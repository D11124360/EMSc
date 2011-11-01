package logic;

import exception.IllegalLogicValue;
import exception.IllegalVectorLogicSize;
import exception.VectorLogicOutOfRange;

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

	/**
	 * @param index of vector logic 
	 * @return vectorLogicValue the boolean value of vectorLogicValue[index]
	 * @throws VectorLogicOutOfRange 
	 */
	public boolean readBitWise(int index) throws VectorLogicOutOfRange {
		
		if ((0 < index) && (index <= vectorLogicValue.length ))
				return vectorLogicValue[index];
		else
				throw new VectorLogicOutOfRange("Index is out of range of Vector Logic. It should be: 1-" + vectorLogicValue.length);
	}

	/**
	 * @param index of vector logic 
	 * @param value of bit
	 * @throws VectorLogicOutOfRange 
	 */
	public void writeBitWise(int index, boolean value) throws VectorLogicOutOfRange{
		if ((0 < index) && (index <= vectorLogicValue.length ))
			this.vectorLogicValue[index] = value;
	else
			throw new VectorLogicOutOfRange("Index is out of range of Vector Logic. It should be: 1-" + vectorLogicValue.length);
		
		
	}

	/**
	 * @param index of vector logic 
	 * @return vectorLogicValue the char value of vectorLogicValue[index]
	 * @throws VectorLogicOutOfRange 
	 */
	public char readBitWiseChar(int index) throws VectorLogicOutOfRange {
		if ((0 < index) && (index <= vectorLogicValue.length ))
			return changeToChar(vectorLogicValue[index]);
	else
			throw new VectorLogicOutOfRange("Index is out of range of Vector Logic. It should be: 1-" + vectorLogicValue.length);
	}
	
	
	
	
	
	private char changeToChar(boolean value){
		if(value == true)
			return '1';
		else 
			return '0';		
	}
	
	private boolean changeToBoolean(char value) throws IllegalLogicValue{
		if (value == '1')
			return true;
		else if (value == '0')
			return false;
		else 
			throw new IllegalLogicValue("Logic value must be '0' or '1'");	
	}

	/**
	 * @param index of vector logic 
	 * @param value of bit
	 * @throws IllegalLogicValue 
	 * @throws VectorLogicOutOfRange  
	 */
	public void writeBitWise(int index, char value) throws IllegalLogicValue, VectorLogicOutOfRange {
		if ((0 < index) && (index <= vectorLogicValue.length ))
			this.vectorLogicValue[index] = changeToBoolean(value);
	else
			throw new VectorLogicOutOfRange("Index is out of range of Vector Logic. It should be: 1-" + vectorLogicValue.length);
	}

}
