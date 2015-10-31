package se04.task2;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.List;

import org.apache.commons.io.IOUtils;

public class Main {

	public static void main(String[] args) throws IOException {

		KeywordsCounter keywordsCounter = new KeywordsCounter();
		 
		Reader reader = new FileReader("Main.java");
		
		Writer writer = new FileWriter("KeywordsInfo.txt");

		List<String> list = IOUtils.readLines(reader);

		IOUtils.write(keywordsCounter.getKeywordsCountMap(list).toString(), writer);

		reader.close();

		writer.close();
	}


}
