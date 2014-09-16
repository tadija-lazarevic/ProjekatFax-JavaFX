package base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserBase {

	private static Connection connection;

	// Pristupa drajveru u JAR fajlu
	private static Connection createConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/user", "root", "Abks7BBf");
		} catch (Exception e) {
                    e.printStackTrace();
			return null;
		}
	}

	public static Connection get() {
		if (connection == null) {
			connection = createConnection();
		}
		return connection;
	}

	public static ResultSet query(String sql) {
		try {
			Connection connection = get();
			Statement s = connection.createStatement();
			return s.executeQuery(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static boolean exec(String sql, Object... values) {
		return exec(String.format(sql, values));
	}

	public static boolean exec(String sql) {
		try {
			Connection connection = get();
			Statement s = connection.createStatement();
			s.execute(sql);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}

}
