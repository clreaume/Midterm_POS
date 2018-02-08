package CNA;

import java.io.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuUpdate {

    public static void updateList() {
        Scanner scan = new Scanner(System.in);
        int lineNum = readline("resources","stuff.txt");
        ArrayList <ProductList> menuUpdateList = new ArrayList <>();
        ArrayList<ProductList> menuStuffList = new ArrayList <>();
        String cont = "y";

        while (cont.equalsIgnoreCase("y")) {
            System.out.println("Please enter product name: ");
            String name = scan.next();
            System.out.println("Please enter product price: ");
            double price = scan.nextDouble();
            System.out.println("Please enter product category: ");
            String category = scan.next();
            System.out.println("please enter product description: ");
            String description = scan.next();

            ProductList newProduct = new ProductList(lineNum,name, price, category, description);
            menuUpdateList.add(newProduct);

            ProductList newProduct2 = new ProductList(name,price);
            menuStuffList.add(newProduct2);

            System.out.println("Do you want to add another product? (y/n)");
            cont = scan.next();
            lineNum++;
        }
        System.out.println("Adding new Product is done");
        System.out.println(menuUpdateList);

        writeToFile("resources","menu.txt",menuUpdateList);
        writeToFile("resources","stuff.txt",menuUpdateList);

    }
    // to read the product list to assign the new added product number
    public static int readline(String dirString, String fileString){

        int i = 0; // counter of product number already in the list
        try {

            FileReader fr = new FileReader("stuff.txt");

            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();

            while (line != null) {
                i++;
                line = reader.readLine();
            }
            reader.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Something wrong with this!");
        }
        return  i;
    }
    public static void writeToFile(String dirString, String fileString, ArrayList <ProductList> productList) {
        Path writeFile = Paths.get(dirString, fileString);

        File file = writeFile.toFile();

        try {

            PrintWriter printOut = new PrintWriter(new FileOutputStream(file, true));
            for (ProductList item : productList) {
                printOut.println(item);
            }
            printOut.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
