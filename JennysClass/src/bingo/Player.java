package bingo;

import java.util.ArrayList;
import java.util.Random;

public class Player {
	private String name;
	private ArrayList <Integer> bingoNumberofPlayer;
	

	private Random randomNumber = new Random ();
	
	
	public Player(String name) {
		super();
		this.bingoNumberofPlayer = new ArrayList <Integer>();
		this.name = name;
		System.out.println("Bingo numbers for player " + name);
		markBingoNumbers2();
		System.out.println();
	}
	
	public void markBingoNumbers(){
		for(int b=0; b<25;b++){
			this.bingoNumberofPlayer.add(randomNumber.nextInt(100));
			System.out.println(this.bingoNumberofPlayer.get(b));
		}
		
	}
	
	public void markBingoNumbers2(){
		for(int b=0; b<25;b++){
			this.bingoNumberofPlayer.add(b+1);
			System.out.println(this.bingoNumberofPlayer.get(b));
		}
		
	}
		
	public String getName() {
		return name;
	}

	public ArrayList<Integer> getBingoNumberofPlayer() {
		return bingoNumberofPlayer;
	}

	
	
public static void main(String arg[]){
	new Player("Vajira");

	
	}



}
