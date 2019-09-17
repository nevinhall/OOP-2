package model;

import java.sql.SQLException;
import java.util.ArrayList;

import model.retrieveFromDB.RetreiveStudentDB;
import model.sendToDB.SendModulesToDB;

public class Modules{

	private ArrayList<Student> tempStudents = new ArrayList<Student>();
	private String moduleName;
	private int moduleGrade;
	private String moduleStudentEmail;





	public String getModuleName() {
		return moduleName;
	}
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	public int getModuleGrade() {
		return moduleGrade;
	}
	public void setModuleGrade(int moduleGrade) {
		this.moduleGrade = moduleGrade;
	}


	public void AddModule(String module, int grade,String studentemail){
		RetreiveStudentDB temp = new RetreiveStudentDB();
		try {
			tempStudents = temp.RetreiveStudent(tempStudents);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for(int i =0;i < tempStudents.size();i++) {
			if(studentemail.equals(tempStudents.get(i).getEmailAddress())) {
				SendModulesToDB writeToDB = new SendModulesToDB();
				writeToDB.writeToDB(module, grade, studentemail);
				
				}
			}
		
	}
	public String getModuleStudentEmail() {
		return moduleStudentEmail;
	}
	public void setModuleStudentEmail(String moduleStudentEmail) {
		this.moduleStudentEmail = moduleStudentEmail;
	}
	
//	public void AddModule(String module, int grade,String studentemail){
//		RetreiveStudentDB temp = new RetreiveStudentDB();
//		try {
//			tempStudents = temp.RetreiveStudent(tempStudents);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		for(int i =0;i < tempStudents.size();i++) {
//			if(studentemail.equals(tempStudents.get(i).getEmailAddress())) {
//				Modules newModule = new Modules();
//				newModule.setModuleGrade(grade);
//				newModule.setModuleName(module);
//				
//				if(tempStudents.get(i).getModules().size() <=  6){
//					tempStudents.get(i).getModules().add(newModule);
//				}
//			}
//		}
//	}


//	public void updateModule(String moduleName,int newGrade){
//		for(int i = 0; i  < modules.size(); i++){
//			if(moduleName.equals(modules.get(i).getModuleName())) {
//				modules.get(i).setModuleGrade(newGrade);
//			}
//		}
//	}


//
//
//	public ArrayList<Modules> getModules() {
//		return modules;
//	}
//
//	public void setModules(ArrayList<Modules> modules) {
//		this.modules = modules;
//	}
//
//	@Override
//	public String toString() {
//		return "ModuleGradeList [modules=" + modules + ", getModules()=" + getModules() + ", getClass()=" + getClass()
//		+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
//	}


}
