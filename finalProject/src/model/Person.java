package model;

public class Person {
	private String emailAddress;
	private int phone;
	private Name personName;
	
	
	public Person(String emailAddress, int phone,Name name) {
		this.emailAddress = emailAddress;
		this.phone = phone;
		this.personName = name;
		
	}
	
	
	@Override
	public String toString() {
		return "Person [emailAddress=" + emailAddress + ", phone=" + phone + ", Name=" +  personName.getFirstName() +  personName.getMiddleName() +  personName.getLastName() + "]";
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}


	public Name getPersonName() {
		return personName;
	}


	public void setPersonName(Name personName) {
		this.personName = personName;
	}
	
	

}
