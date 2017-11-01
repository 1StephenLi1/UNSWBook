package unswbook.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class BaseConn {

	public static String database = "jdbc:mysql://localhost:3306/unswbook";
	public static String username = "root";
	public static String password = "970415";

	public static Connection getConnection() {
		Connection connection = null;
		
		/*
		try {
			File file = new File("./db.conf");
			InputStreamReader reader = new InputStreamReader(new FileInputStream(file));
			BufferedReader br = new BufferedReader(reader);
			
			database = br.readLine();
			username = br.readLine();
			password = br.readLine();
		} catch (Exception e) {
			e.printStackTrace();
		}
		*/

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(database, username,
			        password);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

}
