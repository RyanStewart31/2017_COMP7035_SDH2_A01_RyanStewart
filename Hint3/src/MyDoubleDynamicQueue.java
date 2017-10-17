
public class MyDoubleDynamicQueue<T> implements MyQueue<T> {

	//--------------------------------------------------
	// Attributes
	//--------------------------------------------------
	private int numItems;
	private MyDoubleLinkedNode first;
	private MyDoubleLinkedNode last;

	//-------------------------------------------------------------------
	// Basic Operation --> Check if myQueue is empty: myCreateEmpty
	//-------------------------------------------------------------------	
	public MyDoubleDynamicQueue(){
		this.numItems = 0;
		this.first = null;
		this.last = null;
	}

	//-------------------------------------------------------------------
	// Basic Operation --> Check if myQueue is empty: isEmpty
	//-------------------------------------------------------------------	
	public boolean isEmpty(){
		return (this.numItems <= 0);
	}
	
	//-------------------------------------------------------------------
	// Basic Operation (Partial) --> Get first element from front of MyQueue: first
	//-------------------------------------------------------------------
	public T first(){

	}

	//-------------------------------------------------------------------
	// Basic Operation --> Add element to back of MyQueue: addByFirst 
	//-------------------------------------------------------------------
	public void addByFirst(T element){
		//-----------------------------
		// I. SCENARIO IDENTIFICATION
		//-----------------------------
		int scenario = 0;

		// 1 - Instantiate a new MyNode object
		MyDoubleLinkedNode node = new MyDoubleLinkedNode<T>(null, element, null);

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
				this.first = node;
				break;

			// 2.2 - Set the new MyNode to the 'next' of the head and the next node
			case 2:
				this.first.setLeft(node);
				this.last = node;
				break;

			// 2.3 - Set the new MyNode to the 'next' of the previous node and replace the 'next' with the new node
			case 3:
				this.last.setRight(node);
				this.last = node;
				break;
		}

		// Increment the numItems by 1
		this.numItems++;
	}
	
	//-------------------------------------------------------------------
	// Basic Operation (Partial) --> Remove element from front of MyQueue: removeByFirst 
	//-------------------------------------------------------------------	
	public void removeByFirst(){

	}

	//-------------------------------------------------------------------
	// Basic Operation (Partial) --> Get first element from front of MyQueue: last
	//-------------------------------------------------------------------
	public T last(){

	}

	//-------------------------------------------------------------------
	// Basic Operation --> Add element to back of MyQueue: addByLast 
	//-------------------------------------------------------------------
	public void addByLast(T element){

	}
	
	//-------------------------------------------------------------------
	// Basic Operation (Partial) --> Remove element from front of MyQueue: removeByFirst 
	//-------------------------------------------------------------------	
	public void removeByLast(){

	}
}
