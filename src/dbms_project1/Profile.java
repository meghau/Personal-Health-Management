/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbms_project1;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aishu
 */
public class Profile extends javax.swing.JFrame {

    /**
     * Creates new form Profile
     */
    public Profile() {
        initComponents();
        Connection con = DBMS_Connection.get();
        String id = DBMS_Connection.loginID;
        String type = DBMS_Connection.loginType;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        if(type.equals("patient"))
        {
            System.out.println("patient ? date when null=");
            String query = "select * from patient p where p.id = '"+id+"'";
            try {
                pstmt = con.prepareStatement(query);
            } catch (SQLException ex) {
                System.out.println("pstmt error");
                Logger.getLogger(Profile.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                rs = pstmt.executeQuery();
            } catch (SQLException ex) {
                System.out.println("executequery");
                Logger.getLogger(Profile.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            String pid="",name="",addr="",gender="",category="";
            
            
            Date date=null;
            
              System.out.println("date when null="+date);  
                
            try {
                if(rs.next())
                {
                    System.out.println("date when null="+date);
                    pid = rs.getString(1);
                    System.out.println("date when null="+date);
                    date = rs.getDate(2);
                    System.out.println("date when not null="+date);
                    name = rs.getString(3);
                    addr = rs.getString(4);
                    gender = rs.getString(5);
                }
            } catch (SQLException ex) {
                Logger.getLogger(Profile.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            String query1 = "select * from sick_patient p where p.id = '"+id+"'";
            try {
                pstmt = con.prepareStatement(query1);
            } catch (SQLException ex) {
                System.out.println("pstmt error");
                Logger.getLogger(Profile.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                rs = pstmt.executeQuery();
            } catch (SQLException ex) {
                System.out.println("executequery");
                Logger.getLogger(Profile.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try {
                if(rs.next())
                {
                    type = "Sick patient";
                }
                else
                {
                    type = "Well patient";
                }
            } catch (SQLException ex) {
                Logger.getLogger(Profile.class.getName()).log(Level.SEVERE, null, ex);
            }
                
                Patient_ID.setText(pid);
                Patient_Name.setText(name);
                Patient_Address.setText(addr);
                DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                Patient_DOB.setText(formatter.format(date));
                Patient_Gender.setText(gender);
                Patient_Category.setText(type);
                
                
            
        }
        else
        {
            String query = "select * from Health_Supporter h,patient p where p.id = '"+id+"' AND h.id=p.id";
            try {
                pstmt = con.prepareStatement(query);
            } catch (SQLException ex) {
                System.out.println("pstmt error");
                Logger.getLogger(Profile.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                rs = pstmt.executeQuery();
            } catch (SQLException ex) {
                System.out.println("executequery");
                Logger.getLogger(Profile.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            String pid="",name="",addr="",gender="",category="";
            
            
            Date date=null;
            try {
                if(rs.next())
                {
                  pid = rs.getString(2);
                  date = rs.getDate(3);
                  name = rs.getString(4);
                  addr = rs.getString(5);
                  gender = rs.getString(6);
                  category = type;
                }
                
                String query1 = "select * from sick_patient p where p.id = '"+id+"'";
                try {
                    pstmt = con.prepareStatement(query1);
                } catch (SQLException ex) {
                    System.out.println("pstmt error");
                    Logger.getLogger(Profile.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    rs = pstmt.executeQuery();
                } catch (SQLException ex) {
                    System.out.println("executequery");
                    Logger.getLogger(Profile.class.getName()).log(Level.SEVERE, null, ex);
                }

                try {
                    if(rs.next())
                    {
                        type = "Sick patient";
                    }
                    else
                    {
                        type = "Well patient";
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Profile.class.getName()).log(Level.SEVERE, null, ex);
                }
            
                
                
                Patient_ID.setText(pid);
                Patient_Name.setText(name);
                Patient_Address.setText(addr);
                DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                Patient_DOB.setText(formatter.format(date));
                Patient_Gender.setText(gender);
                Patient_Category.setText(type);
                
                con.close();
            } catch (SQLException ex) {
                System.out.println("rs.next");
                Logger.getLogger(Profile.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public Profile(String id)
    {
        initComponents();
        Connection con = DBMS_Connection.get();
        System.out.println("connection"+(con==null));
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
            String query = "select * from patient p where p.id = '"+id+"'";
            try {
                pstmt = con.prepareStatement(query);
            } catch (SQLException ex) {
                System.out.println("pstmt error");
                Logger.getLogger(Profile.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                rs = pstmt.executeQuery();
            } catch (SQLException ex) {
                System.out.println("executequery");
                Logger.getLogger(Profile.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            String pid="",name="",addr="",gender="",category="";
            
            System.out.println(id+" here");
            Date date=null;
            
                
                
            try {
                if(rs.next())
                {
                    pid = rs.getString(1);
                    date = rs.getDate(2);
                    name = rs.getString(3);
                    addr = rs.getString(4);
                    gender = rs.getString(5);
                }
            } catch (SQLException ex) {
                Logger.getLogger(Profile.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            String query1 = "select * from sick_patient p where p.id = '"+id+"'";
            String type = "";
            try {
                pstmt = con.prepareStatement(query1);
            } catch (SQLException ex) {
                System.out.println("pstmt error");
                Logger.getLogger(Profile.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                rs = pstmt.executeQuery();
            } catch (SQLException ex) {
                System.out.println("executequery");
                Logger.getLogger(Profile.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try {
                if(rs.next())
                {
                    type = "Sick patient";
                }
                else
                {
                    type = "Well patient";
                }
            } catch (SQLException ex) {
                Logger.getLogger(Profile.class.getName()).log(Level.SEVERE, null, ex);
            }
                
                Patient_ID.setText(pid);
                Patient_Name.setText(name);
                Patient_Address.setText(addr);
                DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                Patient_DOB.setText(formatter.format(date));
                Patient_Gender.setText(gender);
                Patient_Category.setText(type);
           
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Patient_Name_Label = new javax.swing.JLabel();
        Patient_DOB_Label = new javax.swing.JLabel();
        Patient_ID_Label = new javax.swing.JLabel();
        Patient_Address_Label = new javax.swing.JLabel();
        Patient_Gender_Label = new javax.swing.JLabel();
        Patient_ID = new javax.swing.JTextField();
        Patient_Name = new javax.swing.JTextField();
        Patient_DOB = new javax.swing.JTextField();
        Patient_Address = new javax.swing.JTextField();
        Patient_Gender = new javax.swing.JTextField();
        Patient_Category_Label = new javax.swing.JLabel();
        Patient_Category = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Patient_Name_Label.setText("Name");

        Patient_DOB_Label.setText("DOB");

        Patient_ID_Label.setText("ID");

        Patient_Address_Label.setText("Address");

        Patient_Gender_Label.setText("Gender");

        Patient_ID.setEditable(false);
        Patient_ID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Patient_IDActionPerformed(evt);
            }
        });

        Patient_Name.setEditable(false);

        Patient_DOB.setEditable(false);

        Patient_Address.setEditable(false);

        Patient_Gender.setEditable(false);

        Patient_Category_Label.setText("Category");

        Patient_Category.setEditable(false);

        jButton1.setText("Edit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Save");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Patient_Gender_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Patient_Category_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Patient_Category, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Patient_Gender, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Patient_ID_Label, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Patient_Name_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(Patient_DOB_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(Patient_Address_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(58, 58, 58)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Patient_Address, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Patient_DOB, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Patient_Name, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Patient_ID, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Patient_ID_Label)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Patient_Name_Label)
                            .addComponent(Patient_Name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Patient_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(15, 15, 15)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Patient_DOB_Label)
                            .addComponent(Patient_DOB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Patient_Address_Label)
                            .addComponent(Patient_Address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Patient_Gender_Label)
                            .addComponent(Patient_Gender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Patient_Category_Label)
                            .addComponent(Patient_Category, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(63, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Patient_IDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Patient_IDActionPerformed
        
    }//GEN-LAST:event_Patient_IDActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Patient_Name.setEditable(true);
        Patient_DOB.setEditable(true);
        Patient_Gender.setEditable(true);
        Patient_Address.setEditable(true);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.setVisible(false);
        String type = DBMS_Connection.loginType;
        if(type.equals("patient"))
        {
            Patient_Menu menu = new Patient_Menu();
            menu.setVisible(true);
        }
        else
        {
            HSupPatientInfoFrame menu = new HSupPatientInfoFrame();
            menu.setVisible(true);
        }
        Connection con = DBMS_Connection.get();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String id = DBMS_Connection.loginID;
        String date = Patient_DOB.getText();
        System.out.println("if save"+date);
        String[] arrdate = date.split("-");
        String month = "";
        int num = Integer.parseInt(arrdate[1]);
        DateFormatSymbols dfs = new DateFormatSymbols();
        String[] months = dfs.getMonths();
        if (num >= 1 && num <= 12 ) {
            month = months[num-1];
        }
        String d = arrdate[0]+"-"+month+"-"+arrdate[2];      
        String query = "update patient p set p.dob='"+d+"', p.address='"+Patient_Address.getText()+"',p.name='"+Patient_Name.getText()+"',p.gender='"+Patient_Gender.getText()+"' where p.id = '"+id+"'";
            try {
                pstmt = con.prepareStatement(query);
            } catch (SQLException ex) {
                System.out.println("pstmt error");
                Logger.getLogger(Profile.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                rs = pstmt.executeQuery();
            } catch (SQLException ex) {
                System.out.println("executequery");
                Logger.getLogger(Profile.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Profile().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Patient_Address;
    private javax.swing.JLabel Patient_Address_Label;
    private javax.swing.JTextField Patient_Category;
    private javax.swing.JLabel Patient_Category_Label;
    private javax.swing.JTextField Patient_DOB;
    private javax.swing.JLabel Patient_DOB_Label;
    private javax.swing.JTextField Patient_Gender;
    private javax.swing.JLabel Patient_Gender_Label;
    private javax.swing.JTextField Patient_ID;
    private javax.swing.JLabel Patient_ID_Label;
    private javax.swing.JTextField Patient_Name;
    private javax.swing.JLabel Patient_Name_Label;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    // End of variables declaration//GEN-END:variables
}
