/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbms_project1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author meghaumesha
 */
public class HealthSupMainFrame extends javax.swing.JFrame {
    static String id;
    /**
     * Creates new form HealthSupMainFrame
     */
    public HealthSupMainFrame() {
        initComponents();
        jList1.setVisible(false);
        id="";
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        access_patient_button = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        LOGOUT = new javax.swing.JButton();
        delAccountButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setViewportView(jList1);

        jLabel1.setText("Patients");

        access_patient_button.setText("Access Patient Information");
        access_patient_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                access_patient_buttonActionPerformed(evt);
            }
        });

        jButton1.setText("Access my Information!");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Whom do I support?");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        LOGOUT.setText("LOGOUT");
        LOGOUT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LOGOUTActionPerformed(evt);
            }
        });

        delAccountButton.setText("Delete Account");
        delAccountButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delAccountButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(300, 343, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(161, 161, 161))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(134, 134, 134))))))
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(delAccountButton)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButton2))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(LOGOUT)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(access_patient_button)))
                        .addGap(77, 77, 77))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(delAccountButton)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(access_patient_button)
                        .addGap(22, 22, 22))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(LOGOUT)
                        .addGap(39, 39, 39))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

     public static void setPid(String id)
    {
        HealthSupMainFrame.id = id;
    }
    
    public static String getPid()
    {
        return id;
    }
    
    private void access_patient_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_access_patient_buttonActionPerformed
        
        String nameid = jList1.getSelectedValue();
        String[] id = nameid.split(" ");
        Connection con = DBMS_Connection.get();
        
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        setPid(id[1]);
        String hsid = DBMS_Connection.loginID;
        System.out.println(id[1]);
        String query1 = "select count(*) from well_patient wp where wp.id = '"+id[1]+"' and ((wp.psid = '"+hsid+"' and wp.p_auth_date <= (SELECT TO_CHAR (sysdate,'dd-mon-yy') \"now\" from dual)) or (wp.ssid='"+hsid+"' and wp.p_auth_date <= (SELECT TO_CHAR (sysdate,'dd-mon-yy') \"now\" from dual)))";
           System.out.println("hi1");
            try {
                pstmt = con.prepareStatement(query1);
            } catch (SQLException ex) {
                System.out.println("pstmt error");
                Logger.getLogger(Profile.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("hi3");
            try {
                rs = pstmt.executeQuery();
            } catch (SQLException ex) {
                System.out.println("executequery");
                Logger.getLogger(Profile.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("hi2");
            String num="";
            int countwell = 0;
            DefaultListModel<String> listModel = new DefaultListModel<>();
        //    DefaultComboBoxModel model = (DefaultComboBoxModel) combo.getModel();
            
            try {
                if(rs.next())
                {
                  num = rs.getString(1);  
                }
                countwell = Integer.parseInt(num);
                System.out.println("countwell="+countwell);
            } catch (SQLException ex) {
                Logger.getLogger(Profile.class.getName()).log(Level.SEVERE, null, ex);
            }
            String query2 = "select count(*) from sick_patient wp where wp.id = '"+id[1]+"' and ((wp.psid = '"+hsid+"' and wp.p_auth_date <= (SELECT TO_CHAR (sysdate,'dd-mon-yy') \"now\" from dual)) or (wp.ssid='"+hsid+"' and wp.p_auth_date <= (SELECT TO_CHAR (sysdate,'dd-mon-yy') \"now\" from dual)))";
           System.out.println("hi1");
            try {
                pstmt = con.prepareStatement(query2);
            } catch (SQLException ex) {
                System.out.println("pstmt error");
                Logger.getLogger(Profile.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("hi3");
            try {
                rs = pstmt.executeQuery();
            } catch (SQLException ex) {
                System.out.println("executequery");
                Logger.getLogger(Profile.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("hi2");
            num="";
            int countsick = 0;
           // DefaultListModel<String> listModel = new DefaultListModel<>();
        //    DefaultComboBoxModel model = (DefaultComboBoxModel) combo.getModel();
            
            try {
                if(rs.next())
                {
                  num = rs.getString(1);  
                }
                countsick = Integer.parseInt(num);
                System.out.println("countsick="+countsick);
            } catch (SQLException ex) {
                Logger.getLogger(Profile.class.getName()).log(Level.SEVERE, null, ex);
            }
           int sum = countwell+countsick;
           System.out.println("sum="+sum);
        if(sum>0)
        {
            this.setVisible(false);
            HSupPatientInfoFrame pinfo = new HSupPatientInfoFrame();
            pinfo.setVisible(true);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "You are still not authorized to support this patient!", "Alert", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_access_patient_buttonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.setVisible(false);
        Profile pr = new Profile();
        pr.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Connection con = DBMS_Connection.get();
        String id = DBMS_Connection.loginID;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
       // System.out.println("my id is : "+id);
            String query = "(select p.name, p.id from well_patient wp, health_supporter hs, patient p where (hs.id=wp.psid or hs.id=wp.ssid) and (hs.id='"+id+"') and p.id=wp.id) UNION (select p.name, p.id from sick_patient wp, health_supporter hs, patient p where (hs.id=wp.psid or hs.id=wp.ssid) and (hs.id='"+id+"') and p.id=wp.id) ";
           //String query = "select p.name, p.id from well_patient wp, health_supporter hs, patient p where (hs.id=wp.psid or hs.id=wp.ssid) and (hs.id='"+id+"') and p.id=wp.id UNION select p.name, p.id from sick_patient wp, health_supporter hs, patient p where (hs.id=wp.psid or hs.id=wp.ssid) and (hs.id='"+id+"') and p.id=wp.id" ;
           System.out.println("hi1");
            try {
                pstmt = con.prepareStatement(query);
            } catch (SQLException ex) {
                System.out.println("pstmt error");
                Logger.getLogger(Profile.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("hi3");
            try {
                rs = pstmt.executeQuery();
            } catch (SQLException ex) {
                System.out.println("executequery");
                Logger.getLogger(Profile.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("hi2");
            String name="",pid="";
            DefaultListModel<String> listModel = new DefaultListModel<>();
        //    DefaultComboBoxModel model = (DefaultComboBoxModel) combo.getModel();
            
            try {
                jList1.setModel(listModel);
                while(rs.next())
                {
                    name = rs.getString(1);
                    pid = rs.getString(2);
                    System.out.println(name+" "+pid);
                    String str = name+" "+pid;
        //            model.addElement(str);
                    listModel.addElement(str);
                }
                jList1.setVisible(true);
               // add(jList1);
            } catch (SQLException ex) {
                Logger.getLogger(Profile.class.getName()).log(Level.SEVERE, null, ex);
            }
            
           
    }//GEN-LAST:event_jButton2ActionPerformed

    private void LOGOUTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LOGOUTActionPerformed
        // TODO add your handling code here:
         this.setVisible(false);
        LoginFrame frame = new LoginFrame();
        frame.setVisible(true);
    }//GEN-LAST:event_LOGOUTActionPerformed

    private void delAccountButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delAccountButtonActionPerformed
        // TODO add your handling code here:
        try {
            System.out.println("deleting account");
            Connection con = DBMS_Connection.get();
                
                String sql1 = "Select p.id from sick_patient s, well_patient w, patient p"
                        +" where ((p.id=s.psid) OR (p.id=w.psid)) and p.id='"+DBMS_Connection.loginID+"'";
                
                String sql2 = "Select p.id from sick_patient s, well_patient w, patient p"
                        +" where ((p.id=s.ssid) OR (p.id=w.ssid)) and p.id='"+DBMS_Connection.loginID+"'";             
                
                PreparedStatement ps = con.prepareStatement(sql1);
                ResultSet rs1 = ps.executeQuery();
                
                ps = con.prepareStatement(sql2);
                ResultSet rs2 = ps.executeQuery();
                if(rs1.next() || rs2.next()){
                  JOptionPane.showMessageDialog(this, "You are supporting a patient! Cannot delete your account!");
                } else {
                    sql1 = "Delete from health_supporter where id ='"+DBMS_Connection.loginID+"'";
                    ps = con.prepareStatement(sql1);
                    ps.execute();
                    con.commit();
                    dispose();
                    new LoginFrame().setVisible(true);
                } 
                con.commit();
                con.close();
        } catch (SQLException ex) {
            Logger.getLogger(HealthSupMainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_delAccountButtonActionPerformed

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
            java.util.logging.Logger.getLogger(HealthSupMainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HealthSupMainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HealthSupMainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HealthSupMainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HealthSupMainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton LOGOUT;
    private javax.swing.JButton access_patient_button;
    private javax.swing.JButton delAccountButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
