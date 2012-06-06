/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ospedale;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author alex
 */
public class ModelJTable_Storico extends JFrame{
    private DefaultTableModel model;
    private Database db=new Database("ospedale","root","lilli");
    private JTable table;
    private Paziente paz;
    private String SQL;
    private String id_prenot=null;
    private ResultSet rs;
    
    
    public ModelJTable_Storico(Paziente p){
        paz=p;
        model = new DefaultTableModel();
        model.addColumn("ID PRENOTAZIONE");
        model.addColumn("REPARTO");
        model.addColumn("GIORNO");
        model.addColumn("ORARIO");
        
        popolaTable();
        
        table = new JTable(model){
        public boolean isCellEditable(int rowIndex, int colIndex) {
            return false; //Disallow the editing of any cell
        }
    };
        table.setColumnSelectionAllowed(false);
         table.setRowSelectionAllowed(true);
    
        Container container = getContentPane();
        
        JLabel informazioni = new JLabel("ELENCO PRENOTAZIONI");
        JLabel user=new JLabel(paz.getPaziente());
        JButton esci=new JButton("ESCI");
        JLabel spazio=new JLabel("          ");
        JButton indietro=new JButton("INDIETRO");
        JButton referto=new JButton("REFERTO");
        
        
        JPanel inputPanel1 = new JPanel();
        inputPanel1.add(informazioni);
        JPanel inputPanel2 =new JPanel();
        inputPanel2.add(user);
        inputPanel2.add(esci);
        inputPanel2.add(spazio);
        inputPanel2.add(indietro);
        inputPanel2.add(referto);
        
        container.add(inputPanel1,BorderLayout.NORTH);
    container.add(new JScrollPane(table), BorderLayout.CENTER);
    container.add(inputPanel2,BorderLayout.AFTER_LAST_LINE);
    
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setSize(500, 400);
    setVisible(true);
    
     table.addMouseListener(new MouseAdapter() {
     public void mouseClicked(MouseEvent me) {
       id_prenot = (String) table.getValueAt(table.getSelectedRow(), 0);
       if(id_prenot!=null) {
           JOptionPane.showMessageDialog(null,"Contenuto riga selezionata: "+id_prenot);
        
           
       }
     }
   });
    
    esci.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                esciActionPerformed(evt);
            }
        });
   indietro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                indietroActionPerformed(evt);
            }
        });
   referto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refertoActionPerformed(evt);
            }
        });
  
    }
    
    private void esciActionPerformed(java.awt.event.ActionEvent evt){
      this.setVisible(false);
      Login l=new Login();
      l.setVisible(true);
  }
  
  private void indietroActionPerformed(java.awt.event.ActionEvent evt){
      paz.setVisible(true);
      this.setVisible(false);
  }
  
  private void refertoActionPerformed(java.awt.event.ActionEvent evt){
      if (id_prenot==null){
           JOptionPane.showMessageDialog(null,"Effettua una scelta prima di proseguire");
      }else{
          try {
            db.connetti();
            SQL="select referto from referti where idprenotazione='"+id_prenot+"';";
            
            System.out.println(id_prenot);
            rs=db.eseguiQuery(SQL);
            while(rs.next()){
                //System.out.println(rs.getString("referto"));
                Visualizza_Referto vr= new Visualizza_Referto(rs.getString("referto"),false);
                vr.setVisible(true);
            }
            rs.close();
            db.disconnetti();
          }catch(SQLException e){ System.out.println(e); }
            
           }
  } 
    private void popolaTable(){
      SQL="select idprenotazione,reparto,data,ora from prenotazioni where idpaziente='"+paz.getCod_Fisc()+"' order by idprenotazione asc;";
           model.setRowCount(0); //svuota la tabella
        try {
            db.connetti();
            ResultSet rs = db.eseguiQuery(SQL);            
            while(rs.next()){             
                       System.out.println(rs.getString(1)+"  -  "+rs.getString(2)+"  -  "+rs.getString(3)+"  -  "+rs.getString(4));
                       String[] stringa={rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)};
                       model.addRow(stringa);  
                       
            }
            rs.close(); 
            db.disconnetti();
        }catch(SQLException e){ System.out.println(e); }
  }
    
}
