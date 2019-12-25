/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.model.Utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kareem E.Farouk
 */
public class DBconnect {
    
    // JDBC driver name and database URL
    private Connection conn;
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost:3306/termproject";
    
    // JDBC driver name and database URL
    static final String USER = "root";
    static final String PASS = "sesame";
   
    public Connection  createConnection()
    {
        try {
            Class.forName(JDBC_DRIVER); //loading mysql driver
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS); //attempting to connect to MySQL database
            System.out.println("Connected database successfully...");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBconnect.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBconnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return conn;
    }
}
