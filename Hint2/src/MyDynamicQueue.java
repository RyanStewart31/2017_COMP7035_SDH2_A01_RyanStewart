
public class MyDynamicQueue implements MyQueue {

	//--------------------------------------------------
	// Attributes
	//--------------------------------------------------
	private MyNode last;
	private MyNode head;
	private int numItems;
	
	//-------------------------------------------------------------------
	// Basic Operation --> Check if MyQueue is empty: myCreateEmpty
	//-------------------------------------------------------------------		
	public MyDynamicQueue(){
		this.numItems = 0;
		this.last = null;
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
		return this.head.getInfo();
	}

	//-------------------------------------------------------------------
	// Basic Operation --> Add element to back of MyQueue: add 
	//-------------------------------------------------------------------
	public void add(int element){
		//-----------------------------
		// I. SCENARIO IDENTIFICATION
		//-----------------------------
		int scenario = 0;

		// 1 - Instantiate a new MyNode object
		MyNode node = new MyNode(element, null);

		// 2 - Test for num items
		switch (this.numItems) {
			// 2.1 - There are 0 items in the queue
			case 0:
				scenario = 1;
				break;


			// 2.2 - There is just 1 in the queue
			case 1:
				scenario = 2;
				break;


			// 2.3 - There are more than 1 items in the queue
			default:
				scenario = 3;
				break;
		}

		
		//-----------------------------
		// II. SCENARIO IMPLEMENTATION
		//-----------------------------
		switch (scenario) {
			// 2.1 - Set new MyNode to head since this is the first item in the queue
			case 1:
				this.head = node;
				break;

			// 2.2 - Set the new MyNode to the 'next' of the head and the next node
			case 2:
				this.head.setNext(node);
				this.last = node;
				break;

			// 2.3 - Set the new MyNode to the 'next' of the previous node and replace the 'next' with the new node
			case 3:
				this.last.setNext(node);
				this.last = node;
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