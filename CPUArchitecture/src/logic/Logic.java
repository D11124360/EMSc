/**	In Digital Electronics, Logic (with boolean algebra) are used for model the functionality of Digital Electronic
 *  entities. Logic values such as '0' (false) and '1' (true) are represented by using different voltage levels. 
 *  In here we have to model that voltage levels or Logic values.
 *  
 *  For this version, we only considering logic values of '0' and '1'.(In real Digital Electronics there are so 
 *  many values exist. But here we only considering BIT values)
 *  
 *  Represent the Bit values by using boolean data type. (false and true)
 *  
 *  User can use char types '0' and '1' to access the original bit representation of Logic
 * 
 */

package logic;

import exception.IllegalLogicValue;

/**
 * @author W Vajira Kuruppuarachchi
 * 
 *
 */
public class Logic {
	 
	private boolean logicValue;
	
	
	/**
	 * @param logicValue the value to set
	 */
	public void writeLogic(boolean logicValue) {
		this.logicValue = logicValue;
	}


	/**
	 * @return the value bit
	 */
	public boolean readLogic() {

		return logicValue;
	}

	/**
	 * @param bit set the char value 
	 * @throws IllegalLogicValue 
	 */
	public void writeLogic(char bit) throws IllegalLogicValue {
		if (bit == '1')
			writeLogic(true);
		else if (bit == '0')
			writeLogic(false);
		else 
			throw new IllegalLogicValue("Logic value must be '0' or '1'");		
	}

	/**
	 * @return the char value of bit
	 */
	public char readLogicByUser() {
		if (readLogic() == false)
			return '0';
		else 
			return '1';
	}

}
