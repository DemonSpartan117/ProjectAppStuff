/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.sql.*;



/**
 *
 * @author Kwangju
 */
public class TruncateTestData {
    
    private static final String DBUrl = "jdbc:mysql://localhost:3306/appstore";
    private static final String DBID = "root";
    private static final String DBPW = "fe8029AFC10"; // "Levi*7537";
    
    private static Statement stmt;

    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(DBUrl, DBID, DBPW);
        stmt = con.createStatement();
        
        String statement = truncate("USER");
        stmt.executeUpdate(statement);
        
        statement = truncate("ADMIN");
        stmt.executeUpdate(statement);
        
        statement = truncate("MODERATOR");
        stmt.executeUpdate(statement);
        
        statement = truncate("APPS");
        stmt.executeUpdate(statement);
        
        statement = "insert into apps values ('Amazing App', 'Damon Duckett', 'this is awesome', 'platforms', null, 'www.awesome.com', null, null, 'Y');";
        stmt.executeUpdate(statement);
        
        statement = "insert into apps values ('Trble App', 'Christopher Scavongelli', 'who cares', 'platforms', null, 'non exist', null, null, 'Y');";
        stmt.executeUpdate(statement);
    }
    
    public static String truncate(String tablename) {
        return "TRUNCATE " + tablename + ";";
    }
    
}
