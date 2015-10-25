package se03.task2;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class ConsoleInterface {

	private Locale[] locales = { new Locale("en", "US"), new Locale("ru", "RU") };

	private ResourceBundle interfaceBundle = ResourceBundle.getBundle("BundleInterface", locales[0]);

	private ResourceBundle questionsBundle = ResourceBundle.getBundle("BundleQuestions", locales[0]);

	public void Start() {

		String temp;

		while (true) {
			Scanner scannerInput = new Scanner(System.in);

			showHelp();

			temp = scannerInput.nextLine();

			System.out.println("_________________________________________________");

			switch (temp) {
			case "EN": {
				changeLanguage(temp);
				break;
			}
			case "RU": {
				changeLanguage(temp);
				break;
			}
			case "showQ": {
				showQuestions();
				System.out.println("_________________________________________________");
				break;
			}
			}
			if (temp.contains("showA")) {

				String[] parts = temp.split(" - ");

				if (parts.length > 1)
					showAnswer(parts[1]);
			}

		}
	}

	public void showHelp() {
		System.out.println(interfaceBundle.getString("helpCommand"));
	}

	public void showAnswer(String number) {

		int index = Integer.parseInt(number) - 1;
		System.out.println("");
		System.out.println(questionsBundle.getString("a" + index));
		System.out.println("_________________________________________________");
	}

	public void changeLanguage(String language) {
		switch (language) {
		case "EN": {
			interfaceBundle = ResourceBundle.getBundle("BundleInterface", locales[0]);

			questionsBundle = ResourceBundle.getBundle("BundleQuestions", locales[0]);
			break;
		}
		case "RU": {
			interfaceBundle = ResourceBundle.getBundle("BundleInterface", locales[1]);

			questionsBundle = ResourceBundle.getBundle("BundleQuestions", locales[1]);
			break;
		}
		}
	}

	public void showQuestions() {
		System.out.println("");
		for (int i = 0; i < 3; i++)
			System.out.format("[%d] %s\n", i + 1, questionsBundle.getString("q" + i));
	}

}
