package model.sendToDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Teacher;
import model.retrieveFromDB.RetreiveTeacherDB;

public class SendTeacherToDB {
	;
	public void writeToDB(Teacher name) {
		String teacherfName = name.getPersonName().getFirstName();
		String teachermName = name.getPersonName().getMiddleName();
		String teacherlName = name.getPersonName().getLastName();
		String teacheremailAddress =  name.getEmailAddress();
		String teacherdegree=  name.getDegree();
		
		
		int teacherphone = name.getPhone();
		try {
		Connection con = null;
		con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/r00165035?user=root&password&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
		Statement insertStmt = con.createStatement();
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
		int primaryKey = 0;
		while(rs.next()) {
			if(rs.getString("EmailAddress").equals(teacheremailAddress)){
				return;
			}
			  if(rs.isLast()) {
				primaryKey = rs.getRow() +1;
			  }
			}

		System.out.println("getRow " +  primaryKey);
		String insertSQL = " Insert into teacher values  ('"+primaryKey +"','"+teachermName+"','"+teacherlName+"','"+teacherfName+"','"+teacherphone+"','"+teacheremailAddress+"','"+teacherdegree+"')";
		int res = insertStmt.executeUpdate(insertSQL);
		primaryKey++;
		String table = "teacher";
		System.out.println("The Number or records inserted is " +res + " to " + table + "\n");

		insertStmt.close();
	}catch (Exception io) {
		System.out.println("error"+io);
	};  

		
	}
	
	public void editDegree(String email, String degree) throws SQLException{
		RetreiveTeacherDB retreiveteacher= new RetreiveTeacherDB();
		ArrayList<Teacher> temp = retreiveteacher.returnArrayList();
		temp.forEach(i ->{
			if(i.getEmailAddress().equals(email)){
				i.setDegree(degree);
				Connection con = null;
				try {
					con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/r00165035?user=root&password&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	            String updateSQL = "Update teacher set degree = '"+degree+"' where EmailAddress ='"+email+"'";
	            Statement updateStmt = null;
				try {
					updateStmt = con.createStatement();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
//	            
//	            String table  = "Docket";
//	            String table2 = "VanCheck";
//	            
//	            int res = updateStmt.executeUpdate(updateSQL);
				try {
					int res = updateStmt.executeUpdate(updateSQL);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
//	            System.out.println("The Number or records updated is " +res + " from " + table + "\n");
//	            System.out.println("The Number or records updated is " +res2 + " from " + table2 + "\n");
//	          
               try {
				updateStmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
			}
		});
		
		
	}

}
