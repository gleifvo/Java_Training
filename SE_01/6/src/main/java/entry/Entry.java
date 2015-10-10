package entry;

public class Entry {
	private String entry;

	/**
	 * @return current entry 
	 */
	public String getEntry() {
		return entry;
	}

	
	/**
	 * @param text recording in current entry
	 */
	public Entry(String text) {
		entry = text;
	}

	public Entry() {
	}
}
