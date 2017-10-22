
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
		this.tail = new MyDoubleLinkedNode<>(null, null, null);
		this.head = new MyDoubleLinkedNode<>(null, null, null);
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
		// 1 - Check if there are any nodes
		if (this.numItems > 0)
			return this.head.getInfo();

		// 2 - Return null if there are no items
		return null;
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
		MyDoubleLinkedNode<T> current = new MyDoubleLinkedNode<T>(null, element, null);
		MyDoubleLinkedNode<T> node    = null;

		// 2 - Test for num items
		switch (this.numItems) {
			// 2.1 - There are 0 items in the queue
			case 0:
				scenario = 1;
				break;

			// 2.2 - There is only 1 node in the queue
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
				// 2.1.1 - Set head to the new current node
				this.head = current;
				break;


			// 2.2 - There is only 1 node in the queue
			case 2:
				// 2.2.1
				this.head.setLeft(current);
				// 2.2.2 - Set new current node's left to head
				current.setRight(this.head);

				// 2.2.3 - Set head's right to new current node
				this.head.setRight(current);

				// 2.2.4 - Set head to new current node
				this.head = current;

				// 2.2.5 - set tail to the right of head
				this.tail = this.head.getRight();
				break;


			// 2.3 - Set the new MyNode to the 'next' of the head and the next node
			case 3:
				// 2.3.1 - Set aux node to this queue's head
				node = this.head;

				// 2.3.3 - Set the most 'left' node's left to the new current node
				node.setLeft(current);

				// 2.3.4 - Set the new current node's right to the most 'left' node
				current.setRight(node);

				// 2.3.5 - Set the head to new current node
				this.head = current;
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

		// 1 - Set scenario to 1 if queue is empty, set to 2 if not.
		scenario = (this.numItems >= 0) ? 1 : 2;


		//-----------------------------
		// II. SCENARIO IMPLEMENTATION
		//-----------------------------
		switch (scenario) {
			// 1.1 - The queue has items in it
			case 1:
				// 1.1.1 - Set head to its 'next' MyNode obj
				this.head = this.head.getRight();

				// 1.1.2 - Decrement num items by 1
				this.numItems--;
				break;

			// 1.2 - The queue is empty, we print an error message
			case 2:
				System.out.println("Sorry, the queue is already empty.");
				break;
		}
	}

	//-------------------------------------------------------------------
	// Basic Operation (Partial) --> Get first element from front of MyQueue: last
	//-------------------------------------------------------------------
	public T last(){
		// 1 - Check if there are actually any nodes in the queue
		if (this.numItems > 0)
			return this.tail.getInfo();

		// 2 - Return null if queue is empty
		return null;
	}

	//-------------------------------------------------------------------
	// Basic Operation --> Add element to back of MyQueue: addByLast 
	//-------------------------------------------------------------------
	public void addByLast(T element){
		//-----------------------------
		// I. SCENARIO IDENTIFICATION
		//-----------------------------
		int scenario = 0;

		// 1 - Instantiate two new MyNode object / 1 for current node 1 aux node
		MyDoubleLinkedNode<T> current = new MyDoubleLinkedNode<T>(null, element, null);
		MyDoubleLinkedNode<T> node    = null;

		// 2 - Test for num items
		switch (this.numItems) {
			// 2.1 - There are 0 items in the queue
			case 0:
				scenario = 1;
				break;

			// 2.2 - There's only 1 item in the queue
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
				this.tail = current;
				break;


			// 2.2 - There is only 1 node in the queue
			case 2:
				// 2.2.1
				this.head = this.tail;

				// 2.2.2 - Set new current node's left to head
				current.setLeft(this.head);

				// 2.2.3 - Set head's right to new current node
				this.head.setRight(current);

				// 2.2.4 - Set tail to new current
				this.tail = current;
				break;


			// 2.3 - Set the new MyNode to the 'next' of the head and the next node
			case 3:
				// 2.3.1 - Set aux node to this queue's head
				node = this.tail;

				// 2.3.2 - Set new current's left to most right node
				current.setLeft(node);

				// 2.3.3 - Set most right node to new current node
				node.setRight(current);

				// 2.3.4 - Set tail to new current node
				this.tail = current;
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

		// 1 - Set scenario to 1 if queue is empty, set to 2 if not.
		scenario = (this.numItems >= 0) ? 1 : 2;


		//-----------------------------
		// II. SCENARIO IMPLEMENTATION
		//-----------------------------
		switch (scenario) {
			// 1.1 - The queue has items in it
			case 1:
				// 1.1.1 - Set tail to its 'previous' node
				this.tail = this.tail.getLeft();

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
