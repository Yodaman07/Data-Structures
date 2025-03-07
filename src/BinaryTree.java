import java.util.ArrayList;

public class BinaryTree {
	//"Top" of the tree
	BSTNode head;
	int size;
	
	
	public BinaryTree() {
		head = null;
		size = 0;
	}
	
	/**
	 * Add node to the tree!
	 * keeps the tree in a sorted fashion
	 * every node to the right of a node is great-than-or-equal-to that node
	 * every node to the left of a node is less-than that node
	 * @param arg
	 */
	public void add(BSTNode n) {
		//https://www.geeksforgeeks.org/insertion-in-binary-search-tree/?ref=lbp
		//Start at head
		if (head == null) {head = n;return;}

		
		int val = n.getData();
		BSTNode curr = head;
		
		while (true) {
			if (val <= curr.getData()) {
				if (curr.left == null) {
					curr.left = n;
					break;
				}
				curr = curr.left;
//				System.out.println("A");
			}else if (val > curr.getData()) {
				if (curr.right == null) {
					curr.right = n;
					break;
				}
				curr = curr.right;
//				System.out.println("B");
			}
		}
		
		
		size++;
	}
	
	/*
	    Used if add is implemented tail recursively
	*/
	public void add(BSTNode curr, BSTNode newNode){
        

    }
	
	public void print() {
		//print all the elements - no specifics on how for the time being
		//for testing purposes
		
		  /* to be completed */
		
	
	}
	
	   static void inorder(BSTNode root) //https://www.geeksforgeeks.org/insertion-in-binary-search-tree/?ref=lbp
	    {
	        if (root != null) {
	            inorder(root.left);
	            System.out.print(root.getData() + " ");
	            inorder(root.right);
	        }
	    }
	
	
	public String bfs() {
		// return a string representation of the nodes
		// in a breath-first-search order
		  /* to be completed */
		String res = "";
		res+=head.getData() + " ";
		if (head == null) {return res;}
		ArrayList<BSTNode> visited = new ArrayList<BSTNode>();
		ArrayList<BSTNode> temp = new ArrayList<BSTNode>();
		visited.add(head);
		
		while (!visited.isEmpty()) {
			for (BSTNode node: visited) {
				if (node.left != null) {
					res+= node.left.getData() + " ";
					temp.add(node.left);
				}
				if (node.right != null) {
					res+= node.right.getData() + " ";
					temp.add(node.right);
				}
			}
			visited.clear();
			for (BSTNode val: temp) {
				visited.add(val);
			}
			temp.clear();
		}
		
		
		return res;
	}
	
	/* Used if bfs is implemented tail recursively */
	public String bfsHelper(ArrayList<BSTNode> visited){ //visited is just all of the nodes from the level above
		String res = "";
	    return res;
	}
	
	//pre-order depth-first-search traversal
	public String dfs() {
		String res = "";
		res += head.getData() + " ";
		
		res += dfsHelper(head.left);
		res += dfsHelper(head.right);
	      /* to be completed */
		return res;
	}
	
	/*
	    Used if dfs is written tail recursively
	*/
	public String dfsHelper(BSTNode curr) {
		String res = "";
	    if (curr == null) {return "";}
	    
		res += curr.getData() + " " + dfsHelper(curr.left);
		res += dfsHelper(curr.right);
	    return res;
	    
	}
	
	
	
	
	
}