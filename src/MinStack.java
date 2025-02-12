
public class MinStack<T>{

    //add any required instance variables
	private Stack<T> stackA;
	private Stack<T> tempStack;
	
    //add a constructor
	public MinStack() {
		stackA = new Stack<T>();
		tempStack = new Stack<T>();
	}

	
    public void push(T el){
    	stackA.push(el);
    }

    public T pop(){
        return stackA.pop();
    } 

    public int size(){
        return stackA.size();
    }
    
    public boolean empty() {
    	return stackA.size() == 0;
    }
    
    public T peek() {
    	return stackA.peek();
    }
    
    public String toString() {
		String res = "[";
		
		int itterations = stackA.size();
		for (int i = 0; i < itterations; i++) { //Shift everything over to the tempStack
			tempStack.push(stackA.pop());
		}
		
		for (int i = 0; i < itterations; i++) {//shift it all back in the right way
			T val = tempStack.pop();
			res += val;
			stackA.push(val);
			
			if (i < itterations-1) {
				res+= ", ";
			}
		}
		
		res += "]";
		return res;
    }

    /* returns the minimum element in the list.
       Does NOT modify the list */
    public T min(){
    	
    	//1 iteration, find the min while shifting to the temp stack and shift back to normal stack
    	if (stackA.size() == 0) {return null;}
    	
    	int iterations = stackA.size();
    	T min = stackA.peek();
    	for (int i =0; i < iterations; i++) {
    			
    		tempStack.push(stackA.pop()); //takes the last element from stackA and puts it into tempStack
    		if (stackA.size() > 0) {
    			
    			if (min.toString().compareTo(stackA.peek().toString()) > 0) {
    				min = stackA.peek();
    			}
    			
    		}
    		
    	}
    	
    	
    	for (int i =0; i< iterations; i++) {
    		stackA.push(tempStack.pop());
    	}//Re organize the stacks
    	
    	
        return min;
    }


}
