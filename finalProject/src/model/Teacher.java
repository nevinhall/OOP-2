package model;

public class Teacher extends Person {
	
	private String degree;
	
	
	public Teacher(String emailAddress, int phone,Name name,String degree) {
		super(emailAddress, phone, name);
		this.degree = degree;
	}

	
	
	
	


	@Override
	public String toString() {
		return getPersonName() + "\n"
				+ getEmailAddress() + "\n" + getPhone() + "\n" + degree
				+ "\n";
	}







	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

}
