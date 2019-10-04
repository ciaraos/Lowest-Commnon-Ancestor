import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LCATest {

	@Test
	public void testEmptyTree() {
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
	public void test2NodeBT() {
		LowestCommonAncestor testTree = new LowestCommonAncestor();
		testTree.root = new Node(1);
		testTree.root.left = new Node(2);
		assertEquals("Testing a tree with two nodes", testTree.findLowestCommonAncestor(1, 2), 1);
	}
	
	@Test
	public void testLCA() {
		LowestCommonAncestor testTree = new LowestCommonAncestor();
		testTree.root = new Node(1);
		testTree.root.left = new Node(2);
		testTree.root.right = new Node(3);
		assertEquals("Data value is correct:",1,testTree.root.data);
		assertEquals("Data value is correct:",2,testTree.root.left.data);
		assertEquals("Data value is correct:",3,testTree.root.right.data);
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

		assertEquals("LCA(2,3) should be 1.",testTree.findLowestCommonAncestor(2,3),1);
		assertEquals("LCA(3,6) should be 3.",testTree.findLowestCommonAncestor(3,6),3);
		assertEquals("LCA(3,4) should be 1.",testTree.findLowestCommonAncestor(3,4),1);
		assertEquals("LCA(2,4) should be 2.",testTree.findLowestCommonAncestor(2,4),2);
	}
	
	@Test
	public void testForAbsentNode() 
	{
		LowestCommonAncestor testTree = new LowestCommonAncestor(); 
		testTree.root= new Node(1); 
		testTree.root.left = new Node(2); 
		testTree.root.right = new Node(3); 
		testTree.root.left.left = new Node(4); 
		assertEquals("LCA of non existent node",testTree.findLowestCommonAncestor(8, 7),-1);
	}
	
	@Test
	public void testForNoRoot()
	{
		LowestCommonAncestor testTree = new LowestCommonAncestor(); 
		testTree.root= new Node(1); 
		testTree.root.left = new Node(2); 
		testTree.root.right = new Node(3); 
		testTree.root.left.left = new Node(4);
		assertEquals("tree with no root.",testTree.findLowestCommonAncestor(4, 0),-1);
	}
}

