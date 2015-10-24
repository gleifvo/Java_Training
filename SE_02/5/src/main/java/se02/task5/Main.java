package se02.task5;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, CloneNotSupportedException {

		List<StudentGroup> studentsGroups = new ArrayList<StudentGroup>();
		

		studentsGroups.add(new StudentGroup(Discipline.Physics));

		studentsGroups.add(new StudentGroup(Discipline.Mathematics));

		studentsGroups.add(new StudentGroup(Discipline.Russian));
		

		studentsGroups.get(0).addStudent("Иван");
		
		studentsGroups.get(1).addStudent("Иван");
		
		studentsGroups.get(2).addStudent("Иван");
		
		
		studentsGroups.get(0).addMark("Иван", new Double(10));
		studentsGroups.get(0).addMark("Иван", new Double(9));
		
		studentsGroups.get(1).addMark("Иван", new Double(3));
		studentsGroups.get(1).addMark("Иван", new Double(2));
		
		studentsGroups.get(2).addMark("Иван", new Integer(8));
		studentsGroups.get(2).addMark("Иван", new Integer(6));


		System.out.println(StudentGroup.findGroupWithBestMarks(studentsGroups, "Иван"));
	


	}
}
