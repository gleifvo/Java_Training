package se04.task4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException, ClassNotFoundException {

		MovieCollection movieCollection = new MovieCollection();

		while (true) {

			help();

			Scanner input = new Scanner(System.in);

			String command = input.nextLine();

			switch (command) {

			case "Show": {
				printInfo(movieCollection.getList());
				break;
			}
			case "Add": {
				System.out.println("Enter movie name");
				String nameMovie = input.nextLine();

				System.out.println("Enter main actor name");
				String nameActor = input.nextLine();

				movieCollection.addMovie(nameMovie, nameActor);
				break;
			}
			case "Save": {
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("temp.out"));
				objectOutputStream.writeObject(movieCollection);
				objectOutputStream.close();
				break;
			}

			case "Read": {

				BufferedReader bufferedReader = new BufferedReader(new FileReader("temp.out"));

				if (bufferedReader.readLine() != null) {

					ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("temp.out"));

					movieCollection = (MovieCollection) objectInputStream.readObject();

					objectInputStream.close();
				} else {
					System.out.println("File is empty");
				}
				bufferedReader.close();
				break;
			}

			}
			if (command.equals("Exit")) {
				break;
			}
		}

	}

	public static void printInfo(List<String> list) {
		for (String element : list) {
			System.out.println("_________________________________");
			System.out.println(element);
			System.out.println("_________________________________");
		}
	}

	public static void help() {
		System.out.println("_________________________________");
		System.out.println("Enter *Show* to view movies list");
		System.out.println("Enter *Add* for add movie");
		System.out.println("Enter *Exit* for exit application");
		System.out.println("Enter *Read* to read state");
		System.out.println("Enter *Save* to save state");
		System.out.println("_________________________________");
	}
}
