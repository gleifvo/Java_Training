package se05.task1;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class ConsoleInterface {
	private FileManager fileManager = new FileManager();

	public void start() {

		Scanner input = new Scanner(System.in);

		showCurrentPath();
		help();

		while (true) {

			String command = input.nextLine();

			switch (command) {

			case "show": {
				printList((fileManager.getFileNames()));
				break;

			}
			case "cd": {
				System.out.println("Input new directory");
				command = input.nextLine();
				Path newPath = Paths.get(fileManager.getPath() + "/" + command);
				changeDirectory(newPath);
				showCurrentPath();
				break;
			}
			case "crd": {
				System.out.println("Input new root directory");
				printAvailableDirectory();
				command = input.nextLine();
				Path newPath = Paths.get(command);
				changeDirectory(newPath);
				showCurrentPath();
				break;
			}
			case "ctf": {
				System.out.println("Input file name");
				command = input.nextLine();
				fileManager.createTextFile(command);
				break;
			}
			case "help": {
				help();
				break;
			}
			case "exit": {
				input.close();
				return;
			}
			case "append": {
				showCurrentPath();
				System.out.println("Input text for appending in file");
				command = input.nextLine();
				fileManager.append(command);
				break;

			}
			case "del": {
				showCurrentPath();
				System.out.println("Delete it?(Input *Y* or *N*)");
				command = input.nextLine();
				if (command.equals("Y")) {
					fileManager.deleteFile();
				}
				break;

			}
			default: {
				System.out.println("Unknown command");
				break;
			}
			}
		}

	}

	public static void help() {
		System.out.println("Input *cd* to change current directory");
		System.out.println("Input *crd* to change root directory");
		System.out.println("Input *show* to view files in current directory");
		System.out.println("Input *append* for append text in current file");
		System.out.println("Input *ctf* for creating new  text file in current directory");
		System.out.println("Input *del* for delete current file or empty directory");
		System.out.println("Input *exit* to exit from application");
	}

	private void showCurrentPath() {
		System.out.format("Current path  - %s \n", fileManager.getPath());
	}

	private void printList(List<String> list) {
		for (String fileName : list) {
			System.out.println(fileName);
		}
	}

	private void changeDirectory(Path path) {
		fileManager.setPath(path);
	}

	private void printAvailableDirectory() {
		StringBuilder dir = new StringBuilder();

		Iterable<Path> dirs = FileSystems.getDefault().getRootDirectories();
		for (Path name : dirs) {
			dir.append(name + " ");
		}

		System.out.println(dir);
	}

}
