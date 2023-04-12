package Assignment1;

public class DoubleLinkedList {


	//-----------------------------------------------------
	// Title: Question 1 - Part A
	// Author: Basme Zantout
	// ID: 99227947762
	// Section: 1
	// Assignment: 1
	// Description: This is the class used by Question 1 (Part A) which is
	//              a DoubleLinkedList class that creates Double linked lists
	//              from nodes (it directly depends on the Node.java class)
	//              and has methods that print and return a matrix in spiral 
	//              form using Double Linked List Data Structure 
	//-----------------------------------------------------

	
	
//-------------------------------------------------------
// Attribute: the "head" or first node of the linked list   
//-------------------------------------------------------
	
	private Node head;
	
	
//-------------------------------------------------------
// Attribute: the "tail" or last node of the linked list   
//-------------------------------------------------------
		
	private Node tail;
	

//-------------------------------------------------------
// Attribute: the number of rows found in the matrix (used
// for calculations to get the spiral form of the matrix)
//-------------------------------------------------------
			
	private int rowNumber;
	
	
//-------------------------------------------------------
// Attribute: In order to get the elements in spiral form we 
// will be iteration through the Double linked list from head 
// to tail then from tail to head and repeat this process until 
// the list is empty. Thus, to specify the direction this int 
// variable will be set to "1" when we need to go  in the 
// direction from head to tail and "-1" when we need to go the 
// opposite direction (from tail to head)
//-------------------------------------------------------
			
	private int Head_Tail_Alternation;
	

//-------------------------------------------------------
// Attribute: the "checker" will be the pointer that points
// to each node one by one as we iterate through the linked list
//-------------------------------------------------------
					
	private Node checker;
	
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	
//-------------------------------------------------------
// Constructor: Default constructor in which the "head" and 
// "tail" nodes are set to null since the list is initially 
// empty, the rowNumber is initially set to 0, and the
// "Head_Tail_Alternation" is set to 1 because our initial 
// iterating direction will be from head to tail.
//-------------------------------------------------------	
	
	public DoubleLinkedList()
	{
		head = null;
		tail = null;
		rowNumber = 0;
		Head_Tail_Alternation = 1;
	}
	
	
//-------------------------------------------------------
// Purpose: checks whether the Linked List it empty or not
// Function: if the "head" or the beginning of the list is 
//           null then the list is empty and it returns true.
//           Otherwise, if the "head" exists then it returns 
//           false meaning that it's not empty.
//-------------------------------------------------------
			
	private boolean isEmpty()
	{
		if (head == null)
			return true;
		else 
			return false;
	}
	
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	

//-------------------------------------------------------
// Purpose: adds a node to the end of the list
// Function: if the list is not empty then it adds a node 
//           after the tail and makes this new node the tail. 
//           Otherwise, if it's empty it sets this new node as
//           the tail and head as well.
// Note: we are using the "setNext(Node n)" and "setPrevious(Node n)"
//       methods from the Node.java class
//-------------------------------------------------------
		
	private void addLast(int newdata)
	{
		Node newNode = new Node(newdata);
		
		if (!isEmpty())
		{
			tail.setNext(newNode);
			newNode.setPrevious(tail);
			tail = newNode;
		}
		
		else
		{
			head = tail = newNode;
		}
	}
	

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	
//-------------------------------------------------------
// Purpose: removes the first node in the linked list
// Function: we assign a temporary node to the "head" or 
//           first node and we let the second node in the 
//           list be the "head" (meaning the first). Then, 
//           we remove the link between  the old first node and 
//           the rest of the list using the temporary node "temp"
//           and methods from the class Node.java (like: "getNext()" 
//           and "setPrevious(Node n)")
//-------------------------------------------------------

