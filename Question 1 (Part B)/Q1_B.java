package Assignment1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Q1_B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//-----------------------------------------------------
		// Title: Question 1 - Part B
		// Author: Basme Zantout
		// ID: 99227947762
		// Section: 1
		// Assignment: 1
		// Description: This is the main class for Question 1 (Part B) 
		//              which depends on the LinkedList.java class directly
		//              and the Node_Q1B class indirectly in order to check 
	        //              the neighborhood of 2 lists in a matrix
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

		filename = "matrixes/q1b/" + filename;
				
		
		
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
			// In order to know the number of rows and columns there 
		        // are in the matrix I used the reader to read a line from
			// from the matrix as a String named "line" then I used the 
			// split(" ") method with space as parameter so it divides
			// the line String at each space and stores the values
			// between the spaces in an array named "col". I implemented it
			// in a while loop which stops when there are no more lines to
			// read in order to know how many rows (lines) we have. Meanwhile,
			// from the length of the array "String [] col" I derived the number
			// columns in the matrix.
			//-------------------------------------------------------
		
				String [] col  = null;
				String line;
				int row = 0;
				int column = 0;
					
				while ((line = reader.readLine()) != null)
				{
					col = line.split(" ");
					row++;
						
				}
					
					column = col.length;
					
			//-------------------------------------------------------
			// Creating a 2D-array called "Matrix" with the 
			// derived number of rows and columns of the matrix
			//-------------------------------------------------------
					
				int [][] Matrix = new int [row][column];
					
					
			//-------------------------------------------------------
			// Closing the Reader
			//-------------------------------------------------------
					
					reader.close();
					
			//-------------------------------------------------------
			// Now after I know the number of rows and columns, I am 
			// reading the matrix again in order to store the values in
			// the 2D-array I created using nested while loops, in which the
			// first while-loop iterates or reads line by line while the 
			// second while-loop uses the spit(" ") method to store the 
			// values in a String array called NUMs as explained before then
			// for we convert each value stored from String to int using 
			// Integer.parseInt() method and that way we keep iterating 
			// until we go over all rows and columns and we end up storing
			// all the values of the matrix to a 2D-array of type int.
			//-------------------------------------------------------	
					
				reader = new BufferedReader(new FileReader(filename));
					
				int r = 0;
				int c = 0;
				    
				while ((c < column) && (r < row))
				{
					line = reader.readLine();
						
					while (c < column)
					{
						String [] NUMs = line.split(" ");
						int NUM = Integer.parseInt(NUMs[c]);
							
						Matrix[r][c] = NUM;
						c++;
					}
						
						c = 0;
						r++;
				}
				
			   
//-------------------------------------------------------
// Creating an instance of the class "LinkedList" in order
// to have store the values of matrixb as a linked list
//-------------------------------------------------------
				
		 LinkedList matrixb = new LinkedList();
			 
			    
//-------------------------------------------------------
// Assigning the VALUES in the "Matrix" 2-D array to the
// linked list "matrixb"
// Note: check "Array_to_LinkedList(int [][] array)" method
//       in the "LinkedList" class
//-------------------------------------------------------
			    
		matrixb.Array_to_LinkedList(Matrix);
			    
				 
//-------------------------------------------------------
// Assigning the INDICES to the values in matrixb
// Note: check "AssignIndices()" method in the "LinkedList" 
//       class
//------------------------------------------------------- 
			    
	    matrixb.AssignIndices();
				
			    
//-------------------------------------------------------
// Closing the Reader
//-------------------------------------------------------
		reader.close();
		
		
		
		
				
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
				
		
		
				
//-------------------------------------------------------
// After reading the matrix we need to read list1
// Below we are doing the same process to scan the input
//-------------------------------------------------------
			    
		System.out.print("Input filename:");
		filename = scan.next();
		filename = "matrixes/q1b/" + filename;
				
				
//-------------------------------------------------------
// Assigning the reader to the new text file
//-------------------------------------------------------
				
		reader = new BufferedReader(new FileReader(filename)); 
				
//-------------------------------------------------------
// Read the line of the list from the text file and assigning
// it to a 1-D array called "list" using the split("-") 
// method which divides the line at each "-" and then we 
// put the values to the array one by one
//-------------------------------------------------------	
				
		String [] list =  (reader.readLine()).split("-");

		
//-------------------------------------------------------
// Creating an instance of the class "LinkedList" in order
// to have store the values of list 1 as a linked list
//-------------------------------------------------------
		
		LinkedList list1 = new LinkedList();
		
		
//-------------------------------------------------------
// Copying the values in the String array "list" to the linked
// list called "list1"
// Note: the method named "Array_to_LinkedList" is overloaded
//		 in which one accepts an int type 2-D array as a 
//       parameter while the other accepts a String type 1-D 
//       array as a parameter
// Note: check "Array_to_LinkedList(String [] array)" method
//       in the "LinkedList" class
//-------------------------------------------------------
		
		list1.Array_to_LinkedList(list);
				
				
//-------------------------------------------------------
// Reclosing the Reader
//-------------------------------------------------------
		
		reader.close();
				
				
				
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
				
				
		
//-------------------------------------------------------
//After reading the matrix and list1 we need to read list2
//Below we are doing the same process to scan the input
//-------------------------------------------------------
		
		System.out.print("Input filename:");
		filename = scan.next();
		filename = "matrixes/q1b/" + filename;
		
		
//-------------------------------------------------------
//Assigning the reader to the new text file
//-------------------------------------------------------
		
		reader = new BufferedReader(new FileReader(filename));
		
		
//-------------------------------------------------------
//Read the line of the list from the text file and assigning
//it to a 1-D array called "list" using the split("-") 
//method which divides the line at each "-" and then we 
//put the values to the array one by one
//-------------------------------------------------------
		
		list =  (reader.readLine()).split("-");
				
		
//-------------------------------------------------------
// Creating an instance of the class "LinkedList" in order
// to have store the values of list 2 as a linked list
//-------------------------------------------------------
		
		LinkedList list2 = new LinkedList();
		
		
//-------------------------------------------------------
// Copying the values in the String array "list" to the linked
// list called "list2"
// Note: the method named "Array_to_LinkedList" is overloaded
//		 in which one accepts an int type 2-D array as a 
//       parameter while the other accepts a String type 1-D 
//       array as a parameter
// Note: check "Array_to_LinkedList(String [] array)" method
//       in the "LinkedList" class
//-------------------------------------------------------
		
		list2.Array_to_LinkedList(list);
				
				
		
//-------------------------------------------------------
// Checking the neighborhood of the 2 lists using the method
// named "Check_Neighborhood" which returns true when there is
// neighborhood and false if there's no neighborhood. Thus,
// we are printing the output (TRUE/FALSE) after checking
// Note: Check the method "Check_Neighborhood" in the 
//       "LinkedList" class for more detail
//-------------------------------------------------------
		
		if(list2.Check_Neighborhood(list1, matrixb))
		{
			System.out.println("TRUE");
		}
		
		else System.out.println("FALSE");

		
//-------------------------------------------------------
// Closing the Scanner
//-------------------------------------------------------
		scan.close();
		
		
//-------------------------------------------------------
// Reclosing the Reader
//-------------------------------------------------------
		reader.close();
	
			
	} 
			
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			    }
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
