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

	}