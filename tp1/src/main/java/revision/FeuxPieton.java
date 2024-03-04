/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package revision;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author tomromano
 */
public class FeuxPieton extends javax.swing.JFrame {

    private enum STATE {
        E0(true, false, false, false,false,false),
        E1(false, true, true, false,false,false),
        E2(false, true, false, true,false,false),

        E3(false, true, false, false,true,false),

        E4(false, true, false, false,false,true);

        private boolean startButtonActive;
        private boolean stopButtonActive;
        private boolean timerVertActive;
        private boolean timerRougeActive;
        private boolean timerRougeClignotantEteintActive;
        private boolean timerRougeClignotantAllumeActive;

        STATE (boolean startButtonActive, boolean stopButtonActive, boolean timerVertActive, boolean timerRougeActive, boolean timerRougeClignotantEteintActive, boolean timerRougeClignotantAllumeActive){
            this.startButtonActive=startButtonActive;
            this.stopButtonActive=stopButtonActive;
            this.timerVertActive=timerVertActive;
            this.timerRougeActive=timerRougeActive;
            this.timerRougeClignotantEteintActive=timerRougeClignotantEteintActive;
            this.timerRougeClignotantAllumeActive=timerRougeClignotantAllumeActive;
        }

        public boolean isStartButtonActive() {
            return startButtonActive;
        }

        public boolean isStopButtonActive() {
            return stopButtonActive;
        }

        public boolean isTimerVertActive() {
            return timerVertActive;
        }

        public boolean isTimerRougeActive() {
            return timerRougeActive;
        }

        public boolean isTimerRougeClignotantEteintActive() {
            return timerRougeClignotantEteintActive;
        }

        public boolean isTimerRougeClignotantAllumeActive() {
            return timerRougeClignotantAllumeActive;
        }
    }

    private STATE etat;
    private Timer timerVert;
    private Timer timerRouge;
    private Timer timerRougeClignotantEteint;
    private Timer timerRougeClignotantAllume;
    private int compteur=0;

    private void initAmpoules(){
        this.ampouleRouge.setColor(Color.RED);
        this.ampouleVerte.setColor(Color.GREEN);
    }

    private void initTimer(){
        timerVert = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timerVertAction(e);            }
        });
        timerRouge = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timerRougeAction(e);
            }
        });

        timerRougeClignotantEteint = new Timer(250, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timerRougeClignotantEteintAction(e);
            }
        });

        timerRougeClignotantAllume = new Timer(250, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timerRougeClignotantAllumeAction(e);
            }
        });
    }

    private void timerVertAction(ActionEvent e){
        ampouleVerte.turnOFF();
        ampouleRouge.turnON();
        etat=STATE.E2;
        updateStatement();
    }

    private void timerRougeAction(ActionEvent e){
        ampouleRouge.turnOFF();
        etat=STATE.E3;
        updateStatement();
    }

    private void timerRougeClignotantEteintAction(ActionEvent e){
        ampouleRouge.turnON();
        etat=STATE.E4;
        updateStatement();
    }

    private void timerRougeClignotantAllumeAction(ActionEvent e){
       if(compteur<2){
           ampouleRouge.turnOFF();
           compteur++;
           etat=STATE.E3;
           updateStatement();
       }else{
           System.out.println("compteur=2"+compteur);
           ampouleRouge.turnOFF();
           ampouleVerte.turnON();
           etat=STATE.E1;
           updateStatement();
       }
    }

    private void updateStatement(){
        startButton.setEnabled(this.etat.isStartButtonActive());
        stopButton.setEnabled(this.etat.isStopButtonActive());
        if(this.etat.isTimerVertActive()){
            timerVert.start();
        }else{
            timerVert.stop();
        }

        if(this.etat.isTimerRougeActive()){
            timerRouge.start();
        }else{
            timerRouge.stop();
        }

        if(this.etat.isTimerRougeClignotantEteintActive()){
            timerRougeClignotantEteint.start();
        }else{
            timerRougeClignotantEteint.stop();
        }

        if(this.etat.isTimerRougeClignotantAllumeActive()){
            timerRougeClignotantAllume.start();
        }else{
            timerRougeClignotantAllume.stop();
        }
    }
    private void initStateMachine(){
        initTimer();
        initAmpoules();
        compteur=0;
        etat=STATE.E0;
        updateStatement();
    }
    /**
     * Creates new form FeuxPieton
     */
    public FeuxPieton() {
        initComponents();
        initStateMachine();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ampouleVerte = new revision.Ampoule();
        ampouleRouge = new revision.Ampoule();
        stopButton = new javax.swing.JButton();
        startButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout ampouleVerteLayout = new javax.swing.GroupLayout(ampouleVerte);
        ampouleVerte.setLayout(ampouleVerteLayout);
        ampouleVerteLayout.setHorizontalGroup(
            ampouleVerteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        ampouleVerteLayout.setVerticalGroup(
            ampouleVerteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout ampouleRougeLayout = new javax.swing.GroupLayout(ampouleRouge);
        ampouleRouge.setLayout(ampouleRougeLayout);
        ampouleRougeLayout.setHorizontalGroup(
            ampouleRougeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        ampouleRougeLayout.setVerticalGroup(
            ampouleRougeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        stopButton.setText("Stop");
        stopButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopButtonActionPerformed(evt);
            }
        });

        startButton.setText("Start");
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(ampouleRouge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ampouleVerte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(startButton)
                        .addGap(43, 43, 43)
                        .addComponent(stopButton)))
                .addContainerGap(108, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(ampouleVerte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ampouleRouge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(startButton)
                    .addComponent(stopButton))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void stopButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopButtonActionPerformed
        switch (etat){
            case E1, E2 -> {
                ampouleVerte.turnOFF();
                ampouleRouge.turnOFF();
                etat=STATE.E0;
                compteur=0;
                updateStatement();
            }
        }
    }//GEN-LAST:event_stopButtonActionPerformed

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
        switch (etat){
            case E0 -> {
                ampouleVerte.turnON();
                etat=STATE.E1;
                updateStatement();
            }
        }    }//GEN-LAST:event_startButtonActionPerformed

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
            java.util.logging.Logger.getLogger(FeuxPieton.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FeuxPieton.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FeuxPieton.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FeuxPieton.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FeuxPieton().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private revision.Ampoule ampouleRouge;
    private revision.Ampoule ampouleVerte;
    private javax.swing.JButton startButton;
    private javax.swing.JButton stopButton;


    // End of variables declaration//GEN-END:variables
}