	private void removeFirst() 
	{
		Node temp = head;
		head = temp.getNext();
		temp.setNext(null);
		head.setPrevious(null);
	}
	

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	
//-------------------------------------------------------
// Purpose: store the value of a 2D-array to a linked list
//          in ordinary, non-spiral order.
// Function: using a nested for-loop, we iterate through each
//           and every element in the array going column by column 
//           and then using the "addLast(int newdata)" method explained 
//           above we keep adding the elements to the list one by one 
//           until we are done with all the elements.
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
	// Note: In this method we also get the "rowNumber" of the 
	// matrix which as previously explained denotes the number of 
	// rows found in the matrix.
	//-------------------------------------------------------

		rowNumber = array.length;
	}
	
	
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	

//-------------------------------------------------------
// Purpose: it returns a linked list that will hold the
//          elements of the matrix in spiral form.
// Function: the main concept of this method is that we have a linked 
//           list in NONSPIRAL form that calls this method and another
//           list created by this method that will hold the values in 
//           SPIRAL form. Thus, as we go through the method's algorithms,
//           we will be REMOVING specific elements from the non-spiral list 
//           and ADDING them to the spiral list.
// Note: we will be also going back and forth (from head to tail then from 
//       tail to head) over and again in the non-spiral list while removing and 
//       adding specific elements until the non-spiral list is empty and thus,
//       the spiral list has all the elements in spiral form. (we will be using 
//       the Head_Tail_Alternation variable for this).
//-------------------------------------------------------
						
	
	public DoubleLinkedList SpiralForm()
	{
		
		
	//-------------------------------------------------------
	// Instantiation the Double Linked List called "SpiralList"
	// that will hold the values in spiral form 
	//-------------------------------------------------------
			
		DoubleLinkedList SpiralList = new DoubleLinkedList();
		
		
	//-------------------------------------------------------
	// In this while we are removing the first "i" elements from 
	// the nonspiral list and adding them to the spiral list, such
	// that "i" is the row number of the matrix. e.g. if the matrix
	// consists of 3 rows then we remove the first 3 items from the
	// nonspiral list and add them one after the other to the spiral 
    // list
	//-------------------------------------------------------
		int i = 1;
		
		while (i <= rowNumber)
		{
			
		//-------------------------------------------------------
		// This if-else statement checks the values of the elements we 
	    // are iterating over. Thus, if the value is -1 it will return 
		// the "SpiralList" and the method will terminate. It does so by
	    // calling the method "END(int data)" which returns a false or true 
		// boolean if the value of the elements is -1 or not, respectively
		// Note: check END(int data) method for details!
		//-------------------------------------------------------
			
			if (END(this.head.getData()))
			{
				
				
			//-------------------------------------------------------
			// Adding the "head" element of the NONSPIRAL list to the
			// end of the SPIRAL list
			// Note: check addLast(int newdata) method for details!
			//-------------------------------------------------------
				
				SpiralList.addLast(this.head.getData());
				
				
			//-------------------------------------------------------
			// The element that we just added to the spiral list is 
			// being removed from the nonspiral list
			// Note: check "removefirst()" method for details!
			//-------------------------------------------------------
				
				this.removeFirst();
				
				++i;
			}
			
			else  return SpiralList;	
		}
		
		
	//-------------------------------------------------------
	// Now our attribute "checker" is being  set to head so we 
	// iterate through the list starting from its head 
	// Note: check Attributes for the use of "checker" variable!
	//-------------------------------------------------------
		
		checker = head;
		
		
	//-------------------------------------------------------
	// Notice that we also decremented the row number by 1. The
	// reason behind this is explained in the next comment
	//-------------------------------------------------------
		
		--rowNumber;
		
		
	//-------------------------------------------------------
	// This is the most significant nested-loop in the method.
	// Function: First, let's consider the example that the row
	// number of the matrix was initially 3 and we decremented it
	// by 1 in the code line above, so it's now "2". And, this loop 
	// will start iterating from the head in which the checker is 
	// at the beginning of the non-spiral list. So, considering 
	// the row number is "2", the "checker" will skip 2 elements from
	// the non-spiral list and move to the third. Once it's at the third
	// element it will take it from the NONSPIRAL list to the SPIRAL
	// list by the "addLast()" and "removeAt()" methods, then, it will
	// do the same process again and again skipping two and getting the
	// third until we reach the tail or the list becomes empty. Now, if
	// we reach the tail, we will also take elements as much as the 
	// row number (the last 2 elements i this example) then we will 
	// decrement the row number by 1 again so it will be "1" and we will 
	//start moving backwards from tail to head doing the same process but 
	// this time skipping 1 element and getting the second. The loop will 
	//terminate when the list is empty or when we see a -1 value.
	//
	// Important NOTE: when the row number is 0 we take all elements
	//                 without skipping
	//-------------------------------------------------------
			
		while (!isEmpty())
		{
			
		//-------------------------------------------------------
		// The "i" will let us know at which element we are. It 
		// helps us in skipping elements and getting the ones we need
		//-------------------------------------------------------
			
			i = 0;
			
		//-------------------------------------------------------
		// Precondition: as long as "i" is less than the row number
		//               and the "checker" is not pointing to a null 
		//               Node, enter the while loop
		//-------------------------------------------------------
			
			while ((i <= rowNumber) && (checker != null))
			{
				
			//-------------------------------------------------------
			// Postcondition (1): if "i" equals the row number...
			//-------------------------------------------------------
				
				if (i == rowNumber)
				{
					
				//-------------------------------------------------------
				// ...and if "i" points to a value other than -1, then take 
				// the data in the "i"th place from the nonspiral list and 
				// add it to the spiral list
				//-------------------------------------------------------
					
					if(END(checker.getData()))
					{
						
						SpiralList.addLast(checker.getData());
						
						
					//-------------------------------------------------------
					// Notice that we used "removeAt(Node toremove)" method this
					// time to remove the element from the non-spiral list because
					// we are removing an element in the middle of the list
					// Note(1): this method let's the "checker" point to the next element
					// Note(2): check "removeAt(Node toremove)" method for details!
					//-------------------------------------------------------
				
						checker = this.removeAt(checker);
						
					//-------------------------------------------------------
					// increment i by 1 so we move to the next element
					//-------------------------------------------------------
					
						++i;
					}
					
				//-------------------------------------------------------
				// If the value is -1 terminate the method and return the
				// spiral list
				//-------------------------------------------------------
			
					else  return SpiralList;
					
				}
				
				
			//-------------------------------------------------------
			// Postcondition (2): Else, if the "i" is not equal to the 
			//                    row number. In other words, if the checker
			//                    is not pointing to the element we need to move, 
			//                    then increment "i" (move to the next element)  
			//                     and check the following:
			//-------------------------------------------------------
				
				else 
				{
					++i;
					
				//-------------------------------------------------------
				// If "Head_Tail_Alternation" is still equal to "1" then 
				// this means we are still iterating from head to tail and 
				// that we have to move to the NEXT element
				//-------------------------------------------------------
			
					if (Head_Tail_Alternation == 1)
					{
						checker = checker.getNext();
					}
					
				//-------------------------------------------------------
				// Else, if Head_Tail_Alterantion is equal to "-1" then this
				// means that we are moving in the opposite direction from 
				// tail to head and that we hae to move to the PREVIOUS element
				//-------------------------------------------------------
					else
					{
						checker = checker.getPrevious();
					}
				}	
			}
			
			//-------------------------------------------------------
			// We check the Head_Tail_Alternation after each time we skip 
		    // elements
		    // Note: check the method below for more details!
			//-------------------------------------------------------
			
			Check_Head_Tail_Alternation(checker, SpiralList, this);
			
	   }
		
		
	//-------------------------------------------------------
	// If the non-spiral list is empty then terminate the method
	// and return the spiral list
	//-------------------------------------------------------
		
		return SpiralList;

	}
	

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	
	
