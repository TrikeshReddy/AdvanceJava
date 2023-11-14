package newone;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCCRUD {
	public static void main(String[] args) {
		System.out.println("select an option:");
		System.out.println("1 to create");
		System.out.println("2 to update");
		System.out.println("3 to insert");
		System.out.println("4 to delete");
		System.out.println("5 to read");
		
		try (Scanner scanner = new Scanner(System.in)) {
			int i =scanner.nextInt();
			switch (i){
			case 1:
				System.out.println("enter the query to create:");
				createTable();
				break;
			case 2:
				System.out.println("enter id and first name to update:");
				int id=scanner.nextInt();
				String name=scanner.next();
				updateUser(name,id);
				break;
			case 3:
				System.out.println("enter id, first name,last name and age to insert:");
				int id1=scanner.nextInt();
				String fname=scanner.next();
				String lname=scanner.next();
				int age=scanner.nextInt();
				insertUser(id1,fname,lname,age);
				break;
			case 4:
				System.out.println("enter id to delete:");
				int id2=scanner.nextInt();
				deleteUser(id2);
				break;
			case 5:
				System.out.println("enter values to update:");
				int id3=scanner.nextInt();
				readUser(id3);
				break;
			}
		}
	
 }

	private static void readUser(int id) {
		try {
			//load and register driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			//build connection
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/advancejava8pm", "root", "root@12");
			//create satement object
			Statement statement=connection.createStatement();
			String sql="select * from registration where id="+id;
			
			ResultSet resultSet=statement.executeQuery(sql);
			while(resultSet.next()) {
	        	System.out.println(resultSet.getInt(1) +"  " +resultSet.getString(2)+"  "+resultSet.getString(3)+"  "+resultSet.getInt(4));
	        }
			statement.close();
			connection.close();
		} catch (ClassNotFoundException e) {
			System.out.println("unable to load or register driver");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("unable to build connection or enteredt query is wrong");
		}
		
	}

	private static void deleteUser(int id) {
		
		try {
			//load and register driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			//build connection
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/advancejava8pm", "root", "root@12");
			//create satement object
			PreparedStatement stmt=connection.prepareStatement("delete from registration where id=?");  
			stmt.setInt(1,id);//1 specifies the first parameter in the query  
			
			  
			int i=stmt.executeUpdate();  
			if(i!=0)
				System.out.println("deleted succesfully");
			else
				System.out.println("unsuccesfull");
			stmt.close();
			connection.close();
			
		} catch (ClassNotFoundException e) {
			System.out.println("unable to load or register driver");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("unable to build connection or enteredt query is wrong");
		}
		
	}

	private static void insertUser(int id,String firstname,String lname,int age) {
		try {
			//load and register driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			//build connection
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/advancejava8pm", "root", "root@12");
			//create satement object
			PreparedStatement stmt=connection.prepareStatement("insert into registration values(?,?,?,?)");  
			stmt.setInt(1,id);//1 specifies the first parameter in the query  
			stmt.setString(2,firstname); 
			stmt.setString(3,lname); 
			stmt.setInt(4,age);//1 specifies the first parameter in the query  
			
			  
			int i=stmt.executeUpdate();  
			System.out.println("inserted succesfully");
			stmt.close();
			connection.close();
			
		} catch (ClassNotFoundException e) {
			System.out.println("unable to load or register driver");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("unable to build connection or enteredt query is wrong");
		}
		
	}

	private static void updateUser(String name,int id) {
		try {
			//load and register driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			//build connection
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/advancejava8pm", "root", "root@12");
			//create satement object
			Statement statement=connection.createStatement();
			String sql="update registration set first='"+name +"' where id=" +id+";";
			
			statement.executeUpdate(sql);
			System.out.println("updated sucessfully");
			statement.close();
			connection.close();
			
		} catch (ClassNotFoundException e) {
			System.out.println("unable to load or register driver");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("unable to build connection or enteredt query is wrong");
		}
		
	}

	private static void createTable() {
		try {
			//load and register driver
			Class.forName("com.mysql.cj.jdb.Driver");
			//build connection
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/advancejava8pm", "root", "root@12");
			//create satement object
			PreparedStatement stmt=connection.prepareStatement("insert into registration values(?,?,?,?)");  
			stmt.setInt(1,101);//1 specifies the first parameter in the query  
			stmt.setString(2,"Ratan"); 
			stmt.setString(3,"tata"); 
			stmt.setInt(4,61);//1 specifies the first parameter in the query  
			
			  
			int i=stmt.executeUpdate();  
			
			stmt.close();
			connection.close();
			
		} catch (ClassNotFoundException e) {
			System.out.println("unable to load or register driver");
		} catch (SQLException e) {
			System.out.println("unable to build connection or enteredt query is wrong");
		}
	}
}
