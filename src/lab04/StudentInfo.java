package lab04;

import java.util.ArrayList;

public class StudentInfo {
	ArrayList<Student> info = new ArrayList<Student>();
	
	public void addStudent(String firstName, String lastName, String major, double gpa, int uin, String netId, int age,
			String gender) {
		this.info.add(new Student(firstName, lastName, major, gpa, uin, netId, age, gender));
	}
	
	public void removeStudent(int index) {
		info.remove(index);
	}
}
