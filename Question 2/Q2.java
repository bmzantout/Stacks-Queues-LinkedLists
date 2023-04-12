package Assignment1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Q2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		//-----------------------------------------------------
		// Title: Question 2
		// Author: Basme Zantout
		// Description: This is the main class for Question 2 which depends on the
		//              QueueofBitcoinPrices.java class directly and uses the Queues
		//              data structure as arrays for the solution
		//-----------------------------------------------------
		

//-------------------------------------------------------
// Creating a Scanner object named "scan"   
//-------------------------------------------------------		

		Scanner scan = new Scanner(System.in);
		
//-------------------------------------------------------
// Saving the file name input to a String 
//-------------------------------------------------------
		
		System.out.println("Input filename:");
		String filename = scan.next();
		
//-------------------------------------------------------
// Adding the required paths to the text file
//-------------------------------------------------------

		filename = "matrixes/q2/" + filename;
		
//-------------------------------------------------------
// Closing the Scanner
//-------------------------------------------------------
		
		scan.close();
		
		
		
//-------------------------------------------------------
// Using the try-catch block because we're using 
// "BufferedReader" Class to read the text file
//-------------------------------------------------------		
		
		try {
			
		//-------------------------------------------------------
		// Creating a BufferedReader object named "reader" with
		// the text file name passed to the parameter
		//-------------------------------------------------------	
			
			BufferedReader reader = new BufferedReader(new FileReader(filename));
	 		
			
		//-------------------------------------------------------
		// Reading a line from the text file and splitting it at 
		// spaces using the split() method with space as a parameter 
		// then saving the 6 values of Bitcoin Prices to a String 
		// array called "Prices"
		//------------------------------------------------------- 	
			
			String [] Prices =  (reader.readLine()).split(" ");
			
			
		//-------------------------------------------------------
		// Creating a QueueofBitcoinPrices object in order to create 
		// a queue (Data Structure) of Bitcoin Prices over six days
		//-------------------------------------------------------
			
			QueueofBitcoinPrices BitcoinPrices = new QueueofBitcoinPrices();
	
			
		//-------------------------------------------------------
		// Enqueueing the values of Bitcoin Prices to an array queue 
		// from the String array "Prices" by taking each of its indices 
		// as parameter using a for-loop 
		//-------------------------------------------------------
			

			for (int i = 0 ; i < Prices.length ; i++ )
			{
				BitcoinPrices.enqueue(Prices[i]);
			}

		//-------------------------------------------------------
		// //Dequeueing the Bitcoin Prices using "printPRICES()" method 
		//-------------------------------------------------------
			
			BitcoinPrices.printPRICES();
			System.out.println();
			
		//-------------------------------------------------------
		// Printing the Bitcoin Ranges using "printRANGES()" method
		//-------------------------------------------------------
			
			BitcoinPrices.printRANGES();

			
		//-------------------------------------------------------
		// Closing the BufferedReader
		//-------------------------------------------------------		
			
			reader.close();
	 	} 
		
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		    }
	}

}
