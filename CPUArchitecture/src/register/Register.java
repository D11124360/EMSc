package register;
/**
 * 
 */

/**
 * @author D11124360
 *
 */
public class Register {
	
	private int size;
	private boolean enable;
	private int readDelay;
	private int writeDelay;
	private byte data;
	
	/**
	 * @param size of the register
	 * @param readDelay is the read delay of register
	 * @param writeDelay is the write delay of register
	 */
	public Register(int size, int readDelay, int writeDelay) {
		super();
		this.size = size;
		this.readDelay = readDelay;
		this.writeDelay = writeDelay;
		
	}
	
	
	
	
	

}
