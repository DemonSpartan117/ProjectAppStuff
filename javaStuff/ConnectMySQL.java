import javax.net.ssl.SSLContext;

import java.sql.*;

// You will need to import Connector/J in order to connect
// MySQL and Java

public class ConnectMySQL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver found");
		} catch (Exception e) {
			System.out.println("Driver failed.");//prints when connection failed
		}
		String url = "jdbc:mysql://localhost/test";
		String id = "**";
		String password = "**";
		java.sql.Connection con;
		try {
			con = DriverManager.getConnection(url, id, password);
			System.out.println("SUCCESS");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM USERLIST;");
			while (rs.next()) {
				String userid = rs.getString("userid");
				String pw = rs.getString("password");
				System.out.println(userid + " " + pw);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			System.out.println("FAIL");
			e1.printStackTrace();
		}

	}

}
