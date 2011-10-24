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
	

	
}
