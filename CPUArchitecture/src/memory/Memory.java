/**
 * 
 */
package memory;

import exception.IllegalLogicValue;
import exception.IllegalVectorLogicSize;
import exception.MemoryException;
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
	
	public void unSelected() {
		this.selected = CLEAR;		
	}

	public void setRead() {
		this.readWrite = CLEAR;		
	}

	public void setwrite() {
		this.readWrite = SET;	
		
	}

	
	/**
	 * @throws MemoryException
	 * @param address the address of the memory
	 * @return the data from the memory
	 *  
	 */
	public String readMemory(int address) throws MemoryException {
		
			if ((0 < address) && (address < this.memorySize))
				return memory[address].readVectorLogicString();
			else
				throw new MemoryException(
						"Address is out of range of Memory. It should be: 0-"
								+ (memorySize - 1));
		
	}
	
	private void initialsizeMemory() throws VectorLogicOutOfRange{
		for(int a = 0; a < this.memorySize; a++)
			for(int b =0; b < this.wordSize; b++){
				memory[a] = new VectorLogic(wordSize);
				memory[a].writeBitWise(b, false);
			}
		
	}

	/**
	 * @throws IllegalVectorLogicSize 
	 * @throws IllegalLogicValue 
	 * @throws MemoryException
	 * @param address the address of the memory
	 * @param data the data that writing into the memory
	 *  
	 */
	public void writeMemory(int address, String data) throws IllegalLogicValue, IllegalVectorLogicSize, MemoryException {
		if((0 < address) && (address<this.memorySize))
			memory[address].writeVectorLogic(data);
		else
			throw new MemoryException("Address is out of range of Memory. It should be: 0-" + (memorySize-1));
		
	}



	
}
