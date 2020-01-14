package basic.multithread.downloadmrg;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class DownloadWindow extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -751480596015086130L;
	private JButton button = new JButton("Pause");
	private JTextArea textArea = new JTextArea(5, 20);
	private boolean paused = false;
	private DownloadFile downloadFile;
	private DownloadListener downloadListener;
	
	public DownloadWindow(DownloadFile downloadFile) {
		this.downloadFile = downloadFile;
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				buttonTapped();
			}
		});
		
		textArea.setLineWrap(true);
		this.setTitle(downloadFile.getUrl());
		this.add(button, BorderLayout.NORTH);
		this.add(textArea, BorderLayout.SOUTH);
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	private void buttonTapped() {
		paused = !paused;
		button.setText(paused ? "Resume" : "Pause");
		if (paused) 
			downloadListener.paused();
		else 
			downloadListener.resumed();
		synchronized (downloadFile) {
			if (!paused) {
				downloadFile.notify();
			}
		}
	}
	
	public void logProgress() {
		textArea.append(Integer.toString(downloadFile.getDownloadedSize()));
	}
	
	public boolean isPaused() {
		return paused;
	}

	public void setPaused(boolean paused) {
		this.paused = paused;
	}

	public JButton getButton() {
		return button;
	}

	public void setDownloadListner(DownloadListener dl) {
		downloadListener = dl;
	}
}
