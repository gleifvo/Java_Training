package se03.task1;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class CrazyLogger {

	private StringBuilder data = new StringBuilder();

	private Pattern logFormat = Pattern.compile(
			"(0?[1-9]|[12][0-9]|3[01])-(0?[1-9]|1[012])-((19|20)\\d\\d) : ([0-9]|0[0-9]|1[0-9]|2[0-3])-[0-5][0-9] - [^\n]*");

	private Pattern dateFormat = Pattern.compile(
			"(0?[1-9]|[12][0-9]|3[01])-(0?[1-9]|1[012])-((19|20)\\d\\d) : ([0-9]|0[0-9]|1[0-9]|2[0-3])-[0-5][0-9]");

	public void add(String message) {
		if (logFormat.matcher(message).matches())
			data.append(message + "\n");
	}

	public void showLogs() {

		System.out.println(data);
	}

	public List<String> searchLogsByTime(String message) throws ParseException {

		List<String> necessaryLogs = new ArrayList<String>();

		if (dateFormat.matcher(message).matches()) {

			String[] Logs = data.toString().split("\n");

			for (String log : Logs) {
				String[] logParts = log.split(" - ");

				String logDate = logParts[0];

				if (logDate.equals(message))
					necessaryLogs.add(log);
			}

		}
		return necessaryLogs;
	}

	public List<String> searchLogsByMessage(String message) throws ParseException {

		List<String> necessaryLogs = new ArrayList<String>();

		String[] Logs = data.toString().split("\n");

		for (String log : Logs) {
			String[] logParts = log.split(" - ");

			String logMessage = logParts[1];

			if (logMessage.contains(message))
				necessaryLogs.add(log);

		}
		return necessaryLogs;
	}
}
