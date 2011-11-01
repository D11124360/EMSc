/**	In Digital Electronics, Logic (with boolean algebra) are used for model the functionality of Digital Electronic
 *  entities. Logic values such as '0' (false) and '1' (true) are represented by using different voltage levels. 
 *  In here we have to model that voltage levels or Logic values.
 *  
 *  For this version, we only considering logic values of '0' and '1'.(In real Digital Electronics there are so 
 *  many values exist. But here we only considering BIT values)
 * 
 */
package logic;

import static org.junit.Assert.*;

import org.junit.Test;

import exception.IllegalLogicValue;

/**
 * @author W Vajira Kuruppuarachchi
 * 
 *
 */
public class LogicTest {


	/* test case  1	
	 * Bit is represented in here using boolean data type
	 * 	Class name is Logic.									
	 */
	@Test
	public void logicRepresetedUsingBoolean() {
		Logic logic = new Logic();
		assertEquals(false,logic.readLogic());
	}
	
	/* test case 2
	 * Set the value of Logic							
	 */
	@Test
	public void getTheVlueOfLogic() {
		Logic logic = new Logic();
		logic.writeLogic(true);
		assertEquals(true,logic.readLogic());
	}
	
	/* test case 3
	 *
	 * Set the logic value using char 							
	 */
	@Test
	public void userSetTheLogicValue() {
		Logic logic = new Logic();
		try {
			logic.writeLogic('1');
		} catch (IllegalLogicValue ilv) {
			
		}
		assertEquals(true,logic.readLogic());
	}
	
	/* test case 4
	 * 
	 * Get the logic value using char							
	 */
	@Test
	public void userGetTheLogicValue() {
		Logic logic = new Logic();
		logic.writeLogic(true);
		assertEquals('1',logic.readLogicByUser());
	}
	
	/* test case 5
	 * Give error message " Logic value must be '0' or '1'  "
	 * when try to use characters other than '0' and '1'
	 * 			Raise exception				
	 */
	@Test
	public void shouldRaiseExceptionForOtherChar() {
		Logic logic = new Logic();
		
		try {
			logic.writeLogic('2');
			fail("Exception Expected");
		} catch (IllegalLogicValue ilv) {
			
		}
		
	}
	
	/* test case 5
	 * Give error message " Logic value must be '0' or '1'  "
	 * when try to use characters other than '0' and '1'
	 * 		Exception message				
	 */
	@Test
	public void exceptionMessageShouldMatch() {
		Logic logic = new Logic();
		
		try {
			logic.writeLogic('2');
			fail("Exception Expected");
		} catch (IllegalLogicValue ilv) {
			assertEquals("Logic value must be '0' or '1'",ilv.getMessage());
			
		}
		//assertEquals('1',logic.getLogicValueByUser());
	}
	
}
