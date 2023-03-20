package telran.util;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class LoggerRecord {
	Instant timestamp;
	String zoneId;
	Level level;
	String loggerName;
	String message;

	public LoggerRecord(Instant timestamp, String zoneId, Level level, String loggerName, String message) {
		this.timestamp = timestamp;
		this.zoneId = zoneId;
		this.level = level;
		this.loggerName = loggerName;
		this.message = message;
	}

	private static final String PATTERN_FORMAT = "dd.MM.yyyy HH:mm:ss:ms";
	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern(PATTERN_FORMAT)
			.withZone(ZoneId.systemDefault());

	@Override
	public String toString() {
		String msg = String.format("%s %s | Logger: %s | Level: %s | Message: \"%s\"", formatter.format(timestamp),
				zoneId, loggerName, level, message);
		return msg;
	}
}