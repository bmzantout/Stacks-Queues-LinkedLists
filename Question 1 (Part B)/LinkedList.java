package Assignment1;

public class LinkedList {

	//-----------------------------------------------------
	// Title: Question 1 - Part B
	// Author: Basme Zantout
	// Description: This is the class used by Question 1 (Part B) which is
	//              a LinkedList class that creates Singly linked lists
	//              from nodes (it directly depends on the Node_Q1B.java class)
	//              and has methods that check the neighborhood of two lists 
	//-----------------------------------------------------

	
	
//-------------------------------------------------------
// Attribute: the "head" or first node of the linked list   
//-------------------------------------------------------
	
	private Node_Q1B head;
	
//-------------------------------------------------------
// Attribute: the "tail" or last node of the linked list   
//-------------------------------------------------------
	
	private Node_Q1B tail;
	
//-------------------------------------------------------
// Attribute: it refers to the row number of the matrix, or 
//            in other words to the number of rows in the 
//            2-D we will use to read the matrix
//-------------------------------------------------------
	
	private int rowNumber;
	
//-------------------------------------------------------
// Attribute: a boolean that is true when there is neighborhood
//            and false otherwise
//-------------------------------------------------------
	
	private static boolean neighborhood;
	
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	
//-------------------------------------------------------
// Constructor: Default constructor in which the "head" is 
// initially set to null beacuse the lists are initially empty
//-------------------------------------------------------
	
	public LinkedList() 
	{
		head = null;
	}


	
//-------------------------------------------------------
// Purpose: checks whether the Linked List it empty or not
// Function: if the "head" or the beginning of the list is 
//	           null then the list is empty and it returns true.
//	           Otherwise, if the "head" exists then it returns 
//	           false meaning that it's not empty.
//-------------------------------------------------------
	
	private boolean isEmpty()
	{
		if (head == null)
			return true;
		else 
			return false;
	}
	


//-------------------------------------------------------
// Purpose: adds a node to the end of the list
// Function: if the list is not empty then it adds a node 
//	           after the tail and makes this new node the tail. 
//	           Otherwise, if it's empty it sets this new node as
//	           the tail and head as well.
// Note: we are using the "setNext(Node n)" method from the 
//       Node_Q1B.java class
//-------------------------------------------------------
	
	private void addLast(int newdata)
	{
		Node_Q1B newNode = new Node_Q1B(newdata);
		
		if (!isEmpty())
		{
			tail.setNext(newNode);
			tail = newNode;
		}
		
		else 
		{
			head = tail = newNode;
		}
	}
	
	

//-------------------------------------------------------
// Purpose: adds a node to the end of the list
// Function: the method "addLast" is overloaded. The first one 
//           takes int type data as parameter (to store the values
//           of the NUMBERS in the matrix) while this one takes 
//           String type data as a parameter (to store the values
//           of the INDICES in the lists)
// Note: we are using the "setNext(Node n)" method from the 
//	       Node_Q1B.java class
//-------------------------------------------------------
	
	private void addLast(String index)
	{
		Node_Q1B newNode = new Node_Q1B(index);
		
		if (!isEmpty())
		{
			tail.setNext(newNode);
			tail = newNode;
		}
		
		else 
		{
			head = tail = newNode;
		}
	}
	
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	
//-------------------------------------------------------
// Purpose: copies the data values in a given 2-D array to a 
//          linked list
// Function: in a nested for-loop we iterate over all the 
//           elements in the 2-D array matrix and add them 
//           to a linked list using the "addLast(int newdata)"
//           method 
//-------------------------------------------------------
	
