/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package tp2.feutricolor;

import compteurAvanceRecule.CompteurAvanceRecule;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 *
 * @author ROMANO Tom
 */
public class FeuTricolor extends javax.swing.JFrame {
    
    private enum STATE{
        E0(true,false,false,false,false,false,false,false),
        E1(false,true,true,true,false,false,false,false),
        E2(false,true,true,false,true,false,false,false),
        E3(false,true,true,false,false,true,false,false),
        E4(true,true,false,false,false,false,false,true),
        E5(true,true,false,false,false,false,true,false);
        
        private boolean marcheButtonActive;
        private boolean arretButtonActive;
        private boolean panneButtonActive;
        private boolean tickTimer1Active;
        private boolean tickTimer2Active;
        private boolean tickTimer3Active;
        private boolean tickTimer4Active;
        private boolean tickTimer5Active;

        private STATE(boolean marcheButtonActive, boolean arretButtonActive, boolean panneButtonActive, boolean tickTimer1Active, boolean tickTimer2Active, boolean tickTimer3Active, boolean tickTimer4Active, boolean tickTimer5Active) {
            this.marcheButtonActive = marcheButtonActive;
            this.arretButtonActive = arretButtonActive;
            this.panneButtonActive = panneButtonActive;
            this.tickTimer1Active = tickTimer1Active;
            this.tickTimer2Active = tickTimer2Active;
            this.tickTimer3Active = tickTimer3Active;
            this.tickTimer4Active = tickTimer4Active;
            this.tickTimer5Active = tickTimer5Active;
        }

        public boolean isMarcheButtonActive() {
            return marcheButtonActive;
        }

        public boolean isArretButtonActive() {
            return arretButtonActive;
        }

        public boolean isPanneButtonActive() {
            return panneButtonActive;
        }

        public boolean isTickTimer1Active() {
            return tickTimer1Active;
        }

        public boolean isTickTimer2Active() {
            return tickTimer2Active;
        }

        public boolean isTickTimer3Active() {
            return tickTimer3Active;
        }

        public boolean isTickTimer4Active() {
            return tickTimer4Active;
        }

        public boolean isTickTimer5Active() {
            return tickTimer5Active;
        }
        
    }
    
    private STATE etat;
    private Timer timer1;
    private Timer timer2;
    private Timer timer3;
    private Timer timer4;
    private Timer timer5;
    
    /**
     * Creates new form FeuTricolor
     */
    public FeuTricolor() {
        initComponents();
        initAmpoules();
        timerInit();
        initState();
        updateStatement();
    }
    
    private void initAmpoules(){
        redAmpoule.setColor(Color.red);
        orangeAmpoule.setColor(Color.orange);
        greenAmpoule.setColor(Color.green);
    }
    
    private void turnOffAmpoules(){
        redAmpoule.turnOFF();
        orangeAmpoule.turnOFF();
        greenAmpoule.turnOFF();
    }
    
    private void initState(){
        this.etat=STATE.E0;
    }
    
    private void updateStatement(){
        marcheButton.setEnabled(this.etat.isMarcheButtonActive());
        panneButton.setEnabled(this.etat.isPanneButtonActive());
        arretButton.setEnabled(this.etat.isArretButtonActive());
        if(this.etat.isTickTimer1Active()){
            timer1.start();
         }else{
            timer1.stop();
         }
        
        if(this.etat.isTickTimer2Active()){
            timer2.start();
         }else{
            timer2.stop();
         }
        
        if(this.etat.isTickTimer3Active()){
            timer3.start();
         }else{
            timer3.stop();
         }
        
        if(this.etat.isTickTimer4Active()){
            timer4.start();
         }else{
            timer4.stop();
         }
        
        if(this.etat.isTickTimer5Active()){
            timer5.start();
         }else{
            timer5.stop();
         }
    }
    
   
    
     private void timerInit(){
        timer1 = new Timer(2000, new ActionListener() { // 1000 ms = 1 seconde
            @Override
            public void actionPerformed(ActionEvent e) {
                   tickTimer1ActionPerformed(e);
            }
        });
        
        timer2 = new Timer(3000, new ActionListener() { // 1000 ms = 1 seconde
            @Override
            public void actionPerformed(ActionEvent e) {
                   tickTimer2ActionPerformed(e);
            }
        });
        
        timer3 = new Timer(1500, new ActionListener() { // 1000 ms = 1 seconde
            @Override
            public void actionPerformed(ActionEvent e) {
                   tickTimer3ActionPerformed(e);
            }
        });
        
        timer4 = new Timer(500, new ActionListener() { // 1000 ms = 1 seconde
            @Override
            public void actionPerformed(ActionEvent e) {
                   tickTimer4ActionPerformed(e);
            }
        });
        
        timer5 = new Timer(500, new ActionListener() { // 1000 ms = 1 seconde
            @Override
            public void actionPerformed(ActionEvent e) {
                   tickTimer5ActionPerformed(e);
            }
        });
    }
    
     private void tickTimer1ActionPerformed(ActionEvent e){
     turnOffAmpoules();
     greenAmpoule.turnON();
     etat=STATE.E2;
     updateStatement();
    }
     
