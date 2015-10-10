package notebook;

import entry.Entry;

public class Notebook {
	private Entry[] notebook;

	/**
	 * @param text added to the first empty entry
	 */
	public void add(String text) {
		for (int i = 0; i < notebook.length; i++) {
			if (notebook[i] == null) {
				notebook[i] = new Entry(text);
				return;
			}
		}
		throw new IndexOutOfBoundsException("Блокнот заполнен");
	}

	/**
	 * @param index for delete entry from notebook
	 */
	public void delEntry(int index) {
		if (index >= notebook.length || index < 0)
			throw new IndexOutOfBoundsException("Элемент с указанными номером не найден");

		notebook[index] = null;
	}

	/**
	 * @param index for searching entry in notebook
	 * @param text for replace entry in notebook
	 */
	public void Editentry(int index, String text) {
		if (index >= notebook.length || index < 0)
			throw new IndexOutOfBoundsException("Элемент с указанными номером не найден");

		notebook[index] = new Entry(text);
	}

	/**
	 * Display all entries on console
	 */
	public void ConsolePrintInfo() {
		for (int i = 0; i < notebook.length; i++) {
			if (notebook[i] != null)
				System.out.println("[" + i + "]" + " " + notebook[i].getEntry());
		}
		System.out.println();
	}

	/**
	 * Create notebook with default size
	 */
	public Notebook() {
		this(50);
	}

	/**
	 * Create notebook with given size
	 * @param size creating notebook with this size
	 */
	public Notebook(int size) {
		if (size <= 0)
			throw new IllegalArgumentException("Недопустимый размер блокнота");

		notebook = new Entry[size];
	}

}
