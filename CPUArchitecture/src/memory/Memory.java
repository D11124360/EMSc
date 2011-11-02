/**
 * 
 */
package memory;

import exception.VectorLogicOutOfRange;
import logic.VectorLogic;

/**
 * @author W Vajira Kuruppuarachchi
 * 
 *
 */
public class Memory {
	private int readTime;
	private int writeTime;
	private int wordSize;
	private int memorySize;
	private VectorLogic [] memory;
	
	private boolean selected;
	private boolean readWrite;
	
	private final boolean SET = true;
	private final boolean CLEAR = false;
	
	
	/**
	 * @param readTime
	 * @param writeTime
	 * @param wordSize
	 * @param memorySize
	 * @throws VectorLogicOutOfRange 
	 */
	public Memory(int wordSize, int memorySize,int readTime, int writeTime) throws VectorLogicOutOfRange {
		super();
		this.readTime = readTime;
		this.writeTime = writeTime;
		this.wordSize = wordSize;
		this.memorySize = memorySize;
		this.selected = false;
		this.readWrite = false;
		
		memory = new VectorLogic [this.memorySize];
		this.initialsizeMemory();
	}


	/**
	 * @return the readTime
	 */
	public int getReadTime() {
		return readTime;
	}


	/**
	 * @return the writeTime
	 */
	public int getWriteTime() {
		return writeTime;
	}


	/**
	 * @return the wordSize
	 */
	public int getWordSize() {
		return wordSize;
	}


	/**
	 * @return the memorySize
	 */
	public int getMemorySize() {
		return memorySize;
	}


	public void selected() {
		this.selected = SET;		
	}

	public void setRead() {
		this.readWrite = CLEAR;		
	}

	

	public String readMemory(int address) {
		if((0 < address) && (address < this.memorySize))
			return memory[address].readVectorLogicString();
		else
			return "11110000";
	}
	
	private void initialsizeMemory() throws VectorLogicOutOfRange{
		for(int a = 0; a < this.memorySize; a++)
			for(int b = 1; b <= this.wordSize; b++){
				memory[a] = new VectorLogic(wordSize);
				memory[a].writeBitWise(b, false);
			}
		
	}

	
}
