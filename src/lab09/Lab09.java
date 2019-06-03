package lab09;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class Lab09 {
	public static void main(String[] args) throws IOException {
		 Scanner input = new Scanner(System.in);
		
		System.out.println("Would you like to load a previous file?");
		String choice = input.nextLine();
		
		switch(choice) {
		case "yes":
			if(new File("qa.txt").isFile()) {
				printQA();
			break;
			} 
		case "no": 
			askQuestions();
		}
		
		
		input.close();
	}
	
	public static void askQuestions() throws IOException {
		Scanner in = new Scanner(System.in);
		String answer;
		
		String question1 = "Who are you?";
		String question2 = "What are you passionate about?";
		String question3 = "What are the achievements you are most proud of?";
		String question4 = "What are you most grateful for in life?";
		String question5 = "What are the most important things to you in life?";
		String question6 = "How would you describe yourself?";
		String question7 = "What are your values?";
		String question8 = "Do you love yourself?";
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter("qa.txt"))) {
			
			
			System.out.println(question1);
			answer = in.nextLine();
			bw.write(question1 + " " + answer);
			bw.newLine();
			
			System.out.println(question2);
			answer = in.nextLine();
			bw.write(question2 + " " + answer);
			bw.newLine();
			
			System.out.println(question3);
			answer = in.nextLine();
			bw.write(question3 + " " + answer);
			bw.newLine();
			
			System.out.println(question4);
			answer = in.nextLine();
			bw.write(question4 + " " + answer);
			bw.newLine();
			
			System.out.println(question5);
			answer = in.nextLine();
			bw.write(question5 + " " + answer);
			bw.newLine();
			
			System.out.println(question6);
			answer = in.nextLine();
			bw.write(question6 + " " + answer);
			bw.newLine();
			
			System.out.println(question7);
			answer = in.nextLine();
			bw.write(question7 + " " + answer);
			bw.newLine();
			
			System.out.println(question8);
			answer = in.nextLine();
			bw.write(question8 + " " + answer);
			bw.newLine();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		in.close();
	}
	
	public static void printQA() {
		BufferedReader br = null;
		
		try {
			File file = new File("qa.txt");
			br = new BufferedReader(new FileReader(file));
			
			String line;
			while((line = br.readLine()) != null) {
				System.out.println(line.substring(0, line.indexOf('?')+1));
				System.out.println(line.substring(line.indexOf('?')+2));
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("printQA not working obviously");
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
}
