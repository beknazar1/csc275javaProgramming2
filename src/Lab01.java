import java.util.*;

public class Lab01 {
	
	public static void main(String[] args) {
		int[] arr = new int[100]; //initialize an int array with size 100
		
		//fill array with numbers
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (1+ Math.random()*100); //minimum value is 1, maximum is 100
		}
				
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter a number from 1 to 100: ");
		int in = input.nextInt();
		int out = -1; //create an int variable to store result from for loop below
		for (int i = 0; i < arr.length; i++) {
			if (in == arr[i]) {
				out = i;
				break;
			}
		}
		
		if (out==-1) {
			System.out.println("No match found");
		} else {
		System.out.println("We found your number "+ in +" at position " + out + " in the array" );
		}
	}
}
