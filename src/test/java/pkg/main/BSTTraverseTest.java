package pkg.main;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BSTTraverseTest {

	private static BSTDictionary<Integer, String> dict;
	
	@BeforeEach
	void init() {
		
		dict = new BSTDictionary<Integer, String>();
	}

	  @Test
	  public void testDFT() {
		  
			  
		  	dict.insert(10, "10");
			dict.insert(2,"2");
			dict.insert(3, "3");
			dict.insert(15,"15");
			BSTTraverse.clear();
			BSTTraverse.depthFirstTraverse(dict.getRoot());
		    
		  
			assertEquals(BSTTraverse.print(), "2 3 10 15 ");
	  }
      
	  @Test
	  public void testBFT() {
		
		    dict.insert(10, "10");
			dict.insert(2,"2");
			dict.insert(3, "3");
			dict.insert(15,"15");
		
			BSTTraverse.clear();

			BSTTraverse.breathFirstTraverse(dict.getRoot());
		    
		  
			assertEquals("10 2 3 15 ",BSTTraverse.print());
	  }

	  @Test	
	  public void testCount() {
		  dict.insert(10, "10");
			dict.insert(2,"2");
			dict.insert(3, "3");
			dict.insert(15,"15");
			
			BSTTraverse.clear();

	   
	    assertEquals(4, BSTTraverse.count(dict.getRoot()));
	  }

	  // The following tests for checkBST are a little dicey. The book
	  // code uses a simple BinNode abstract class. Syntactically, this
	  // works fine since the function uses only base class
	  // functionality. But logically, this works only so long as the key
	  // and element of the BSTNode are the same (since BinNode.element()
	  // returns the element, not the key). 

	  @Test
	  public void testBSTa() {
		dict.insert(10, "10");
		dict.insert(2,"2");
		dict.insert(3, "3");
		dict.insert(15,"15");
		
		BSTTraverse.clear();

	   
	    assertEquals(true, 
	    		BSTTraverse.checkBST(dict.getRoot(), 
	    				Integer.valueOf(-1), Integer.valueOf(1000)));
	  }
      
	 
	
}
