package Assignment1;

public class Node_Q1B {

	//-----------------------------------------------------
	// Title: Question 1 - Part A
	// Author: Basme Zantout
	// Description: This is the class used by Question 1 (Part B) which is
	//              a Node class that creates a Node and has the required
	//              getter and setter methods for it. It also does the required
	//              modifications to the data stored in a node
	//-----------------------------------------------------

		
		
//-------------------------------------------------------
// Attribute: the "index" or the information (index of the 
//            elements in the list) that will be carried by 
//            each node in the list
// Note: it is a String value
//-------------------------------------------------------
	
	private String index;
	
	
//-------------------------------------------------------
// Attribute: a String that holds the first part of the 
//            index (e.g. for the index "0,1" the "FirstIndex"
//            is the "0")
//-------------------------------------------------------
	
	private String FirstIndex;
	
	
//-------------------------------------------------------
// Attribute: a String that holds the second part of the 
//	            index (e.g. for the index "0,1" the 
//              "SecondIndex" is the "1")        
//-------------------------------------------------------
	
	private String SecondIndex;
	
	
//-------------------------------------------------------
// Attribute: the "data" or the information (integer number)
//	            that will be carried by each node in the list
// Note: the data are the number values of the matrix 
//-------------------------------------------------------
	
	private int data;
	
	
//-------------------------------------------------------
// Attribute: the "next" node in the list (since each node 
//            holds the address of the node next to it)
//-------------------------------------------------------
	
	private Node_Q1B next;
	
	
//-----------------------------------------------------
// Constructor: Creates a single node with no current data
//              (index data) and no node next to it
//-----------------------------------------------------
	
	public Node_Q1B()
	{
		index = null;
		next = null;
	}
	
	
//-----------------------------------------------------
// Constructor: Creates a single node with data (index
//              data) passed as parameter            
//-----------------------------------------------------
	
	public Node_Q1B(String index) 
	{
		this.index = index;
		this.next = null;
	}
	
	
//-----------------------------------------------------
// Constructor: Creates a single node with data (number
//	              data) passed as parameter
// Note: the "matrixb" list will have both the values of
//       the integer numbers in the matrix and their corresponding
//       indices. 
//-----------------------------------------------------
	
	public Node_Q1B(int data)
	{
		this.data = data;
		index = null;
	}
	
	
//-----------------------------------------------------
//  Getter: returns the node next to the one calling 
//          the method
//-----------------------------------------------------
	
	public Node_Q1B getNext()
	{
		return next;
	}
	
	
//-----------------------------------------------------
//  Setter: sets the next node (node passed as parameter)
//-----------------------------------------------------
	
	public void setNext(Node_Q1B next)
	{
		this.next = next;
	}
	
	
//-----------------------------------------------------
//  Setter: sets data to a node (data passed as parameter)
//-----------------------------------------------------
	
	public void setData(int data)
	{
		this.data = data;
	}
	

//-----------------------------------------------------
//  Getter: returns the index value in a node
//-----------------------------------------------------
	
	public String getIndex()
	{
		return index;
	}
	
	
//-----------------------------------------------------
//  Setter: sets index value to a node (index passed as parameter)
//-----------------------------------------------------
	
	public void setIndex(String index)
	{
		this.index = index;
	}
	
	
//-----------------------------------------------------
//  Setter: sets index value to a node (index passed as parameter)
//  Note: the "setIndex" method is overloaded the
//        "setIndex(String index)" method takes the whole
//        index as parameter and assigns it to the node while
//        this overloaded method assigns the index by combining
//        both the first part and second part of that index in the 
//        specified format (e.g. "2,1")
//-----------------------------------------------------
	
	public void setIndex(String firstindex, String secondindex)
	{
		FirstIndex = firstindex;
		SecondIndex = secondindex;
		index = firstindex + "," + secondindex;
	}
	
	
//-----------------------------------------------------
//  Getter: returns the first part of the index value 
//          in a node which will be used in neighborhood
//          checking methods
//-----------------------------------------------------

	public String getFirstIndex()
	{
		
	//-----------------------------------------------------
	// Get the first character in the index and convert it  
	// to String 
	//-----------------------------------------------------
		FirstIndex = String.valueOf(index.charAt(0));
		return FirstIndex;
	}
	
	
//-----------------------------------------------------
//  Getter: returns the second part of the index value 
//          in a node which will be used in neighborhood
//          checking methods
//-----------------------------------------------------
	
	public String getSecondIndex()
	{
		
	//-----------------------------------------------------
	// Get the second character in the index and convert it 
	// toString 
	//-----------------------------------------------------
		SecondIndex = String.valueOf(index.charAt(2));
		return SecondIndex;
	}

}
