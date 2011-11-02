/**
 * 
 */
package logic;

import static org.junit.Assert.*;

import org.junit.Test;

import exception.IllegalLogicValue;
import exception.IllegalVectorLogicSize;
import exception.VectorLogicOutOfRange;

/**
 * @author W Vajira Kuruppuarachchi
 *
 */
public class VectorLogicTest {


	/*Test Case 1
	 *  vector logic is represented using boolean array
	 * 	get method for read that value
	 */
	@Test
	public void bitArrayshouldRepresentedByUsingBooleanArray() {
		VectorLogic vectorlogic = new VectorLogic(4);
		boolean [] value;
		value = vectorlogic.readVectorLogic();
		assertEquals(4,value.length);
	}
	
	/*Test Case 2
	 * 
	 * set method for write the value
	 */
	@Test
	public void setTheVectorLogicValue() {
		VectorLogic vectorlogic = new VectorLogic(4);
		boolean [] value =  {true,false,true,false};
		vectorlogic.writeVectorLogic(value);
		assertEquals(4,vectorlogic.readVectorLogic().length);
	}
	
	/*Test Case 3
	 * 
	 * write vector logic value by using String of '0' and '1'
	 */
	@Test
	public void writeVectorLogicValueAsString() {
		VectorLogic vectorlogic = new VectorLogic(4);
		try {
			vectorlogic.writeVectorLogic("1010");
		} catch (IllegalLogicValue e) {
		
		} catch (IllegalVectorLogicSize e) {
			
		}
		
	}
	
	/*Test Case 4
	 * 
	 * read vector logic value by using String of '0' and '1'
	 */
	@Test
	public void readVectorLogicValueAsString() {
		VectorLogic vectorlogic = new VectorLogic(4);
		boolean [] value =  {true,false,true,false};
		vectorlogic.writeVectorLogic(value);
		assertEquals("1010",vectorlogic.readVectorLogicString());
	}
	
	/*Test Case 5
	 * 
	 * String must contains only '0' and '1'. Otherwise raise IllegalLogicValue exception
	 */
	@Test
	public void shouldRaiseExceptionForOtherStringValues() {
		VectorLogic vectorlogic = new VectorLogic(4);
		try {
			vectorlogic.writeVectorLogic("10g0");
			fail("Exception Expected");
		} catch (IllegalLogicValue ilv) {
			assertEquals("Logic value must be '0' or '1'", ilv.getMessage());
		} catch (IllegalVectorLogicSize e) {
			
		}
		
	}
	
	/*Test Case 6
	 * 
	 * Size of the input String must be match with vector logic value. Otherwise 
	 * raise IllegalVectorLogicSize exception
	 */
	@Test
	public void shouldRaiseExceptionWhenStringLengthIsNotMatch() {
		VectorLogic vectorlogic = new VectorLogic(4);
		try {
			vectorlogic.writeVectorLogic("100000");
			fail("Exception Expected");
		} catch (IllegalVectorLogicSize ils) {
			assertEquals("Size of Vector Logic must be 4", ils.getMessage());
		} catch (IllegalLogicValue e) {
			
		}
	}
	
	/*Test Case 7
	 * 
	 * Bit wise access to Vector Logic
	 * Read Bit Wise
	 */
	@Test
	public void readVectorLogigBitWise(){
		VectorLogic vectorlogic = new VectorLogic(3);
		boolean [] value =  {true,true,true};
		vectorlogic.writeVectorLogic(value);
		try {
			assertEquals(true,vectorlogic.readBitWise(2));
		} catch (VectorLogicOutOfRange vlr) {
			
		}	
	}
	
	/*Test Case 8
	 * 
	 * It should raise Exception for out of range of vector logic
	 * Show the correct range in exception message
	 */
	@Test
	public void raiseExceptionWhenTryToReadOutOfRange(){
		VectorLogic vectorlogic = new VectorLogic(3);
		boolean [] value =  {true,true,true};
		vectorlogic.writeVectorLogic(value);
		try {
			assertEquals(true,vectorlogic.readBitWise(6));
			fail("Exception Expected");
		} catch (VectorLogicOutOfRange vlr) {
			assertEquals("Index is out of range of Vector Logic. It should be: 1-3",vlr.getMessage());
		}		
	}
	
	/*Test Case 9
	 * 
	 * Bit wise access to Vector Logic
	 * write Bit Wise
	 */
	@Test
	public void writeVectorLogigBitWise() throws VectorLogicOutOfRange{
		VectorLogic vectorlogic = new VectorLogic(3);
		vectorlogic.writeBitWise(2,true);
		assertEquals(true,vectorlogic.readBitWise(2));
	
	}
	
	/*Test Case 10
	 * 
	 * It should raise Exception for trying to write out of range of vector logic location
	 * Show the correct range in exception message
	 */
	@Test
	public void raiseExceptionWhenTryToWriteOutOfRange() throws VectorLogicOutOfRange{
		VectorLogic vectorlogic = new VectorLogic(3);
		try {
			vectorlogic.writeBitWise(5,true);
			fail("Exception Expected");
		} catch (VectorLogicOutOfRange vlr) {
			assertEquals("Index is out of range of Vector Logic. It should be: 1-3",vlr.getMessage());
		}
	}
	
	/*Test Case 11
	 * 
	 * Bit wise access to Vector Logic
	 * Read char value of vector logic Bit Wise
	 * It should raise Exception for trying to read out of range of vector logic location
	 * Show the correct range in exception message
	 */
	@Test
	public void readVectorLogigBitWiseChar(){
		VectorLogic vectorlogic = new VectorLogic(3);
		boolean [] value =  {true,true,true};
		vectorlogic.writeVectorLogic(value);
		try {
			assertEquals('1',vectorlogic.readBitWiseChar(2));
		} catch (VectorLogicOutOfRange vlr) {
			
		}	
	}
	
	/*Test Case 12
	 * 
	 * Bit wise access to Vector Logic
	 * write char value of vector logic Bit Wise
	 * It should raise Exception for trying to read out of range of vector logic location
	 * Show the correct range in exception message
	 */
	@Test
	public void writeVectorLogigBitWiseChar(){
		VectorLogic vectorlogic = new VectorLogic(3);
		boolean [] value =  {true,true,true};
		vectorlogic.writeVectorLogic(value);
		try {
			vectorlogic.writeBitWise(2, '0');
			assertEquals('0',vectorlogic.readBitWiseChar(2));
		} catch (VectorLogicOutOfRange vlr) {
			
		} catch (IllegalLogicValue e) {
			
		}	
	}
}
