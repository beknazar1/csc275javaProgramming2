package lab05;

import java.util.Scanner;

public class Lab05 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter a number from 1 to 26: ");
		int num = input.nextInt();
		input.nextLine();
		
		System.out.println("Enter a phrase: ");
		String str = input.nextLine().toUpperCase();
		
		String res = "";
		
		for (int i = 0; i < str.length(); i++) {
			char a = (char) (str.charAt(i)+num);
			if (a>90) {
				a = (char) (a-26);
			}
			res = res + a;
		}
		System.out.println("\nThe result is " + res);
		
	}
}
