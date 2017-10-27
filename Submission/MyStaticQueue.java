
public class MyStaticQueue implements MyQueue {

	//--------------------------------------------------
	// Attributes
	//--------------------------------------------------
	private int numItems;
	private int maxItems;
	private int collection[];

	//-------------------------------------------------------------------
	// Basic Operation --> Check if myQueue is empty: myCreateEmpty
	//-------------------------------------------------------------------	
	public MyStaticQueue(int max){
		this.numItems   = 0;
		this.maxItems   = max;
		this.collection = new int[this.maxItems];
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
		//-----------------------------
		// I. SCENARIO IDENTIFICATION
		//-----------------------------
		int scenario = 0;

		// 1 - There are items in queue
		if (!(this.numItems <= 0))
			scenario = 1;

		//-----------------------------
		// II. SCENARIO IMPLEMENTATION
		//-----------------------------
		switch (scenario) {
			// 1 - There are items in the queue
			case 1:
				// 1.1 - Return the first item in queue
				return this.collection[0];

			// 2 - The queue is empty
			default:
				// 2.1 - Print error message
				System.out.println("Error: Cannot get first node. Reason: Queue is empty.");

				// 2.2 - Return 0 as default value when the queue is empty
				return 0;
		}
	}
	
	//-------------------------------------------------------------------
	// Basic Operation (Partial) --> Add element to back of MyQueue: add 
	//-------------------------------------------------------------------
	public void add(int element){
		//-----------------------------
		// I. SCENARIO IDENTIFICATION
		//-----------------------------
		int scenario = 0;

		// 1 - Check if there are sufficient items left
		if (this.maxItems > this.numItems)
			scenario = 1;
		// 2 - The queue is full
		else
			scenario = 2;


		//-----------------------------
		// II. SCENARIO IMPLEMENTATION
		//-----------------------------
		switch (scenario) {
			// 1 - Check if there are sufficient items left
			case 1:
				// 1.1 - Add new item into queue
				this.collection[numItems] = element;

				// 1.2 - Increment total num of items in queue
				this.numItems++;
				break;


			// 2 - The queue is full
			case 2:
				// 2.1 - Print queue is already full error message
				System.out.println("Error: Cannot add node. Reason: Queue is full.");
				break;
		}
	}
	
	//-------------------------------------------------------------------
	// Basic Operation (Partial) --> Remove element from front of MyQueue: remove 
	//-------------------------------------------------------------------	
	public void remove() {
		//-----------------------------
		// I. SCENARIO IDENTIFICATION
		//-----------------------------
		int scenario = 0;

		// 1 - Check if we can remove any more items
		if (!(this.numItems <= 0))
			scenario = 1;
		// 2 - The queue no longer contains any items
		else
			scenario = 2;


		//-----------------------------
		// II. SCENARIO IMPLEMENTATION
		//-----------------------------
		switch (scenario) {
			// 1 - Check if we can remove any more items
			case 1:
				// 1.1 - Iterate through all items
				for (int i = 0; i < this.numItems-1; i++)
					// 1.1.1.1 - Move the items one place to the left (front of queue)
					this.collection[i] = this.collection[i + 1];

				// 1.2 - Set the removed node to 0 
				this.collection[this.numItems-1] = 0;

				// 1.3 - Decrement total num items
				this.numItems--;
				break;


			// 2 - The queue no longer contains any items
			case 2:
				// 2.1 Print queue is empty error message
				System.out.println("Error: Cannot remove node. Reason: Queue is empty.");
				break;
		}
	}
}