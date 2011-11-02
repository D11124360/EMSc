/**
 * 
 */
package textalerts;

/**
 * @author D11124360
 *
 */
public class SportsReporter extends AbsentFan{
	
	
	/**
	 * @param name
	 * @param matchAttender
	 */
	public SportsReporter(String name, MatchAttender matchAttender) {
	
		super(name,matchAttender);
	}


	public String getLastReport() {
		
		return "" + super.getLastScorer() +" has scored for the " + super.getTeamLastGoal() + " team in the " + super.getTimeOfLastGoal() + this.something(Integer.toString(super.getTimeOfLastGoal())) + " minute.";
	}
	
	private String something(String number){
		if(number.endsWith("11"))
			return "th";
		else if(number.endsWith("12"))
			return "th";
		else if(number.endsWith("13"))
			return "th";
		else if(number.endsWith("1"))
				return "st";
		else if(number.endsWith("2"))
				return "nd";
		else if(number.endsWith("3"))
				return "rd";		
		else
			return "th";
			
		
		
				
				
		
	}
	
	

}
