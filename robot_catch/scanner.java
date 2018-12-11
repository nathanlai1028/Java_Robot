package robot_catch;
import java.util.Scanner;
import java.io.*;

public class scanner {

	public int getPropertyNumber() {
		int propNum = 0;
		Scanner in = new Scanner(System.in);
		boolean continueInput = true;
		do {
			try {	
		      System.out.println("How many property numbers needs to copy?(Type Integer please)");
		      propNum =  Integer.parseInt(in.nextLine());
//		      System.out.println("You entered number " + propNum);
		      continueInput = false;
			}
			catch(NumberFormatException ex) {
				System.out.println("Try again. (Incorrect input: an integer is required)");
			}
		}
		while(continueInput);
        return propNum;
	}
	
	public int getMethod() {
		int selection = -1;
		Scanner in = new Scanner(System.in);
		boolean continueInput = true;
		do{
			try {
				System.out.println("1: Ctrl + A       2: Select + Right. Please Type \"1\" / \"2\"");
				selection = Integer.parseInt(in.nextLine());
//				System.out.println("You entered option " + selection);
				continueInput = false;
			}
			catch(NumberFormatException ex) {
				System.out.println("Try again. (Incorrect input: an integer is required)");
			}
		}while (continueInput || (selection != 1 && selection != 2));
        return selection;
	}
	
	
	public int getNeedSecondPage() {
		int option = -1;
		Scanner in = new Scanner(System.in);
		boolean continueInput = true;
		do {
			try {	
		      System.out.println("Need Second Page Information? 1: True  	2: False");
		      option =  Integer.parseInt(in.nextLine());
//		      System.out.println("You entered number " + option);
		      continueInput = false;
			}
			catch(NumberFormatException ex) {
				System.out.println("Try again. (Incorrect input: an integer is required)");
			}
		}
		while(continueInput || (option != 1 && option != 2));
        return option;
	}
	

////	public static void main(String[] args) {
////		scanner scanner = new scanner();
////	}
}
