package Assignment1;

public class QueueofBitcoinPrices {

	

	//-----------------------------------------------------
	// Title: Question 2
	// Author: Basme Zantout
	// Description: This is the class used by Question 2 which is
	//              a Queue class that creates a Queue of Bitcoin 
	//              Ranges using arrays. It also has the required 
        //              methods to calculate and print the Bitcoin Ranges
	//-----------------------------------------------------
	
	
	
//-------------------------------------------------------
// Attribute: shows the current size of the array queue   
//-------------------------------------------------------
    
	private int size; 

//-------------------------------------------------------
// Attribute: An array queue of Bitcoin Prices
//-------------------------------------------------------

	private int [] BitcoinPrices;
	
//-------------------------------------------------------
// Attribute: A private array for the Bitcoin Ranges 
//-------------------------------------------------------
 
	private int [] BitcoinRanges;
	
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
//-------------------------------------------------------
// Default Constructor
//-------------------------------------------------------
	
	public QueueofBitcoinPrices()
	{
		
	//-------------------------------------------------------
	// Initial size of the array queue
	//-------------------------------------------------------
		
		size = 0;
		
		
	//-------------------------------------------------------
	// "BitcoinPrices" array with length 6 since the bitcoin 
	// prices are to be over 6 days
	//-------------------------------------------------------
		
		BitcoinPrices = new int [6];
	}
	
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	
//-------------------------------------------------------
// Purpose: adding elements to the end of the queue
//-------------------------------------------------------
	
	public void enqueue (String PriceAsString)
	{
		
	//-------------------------------------------------------
	// Converting a String type variable to an int type variable 
    // since we are enqueueing the "BitcoinPrices" array from 
	// another String type array in the main class called "Prices"
	//-------------------------------------------------------
		
		int PriceAsInteger = Integer.parseInt(PriceAsString);
		BitcoinPrices[size] = PriceAsInteger;
		++size;
	}
	
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	
//-------------------------------------------------------
// Purpose: printing Bitcoin Prices
//-------------------------------------------------------	

	public void printPRICES() 
	{
		
	//-------------------------------------------------------
	// Calling the printArray method to print the bitcoin
	// prices from the array "BitcoinPrices"
	//-------------------------------------------------------
	
		printArray(BitcoinPrices);
	}
 
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	
	
//-------------------------------------------------------
// Purpose: Calculating and Printing Bitcoin Prices
//-------------------------------------------------------	

	
	public void printRANGES()
	{
		
	//-------------------------------------------------------
	// Instantiating "BitcoinRanges" array (with the same 
	// length of the prices)
	//-------------------------------------------------------
		
		BitcoinRanges = new int [BitcoinPrices.length];
		
		
	//-------------------------------------------------------
	// Setting its first index as 1 since the first range 
	// (of the first day) is always 1
	//-------------------------------------------------------

		BitcoinRanges[0] = 1;
		
		
	//-------------------------------------------------------
	// Instantiating a "singleRange" int variable to calculate
	// the range of bitcoin for each day
	//-------------------------------------------------------
		
		int singleRange = 0;
		
		
	//-------------------------------------------------------
	// In a nested for-loop the "pointer" moves day by day getting
	// the Bitcoin price of each day while the "checker" compares 
	// the Bitcoin price of the day with that of previous days in 
	// order to calculate the range at each day and save each value
	// in the corresponding "BitcoinRanges" array	
	//-------------------------------------------------------
		

		for (int pointer = 1 ; pointer < BitcoinPrices.length ; pointer++)
		{
			for (int checker = (pointer-1) ; checker >= 0 ; checker--)
			{
				if ((checker == (pointer-1)) && (BitcoinPrices[checker] >= BitcoinPrices[pointer]))
				{
					singleRange += 2; 
				}
				
				else if ((BitcoinPrices[checker] >= BitcoinPrices[pointer]))
				{
					singleRange += 1;
				}
				
				else if ((checker == 0) && (singleRange == 0) )
			    {
			        singleRange = 1;
			    }
				
			}

			BitcoinRanges[pointer] = singleRange;
			
			
		//-------------------------------------------------------
		// Resetting it to 0 to calculate the range of the next day
		//-------------------------------------------------------
		
			singleRange = 0;
		}
		
		
	//-------------------------------------------------------
	// Calling the printArray method to print the bitcoin 
	// ranges from the array "BitcoinRanges"
	//-------------------------------------------------------
		
		printArray(BitcoinRanges);
	}
	
	

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	
//-------------------------------------------------------
// Purpose: prints an array in a specific format
// Function: This private method takes an array of int as 
// a parameter and prints it in a specific format using a 
// a for-loop e.g. [value1, value2, value3...]
//-------------------------------------------------------
	

	private void printArray(int[] array)
	{
		System.out.print('[');
		
		for (int i = 0 ; i < array.length ; i++)
		{
			System.out.print(array[i]);
			
			if (i < (array.length - 1))
			{
				System.out.print(", ");
			}
		}
		
		System.out.print(']');
	}
 	
	
}
