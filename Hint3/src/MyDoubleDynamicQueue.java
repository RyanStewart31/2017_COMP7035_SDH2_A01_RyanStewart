
public class MyDoubleDynamicQueue<T> implements MyQueue<T> {

	//--------------------------------------------------
	// Attributes
	//--------------------------------------------------
	private int numItems;
	private MyDoubleLinkedNode<T> head;
	private MyDoubleLinkedNode<T> tail;

	//-------------------------------------------------------------------
	// Basic Operation --> Check if myQueue is empty: myCreateEmpty
	//-------------------------------------------------------------------
	public MyDoubleDynamicQueue(){
		this.numItems = 0;

		// Instantiate head
		this.head = new MyDoubleLinkedNode<>(null, null, null);

		// Set tail equal to head in order to link head to tail
		this.tail = this.head;
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
		//-----------------------------
		// I. SCENARIO IDENTIFICATION
		//-----------------------------
		int scenario = 0;


		// 1 - Had contains a node
		if (this.head.getInfo() != null)
			scenario = 1;


		//-----------------------------
		// II. SCENARIO IMPLEMENTATION
		//-----------------------------
		switch (scenario) {
			// 1 - Head contains node
			case 1:
				return this.head.getInfo();

			// Print error and return null
			default:
				System.out.println("Sorry, the queue is empty.");
				return null;
		}
	}

	//-------------------------------------------------------------------
	// Basic Operation --> Add element to back of MyQueue: addByFirst
	//-------------------------------------------------------------------
	public void addByFirst(T element){
		//-----------------------------
		// I. SCENARIO IDENTIFICATION
		//-----------------------------
		int scenario = 0;

		// 1 - Instantiate two new MyNode object / 1 for current node 1 aux node
		MyDoubleLinkedNode<T> current = new MyDoubleLinkedNode<T>(null, element, this.head);

		// 2 - Test for num items
		if (this.head.getInfo() != null)
			scenario = 1;
		else
			scenario = 2;


		//-----------------------------
		// II. SCENARIO IMPLEMENTATION
		//-----------------------------
		switch (scenario) {
			// 2.1 - Set new MyNode to head since this is the first item in the queue
			case 1:
				// 2.1.1 - Set head to the new current node
				this.head.setLeft(current);
				this.head = current;
				break;


			// 2.2 - There is only 1 node in the queue
			case 2:
				this.head.setInfo(element);
				break;
		}

		// Increment the numItems by 1
		this.numItems++;
	}

	//-------------------------------------------------------------------
	// Basic Operation (Partial) --> Remove element from front of MyQueue: removeByFirst
	//-------------------------------------------------------------------
	public void removeByFirst(){
		//-----------------------------
		// I. SCENARIO IDENTIFICATION
		//-----------------------------
		int scenario = 0;

		// 1 - If head is tail
		if (this.head == this.tail)
			scenario = 1;

		// 2 - if head is empty
		else if (this.head.getInfo() == null)
			scenario = 2;

		// 3 - There are nodes in the queue
		else
			scenario = 3;

		//-----------------------------
		// II. SCENARIO IMPLEMENTATION
		//-----------------------------
		switch (scenario) {
			// 1 - Head is set to tail
			case 1:
				// 1.1 - Set head info to null deleting the node
				this.head.setInfo(null);

				// 1.2 - Decrement numItems
				this.numItems--;
				break;


			// 2 - Head is empty
			case 2:
				// 2.1 - Print an error message
				System.out.println("Sorry, the queue is already empty.");
				break;


			// 3 - There are nodes in the queue, let's remove some nodes!
			case 3:
				// 3.1 - Set head equal to its right node
				this.head = this.head.getRight();

				// 3.2 - Set head's left node to null
				this.head.setLeft(null);

				// 3.3 - Decrement numItems
				this.numItems--;
				break;
		}
	}

	//-------------------------------------------------------------------
	// Basic Operation (Partial) --> Get first element from front of MyQueue: last
	//-------------------------------------------------------------------
	public T last(){
		//-----------------------------
		// I. SCENARIO IDENTIFICATION
		//-----------------------------
		int scenario = 0;

		if (this.tail.getInfo() != null)
			// 1 - There are nodes in the queue
			scenario = 1;


		//-----------------------------
		// II. SCENARIO IMPLEMENTATION
		//-----------------------------
		switch (scenario) {
			// 1.1 - Tail contains node
			case 1:
				return this.tail.getInfo();

			// Print error and return null
			default:
				System.out.println("Sorry, the queue is empty.");
				return null;
		}
	}

	//-------------------------------------------------------------------
	// Basic Operation --> Add element to back of MyQueue: addByLast
	//-------------------------------------------------------------------
	public void addByLast(T element){
		//-----------------------------
		// I. SCENARIO IDENTIFICATION
		//-----------------------------
		int scenario = 0;

		// 1 - Instantiate new MyNode object
		MyDoubleLinkedNode<T> current = new MyDoubleLinkedNode<T>(this.tail, element, null);

		if (this.tail.getInfo() != null)
			// 1 - There is a node in tail
			scenario = 1;


		//-----------------------------
		// II. SCENARIO IMPLEMENTATION
		//-----------------------------
		switch (scenario) {
			// 1 - There is a node in tail
			case 1:
				// 1.1 - Set tail's right node to new current node
				this.tail.setRight(current);

				// 1.2 - Set tail to new current node
				this.tail = current;
				break;


			// There is only 1 node in the queue as tail is empty
			default:
				// Set tail's info to new element
				this.tail.setInfo(element);
				break;
		}

		// Increment the numItems by 1
		this.numItems++;
	}

	//-------------------------------------------------------------------
	// Basic Operation (Partial) --> Remove element from front of MyQueue: removeByFirst
	//-------------------------------------------------------------------
	public void removeByLast(){
		//-----------------------------
		// I. SCENARIO IDENTIFICATION
		//-----------------------------
		int scenario = 0;


		if (this.head == this.tail)
			// 1 - head is equal to tail: 1 node in the queue
			scenario = 1;

		else if (this.tail.getInfo() == null)
			// 2 - Tail is empty
			scenario = 2;

		else
			// 3 - There is more than 1 node in the queue
			scenario = 3;


		//-----------------------------
		// II. SCENARIO IMPLEMENTATION
		//-----------------------------
		switch (scenario) {
			// 1 - Head is equal to tail: 1 node in the queue
			case 1:
				// 1.1 - Set tail's info to null
				this.tail.setInfo(null);

				// 1.2 - Decrement numItems
				this.numItems--;
				break;


			// 2 - The queue is empty
			case 2:
				// 2.1 - Print error message
				System.out.println("Sorry, the queue is empty.");
				break;


			// 3 - There is more than 1 node in the queue
			case 3:
				// 3.1 - Set tail to its left node
				this.tail = this.tail.getLeft();

				// 3.2 - Set tail's right node to null
				this.tail.setRight(null);

				// 3.3 - Decrement numItems
				this.numItems--;
				break;
		}
	}
}
