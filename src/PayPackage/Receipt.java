package PayPackage;

import java.util.ArrayList;

import ProductPackage.Product;

public class Receipt {
	public static void getReceipt(ArrayList<Product> orderArr, double st, double gt, String paymentStr) {
		//receipt should have items ordered, subtotal, grand total and appropriate payment info
		System.out.println();
		System.out.println("-------\t-------\t-------\t-------\t-------\t-------");
		System.out.println("\t\t~RECEIPT~");
		System.out.println();
		
		//PRINT ITEMS IN ORDER
		System.out.println("Items:");
		for (Product i : orderArr) {
			//System.out.printf("%s \t (quantity: %d) \t %.2f", i.getName(), i.getQuantity(), i.getPrice()*i.getQuantity());
			System.out.printf("%-16s  quantity: %-3d  $%.2f", i.getName(), i.getQuantity(), i.getPrice()*i.getQuantity());
			System.out.println();
		}
		System.out.println();
		
		//PRINT SUBTOTAL
		System.out.printf("Subtotal: \t\t\t $%.2f",st);
		//System.out.printf("Subtotal: $%.2f",st);
		System.out.println();
		
		//PRINT TAX
		System.out.println("Tax: \t\t\t\t $0.00");
		
		//PRINT GRAND TOTAL
		System.out.printf("Grand total: \t\t\t $%.2f",gt);
		System.out.println();
		System.out.println();
		
		
		//PRINT PAYMENT INFO
		
		System.out.println(paymentStr);
		
		//PRINT EXIT MSG
		System.out.println();
		System.out.println("\tThanks for shopping at CAN!");
		
		System.out.println("-------\t-------\t-------\t-------\t-------\t-------");
		System.out.println();
		
		
		 
	}
	
}

