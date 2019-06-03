import java.util.Scanner;

public class Lab02 {
	public String[][] arr;
	
	public Lab02(){
		arr = new String[10][4];
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = "";
			}
		}
	}
	
	public static void main(String[] args) {
		Lab02 contacts = new Lab02();
		
		contacts.add(0, "Bekn", "Zhum", "312445887", "20");
		contacts.view(0);
		
		contacts.delete(0);
	}
	
	
	public void view(int contact) {
		if (contact < 0 || contact > 9) {
			return;
		}
		
		System.out.println("First Name is " + arr[contact][0]);
		System.out.println("Last Name is " + arr[contact][1]);
		System.out.println("Phone Number is " + arr[contact][2]);
		System.out.println("Age is " + arr[contact][3]);
	}
		
	public void add(int contact, String firstName, String lastName, String phoneNumber, String age) {
		if (contact < 0 || contact > 9) {
			return;
		}
		
		arr[contact][0] = firstName;
		arr[contact][1] = lastName;
		arr[contact][2] = phoneNumber;
		arr[contact][3] = age;
	}
	
	public void delete(int contact) {
		if (contact < 0 || contact > 9) {
			return;
		}
		
		arr[contact][0] = "";
		arr[contact][1] = "";
		arr[contact][2] = "";
		arr[contact][3] = "";
		System.out.println("Contact deleted");
	}
}
