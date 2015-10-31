package se04.task3;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import org.apache.commons.io.IOUtils;

public class Main {

	public static void main(String[] args) throws IOException {

		OutputStream output = new FileOutputStream("FileWithUTF-8.txt");

		IOUtils.write("Текст на кириллице", output, "UTF-8");

		output.close();

		InputStream input = new FileInputStream("FileWithUTF-8.txt");

		List<String> list = IOUtils.readLines(input, "UTF-8");

		input.close();

		output = new FileOutputStream("FileWithUTF-16.txt");
		
		IOUtils.writeLines(list,"", output, "UTF-16");
		
		output.close();

	}

}
