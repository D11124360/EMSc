/**
 * 
 */
package memory;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import exception.IllegalLogicValue;
import exception.IllegalVectorLogicSize;
import exception.MemoryException;

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
	public void readMemoryByGivenAddress() throws MemoryException {
		memory.selected();
		memory.setRead();
		assertEquals("00000000", memory.readMemory(10));	
	}
	
	/*	Test Case 03
	 *  When trying to Read memory by using out of range address
	 *  It should raise Exception
	 * 	upper boundary
	 */
	@Test
	public void raiseExceptionWhenTryingToReadOutOfRangeUpper() {
		memory.selected();
		memory.setRead();
		try {
			assertEquals("00000000", memory.readMemory(9100));
			fail("Exception Expected");
		} catch (MemoryException mr) {
			assertEquals("Address is out of range of Memory. It should be: 0-31",mr.getMessage());
			
		}	
		
	}
	
	/*	Test Case 04
	 *  When trying to Read memory by using out of range address
	 *  It should raise Exception
	 * 	lower boundary
	 */
	@Test
	public void raiseExceptionWhenTryingToReadOutOfRangeLower() {
		memory.selected();
		memory.setRead();
		try {
			assertEquals("00000000", memory.readMemory(-10));
			fail("Exception Expected");
		} catch (MemoryException mr) {
			assertEquals("Address is out of range of Memory. It should be: 0-31",mr.getMessage());
			
		}	
	}
	
	/*	Test Case 05
	 *  
	 *  Write memory 
	 */
	@Test
	public void writemoryByGivenAddressAndData() throws MemoryException, IllegalLogicValue, IllegalVectorLogicSize {
		memory.selected();
		memory.setwrite();
		memory.writeMemory(10,"00000011");
		assertEquals("00000011", memory.readMemory(10));
			
		
	}
	
	/*	Test Case 06
	 *  
	 *  Write memory 
	 *  upper boundary
	 */
	@Test
	public void raiseExceptionWhenTryingToWriteOutOfRangeUpper() throws IllegalLogicValue, IllegalVectorLogicSize {
		memory.selected();
		memory.setwrite();
		try {
			memory.writeMemory(550,"00000011");
			fail("Exception Expected");
		} catch (MemoryException mr) {
			assertEquals("Address is out of range of Memory. It should be: 0-31",mr.getMessage());
		}
		//assertEquals("00000011", memory.readMemory(10));
			
		
	}
	
	/*	Test Case 07
	 *  
	 *  Write memory 
	 *  upper boundary
	 */
	@Test
	public void raiseExceptionWhenTryingToWriteOutOfRangeLower() throws IllegalLogicValue, IllegalVectorLogicSize {
		memory.selected();
		memory.setwrite();
		try {
			memory.writeMemory(-10,"00000011");
			fail("Exception Expected");
		} catch (MemoryException mr) {
			assertEquals("Address is out of range of Memory. It should be: 0-31",mr.getMessage());
		}
			
		
	}
}
