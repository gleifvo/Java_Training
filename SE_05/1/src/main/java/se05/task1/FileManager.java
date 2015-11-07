package se05.task1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class FileManager {

	private Path path = Paths.get("C:/");

	public void setPath(Path path) {

		try {
			if (!Files.exists(path)) {
				throw new FileNotFoundException("Path not found");
			}
			this.path = path;
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	public String getPath() {
		return path.toString();
	}

	public List<String> getFileNames() {
		List<String> filesNames = new ArrayList<String>();

		try (DirectoryStream<Path> stream = Files.newDirectoryStream(path)) {

			for (Path file : stream) {
				filesNames.add(file.getFileName().toString());
			}
		} catch (IOException | DirectoryIteratorException e) {
			System.out.println(e.getMessage() + " - Is not directory");
		}
		return filesNames;

	}

	public void append(String data) {
		try {
			File file = new File(path.toString());
			FileUtils.writeStringToFile(file, data + "\n", true);
		} 
		 catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}

	public void createTextFile(String name) {

		PrintWriter writer;
		try {

			Path filePath = Paths.get(this.path + "/" + name + ".txt");

			if (!Files.isDirectory(path)) {
				throw new FileNotFoundException(path + " - It is not directory");
			}

			if (Files.exists(filePath)) {
				throw new FileAlreadyExistsException(filePath + " - Already exists");
			}
			writer = new PrintWriter(filePath.toString(), "UTF-8");
			writer.close();

		} catch (UnsupportedEncodingException e) {
			System.out.println(e.getMessage());
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (FileAlreadyExistsException e) {
			System.out.println(e.getMessage());
		}
	}

	public void deleteFile() {
		try {
			Files.delete(path);
		} catch (NoSuchFileException x) {
			System.out.format("%s: no such" + " file or directory%n", path);
		} catch (DirectoryNotEmptyException x) {
			System.out.format("%s not empty%n", path);
		} catch (IOException x) {
			System.out.println(x);
		}
	}
}
