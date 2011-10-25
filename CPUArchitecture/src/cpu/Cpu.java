/**
 * 
 */
package cpu;

import memory.Memory;
import register.Register;

/**
 * @author W Vajira Kuruppuarachchi (D11124360)
 *
 */
public class Cpu {
	
	private Register pc;	// Program Counter
	private Register mar;	// Memory Address Register
	private Register mdr;	// Memory Data Register
	private Register ir;	// Instruction Register
	private Register fr;	// Flag Register
	
	private Memory mainMemory;		//	Main memory of the CPU
	private Memory cache;			//	Main memory of the CPU

}
