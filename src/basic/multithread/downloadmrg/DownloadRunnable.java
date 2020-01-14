package basic.multithread.downloadmrg;

public class DownloadRunnable implements Runnable {
	private DownloadWindow downloadWindow;
	private DownloadFile downloadFile;
	private DownloadListener downloadListener;
	private DownloadState downloadState = DownloadState.WAITTING;
	
	public DownloadRunnable(DownloadWindow dw, DownloadFile df) {
		this.downloadWindow = dw;
		this.downloadFile = df;
	}

	@Override
	public void run() {
		for (int i = 0; i < downloadFile.getTotalSize(); i++) {
			allowPause();
			downloadFile.increaseDownloadedSize();
			downloadWindow.logProgress();
			sleep();
		}
		done();
	}
	
	private void allowPause() {
		synchronized (downloadFile) {
			if (downloadWindow.isPaused()) {
				try {
					downloadFile.wait();
				} catch (InterruptedException e) {
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
	
	public void setDownloadListener(DownloadListener listener) {
		downloadListener = listener;
	}

	public void startDownload() {
		setDownloadState(DownloadState.DOWNLOADING);
		downloadWindow.getButton().setEnabled(true);
		downloadWindow.getButton().setText("Pause");
		new Thread(this).start();
	}
	
	public void waitDownload() {
		downloadWindow.getButton().setEnabled(false);
		downloadWindow.getButton().setText("Wait");
	}
	
	private void done() {
		downloadListener.completed();
		setDownloadState(DownloadState.DONE);
		downloadWindow.getButton().setText("Done");
		downloadWindow.getButton().setEnabled(false);
	}
	
	public DownloadState getDownloadState() {
		return downloadState;
	}

	public void setDownloadState(DownloadState downloadState) {
		this.downloadState = downloadState;
	}

	public DownloadFile getDownloadFile() {
		return downloadFile;
	}

	public void setDownloadFile(DownloadFile downloadFile) {
		this.downloadFile = downloadFile;
	}

	enum DownloadState {
		DOWNLOADING, DONE, PAUSE, ERROR, CANCEL, WAITTING;
	}

}

