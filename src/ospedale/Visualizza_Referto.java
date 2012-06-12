/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ospedale;

import java.awt.BorderLayout;
import java.awt.Container;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;

/**
 *
 * @author alex
 */
public class Visualizza_Referto extends JFrame {
    private Database db=new Database("ospedale","root","lilli");
    private String testo;
    private JTextArea foglio;
    private String id;
    public Visualizza_Referto(String idPrenot,boolean editabile){
      id=idPrenot;
        Container container = getContentPane();
    foglio=new JTextArea();
    foglio.setEditable(editabile);
    JButton stampa=new JButton("STAMPA");
    JButton salva=new JButton("SALVA");
    JButton chiudi=new JButton("CHIUDI");
    JLabel titolo=new JLabel("REFERTO");
    
    this.setTitle("REFERTO n° "+ id);
    JPanel inputPanel1=new JPanel();
    inputPanel1.add(titolo);
    JPanel inputPanel2=new JPanel();
    inputPanel2.add(stampa);
    inputPanel2.add(salva);
    inputPanel2.add(chiudi);
    container.add(inputPanel1,BorderLayout.NORTH);
    container.add(new JScrollPane(foglio),BorderLayout.CENTER);
    container.add(inputPanel2,BorderLayout.SOUTH);
    testo=null;
    String SQL="select referto from referti where idprenotazione='"+id+"';";
    
    try{
            db.connetti();
            ResultSet r=db.eseguiQuery(SQL);
            while(r.next()){
                testo=r.getString("referto");
                System.out.println(testo);
            }
            
        } catch(SQLException e){e.getMessage();}
    if (testo==null && editabile==false){
        foglio.setText("Referto non ancora inserito");
        stampa.setEnabled(false);
        salva.setEnabled(false);
    }else if (testo!=null && editabile==false){
        foglio.setText(testo);
        stampa.setEnabled(true);
        salva.setEnabled(false);
    }
    
    if (testo==null && editabile==true){
        stampa.setEnabled(false);
    }else if (testo!= null && editabile==true){
        foglio.setText(testo);
    }
    
    setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(850, 530);
        setVisible(true);
        setResizable(false);
        
        
        chiudi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chiudiActionPerformed(evt);
            }
        });
        
        salva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvaActionPerformed(evt);
            }
        });
        
        stampa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stampaActionPerformed(evt);
            }
        });
    
    }
    
    private void chiudiActionPerformed(java.awt.event.ActionEvent evt) {                                                     
        this.setVisible(false);
    }
    
    private void salvaActionPerformed(java.awt.event.ActionEvent evt) {                                                     
        System.out.println(foglio.getText());
        if(foglio.getText()!=null && foglio.getText().isEmpty()==false){
            String SQL="update referti set referto='"+foglio.getText()+"' where idprenotazione='"+id+"';";
            db.eseguiAggiornamento(SQL);
            System.out.println("aggiornato");
            
        }else {System.out.println("ricon vuoto, settato a null campo db");
            String SQL="update referti set referto=null where idprenotazione='"+id+"';";
            db.eseguiAggiornamento(SQL);
        }
    }
    
    private void stampaActionPerformed(java.awt.event.ActionEvent evt) {                                                     
        
    }

   
}
