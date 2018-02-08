package CNA;

import java.util.ArrayList;
import java.util.Scanner;

import PayPackage.Payment;
import PayPackage.Receipt;
import ProductPackage.Product;
import Toolbox.FileTools;
import Toolbox.MenuUpdate;
import Toolbox.Validator;

public class MainStore {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		String role = Validator.getRole(input,
				"Hello and welcome to CAN, a canned foods store. Are you an employee or a customer? (employee/customer) ", "employee",
				"customer");

		if (role.equalsIgnoreCase("employee")) {
			String addProd = Validator.getContinue(input,
					"Would you like to add a product to the inventory list? (Y/N) ", "y", "n");
			if (addProd.equalsIgnoreCase("Y")) {
				// System.out.println("Let's add a product to the inventory.");
				MenuUpdate.updateList();
				// System.out.println("Thanks for the update!");
			} else {
				System.out.println("Goodbye! Remember, you CAN always come back.");

			}
			System.exit(0);
		}

		if (role.equalsIgnoreCase("customer")) {
			String anotherOrder;
			do {
				System.out.println("Here's a list of our products!");

				ArrayList<Product> order = new ArrayList<Product>();

				String keepGoing;
				double subtotal;

				do {
					FileTools.readFromFile("resources", "menu.txt");

					int lineNum = Toolbox.MenuUpdate.readline("resources", "stuff.txt");

					int selectionLine = Validator.getInt(input, "Please select a product by choosing a number: ", 1,
							lineNum);
					selectionLine = selectionLine - 1;
					String lineString = FileTools.grabALine("resources", "stuff.txt", selectionLine);
					// System.out.println(lineString);
					String[] tempArr = lineString.split(" ");

					int quantity = Validator.getInt(input, "How many would you like?");
					String name = tempArr[1];
					double price = Double.parseDouble(tempArr[2]);

					Product tempProd = new Product();
					tempProd.setName(name);
					tempProd.setPrice(price);
					tempProd.setQuantity(quantity);

					order.add(tempProd);

					double lineTotal = price * quantity;
					subtotal = calcSubtotal(order);

					System.out.printf("%d cans of %s costing $%.2f each ($%.2f total) has been added to your order. ",
							tempProd.getQuantity(), tempProd.getName(), price, lineTotal);
					System.out.println();
					System.out.printf("Your subtotal is $%.2f.", subtotal);
					System.out.println();
					keepGoing = Validator.getContinue(input, "Want to add another product? (Y/N) ", "y", "n");

				} while (keepGoing.equalsIgnoreCase("Y"));

				double grandTotal = subtotal;

				System.out.printf("There's no sales tax on canned goods in MI!");
				System.out.println();
				System.out.printf("Your grand total is $%.2f.", grandTotal);

				int payment = Validator.getInt(input,
						" How would you like to pay? Enter 1 for Card, 2 for Cash and 3 for Check: ", 1, 3);

				String receiptStr = "";
				switch (payment) {
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

				anotherOrder = Validator.getContinue(input, "Want to place another order? (Y/N) ", "y", "n");

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
