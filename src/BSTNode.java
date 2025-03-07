
public class BSTNode {
	
	private int data; // the piece of data
	public BSTNode left = null; 
	public BSTNode right = null;
	
	
	//constructor
	public BSTNode(int data) {
		this.data = data;
	}
	
	//getter & setter for Data
	public int getData() { return this.data; }
	
	public void setData(int newData) {this.data = newData;}
	

	
//	public Node getNext(){ return next;}
//	    
//    public void setNext(Node n){ this.next = n;}
}
