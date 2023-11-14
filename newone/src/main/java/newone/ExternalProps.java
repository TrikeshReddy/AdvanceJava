package newone;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class ExternalProps {
	public static void main(String[] args) {
		Properties properties=new  Properties();
		try {
			FileInputStream file =new FileInputStream("C:\\Users\\User\\eclipse-workspace\\newone\\src\\main\\java\\db.properties");
			
			properties.load(file);
			String url=properties.getProperty("db.url");
			String un=properties.getProperty("db.user");
			String pwd=properties.getProperty("db.password");
			String driver=properties.getProperty("db.driverClass");
			System.out.println(driver);
			try {
				Class.forName(driver);
				Connection connection=DriverManager.getConnection(url,un,pwd);
				String sql="insert into IMGTABLE value (?,?);";
				PreparedStatement statement = connection.prepareStatement(sql);
				FileInputStream fileInputStream = new FileInputStream("C:\\Users\\User\\eclipse-workspace\\newone\\src\\main\\java\\db.properties");
				statement.setString(1, "notepad");
				statement.setBlob(2, fileInputStream, fileInputStream.available());
				statement.executeUpdate();
				statement.close();
				connection.close();
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
