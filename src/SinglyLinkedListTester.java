import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SinglyLinkedListTester {

	@Test
	void testOneElement() {
		
		SinglyLinkedList list = new SinglyLinkedList();
		
		//add one Node then check size
		list.add(new Node(7));
		assertTrue(list.size() == 1);//size should be 1 now
		
		assertTrue(list.head != (null));
		
		//check the head reference
		//check that the head reference is not NULL!!!!!!
	}
	
	@Test
	void testMultipleElements() {
		SinglyLinkedList list = new SinglyLinkedList();
		
		list.add(new Node(7));
		list.add(new Node(21));
		list.add(new Node(14));
		
		
		assertTrue(list.toString().equals("[7, 21, 14]"));
		
		assertTrue(list.size() == 3);//size should be 1 now
		
		assertTrue(list.head != (null));
		
		assertTrue(list.get(0).getData().equals(7));
		assertTrue(list.get(1).getData().equals(21));
		assertTrue(list.get(2).getData().equals(14));
		
		assertTrue(list.get(3) == (null));
		assertTrue(list.get(-1) == (null));
		
//		some get code we did in class
//		int curr = 0;
//		Node temp = head;
//		while (curr < index) {
//			temp = temp.next;
//			curr++;
//		}
//		return temp;
	}
	
	
	@Test
	void testRemoving() {
		SinglyLinkedList list = new SinglyLinkedList();
		list.add(new Node(7));
		list.add(new Node(21));
		list.add(new Node(14));
		
		
		assertTrue(list.get(0).getData().equals(7));
		assertTrue(list.get(1).getData().equals(21));
		assertTrue(list.get(2).getData().equals(14));
		
		
		assertTrue(list.remove(0).getData().equals(7)); //removing the first element
		assertTrue(list.get(0).getData().equals(21));
		assertTrue(list.get(1).getData().equals(14));
		assertTrue(list.toString().equals("[21, 14]"));
		
		
		assertTrue(list.remove(2) == null);
		assertTrue(list.remove(-1) == null);
		assertTrue(list.size() == 2);
		assertTrue(list.toString().equals("[21, 14]"));
		
		assertTrue(list.remove(1).getData().equals(14)); //removing the last element
		assertTrue(list.get(0).getData().equals(21));
		assertTrue(list.toString().equals("[21]"));
		
		
		assertTrue(list.remove(0).getData().equals(21)); 
		assertTrue(list.get(0) == null);
		assertTrue(list.toString().equals("[]"));
		
		list.add(new Node(1));
		list.add(new Node(2));
		list.add(new Node(3));
		assertTrue(list.toString().equals("[1, 2, 3]"));
		
		assertTrue(list.remove(1).getData().equals(2)); //removing middle element
		assertTrue(list.size() == 2);
		assertTrue(list.toString().equals("[1, 3]"));
	}
	
	
	
	@Test
	void testInsert() {
		SinglyLinkedList list = new SinglyLinkedList();
		list.add(new Node(7));
		list.add(new Node(21));
		list.add(new Node(14));
		
		assertTrue(list.toString().equals("[7, 21, 14]"));

		list.insert(2, new Node(3));//inserting in the middle
		assertTrue(list.toString().equals("[7, 21, 3, 14]"));
		
		list.insert(0, new Node(10));//inserting on the left
		assertTrue(list.toString().equals("[10, 7, 21, 3, 14]"));
		
		list.insert(5, new Node(39));//inserting on the right
		assertTrue(list.toString().equals("[10, 7, 21, 3, 14, 39]"));

		
	}

}
