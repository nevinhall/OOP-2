package model.sendToDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;

import model.ClassGroup;

public class SendClassGroupsToDB {
	public void writeToDB(ClassGroup GroupName) {
		String ClassGroupName = GroupName.getClassGroupName();
		try {
		Connection con = null;
		con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/r00165035?user=root&password&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
		Statement insertStmt = con.createStatement();
		String insertSQL = " Insert into classGroups values  ('"+ClassGroupName+"')";
		int res = insertStmt.executeUpdate(insertSQL);

		String table = "classGroups";
		System.out.println("The Number or records inserted is " +res + " to " + table + "\n");

		insertStmt.close();
	}catch (Exception io) {
		System.out.println("error"+io);
	};  

		
	}


}