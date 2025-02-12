import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StackTester {

	@Test
	void testSize() {
	
		
		//create a Stack
		NewStack<Integer> myStack = new NewStack<Integer>();
 		
		//test that the size is 0
		//when you haven't added anything 
		
		assertTrue(myStack.size() == 0);
		
	}
	
	@Test
	void testPush() {
		NewStack<Integer> myStack = new NewStack<Integer>();
		assertTrue(myStack.toString().equals("[]"));
		assertTrue(myStack.size() == 0);
		assertTrue(myStack.empty());
		
		//push on thing
		myStack.push(10);
		assertTrue(myStack.size() == 1);
		assertTrue(myStack.toString().equals("[10]"));
		//check the size
		
		
		myStack.push(20);
		assertTrue(myStack.size() == 2);
		myStack.push(30);
		
//		System.out.println(myStack.toString());
		assertTrue(myStack.toString().equals("[10, 20, 30]"));
		assertTrue(myStack.size() == 3);
	}
	
	
	@Test
	void testPop() {
		NewStack<Integer> myStack = new NewStack<Integer>();
		assertTrue(myStack.empty());
		myStack.push(10);
		myStack.push(20);
		myStack.push(30);
		
		myStack.pop();
		assertTrue(myStack.toString().equals("[10, 20]"));
		
		assertTrue(myStack.size() == 2);
	}
	
	
	
	@Test
	void testPeek() {
		NewStack<Integer> myStack = new NewStack<Integer>();
		assertTrue(myStack.empty());
		myStack.push(10);
		myStack.push(20);
		myStack.push(30);
		
		assertTrue(myStack.peek() == 30);
		assertTrue(myStack.toString().equals("[10, 20, 30]"));
		assertTrue(myStack.size() == 3);
	}
	
	
	@Test 
	void testPopNull() {
		NewStack<Integer> myStack = new NewStack<Integer>();
		assertTrue(myStack.empty());
		assertTrue(myStack.pop() == null);
	}
	

}
