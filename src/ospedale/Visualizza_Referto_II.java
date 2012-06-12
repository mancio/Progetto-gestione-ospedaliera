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
public class Visualizza_Referto_II extends JFrame {
    private Database db=new Database("ospedale","root","lilli");
    
    public Visualizza_Referto_II(String idPrenot,boolean editabile){
      Container container = getContentPane();
        JTextArea foglio=new JTextArea();
    foglio.setEditable(editabile);
    JButton stampa=new JButton("STAMPA");
    JButton salva=new JButton("SALVA");
    JButton chiudi=new JButton("CHIUDI");
    JLabel titolo=new JLabel("REFERTO");
    
    this.setTitle("REFERTO n° "+ idPrenot);
    JPanel inputPanel1=new JPanel();
    inputPanel1.add(titolo);
    JPanel inputPanel2=new JPanel();
    inputPanel2.add(stampa);
    inputPanel2.add(salva);
    inputPanel2.add(chiudi);
    container.add(inputPanel1,BorderLayout.NORTH);
    container.add(new JScrollPane(foglio),BorderLayout.CENTER);
    container.add(inputPanel2,BorderLayout.SOUTH);
    String testo=null;
    String SQL="select referto from referti where idprenotazione='"+idPrenot+"';";
    
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
        
    }else if (testo!= null && editabile==true){
        
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
    
    }
    
    private void chiudiActionPerformed(java.awt.event.ActionEvent evt) {                                              
        
        this.setVisible(false);
    }

   
}
