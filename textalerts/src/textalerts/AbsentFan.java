/**
 * 
 */
package textalerts;

/**
 * @author D11124360
 *
 */
public class AbsentFan {
	
	private String name;
	private int textMessageCount =0;
	private MatchAttender matchAttender;
	private int homeTeamLastScore = 0;
	private int awayTeamlastScore = 0;
	// Knowledge of Match 
	private int homeTeamScore = 0;
	private int awayTeamScore = 0;
	private int timeOfLastGoal = 0;
	private String lastScorer;
	private String teamLastGoal;
	private String team;

	
	/** 	Constructor coding starting from here		**/
	
	/**
	 * @param fanName
	 */
	public AbsentFan(String fanName) {
		super();
		this.name = fanName;
		
	}
	
	/**
	 * @param fanName
	 * @param matchAttender
	 */
	public AbsentFan(String fanName, MatchAttender matchAttender) {
		
		this(fanName);
		this.matchAttender = matchAttender;
	}
	
	/**
	 * @param name
	 * @param matchAttender
	 * @param team
	 */
	public AbsentFan(String name, MatchAttender matchAttender, String team) {
		this(name, matchAttender);
		this.team = team;
	}

	/** 	Constructor coding ending from here		**/
	
	/** 	Getter and Setter methods starting from here		**/
	
	/**
	 * @return the fanName
	 */
	public String getName() {
		return name;
	}
	
	public int getTextMessageCount(){
	
		return textMessageCount;
	}

	/**
	 * @param textMessageCount the textMessageCount to set
	 */
	public void setTextMessageCount(int textMessageCount) {
		this.textMessageCount = textMessageCount;
	}

	
	/**
	 * @return the score
	 */
	public String getScore() {
		
		return "" + homeTeamScore + "-" + awayTeamScore;
	}

	/**
	 * @return the homeTeamScore
	 */
	public int getHomeTeamScore() {
		return homeTeamScore;
	}

	/**
	 * @param homeTeamScore the homeTeamScore to set
	 */
	public void setHomeTeamScore(int homeTeamScore) {
		homeTeamLastScore = this.homeTeamScore;
		this.homeTeamScore = homeTeamScore;
		
	}

	
	/**
	 * @return the awayTeamScore
	 */
	public int getAwayTeamScore() {
		return awayTeamScore;
	}

	/**
	 * @param awayTeamScore the awayTeamScore to set
	 */
	public void setAwayTeamScore(int awayTeamScore) {
		awayTeamlastScore = this.awayTeamScore;
		this.awayTeamScore = awayTeamScore;
	}

	
	/**
	 * @return the lastScorer
	 */
	public String getLastScorer() {
		return lastScorer;
	}

	/**
	 * @param lastScorer the lastScorer to set
	 */
	public void setLastScorer(String lastScorer) {
		this.lastScorer = lastScorer;
	}

	
	
	/**
	 * @param timeOfLastGoal the timeOfLastGoal to set
	 */
	public void setTimeOfLastGoal(int timeOfLastGoal) {
		this.timeOfLastGoal = timeOfLastGoal;
	}
		
	/**
	 * @return the timeOfLastGoal
	 */
	public int getTimeOfLastGoal() {
		return timeOfLastGoal;
	}
		
	
	
	/**
	 * @return the teamLastGoal
	 */
	public String getTeamLastGoal() {
		return teamLastGoal;
	}

	/**
	 * @param teamLastGoal the teamLastGoal to set
	 */
	public void setTeamLastGoal(String teamLastGoal) {
		this.teamLastGoal = teamLastGoal;
	}

	/** 	Getter and Setter methods ending from here		**/
	
	
	

	public void subscribeToAlerts(){
		matchAttender.subscribe(this);
	
	}

	public boolean isHappy() {
		return teamLastScored();
				
	}

	/**
	 * @return
	 */
	private boolean teamLastScored() {
		if (team == "Home")
		{
			if((homeTeamScore - homeTeamLastScore )> 0)
				return true;
			else
				return false;		
		}
		else 
		{
			if((awayTeamScore - awayTeamlastScore) > 0)
				return true;
			else
				return false;
		}
	}

	
	
	

}
