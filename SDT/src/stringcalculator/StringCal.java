package stringcalculator;

public class StringCal {
	
/*	public String addString(String number1, String number2){
		Integer temp = Integer.parseInt(number1) + Integer.parseInt(number2);
		return temp.toString();
	}
	public String addString(String number1){
		return number1;
	}
	public static String addString(){		
		return "";
	}*/
	
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
	