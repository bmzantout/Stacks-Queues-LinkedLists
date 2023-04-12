package Assignment1;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Q1_A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//-----------------------------------------------------
		// Title: Question 1 - Part A
		// Author: Basme Zantout
		// ID: 99227947762
		// Section: 1
		// Assignment: 1
		// Description: This is the main class for Question 1 (Part A) which depends
		//              on the DoubleLinkedList.java class directly and Node.java class
		//              indirectly to return a matrix in spiral form using linked lists
		//-----------------------------------------------------

		
		
//-------------------------------------------------------
// Creating a Scanner object named "scan"   
//-------------------------------------------------------
		
		Scanner scan = new Scanner(System.in);
		
//-------------------------------------------------------
// Saving the file name input to a String 
//-------------------------------------------------------
		
		System.out.print("Input filename:");
		String filename = scan.next();
		
//-------------------------------------------------------
// Adding the required paths to the text file
//-------------------------------------------------------

		filename = "matrixes/q1a/" + filename;
		
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
			// Creating an instance of the class DoubleLinkedList called "NOTSpiral".
			// Thus, I'm creating a double linked list in order to store the 
			// values in the 2D array called "Matrix" to this Double Linked List
			// Note (1): this Double Linked List will store the values in an
			// ordinary order which means in a NON-SPIRAL form!
			// Note (2): this Double Linked List is currently empty!
			//-------------------------------------------------------
				
			    DoubleLinkedList NOTSpiral = new DoubleLinkedList();
			    
				
			//-------------------------------------------------------
			// This method stores the values found in a 2D-array (Matrix)
			// to a Double Linked List (NOT_Spiral) in a non-spiral form, 
			// in an ordinary order going column by column.
			//-------------------------------------------------------
					    
			    NOTSpiral.Array_to_LinkedList(Matrix);
				
			//-------------------------------------------------------
			// Creating another instance of the class DoubleLinkedList 
			// called "Spiral" which is intended to store the values of 
			// matrix in spiral form.
			// Note: this Double Linked List is currently empty!
			//-------------------------------------------------------
			    
			    DoubleLinkedList Spiral = new DoubleLinkedList();
			
				
			//-------------------------------------------------------
			// The method SpiralForm() of the class DoubleLinkedList
			// takes the non-spiral linked list (NOTSpiral) and returns 
			// a Double Linked List which holds the values in spiral form 
			// The returned Double Linked List is therefore assigned to (Spiral).
			//-------------------------------------------------------
				   
			    Spiral = NOTSpiral.SpiralForm();
			    
				
			//-------------------------------------------------------
			// The method "printDoubleLinkedList()" prints the Double
			// Linked List (Spiral) to the console in a specific format
			// e.g. [value1, value2,value3...]
			//-------------------------------------------------------
				
			    Spiral.printDoubleLinkedList();

				
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


