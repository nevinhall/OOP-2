package model.sendToDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.sun.xml.internal.bind.v2.runtime.Name;

import model.Student;
import model.retrieveFromDB.RetreiveStudentDB;



public class SendStudentsToDB {
	ArrayList<Student> writeToDBstudents =  new  ArrayList<Student>();


	public  void sendStudentsToDb(Student addStudent) throws SQLException {


		RetreiveStudentDB temp =  new  RetreiveStudentDB();
		writeToDBstudents  = temp.RetreiveStudent(writeToDBstudents);
		System.out.println("Size of writeToDB array: " + writeToDBstudents.size());

		String fName = addStudent.getPersonName().getFirstName();
		String mName = addStudent.getPersonName().getMiddleName();
		String lName = addStudent.getPersonName().getLastName();
		String emailAddress =  addStudent.getEmailAddress();
		int dob =  addStudent.getDob();
		int phone = addStudent.getPhone();

	
		if( mName != null) {
			try {


//			
				System.out.println("test2");
				Connection con = null;
				con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/r00165035?user=root&password&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
				Statement insertStmt = con.createStatement();
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
				int primaryKey = 0;
				while(rs.next()) {
					System.out.println("email from db is" + rs.getString("EmailAddress"));
					if(rs.getString("EmailAddress").equals(emailAddress)){
						return;
					}
					if(rs.isLast()) {
						primaryKey = rs.getInt(1) +1;
					}


				}

				String insertSQL = " Insert into student values  ('"+primaryKey+"','"+mName+"','"+lName+"','"+fName+"','"+phone+"','"+dob+"','"+emailAddress+"')";
				int res = insertStmt.executeUpdate(insertSQL);

				String table = "student";
				System.out.println("The Number or records inserted is " +res + " to " + table + "\n");

				insertStmt.close();
			}catch (Exception io) {
				System.out.println("error"+io);
			};  
			//				Statement insertStmt = null;
			//				Connection con = null;
			//				try {
			//					con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/r00165035?user=root&password&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
			//				} catch (SQLException e) {
			//					// TODO Auto-generated catch block
			//					e.printStackTrace();
			//				}  
			//				try {
			//					insertStmt = con.createStatement();
			//				} catch (SQLException e) {
			//					// TODO Auto-generated catch block
			//					e.printStackTrace();
			//				}
			//				Name StudentName =  new Name(fName, lName);
			//				Student student = new Student(emailAddress, phone, StudentName, dob);
			//				
			//
			//				String insertSQL = " Insert into student values (7,'g',lName','fName',7,7,'emailAddress')";
			//				try {
			//					int res = insertStmt.executeUpdate(insertSQL);
			//				} catch (SQLException e) {
			//					// TODO Auto-generated catch block
			//					e.printStackTrace();
			//				}
			//				try {
			//					insertStmt.close();
			//				} catch (SQLException e) {
			//					// TODO Auto-generated catch block
			//					e.printStackTrace();
			//				}


			//System.out.println(student);
		}else { 


			//System.out.println(student);

		}





	};   

}



