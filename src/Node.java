
public class Node<T> {
	
	private T data; // the piece of data
	public Node next; //null or references another node
	public Node prev; // null or references the previous node
	
	
	//constructor
	public Node(T data) {
		this.data = data;
	}
	
	//getter & setter for Data
	public T getData() { return this.data; }
	
	public void setData(T newData) {this.data = newData;}
	

	
//	public Node getNext(){ return next;}
//	    
//    public void setNext(Node n){ this.next = n;}
}
