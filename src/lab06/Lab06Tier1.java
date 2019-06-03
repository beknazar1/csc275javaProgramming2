package lab06;

import java.util.Scanner;

public class Lab06Tier1 {
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

	public static void checkString(String str, String in) {
		if (checkStringInner(str)) {
			System.out.println("String method: \"" + in + "\" is a palindrome!");
			return;
		}
		System.out.println("String method: \"" + in + "\" is NOT a palindrome!");
		
		for (int i = 0; i < str.length(); i++) {
			String temp = "";
			String ch = "";
			for (int j = 0; j < str.length(); j++) {
				if (j == i) {
					ch  += str.charAt(j);
					continue;
				}
				temp += str.charAt(j);
			}
			
			if (checkStringInner(temp)) {
				System.out.println("\tDelete character \"" + ch + "\" to make it a palindrome.");
				break;
			}
		}
		
	}
	
	public static boolean checkStringInner(String str) {
		for (int i = 0; i < str.length() / 2; i++) {
			if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
				return false;
			}
		}
		return true;
	}

	public static void checkSB(String str, String in) {
		StringBuilder sb = new StringBuilder(str);
		
		if (checkSBinner(sb)) {
			System.out.println("StringBuilder method: \"" + in + "\" is a palindrome!");
			return;
		}
		System.out.println("StringBuilder method: \"" + in + "\" is NOT a palindrome!");
		
		for (int i = 0; i < sb.length(); i++) {
			StringBuilder temp = new StringBuilder(sb);
			String ch = "" + sb.charAt(i);
			
			if (checkSBinner(temp.deleteCharAt(i))) {
				System.out.println("\tDelete character \"" + ch + "\" to make it a palindrome.");
				break;
			}
		}
	}
	
	public static boolean checkSBinner(StringBuilder original) {
		StringBuilder reverse = new StringBuilder(original);
		reverse.reverse();
		for (int i = 0; i < original.length(); i++) {
			if (original.charAt(i) != reverse.charAt(i)) {
				return false;
			}
		}
		return true;
	}

}
