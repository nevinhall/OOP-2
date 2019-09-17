package controller;

import java.sql.SQLException;

import model.Modules;
import model.Teacher;
import model.removeFromDB.RemoveTeacherFromDB;
import model.sendToDB.SendModulesToDB;
import model.sendToDB.SendTeacherToDB;

public class ControllerPopUp {
	SendTeacherToDB sendTeacher = new SendTeacherToDB();
	SendModulesToDB sendModule = new SendModulesToDB();
	RemoveTeacherFromDB removeTeacher = new RemoveTeacherFromDB();
	Modules controllerModules = new Modules();
	controller mainController = new controller();



	public void addteacherControllerPopUp(Teacher teacher){
		sendTeacher.writeToDB(teacher);
		try {
			mainController.printTeacherController();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void editTeacherDegree(String email,String degree) throws SQLException{
		sendTeacher.editDegree(email, degree);
		try {
			mainController.printTeacherController();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void removeTeacherController(String email){
		removeTeacher.removeTeacherFromDB(email);
		try {
			mainController.printTeacherController();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void addModulesController(String module, int grade,String studentemail){
		 controllerModules.AddModule(module, grade, studentemail);
	}
	
	public void editModuleGradeController(String email, int grade,String moduleName) throws SQLException{
		sendModule.editMoule(email, grade,moduleName);
		
	}
}