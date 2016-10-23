/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbms_project1;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author meghaumesha
 */
public class DBMS_Project1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        try {
            // TODO code application logic here
            new DBMS_Connection();
            File f = new File("sql.txt");
            Scanner sc= new Scanner(f);
            
            /*PreparedStatement stmt = null;
            Connection con = DBMS_Connection.get();
            String s ="INSERT INTO well_patient VALUES('133','121','12-Jan-2016',null,null)";
            stmt = con.prepareStatement(s);
            stmt.execute(s);
            System.out.println("inserted");*/
            StringBuilder sb = new StringBuilder();
            String line = "";
            
            //line = "BEGIN EXECUTE IMMEDIATE 'DROP TABLE patient'; EXCEPTION WHEN OTHERS THEN IF SQLCODE != -942 THEN RAISE; END IF; END;";
            
            /*while(sc.hasNext()){
                line = sc.nextLine();
                sb.append(line);
            }
            String sql = sb.toString();
            
            String[] sqlQueries = sql.split(";");*/
            line = "Drop table diagnosis";
            PreparedStatement stmt = null;
            Connection con = DBMS_Connection.get();
            stmt = con.prepareStatement(line);
//            stmt.execute(line);
//            
//            line = "Drop table diagnosis";
//            stmt = con.prepareStatement(line);
//            stmt.executeQuery(line);
            /*for(String s: sqlQueries){
                stmt = con.prepareStatement(s);
                stmt.executeQuery(s);
            }*/
            LoginFrame lf = new LoginFrame();
            lf.setVisible(true);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DBMS_Project1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBMS_Project1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
