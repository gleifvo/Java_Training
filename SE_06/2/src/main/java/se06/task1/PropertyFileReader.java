package se06.task1;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Properties;

public class PropertyFileReader {

	private Properties properties = new Properties();

	private Map<String,String> propertiesMap = new HashMap<String,String>();
	
	public void readFile(String fileName) {
		try (BufferedInputStream bufferedInputStream = new BufferedInputStream(
				new FileInputStream(new File(".\\src\\main\\resources\\" + fileName + ".properties")))) {

			properties.load(bufferedInputStream);
			propertiesMap = (Map<String, String>) properties.clone();

		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e1) {
			System.out.println(e1.getMessage());
		}
	}

	@Override
	public String toString() {
		return "PropertyFileReader [propertiesMap=" + propertiesMap + "]";
	}

	public String getValue(String key) {

		try {
			String value = propertiesMap.get(key);
			if (value == null) {
				throw new IllegalArgumentException(key + " - Key not found");
			}
			return value;
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			return null;
		}
	}
}
