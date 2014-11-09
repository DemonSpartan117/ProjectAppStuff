import java.sql.*;
import java.util.*;

class Login { // LOGIN DEMO
	
	public static void Login(User u) {
		String inputId = u.getName();
		String inputPw = u.getPassword();
		String url = null; // THE LOCATION OF DATABASE
		String dbid = null; // THE USERID OF DATABASE
		String dbpw = null; // THE PASSWORD OF DATABASE
		Connection con;
		try {
			con = DriveManager.getConnection(url, dbid, dbpw);
			System.out.println("SUCCESS"); // FOR TEST PURPOSE
			String query = String.format("SELECT USERNAME, PASSWORD FROM USER WHERE USERNAME = '%s' AND PASSWORD = '%s'", inputId, intputPw);
			if (rs.next()) System.out.println("YOU ARE LOGGED IN.");
			else System.out.println("NO SUCH ACCOUNT FOUND.");
		} catch (SQLException e1) {
			System.out.println("FAIL TO ACCESS. CONTACT THE DBA OR THE DEVELOPER TO SOLVE THIS ISSUE.");
		}
	}

}