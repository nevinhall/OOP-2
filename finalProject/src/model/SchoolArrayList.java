package model;

import java.sql.SQLException;
import java.util.ArrayList;

import model.removeFromDB.RemoveClassGroupFromDB;
import model.retrieveFromDB.RetreiveClassGroupsFromDB;
import model.sendToDB.SendClassGroupsToDB;

public class SchoolArrayList  {
	SendClassGroupsToDB sendToDb = new SendClassGroupsToDB();
	RemoveClassGroupFromDB removeFromDB = new  RemoveClassGroupFromDB();
	RetreiveClassGroupsFromDB retreviveClassGroups = new RetreiveClassGroupsFromDB();
	ArrayList<ClassGroup> currentClassGroups;
	
	ClassGroup classGroup  = new ClassGroup();
	
	public  SchoolArrayList()   {
		try {
			currentClassGroups = retreviveClassGroups.RetreiveClassGroupsDB();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ArrayList<ClassGroup> addClassGroup(String name){
		classGroup.setClassGroupName(name);
		currentClassGroups.add(classGroup);
		sendToDb.writeToDB(classGroup);

		System.out.println("ADD CLASS GROUPname of class group"+currentClassGroups.get(0).getClassGroupName() + currentClassGroups.size());
		return currentClassGroups;

	}


	public ArrayList<ClassGroup> removeClassGroup(String classGroupName){
		for(int i = 0; i < currentClassGroups.size(); i++) {
			if(classGroupName.equals(currentClassGroups.get(i).getClassGroupName())){
				System.out.println("IM GETTING HERE");
				removeFromDB.removeClassGroupFromDB(classGroupName);
				currentClassGroups.remove(i);
				//CALL TO DELTE FUNCTION HERE

			}
			System.out.println(currentClassGroups.size());
		}
		return currentClassGroups;

	}

	public ClassGroup returnClassGroup(String classGroupName) throws SQLException{
		currentClassGroups = retreviveClassGroups.RetreiveClassGroupsDB();
		for(int i = 0; i < currentClassGroups.size(); i++) {
			System.out.println("returnClassGroupSize "+currentClassGroups.size());
			System.out.println("stored class group name "+currentClassGroups.get(i).getClassGroupName());
			System.out.println("imported name  "+ classGroupName);
			if(classGroupName.equals(currentClassGroups.get(i).getClassGroupName())){
				classGroup = currentClassGroups.get(i);
				return classGroup;

			}
		}

		System.out.println("name is null");
		return classGroup = null;


	}

	public ArrayList<Student> returnClassGroupStudents(String classGroupName){
		System.out.println(currentClassGroups.size());
		for(int i = 0; i < currentClassGroups.size(); i++) {
			System.out.println("comparing class group name" +classGroupName );
			System.out.println("currentClassGroups : "+currentClassGroups.get(i).getClassGroupName());
			if(classGroupName.equals(currentClassGroups.get(i).getClassGroupName())){
				System.out.println("something is equal");
				System.out.println("The size of the group is "+currentClassGroups.get(i).getGroup().size());
				return currentClassGroups.get(i).getGroup();

			}
		}
		return null;

	}
}
