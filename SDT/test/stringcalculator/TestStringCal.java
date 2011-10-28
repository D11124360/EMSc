/**
 * 
 */
package stringcalculator;


import static org.junit.Assert.*;
import org.junit.Test;

/**
 * @author D11124360
 *
 */
public class TestStringCal {
	
	
	@Test
	public void addNothing(){
		int x = StringCal.add("");
		assertEquals(0,x);
	}
	@Test
	public void addOneNumber(){
		int x = StringCal.add("5");
		assertEquals(5,x);
	}
	
	@Test
	public void addTwoNumber(){
		int x = StringCal.add("5,68");
		assertEquals(73,x);
	}
	
	@Test
	public void addManyNumber(){
		int x = StringCal.add("5,68,10");
		assertEquals(83,x);
	}
	
	@Test
	public void addNumbersWithNewLine(){
		int x = StringCal.add("1\n2,3");
		assertEquals(6,x);
	}
	
	@Test
	public void commaWithNewLine(){
		int x = StringCal.add("1,\n2");
		assertEquals(6,x);
	}
	
	@Test
	public void changeTheDelimiter(){
		int x = StringCal.add("//;\n1;2");
		assertEquals(3,x);
	}
	
	@Test
	public void checkNewDelimiter(){
		int x = StringCal.add("4;1;2");
		assertEquals(7,x);
	}
	
	@Test
	public void throwExceptionForNegativeNumbers(){
		
		try {
			int x = StringCal.add("-4;1;2");
			fail("Exception expected");
		} catch (RuntimeException e) {
			//
			
		}
	}
	
}
