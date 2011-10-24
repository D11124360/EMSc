package bingo;

import java.util.ArrayList;
import java.util.Random;

public class Bingo {
	
	private ArrayList <Integer> bingoNumberes;
	private Random randomNumber = new Random ();
	private ArrayList<Player> players =new ArrayList<Player>();
	
	private Player vinod = new Player("Vinod");
	private Player vajira = new Player("Vajira");
	private Player john = new Player("John");
	private Player lal = new Player("Lal");
	private Player mala = new Player("Mala");

	

public Bingo(){
	bingoNumberes = new ArrayList <Integer>();
	addPlayers();
	System.out.println("Bingo numbers : ");
	createBingoNumbers2();
	winnerFinder();
	
	
	
}

private void addPlayers(){
	
	players.add(vinod);
	players.add(vajira);
	players.add(john);
	players.add(lal);
	players.add(mala);
}

public void winnerFinder(){
	
	System.out.println("**********************************************");
	for (Player x: players){
		System.out.println("Player : " + x.getName());
		
		for(int b = 0; b<25; b++){
			if (x.getBingoNumberofPlayer().get(b)==this.bingoNumberes.get(b))
				System.out.println("Player number " + x.getBingoNumberofPlayer().get(b) 
						+ " is match with Bingo number " + this.bingoNumberes.get(b));
			else{
				System.out.println("This Player is not a winner ");
				break;
				}				
			}
		
	}
	
	
}
	
public void createBingoNumbers(){
		for(int b=0; b<25;b++){
			this.bingoNumberes.add(randomNumber.nextInt(100));
			System.out.println(this.bingoNumberes.get(b));
			}
		}

public void createBingoNumbers2(){
	for(int b=0; b<25;b++){
		this.bingoNumberes.add(b+1);
		System.out.println(this.bingoNumberes.get(b));
		}
	}

	
	public static void main(String[] args) {
		new Bingo();

	}

}
