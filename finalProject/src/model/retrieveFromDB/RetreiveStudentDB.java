package model.retrieveFromDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

import model.Name;
import model.Student;



public class RetreiveStudentDB {
	
	
	public ArrayList<Student>  RetreiveStudent(ArrayList<Student> students) throws SQLException {
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/r00165035?user=root&password&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}                                

		// Prepare SQL.
		String query = ("SELECT * " +
				"FROM student"); 

		// Set prepared statement.
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		// Execute SQL.
		ResultSet rs = null;
		try {
			rs = ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}                                                          

		// Get data from database.
//		ArrayList<Teacher> teachers = new ArrayList<>();
		while (rs.next()) { 
			
			String mName = (rs.getString("MiddleName"));
			String fName =  (rs.getString("FirstName"));
			String lName  = (rs.getString("LastName"));
			String studentEmailAddress = (rs.getString("EmailAddress")); 
		
			
			int studentPhone = (rs.getInt("Phone")); 
			int studentDob= (rs.getInt("DOB")); 
			
			if( mName == null || mName == "") {
				Name studentName =  new Name(fName, lName);
				Student student = new Student(studentEmailAddress ,studentPhone , studentName,studentDob);
				
				students.add(student);
				
				System.out.println(students.get(0));
				

			}else { 
				Name studentNameFull =  new Name(fName, mName, lName);
				Student student = new Student(studentEmailAddress ,studentPhone , studentNameFull,studentDob);
				students.add(student);
				
				System.out.println(students.get(0));

			}

			
		
		}
		
		ArrayList<String> temp = new ArrayList();
		 Collections.sort(temp);
		return students;                 
	}

	
	
		
		
	

}
