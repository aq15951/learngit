package pr.fd.future;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionMysql {

	String driver = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost/alk";

	String user = "root";
	String pwd = "root";

	public Connection getconnection() {
		Connection conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, pwd);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}

	public static void main(String[] args) {
		ConnectionMysql test = new ConnectionMysql();
		System.out.println(test.getconnection());
	}

}
