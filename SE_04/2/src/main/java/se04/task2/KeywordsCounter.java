package se04.task2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.axis2.util.JavaUtils;

public class KeywordsCounter {

	private void addKeyword(String word, Map<String, Integer> keywordsMap) {
		if (!keywordsMap.containsKey(word)) {
			keywordsMap.put(word, 1);
		} else {
			keywordsMap.put(word, keywordsMap.get(word) + 1);
		}
	}

	public Map<String, Integer> getKeywordsCountMap(List<String> list) {

		Map<String, Integer> keywordsMap = new HashMap<String, Integer>();

		for (String element : list) {

			element = element.replaceAll("\\p{Punct}|\\p{Space}", " ");

			String[] substrings = element.split(" ");

			for (String string : substrings) {
				if (JavaUtils.isJavaKeyword(string)) {
					addKeyword(string, keywordsMap);
				}
			}
		}
		return keywordsMap;

	}
}
