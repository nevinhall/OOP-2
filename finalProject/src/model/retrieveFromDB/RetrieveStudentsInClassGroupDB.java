package model.retrieveFromDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Name;
import model.Student;

public class RetrieveStudentsInClassGroupDB {
	RetreiveStudentDB currentStudents = new RetreiveStudentDB();
	ArrayList<Student> storedStudents = new ArrayList<Student>();
	ArrayList<Student> temp = new ArrayList<Student>();


	public ArrayList<Student>  RetreiveStudentsClassGroupsDB(String classGroupName) throws SQLException{
		storedStudents = currentStudents.RetreiveStudent(storedStudents);

		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/r00165035?user=root&password&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}                                

		// Prepare SQL.
		String query = ("SELECT * " +
				"FROM  classGroupStudents"); 

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
		while (rs.next()) {
			String classGroupNameStored = (rs.getString("ClassName"));
			for(int i =0; i < storedStudents.size(); i++){


				String studentEmailAddress = (rs.getString("ClassStudentEmail")); 
				if(studentEmailAddress.equals(storedStudents.get(i).getEmailAddress()) && classGroupName.equals(classGroupNameStored)) {

					String mName = storedStudents.get(i).getPersonName().getMiddleName();
					String fName =  storedStudents.get(i).getPersonName().getFirstName();
					String lName  = storedStudents.get(i).getPersonName().getLastName();
					int studentPhone = storedStudents.get(i).getPhone();
				   int studentDob = storedStudents.get(i).getDob();

				if( mName == null || mName == "") {
					Name studentName =  new Name(fName, lName);
					Student student = new Student(studentEmailAddress ,studentPhone , studentName,studentDob);
					temp.add(student);
					System.out.println(temp.get(0));

				}else { 
					Name studentNameFull =  new Name(fName, mName, lName);
					Student student = new Student(studentEmailAddress ,studentPhone , studentNameFull,studentDob);
					temp.add(student);

				}
				}
			               

			}
		}
		return temp;
	}
}