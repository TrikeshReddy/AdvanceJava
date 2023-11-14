package newone;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Properties;

public class RetriveFile {

	public static void main(String[] args) {
		Properties properties=new  Properties();
		
			FileInputStream file;
			try {
				file = new FileInputStream("C:\\Users\\User\\eclipse-workspace\\newone\\src\\main\\java\\db.properties");
				properties.load(file);
				String url=properties.getProperty("db.url");
				String un=properties.getProperty("db.user");
				String pwd=properties.getProperty("db.password");
				String driver=properties.getProperty("db.driverClass");
				try {
					Class.forName(driver);
					Connection connection=DriverManager.getConnection(url,un,pwd);
					String sql="select * from IMGTABLE where NAME =?;";
					PreparedStatement statement = connection.prepareStatement(sql);
					statement.setString(1, "notepad");
					ResultSet resultSet=  statement.executeQuery();
					resultSet.next();
					System.out.println(resultSet.getString(1)+"  "+resultSet.getBlob(2));
					Blob blob = resultSet.getBlob(2);
					InputStream in = blob.getBinaryStream();
					FileOutputStream out = new FileOutputStream("C:\\Users\\User\\eclipse-workspace\\newone\\src\\main\\java\\some.txt");
					byte[] buff = new byte[4096]; // how much of the blob to read/write at a time
					System.out.println(Arrays.toString(buff));
					int len = 0;

					while ((len = in.read(buff)) != -1) {
					    out.write(buff, 0, len);
					}
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
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			
				
	}

}
