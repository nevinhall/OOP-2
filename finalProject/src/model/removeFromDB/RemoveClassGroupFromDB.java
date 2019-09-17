package model.removeFromDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class RemoveClassGroupFromDB {
	 public RemoveClassGroupFromDB() {
	    }
	    
	     public void removeClassGroupFromDB(String classGroupName) {
	        try {
	        	Connection con = null;
	        	con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/r00165035?user=root&password&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
	            Statement deleteStmt = con.createStatement();
	            String deleteSQL = " Delete from  classGroups where  ClassName= '"+classGroupName+"'";
	            //String table = "Docket";
              int res = deleteStmt.executeUpdate(deleteSQL);
//	            int res2 = deleteStmt.executeUpdate(deleteSQL2);
//	            System.out.println("The Number or records deleted is " +res + " from " + table + "\n");
//	            System.out.println("The Number or records deleted is " +res2 + " from " + table2 + "\n"); 
	            deleteStmt.close();
	       }catch (Exception io) {
	                System.out.println("error"+io);
	       };   
	  
	     }


}
