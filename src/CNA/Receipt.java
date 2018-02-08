package CNA;

import java.util.ArrayList;

public class Receipt {
	public static String getReceipt(ArrayList<Product> orderArr, double st, double gt ) {
		//receipt should have items ordered, subtotal, grand total and appropriate payment info
		
		//PRINT ITEMS IN ORDER
		System.out.println("Your order:");
		for (Product i : orderArr) {
			System.out.printf("%d %s \t \t %.2f",i.getQuantity(), i.getName(), i.getPrice()*i.getQuantity());
			System.out.println();
		}
		
		//PRINT SUBTOTAL
		System.out.println("Subtotal:" + st);
		
		//PRINT TAX
		System.out.println("Tax: $0.00");
		
		//PRINT GRAND TOTAL
		System.out.println("Grand total:" + gt);
		
		
		//PRINT PAYMENT INFO
		
		
		
		return "";
		 
	}
	
}

