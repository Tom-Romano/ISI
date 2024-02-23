/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package quatreboutons2a2;

/**
 *
 * @author ROMANO Tom
 */
public class QuatreBoutons2a2 extends javax.swing.JFrame {
    
     private enum STATE{
        E1,
        E2,
        E3,
        E4,
        E5,
        E6
    }
     
     private STATE etat;
    /**
     * Creates new form QuatreBoutons2a2
     */
    public QuatreBoutons2a2() {
        initComponents();
        initStateMachine();
    }
    
    private void initStateMachine(){
        etat=STATE.E1;
        button1.setEnabled(true);
        button2.setEnabled(true);
        button3.setEnabled(false);
        button4.setEnabled(false);
    }
    
    private void activateE1(){
        button1.setEnabled(true);
        button2.setEnabled(true);
        button3.setEnabled(false);
        button4.setEnabled(false);
    }
     
    private void activateE2(){
       button1.setEnabled(true);
        button2.setEnabled(true);
        button3.setEnabled(false);
        button4.setEnabled(false);
    }
    
    private void activateE3(){
        button1.setEnabled(true);
        button2.setEnabled(true);
        button3.setEnabled(false);
        button4.setEnabled(false);
    }
    private void activateE4(){
        button1.setEnabled(false);
        button2.setEnabled(false);
        button3.setEnabled(true);
        button4.setEnabled(true);
    }
    private void activateE5(){
        button1.setEnabled(false);
        button2.setEnabled(false);
        button3.setEnabled(true);
        button4.setEnabled(true);
    }
    private void activateE6(){
        button1.setEnabled(false);
        button2.setEnabled(false);
        button3.setEnabled(true);
        button4.setEnabled(true);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // </editor-fold>
    
 
                                      

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        button1 = new javax.swing.JButton();
        button2 = new javax.swing.JButton();
        button3 = new javax.swing.JButton();
        button4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quatre Boutons 2 à 2");

        button1.setText("Button 1");
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        button2.setText("Button 2");
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });

        button3.setText("Button 3");
        button3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button3ActionPerformed(evt);
            }
        });

        button4.setText("Button 4");
        button4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(button3)
                    .addComponent(button1))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(button2)
                    .addComponent(button4))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button1)
                    .addComponent(button2))
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button3)
                    .addComponent(button4))
                .addContainerGap(65, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        switch(etat){
            case E1 -> {
                etat=STATE.E2;
                activateE2();
            }
            case E2 -> {
                etat=STATE.E2;
                activateE2();  
            } 
            case E3 -> {
                etat=STATE.E4;
                activateE4();
            }
        } 
    }//GEN-LAST:event_button1ActionPerformed

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
            switch(etat){
            case E1 -> {
                etat=STATE.E3;
                activateE3();
            }
            case E2 -> {
                etat=STATE.E4;
                activateE4();
            } 
             case E3 -> {
                etat=STATE.E3;
                activateE3();
            }
        }  
    }//GEN-LAST:event_button2ActionPerformed

    private void button3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button3ActionPerformed
        switch(etat){
            case E4 -> {
                etat=STATE.E5;
                activateE5();
            }
            case E5 -> {
                etat=STATE.E5;
                activateE5();
            }
            case E6 -> {
                etat=STATE.E1;
                activateE1();
            }
        } 
    }//GEN-LAST:event_button3ActionPerformed

    private void button4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button4ActionPerformed
       switch(etat){
            case E4 -> {
                etat=STATE.E6;
                activateE6();
            }
            case E5 -> {
                etat=STATE.E1;
                activateE1();
            }
            case E6 -> {
                etat=STATE.E6;
                activateE6();
            }
        } 
    }//GEN-LAST:event_button4ActionPerformed

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
            java.util.logging.Logger.getLogger(QuatreBoutons2a2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuatreBoutons2a2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuatreBoutons2a2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuatreBoutons2a2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuatreBoutons2a2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button1;
    private javax.swing.JButton button2;
    private javax.swing.JButton button3;
    private javax.swing.JButton button4;
    // End of variables declaration//GEN-END:variables
}
