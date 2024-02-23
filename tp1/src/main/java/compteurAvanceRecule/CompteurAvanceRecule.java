/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package compteurAvanceRecule;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 *
 * @author ROMANO Tom
 */
public class CompteurAvanceRecule extends javax.swing.JFrame {

    private enum STATE{
        E1(true, false, false, false, false),
        E2(false, true, false, true, true),
        E3(false, false, true, true, true);
        
        private boolean startButtonActive;
        private boolean reculeButtonActive;
        private boolean avanceButtonActive;
        private boolean stopButtonActive;
        private boolean tickTimerActive;

        private STATE(boolean startButtonActive, boolean reculeButtonActive, boolean avanceButtonActive, boolean stopButtonActive, boolean tickTimerActive) {
            this.startButtonActive = startButtonActive;
            this.reculeButtonActive = reculeButtonActive;
            this.avanceButtonActive = avanceButtonActive;
            this.stopButtonActive = stopButtonActive;
            this.tickTimerActive = tickTimerActive;
        }
        

        public boolean isStartButtonActive() {
            return startButtonActive;
        }

        public boolean isReculeButtonActive() {
            return reculeButtonActive;
        }

        public boolean isAvanceButtonActive() {
            return avanceButtonActive;
        }

        public boolean isStopButtonActive() {
            return stopButtonActive;
        }

        public boolean isTickTimerActive() {
            return tickTimerActive;
        }
        
        
        
    }
    
    private Timer tickTimer;
    private int cpt;
    private STATE etat;
    
    private void timerInit(){
        tickTimer = new Timer(30, new ActionListener() { // 1000 ms = 1 seconde
            @Override
            public void actionPerformed(ActionEvent e) {
                   tickTimerActionPerformed(e);
            }
        });
    }
    
    private void tickTimerActionPerformed(ActionEvent e){
        switch(etat){
            case E1 -> {
                throw new IllegalStateException("Tick in the E1 statement." );
            }

            case E2 -> {
                cpt++;
                AfficherLabelText();
            }
            case E3 -> {
                cpt--;
                AfficherLabelText();
            }
        }
    }
    
    private void AfficherLabelText(){
        compteurLabel.setText(Integer.toString(cpt));
    }
    
    private void updateStatements(){
        this.startButton.setEnabled(this.etat.isStartButtonActive());
        this.stopButton.setEnabled(this.etat.isStopButtonActive());
        this.reculeButton.setEnabled(this.etat.isReculeButtonActive());
        this.avanceButton.setEnabled(this.etat.isAvanceButtonActive());
         if(this.etat.isTickTimerActive()){
            tickTimer.start();
         }else{
            tickTimer.stop();
         }
    }
    
    private void initState(){
        this.etat = STATE.E1;
        timerInit();
        updateStatements();
        this.cpt = 0;
        AfficherLabelText();   
    }
    
    public CompteurAvanceRecule() {
        initComponents();
        initState();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        startButton = new javax.swing.JButton();
        reculeButton = new javax.swing.JButton();
        avanceButton = new javax.swing.JButton();
        stopButton = new javax.swing.JButton();
        compteurLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Compteur avance-recule");

        startButton.setText("Start");
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });

        reculeButton.setText("Recule");
        reculeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reculeButtonActionPerformed(evt);
            }
        });

        avanceButton.setText("Avance");
        avanceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                avanceButtonActionPerformed(evt);
            }
        });

        stopButton.setText("Stop");
        stopButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopButtonActionPerformed(evt);
            }
        });

        compteurLabel.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        compteurLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        compteurLabel.setText("0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(startButton)
                .addGap(18, 18, 18)
                .addComponent(reculeButton)
                .addGap(18, 18, 18)
                .addComponent(avanceButton)
                .addGap(18, 18, 18)
                .addComponent(stopButton)
                .addContainerGap(35, Short.MAX_VALUE))
            .addComponent(compteurLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addComponent(compteurLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(startButton)
                    .addComponent(reculeButton)
                    .addComponent(avanceButton)
                    .addComponent(stopButton))
                .addGap(31, 31, 31))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
        switch(etat){
            case E1 -> {
                this.cpt = 0;
                AfficherLabelText();
                this.etat = STATE.E2;
                updateStatements();  
            }
            case E2 -> {
                throw new IllegalStateException("Button start pressed on state : E2" );
            }
            case E3 -> {
                throw new IllegalStateException("Button start pressed on state : E3" );
            }
        }
    }//GEN-LAST:event_startButtonActionPerformed

    private void reculeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reculeButtonActionPerformed
       switch(etat){
            case E1 -> {
                throw new IllegalStateException("Button recule pressed on state : E1" );
            }
            case E2 -> {
                this.etat = STATE.E3;
                updateStatements(); 
            }
            case E3 -> {
                throw new IllegalStateException("Button recule pressed on state : E3" );
            }
        }
    }//GEN-LAST:event_reculeButtonActionPerformed

    private void avanceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_avanceButtonActionPerformed
         switch(etat){
            case E1 -> {
                throw new IllegalStateException("Button avance pressed on state : E1" );
            }
            case E2 -> {
                throw new IllegalStateException("Button avance pressed on state : E1" );
            }
            case E3 -> {
                this.etat = STATE.E2;
                updateStatements();
            }
        }
    }//GEN-LAST:event_avanceButtonActionPerformed

    private void stopButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopButtonActionPerformed
        switch(etat){
            case E1 -> {
                throw new IllegalStateException("Button stop pressed on state : E1" );
            }
            case E2 -> {
                this.etat = STATE.E1;
                updateStatements();
            }
            case E3 -> {
                this.etat = STATE.E1;
                updateStatements();
            }
        }
    }//GEN-LAST:event_stopButtonActionPerformed

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
            java.util.logging.Logger.getLogger(CompteurAvanceRecule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CompteurAvanceRecule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CompteurAvanceRecule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CompteurAvanceRecule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CompteurAvanceRecule().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton avanceButton;
    private javax.swing.JLabel compteurLabel;
    private javax.swing.JButton reculeButton;
    private javax.swing.JButton startButton;
    private javax.swing.JButton stopButton;
    // End of variables declaration//GEN-END:variables
}