/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dbms_project1;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author abc
 */
public class View_Edit_Diagnoses extends javax.swing.JFrame {
    int patient_id;
    /**
     * Creates new form View_Edit_Diagnoses
     */
    public View_Edit_Diagnoses() {
        try {
            initComponents();
            String s="";
            Connection con=DBMS_Connection.get();
            //Statement stmt=con.createStatement();
            System.out.println(DBMS_Connection.loginID);
            String query1="select DISEASE_NAME from diagnosis WHERE PATIENT_ID='"+DBMS_Connection.loginID+"'";
            System.out.println(query1);
            Statement stm=con.createStatement();
            ResultSet rs=stm.executeQuery(query1);
            
            while(rs.next())
            {
              s+=rs.getString("DISEASE_NAME")+"\n";
            }
            System.out.println("dis:"+s);
            Current_Diag.setText(s);
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(View_Edit_Diagnoses.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Current_Diag = new javax.swing.JTextArea();
        disease = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        Add_diag = new javax.swing.JButton();
        back_button = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Current Diagnoses: ");

        Current_Diag.setEditable(false);
        Current_Diag.setColumns(20);
        Current_Diag.setRows(5);
        jScrollPane1.setViewportView(Current_Diag);

        disease.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "HD", "HIV", "COPD", " " }));
        disease.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                diseaseActionPerformed(evt);
            }
        });

        jLabel2.setText("Diagnoses");

        Add_diag.setText("ADD");
        Add_diag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Add_diagActionPerformed(evt);
            }
        });

        back_button.setText("Back");
        back_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(disease, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Add_diag)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(back_button)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(back_button))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(disease, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Add_diag))
                .addGap(69, 69, 69))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Add_diagActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Add_diagActionPerformed
        
        String diseases=(String)disease.getSelectedItem();
        try {
            boolean flag=false;
           // DBMS_Connection.
            Connection con=DBMS_Connection.get();
            String query1="select DISEASE_NAME from diagnosis WHERE PATIENT_ID='"+DBMS_Connection.loginID+"'";
            Statement stm=con.createStatement();
            ResultSet rs=stm.executeQuery(query1);
            
            while(rs.next())
            {
              if (rs.getString("DISEASE_NAME").equals(diseases))
              {
                  
                  flag=true;
              }
            }
            if(flag==false){
                String query="select psid from well_patient where id='"+DBMS_Connection.loginID+"'"; 
                PreparedStatement ps=con.prepareStatement(query);
                ResultSet rs1 = ps.executeQuery();
                rs1.next();
                if(rs1.getString(1) != null){

                    query="insert into diagnosis values(?,?)"; 
                    ps=con.prepareStatement(query);
                    ps.setString(1,DBMS_Connection.loginID);
                    ps.setString(2,diseases);

                    ps.executeQuery();
                //    JOptionPane.showMessageDialog(this,"Added");
                    // insert into sick patient, if not present
                    query="select id,psid,TO_CHAR(p_auth_date, 'DD-MON-YY'),ssid,TO_CHAR(s_auth_date, 'DD-MON-YY') from well_patient where id='"+DBMS_Connection.loginID+"'"; 
                    ps=con.prepareStatement(query);
                    rs1 = ps.executeQuery();
                    if(rs1.next()){
                        System.out.println("inserting into sick_patient");
                        query="insert into sick_patient values(?,?,?,?,?)";
                        ps=con.prepareStatement(query);
                        System.out.println(rs1.getString(1)+"\n"+rs1.getString(2)+"\n"+rs1.getString(3)+"\n"+rs1.getString(4)+"\n"+rs1.getString(5));
                        ps.setString(1, rs1.getString(1));
                        ps.setString(2, rs1.getString(2));
                        ps.setString(3, rs1.getString(3));
                        ps.setString(4, rs1.getString(4));
                        ps.setString(5, rs1.getString(5));

                        ps.execute();

                        // delete from well patient
                        query="delete from well_patient where id='"+DBMS_Connection.loginID+"'"; 
                        ps=con.prepareStatement(query);
                        ps.execute();
                        DBMS_Connection.patientType = "sick";
                    }
                } else
                    JOptionPane.showMessageDialog(this, "Action not allowed. Add a health supporter first!");
            }
            else
            {
                JOptionPane.showMessageDialog(this,"Diasease exists!");
            }  
            
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(View_Edit_Diagnoses.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Add_diagActionPerformed

    private void diseaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_diseaseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_diseaseActionPerformed

    private void back_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_buttonActionPerformed
        dispose();
        new Patient_Menu().setVisible(true);
    }//GEN-LAST:event_back_buttonActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(View_Edit_Diagnoses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(View_Edit_Diagnoses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(View_Edit_Diagnoses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(View_Edit_Diagnoses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new View_Edit_Diagnoses().setVisible(true);
//            }
//        });
//    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Add_diag;
    private javax.swing.JTextArea Current_Diag;
    private javax.swing.JButton back_button;
    private javax.swing.JComboBox disease;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