//-------------------------------------------------------
// Purpose: check if the value in a node is -1 or not
// Function: this method returns a boolean. If the data
//           in a node is equal to "-1" it returns false. 
//           Otherwise, it returns true
//-------------------------------------------------------
	
	private boolean END(int data)
	{
		if(data == -1)
			return false;
		else
			return true;
	}
	
	
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	
	
//-------------------------------------------------------
// Purpose: removes a node from the middle of a double
//          linked list
// Function: it returns a node which we consider to be
//           the new position of the "checker". In order to 
//           remove a node from the middle of the list, there
//           are some special cases or conditions that we have 
//           to consider, which are as follows:
//-------------------------------------------------------
	
	private Node removeAt(Node toremove) 
	{
		
		Node toreturn = null;
		
	//-------------------------------------------------------
	// (CASE 1):
	// Precondition (1): if the list is NOT EMPTY
    // Precondition (2): if there exists a node AFTER the one that we want to remove
	// Precondition (3): if there exists a node BEFORE the one that we want to remove
	//-------------------------------------------------------
		
		if (!isEmpty() && (toremove.getNext() != null) && (toremove.getPrevious() != null))
		{
			
			
		//-------------------------------------------------------
		// Postcondition: 
		// 1. Create a node "before" that is the node before the
		//    one that we want to remove
		// 2. Remove the element using "getPrevious()", "getNext()",
		//    "setPrevious(Node n)", and "setNext(Node n)" methods 
		// 3. Check "Head_Tail_Alternation" and return to the checker
		//    the next node or the "before" node, accordingly
		//-------------------------------------------------------
			
			 Node before = toremove.getPrevious();
			 before.setNext(toremove.getNext());
			 (toremove.getNext()).setPrevious(before);
			 toremove.setNext(null);
			 toremove.setPrevious(null);
		
			 if (Head_Tail_Alternation == 1)
			 {
				 toreturn = before.getNext();
			 }
			 else 
			 {
				 toreturn = before;
			 } 
		}
		
		
	//-------------------------------------------------------
	// (CASE 2):
	// Precondition (1): if the list is NOT EMPTY
	// Precondition (2): if there is NO node AFTER the one that we want to remove
	// Precondition (3): if there is NO node BEFORE the one that we want to remove
	//-------------------------------------------------------
			
		else if ((!isEmpty()) && (toremove.getNext() == null) && (toremove.getPrevious() == null))
		{
			
			//-------------------------------------------------------
			// Postcondition: remove the last node in the list!
			//-------------------------------------------------------
			
			head = toremove = null;
			toreturn = null;
		}
		
		
	//-------------------------------------------------------
	// (CASE 3):
	// Precondition (1): if the list is NOT EMPTY
	// Precondition (2): if there is NO node AFTER the one that we want to remove
	//                   (but there is a node before)
	//-------------------------------------------------------
		
		else if ((!isEmpty()) && (toremove.getNext() == null))
        {
			
			
		//-------------------------------------------------------
		// Postcondition: 
		// 1. Create a node "before" that is the node before the
		//    one that we want to remove
		// 2. Remove the element using "getPrevious()", "setPrevious(Node n)",
		//    and "setNext(Node n)" methods 
		// 3. Let the "before" node which is now the last node be the tail
		//    and return it to the checker
		//-------------------------------------------------------
			
        	Node before = toremove.getPrevious();
            before.setNext(null);
        	toremove.setPrevious(null);
        	tail = before;
        	toreturn = before;
	    }
		
		
		
	//-------------------------------------------------------
	// (CASE 4):
	// Precondition (1): if the list is NOT EMPTY
	// Precondition (2): if there is NO node BEFORE the one that we want to remove
	//                   (but there is a node after)
	//-------------------------------------------------------
		
		else if ((!isEmpty()) && (toremove.getPrevious() == null))
		{
			
		//-------------------------------------------------------
		// Postcondition: 
		// 1. Create a node "after" that is the node after the
		//    one that we want to remove
		// 2. Remove the element using "getNext()", "setPrevious(Node n)",
		//    and "setNext(Node n)" methods 
		// 3. Let the "after" node which is now the first node be the head
		//    and return it to the checker
		//-------------------------------------------------------
			
			Node after = toremove.getNext();
			toremove.setNext(null);
			after.setPrevious(null);
			head = after;
			toreturn = after;
			
		}
		
		return toreturn;
	}
	
	
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	
	
