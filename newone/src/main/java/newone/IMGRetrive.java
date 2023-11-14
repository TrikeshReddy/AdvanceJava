package newone;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class IMGRetrive {
	static final String DB_URL = "jdbc:mysql://localhost/advancejava8pm";
	   static final String USER = "root";
	   static final String PASS = "root@12";

@SuppressWarnings("deprecation")
public static void main(String[] args) {
	

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);//building a connection
		     Statement stmt = conn.createStatement();//creating statement
		     String sql="select * from IMGTABLE where NAME='CAT';";
		    ResultSet rs= stmt.executeQuery(sql);
		    rs.next();
		    Blob b=rs.getBlob(2);//get the blob 
		    byte barr[]=b.getBytes(1,(int)b.length());//1 means first image  
		    FileOutputStream fout=new FileOutputStream("C:\\Users\\User\\Desktop\\7pm-fs-batch\\retrive.png"); //convert to image 
		    fout.write(barr);  
		                  
		    fout.close();  
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
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