	public void Array_to_LinkedList(int [][] array)
	{
		for (int column = 0 ; column < array[0].length ; column++)
		{
			for (int row = 0 ; row < array.length ; row++)
			{
				this.addLast(array[row][column]);
			}
		}
		
	//-------------------------------------------------------
	// Note: we are taking here the number of rows in the matrix
	// from the 2-D array and assigning to our attribute "rowNumber"
	//-------------------------------------------------------
		rowNumber = array.length; 
	}

	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	
//-------------------------------------------------------
// Purpose: copies the data values in a given 2-D array to a 
//	          linked list
// Function: the method "Array_to_LinkedList" is overloaded. 
//           The first one takes int type 2-D array as parameter 
//           (because the matrix's data is INTEGER NUMBERS) while 
//           this one takes String type 1-D array as a parameter
//           (because the lists' indices are taken STRINGs)
// Note: we are using the "addLast(String index)" method to add
//       to the linked list
//-------------------------------------------------------
	
	public void Array_to_LinkedList(String [] array)
	{
		for (int i = 0 ; i < array.length ; i++)
		{
			this.addLast(array[i]);
		}
	}
	
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	
//-------------------------------------------------------
// Purpose: In the matrixb linked list each node has "data" 
//          the integer number value of the element and its
//          corresponding "index". Thus this method will assign
//          to each value the index based on its location in 
//          the matrix
// Function: the method iterates through each node in the "matrixb" 
//          linked list starting from the "head" using a while-loop
//          and assigns the index values based on their locations 
//          (as rows and columns) by following the arrow direction
//          in Q1-A
//-------------------------------------------------------

	public void AssignIndices()
	{
		int row = 0;
		int column = 0;
		Node_Q1B pointer = head;
		
		while (pointer != null)
		{
			
		//-------------------------------------------------------
		// The method "Integer.toString" converts an integer in a 
		// to a string. 
		// Note: check Node_Q1B class for details about the method:
		// "setIndex(Integer.toString(row), Integer.toString(column))"
		//-------------------------------------------------------
			pointer.setIndex(Integer.toString(row), Integer.toString(column));
			pointer = pointer.getNext();
			row++;
			
			if (row == rowNumber)
			{
				row = 0;
				column++;
			}
		}
	}
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	
//-------------------------------------------------------
// Purpose: This method is the most significant method since
//          it is the method that checks or neighborhood in 
//          the four directions
// Function: It calls 4 methods in which each of these methods
//           checks neighborhood in a singular direction. The 
//           attribute "neighborhood" is a common boolean in all 
//           methods. Thus, if neighborhood in one direction is false
//           "neighborhood" will be FALSE and the method will terminate
//-------------------------------------------------------	
	
	public boolean Check_Neighborhood(LinkedList list1, LinkedList matrixb)
	{
		
	//-----------------------------------------------------
	//  "neighborhood" is initially set to true
	//-----------------------------------------------------
		
		neighborhood = true;
		
	//-----------------------------------------------------
	// Calling each method to check neighborhood in each direction)
	// If the method returns "neighborhood" as false then the method
	// terminates and "neighborhood" is returned else if there exists 
	// neighborhood in all four directions then "neighborhood" will
	// be returned as true
	//-----------------------------------------------------
		
		if (!(this.checkUpward(list1, matrixb))) return neighborhood;
		else if (!(this.checkDownward(list1, matrixb))) return neighborhood;
		else if (!(this.checkRight(list1, matrixb))) return neighborhood;
		else if (!(this.checkLeft(list1, matrixb))) return neighborhood;
		else return neighborhood;
	}
	
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	
//-------------------------------------------------------
// Purpose: Checks neighborhood upwards (over the list)
// Function: to check upward neighborhood I considered the 
//           index values of the list. For example to check 
//           whether the node of index (1,1) in list2 has neighborhood
//           upwards the method will consider the index (0,1) in which
//           it decrements the value of the first part of the index by 1.
//           Then if that index (0,1) is present in lists1 and the matrix
//           "neighborhood" will be true. But, if it's not found in those 
//           lists then we have to check if the list above (1,1) is also
//           in list2. In that case we change our pointer's location to 
//           that node and repeat the same process until the index checked
//           does not exist in ANY LIST, then neighborhood will be false
//-------------------------------------------------------		
	
