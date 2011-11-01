/**
 * 
 */
package logic;

import static org.junit.Assert.*;

import org.junit.Test;

import exception.IllegalLogicValue;
import exception.IllegalVectorLogicSize;

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
		assertEquals("1010",vectorlogic.getVectorLogicValueString());
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
	
	
}
