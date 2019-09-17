package model.retrieveFromDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.jcp.xml.dsig.internal.dom.Utils;

import model.Name;
import model.Teacher;



public class RetreiveTeacherDB {
	
	
	
	
	ArrayList<Teacher> teachers = new ArrayList<>();

	public ArrayList<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(ArrayList<Teacher> teachers) {
		this.teachers = teachers;
	}

	public RetreiveTeacherDB() throws SQLException{
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/r00165035?user=root&password&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}                                

		// Prepare SQL.
		String query = ("SELECT * " +
				"FROM teacher"); 

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
			String teacherEmailAddress = (rs.getString("EmailAddress")); 
			String degree = (rs.getString("degree")); 
			
			int teacherPhone = (rs.getInt("Phone")); 
			
			
			if( mName == null || mName == "") {
				Name teacherName =  new Name(fName, lName);
				Teacher teacher = new Teacher(teacherEmailAddress ,teacherPhone , teacherName,degree);
				teachers.add(teacher);
				System.out.println(teachers.get(0));

			}else { 
				Name teacherNameFull =  new Name(fName, mName, lName);
				Teacher teacher = new Teacher(teacherEmailAddress , teacherPhone, teacherNameFull,degree);
				teachers.add(teacher);
				System.out.println(teachers.get(0));

			}

			
		
		}  
		
	
		
	} 
	public ArrayList<Teacher>  returnArrayList() {
		return teachers;
		
	}
}


