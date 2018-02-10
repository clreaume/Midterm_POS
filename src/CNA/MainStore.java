package CNA;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import Employee.Employee;
import PayPackage.Payment;
import PayPackage.Receipt;
import ProductPackage.Product;
import Toolbox.FileTools;
import Toolbox.MenuUpdate;
import Toolbox.Validator;

public class MainStore {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		// program starts
		String role = Validator.getRole(input,
				"Hello and welcome to CAN, a canned foods store. Are you an employee or a customer? (E/C): ",
				"E", "C");

		HashMap<String, Integer> employees = new HashMap<String, Integer>(); // creating hashmap of username/pw pairs																	
		employees.put("caralr", 3454);
		employees.put("nickgs", 6787);
		employees.put("abdulhs", 5434);

		if (role.equalsIgnoreCase("employee")) {
			String userName = Validator.getString(input, "Please enter your employee username: ");

			while (!employees.containsKey(userName)) { //making sure username is key in employees HashMap
				userName = Validator.getString(input, "Invalid username! Try again: ");
			}

			int password = Validator.getInt(input, "Please enter your password: ");

			while (employees.get(userName) != password) { //making sure password is value in employees HashMap
				password = Validator.getInt(input, "Invalid password! Try again: ");
			}

			Employee.employeeScreen(userName, employees); //routing to employee screen
		}

		if (role.equalsIgnoreCase("customer")) {
			String anotherOrder;
			do {
				System.out.println("\nHere's a list of our products!");
				
				ArrayList<Product> order = new ArrayList<Product>(); // creating order array list, aka shopping cart

				String keepGoing;
				double subtotal;

				do {
					FileTools.readFromFile("resources", "menu.txt");

					int lineNum = Toolbox.MenuUpdate.readline("resources", "stuff.txt");
					System.out.println(); // spacing
					int selectionLine = Validator.getInt(input, "Please select a product by choosing a number: ", 1,
							lineNum);
					selectionLine = selectionLine - 1; // accounting for zero-indexing
					String lineString = FileTools.grabALine("resources", "stuff.txt", selectionLine);
					String[] tempArr = lineString.split(" "); // splitting line into array

					int quantity = Validator.getInt(input, "How many would you like? "); // asks user for quantity
					String name = tempArr[1]; // assigning name variable to second item of array
					double price = Double.parseDouble(tempArr[2]); // assigning price variable to third item of array

					Product tempProd = new Product(); // creating Product object of user's choice
					tempProd.setName(name);
					tempProd.setPrice(price);
					tempProd.setQuantity(quantity);

					order.add(tempProd); // adding Product object into order array list

					double lineTotal = price * quantity;
					subtotal = calcSubtotal(order);

					System.out.println();// extra line for spacing
					System.out.printf("%d can(s) of %s costing $%.2f each ($%.2f total) added to your order. ",
							tempProd.getQuantity(), tempProd.getName(), price, lineTotal);
					System.out.println();// spacing
					System.out.printf("Your subtotal is $%.2f.", subtotal);
					System.out.println();// spacing
					System.out.println();// spacing
					keepGoing = Validator.getContinue(input, "Want to add another product? (Y/N) ", "y", "n");

				} while (keepGoing.equalsIgnoreCase("Y"));

				double grandTotal = subtotal; // these will always be equal bc no sales tax

				System.out.printf("There's no sales tax on canned goods in MI!");
				System.out.println();
				System.out.printf("Your grand total is $%.2f.", grandTotal);

				int payment = Validator.getInt(input,
						" How would you like to pay? Enter 1 for Card, 2 for Cash and 3 for Check: ", 1, 3);

				String receiptStr = "";
				switch (payment) { //switch cases based on type of payment
				case 1:
					String cardNum = Payment.creditCard(input);
					System.out.println(cardNum);
					receiptStr = cardNum;
					break;
				case 2:
					double cashProvided = Validator.getDouble(input, "Please enter your cash amount: ", grandTotal);
					String changeStr = Payment.CashPayment(cashProvided, grandTotal);
					System.out.println(changeStr);
					receiptStr = changeStr;
					break;
				case 3:
					String checkStr = Payment.Check(input);
					System.out.println(checkStr);
					receiptStr = checkStr;
					break;
				}

				Receipt.getReceipt(order, subtotal, grandTotal, receiptStr);

				anotherOrder = Validator.getContinue(input, "Want to place another order? (Y/N) ", "Y", "N");

			} while (anotherOrder.equalsIgnoreCase("Y"));
			System.out.println("Goodbye! Remember, you CAN always come back.");
		}

	}

	public static double calcSubtotal(ArrayList<Product> items) {
		double subTotal = 0.0;
		for (Product i : items) {
			subTotal += i.getPrice() * i.getQuantity();
		}
		return subTotal;
	}

}
