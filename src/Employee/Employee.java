package Employee;

import java.util.HashMap;
import java.util.Scanner;

import Toolbox.MenuUpdate;
import Toolbox.Validator;

public class Employee {
	
	public static void employeeScreen(String name, HashMap<String, Integer> empHM) {
		Scanner input = new Scanner(System.in);
		
		String choice;
		System.out.println("\nWelcome " + name + "!");
		
		do {
		System.out.println();//extra line for spacing
		choice = Validator.employeeChoice(input, "Please choose an action:\nTo add product(s) to the inventory list, enter P\nTo add employee(s) to the system, enter E\nTo exit, enter X\n", "P", "E", "X");
		System.out.println(); //extra line for spacing
		
		if (choice.equalsIgnoreCase("P")) {
			MenuUpdate.updateList();
		} 
		else if (choice.equalsIgnoreCase("E")) {
			Employee.addEmp(empHM);
		}
		} while(!choice.equalsIgnoreCase("X"));
			
		System.out.println("Goodbye! Remember, you CAN always come back.");
	}
	
	
	public static void addEmp(HashMap<String, Integer> emps) {
		Scanner sc = new Scanner(System.in);
		String cont;
		
		do {
		String un = Validator.getString(sc, "Please enter the new employee's username: ");
		int pw = Validator.getInt(sc, "Please enter the new employee's password: ");
		emps.put(un, pw);
		
		System.out.println();
		System.out.println(un + " has been added to the system.");
		System.out.println();
		
		System.out.println("Current CAN employees: ");
		for (String i : emps.keySet()) {
			System.out.println(i);
		}
		System.out.println();
		
		cont = Validator.getContinue(sc, "Want to add another employee? (Y/N): ", "Y", "N");
		} while(cont.equalsIgnoreCase("Y"));
		
	}

}
