package basic.multithread.downloadmrg;

public interface DownloadListener {
	void completed();
	void paused();
	void resumed();
}
