/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ospedale;

import java.sql.ResultSet;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;

/**
 *
 * @author mancio
 */
public class Amministratore extends javax.swing.JFrame {
    private String codice,pass,amministratore,email,telef,resid;
    private int is_admin;
    Database db;
    ResultSet rs;
    /**
     * Creates new form Amministratore
     */
    public Amministratore() {
        initComponents();
    }
    
    public Amministratore(String Cod_Fisc,String passw,String nome,String mail,String tel,String res,int adm){
        initComponents();
        codice=Cod_Fisc;
        pass=passw;
        amministratore=nome;
        email=mail;
        telef=tel;
        resid=res;
        is_admin=adm;
        jLabel4.setText(nome);
        
        ButtonGroup bg1=new ButtonGroup();
        bg1.add(aggiornaVisite);
        bg1.add(aggiornaPrenotazioniReferti);
        bg1.add(visualizzaPrenotazioniReferti);
        ButtonGroup bg2=new ButtonGroup();
        bg2.add(visualizzaReparto);
        bg2.add(visualizzaPaziente);
        bg2.add(visualizzaIDPrenotazione);
        bg2.add(visualizzaTutte);
        disabilitaSelezione();
        getPazienti();
        getPrenotazioni();
    }
    
    public void getPrenotazioni(){
        try{
        db=new Database("ospedale","root","lilli");
        rs=db.eseguiQuery("select idprenotazione from prenotazioni order by idprenotazione asc;");
        jComboID.addItem("..selezionare una prenotazione..");
        
            while(rs.next()){
                jComboID.addItem(rs.getString("idprenotazione"));
            }
        }catch (Exception e) { System.out.println(e.getMessage()); }

    }
    
    public void getPazienti(){
        try{
        db=new Database("ospedale","root","lilli");
        rs=db.eseguiQuery("select cod_fisc from utenti where is_admin='0' order by cod_fisc asc;");
        jComboPaziente.addItem("..selezionare un paziente..");
        
            while(rs.next()){
                jComboPaziente.addItem(rs.getString("cod_fisc"));
            }
        }catch (Exception e) { System.out.println(e.getMessage()); }

    }
 
    public String getAmministratore(){ return amministratore;}

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
        aggiornaVisite = new javax.swing.JRadioButton();
        aggiornaPrenotazioniReferti = new javax.swing.JRadioButton();
        visualizzaPrenotazioniReferti = new javax.swing.JRadioButton();
        conferma = new javax.swing.JButton();
        esci = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        visualizzaReparto = new javax.swing.JRadioButton();
        visualizzaPaziente = new javax.swing.JRadioButton();
        visualizzaIDPrenotazione = new javax.swing.JRadioButton();
        visualizzaTutte = new javax.swing.JRadioButton();
        jComboReparto = new javax.swing.JComboBox();
        jComboPaziente = new javax.swing.JComboBox();
        jComboID = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ospedale/logo.jpeg"))); // NOI18N

        jLabel2.setText("GESTISCI SISTEMA");

