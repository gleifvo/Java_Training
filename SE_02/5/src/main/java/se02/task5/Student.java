package se02.task5;

import java.util.ArrayList;
import java.util.List;

public class Student implements Cloneable {

	private String name;

	private List<Number> marks = new ArrayList<Number>();

	public Student(String name) {
		this.name = name;
	}

	public Double getAverageMark() {

		Double marksSum = new Double(0);

		for (Number mark : marks)
			marksSum += mark.doubleValue();
		if (marksSum != 0)
			return marksSum / marks.size();
		else
			return 0.0;
	}

	@Override
	protected Student clone() throws CloneNotSupportedException {
		Student student = (Student) super.clone();

		return student;
	}

	public Student(String name, List<Number> marks) {
		this.name = name;
		this.marks = marks;
	}

	public String getName() {
		return name;
	}

	public List<Number> getMarks() {
		return marks;
	}

	public void setMarks(List<Number> marks) {
		this.marks = marks;
	}

	public void setName(String name) {

		this.name = name;
	}

}