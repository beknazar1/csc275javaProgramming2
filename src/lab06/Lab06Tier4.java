package lab06;

import java.util.Scanner;

public class Lab06Tier4 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the word to check for palindrome: ");
		String str = input.nextLine();
		
		checkString(str);
		checkSB(str);
		
	}

	public static void checkString(String str) {
		for (int i = 0; i < str.length() / 2; i++) {
			if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
				System.out.println("String method: " + str + " is NOT a palindrome!");
				return;
			}
		}
		System.out.println("String method: " + str + " is a palindrome!");
	}

	public static void checkSB(String str) {
		StringBuilder original = new StringBuilder(str);
		StringBuilder reverse = new StringBuilder(str);
		reverse.reverse();
		for (int i = 0; i < original.length(); i++) {
			if (original.charAt(i) != reverse.charAt(i)) {
				System.out.println("StringBuilder method: " + original + " is NOT a palindrome!");
				return;
			}
		}
		System.out.println("StringBuilder method: " + original + " is a palindrome!");
	}

}
