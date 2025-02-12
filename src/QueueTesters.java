import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class QueueTesters {

	@Test
	void testEnqueue() {
		Queue<Integer> myQ = new Queue<Integer>();
		assertTrue(myQ.size()==0);
		assertTrue(myQ.empty());
		
		
		myQ.enqueue(1);
		myQ.enqueue(2);
		assertTrue(myQ.peek() == 1);
		assertTrue(myQ.size()==2);
		
		
		//check size after dequeuing
		int elA = myQ.dequeue();
		assertTrue(myQ.size()==1);
		
//		System.out.println(myQ.toString());
		assertTrue(elA == 1);
		assertTrue(myQ.toString().equals("[2]"));
	}
	
	@Test
	void testDequeue() {
		Queue<Integer> myQ = new Queue<Integer>();
		
		myQ.enqueue(1);
		myQ.enqueue(3);
		myQ.enqueue(2);
		myQ.enqueue(5);
		myQ.enqueue(9);
		
		
		myQ.dequeue();
		assertTrue(myQ.toString().equals("[3, 2, 5, 9]"));
		int a = myQ.dequeue();
		assertTrue(a == 3);

		assertTrue(myQ.toString().equals("[2, 5, 9]"));
		myQ.enqueue(10);
		assertTrue(myQ.toString().equals("[2, 5, 9, 10]"));
		
		assertTrue(myQ.peek() == 2);
		System.out.println(myQ.peek());
	}

}
