package model;

import java.util.ArrayList;





public class Student extends Person implements Comparable<Name >{
	private int dob;
	private ArrayList<Modules> modules = new ArrayList<Modules>();
	
	public Student(String emailAddress, int phone, Name name,int dob) {
		super(emailAddress, phone, name);
		this.setDob(dob);
		
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public int compareTo(Name compare) {

		int lastCmp  = getPersonName().getFirstName().compareTo(compare.getFirstName());
		return (lastCmp != 0 ? lastCmp : getPersonName().getLastName().compareTo(compare.getLastName()));
		
	}
	
	
	

	@Override
	public String toString() {
		return getPersonName() + "\n"
				+ getEmailAddress() + "\n" + getPhone() + "\n" + dob
				+ "\n";
	}


	public int getDob() {
		return dob;
	}

	public void setDob(int dob) {
		this.dob = dob;
	}



	public ArrayList<Modules> getModules() {
		return modules;
	}



	public void setModules(ArrayList<Modules> modules) {
		this.modules = modules;
	}


	


}
