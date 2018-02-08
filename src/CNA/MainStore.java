package CNA;

import java.util.ArrayList;
import java.util.Scanner;

public class MainStore {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Hi. Are you an employee?");
		String role = input.next();
		
		if (role.equalsIgnoreCase("employee")) {
			MenuUpdate.updateList();
			System.exit(0);
		}
		
		
		
		String anotherOrder;
		do {
			System.out.println("Hello and welcome to CAN, where you can buy canned goods.");

			ArrayList<Product> order = new ArrayList<Product>();

			String keepGoing;
			double subtotal;

			do {
				System.out.println("Inventory:");
				FileTools.readFromFile("resources", "menu.txt");

				System.out.println("Please select a product by choosing a number: ");
				int selectionLine = input.nextInt() - 1;
				String lineString = FileTools.grabALine("resources", "stuff.txt", selectionLine);
				// System.out.println(lineString);
				String[] tempArr = lineString.split(" ");

				System.out.println("How many would you like?");
				int quantity = input.nextInt();
				String name = tempArr[1];
				double price = Double.parseDouble(tempArr[2]);

				Product tempProd = new Product();
				tempProd.setName(name);
				tempProd.setPrice(price);
				tempProd.setQuantity(quantity);

				order.add(tempProd);

				double lineTotal = price * quantity;
				subtotal = calcSubtotal(order);

				System.out.printf("%d cans of %s costing $%.2f has been added to your order. ", tempProd.getQuantity(),
						tempProd.getName(), lineTotal);
				System.out.println();
				System.out.printf("Your subtotal is $%.2f.", subtotal);
				System.out.println();
				System.out.println("Want to add another product? Enter Y or N: ");
				keepGoing = input.next();

			} while (keepGoing.equalsIgnoreCase("Y"));

			double grandTotal = subtotal;

			System.out.printf("There's no sales tax on canned goods in MI!");
			System.out.println();
			System.out.printf("Your grand total is $%.2f.", grandTotal);

			System.out.println(" How would you like to pay? Enter a for card, b for cash and c for check: ");
			char payment = input.next().charAt(0);
			
			String receiptStr = "";
			switch (payment) {
			case 'a':
				String cardNum = Payment.creditCard(input);
				System.out.println(cardNum);
				receiptStr = cardNum;
				break;
			case 'b':
				System.out.println("Please enter your cash amount: ");
				double cashProvided = input.nextDouble();
				
				String changeStr = Payment.CashPayment(cashProvided, grandTotal);
				System.out.println(changeStr);
				receiptStr = changeStr;
				break;
			case 'c':
				String checkStr = Payment.Check(input);
				
				System.out.println(checkStr);
				receiptStr = checkStr;
				break;
			}
			
			
			Receipt.getReceipt(order, subtotal, grandTotal, receiptStr);

			System.out.println("Want to place another order? Enter Y or N: ");
			anotherOrder = input.next();

		} while (anotherOrder.equalsIgnoreCase("Y"));
		
		
		System.out.println("Goodbye! Remember, you CAN always come back.");
		
		
	}

	public static double calcSubtotal(ArrayList<Product> items) {
		double subTotal = 0.0;
		for (Product i : items) {
			subTotal += i.getPrice() * i.getQuantity();
		}

		return subTotal;
	}

}
