package marriages;

import static org.junit.Assert.*;
import org.junit.Test;

public class MarriagesTest {
	private Person jack = new Person("Jack");
	private Person jill = new Person("Jill");
	private Person fred = new Person("Fred");
	@Test
	public void personIsSingleByDefault(){
		assertTrue(jack.isSingle());		
	}
	
	@Test
	public void marryCausesFirstPersonToBeMarried() throws BigMyException{
		jack.marry(jill);
		assertTrue(jack.isMarried());
		assertEquals(jack.getSpouse(), jill);
		fail();
	}
	
	@Test
	public void marryCausesSecondPersonToBeMarried(){
		jack.marry(jill);
		assertTrue(jill.isMarried());
		assertEquals(jill.getSpouse(), jack);
	}
	
	@Test
	public void marryDoesNotremarryMarriedPeople(){
		jack.marry(jill);
		jack.marry(fred);
		assertTrue(jill.isMarried());
		assertEquals(jill.getSpouse(), jack);
		assertFalse(fred.isMarried());
	}
	
	

}