	private boolean checkUpward(LinkedList list1, LinkedList matrixb)
	{
		
	//-------------------------------------------------------
	// The first part of the index as integer
	//-------------------------------------------------------

		int firstindex; 
		
	//-------------------------------------------------------
	// The second part of the index as integer
	//-------------------------------------------------------
		
		int secondindex;
	
	//-------------------------------------------------------
	// The index of the node whose neighborhood with the list 
	// will be checked
	//-------------------------------------------------------
		
		String index_ToCheck; 
		
	//-------------------------------------------------------
	// Since we will check upward neighborhood throughout all the
	// list we will check the neighborhood over each node. Thus, we 
	// will iterate through each node in the list and the "pointer"
	// will point to the node we are at
	//-------------------------------------------------------
		
		Node_Q1B pointer = this.head;
		
	//-------------------------------------------------------
	// Iterating till the end of the list using a while-loop
	//-------------------------------------------------------
		
		while (pointer != null)
		{
			
		//-------------------------------------------------------
		// The pointer now is pointing to a node. Thus, here we take 
		// the first part of the index of that node (as String) and 
		//convert it to integer using "Integer.parseInt" method
		// Note: check "getFirstIndex()" method in "Node_Q1B" class
		//-------------------------------------------------------
			
			firstindex = Integer.parseInt(pointer.getFirstIndex());
			
			
		//-------------------------------------------------------
		// And here we take the second part of the index using the 
		// technique above
		// Note: check "getSecondIndex()" method in "Node_Q1B" class 
		//-------------------------------------------------------		
		
			secondindex = Integer.parseInt(pointer.getSecondIndex());
			
			
		//-------------------------------------------------------
		// Decrementing the first index by one to get the node above 
		// the pointer
		//-------------------------------------------------------
			
			--firstindex;
			
			
		//-------------------------------------------------------
		// Writing the whole index in its standard String format
		// to check its existence in other lists
		//-------------------------------------------------------
			
			index_ToCheck = firstindex + "," + secondindex;
			
			
		//-------------------------------------------------------
		// Searching for that index in the first list and in matrixb
		// as well using "LinearSearch" method". If it exists then 
		// "neighborhood" will be set as true and the next node on the 
		// list (if it exists) will be considered for the same process 
		// Note: check "LinearSearch" method below for details
		//-------------------------------------------------------
			
			if (list1.LinearSearch(index_ToCheck) && matrixb.LinearSearch(index_ToCheck))
			{
				neighborhood = true;
				pointer = pointer.getNext();
			}
		
			
		//-------------------------------------------------------
		// If the index we are searching for is not in the above 
		// lists then we check if it is part of the same list. If
		// that is the case then we check for the next node
		//-------------------------------------------------------
			
			else if (this.LinearSearch(index_ToCheck))
			{
				pointer = pointer.getNext();
			}
			
			
		//-------------------------------------------------------
		// If the index does not belong to any list then "neighborhood"
		// would definitely be false
		//-------------------------------------------------------
			
			else 
			{
				neighborhood = false;
				pointer = null;
			}
		}
		
		
	//-------------------------------------------------------
	// We return the boolean "neighborhood" after checking upward
	// neighborhood over all nodes on the list
	//-------------------------------------------------------
		
		return neighborhood;
	}
	
	
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


//-------------------------------------------------------
// Purpose: Checks neighborhood downwards (under the list)
// Function: This method functions similar to the "checkUpward"
//          method but instead of decrementing the first part of 
//          the index by one it increments it by one
//-------------------------------------------------------
	
