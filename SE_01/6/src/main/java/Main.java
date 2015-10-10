import notebook.Notebook;

public class Main {

	public static void main(String[] args) {
		try {
			Notebook notebook = new Notebook(4);
			
			notebook.add("first entry");
			notebook.add("1");
			notebook.add("2");
			notebook.add("3");
			
			notebook.ConsolePrintInfo();
			
			notebook.delEntry(1);
			notebook.delEntry(2);
			notebook.Editentry(3, "edit");

			notebook.ConsolePrintInfo();
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

}
