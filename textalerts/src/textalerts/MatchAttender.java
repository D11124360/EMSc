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
	
	private int homeTeamScore = 0;
	private int awayTeamScore = 0;
	private int timeOfLastGoal = 0;
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
			homeTeamScore++;
		}
		else if (team == "Away"){
			awayTeamScore++;
		}
		
	}
	
	public void registerScore(String team, int time, String player){
		if (team == "Home"){
			homeTeamScore++;
			
		}
		else if (team == "Away"){
			awayTeamScore++;
		}
		
		timeOfLastGoal = time;
		lastScorer = player;
		messageCount++;
		sendMessage();
		
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
			x.setScore(getScore());
		}
		
	}

}
