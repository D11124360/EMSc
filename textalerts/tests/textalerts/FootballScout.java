package textalerts;

public class FootballScout extends AbsentFan {

	/**
	 * @param name
	 * @param matchAttender
	 */
	public FootballScout(String fanName, MatchAttender matchAttender) {
		super(fanName, matchAttender);
		
	}

	public boolean isInterestedIn(String scorer) {
		if(super.getLastScorer() == scorer)
			return true;
		else
			return false;
	}

	
	
}
