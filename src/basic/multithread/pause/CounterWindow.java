package basic.multithread.pause;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class CounterWindow {
	private JFrame frame = new JFrame("PauseResume");
	private JButton button = new JButton("Pause");
	private JTextArea textArea = new JTextArea(5, 20);
	private boolean paused = false;
	private Counter counter;
	
	public CounterWindow(Counter counter) {
		this.counter = counter;
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				buttonTapped();
			}
		});
		
		textArea.setLineWrap(true);
		frame.add(button, BorderLayout.NORTH);
		frame.add(textArea, BorderLayout.SOUTH);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	private void buttonTapped() {
		paused = !paused;
		button.setText(paused ? "Resume" : "Pause");
		synchronized (counter) {
			if (!paused) {
				counter.notify();
			}
		}
	}
	
	public void writeCounter() {
		textArea.append(counter.toString());
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
}
