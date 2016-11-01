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
            File f = new File("sql.txt");
            Scanner sc= new Scanner(f);
            
            StringBuilder sb = new StringBuilder();
            String line="";
//            String line = "drop table recommendations";
            Connection con = DBMS_Connection.get();
//            PreparedStatement stmt = con.prepareStatement(line);
//            stmt.execute(line);
            
            while(sc.hasNext()){
                line = sc.nextLine();
                sb.append(line);
            }
            String sql = sb.toString();
            
            String[] sqlQueries = sql.split("===");
            PreparedStatement stmt = null;
            

            for(String s: sqlQueries){
//                System.out.println(s);
                stmt = con.prepareStatement(s);
           //     stmt.executeQuery(s);
            }
            LoginFrame lf = new LoginFrame();
            lf.setVisible(true);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DBMS_Project1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBMS_Project1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
