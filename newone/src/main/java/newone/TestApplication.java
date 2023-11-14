package newone;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
//importing the packages
	
public class TestApplication {
	   static final String DB_URL = "jdbc:mysql://localhost/advancejava8pm";
	   static final String USER = "root";
	   static final String PASS = "root@12";

	   public static void main(String[] args) {
		   System.out.println("enter emp id:");
		   Scanner scanner = new Scanner(System.in);
		   int empId=scanner.nextInt();
	      try {
			Class.forName("com.mysql.cj.jdbc.Driver");//load and registering drivers
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);//building a connection
	         Statement stmt = conn.createStatement();//creating statement
	      	      
	          String sql = "SELECT * FROM registration where id="+empId+";"; //exceuting the query

	        ResultSet resultSet= stmt.executeQuery(sql);
	        int i=0;
	        while(resultSet.next()) {
	        	System.out.println(resultSet.getInt(1) +"  " +resultSet.getString(2)+"  "+resultSet.getString(3)+"  "+resultSet.getInt(4));
	        }
	         
	         stmt.close();//closing statement
	         conn.close();//closing connection
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	      finally {
	    	  
		}
	   }
}
//create read update and delete  
