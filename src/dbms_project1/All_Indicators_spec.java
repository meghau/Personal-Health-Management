/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dbms_project1;

/**
 *
 * @author abc
 */
public class All_Indicators_spec extends javax.swing.JFrame {

    /**
     * Creates new form All_Indicators_spec
     */
    public All_Indicators_spec() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Weight = new javax.swing.JButton();
        Blood_Pressure_sys = new javax.swing.JButton();
        Blood_Pressure_dia = new javax.swing.JButton();
        Oxy_Sat = new javax.swing.JButton();
        Pain = new javax.swing.JButton();
        Mood = new javax.swing.JButton();
        Temp = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Weight.setText("Weight");
        Weight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                WeightActionPerformed(evt);
            }
        });

        Blood_Pressure_sys.setText("Blood Pressure Systolic");
        Blood_Pressure_sys.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Blood_Pressure_sysActionPerformed(evt);
            }
        });

        Blood_Pressure_dia.setText("Blood Pressure Diastolic");
        Blood_Pressure_dia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Blood_Pressure_diaActionPerformed(evt);
            }
        });

        Oxy_Sat.setText("Oxygen Saturation");
        Oxy_Sat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Oxy_SatActionPerformed(evt);
            }
        });

        Pain.setText("Pain");
        Pain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PainActionPerformed(evt);
            }
        });

        Mood.setText("Mood");
        Mood.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MoodActionPerformed(evt);
            }
        });

        Temp.setText("Temperature");
        Temp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TempActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(121, 121, 121)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(Oxy_Sat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Blood_Pressure_sys, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Weight, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Pain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Mood, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Temp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Blood_Pressure_dia, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(134, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(Weight)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Blood_Pressure_sys, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(Blood_Pressure_dia, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Oxy_Sat)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Pain)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Mood)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Temp)
                .addContainerGap(55, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void WeightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_WeightActionPerformed
        DBMS_Connection.indicator="Weight";
        System.out.println(DBMS_Connection.indicator);
        this.setVisible(false);
        add_spec_rec asr =new add_spec_rec();
        asr.setVisible(true);

    }//GEN-LAST:event_WeightActionPerformed

    private void Blood_Pressure_sysActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Blood_Pressure_sysActionPerformed
        DBMS_Connection.indicator="BP_Sys";
        this.setVisible(false);
        add_spec_rec asr =new add_spec_rec();
        asr.setVisible(true);

    }//GEN-LAST:event_Blood_Pressure_sysActionPerformed

    private void Blood_Pressure_diaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Blood_Pressure_diaActionPerformed
        // TODO add your handling code here:
        DBMS_Connection.indicator="BP_dys";
        this.setVisible(false);
        add_spec_rec asr =new add_spec_rec();
        asr.setVisible(true);

    }//GEN-LAST:event_Blood_Pressure_diaActionPerformed

    private void Oxy_SatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Oxy_SatActionPerformed
        DBMS_Connection.indicator="Oxygen Saturation";
        this.setVisible(false);
        add_spec_rec asr =new add_spec_rec();
        asr.setVisible(true);

    }//GEN-LAST:event_Oxy_SatActionPerformed

    private void PainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PainActionPerformed
        DBMS_Connection.indicator="Pain";
        this.setVisible(false);
        add_spec_rec asr =new add_spec_rec();
        asr.setVisible(true);

    }//GEN-LAST:event_PainActionPerformed

    private void MoodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MoodActionPerformed
        DBMS_Connection.indicator="Mood";
        this.setVisible(false);
        add_spec_rec asr =new add_spec_rec();
        asr.setVisible(true);

    }//GEN-LAST:event_MoodActionPerformed

    private void TempActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TempActionPerformed
        DBMS_Connection.indicator="Temperature";
        this.setVisible(false);
        add_spec_rec asr =new add_spec_rec();
        asr.setVisible(true);

    }//GEN-LAST:event_TempActionPerformed

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
            java.util.logging.Logger.getLogger(All_Indicators_spec.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(All_Indicators_spec.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(All_Indicators_spec.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(All_Indicators_spec.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new All_Indicators_spec().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Blood_Pressure_dia;
    private javax.swing.JButton Blood_Pressure_sys;
    private javax.swing.JButton Mood;
    private javax.swing.JButton Oxy_Sat;
    private javax.swing.JButton Pain;
    private javax.swing.JButton Temp;
    private javax.swing.JButton Weight;
    // End of variables declaration//GEN-END:variables
}
