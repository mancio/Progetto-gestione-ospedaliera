/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ospedale;

import javax.swing.JOptionPane;
  
/**
 *
 * @author mancio
 */
public class Paziente extends javax.swing.JFrame {
    private String codice,pass,paziente,email,telef,resid;
    private int is_admin;
    /**
     * Creates new form Reparto
     */
    public Paziente() {
        initComponents();
        
    }
    public Paziente(String Cod_Fisc,String passw,String nome,String mail,String tel,String res,int adm){
        initComponents();
        codice=Cod_Fisc;
        pass=passw;
        paziente=nome;;
        email=mail;
        telef=tel;
        resid=res;
        is_admin=adm;
        jLabel4.setText(paziente);
    }
   public String getCod_Fisc(){return codice;}
   public String getPaziente(){ return paziente;}
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        label1 = new java.awt.Label();
        jRadioButtonPrenota = new javax.swing.JRadioButton();
        jComboBoxReparti = new javax.swing.JComboBox();
        jRadioButtonStorico = new javax.swing.JRadioButton();
        jButtonConferma = new javax.swing.JButton();
        jButtonEsci = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ospedale/logo.jpeg"))); // NOI18N

        label1.setAlignment(java.awt.Label.CENTER);
        label1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        label1.setText("SCEGLI COSA FARE:");

        jRadioButtonPrenota.setText("Effettua Prenotazione");
        jRadioButtonPrenota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonPrenotaActionPerformed(evt);
            }
        });

        jComboBoxReparti.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Scegliere un reparto...", "Ortopedia", "Pediatria" }));
        jComboBoxReparti.setEnabled(false);

        jRadioButtonStorico.setText("Visualizza Storico Prenotazioni");
        jRadioButtonStorico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonStoricoActionPerformed(evt);
            }
        });

        jButtonConferma.setText("CONFERMA");
        jButtonConferma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConfermaActionPerformed(evt);
            }
        });

        jButtonEsci.setText("ESCI");
        jButtonEsci.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEsciActionPerformed(evt);
            }
        });

        jLabel2.setText("Benvenuto:");

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
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButtonEsci, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButtonConferma))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jComboBoxReparti, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jRadioButtonPrenota)
                                        .addComponent(jRadioButtonStorico)))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButtonPrenota)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBoxReparti, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jRadioButtonStorico))
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 15, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonConferma)
                            .addComponent(jButtonEsci))
                        .addGap(22, 22, 22))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButtonPrenotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonPrenotaActionPerformed
        // TODO add your handling code here:
      jComboBoxReparti.setEnabled(true);
      jRadioButtonStorico.setSelected(false);
      if ((jRadioButtonStorico.isSelected()==false) && (jRadioButtonPrenota.isSelected()==false)){
          jComboBoxReparti.setEnabled(false);
          jComboBoxReparti.setSelectedIndex(0);
            jRadioButtonStorico.setSelected(false);
      }
      
    }//GEN-LAST:event_jRadioButtonPrenotaActionPerformed

    private void jRadioButtonStoricoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonStoricoActionPerformed
        // TODO add your handling code here:
        jComboBoxReparti.setEnabled(false);
        jRadioButtonPrenota.setSelected(false);
        jComboBoxReparti.setSelectedIndex(0);
    }//GEN-LAST:event_jRadioButtonStoricoActionPerformed

    private void jButtonConfermaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConfermaActionPerformed
        // TODO add your handling code here:
        if ((jRadioButtonStorico.isSelected()==false) && (jRadioButtonPrenota.isSelected()==false)){
            JOptionPane.showMessageDialog(null,"Effettuare una scelta","Error",JOptionPane.ERROR_MESSAGE);
        }
        else if ((jComboBoxReparti.getSelectedIndex()==0) && jComboBoxReparti.isEnabled()){
            JOptionPane.showMessageDialog(null,"Scegliere il reparto in cui effetuare la prenotazioine","Error",JOptionPane.ERROR_MESSAGE);
            
        }
        if (jRadioButtonPrenota.isSelected() && jComboBoxReparti.getSelectedIndex() != 0){
                if(jComboBoxReparti.getSelectedIndex()==1){
                    ModelJTable p=new ModelJTable("ortopedia",this);
                    this.setVisible(false);
                }else{
                    ModelJTable p=new ModelJTable("pediatria",this);
                    this.setVisible(false);
                }
        }
        if (jRadioButtonPrenota.isSelected()==false && jRadioButtonStorico.isSelected()){
            ModelJTable s=new ModelJTable(this);          
            this.setVisible(false);
        }
    }//GEN-LAST:event_jButtonConfermaActionPerformed

    private void jButtonEsciActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEsciActionPerformed
        // TODO add your handling code here:
        Login l=new Login();
        l.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButtonEsciActionPerformed
    
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
            java.util.logging.Logger.getLogger(Paziente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Paziente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Paziente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Paziente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
               // new Paziente().setVisible(true);
            }
        });
        
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButtonConferma;
    private javax.swing.JButton jButtonEsci;
    private javax.swing.JComboBox jComboBoxReparti;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JRadioButton jRadioButtonPrenota;
    private javax.swing.JRadioButton jRadioButtonStorico;
    private java.awt.Label label1;
    // End of variables declaration//GEN-END:variables
}
