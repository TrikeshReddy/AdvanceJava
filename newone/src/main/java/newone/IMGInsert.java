package newone;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class IMGInsert {
	static final String DB_URL = "jdbc:mysql://localhost/advancejava8pm";
	   static final String USER = "root";
	   static final String PASS = "root@12";

public static void main(String[] args) {
	
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);//building a connection
	     Statement stmt = conn.createStatement();//creating statement
	     FileInputStream fin=new FileInputStream("C:\\Users\\User\\Downloads\\cat.png");//convert to blob  
	     String sql = "insert into IMGTABLE values ('catp','"+fin+fin.available() +"');";
	     System.out.println(sql);
	     stmt.executeUpdate(sql);
	     stmt.close();
	     conn.close();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}//load and registering drivers
 catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (FileNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
}
