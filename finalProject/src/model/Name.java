package model;
public class Name {
	private String firstName;
	private String lastName;
	private String middleName;
	
	public Name(){
		
	}
	
	
	public Name(String firstName, String lastName ,String middleName) {
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		
	}
	
	
	public Name(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		
	}
	
	

	

	@Override
	public String toString() {
		return  firstName + " "+ lastName + " " + middleName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lasttName) {
		this.lastName = lasttName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

}
