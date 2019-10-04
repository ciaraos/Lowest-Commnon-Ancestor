import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LCATest {
	
	//test pass
	//test fail
	//test one node
	//test two nodes

	@Test
	public void testEmpty() {
		LowestCommonAncestor testTree = new LowestCommonAncestor();
		assertNull("Testing empty tree", testTree.root);
	}
	
	@Test 
	public void testSingleNodeBT() {
		LowestCommonAncestor testTree = new LowestCommonAncestor();
		testTree.root = new Node(1);
		assertEquals("Testing a tree with only one node", testTree.findLowestCommonAncestor(1, 2), -1);
	}
	
	@Test
	public void testLCA() {
		LowestCommonAncestor testTree = new LowestCommonAncestor();
		testTree.root = new Node(3);
		testTree.root.left = new Node(4);
		testTree.root.right = new Node(5);
		assertEquals("Data value is correct:",3,testTree.root.data);
		assertEquals("Data value is correct:",4,testTree.root.left.data);
		assertEquals("Data value is correct:",5,testTree.root.right.data);
		
	}
	
	@Test
	public void testFindPath() {
		LowestCommonAncestor testTree = new LowestCommonAncestor(); 
		testTree.root= new Node(1); 
		testTree.root.left = new Node(2); 
		testTree.root.right = new Node(3); 
		testTree.root.left.left = new Node(4); 
		testTree.root.left.right = new Node(5); 
		testTree.root.right.left = new Node(6); 
		testTree.root.right.right = new Node(7); 

		assertEquals("LCA(4,5) should be 2.",testTree.findLowestCommonAncestor(4,5),2);
		assertEquals("LCA(4,6) should be 1.",testTree.findLowestCommonAncestor(4,6),1);
		assertEquals("LCA(3,4) should be 1.",testTree.findLowestCommonAncestor(3,4),1);
		assertEquals("LCA(2,4) should be 2.",testTree.findLowestCommonAncestor(2,4),2);
		assertEquals("LCA of non existent node",testTree.findLowestCommonAncestor(8, 7),-1);
		
		testTree.root.left = new Node(5);
		assertEquals("tree with no root.",testTree.findLowestCommonAncestor(5, 0),-1);
		  
	}
}

