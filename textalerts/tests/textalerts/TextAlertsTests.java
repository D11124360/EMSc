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
	
	// Test number 7.
       @Test
       public void supportersShouldBeHappyWhenTeamScores() {
               MatchAttender attender = new MatchAttender();
               AbsentFan john = new AbsentFan("John", attender, "Home");
               AbsentFan jane = new AbsentFan("Jane", attender, "Away");
               john.subscribeToAlerts();
               jane.subscribeToAlerts();
               attender.registerScore("Home", 12, "Balotelli");
               assertTrue(john.isHappy());
               assertFalse(jane.isHappy());
               attender.registerScore("Away", 44, "Fletcher");
               assertFalse(john.isHappy());
               assertTrue(jane.isHappy());
       }

       // Test number 8.
       @Test
       public void supportersShouldKnowOtherDetails() {
               MatchAttender attender = new MatchAttender();
               AbsentFan john = new AbsentFan("John", attender, "Home");
               AbsentFan jane = new AbsentFan("Jane", attender, "Away");
               john.subscribeToAlerts();
               jane.subscribeToAlerts();
               attender.registerScore("Home", 12, "Balotelli");
               assertEquals("Balotelli", john.getLastScorer());
               assertEquals(12, john.getTimeOfLastGoal());
       }

       // Test number 9.
       @Test
       public void sportsReportersCanBeNotified() {
               MatchAttender attender = new MatchAttender();
               SportsReporter megan = new SportsReporter("Megan", attender);
               megan.subscribeToAlerts();
               attender.registerScore("Home", 12, "Balotelli");
               assertEquals("Balotelli has scored for the Home team in the 12th minute."
                               , megan.getLastReport());
               attender.registerScore("Away", 43, "Fletcher");
               assertEquals("Fletcher has scored for the Away team in the 43rd minute."
                               , megan.getLastReport());
       }

       // Test number 10.
       @Test
       public void footballScoutCanBeNotified() {
               MatchAttender attender = new MatchAttender();
               FootballScout fred = new FootballScout("Fred", attender);
               fred.subscribeToAlerts();
               assertFalse(fred.isInterestedIn("Balotelli"));
               attender.registerScore("Home", 12, "Balotelli");
               assertTrue(fred.isInterestedIn("Balotelli"));

       }
}