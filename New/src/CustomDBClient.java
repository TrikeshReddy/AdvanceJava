import java.io.*;
import java.net.Socket;

public class CustomDBClient {
	private Socket socket;
	private BufferedReader reader;
	private PrintWriter writer;

	public CustomDBClient(String host, int port) throws IOException {
		socket = new Socket(host, port);
		reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		writer = new PrintWriter(socket.getOutputStream(), true);
	}

	public String executeQuery(String query) throws IOException {
		writer.println(query);
		StringBuilder result = new StringBuilder();
		String line;
		while ((line = reader.readLine()) != null) {
			result.append(line).append("\n");
		}
		return result.toString();
	}

	public void close() throws IOException {
		reader.close();
		writer.close();
		socket.close();
	}

	public static void main(String[] args) throws IOException {
		CustomDBClient client = new CustomDBClient("localhost", 3306);
		String query = "SELECT * FROM my_table";
		String result = client.executeQuery(query);
		System.out.println(result);
		client.close();
	}
}