     private void tickTimer2ActionPerformed(ActionEvent e){
     turnOffAmpoules();
     orangeAmpoule.turnON();
     etat=STATE.E3;
     updateStatement();
    }
     private void tickTimer3ActionPerformed(ActionEvent e){
     turnOffAmpoules();
     redAmpoule.turnON(); 
     etat=STATE.E1;
     updateStatement();

    }
     private void tickTimer4ActionPerformed(ActionEvent e){
     turnOffAmpoules();
     orangeAmpoule.turnON();
     etat=STATE.E4;
     updateStatement();
    }
     private void tickTimer5ActionPerformed(ActionEvent e){
     turnOffAmpoules();
     etat=STATE.E5;
     updateStatement();
    }
     
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        marcheButton = new javax.swing.JButton();
        arretButton = new javax.swing.JButton();
        panneButton = new javax.swing.JButton();
        redAmpoule = new tp2.feutricolor.Ampoule();
        orangeAmpoule = new tp2.feutricolor.Ampoule();
        greenAmpoule = new tp2.feutricolor.Ampoule();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Feu Tricolor");

        marcheButton.setText("Marche");
        marcheButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                marcheButtonActionPerformed(evt);
            }
        });

        arretButton.setText("Arrêt");
        arretButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                arretButtonActionPerformed(evt);
            }
        });

        panneButton.setText("Panne");
        panneButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                panneButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout redAmpouleLayout = new javax.swing.GroupLayout(redAmpoule);
        redAmpoule.setLayout(redAmpouleLayout);
        redAmpouleLayout.setHorizontalGroup(
            redAmpouleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        redAmpouleLayout.setVerticalGroup(
            redAmpouleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout orangeAmpouleLayout = new javax.swing.GroupLayout(orangeAmpoule);
        orangeAmpoule.setLayout(orangeAmpouleLayout);
        orangeAmpouleLayout.setHorizontalGroup(
            orangeAmpouleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        orangeAmpouleLayout.setVerticalGroup(
            orangeAmpouleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout greenAmpouleLayout = new javax.swing.GroupLayout(greenAmpoule);
        greenAmpoule.setLayout(greenAmpouleLayout);
        greenAmpouleLayout.setHorizontalGroup(
            greenAmpouleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        greenAmpouleLayout.setVerticalGroup(
            greenAmpouleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(greenAmpoule, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(redAmpoule, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(orangeAmpoule, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(arretButton, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(marcheButton, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panneButton, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(48, 48, 48))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(marcheButton)
                        .addGap(26, 26, 26)
                        .addComponent(arretButton))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(redAmpoule, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(panneButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                        .addComponent(orangeAmpoule, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(greenAmpoule, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void marcheButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_marcheButtonActionPerformed
        switch(etat){
            case E0 -> {
                this.etat = FeuTricolor.STATE.E1;
                turnOffAmpoules();
                redAmpoule.turnON();
                updateStatement();  

            }
            case E2 -> {
                throw new IllegalStateException("Button pressed on wrong state" );
            }
            case E3 -> {
                throw new IllegalStateException("Button pressed on wrong state" );
            }
             case E4 -> {
               this.etat = FeuTricolor.STATE.E1;
                turnOffAmpoules();
                redAmpoule.turnON();
                updateStatement();  
            }
              case E5 -> {
               this.etat = FeuTricolor.STATE.E1;
                turnOffAmpoules();
                redAmpoule.turnON();
                updateStatement();  
            }
        }
    }//GEN-LAST:event_marcheButtonActionPerformed

    private void arretButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_arretButtonActionPerformed
         switch(etat){
            case E0 -> {
               throw new IllegalStateException("Button pressed on wrong state" );
            }
            case E1 -> {
                this.etat = FeuTricolor.STATE.E0;
                turnOffAmpoules();
                updateStatement();  
            }
            case E2 -> {
                this.etat = FeuTricolor.STATE.E0;
                turnOffAmpoules();
                updateStatement();  
            }
            case E3 -> {
                this.etat = FeuTricolor.STATE.E0;
                turnOffAmpoules();
               updateStatement();  
            }
            case E4 -> {
                this.etat = FeuTricolor.STATE.E0;
                turnOffAmpoules();
               updateStatement();  
            }
            case E5 -> {
                this.etat = FeuTricolor.STATE.E0;
                turnOffAmpoules();
                updateStatement();  
            }
        }
    }//GEN-LAST:event_arretButtonActionPerformed

    private void panneButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_panneButtonActionPerformed
         switch(etat){
            case E0 -> {
               throw new IllegalStateException("Button pressed on wrong state" );
            }
            case E1 -> {
                this.etat = FeuTricolor.STATE.E4;
                turnOffAmpoules();
                orangeAmpoule.turnON();
                updateStatement();  
            }
            case E2 -> {
               this.etat = FeuTricolor.STATE.E4;
                turnOffAmpoules();
                orangeAmpoule.turnON();
                updateStatement();
            }
            case E3 -> {
                this.etat = FeuTricolor.STATE.E4;
                turnOffAmpoules();
                orangeAmpoule.turnON();
                updateStatement();
            }
             case E4 -> {
               throw new IllegalStateException("Button pressed on wrong state" );
            }
              case E5 -> {
               throw new IllegalStateException("Button pressed on wrong state" );
            }
        }
    }//GEN-LAST:event_panneButtonActionPerformed

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
            java.util.logging.Logger.getLogger(FeuTricolor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FeuTricolor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FeuTricolor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FeuTricolor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FeuTricolor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton arretButton;
    private tp2.feutricolor.Ampoule greenAmpoule;
    private javax.swing.JButton marcheButton;
    private tp2.feutricolor.Ampoule orangeAmpoule;
    private javax.swing.JButton panneButton;
    private tp2.feutricolor.Ampoule redAmpoule;
    // End of variables declaration//GEN-END:variables
}
