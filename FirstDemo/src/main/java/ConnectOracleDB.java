import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

/*
 * Here we will learn to connect to Oracle DB using JDBC Driver.
 */
public class ConnectOracleDB {

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Please provide below details to connect Oracle Database");
		System.out.println("Enter Database");
		String dbName = scanner.next();
		System.out.println("Enter UserName");
		String userName = scanner.next();
		System.out.println("Enter Password");
		String password = scanner.next();

		try {
 
			Class.forName("oracle.jdbc.driver.OracleDriver");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Connection connection = null;

		try {

			connection = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521/XE" , userName,password);

		} catch (SQLException e) {

			e.printStackTrace();
		}

		if (connection != null) {
			System.out.println("Successfullly connected to Oracle DB");
		} else {
			System.out.println("Failed to connect to Oracle DB");
		}
	}

}