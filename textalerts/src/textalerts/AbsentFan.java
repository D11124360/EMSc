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
	private String Score;
	
	/**
	 * @param fanName
	 */
	public AbsentFan(String fanName, MatchAttender matchAttender) {
		super();
		this.name = fanName;
		this.matchAttender = matchAttender;
	}
	
	public AbsentFan(String fanName) {
		super();
		this.name = fanName;
		
	}

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

	public void subscribeToAlerts(){
		matchAttender.subscribe(this);
	
	}

	/**
	 * @return the score
	 */
	public String getScore() {
		
		return Score;
	}

	/**
	 * @param score the score to set
	 */
	public void setScore(String score) {
		Score = score;
	}
	
	

}