	private boolean checkDownward(LinkedList list1, LinkedList matrixb)
	{
		int firstindex; 
		int secondindex;
		String index_ToCheck; 
		
		Node_Q1B pointer = this.head;
		
		while (pointer != null)
		{
			firstindex = Integer.parseInt(pointer.getFirstIndex());
			secondindex = Integer.parseInt(pointer.getSecondIndex());
			++firstindex;
			index_ToCheck = firstindex + "," + secondindex;
			
			if (list1.LinearSearch(index_ToCheck) && matrixb.LinearSearch(index_ToCheck))
			{
				neighborhood = true;
				pointer = pointer.getNext();
			}
			
			else if (this.LinearSearch(index_ToCheck))
			{
				pointer = pointer.getNext();
			}
			
			else 
			{
				neighborhood = false;
				pointer = null;
			}
		}
			
			return neighborhood;
	}
	
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


//-------------------------------------------------------
// Purpose: Checks neighborhood leftwards (to the left of the list)
// Function: This method functions similar to the "checkUpward"
//           method but instead of decrementing the first part of 
//           the index by one it increments the second part of
//           the index by one
//-------------------------------------------------------

	
	private boolean checkRight(LinkedList list1, LinkedList matrixb)
	{
		int firstindex; 
		int secondindex;
		String index_ToCheck; 
		
		Node_Q1B pointer = this.head;
		
		while (pointer != null)
		{
			firstindex = Integer.parseInt(pointer.getFirstIndex());
			secondindex = Integer.parseInt(pointer.getSecondIndex());
			++secondindex;
			index_ToCheck = firstindex + "," + secondindex;
			
			if (list1.LinearSearch(index_ToCheck) && matrixb.LinearSearch(index_ToCheck))
			{
				neighborhood = true;
				pointer = pointer.getNext();
			}
			
			else if (this.LinearSearch(index_ToCheck))
			{
				pointer = pointer.getNext();
			}
			
			else 
			{
				neighborhood = false;
				pointer = null;
			}
		}
			
			return neighborhood;
	}
	
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


//-------------------------------------------------------
// Purpose: Checks neighborhood leftwards (to the left of the list)
// Function: This method functions similar to the "checkUpward"
//           method but instead of decrementing the first part of 
//           the index by one it decrements the second part of
//           the index by one
//-------------------------------------------------------
	
	private boolean checkLeft(LinkedList list1, LinkedList matrixb)
	{
		int firstindex; 
		int secondindex;
		String index_ToCheck; 
		
		Node_Q1B pointer = this.head;
		
		while (pointer != null)
		{
			firstindex = Integer.parseInt(pointer.getFirstIndex());
			secondindex = Integer.parseInt(pointer.getSecondIndex());
			--secondindex;
			index_ToCheck = firstindex + "," + secondindex;
			
			if (list1.LinearSearch(index_ToCheck) && matrixb.LinearSearch(index_ToCheck))
			{
				neighborhood = true;
				pointer = pointer.getNext();
			}
			
			else if (this.LinearSearch(index_ToCheck))
			{
				pointer = pointer.getNext();
			}
			
			else 
			{
				neighborhood = false;
				pointer = null;
			}
		}
			
			return neighborhood;
	}
	
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


//-------------------------------------------------------
// Purpose: Searches for an index value in a linked list 
// Function: This method takes an index String as a parameter 
//           and using Linear Search method, checks whether
//           the given index is found in list or not. The method
//           iterates through the list node by node using a 
//           while-loop and since indices are String attributes
//           it uses the String method named "equals" to compare
//           the given index with the index stored at each node. 
//           The loop will keep iterating until it finds the given 
//           index in the list ("found" will be true) or until
//           there are no more nodes in the list to check ("found"
//           will be false). Lastly, the boolean "found" is returned
//           
// Note: check "Node_Q1B" class for details about "getIndex()" method, 
//       "getNext()" method, and the "index" attribute     
//-------------------------------------------------------
	
	private boolean LinearSearch(String index)
	{
		boolean found = false;
		Node_Q1B pointer = this.head;
		
		
		while ((pointer != null))
		{
			if ((pointer.getIndex()).equals(index))
			{
				found = true;
				pointer = null;
			}
			
			else 
			{
				pointer = pointer.getNext();
			}
			
			
		}
		
		return found;
	}
	
	
	
	
	
	
	
	
}
