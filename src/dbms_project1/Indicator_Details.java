/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dbms_project1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author abc
 */
public class Indicator_Details extends javax.swing.JFrame {
String patient_id=DBMS_Connection.loginID;
String indicator=DBMS_Connection.indicator;
    /**
     * Creates new form Indicator_Details
     */

    public Indicator_Details() {
    try {
        initComponents();
    
        Connection con=DBMS_Connection.get();
    //'"+patient_id+"'
            Indicator_Value.setText(indicator);
            System.out.println("In indicator details");
            Description_Indicator.setText(indicator);
            Description_Indicator.setEditable(false);
            String query="select max(frequency),max(lower),max(upper),max(info) from recommendations where patient_id=111 and disease_name in (Select disease_name from diagnosis where patient_id=111) and indicator='"+indicator+"'" ;
            Statement stm=con.createStatement();
            ResultSet rs=stm.executeQuery(query);
            if(rs.next()){
                if(rs.next())
                {
              //  System.out.println("patient_i");    
                int frequency=rs.getInt(1);
                int lower1=rs.getInt(2);
                int upper1=rs.getInt(3);
                int info=rs.getInt(4);
                if(frequency!=0)
                {
                    freq.setText(Integer.toString(frequency));
                    freq.setEditable(false);
                }   
                else
                    freq.setEditable(false);
                if(lower1==0 && upper1==0)
                {
                    lower_limit.setEditable(false);
                    upper_limit.setEditable(false);
                }
                else
                {
                    lower_limit.setText(Integer.toString(lower1));
                    upper_limit.setText(Integer.toString(upper1));
                    lower_limit.setEditable(false);
                    upper_limit.setEditable(false);
                }
                if(indicator=="Mood")
                {
                    if(info==0)
                     Info.setText("Happy");
                    else if(info==1)
                      Info.setText("Neutral");
                    else
                        Info.setText("Sad");
                    Info.setEditable(false);
                }   
                else if(indicator=="Pain")
                {
                    if(info==0)
                        Info.setEditable(false);
                    else
                        Info.setText(Integer.toString(info));
                    Info.setEditable(false);
                }
                else
                    Info.setEditable(false);
                }
                else
                {
                System.out.println(patient_id);
                String query1="select max(frequency),max(lower),max(upper),max(info) from recommendations where patient_id=001 and disease_name in (Select disease_name from diagnosis where patient_id='"+patient_id+"') and indicator='"+indicator+"'" ;
                Statement stm1=con.createStatement();
                ResultSet rs1=stm1.executeQuery(query1);
                
          //      System.out.println("Yeswww");
                if(rs1.next())
                {
                int frequency=rs1.getInt(1);
                int lower1=rs1.getInt(2);
                int upper1=rs1.getInt(3);
                int info=rs1.getInt(4);
            //    System.out.println(frequency);
            //    System.out.println(lower1);
            //    System.out.println(upper1);
            //    System.out.println(info);
                if(frequency!=0)
                {
                    freq.setText(Integer.toString(frequency));
                    freq.setEditable(false);
                }
                else
                    freq.setEditable(false);
                if(lower1==0 && upper1==0)
                {
                    lower_limit.setEditable(false);
                    upper_limit.setEditable(false);
                }
                else
                {
                    lower_limit.setText(Integer.toString(lower1));
                    upper_limit.setText(Integer.toString(upper1));
                    lower_limit.setEditable(false);
                    upper_limit.setEditable(false);
                }
                if(indicator=="Mood")
                {
                    if(info==0)
                     Info.setText("Happy");
                    else if(info==1)
                      Info.setText("Neutral");
                    else
                        Info.setText("Sad");
                    Info.setEditable(false);
                }   
                else if(indicator=="Pain")
                    if(info==0)
                        Info.setEditable(false);
                    else
                    {
                        Info.setText(Integer.toString(info));
                        Info.setEditable(false);
                    }
                else
                    Info.setEditable(false);
                }
                }
                }
    } catch (SQLException ex) {
        Logger.getLogger(Indicator_Details.class.getName()).log(Level.SEVERE, null, ex);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        Description_Indicator = new javax.swing.JTextArea();
        freq = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lower_limit = new javax.swing.JTextField();
        upper_limit = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        Info = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        Indicator_Value = new java.awt.Label();
        Back = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Description_Indicator.setColumns(20);
        Description_Indicator.setRows(5);
        jScrollPane1.setViewportView(Description_Indicator);

        freq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                freqActionPerformed(evt);
            }
        });

        jLabel1.setText("Alert Threshold");

        jLabel2.setText("Description");

        jLabel3.setText("Recommended Limit");

        jLabel4.setText("to");

        jButton1.setText("ADD MEASUREMENT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel5.setText("Info");

        Indicator_Value.setText("label1");

        Back.setText("BACK");
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(Back)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(82, 82, 82))
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGap(28, 28, 28))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGap(36, 36, 36))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(59, 59, 59)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Indicator_Value, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(freq, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Info, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lower_limit, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(upper_limit, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(111, 111, 111))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Indicator_Value, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(freq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lower_limit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(upper_limit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addComponent(Info, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(Back))
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        Add_Measurement_of_Indicator amoi =new Add_Measurement_of_Indicator();
        amoi.setVisible(true);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void freqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_freqActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_freqActionPerformed

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        All_Indicators ai=new All_Indicators();
        ai.setVisible(true);
    }//GEN-LAST:event_BackActionPerformed

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
            java.util.logging.Logger.getLogger(Indicator_Details.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Indicator_Details.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Indicator_Details.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Indicator_Details.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Indicator_Details().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Back;
    private javax.swing.JTextArea Description_Indicator;
    private java.awt.Label Indicator_Value;
    private javax.swing.JTextField Info;
    private javax.swing.JTextField freq;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField lower_limit;
    private javax.swing.JTextField upper_limit;
    // End of variables declaration//GEN-END:variables
}
