package Toolbox;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileTools {
	
	public static void readFromFile(String dirString, String filePath) {
		Path readFile = Paths.get(dirString, filePath);  
		File file = readFile.toFile();
		
		try {
			FileReader fr = new FileReader(file);
			BufferedReader reader = new BufferedReader(fr);
			String line = reader.readLine();
			
			while(line != null) {
				System.out.println(line);
				line = reader.readLine();
			}
			reader.close(); 
			
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Something went wrong with this!");
			e.printStackTrace();
		}
	}
	
	public static String grabALine(String dirString, String filePath, int selectionLine) {
		
		String lineWeWant = "";
		try {
			lineWeWant = Files.readAllLines(Paths.get(dirString,filePath)).get(selectionLine);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return lineWeWant;
		
		
	}
	
	
	
	

}
