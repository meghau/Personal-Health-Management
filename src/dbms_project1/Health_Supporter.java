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
import javax.swing.JOptionPane;

/**
 *
 * @author aishu
 */
public class Health_Supporter extends javax.swing.JFrame {
    String table = "";
    boolean isEdited1=false, isEdited2=false;
    /**
     * Creates new form Health_Supporter
     */
    public Health_Supporter() {
        
        try {
            
            initComponents();
            myInitComponents();
            // no phone number for now 
            s1_phno.setVisible(false);
            s2_phno.setVisible(false);
            jLabel4.setVisible(false);
            jLabel8.setVisible(false);
            
            Connection con = DBMS_Connection.get();
            
            if(DBMS_Connection.patientType.equalsIgnoreCase("well"))
                table="well_patient";
            else
                table="sick_patient";
            
            
            String sql1 = "Select w.psid from patient p, "+ table+" w "
                    +"where w.psid=p.id and w.id='"+DBMS_Connection.loginID+"'";
            PreparedStatement ps1 = con.prepareStatement(sql1);
            ResultSet rs1 = ps1.executeQuery();
            
            String sql2 = "Select w.ssid from patient p, "+ table+" w "
                    +"where w.ssid=p.id and w.id='"+DBMS_Connection.loginID+"'";
            PreparedStatement ps2 = con.prepareStatement(sql2);
            ResultSet rs2 = ps2.executeQuery();
            
            s1_name.setEditable(true);
            s1_addr.setEditable(true);
            s1_auth.setEditable(true);
            
            s2_name.setEditable(true);
            s2_addr.setEditable(true);
            s2_auth.setEditable(true);
            if(rs1.next()){
                s1_add.setVisible(false);
                s1_combo.setVisible(false);
                
                s1_name.setEditable(false);
                s1_addr.setEditable(false);
//                s1_phno.setEditable(false);
                s1_auth.setEditable(false);
                
                sql1 = "select name,address,TO_CHAR(p_auth_date, 'DD-MON-YY') from patient p, "+table+" w where p.id=w.psid and w.id='"+DBMS_Connection.loginID+"'";
                ps1 = con.prepareStatement(sql1);
                rs1 = ps1.executeQuery();
                if(rs1.next()){
                    s1_name.setText(rs1.getString(1));
                    s1_addr.setText(rs1.getString(2));
                    s1_auth.setText(rs1.getString(3));
                }
            }else
                s1_delete.setVisible(false);
            
            if(rs2.next()){
                s2_add.setVisible(false);
                s2_combo.setVisible(false);
                
                s2_name.setEditable(false);
                s2_addr.setEditable(false);
                s2_auth.setEditable(false);
                
                sql2 = "select name,address,TO_CHAR(s_auth_date, 'DD-MON-YY') from patient p, "+table+" w where p.id=w.ssid and w.id='"+DBMS_Connection.loginID+"'";
                ps2 = con.prepareStatement(sql2);
                rs2 = ps2.executeQuery();
                if(rs2.next()){
                    s2_name.setText(rs2.getString(1));
                    s2_addr.setText(rs2.getString(2));
                    s2_auth.setText(rs2.getString(3));
                }
            }else
                s2_delete.setVisible(false);
            
            //populate combo box
            sql1="Select id from health_supporter";
            ps1 = con.prepareStatement(sql1);
            rs1 = ps1.executeQuery(sql1);
                
            s1_combo.removeAllItems();
            s2_combo.removeAllItems();
                
            while(rs1.next()){
                s1_combo.addItem(rs1.getString("id"));
                s2_combo.addItem(rs1.getString("id"));
            }
            con.commit();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Health_Supporter.class.getName()).log(Level.SEVERE, null, ex);
        }         
    }
    
    public void myInitComponents() {
        s1_combo.addFocusListener(new java.awt.event.FocusAdapter() {
                public void focusLost(java.awt.event.FocusEvent evt) {
                    s1_comboFocusLost(evt);
                }
            });
            
        s2_combo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                s2_comboFocusLost(evt);
            }
        });
        
        s2_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s2_addActionPerformed(evt);
            }
        });
        
        s1_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s1_editActionPerformed(evt);
            }
        });
        
        s2_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s2_editActionPerformed(evt);
            }
        });
        
        s1_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s1_saveActionPerformed(evt);
            }
        });
        
        s2_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s2_saveActionPerformed(evt);
            }
        });
        
        s1_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s1_deleteActionPerformed(evt);
            }
        });
        
        s2_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s2_deleteActionPerformed(evt);
            }
        });
        
