package telran.util;

import java.io.PrintStream;

public class SimpleStreamHandler implements Handler {
	private PrintStream stream;

	@Override
	public void publish(LoggerRecord loggerRecord) {

		stream.println(loggerRecord);
	}

	public SimpleStreamHandler(PrintStream stream) {
		this.stream = stream;
	}
}