package model;

import java.util.ArrayList;

import model.removeFromDB.RemoveStudentFromDB;

public class StudentArrayList {
	ArrayList<Student> students = new ArrayList<>();

	public ArrayList<Student> getStudents() {
		return students;
	}

	public void setStudents(ArrayList<Student> students) {
		this.students = students;
	}

	public ArrayList<Student> addStudents(Student addStudent){
		students.add(addStudent);
		return students;

	}



	public ArrayList<Student> removeStudent(String studentEmail){
		RemoveStudentFromDB removeFromDB = new RemoveStudentFromDB();
		for(int i = 0; i < students.size();i++){
			String storedEmail = students.get(i).getEmailAddress();


			if(studentEmail.equals(storedEmail))
				students.remove(i);
				removeFromDB.removeStudentFromDB(studentEmail);
			System.out.println("Size after delete: " +students.size());
		}
		return students;

	}
}
