package telran.util;

import java.time.Instant;
import java.time.ZoneId;

public class Logger {
	private Level level = Level.INFO;
	private Handler handler;
	private String name;

	public Logger(Handler handler, String name) {
		this.handler = handler;
		this.name = name;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	public void error(String message) {
		publish(message, Level.ERROR);
	}

	public void warning(String message) {
		publish(message, Level.WARNING);
	}

	public void info(String message) {
		publish(message, Level.INFO);
	}

	public void debug(String message) {
		publish(message, Level.DEBUG);
	}

	public void trace(String message) {
		publish(message, Level.TRACE);
	}

	private LoggerRecord getNewLoggerRecord(String message, Level level) {
		return new LoggerRecord(Instant.now(), ZoneId.systemDefault().toString(), level, name, message);
	}

	private void publish(String message, Level level) {
		if (this.level.ordinal() <= level.ordinal()) {
			handler.publish(getNewLoggerRecord(message, level));
		}
	}
}
