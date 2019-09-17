package model;

import java.sql.SQLException;
import java.util.ArrayList;

import model.removeFromDB.RemoveStudentFromClassGroupDB;
import model.retrieveFromDB.RetreiveStudentDB;
import model.sendToDB.sendClassGroupStudentToDb;

public class ClassGroup {
	private  ArrayList<Student> group =  new ArrayList<Student>() ;
	RetreiveStudentDB students = new RetreiveStudentDB();
	private String ClassGroupName;



	public void addStudentToGroup(String emailAddress,ClassGroup classGroup,ArrayList<Student> students ){
		System.out.println("stored given " + emailAddress );
		for(int i = 0; i < students.size();i++){
			String storedemailAddress = students.get(i).getEmailAddress();
			System.out.println("comparing against " +  students.get(i).getEmailAddress());
			if(emailAddress.equals(storedemailAddress)){
				Student x = students.get(i);
				System.out.println(x.getPersonName().getFirstName());

				classGroup.getGroup().add(students.get(i));
				sendClassGroupStudentToDb sendToDB = new sendClassGroupStudentToDb();
				sendToDB.writeToDB(classGroup, storedemailAddress);
				//System.out.println("this is class group"+classGroup.getClassGroupName() + "students" + classGroup.getClassGroupName() + classGroup.getGroup().get(0));
				//CALL FUNCTION TO ADD TO CLASSgROUPsTUDENY TAHDAIUFD

			}


		}


	}


	public void removeStudentFromClassGroup(String emailAddress){
		try {
			group = students.RetreiveStudent(group);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("size before student removed from class group " + group.size());
		for(int i = 0; i < group.size();i++){
			String storedemailAddress = group.get(i).getEmailAddress();

			System.out.println("value passed in " +  emailAddress);
			System.out.println("comparing to " +  group.get(i).getEmailAddress());
			if(emailAddress.equals(storedemailAddress)){
				group.remove(i);
				RemoveStudentFromClassGroupDB removeStudentFromClassGroupDB = new RemoveStudentFromClassGroupDB();
				removeStudentFromClassGroupDB.removeStudentFromClassGroupFromDB(emailAddress);
			}

		}
		System.out.println("size after student removed from class group " + group.size());
	}





	public ArrayList<Student> getGroup() {
		return group;
	}


	public void setGroup(ArrayList<Student> group) {
		this.group = group;
	}


	public String getClassGroupName() {
		//return "xyz";
		return ClassGroupName;
	}


	public void setClassGroupName(String classGroupName) {
		ClassGroupName = classGroupName;
	}




}
