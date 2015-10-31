package se04.task4;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovieCollection implements Serializable {

	private static final long serialVersionUID = 1;

	private Map<String, String> data = new HashMap<String, String>();

	public void addMovie(String nameMovie, String nameActor) {
		data.put(nameMovie, nameActor);
	}

	@Override
	public String toString() {
		return "MovieCollection [Info=" + data + "]";
	}

	public List<String> getList() {
		List<String> list = new ArrayList<String>();

		for (Map.Entry<String, String> entry : data.entrySet()) {
			list.add("Movie : " + entry.getKey() + "\n" + "Actor : " + entry.getValue());
		}

		return list;

	}

}
