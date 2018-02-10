package Toolbox;

import java.util.Scanner;

public class Validator {
	
	public static String employeeChoice(Scanner sc, String prompt, String letter1, String letter2, String letter3) {
		boolean isValid = false;
		String s = getString(sc, prompt);
		while (isValid == false) {
			if (s.equalsIgnoreCase(letter1)) {
				
				isValid = true;
			} else if (s.equalsIgnoreCase(letter2)) {
			
				isValid = true;
			} else if (s.equalsIgnoreCase(letter3)) {
				
				isValid = true;
			}
			else {
				System.out.println("Invalid entry. Enter P (for product entry), E (for employee entry) or X (to exit): ");
				s = getString(sc, prompt);
			}
		}
		return s;
	}
	
	
	
	public static String getString(Scanner sc, String prompt) {
		System.out.print(prompt);
		String s = sc.next(); 
		//sc.nextLine(); 
		return s;
	}

	public static String getRole(Scanner sc, String prompt, String letter1, String letter2) {
		boolean isValid = false;
		String s = getString(sc, prompt);
		while (isValid == false) {
			if (s.equalsIgnoreCase(letter1)) {
				s = "employee";
				isValid = true;
			} else if (s.equalsIgnoreCase(letter2)) {
				s = "customer";
				isValid = true;
			} else {
				System.out.println("Invalid entry.");
				s = getString(sc, prompt);
			}
		}
		return s;
	}
	
	public static String getContinue(Scanner sc, String prompt, String letter1, String letter2) {
		boolean isValid = false;
		String s = getString(sc, prompt);
		while (isValid == false) {
			if (s.equalsIgnoreCase(letter1)) {
				isValid = true;
			} else if (s.equalsIgnoreCase(letter2)) {
				isValid = true;
			} else {
				System.out.println("Invalid entry.");
				s = getString(sc, prompt);
			}
		}
		return s;
	}
	

	public static String getMove(Scanner sc, String prompt, String letter1, String letter2, String letter3) {
		boolean isValid = false;
		String s = getString(sc, prompt);
		while (isValid == false) {
			if (s.equalsIgnoreCase(letter1)) {
				s = "R";
				isValid = true;
			} else if (s.equalsIgnoreCase(letter2)) {
				s = "P";
				isValid = true;
			} else if (s.equalsIgnoreCase(letter3)) {
				s = "S";
				isValid = true;
			}

			else {
				System.out.println("Invalid entry. Please enter (R) (P) or (S)");
				s = getString(sc, prompt);
			}
		}
		return s;
	}

	public static int getInt(Scanner sc, String prompt) {
		int i = 0;
		boolean isValid = false;
		while (isValid == false) {
			System.out.print(prompt);
			if (sc.hasNextInt()) {
				i = sc.nextInt();
				isValid = true;
			} else {
				sc.next(); //to clear junk
				sc.nextLine(); //to clear junk
				System.out.println("Error! Invalid integer value. Try again.");
			}
		}
		return i;
	}

	public static int getInt(Scanner sc, String prompt, int min, int max) {
		int i = 0;
		boolean isValid = false;
		while (isValid == false) {
			i = getInt(sc, prompt);
			if (i < min)
				System.out.println("Error! Number must be " + min + " or greater.");
			else if (i > max)
				System.out.println("Error! Number must be " + max + " or less.");
			else
				isValid = true;
		}
		return i;
	}

	public static double getDouble(Scanner sc, String prompt) {
		double d = 0;
		boolean isValid = false;
		while (isValid == false) {
			System.out.print(prompt);
			if (sc.hasNextDouble()) {
				d = sc.nextDouble();
				isValid = true;
			} else {
				System.out.println("Error! Invalid decimal value. Try again.");
			}
			sc.nextLine(); // discard any other data entered on the line
		}
		return d;
	}

	public static double getDouble(Scanner sc, String prompt, double min) {
		double d = 0;
		boolean isValid = false;
		while (isValid == false) {
			d = getDouble(sc, prompt);
			if (d < min) {
				System.out.printf("Error! Cash tendered must be $%.2f or greater. ", min);
			}
			else {
				isValid = true;
			}
		}
		return d;
	}
}
