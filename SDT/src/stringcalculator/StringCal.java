package stringcalculator;

public class StringCal {
	
	
	public static int add(String numbers){
		String[] parts = numbers.replace("\n", ",").split(",");
		int i = 0;
		if(numbers != ""){
			for(int a=0; a<parts.length; a++){
				i = i + Integer.parseInt(parts[a]);
			}
			return i;
		}
		else
			return 0;
		
	}
	

}
	