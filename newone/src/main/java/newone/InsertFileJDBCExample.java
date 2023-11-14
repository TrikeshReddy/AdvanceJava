package newone;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertFileJDBCExample {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/your_database";
        String user = "your_username";
        String password = "your_password";

        String filePath = "path_to_your_file";
        File file = new File(filePath);

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String sql = "INSERT INTO files (file_name, file_data) VALUES (?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, file.getName());
                FileInputStream inputStream = new FileInputStream(file);
                statement.setBinaryStream(2, inputStream, (int) file.length());
                statement.executeUpdate();
                System.out.println("File inserted successfully.");
            } catch (Exception e) {
                System.err.println("Error during the insert: " + e.getMessage());
            }
        } catch (Exception e) {
            System.err.println("Database connection error: " + e.getMessage());
        }
    }
}
