import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LCATest {

	@Test
	public void testEmptyTree() {
		//testing constructor for empty tree
		LowestCommonAncestor testTree = new LowestCommonAncestor();
		assertNull("Testing empty tree", testTree.root);
	}

	@Test 
	public void testSingleNodeBT() {
		//testing constructor and findLowestCommonAncestor() for a BT with only one node
		LowestCommonAncestor testTree = new LowestCommonAncestor();
		testTree.root = new Node(1);
		assertEquals("Testing a tree with only one node", testTree.findLowestCommonAncestor(1, 2), -1);
	}

	@Test
	public void test2NodeBT() {
		//testing constructor and findLowestCommonAncestor() for a BT with only two nodes
		LowestCommonAncestor testTree = new LowestCommonAncestor();
		testTree.root = new Node(1);
		testTree.root.left = new Node(2);
		assertEquals("Testing a tree with two nodes", testTree.findLowestCommonAncestor(1, 2), 1);
	}

	@Test
	public void testLCA() {
		//testing that the correct LCA is found 
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
		//testing that the correct path is found and followed 
		LowestCommonAncestor testTree = new LowestCommonAncestor(); 
		
		testTree.root= new Node(1); 
		testTree.root.left = new Node(2); 
		testTree.root.right = new Node(3); 
		testTree.root.left.left = new Node(4); 
		testTree.root.left.right = new Node(5); 
		testTree.root.right.left = new Node(6); 
		testTree.root.right.right = new Node(7); 
		
		assertEquals("tree with no root.",testTree.findLowestCommonAncestor(4, 0),-1);

		assertEquals("LCA(2,3) should be 1.", testTree.findLowestCommonAncestor(2, 3),1);
		assertEquals("LCA(3,6) should be 3.", testTree.findLowestCommonAncestor(3, 6),3);
		assertEquals("LCA(3,4) should be 1.", testTree.findLowestCommonAncestor(3, 4),1);
		assertEquals("LCA(2,4) should be 2.", testTree.findLowestCommonAncestor(2, 4),2);
	}

	@Test
	public void testForAbsentNode() 
	{
		//test findLowestCommonAncestor() for a node that doesn't exist in the BT
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
		//test findLowestCommonAncestor() for a binary tree with no root
		LowestCommonAncestor testTree = new LowestCommonAncestor(); 
		testTree.root= new Node(1); 
		testTree.root.left = new Node(2); 
		testTree.root.right = new Node(3); 
		testTree.root.left.left = new Node(4);
		assertEquals("tree with no root.",testTree.findLowestCommonAncestor(4, 0),-1);
	}

}