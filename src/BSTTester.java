import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BSTTester {

	@Test
	void test() {
//		fail("Not yet implemented");
		BinaryTree bst = new BinaryTree();
		
		bst.add(new BSTNode(10));
		bst.add(new BSTNode(11));
		bst.add(new BSTNode(6));
		bst.add(new BSTNode(7));
		bst.add(new BSTNode(8));
		
		
//		bst.inorder(bst.head);
//		System.out.println();
//		
//		System.out.println(bst.head.left.left.getData());
//		System.out.println(bst.head.right.getData());
		System.out.println(bst.dfs());
		assertTrue(bst.dfs().equals("10 6 7 8 11 "));

	}

}
