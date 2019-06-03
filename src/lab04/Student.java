package lab04;

import java.util.ArrayList;

public class Student {
	private String firstName;
	private String lastName;
	private String major;
	private double gpa;
	private int uin;
	private String netId;
	private int age;
	private String gender;
	
	public Student(String firstName, String lastName, String major, double gpa, int uin, String netId, int age,
			String gender) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.major = major;
		this.gpa = gpa;
		this.uin = uin;
		this.netId = netId;
		this.age = age;
		this.gender = gender;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	public int getUin() {
		return uin;
	}

	public void setUin(int uin) {
		this.uin = uin;
	}

	public String getNetId() {
		return netId;
	}

	public void setNetId(String netId) {
		this.netId = netId;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
}