        aggiornaVisite.setText("Aggiorna lista visite");
        aggiornaVisite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aggiornaVisiteActionPerformed(evt);
            }
        });

        aggiornaPrenotazioniReferti.setText("Aggiorna lista prenotazioni");
        aggiornaPrenotazioniReferti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aggiornaPrenotazioniRefertiActionPerformed(evt);
            }
        });

        visualizzaPrenotazioniReferti.setText("Visualizza storico prenotazioni e referti");
        visualizzaPrenotazioniReferti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                visualizzaPrenotazioniRefertiActionPerformed(evt);
            }
        });

        conferma.setText("CONFERMA");
        conferma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confermaActionPerformed(evt);
            }
        });

        esci.setText("ESCI");
        esci.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                esciActionPerformed(evt);
            }
        });

        jLabel3.setText("Benvenuto:");

        visualizzaReparto.setText("per reparto");
        visualizzaReparto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                visualizzaRepartoActionPerformed(evt);
            }
        });

        visualizzaPaziente.setText("per paziente");
        visualizzaPaziente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                visualizzaPazienteActionPerformed(evt);
            }
        });

        visualizzaIDPrenotazione.setText("per ID");
        visualizzaIDPrenotazione.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                visualizzaIDPrenotazioneActionPerformed(evt);
            }
        });

        visualizzaTutte.setText("tutte");
        visualizzaTutte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                visualizzaTutteActionPerformed(evt);
            }
        });

        jComboReparto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "..selezionare un reparto..", "ortopedia", "pediatria" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(esci))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(118, 118, 118)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(aggiornaPrenotazioniReferti)
                                    .addComponent(aggiornaVisite)
                                    .addComponent(visualizzaPrenotazioniReferti)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(21, 21, 21)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(visualizzaReparto)
                                            .addComponent(visualizzaPaziente)
                                            .addComponent(visualizzaIDPrenotazione)
                                            .addComponent(visualizzaTutte))
                                        .addGap(31, 31, 31)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jComboID, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jComboPaziente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jComboReparto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))))
                    .addComponent(jLabel3)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 503, Short.MAX_VALUE)
                        .addComponent(conferma)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(31, 31, 31)
                        .addComponent(aggiornaVisite)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(aggiornaPrenotazioniReferti)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(visualizzaPrenotazioniReferti)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(visualizzaReparto)
                            .addComponent(jComboReparto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(4, 6, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(visualizzaPaziente)
                            .addComponent(jComboPaziente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(visualizzaIDPrenotazione)
                            .addComponent(jComboID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(visualizzaTutte)
                        .addGap(6, 6, 6)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(0, 75, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 50, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(conferma)
                            .addComponent(esci))))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void disabilitaSelezione(){
        visualizzaReparto.setEnabled(false);
        visualizzaPaziente.setEnabled(false);
        visualizzaIDPrenotazione.setEnabled(false);
        visualizzaTutte.setEnabled(false);
        jComboReparto.setEnabled(false);
        jComboPaziente.setEnabled(false);
        jComboID.setEnabled(false);
    }
    
    private void abilitaSelezione(){
        visualizzaReparto.setEnabled(true);
        visualizzaPaziente.setEnabled(true);
        visualizzaIDPrenotazione.setEnabled(true);
        visualizzaTutte.setEnabled(true);
        jComboReparto.setEnabled(true);
        jComboPaziente.setEnabled(true);
        jComboID.setEnabled(true);
    }
     
    private void confermaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confermaActionPerformed
        // TODO add your handling code here:
        if(visualizzaPrenotazioniReferti.isSelected() && visualizzaTutte.isSelected()){  //visualizza tutte le prenotazioni
            ModelJTable m=new ModelJTable(this,1,null);
            this.setVisible(false);
        }
        
        if(visualizzaPrenotazioniReferti.isSelected() && jComboReparto.isEnabled() && jComboReparto.getSelectedIndex()!=0){
            ModelJTable m=new ModelJTable(this,2,(String)jComboReparto.getSelectedItem());
            this.setVisible(false);
        }
        
        if(visualizzaPrenotazioniReferti.isSelected() && jComboPaziente.isEnabled() && jComboPaziente.getSelectedIndex()!=0){
            ModelJTable m=new ModelJTable(this,3,(String)jComboPaziente.getSelectedItem());
            this.setVisible(false);
        }
        
        if(visualizzaPrenotazioniReferti.isSelected() && jComboID.isEnabled() && jComboID.getSelectedIndex()!=0){
            ModelJTable m=new ModelJTable(this,4,(String)jComboID.getSelectedItem());
            this.setVisible(false);
        }
       
        if(aggiornaVisite.isSelected()){
            ModelJTable m=new ModelJTable(this);
            this.setVisible(false);
        }
        
        if (aggiornaPrenotazioniReferti.isSelected()){
            ModelJTable m=new ModelJTable(this,5);
            this.setVisible(false);
        }
    }//GEN-LAST:event_confermaActionPerformed

    private void aggiornaVisiteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aggiornaVisiteActionPerformed
        disabilitaSelezione();
        jComboReparto.setSelectedIndex(0);
        jComboPaziente.setSelectedIndex(0);
        jComboID.setSelectedIndex(0);
    }//GEN-LAST:event_aggiornaVisiteActionPerformed

    private void aggiornaPrenotazioniRefertiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aggiornaPrenotazioniRefertiActionPerformed
        // TODO add your handling code here:
       disabilitaSelezione();
       jComboReparto.setSelectedIndex(0);
        jComboPaziente.setSelectedIndex(0);
        jComboID.setSelectedIndex(0);
    }//GEN-LAST:event_aggiornaPrenotazioniRefertiActionPerformed
    
        private void visualizzaPrenotazioniRefertiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_visualizzaPrenotazioniRefertiActionPerformed
        // TODO add your handling code here:
            abilitaSelezione();
            jComboReparto.setSelectedIndex(0);
        jComboPaziente.setSelectedIndex(0);
        jComboID.setSelectedIndex(0);
    }//GEN-LAST:event_visualizzaPrenotazioniRefertiActionPerformed

    private void esciActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_esciActionPerformed
        // TODO add your handling code here:
        
        Login l=new Login();
        l.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_esciActionPerformed

    private void visualizzaRepartoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_visualizzaRepartoActionPerformed
        // TODO add your handling code here:
    
        jComboPaziente.setSelectedIndex(0);
        jComboID.setSelectedIndex(0);
    }//GEN-LAST:event_visualizzaRepartoActionPerformed

    private void visualizzaPazienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_visualizzaPazienteActionPerformed
        // TODO add your handling code here:
    
        jComboReparto.setSelectedIndex(0);
         jComboID.setSelectedIndex(0);
    }//GEN-LAST:event_visualizzaPazienteActionPerformed

    private void visualizzaIDPrenotazioneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_visualizzaIDPrenotazioneActionPerformed
        // TODO add your handling code here:
    
        jComboReparto.setSelectedIndex(0);
        jComboPaziente.setSelectedIndex(0);
    }//GEN-LAST:event_visualizzaIDPrenotazioneActionPerformed

    private void visualizzaTutteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_visualizzaTutteActionPerformed
        // TODO add your handling code here:
   
        jComboReparto.setSelectedIndex(0);
        jComboPaziente.setSelectedIndex(0);
        jComboID.setSelectedIndex(0);
    }//GEN-LAST:event_visualizzaTutteActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Amministratore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Amministratore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Amministratore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Amministratore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
               // new Amministratore().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton aggiornaPrenotazioniReferti;
    private javax.swing.JRadioButton aggiornaVisite;
    private javax.swing.JButton conferma;
    private javax.swing.JButton esci;
    private javax.swing.JComboBox jComboID;
    private javax.swing.JComboBox jComboPaziente;
    private javax.swing.JComboBox jComboReparto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JRadioButton visualizzaIDPrenotazione;
    private javax.swing.JRadioButton visualizzaPaziente;
    private javax.swing.JRadioButton visualizzaPrenotazioniReferti;
    private javax.swing.JRadioButton visualizzaReparto;
    private javax.swing.JRadioButton visualizzaTutte;
    // End of variables declaration//GEN-END:variables
}
