package model.removeFromDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class RemoveStudentFromDB {
	public RemoveStudentFromDB() {
		
	}
	
    public void removeStudentFromDB(String email) {
        try {
        	Connection con = null;
        	con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/r00165035?user=root&password&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
            Statement deleteStmt = con.createStatement();
            String deleteSQL = " Delete from student where EmailAddress = '"+email+"'";
            //String table = "Docket";
             int res = deleteStmt.executeUpdate(deleteSQL);
//            int res2 = deleteStmt.executeUpdate(deleteSQL2);
//            System.out.println("The Number or records deleted is " +res + " from " + table + "\n");
//            System.out.println("The Number or records deleted is " +res2 + " from " + table2 + "\n"); 
            deleteStmt.close();
            
            RemoveStudentFromClassGroupDB consitentRemove = new RemoveStudentFromClassGroupDB();
            RemoveModules consitentRemoveFromModule  = new   RemoveModules();
            consitentRemove.removeStudentFromClassGroupFromDB(email);
            consitentRemoveFromModule.removeModuleStudentDB(email); 
       }catch (Exception io) {
                System.out.println("error"+io);
       };   
  
     }

}
