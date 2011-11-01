package logic;

import exception.IllegalLogicValue;
import exception.IllegalVectorLogicSize;

/**
 * @author W Vajira Kuruppuarachchi
 * 
 *
 */
public class VectorLogic {
	private int vectorSize;
	private boolean [] vectorLogicValue;
	
	
	/**
	 * @param vectorSize
	 */
	public VectorLogic(int vectorSize) {
		super();
		this.vectorSize = vectorSize;
		this.vectorLogicValue = new boolean [vectorSize];

	}


	/**
	 * @return the vectorLogicValue
	 */
	public boolean[] readVectorLogic() {
		return vectorLogicValue;
	}


	/**
	 * @param vectorLogicValue the vectorLogicValue to set
	 */
	public void writeVectorLogic(boolean[] vectorLogicValue) {
		this.vectorLogicValue = vectorLogicValue;
	}


	/**
	 * @param vectorLogicValue the vectorLogicValue to set
	 * @throws IllegalLogicValue 
	 * @throws IllegalVectorLogicSize 
	 */
	public void writeVectorLogic(String vectorLogicValue) throws IllegalLogicValue, IllegalVectorLogicSize{
		
		if (vectorLogicValue.length() == this.vectorLogicValue.length) {
			String[] temp = vectorLogicValue.split("");
			for (int a = 0; a < vectorSize; a++) {
				if (temp[a] == "1")
					this.vectorLogicValue[a] = true;
				else if (temp[a] == "0")
					this.vectorLogicValue[a] = false;
				else
					throw new IllegalLogicValue("Logic value must be '0' or '1'");
			}
		}
		else
			throw new IllegalVectorLogicSize("Size of Vector Logic must be " + this.vectorLogicValue.length );
		
	}
	
	/**
	 * @return vectorLogicValue the vectorLogicValue to set
	 */
	public String getVectorLogicValueString() {
		String temp ="";
		for(int a=0; a<this.vectorLogicValue.length; a++){
			if(vectorLogicValue[a] == true)
				temp = temp.concat("1");
			else if(vectorLogicValue[a] == false)
				temp = temp.concat("0");
		}
		return temp;
	}
	
	

}
