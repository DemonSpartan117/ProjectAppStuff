/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import java.sql.*;
import java.util.ArrayList;

import com.secure.userInfo.*;
import com.others.App;

/**
 *
 * @author Kwangju
 */
public class DBHandling {
    
    private static final String DBUrl = "jdbc:mysql://localhost:3306/appstore";
    private static final String DBID = "root";
    private static final String DBPW = "Levi*7537";
    
    private static Statement stmt;
    
    private static Statement initializer() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(DBUrl, DBID, DBPW);
        return con.createStatement();
    }
    
    public static boolean Login(User u) throws Exception {
        stmt = initializer();
	String statement;
        if (u.isAdmin()) {
            statement = String.format("SELECT USERNAME, PASSWORD FROM ADMIN WHERE USERNAME = '%s' AND PASSWORD = '%s'", u.getName(), u.getPassword());
        } else if (u.isModerator()) {
            statement = String.format("SELECT USERNAME, PASSWORD FROM MODERATOR WHERE USERNAME = '%s' AND PASSWORD = '%s'", u.getName(), u.getPassword());
        } else {
            statement = String.format("SELECT USERNAME, PASSWORD FROM USER WHERE USERNAME = '%s' AND PASSWORD = '%s'", u.getName(), u.getPassword());
        }
        ResultSet rs = stmt.executeQuery(statement);
        int count = 0;
        while (rs.next()) {
            ++count;
        }
        
        if (count > 1) {
            throw new IllegalStateException();
        }
        if (count == 1) {
            rs.first();
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
        stmt = initializer();
	String statement;
        if (u.isAdmin()) {
            statement = String.format("INSERT INTO ADMIN " + "VALUES ('%s', '%s');", u.getName(), u.getPassword());
        } else if (u.isModerator()) {
            statement = String.format("INSERT INTO MODERATOR " + "VALUES ('%s', '%s');", u.getName(), u.getPassword());
        } else {
            statement = String.format("INSERT INTO USER " + "VALUES ('%s', '%s');", u.getName(), u.getPassword());
        }
        
        try {
            stmt.executeUpdate(statement);
        } catch (SQLException e) {
            return false; // SIGNUP FAILED
        }
        return true; //SIGNUP SUCCESSFUL
    }
    
    public static boolean DeleteAccount(User u) throws Exception {
        stmt = initializer();
        String statement = String.format("DELETE FROM USER WHERE USERNAME = '%s';", u.getName());
        try {
            stmt.executeUpdate(statement);
        } catch (SQLException e) {
            return false; // DELETE FAILED
        }
        return true; // DELETE SUCCESSFUL
    }
    
    public static ArrayList<App> search(String keyword, int filter, int sort) throws Exception {
        stmt = initializer();
        String statement = String.format("SELECT * FROM APPLIST ");
        
        /*public App(String name, String developer, String description, String[] platforms, String link) {*/
        
        
        if (filter != 0) {
            String cmd = "WHERE ";
            switch (filter) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                default: throw new IllegalStateException("Something went wrong.");
            }
            statement += cmd;
        }
        
        if (sort != 0) {
            statement += String.format("ORDER BY %d;" + sort);
        }
        
        ResultSet rs = stmt.executeQuery(statement);
        
        ArrayList<App> ret = new ArrayList<App>();
        
        while (rs.next()) {
            String name = rs.getString("NAME");; 
            String developer = rs.getString("DEVELOPER");
            String description = rs.getString("DESCRIPTION"); 
            String[] platforms = new String[] {rs.getString("PLAFTORMS")}; 
            String link = rs.getString("LINK");
            ret.add(new App(name, developer, description, platforms, link));
        }
        
        return ret;
    }
    
}
