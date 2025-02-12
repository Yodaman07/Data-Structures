import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MinStackTester {

	@Test
	void testMin() {
		MinStack<Integer> minStack = new MinStack<Integer>();
		
		assertTrue(minStack.pop() == null);
		assertTrue(minStack.min() == null);
		
		
		minStack.push(1);
		minStack.push(2);
		minStack.push(3);
		minStack.push(0);
		minStack.push(-1);
		
		
		System.out.println(minStack.min());
		assertTrue(minStack.min() == -1);
		
		int p = minStack.pop();
		assertTrue(p == -1);
		assertTrue(minStack.min() == 0);
		
		p = minStack.pop();
		assertTrue(p == 0);
		assertTrue(minStack.min() == 1);
		
		
		minStack.push(-10000);
		assertTrue(minStack.min() == -10000);
		
	}
	
	
	
	@Test
	void testPush() {
		MinStack<Integer> minStack = new MinStack<Integer>();
		
		
		minStack.push(1);
		minStack.push(2);
		minStack.push(3);
		minStack.push(0);
		minStack.push(-1);
		
		
		assertTrue(minStack.size() == 5);
		assertTrue(minStack.toString().equals("[1, 2, 3, 0, -1]"));
	}
	
	

}
