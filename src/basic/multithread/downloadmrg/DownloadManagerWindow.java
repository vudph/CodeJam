package basic.multithread.downloadmrg;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.atomic.AtomicInteger;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class DownloadManagerWindow extends JFrame {
	private static final long serialVersionUID = -238954172002868027L;
	private static int MAX_CONCURRENT_PROCESS = 3;
	private JButton addURL;
	private JTextField search;
	private JPanel bottom;
	private JScrollPane js;
	private JTextArea textArea = new JTextArea(20, 50);
	private Queue<DownloadRunnable> downloadQueue = new ConcurrentLinkedDeque<>();
	private AtomicInteger downloadingCount = new AtomicInteger(0);
	
	public DownloadManagerWindow() {
		js = new JScrollPane(textArea);
		bottom = new JPanel();
		bottom.setLayout(new BorderLayout());
		
		addURL = new JButton("Add URL");
		addURL.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				addUrlTapped();
			}
		});
		search = new JTextField();
		
		bottom.add(addURL, BorderLayout.WEST);
		bottom.add(search, BorderLayout.CENTER);
		add(bottom, BorderLayout.SOUTH);
		add(js, BorderLayout.NORTH);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	protected void addUrlTapped() {
		DownloadFile df = new DownloadFile(search.getText());
		DownloadWindow dw = new DownloadWindow(df);
		DownloadRunnable dr = new DownloadRunnable(dw, df);
		DownloadListener dl = new DownloadListener() {
			
			@Override
			public void completed() {
				textArea.append("COMPLETE: " + dr.getDownloadFile().getUrl() + "\n");
				downloadingCount.decrementAndGet();
				startNewDownload();
			}

			@Override
			public void paused() {
				textArea.append("PAUSE: " + dr.getDownloadFile().getUrl() + "\n");
			}

			@Override
			public void resumed() {
				textArea.append("RESUME: " + dr.getDownloadFile().getUrl() + "\n");
			}
		};
		dr.setDownloadListener(dl);
		dw.setDownloadListner(dl);
		System.out.println("count: " + downloadingCount.get());
		if (downloadingCount.get() < MAX_CONCURRENT_PROCESS) {
			downloadingCount.incrementAndGet();
			dr.startDownload();
		} else {
			dr.waitDownload();
			downloadQueue.add(dr);
		}
	}

	protected void startNewDownload() {
		if (!downloadQueue.isEmpty()) {
			DownloadRunnable dr = downloadQueue.poll();
			dr.startDownload();
			downloadingCount.incrementAndGet();
		}
	}
}
