
public class DoublyLinkedList {
	
	
	//reference to the "start" of the list
	Node head; 			//null or references first node
	private int size; 	// # of Node objects
	
	public DoublyLinkedList() {
		head = null;
		size = 0;
	}
	
	public void add (int index, Node node) {
		if (index > this.size) {return;}
		if (index < 0) {return;}
		
		if (index == 0) { //if we are inserting at the front of the list			
			node.next = head;
			head.prev = node;
			head = node;
			size++;
			return;
		}else if(index == this.size()) {
			this.add(node); //if we are inserting at the back of the list
			return;
		}
		
		//anywhere else
		
		Node left = this.get(index-1);
		Node right = this.get(index);
		
		left.next = node;
		node.prev = left;
		
		node.next = right;
		right.prev = node;
		size++;
		return;
	}
	
	
	
	public void add(Node newNode) {
		// what is involved in adding nodes?
		
		//are there existing nodes?
		//what do you have to do to the head reference
		//so it's valid?
		if (head == null) {head = newNode;}
		else {
			this.add(head, newNode); //call the private helper method if needed (recursive)
		}
		size++;
	
	}
	
	/*
	 * Recursive add method
	 */
	
	private void add(Node curr, Node newNode) {
		
		//base-case
		if (curr.next == null) { //found the end of the list - the next ref is NULLLL
			curr.next = newNode; //add the new node and exit the recursion :)
			newNode.prev = curr;
		}else {
			add(curr.next, newNode);
			//recursive case
		}
	}
	
	
	/*
	 * returns the Node at the given index
	 * or null if invalid
	 */
	public Node get(int index) {
		//check if index is invalid
		//return null
		//else look for the Node (my code is below)
		if (index > this.size-1) {return null;}
		if (index < 0) {return null;}
		
		return this.get(head, index, 0);
	}
	
	
	private Node get(Node curr, int index, int currIndex) {
		if (index == currIndex) {return curr;}
		return this.get(curr.next, index, currIndex+1);
	}
	
	public Node remove(int index) {
		if (index > this.size-1) {return null;}
		if (index < 0) {return null;}
		
		Node removed = this.remove(head, index, 0);
		size--;
		return removed;
	}
	
	/*
	 * Remove and return the Node recursively
	 */
	private Node remove(Node curr, int index, int currIndex) {
		if (index == currIndex) { //base case
			//reorder elements
			if (index == 0 && size == 1) {head = null;} //if you are removing the only element
			
			else if (index == this.size()-1) {this.get(index-1).next = null;} //if the element is on the right most side
			else if (index == 0) {head = this.get(1); head.prev = null;} // if the element is on the left most side
			else {
				Node n = this.get(index+1);
				this.get(index-1).next = n;
				n.prev = this.get(index-1);
			} //normal case
			
			return curr;
		}
		
		return remove(curr.next, index, currIndex+1); //recursive case
	}
	
	
	//recursive implementation of the toString method
	public String toString() {
		return "[" + toString(0);
	}
	
	private String toString(int currentIndex) {
		//base case
		if (currentIndex == this.size()-1) {
			
			return this.get(currentIndex).getData() + "]";
			
		}
		
		
		//recursive case
		if (this.get(currentIndex) == null) {return "]";}
		return this.get(currentIndex).getData() + ", " + this.toString(currentIndex+1);
	}
	
	
	//getter for size
	public int size() {return this.size;}

}
