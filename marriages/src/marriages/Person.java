package marriages;

/**
 * @author D11124360
 *
 */
public class Person {

	private String personName;
	private Person spouse;
	
	
	public Person(String personName) {
		super();
		this.personName = personName;
	}

	public void marry(Person person){
		
		if((this.isSingle()) && (person.isSingle())){
			this.spouse = person;
			person.spouse = this;
		}	
	}
	
	public boolean isMarried(){
		return spouse != null;		
	}
	
	public boolean isSingle(){
		return spouse == null;			
		}

	/**
	 * @return the personName
	 */
	public String getPersonName() {
		return personName;
	}


	/**
	 * @return the spouse
	 */
	public Person getSpouse() {
		return spouse;
	}



	
	
	
}

