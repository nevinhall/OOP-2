package model.retrieveFromDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Modules;

public class RetreiveModuleDB {
	ArrayList<Modules>  temp = new ArrayList<>();

	public ArrayList<Modules>  getModules() {
		return temp;
	}

	public void setTemp(ArrayList<Modules> temp) {
		this.temp= temp;
	}


	public ArrayList<Modules> retreiveModuleDB() throws SQLException{
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/r00165035?user=root&password&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}                                

		// Prepare SQL.
		String query = ("SELECT * " +
				"FROM studentModules"); 

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
			String moduleName = (rs.getString("moduleName"));
			String moduleStudentEmail = (rs.getString("ModuleStudentEmail"));
			int moduleGrade = (rs.getInt("moduleGrade"));
			Modules tempModules = new Modules();
			tempModules.setModuleName(moduleName);
			tempModules.setModuleGrade(moduleGrade);
			tempModules.setModuleStudentEmail(moduleStudentEmail);
			temp.add(tempModules);
			//System.out.println(teachers.get(0));

		}
		return temp;



	}  

	public ArrayList<Modules>  returnArrayList() {
		return temp;
		
	}



} 


