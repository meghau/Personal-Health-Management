/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbms_project1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author aishu
 */
public class DBMS_Connection {
    public static String loginID="";
    public static String loginpassword="";
    public static String loginType="";
    public static String patientType="";
    public static String DRIVER = "oracle.jdbc.driver.OracleDriver";
    public static String DB_URL ="jdbc:oracle:thin:@ora.csc.ncsu.edu:1521:ORCL";
    public static String USER_NAME = "mumesha";
    public static String PASS = "200107889";
    public static Connection connection = null;
    
    public static Connection get()
    {
        
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            //Class.forName("com.mysql.jdbc.Driver"); 

	} catch (ClassNotFoundException e) {
            System.out.println("OJDBC not found.");
            e.printStackTrace();
            return null;
        }
	System.out.println("Oracle JDBC Driver Registered!");
        Connection connection = null;
	try {
            connection = DriverManager.getConnection(
		"jdbc:oracle:thin:@orca.csc.ncsu.edu:1521:orcl01", USER_NAME,
		PASS);
//            connection =DriverManager.getConnection(  
//            "jdbc:mysql://localhost:3306/health_management","root","root");
	} catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return null;
        }
        return connection;
    }
} 

