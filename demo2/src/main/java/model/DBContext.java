package model;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Acer Aspire
 */
public class DBContext {
    protected Connection connection;
    public DBContext()
    {
        try {
            String user = "root" ;//"SWP_Admin";
            String password = "1234"; //"Test1234@";
            //String database = "headphone";
            //String url = "jdbc:mysql://dbswp.mysql.database.azure.com:3306/" + database + "?useSSL=true";

            String url = "jdbc:mysql://localhost:3306/headphone?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UT";

            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
