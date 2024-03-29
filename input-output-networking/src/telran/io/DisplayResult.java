package telran.io;

public class DisplayResult {
	protected long fileSize;
	protected long copyTime;

	public DisplayResult(long fileSize, long copyTime) {
		this.fileSize = fileSize;
		this.copyTime = copyTime;
	}

	@Override
	public String toString() {
		return String.format("filesize: %d copytime: %d; ", fileSize, copyTime);

	}
}