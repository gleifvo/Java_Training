package se02.task5;

import java.util.ArrayList;
import java.util.List;

public class StudentGroup {

	private Class<? extends Number> marksType;

	private ArrayList<Student> studentsList = new ArrayList<Student>();

	private String dicsipline;

	public String getDicsipline() {
		return dicsipline;
	}

	public Student getStudentByName(String name) throws CloneNotSupportedException {

		for (Student student : studentsList)
			if (student.getName().equals(name))
				return student.clone();

		return null;

	}

	public Student getStudentByNumber(int index) throws CloneNotSupportedException {

		if (studentsList.size() > index)
			return studentsList.get(index).clone();

		return null;

	}

	public void addMark(String studentName, Number mark) {
		for (Student student : studentsList) {
			if (student.getName().equals(studentName)) {
				if (mark.getClass().equals(marksType))
					student.getMarks().add(mark);
				else
					throw new ClassCastException();
			}
		}
	}

	public StudentGroup(Discipline dicsipline) {

		this.dicsipline = dicsipline.toString();

		marksType = dicsipline.dicsiplineType;
	}

	public void addStudent(String name) {
		if (checkStudentName(name))
			studentsList.add(new Student(name));
	}

	public void addStudent(String name, List<Number> marks) {
		if (checkMarks(marks)) {
			if (checkStudentName(name))
				studentsList.add(new Student(name, marks));

		} else
			throw new ClassCastException();

	}

	private boolean checkMarks(List<Number> marks) {
		for (Number mark : marks)
			if (!(mark.getClass().equals(marksType)))
				return false;

		return true;

	}

	private boolean checkStudentName(String name) {
		for (Student student : studentsList)
			if (student.getName().equals(name))
				return false;

		return true;

	}

	static public String findGroupWithBestMarks(List<StudentGroup> groupsList, String name)
			throws CloneNotSupportedException {

		String discipline = null;

		Double bestMark = new Double(0);

		for (StudentGroup group : groupsList) {

			Student student = group.getStudentByName(name);

			if (student != null) {

				if (discipline == null) {

					discipline = group.getDicsipline();

					bestMark = student.getAverageMark();

				} else {

					int result = student.getAverageMark().compareTo(bestMark);

					if (result > 0) {

						discipline = group.getDicsipline();

						bestMark = student.getAverageMark();
					}
				}
			}

		}
		if (discipline != null)
			return discipline + " - " + bestMark;

		return null;
	}
}
}
