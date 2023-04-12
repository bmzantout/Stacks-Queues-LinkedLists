package Assignment1;


public class Node {
	
	//-----------------------------------------------------
	// Title: Question 1 - Part A
	// Author: Basme Zantout
	// Description: This is the class used by Question 1 (Part A) which is
	//              a Node class that creates a Node and has the required
	//              getter and setter methods for it.
	//-----------------------------------------------------

		
		
//-------------------------------------------------------
// Attribute: the "data" or the information (integer number)
//            that will be carried by each node in the list
//-------------------------------------------------------
	
	private int data;
	
//-------------------------------------------------------
// Attribute: the "next" node in the list (since each node 
//            holds the address of the node next to it)
//-------------------------------------------------------

	private Node next;
	
//-------------------------------------------------------
// Attribute: the "previous" node in the list (since a node 
//	          in a DOUBLY linked list holds the address of 
//            the node before to it as well)
//-------------------------------------------------------
	
	private Node previous;
	
	
//-----------------------------------------------------
// Constructor: Creates a single node with no current 
//              data and no node next to it             
//-----------------------------------------------------
	
	public Node()
	{
		data = 0;
		next = null;
	}
	
	
//-----------------------------------------------------
// Constructor: Creates a single node with data  passed 
//              as parameter            
//-----------------------------------------------------
	
	public Node(int data) 
	{
		this.data = data;
		next = null;
	}
	
	
//-----------------------------------------------------
//  Getter: returns the data in a node
//-----------------------------------------------------
	
	public int getData()
	{
		return data;
	}
	
	
//-----------------------------------------------------
//  Getter: returns the node next to the node that calls 
//          the method
//-----------------------------------------------------
	
	public Node getNext()
	{
		return next;
	}
	
	
//-----------------------------------------------------
//  Getter: returns the node before the node that calls 
//          the method
//-----------------------------------------------------
	
	public Node getPrevious()
	{
		return previous;
	}
	
	
//-----------------------------------------------------
//  Setter: sets data to a node (data passed as parameter)
//-----------------------------------------------------
	
	public void setData(int data)
	{
		this.data = data;
	}
	
	
//-----------------------------------------------------
//  Setter: sets the next node (node passed as parameter)
//-----------------------------------------------------
	
	public void setNext(Node next)
	{
		this.next = next;
	}
	
	
//-----------------------------------------------------
//  Setter: sets the previous node (node passed as parameter)
//-----------------------------------------------------
	
	public void setPrevious(Node previous)
	{
		this.previous = previous;
	}
}
