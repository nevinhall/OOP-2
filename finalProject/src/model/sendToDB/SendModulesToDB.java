package model.sendToDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Modules;
import model.retrieveFromDB.RetreiveModuleDB;

public class SendModulesToDB {
	public void writeToDB(String moduleName, int grade,String email) {
	
		try {
		Connection con = null;
		con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/r00165035?user=root&password&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
		Statement insertStmt = con.createStatement();
		String insertSQL = " Insert into studentModules values  ('"+email+"','"+moduleName+"','"+grade+"')";
		int res = insertStmt.executeUpdate(insertSQL);


		String table = "classGroups";
		System.out.println("The Number or records inserted is " +res + " to " + table + "\n");

		insertStmt.close();
	}catch (Exception io) {
		System.out.println("error"+io);
	};  

		
	}
	
	public void editMoule(String email, int moduleGrade,String moduleName) throws SQLException{
		RetreiveModuleDB retreivemodule = new RetreiveModuleDB();
		ArrayList<Modules> temp = retreivemodule.retreiveModuleDB();
		temp.forEach(i ->{
			if(i.getModuleStudentEmail().equals(email) && i.getModuleName().equals(moduleName)){
				i.setModuleGrade(moduleGrade);
				Connection con = null;
				try {
					con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/r00165035?user=root&password&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	            String updateSQL = "Update  studentModules set moduleGrade = '"+moduleGrade+"'  where EmailAddress ='"+email+"' and  where EmailAddress ='"+ moduleName+"' ";
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
