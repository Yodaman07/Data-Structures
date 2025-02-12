public class NewStack<E> {
	
	private Queue<E> queue;
	private Queue<E> tempQueue;

	
	public NewStack() {

		queue = new Queue<E>();
		tempQueue = new Queue<E>();
	}
	
	
	//add the element to the stack
	public void push (E element) {
		queue.enqueue(element);
	}
	
	//pop from the Stack (removes and returns)
	//@return null if empty
	public E pop() {
		// 1,2,3,4,5 --> 1,2,3,4 --> 1,2,3,4
		if (queue.size() == 0) {return null;}
		
		E elmn;
		int itterations = queue.size();
		for (int i = 0; i < itterations-1; i++) {
			tempQueue.enqueue(queue.dequeue());
		}
		
		elmn = queue.dequeue();
		
		
		for (int i = 0; i < itterations-1; i++) {
			queue.enqueue(tempQueue.dequeue());
		}
		
		return elmn;
		
	}
	
	//return the top of the stack WITHOUT removing from the data structure
	public E peek() {
		E elmn = queue.peek(); //Some temp value
		int itterations = queue.size();
		for (int i = 0; i < itterations; i++) {
			if (i == itterations-1) {
				elmn = queue.dequeue();
				tempQueue.enqueue(elmn);
			}else {
				tempQueue.enqueue(queue.dequeue());
			}
		}
		
		
		for (int i = 0; i < itterations; i++) {
			queue.enqueue(tempQueue.dequeue());
		}
		
		return elmn;
	}
	
	
	//return the size of the stack
	public int size() {
		return queue.size();
	}
	
	public String toString() {
		//return a String representation of the data
		String res = "[";
		
		int itterations = queue.size();
		for (int i = 0; i < itterations; i++) { //Shift everything over to the tempStack
			tempQueue.enqueue(queue.dequeue());
		}
		
		for (int i = 0; i < itterations; i++) {//shift it all back in the right way
			E val = tempQueue.dequeue();
			res += val;
			queue.enqueue(val);
			
			if (i < itterations-1) {
				res+= ", ";
			}
		}
		
		res += "]";
		return res;		
	}
	
	public boolean empty() {
		return (queue.size()==0);
	}
}
