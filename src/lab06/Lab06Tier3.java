package lab06;

import java.util.Scanner;

public class Lab06Tier3 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the phrase to check for palindrome: ");
		String str = input.nextLine();

		checkString(str);
		checkSB(str);
	}

	public static void checkString(String str) {
		String str2 = "";

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) != ' ') {
				str2 += str.charAt(i);
			}
		}

		for (int i = 0; i < str2.length() / 2; i++) {
			if (str2.charAt(i) != str2.charAt(str2.length() - 1 - i)) {
				System.out.println("String method: \"" + str + "\" is NOT a palindrome!");
				return;
			}
		}
		System.out.println("String method: \"" + str + "\" is a palindrome!");
	}

	public static void checkSB(String str) {
		String str2 = "";

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) != ' ') {
				str2 += str.charAt(i);
			}
		}

		StringBuilder original = new StringBuilder(str2);
		StringBuilder reverse = new StringBuilder(str2);
		reverse.reverse();
		for (int i = 0; i < original.length(); i++) {
			if (original.charAt(i) != reverse.charAt(i)) {
				System.out.println("StringBuilder method: \"" + str + "\" is NOT a palindrome!");
				return;
			}
		}
		System.out.println("StringBuilder method: \"" + str + "\" is a palindrome!");
	}
}
