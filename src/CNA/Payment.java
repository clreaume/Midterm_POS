package CNA;

import java.util.Scanner;

public class Payment {

    // cash payment method
	public static String CashPayment(double pay, double gt) {

		double changeAmount = 0; // to hold the change
		double paymentDetail; // to hold return value

        // compute the change amount
		changeAmount = Math.abs(gt - pay);

		return String.format("Change: ", changeAmount);
		
	}
	// check payment method
	public static String Check(Scanner sc) {

		System.out.println("Please enter check number: ");
		String checkNum = sc.next();

		System.out.println("Thank you!");

		return "Payment made check: " + checkNum;
	}
    // credit card payment method
	public static String creditCard(Scanner sc) {
		System.out.println("Please enter your card number: ");
		String cardNum = sc.next();
		System.out.println("Please enter card expiration: (MM/YY)");
		String cardExpir = sc.next();
		System.out.println("Please enter CVV code: ");
		String cvv = sc.next();

		System.out.println(" Thank you!");

		return "Payment made through credit card: XXX" + cardNum.substring(12);
	}

}
