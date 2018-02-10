package Toolbox;

import java.io.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import ProductPackage.MinProductList;
import ProductPackage.ProductList;

public class MenuUpdate {

	public static void updateList() {
		Scanner scan = new Scanner(System.in);
		int lineNum = readline("resources", "stuff.txt");
		lineNum += 1;
		ArrayList<ProductList> menuUpdateList = new ArrayList<>();
		ArrayList<MinProductList> menuStuffList = new ArrayList<>();
		String cont = "Y";

		while (cont.equalsIgnoreCase("y")) {

			String name = Validator.getString(scan, "Please enter product name: ");

			double price = Validator.getDouble(scan, "Please enter product price: ");

			String category = Validator.getString(scan, "Please enter product category: ");

			String description = Validator.getString(scan, "Please enter product description: ");

			ProductList newProduct = new ProductList(lineNum, name, price, category, description);
			menuUpdateList.add(newProduct);

			MinProductList newProduct2 = new MinProductList(lineNum, name, price);
			menuStuffList.add(newProduct2);
			
			System.out.println(); //spacing
			cont = Validator.getContinue(scan, "Do you want to add another product? (Y/N) ", "Y", "N");

			lineNum++;
		}

		// System.out.println(menuUpdateList);

		writeToFile("resources", "menu.txt", menuUpdateList);
		writeToFileStuuf("resources", "stuff.txt", menuStuffList);

		System.out.println("Thanks, CAN's inventory has been updated with your product(s)!");

	}

	// to read the product list to assign the new added product number
	public static int readline(String dirString, String filePath) {

		int i = 0; // counter of product number already in the list
		Path readFile = Paths.get(dirString, filePath); // could also do (dirString, filePath)
		File file = readFile.toFile();

		try {
			FileReader fr = new FileReader(file);
			// the benefit of using BufferedReader is to help us store a block of memory
			// that we can go back to and read data from later - more efficient than scanner
			BufferedReader reader = new BufferedReader(fr);
			String line = reader.readLine();

			while (line != null) {
				i++;
				line = reader.readLine();
			}
			reader.close(); //

		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("Something wrong with this!");
		}
		return i;
	}

	public static void writeToFile(String dirString, String fileString, ArrayList<ProductList> ProductList) {
		Path writeFile = Paths.get(dirString, fileString);

		File file = writeFile.toFile();

		try {

			PrintWriter printOut = new PrintWriter(new FileOutputStream(file, true));
			for (ProductList item : ProductList) {
				printOut.println(item);
			}
			printOut.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void writeToFileStuuf(String dirString, String fileString, ArrayList<MinProductList> ProductList) {
		Path writeFile = Paths.get(dirString, fileString);

		File file = writeFile.toFile();

		try {

			PrintWriter printOut = new PrintWriter(new FileOutputStream(file, true));
			for (MinProductList item : ProductList) {
				printOut.println(item);
			}
			printOut.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}