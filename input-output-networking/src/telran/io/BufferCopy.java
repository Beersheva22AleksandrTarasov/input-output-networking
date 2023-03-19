package telran.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class BufferCopy extends Copy {
	private long bufferSize;

	public BufferCopy(String srcFilePath, String destFilePath, boolean overwrite, long bufferSize) {
		super(srcFilePath, destFilePath, overwrite);
		this.bufferSize = bufferSize;
	}

	@Override
	public long copy() {
		long result = 0L;
		try (InputStream inputStream = new FileInputStream(srcFilePath);
				OutputStream outputStream = new FileOutputStream(destFilePath)) {
			byte[] buffer = new byte[(int) bufferSize];
			int length = inputStream.read(buffer);
			while (length > 0) {
				outputStream.write(buffer);
				result += length;
				length = inputStream.read(buffer);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;

	}

	public DisplayResultBuffer getDisplayResult(long fileSize, long copyTime) {
		return new DisplayResultBuffer(fileSize, copyTime, bufferSize);
	}

}
