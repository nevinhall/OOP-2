/*
 * RunDB.java
 *
 * 
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.TimeZone;
import java.sql.ResultSet;


public class RunDB {


	public RunDB() {
	


	
		try {




			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();


			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/r00165035?user=root&password&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
			System.out.println ("Database connection established");
			Statement s = con.createStatement ();


//			System.out.println("1. Run a Select Statment"+"\n"+"2. Run an insert Statement"+"\n"+"3. Run an update Statement"+"\n"+"4. Run an Delete Statement"+"\n"+"5. Run an prepared Statement"+"\n"+"6.Quit."+"\n");
//
//			Scanner menu_input = new Scanner(System.in);
//			int user_choice = menu_input.nextInt();
//
//			boolean current_flag = true;
//			while(current_flag == true) {
//				if(user_choice == 1) {
//					Scanner user_input = new Scanner(System.in);
//					System.out.println("You have chosen to run a select statement:"+"\n");
//					ResultSet rs = s.executeQuery ("SELECT * FROM Product");
//					while (rs.next ())
//					{
//						String ProductNoVal = rs.getString ("ProductNo");
//						System.out.println("ProductNo is : "+ProductNoVal+"\n");
//					}
//
//					main(args);
//
//				}else if(user_choice == 2) {
//					System.out.println("You have chosen to run an Insert statement:"+"\n");
//					InsertRecord ir = new InsertRecord(); 
//					ir.insert(con);
//					main(args);
//
//				}else if(user_choice == 3) {
//					System.out.println("You have chosen to run a Update statement:"+"\n");
//					UpdateRecord ur = new UpdateRecord(); 
//					ur.update(con);
//					main(args);
//
//				}else if(user_choice == 4) {
//					System.out.println("You have chosen to run a Delete statement:"+"\n");
//					DeleteRecord dr = new DeleteRecord(); 
//					dr.delete(con); 
//					main(args);
//
//
//				}else if(user_choice == 5) {
//					Scanner insert = new Scanner(System.in);
//					System.out.println("Enter Product ID into Insert statement: ");
//					int productNo =  insert.nextInt();
//					System.out.println("Enter Product Name into Insert statement:  ");
//					String supplierName1 = insert.nextLine();
//					String productName = insert.nextLine();
//
//					System.out.println("Enter Pack Condition  into Insert statement: ");
//					String packCondition =  insert.nextLine();
//
//					System.out.println("Enter UseByDate into Insert statement: ");
//					int useByDate =  insert.nextInt();
//
//					System.out.println("Enter Batch Number into Insert statement: ");
//					int batchNo =  insert.nextInt();
//
//
//					SQLQueryPrepared ir = new SQLQueryPrepared(productNo, productName, packCondition, useByDate,batchNo); 
//					ir.queryStatement(con,productNo, productName, packCondition, useByDate,batchNo);
//					main(args);
//
//				}else if(user_choice == 6) {
//					current_flag = false;
//					break;
//
//				}else
//					System.out.print("you have entered an invalid number please try again");
//				main(args);
//
//
//			}
//

		}catch (Exception ex) {
			System.out.println("SQLException: " + ex.getMessage());

		};

	}

}
