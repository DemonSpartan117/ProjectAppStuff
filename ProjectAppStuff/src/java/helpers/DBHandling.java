/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import java.sql.*;
import com.secure.userInfo.*;

/**
 *
 * @author Kwangju
 */
public class DBHandling {
    
    private static final String DBUrl = "jdbc:mysql://localhost:3306/appstore";
    private static final String DBID = "root";
    private static final String DBPW = "Levi*7537";
    
    public static boolean Login(User u) throws Exception {
        Connection con = DriverManager.getConnection(DBUrl, DBID, DBPW);
        Statement stmt = con.createStatement();
        String statement = String.format("SELECT USERNAME, PASSWORD FROM USER WHERE USERNAME = '%s' AND PASSWORD = '%s'", u.getName(), u.getPassword());
        ResultSet rs = stmt.executeQuery(statement);
        while (rs.next()) {
            String foundID = rs.getString("USERNAME");
            String foundPW = rs.getString("PASSWORD");
            if (u.getName().equals(foundID)) {
                if (u.getPassword().equals(foundPW)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public static boolean SignUp(User u) throws Exception {
        Connection con = DriverManager.getConnection(DBUrl, DBID, DBPW);
        Statement stmt = con.createStatement();
        String statement = String.format("INSERT INTO USER " + "VALUES ('%s', '%s');", u.getName(), u.getPassword());
        try {
            stmt.executeUpdate(statement);
        } catch (SQLException e) {
            return false; // SIGNUP FAILED
        }
        return true; //SIGNUP SUCCESSFUL
    }
    
    public static boolean DeleteAccount(User u) throws Exception {
        Connection con = DriverManager.getConnection(DBUrl, DBID, DBPW);
        Statement stmt = con.createStatement();
        String statement = String.format("DELETE FROM USER WHERE USERNAME = '%s';", u.getName());
        try {
            stmt.executeUpdate(statement);
        } catch (SQLException e) {
            return false; // DELETE FAILED
        }
        return true; // DELETE SUCCESSFUL
    }
    
}
