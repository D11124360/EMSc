/**
 * 
 */
package memory;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author W Vajira Kuruppuarachchi
 *
 */
public class MemoryTest {

	private Memory memory;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		 memory = new Memory(8, 32, 10, 20);
	}
	
	
	/*	Test Case 01
	 *  Memory
	 * 	Testing of get methods
	 */
	@Test
	public void testGetMethodsOfMemory() {
		assertEquals(8, memory.getWordSize());
		assertEquals(32, memory.getMemorySize());
		assertEquals(10, memory.getReadTime());
		assertEquals(20, memory.getWriteTime());
		
	}
	
	/*	Test Case 02
	 *  Read memory by using given address
	 * 	
	 */
	@Test
	public void readMemoryByGivenAddress() {
		memory.selected();
		memory.setRead();
		assertEquals("00000000", memory.readMemory(10));	
	}
	
	/*	Test Case 03
	 *  When trying to Read memory by using out of range address
	 *  It should raise Exception
	 * 	
	 */
	@Test
	public void raiseExceptionWhenTryingToReadOutOfRange() {
		memory.selected();
		memory.setRead();
		assertEquals("00010000", memory.readMemory(1000));	
	}
}
