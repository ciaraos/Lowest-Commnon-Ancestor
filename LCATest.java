import static org.junit.Assert.*;

import org.junit.Test;

public class LCATest {

	@Test
	public void testLCA() {
		LowestCommonAncestor testTree = new LowestCommonAncestor();
		assertNull("Testing empty tree", testTree.LCAroot);
		testTree.LCAroot = new Node(3);
		testTree.LCAroot.leftNode = new Node(4);
		testTree.LCAroot.rightNode = new Node(5);
		assertEquals("Data value is correct:",3,testTree.LCAroot.data);
		assertEquals("Data value is correct:",4,testTree.LCAroot.leftNode.data);
		assertEquals("Data value is correct:",5,testTree.LCAroot.rightNode.data);
		
	}
	
	@Test
	public void testFindPath() {
		LowestCommonAncestor testTree = new LowestCommonAncestor(); 
		testTree.LCAroot = new Node(1); 
		testTree.LCAroot.leftNode = new Node(2); 
		testTree.LCAroot.rightNode = new Node(3); 
		testTree.LCAroot.leftNode.leftNode = new Node(4); 
		testTree.LCAroot.leftNode.rightNode = new Node(5); 
		testTree.LCAroot.rightNode.leftNode = new Node(6); 
		testTree.LCAroot.rightNode.rightNode = new Node(7); 

		assertEquals("LCA(4,5) should be 2.",testTree.findLowestCommonAncestor(4,5),2);
		assertEquals("LCA(4,6) should be 1.",testTree.findLowestCommonAncestor(4,6),1);
		assertEquals("LCA(3,4) should be 1.",testTree.findLowestCommonAncestor(3,4),1);
		assertEquals("LCA(2,4) should be 2.",testTree.findLowestCommonAncestor(2,4),2);
		assertEquals("LCA of non existent node",testTree.findLowestCommonAncestor(8, 7),-1);
		
		testTree.LCAroot.leftNode = new Node(5);
		assertEquals("tree with no root.",testTree.findLowestCommonAncestor(5, 0),-1);
		  
	}
	
}