package basic.multithread.downloadmrg;

import java.util.Random;

public class DownloadFile {
	private String url;
	private int totalSize;
	private int downloadedSize;
	private Random rand = new Random();
	
	public DownloadFile(String url) {
		this.setUrl(url);
		this.setTotalSize(50 + rand.nextInt(100 - 50)); //random 50 -> 100
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getTotalSize() {
		return totalSize;
	}

	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}

	public int getDownloadedSize() {
		return downloadedSize;
	}

	public void setDownloadedSize(int downloadedSize) {
		this.downloadedSize = downloadedSize;
	}

	public void increaseDownloadedSize() {
		downloadedSize++;
	}
}
