
public class MyDynamicQueue implements MyQueue {

	//--------------------------------------------------
	// Attributes
	//--------------------------------------------------
	private MyNode head;
	private int numItems;
	
	//-------------------------------------------------------------------
	// Basic Operation --> Check if MyQueue is empty: myCreateEmpty
	//-------------------------------------------------------------------		
	public MyDynamicQueue(){
		this.numItems = 0;
		this.head = null;
	}

	//-------------------------------------------------------------------
	// Basic Operation --> Check if MyQueue is empty: isEmpty
	//-------------------------------------------------------------------	
	public boolean isEmpty(){
		return (this.numItems <= 0);
	}
	
	//-------------------------------------------------------------------
	// Basic Operation (Partial) --> Get first element from front of MyQueue: first
	//-------------------------------------------------------------------
	public int first(){
		if (!(this.numItems <= 0))
			return this.head.getInfo();

		// Return -1 if there are no items
		return -1;
	}

	//-------------------------------------------------------------------
	// Basic Operation --> Add element to back of MyQueue: add 
	//-------------------------------------------------------------------
	public void add(int element){
		//-----------------------------
		// I. SCENARIO IDENTIFICATION
		//-----------------------------
		int scenario = 0;

		// 1 - Instantiate two new MyNode object / 1 for current node 1 aux node
		MyNode current = new MyNode(element, null);;
		MyNode node = null;

		// 2 - Test for num items
		switch (this.numItems) {
			// 2.1 - There are 0 items in the queue
			case 0:
				scenario = 1;
				break;

			// 2.2 - There are more than 1 items in the queue
			default:
				scenario = 2;
				break;
		}


		//-----------------------------
		// II. SCENARIO IMPLEMENTATION
		//-----------------------------
		switch (scenario) {
			// 2.1 - Set new MyNode to head since this is the first item in the queue
			case 1:
				head = current;
				break;


			// 2.2 - Set the new MyNode to the 'next' of the head and the next node
			case 2:
				// 2.2.1 - Set aux node to this queue's head
				node = this.head;

				// 2.2.2 - Iterate through all nodes until null is found
				while(node.getNext() != null)
					// 2.2.2.1 - Set aux node to its next node
					node = node.getNext();

				// 2.2.3 - Set aux node's next to current
				node.setNext(current);
				break;
		}

		// Increment the numItems by 1
		this.numItems++;

	}
	
	//-------------------------------------------------------------------
	// Basic Operation (Partial) --> Remove element from front of MyQueue: remove 
	//-------------------------------------------------------------------	
	public void remove(){
		//-----------------------------
		// I. SCENARIO IDENTIFICATION
		//-----------------------------
		int scenario = 0;

		// 1 - Set scenario to 1 if queue is empty, set to 2 if not.
		scenario = (!this.isEmpty()) ? 1 : 2;


		//-----------------------------
		// II. SCENARIO IMPLEMENTATION
		//-----------------------------
		switch (scenario) {
			// 1.1 - The queue has items in it
			case 1:
				// 1.1.1 - Set head to its 'next' MyNode obj
				this.head = this.head.getNext();

				// 1.1.2 - Decrement num items by 1
				this.numItems--;
				break;

			// 1.2 - The queue is empty, we print an error message
			case 2:
				System.out.println("Sorry, the queue is already empty.");
				break;
		}
	}
}