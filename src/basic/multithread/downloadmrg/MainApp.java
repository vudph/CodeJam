package basic.multithread.downloadmrg;

public class MainApp {

	public static void main(String[] args) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				DownloadManagerWindow dlm = new DownloadManagerWindow();
				dlm.setSize(300, 100);
				dlm.pack();
			}
		});
	}

}
