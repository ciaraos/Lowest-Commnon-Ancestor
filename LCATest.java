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
}