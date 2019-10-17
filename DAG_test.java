import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DAG_test {

		@Test
		void testConstructor() {
		// testing that the constructor works
			LCA_DAG DAG = new LCA_DAG(7);
			assertEquals("Test Constructor", 7, DAG.V());
			
			LCA_DAG DAG2 = new LCA_DAG(6);
			assertEquals("Test Constructor", 6, DAG2.V());
			
			LCA_DAG DAG3 = new LCA_DAG(12);
			assertEquals("Test Constructor", 12, DAG3.V());
			
			//test to make sure the vertex entered is below 0, exception thrown if not 
			try {
				LCA_DAG DAG4 = new LCA_DAG(-3);
			} 
			catch (IllegalArgumentException e) {
			}
			
			//test false if expected vertex does not equal vertex returned 
			LCA_DAG DAG5 = new LCA_DAG(10);
			assertFalse("Test Constructor", 9 == DAG5.V());
		}
		
		@Test
		void testV() {
		//Test V() returns correct vertex
			LCA_DAG DAG = new LCA_DAG(1);
			int vertex = DAG.V();
			assertEquals("Test V() returns 1", 1, vertex);
			
			LCA_DAG DAG2 = new LCA_DAG(1);
			int vertex2 = DAG2.V();
			assertEquals("Test V() returns 2", 1, vertex2);
			
			LCA_DAG DAG3 = new LCA_DAG(3);
			int vertex3 = DAG3.V();
			assertEquals("Test V() returns 3", 3, vertex3);
			
			//test if expected vertex does not match what is returned, assert false
			LCA_DAG DAG4 = new LCA_DAG(4);
			assertFalse("Test V() is not a match", 2 == DAG4.V());

		}
		

		@Test 
		void TestValidateV(){
		//if vertex is not valid, throw exception
			LCA_DAG DAG = new LCA_DAG(5);
			try {
				DAG.addEdge(-1,-1);
			} 
			catch (IllegalArgumentException e) {
			}

			LCA_DAG DAG2 = new LCA_DAG(3);
			try {
				DAG2.addEdge(2,2);
				DAG2.addEdge(2,1);
				DAG2.addEdge(1,9);
			} 
			catch (IllegalArgumentException e) {
			}
		}
	}