//        s2_delete.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                s2_deleteActionPerformed(evt);
//            }
//        });
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
        jLabel2 = new javax.swing.JLabel();
        s1_name = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        s1_addr = new javax.swing.JTextField();
        s1_phno = new javax.swing.JTextField();
        s1_auth = new javax.swing.JTextField();
        s2_addr = new javax.swing.JTextField();
        s2_phno = new javax.swing.JTextField();
        s2_name = new javax.swing.JTextField();
        s2_auth = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        done_button = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        s1_combo = new javax.swing.JComboBox<>();
        s1_edit = new javax.swing.JButton();
        s1_add = new javax.swing.JButton();
        s1_save = new javax.swing.JButton();
        s1_delete = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        s2_combo = new javax.swing.JComboBox<>();
        s2_add = new javax.swing.JButton();
        s2_edit = new javax.swing.JButton();
        s2_save = new javax.swing.JButton();
        s2_delete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("PRIMARY");

        jLabel2.setText("SECONDARY");

        s1_name.setEditable(false);
        s1_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s1_nameActionPerformed(evt);
            }
        });

        jLabel3.setText("Name");

        jLabel4.setText("Ph no");

        jLabel5.setText("Address");

        jLabel6.setText("Auth Date");

        s1_addr.setEditable(false);

        s1_phno.setEditable(false);
        s1_phno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s1_phnoActionPerformed(evt);
            }
        });

        s1_auth.setEditable(false);
        s1_auth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s1_authActionPerformed(evt);
            }
        });

        s2_addr.setEditable(false);

        s2_phno.setEditable(false);
        s2_phno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s2_phnoActionPerformed(evt);
            }
        });

        s2_name.setEditable(false);

        s2_auth.setEditable(false);
        s2_auth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s2_authActionPerformed(evt);
            }
        });

        jLabel7.setText("Name");

        jLabel8.setText("Ph no");

        jLabel9.setText("Address");

        jLabel10.setText("Auth Date");

        done_button.setText("Done!");
        done_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                done_buttonActionPerformed(evt);
            }
        });

        s1_edit.setText("Edit");

        s1_add.setText("Add");
        s1_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s1_addActionPerformed(evt);
            }
        });

        s1_save.setText("Save");

        s1_delete.setText("Delete");

        jLabel11.setText("ID");

        jLabel12.setText("ID");

        s2_add.setText("Add");

        s2_edit.setText("Edit");

        s2_save.setText("Save");

        s2_delete.setText("Delete");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(s1_addr, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel11))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(s1_name, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(s1_combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel4)))
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(s1_phno, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(s1_auth, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(s1_delete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(s1_save, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(s1_edit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(s1_add, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(28, 28, 28))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel12))
                                .addGap(44, 44, 44)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(s2_combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(s2_name, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(44, 44, 44)
                                        .addComponent(jLabel8))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(s2_addr, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(44, 44, 44)
                                        .addComponent(jLabel10))))
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(s2_auth, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(s2_phno, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(61, 61, 61)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(s2_delete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(s2_save, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(s2_edit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(s2_add, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
            .addGroup(layout.createSequentialGroup()
                .addGap(215, 215, 215)
                .addComponent(done_button)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(31, 31, 31)
                                        .addComponent(jLabel11))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(28, 28, 28)
                                        .addComponent(s1_combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(s1_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4)
                                    .addComponent(s1_phno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel5)
                                        .addComponent(s1_addr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel6)
                                        .addComponent(s1_auth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(s1_add)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(s1_edit)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(s1_save)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(s1_delete))))
                    .addComponent(jLabel1))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(s2_combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(s2_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(s2_phno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(s2_addr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(s2_auth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(s2_add)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(s2_edit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(s2_save)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(s2_delete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(done_button)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void s1_phnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s1_phnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s1_phnoActionPerformed

    private void s1_authActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s1_authActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s1_authActionPerformed

    private void s2_phnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s2_phnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s2_phnoActionPerformed

    private void s2_authActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s2_authActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s2_authActionPerformed

    private void s1_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s1_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s1_nameActionPerformed

    private void s1_comboFocusLost(java.awt.event.FocusEvent evt) {
        
        try {
            String sql1 = "select name,address from patient p where p.id='"+s1_combo.getSelectedItem()+"'";
            PreparedStatement  ps1 = DBMS_Connection.get().prepareStatement(sql1);
            ResultSet rs1 = ps1.executeQuery();
            if(rs1.next()){
                s1_name.setText(rs1.getString(1));
                s1_addr.setText(rs1.getString(2));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Health_Supporter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void s2_comboFocusLost(java.awt.event.FocusEvent evt) {
        try {
            String sql1 = "select name,address from patient p where p.id='"+s2_combo.getSelectedItem()+"'";
            PreparedStatement  ps1 = DBMS_Connection.get().prepareStatement(sql1);
            ResultSet rs1 = ps1.executeQuery();
            if(rs1.next()){
                s2_name.setText(rs1.getString(1));
                s2_addr.setText(rs1.getString(2));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Health_Supporter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void done_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_done_buttonActionPerformed
        this.setVisible(false);
        dispose();
        Patient_Menu menu = new Patient_Menu();
        menu.setVisible(true);
    }//GEN-LAST:event_done_buttonActionPerformed

    private void s1_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s1_addActionPerformed
        try {
            s1_name.setEditable(false);
            s1_addr.setEditable(false);
            s1_auth.setEditable(false);
            System.out.println("inserting s1");
            Connection con = DBMS_Connection.get();
            String sql = "update "+table+" set psid='"+(String)s1_combo.getSelectedItem()+"',p_auth_date='"+s1_auth.getText()+"' where id='"+DBMS_Connection.loginID+"'";
            System.out.println(sql);
            PreparedStatement ps = con.prepareStatement(sql);
            ps.executeUpdate();
            System.out.println("executed s1");
            s1_combo.setVisible(false);
            isEdited1=false;
            s1_delete.setVisible(true);
            con.commit();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Health_Supporter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_s1_addActionPerformed

    private void s2_addActionPerformed(java.awt.event.ActionEvent evt) {                                       
        try {
            s2_name.setEditable(false);
            s2_addr.setEditable(false);
            s2_auth.setEditable(false);
            System.out.println("inserting s2");
            Connection con = DBMS_Connection.get();
            String sql = "update "+table+" set ssid='"+(String)s2_combo.getSelectedItem()+"',s_auth_date='"+s2_auth.getText()+"' where id='"+DBMS_Connection.loginID+"'";
            System.out.println(sql);
            PreparedStatement ps = con.prepareStatement(sql);
            ps.executeUpdate();
            System.out.println("executed s2");
            s2_combo.setVisible(false);
            isEdited2=false;
            s2_delete.setVisible(true);
            con.commit();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Health_Supporter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void s1_editActionPerformed(java.awt.event.ActionEvent evt) {                                       
        s1_name.setEditable(true);
        s1_addr.setEditable(true);
        s1_auth.setEditable(true);
        s1_combo.setVisible(true);
        isEdited1=true;
    }  
    
    private void s2_editActionPerformed(java.awt.event.ActionEvent evt) {                                       
        s2_name.setEditable(true);
        s2_addr.setEditable(true);
        s2_auth.setEditable(true);
        s2_combo.setVisible(true);
        isEdited2=true;
    }  
    
    private void s1_saveActionPerformed(java.awt.event.ActionEvent evt) {                                       
        try {
            s1_combo.setVisible(false);
            s1_name.setEditable(false);
            s1_addr.setEditable(false);
            s1_auth.setEditable(false);
            if(isEdited1){
                System.out.println("saving s1");
                Connection con = DBMS_Connection.get();
                con.setAutoCommit(false);
                String sql = "update "+table+" set psid='"+(String)s1_combo.getSelectedItem()+"',p_auth_date='"+s1_auth.getText()+"' where id='"+DBMS_Connection.loginID+"'";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.executeUpdate();

                sql = "update patient set name='"+s1_name.getText()+"',address='"+s1_addr.getText()+"' where id='"+(String)s1_combo.getSelectedItem()+"'";
                ps = con.prepareStatement(sql);
                ps.executeUpdate();
                con.setAutoCommit(true);
                con.commit();
                con.close();
            }
            isEdited1=false;
        } catch (SQLException ex) {
            Logger.getLogger(Health_Supporter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }  
    
    private void s2_saveActionPerformed(java.awt.event.ActionEvent evt) {                                       
        try {
            s2_combo.setVisible(false);
            s2_name.setEditable(false);
            s2_addr.setEditable(false);
            s2_auth.setEditable(false);
            if(isEdited2){
                System.out.println("saving s2");
                Connection con = DBMS_Connection.get();
                con.setAutoCommit(false);
                String sql = "update "+table+" set ssid='"+(String)s2_combo.getSelectedItem()+"',s_auth_date='"+s2_auth.getText()+"' where id='"+DBMS_Connection.loginID+"'";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.executeUpdate();

                sql = "update patient set name='"+s2_name.getText()+"',address='"+s2_addr.getText()+"' where id='"+(String)s2_combo.getSelectedItem()+"'";
                ps = con.prepareStatement(sql);
                ps.executeUpdate();
                con.setAutoCommit(true);
                con.commit();
                con.close();
            }
            isEdited2=false;
        } catch (SQLException ex) {
            Logger.getLogger(Health_Supporter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }  
    
    private void s1_deleteActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            Connection con = DBMS_Connection.get();
//            if(DBMS_Connection.patientType.equalsIgnoreCase("sick")){
                System.out.println(DBMS_Connection.patientType);
                String sql = "Select w.ssid,name,address,TO_CHAR(s_auth_date, 'DD-MON-YY') from "+ table+" w, patient p"
                        +" where p.id=w.ssid and w.id='"+DBMS_Connection.loginID+"'";
//                
                PreparedStatement ps2 = con.prepareStatement(sql);
                ResultSet rs2 = ps2.executeQuery();
                if(rs2.next()){
                    System.out.println(rs2.getString(4));
                    System.out.println(table);
//                    con.setAutoCommit(false);
                    sql="update "+table+" set psid='"+rs2.getString(1)+"',p_auth_date='"+rs2.getString(4)+"',ssid=null,s_auth_date=null where id='"+DBMS_Connection.loginID+"'";
                    ps2 = con.prepareStatement(sql);
//                    ps2.setString(1, rs2.getString(1));
//                    ps2.setString(2,rs2.getString(4));
                    System.out.println(sql);
                    int f = ps2.executeUpdate();
                    if(f!=1)
                        System.out.println("f value not 1");
                    else
                        System.out.println("f value is 1");
//                    con.setAutoCommit(true);
                    
                    con.commit();
                }else if(DBMS_Connection.patientType.equalsIgnoreCase("well")){
                    sql="update "+table+" set psid=null,p_auth_date=null,ssid=null,s_auth_date=null where id='"+DBMS_Connection.loginID+"'";
                    ps2 = con.prepareStatement(sql);
                    ps2.executeUpdate();
                } else {
                    JOptionPane.showMessageDialog(this, "You are sick. Cannot delete Health Supporter!");
                }
            /*}else{
                System.out.println("delete for well patient");
                String sql="update "+table+" set psid=null, p_auth_date=null where id='"+DBMS_Connection.loginID+"'";
                PreparedStatement ps2 = con.prepareStatement(sql);
                ps2.executeUpdate();
            }*/
            con.commit();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Health_Supporter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    private void s2_deleteActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            Connection con = DBMS_Connection.get();
            PreparedStatement ps = null;
            System.out.println(DBMS_Connection.patientType);
            String sql="update "+table+" set ssid=null,s_auth_date=null where id='"+DBMS_Connection.loginID+"'";
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
            con.commit();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Health_Supporter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
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
            java.util.logging.Logger.getLogger(Health_Supporter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Health_Supporter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Health_Supporter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Health_Supporter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Health_Supporter().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton done_button;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JButton s1_add;
    private javax.swing.JTextField s1_addr;
    private javax.swing.JTextField s1_auth;
    private javax.swing.JComboBox<String> s1_combo;
    private javax.swing.JButton s1_delete;
    private javax.swing.JButton s1_edit;
    private javax.swing.JTextField s1_name;
    private javax.swing.JTextField s1_phno;
    private javax.swing.JButton s1_save;
    private javax.swing.JButton s2_add;
    private javax.swing.JTextField s2_addr;
    private javax.swing.JTextField s2_auth;
    private javax.swing.JComboBox<String> s2_combo;
    private javax.swing.JButton s2_delete;
    private javax.swing.JButton s2_edit;
    private javax.swing.JTextField s2_name;
    private javax.swing.JTextField s2_phno;
    private javax.swing.JButton s2_save;
    // End of variables declaration//GEN-END:variables
}