//-------------------------------------------------------
// Purpose: it checks the Head_Tail_Alternation and changes 
//          the direction when needed
// Function: Remember when we are at the head we move 
//           "rowNumber" number of elements from the non-spiral
//           to the spiral list (while iterating from  head to tail).
//           Similarly, when we are at the tail  we move 
//           "rowNumber" number of elements from the non-spiral
//           to the spiral list (while iterating from  tail to head).
//           And that's what this method is for!
// Note: After this process we can decrement the row number by 1
//       to continue with the skipping and moving process
//-------------------------------------------------------	
	
	private void Check_Head_Tail_Alternation(Node checker_position, DoubleLinkedList Spiral, DoubleLinkedList NOTSpiral)
	{
		
		
	//-------------------------------------------------------
	// Precondition (1): If the checker is at the tail then:
	// Postcondition (1): If the data in the node is not "-1" then 
    //                    remove "rowNumber" number of elements from
	//                    the non-spiral list and add them to the end
	//                    of the spiral list (removing the nodes at the
	//                    END of the non-spiral list one by one)
	//-------------------------------------------------------
		
		if ((checker_position == tail))
		{
			int i = 1;
			while (i <= rowNumber)
			{
				if (END(checker_position.getData()))
				{
					Spiral.addLast(checker_position.getData());
					checker_position = NOTSpiral.removeAt(checker_position);
					++i;
				}
				else  break;
				
			}
			
		//-------------------------------------------------------
		// This assignment defines the new position of the checker
		//-------------------------------------------------------
				
			checker = checker_position;
			
		//-------------------------------------------------------
		// Postcondition (2): Change the direction of iteration
		//                    "-1" means the direction is now from 
		//                    tail to head and decrement "rowNumber"
		//                    by 1
		//-------------------------------------------------------
			Head_Tail_Alternation = -1;
			
			if (rowNumber > 0)
			{
				--rowNumber;
			}
			
		}
		
	//-------------------------------------------------------
	// Precondition (2): If the checker is at the tail then:
	// Postcondition (1): If the data in the node is not "-1" then 
	//                    remove "rowNumber" number of elements from
	//                    the non-spiral list and add them to the end
	//                    of the spiral list (removing the nodes at the
	//                    BEGINNING of the non-spiral list one by one) 
	//-------------------------------------------------------
		
		else if ((checker_position == head))
		{
			int i = 1;
			while (i <= rowNumber)
			{
				if (END(checker_position.getData()))
				{
					Spiral.addLast(checker_position.getData());
					checker_position = NOTSpiral.removeAt(checker_position);
					++i;
				}
				
				else  break;
				
			}
			
		//-------------------------------------------------------
		// This assignment defines the new position of the checker
		//-------------------------------------------------------
			
			checker = checker_position;
			
		//-------------------------------------------------------
		// Postcondition (2): Change the direction of iteration
		//                    "1" means the direction is now from 
		//                    head to tail and decrement "rowNumber"
		//                    by 1
		//-------------------------------------------------------
			
			Head_Tail_Alternation = 1;
			
			if (rowNumber > 0)
			{
				--rowNumber;
			}	
		}
	}
	
	
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	
	
	//-------------------------------------------------------	
    // Purpose: This public method prints a linked list in a 
    //          specific format e.g. [value1, value2, value3...]
	// Function: using a while we iterate through the loop nodes
	//           one by one starting from the head until the end 
	//           of the list
    //-------------------------------------------------------
	
	public void printDoubleLinkedList ()
	{
		Node n = head;
		
		System.out.print('[');
		
		while (n != null)
		{
			System.out.print(n.getData());
			n = n.getNext();
			if (n != null)
			{
				System.out.print(", ");
			}
		}
		
		System.out.print(']');
	}
	
	
}
