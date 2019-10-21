package basic.oop.downloader;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class DownloadProcess extends JFrame implements Runnable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JButton button = new JButton("Pause");
	private JTextArea textArea = new JTextArea(5, 20);
	
	private DownloadState pstate;
	private String url;
	private DownloadListener downloadListener;
	private Object lock = new Object();
	private volatile boolean paused = false;

	public DownloadProcess(String url) {
		this.url = url;
		this.pstate = DownloadState.WAITTING;
		
		this.setTitle(url);
		button.addActionListener(pauseResume);
		textArea.setLineWrap(true);
		this.add(button, BorderLayout.NORTH);
		this.add(textArea, BorderLayout.SOUTH);
		this.pack();
		this.setVisible(true);
	}

	public void addDownloadListener(DownloadListener dl) {
		downloadListener = dl;
	}

	@Override
	public void run() {
		work();
	}
	
	private void work() {
		allowPause();
		for (int i = 0; i < 50; i++) {
			allowPause();
			textArea.append(Integer.toString(i) + ",");
			sleep();
		}
		completeDownload();
	}

	private void allowPause() {
		synchronized (lock) {
			while (paused) {
				try {
					lock.wait();
				} catch (InterruptedException e) {
					// nothing
				}
			}
		}
	}

	private void sleep() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// nothing
		}
	}
	
	public void startDownload() {
		pstate = DownloadState.DOWNLOADING;
		downloadListener.changed(url + ": DOWNLOADING");
		button.setEnabled(true);
		button.setText("Pause");
		new Thread(this).start();
	}

	enum DownloadState {
		DOWNLOADING, COMPLETE, PAUSE, ERROR, CANCEL, WAITTING;
	}

	public void waitDownload() {
		pstate = DownloadState.WAITTING;
		downloadListener.changed(url + ": WAITING");
		button.setEnabled(false);
		button.setText("Wait");
	}

	public void completeDownload() {
		pstate = DownloadState.COMPLETE;
		downloadListener.completed();
		paused = true;
		downloadListener.changed(url + ": DOWNLOADED");
		
		button.setText("DONE");
		button.setEnabled(false);
	}

	public DownloadState getPState() {
		return pstate;
	}

	public void setState(DownloadState state) {
		this.pstate = state;
	}

	public void pauseDownload() {
		pstate = DownloadState.PAUSE;
		downloadListener.changed(url + ": PAUSED");
		paused = !paused;
		synchronized (lock) {
			lock.notifyAll();
		}
	}

	public void resumeDownload() {
		pstate = DownloadState.DOWNLOADING;
		downloadListener.changed(url + ": RESUMED");
		paused = !paused;
		synchronized (lock) {
			lock.notifyAll();
		}
	}
	
	private java.awt.event.ActionListener pauseResume = new java.awt.event.ActionListener() {
		@Override
		public void actionPerformed(java.awt.event.ActionEvent e) {
			if (!paused)
				pauseDownload();
			else 
				resumeDownload();
			button.setText(paused ? "Resume" : "Pause");
		}
	};

}
