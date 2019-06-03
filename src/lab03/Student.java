package lab03;

public class Student {
	private String[][] students;
	
	public Student() {
		students = new String[10][8];
	}
	
	public void add(int index, String firstName, String lastName, String major, String gpa, String uin, String netId, String age, String gender) {
		if (index < 0 || index > 7) {
			System.out.println("No such index");
			return;
		}
		
		this.students[index][0] = firstName;
		this.students[index][1] = lastName;
		this.students[index][2] = major;
		this.students[index][3] = gpa;
		this.students[index][4] = uin;
		this.students[index][5] = netId;
		this.students[index][6] = age;
		this.students[index][7] = gender;
	}
	
	public void remove(int index) {
		if (index < 0 || index > 7) {
			System.out.println("No such index");
			return;
		}
		this.students[index][0] = null;
		this.students[index][1] = null;
		this.students[index][2] = null;
		this.students[index][3] = null;
		this.students[index][4] = null;
		this.students[index][5] = null;
		this.students[index][6] = null;
		this.students[index][7] = null;
	}
	
	public void print(int index) {
		for (int i = 0; i < 8; i++) {
			System.out.print(students[index][i] + ", ");
		}
		System.out.println();
	}
}
