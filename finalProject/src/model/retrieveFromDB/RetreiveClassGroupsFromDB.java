package model.retrieveFromDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.ClassGroup;

public class RetreiveClassGroupsFromDB {

	ArrayList<ClassGroup>  temp = new ArrayList<>();

	public ArrayList<ClassGroup>  getTeachers() {
		return temp;
	}

	public void setTemp(ArrayList<ClassGroup> temp) {
		this.temp= temp;
	}

	public ArrayList<ClassGroup>  RetreiveClassGroupsDB() throws SQLException{
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/r00165035?user=root&password&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}                                

		// Prepare SQL.
		String query = ("SELECT * " +
				"FROM  classGroups"); 

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
			String classGroupName = (rs.getString("ClassName"));
				ClassGroup tempClass = new ClassGroup();
				tempClass.setClassGroupName(classGroupName);
				temp.add(tempClass);
				//System.out.println(teachers.get(0));

			}
		return temp;

			
		
		}  
		
	
		
	
	public ArrayList<ClassGroup>  returnArrayList() {
		return temp;
		
	}

}
