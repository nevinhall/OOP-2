package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import model.ClassGroup;
import model.SchoolArrayList;
import model.Student;
import model.StudentArrayList;
import model.retrieveFromDB.RetreiveStudentDB;
import model.retrieveFromDB.RetreiveTeacherDB;
import model.retrieveFromDB.RetrieveStudentsInClassGroupDB;
import model.sendToDB.SendStudentsToDB;


public class controller  {

	StudentArrayList studentArray = new StudentArrayList();
	ArrayList<Student> students = studentArray.getStudents();
	ArrayList<Student> classGroupstudents = studentArray.getStudents();
	SchoolArrayList classGroupInSchool = new SchoolArrayList();
	ClassGroup controllerClassGroup = new ClassGroup();



	public controller(){


	}


	public ArrayList<Student> removeStudentController(String studentEmail){
		try {
			students = studentArray.removeStudent(studentEmail);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return students;

	}

	public Label printTeacherController() throws SQLException {

		Label teacherlist =  new Label();
		String teachers = "";
		RetreiveTeacherDB getTeacher = new RetreiveTeacherDB();

		for(int i = 0; i < getTeacher.getTeachers().size(); i++){
			teachers =  teachers + "\n" +  getTeacher.getTeachers().get(i);
		}
		teacherlist.setText(teachers);
		return teacherlist;

	}


	public String printStudentController() {
		List<String> temp= new ArrayList<String>();
		String student = "";
		String sortedStudents = " ";
		try {
			RetreiveStudentDB getStudent= new RetreiveStudentDB();
			students = getStudent.RetreiveStudent(students);
			for(int i = 0; i < students.size(); i++){
				student = "" + students.get(i);
				temp.add(student);
			}
			Collections.sort(temp);
			int limit = temp.size();
			
			for(int i = 0; i < temp.size(); i++) {
				System.out.println("names sorted " + temp.get(i));
				student =  student + temp.get(i) ;


			}



		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//students.forEach(i->System.out.println("students from db"+i));
		System.out.println("Size before Add: " +students.size());
		return student;


	}

	public String printStudentClassGroupController(String classGroupName) {
		String classGroupstudent= "";
		try {
			RetrieveStudentsInClassGroupDB getStudent= new RetrieveStudentsInClassGroupDB();
			classGroupstudents  = getStudent.RetreiveStudentsClassGroupsDB(classGroupName);
			for(int i = 0; i < classGroupstudents .size(); i++){
				classGroupstudent =  	 classGroupstudent + "\n" + 	 classGroupstudents.get(i);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//students.forEach(i->System.out.println("students from db"+i));
		System.out.println("Size before Add: " +students.size());
		return classGroupstudent;



	}
	public ArrayList<Student> addStudentController(Student addStudent) throws SQLException{


		try {
			//students.forEach(i-> System.out.println("after add " +i));
			System.out.println("Size after Add: " +students.size());
			SendStudentsToDB sendStudents = new SendStudentsToDB();
			sendStudents.sendStudentsToDb(addStudent);
			printStudentController();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return students;	
	}

	public void addStudentClassGroupController(String name,String emailAddress) throws SQLException{
		try {
			controllerClassGroup = classGroupInSchool.returnClassGroup(name);
			controllerClassGroup.addStudentToGroup(emailAddress,controllerClassGroup,students);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	public  void removeStudentClassGroupController(String name,String emailAddress) throws SQLException{
		try {
			controllerClassGroup = classGroupInSchool.returnClassGroup(name);
			controllerClassGroup.removeStudentFromClassGroup(emailAddress);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}


	//	public void sortOnYearController();




	public ArrayList<ClassGroup> addClassGroupController(String name){

		return classGroupInSchool.addClassGroup(name);

	}

	public void removeClassGroupController(String name){
		try {
			classGroupInSchool.removeClassGroup(name);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	public String returnClassGroupStudentsController(String name){
		String studentInClass = "";
		ArrayList<Student> studentsInClass = classGroupInSchool.returnClassGroupStudents(name);
		if(studentsInClass.size() > 0) {
			for(int i = 0; i < studentsInClass.size(); i++){
				studentInClass =  studentInClass + "\n" + studentsInClass.get(i);
			}
		}
		return studentInClass;

	}







}



