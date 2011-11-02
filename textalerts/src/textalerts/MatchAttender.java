/**
 * 
 */
package textalerts;

import java.util.ArrayList;

/**
 * @author D11124360
 *
 */
public class MatchAttender {
	
	// Knowledge of Match 
	private int homeTeamScore = 0;
	private int awayTeamScore = 0;
	private int timeOfLastGoal = 0;
	private String teamLastGoal;
	private String lastScorer;
	
	
	private int messageCount = 0;
	private ArrayList<AbsentFan> subscriber = new ArrayList<AbsentFan> ();
	
	
	public void subscribe(AbsentFan e){
		subscriber.add(e);
		
	}
	/**
	 * @return the homeTeamScore
	 */
	public int getHomeTeamScore() {
		return homeTeamScore;
	}

	/**
	 * @return the awayTeamScore
	 */
	public int getAwayTeamScore() {
		return awayTeamScore;
	}

	public String getScore(){
		return "" + homeTeamScore + "-" + awayTeamScore;
	}
	
	
	/**
	 * @return the messageCount
	 */
	public int getMessageCount() {
		return messageCount;
	}

	public void registerScore(String team){
		if (team == "Home"){
			updateHomeScore();
		}
		else if (team == "Away"){
			updateAwayScore();
		}
		
	}
	
	public void registerScore(String team, int time, String player){
		if (team == "Home"){
			updateHomeScore();
			
		}
		else if (team == "Away"){
			updateAwayScore();
		}
		
		timeOfLastGoal = time;
		lastScorer = player;
		messageCount++;
		sendMessage();
		
	}
	
	private void updateAwayScore() {
		awayTeamScore++;
		teamLastGoal = "Away";
	}
	
	private void updateHomeScore() {
		homeTeamScore++;
		teamLastGoal = "Home";
	}
	
	
	public int getTimeOfLastGoal(){
		return timeOfLastGoal;
		
	}
	
	public String getLastScorer(){
		return lastScorer;
	}
	
	private void sendMessage(){
		int a;
		for (AbsentFan x:subscriber){
			a = x.getTextMessageCount();
			x.setTextMessageCount((++a));
			x.setAwayTeamScore(awayTeamScore);
			x.setHomeTeamScore(homeTeamScore);
			x.setLastScorer(lastScorer);
			x.setTimeOfLastGoal(timeOfLastGoal);
			x.setTeamLastGoal(teamLastGoal);
		}
		
	}

}
