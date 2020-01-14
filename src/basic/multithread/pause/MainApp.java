package basic.multithread.pause;

public class MainApp {

	public static void main(String[] args) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				Counter c = new Counter();
				CounterWindow cw = new CounterWindow(c);
				CounterThread ct = new CounterThread(cw, c);
				Thread t = new Thread(ct);
				t.start();
			}
		});
	}

}
