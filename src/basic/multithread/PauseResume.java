package basic.multithread;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class PauseResume {
	private JFrame frame = new JFrame("PauseResume");
	private JButton button = new JButton("Pause");
	private JTextArea textArea = new JTextArea(5, 20);

	private Object lock = new Object();
	private volatile boolean paused = false;

	public static void main(String[] args) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				new PauseResume();
			}
		});
	}

	public PauseResume() {
		counter.start();
		button.addActionListener(pauseResume);

		textArea.setLineWrap(true);
		frame.add(button, java.awt.BorderLayout.NORTH);
		frame.add(textArea, java.awt.BorderLayout.SOUTH);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	private Thread counter = new Thread(new Runnable() {
		@Override
		public void run() {
//			while (true) {
				work();
//			}
		}
	});

	private void work() {
		for (int i = 0; i < 50; i++) {
			allowPause();
			write(Integer.toString(i));
			sleep();
		}
		done();
	}

	private void allowPause() {
		synchronized (lock) {
			if (paused) {
				try {
					lock.wait();
					System.out.println("got notified, paused: " + paused);
				} catch (InterruptedException e) {
					// nothing
				}
			}
		}
	}

	private java.awt.event.ActionListener pauseResume = new java.awt.event.ActionListener() {
		@Override
		public void actionPerformed(java.awt.event.ActionEvent e) {
			paused = !paused;
			button.setText(paused ? "Resume" : "Pause");
			synchronized (lock) {
				lock.notifyAll();
			}
		}
	};

	private void sleep() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// nothing
		}
	}

	private void done() {
		button.setText("Start");
		paused = true;
	}

	public void write(String str) {
		textArea.append(str);
	}
}
