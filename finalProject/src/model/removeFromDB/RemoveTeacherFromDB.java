package model.removeFromDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class RemoveTeacherFromDB {
	 public RemoveTeacherFromDB() {
	    }
	    
	     public void removeTeacherFromDB(String email) {
	        try {
	        	Connection con = null;
	        	con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/r00165035?user=root&password&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
	            Statement deleteStmt = con.createStatement();
	            String deleteSQL = " Delete from teacher where EmailAddress = '"+email+"'";
	            //String table = "Docket";
                 int res = deleteStmt.executeUpdate(deleteSQL);

	            deleteStmt.close();
	       }catch (Exception io) {
	                System.out.println("error"+io);
	       };   
	  
	     }

}
