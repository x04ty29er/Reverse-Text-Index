import java.lang.*;
import java.io.*;
import java.util.*;

public class activeTest {

	private static reverseIdx brain;
	private static int sentLen = 10;
	
	
	public static void main(String []args){
		brain = new reverseIdx();
		if (args[0] != null) {
			try {
				System.out.println("Loading current memory...");
				
				//Split into new function eventually
				String toBeParsed = "";
				File inputFile = new File(args[0]);
				Scanner inputStream = new Scanner(inputFile);
				
				while (inputStream.hasNextLine()) {
					toBeParsed = inputStream.nextLine();
					brain.memorize(toBeParsed);
				}
				System.out.println("Memory Loaded!");
			}
			catch (FileNotFoundException e) {
				System.out.println("Please use a valid memory file next time!");
			}
			
		}
		Scanner s = new Scanner(System.in);
		String userInput = "";
		while (true) {
			System.out.print("Your Input: ");
			userInput = s.nextLine();
			brain.memorize(userInput);
			System.out.println(brain.utter(sentLen));
		}
	}
}