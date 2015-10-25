package se03.task1;

import java.text.ParseException;
import java.util.List;

public class Main {

	public static void main(String[] args) throws ParseException {

		CrazyLogger crazyLogger = new CrazyLogger();

		crazyLogger.add("31-01-1995 : 12-00 - 12345678");

		crazyLogger.add("01-02-1995 : 12-05 -  990099");

		showLogs(crazyLogger.searchLogsByTime("31-01-1995 : 12-00"));
		showLogs(crazyLogger.searchLogsByMessage("0"));


	}

	public static void showLogs(List<String> logs) {
		for (String log : logs)
			System.out.println(log);
		System.out.println("");
	}
}
