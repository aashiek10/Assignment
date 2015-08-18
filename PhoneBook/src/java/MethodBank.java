/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.DriverManager;
import java.sql.*;
/**
 *
 * @author cb-aashiek
 */
public class MethodBank {
  
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/", "root", "");
        return con;
    }

    public static Statement getStatement(Connection c) throws ClassNotFoundException, SQLException {
        return c.createStatement();
    }

    public static void closeConnection(Connection c, Statement s) throws SQLException {
        if(c!=null)
        c.close();
    }
     
    public static void closeStatement(Statement s) throws SQLException {
        if(s!=null)
        s.close();
    }
    
    public static void createDataBase(Statement s, String dataBaseName) throws ClassNotFoundException, SQLException {
        String crtDb = "CREATE DATABASE " + dataBaseName;
        s.executeUpdate(crtDb);
        String useDb = "USE " + dataBaseName;
        s.executeUpdate(useDb);
    }
    
    public static void createTable(Statement s, String createTable) throws ClassNotFoundException, SQLException {        
        s.executeUpdate(createTable);
    }
    
    public static void dropDataBase(Statement s, String dataBaseName) throws SQLException{
        String drpDb = "DROP DATABASE " + dataBaseName;
        s.executeUpdate(drpDb);
    }
    
    public static void dropTable(Statement s, String tableName) throws SQLException{
        String drpTbl = "DROP TABLE " + tableName;
        s.executeUpdate(drpTbl);
    }
    
}
