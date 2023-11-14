package newone;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ExternalProperties {
	public static void main(String[] args) {
        Properties properties = new Properties();
        try (FileInputStream input = new FileInputStream("C:\\\\Users\\\\User\\\\eclipse-workspace\\\\newone\\\\src\\\\main\\\\java\\\\db.properties")) {
            properties.load(input);
        } catch (IOException e) {
        	e.printStackTrace();
            System.err.println("Error loading properties file: " + e.getMessage());
            System.exit(1);
        }

        String url = properties.getProperty("db.url");
        String user = properties.getProperty("db.user");
        String password = properties.getProperty("db.password");

        
        System.out.println(url);
    }
}
