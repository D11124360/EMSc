package textalerts;

import static org.junit.Assert.*;

import org.junit.Test;

public class TextAlertsTests {
	
	// Test number 1.
	@Test
	public void shouldInitiallyAnswerThatGameIsScoreless() {
		MatchAttender attender = new MatchAttender();
		assertEquals("0-0", attender.getScore());
	}

	// Test number 2.
	@Test
	public void shouldUpdateScoreCorrectly() {
		MatchAttender attender = new MatchAttender();
		attender.registerScore("Home");
		assertEquals("1-0", attender.getScore());
		attender.registerScore("Home");
		assertEquals("2-0", attender.getScore());
		attender.registerScore("Away");
		assertEquals("2-1", attender.getScore());
	}

	// Test number 3.
	@Test
	public void shouldKnowTimeOfLastGoal() {
		MatchAttender attender = new MatchAttender();
		attender.registerScore("Home", 22, "Balotelli");
		assertEquals(22, attender.getTimeOfLastGoal());
	}

	// Test number 4.
	@Test
	public void shouldKnowLastScorer() {
		MatchAttender attender = new MatchAttender();
		attender.registerScore("Away", 22, "Balotelli");
		assertEquals("Balotelli", attender.getLastScorer());
	}
	
	// Test number 5.
	@Test
	public void absentFansInitiallyHaveNoTextMessages() {
		AbsentFan john = new AbsentFan("John");
		assertEquals("John", john.getName());
		assertEquals(0, john.getTextMessageCount());
	}

	// Test number 6.
	@Test
	public void shouldNotifyAbsentFansWhoAreSubscribed() {
		MatchAttender attender = new MatchAttender();
		AbsentFan john = new AbsentFan("John", attender);
		john.subscribeToAlerts();		
		attender.registerScore("Home", 12, "Balotelli");
		assertEquals(1, john.getTextMessageCount());
		assertEquals("1-0", john.getScore());
		attender.registerScore("Home", 44, "Aguero");
		assertEquals(2, john.getTextMessageCount());
		assertEquals("2-0", john.getScore());
	}

}
