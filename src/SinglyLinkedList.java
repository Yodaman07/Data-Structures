
public class SinglyLinkedList {
	
	//reference to the "start" of the list
	Node head; 			//null or references first node
	private int size; 	// # of Node objects
	
	public SinglyLinkedList() {
		head = null;
		size = 0;
	}
	
	
	public void insert (int index, Node node) {
		if (index > this.size) {return;}
		if (index < 0) {return;}
		
		if (index == 0) { //if we are inserting at the front of the list
			node.next = head;
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
		node.next = right;
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
//			Node currentEnd = head; //starting value for the end
//			for (int i = 0; i < this.size()-1; i++) {
//				currentEnd = currentEnd.next;
//			}
//			currentEnd.next = newNode;
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
		
//		Node currentNode = head;
//		for (int i = 0; i < this.size; i++) {
//			if (i == index) {
//				return currentNode;
//			}
//			currentNode = currentNode.next;
//		}
//		
//		return null;
		return this.get(head, index, 0);
	}
	
	
	private Node get(Node curr, int index, int currIndex) {
		if (index == currIndex) {return curr;}
		return this.get(curr.next, index, currIndex+1);
	}
	
	public Node remove(int index) {
		if (index > this.size-1) {return null;}
		if (index < 0) {return null;}
		
//		Node left = head; //you need to remap the reference for this value
//		Node beingRemoved = this.get(index); //for returning the value being removed
//		Node currentNode = head; //keep track of current iteration
//		
//		if (index == 0) { //for handling if the you are removing the first value
//			if (size > 1) {
//				this.head = this.head.next;
//			}else {this.head = null;}
//			size--;
//			return beingRemoved;
//		}
//		
//		boolean remapped = false;
//		//if the index isn't 0
//		for (int i = 0; i < this.size; i++) {
//			if (i == index-1) {
//				left = currentNode;
//				
//			}else if (i == index+1) { //remap the left node
//				left.next = currentNode;
//				remapped = true;
//			}
//			
//			currentNode = currentNode.next;
//		}
//		if (!remapped) {left.next = null;}//it means that you are removing the rightmost index
//		
//		size--;
//		return beingRemoved;
		
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
			else if (index == 0) {head = this.get(1);} // if the element is on the left most side
			else {this.get(index-1).next = this.get(index+1);} //normal case
			
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
