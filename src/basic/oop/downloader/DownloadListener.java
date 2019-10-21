package basic.oop.downloader;

public interface DownloadListener {
	void completed();
	void changed(String msg);
}
