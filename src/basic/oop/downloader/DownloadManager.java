package basic.oop.downloader;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import basic.oop.downloader.DownloadProcess.DownloadState;

public class DownloadManager extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static int MAX_CONCURRENT_PROCESS = 3;
	private int downloadingCount = 0;
	private Map<String, DownloadProcess> processes = new HashMap<>();
	private JButton addURL;
	private JTextField search;
	private JPanel bottom;
	private JScrollPane js;
	private JTextArea textArea = new JTextArea(20, 50);
	
	public DownloadManager() {
		js = new JScrollPane(textArea);
		bottom = new JPanel();
		bottom.setLayout(new BorderLayout());
		
		addURL = new JButton("Add URL");
		addURL.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				addDownload(search.getText());
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
	
	public void addDownload(String url) {
		DownloadProcess dp = new DownloadProcess(url);
		processes.put(url, dp);
		
		dp.addDownloadListener(new DownloadListener() {
			@Override
			public void completed() {
				downloadingCount--;
				startNextDownload();
			}

			@Override
			public void changed(String msg) {
				textArea.append(msg + "\n");
			}
		});
		
		if (downloadingCount < MAX_CONCURRENT_PROCESS) {
			downloadingCount++;
			dp.startDownload();
		} else {
			dp.waitDownload();
		}
	}
	
	protected void startNextDownload() {
		for (DownloadProcess dp : processes.values()) {
			if (dp.getPState() == DownloadState.WAITTING) {
				if (downloadingCount < MAX_CONCURRENT_PROCESS) {
					downloadingCount++;
					dp.setState(DownloadState.DOWNLOADING);
					dp.startDownload();
				}
			}
		}
	}

	public void pauseDownload(String url) {
		if (processes.containsKey(url)) {
			DownloadProcess dp = processes.get(url);
			dp.pauseDownload();
		} else {
			System.out.println(url + " not found");
		}
	}
	
	public void resumeDownload(String url) {
		if (processes.containsKey(url)) {
			DownloadProcess dp = processes.get(url);
			dp.resumeDownload();
		} else {
			System.out.println(url + " not found");
		}
	}
	
	public void removeDownload(String url) {
		if (processes.containsKey(url)) {
			processes.remove(url);
		} else {
			System.out.println(url + " not found");
		}
	}
	
	public static void main(String[] args) throws InterruptedException, ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
//		DownloadManager dm = new DownloadManager();
//		dm.addDownload("123");
//		dm.addDownload("456");
//		dm.addDownload("789");
//		dm.addDownload("abc");
//		dm.addDownload("def");
		
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				DownloadManager dlm = new DownloadManager();
				dlm.setSize(300, 100);
				dlm.pack();
			}
		});
	}
}
