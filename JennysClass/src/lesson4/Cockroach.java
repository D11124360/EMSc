package lesson4;

public class Cockroach {
	
	private double volumeOfCockroach = 0.0002;
	private double NoOfCockroach = 10;
	private double rate = 0.95;
	private int volumeOfHouse = 8000;
	private double noOfWeeks =0;	

	
	public Cockroach(){
		double noOfNeededCockroach = (volumeOfHouse/volumeOfCockroach); 		//- NoOfCockroach;	
		
		while (NoOfCockroach<noOfNeededCockroach){
			NoOfCockroach = NoOfCockroach + NoOfCockroach*rate;
			noOfWeeks++;
		}
		
		System.out.println("No of weeks need : " + noOfWeeks);
		System.out.println("No of cockroaches need : " + NoOfCockroach);
		System.out.println("Volume of cockroaches : " + volumeOfCockroach*NoOfCockroach);
	}
	
	public static void main(String[] args) {
		
		new Cockroach();
		
	}

}
