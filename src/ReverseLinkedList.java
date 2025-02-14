
public class ReverseLinkedList {
	
	
	public void reverse(SinglyLinkedList list){
        //Reminder: this is a SinglyLinkedList. There is no ref. to prev Node
        
        /* student solution */
        
		Node curr = list.head;
		Node prev = null;
		Node next = null;
        
        while (curr != null) {
        	next = curr.next;
        	curr.next = prev;
        	prev = curr;
        	curr = next;
        }
        list.head = prev;
        
        
    }
	
	
}
