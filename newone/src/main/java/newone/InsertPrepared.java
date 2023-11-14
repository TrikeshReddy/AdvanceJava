package newone;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public	class InsertPrepared{  
	public static void main(String args[]){  
	try{  
	Class.forName("com.mysql.cj.jdbc.Driver");  
	  
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost/advancejava8pm","root","root@12");  
	  
	PreparedStatement stmt=con.prepareStatement("insert into registration values(?,?,?,?)");  
	stmt.setInt(1,101);//1 specifies the first parameter in the query  
	stmt.setString(2,"Ratan"); 
	stmt.setString(3,"tata"); 
	stmt.setInt(4,61);//1 specifies the first parameter in the query  
	
	  
	int i=stmt.executeUpdate();  
	System.out.println(i+" records inserted");  
	  
	con.close();  
	  
	}catch(Exception e){ System.out.println(e);}  
	  
	}  
	} 
