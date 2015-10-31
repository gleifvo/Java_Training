package se04.task1;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.IOUtils;

public class Main {

	public static void main(String[] args) throws IOException {

		KeywordsCounter keywordsCounter = new KeywordsCounter();

		BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("Main.java"));

		BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("KeywordsInfo.txt"));

		List<String> list = IOUtils.readLines(bufferedInputStream, "UTF-8");

		IOUtils.write(keywordsCounter.getKeywordsCountMap(list).toString(), bufferedOutputStream);

		bufferedOutputStream.close();

		bufferedInputStream.close();
	}


}
