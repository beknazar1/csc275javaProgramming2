package lab06;

import java.util.Scanner;

public class Lab06Tier2 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the phrase to check for palindrome: ");
		String str = input.nextLine();
		
		String str2 = "";

		for (int i = 0; i < str.length(); i++) {
			if (Character.isLetter(str.charAt(i))) {
				str2 += str.charAt(i);
			}
		}
		
		str2 = str2.toLowerCase();
		
		checkString(str2, str);
		checkSB(str2, str);
	}

	public static void checkString(String str , String in) {
		for (int i = 0; i < str.length() / 2; i++) {
			if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
				System.out.println("String method: \"" + in + "\" is NOT a palindrome!");
				return;
			}
		}
		System.out.println("String method: \"" + in + "\" is a palindrome!");
	}

	public static void checkSB(String str, String in) {
		StringBuilder original = new StringBuilder(str);
		StringBuilder reverse = new StringBuilder(str);
		reverse.reverse();
		for (int i = 0; i < original.length(); i++) {
			if (original.charAt(i) != reverse.charAt(i)) {
				System.out.println("StringBuilder method: \"" + in + "\" is NOT a palindrome!");
				return;
			}
		}
		System.out.println("StringBuilder method: \"" + in + "\" is a palindrome!");
	}
}
