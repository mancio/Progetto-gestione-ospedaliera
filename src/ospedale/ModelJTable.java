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
public class ModelJTable extends JFrame{
    private String data_table,ora_table,id_prenot,reparto;
    private Paziente paz=null;
    private DefaultTableModel model;
    private Database db=new Database("ospedale","root","lilli");
    private JTable table;
    final int identificativo;
    private JRadioButton priorita;
    
    public ModelJTable(String rep,Paziente p){ ///effettuare prenotazioni (classe Paziente)
        super();
        identificativo=1;
    data_table=null;
    ora_table=null;
    reparto=rep;
    paz=p;
    model = new DefaultTableModel();
    model.addColumn("GIORNO");
    model.addColumn("ORARIO");
    
    popolaTable("select data,ora from visite where reparto='"+reparto+"' and priorita='0' order by data,ora asc;",model.getColumnCount());
    
    table = new JTable(model){
        public boolean isCellEditable(int rowIndex, int colIndex) {
            return false; //Disallow the editing of any cell
        }
    };
        generaGrafica("ELENCO DATE DISPONIBILI",paz.getPaziente(),identificativo);
    }
    
    
    public ModelJTable(Paziente p){         //visualizza storico prenotazioni (Paziente)
        identificativo=2;
        paz=p;
        model = new DefaultTableModel();
        model.addColumn("ID PRENOTAZIONE");
        model.addColumn("REPARTO");
        model.addColumn("GIORNO");
        model.addColumn("ORARIO");
        
       popolaTable("select idprenotazione,reparto,data,ora from prenotazioni where idpaziente='"+paz.getCod_Fisc()+"' order by idprenotazione asc;",model.getColumnCount());
        
        table = new JTable(model){
        public boolean isCellEditable(int rowIndex, int colIndex) {
            return false; //Disallow the editing of any cell
        }
    };
       generaGrafica("ELENCO PRENOTAZIONI",paz.getPaziente(),identificativo); 
    }
    
    
    private void generaGrafica(String titolo,String utente,final int identificativo){
        JLabel informazioni=new JLabel(titolo);
        JLabel user =new JLabel(utente);
        JButton esci=new JButton("ESCI");
        JButton indietro=new JButton("INDIETRO");
        priorita=new JRadioButton("Richiedi Priorità");
        JButton referto=new JButton("REFERTO");
        JButton conferma=new JButton("CONFERMA");
        
        table.setColumnSelectionAllowed(false);
        table.setRowSelectionAllowed(true);
    
        Container container = getContentPane();
        
        JPanel inputPanel1 = new JPanel();
        JPanel inputPanel2 = new JPanel();
        
        inputPanel1.add(informazioni);
        inputPanel2.add(user);
        inputPanel2.add(esci);
        inputPanel2.add(indietro);
        inputPanel2.add(priorita);
        inputPanel2.add(referto);
        inputPanel2.add(conferma);
        container.add(inputPanel1,BorderLayout.NORTH);
        container.add(new JScrollPane(table), BorderLayout.CENTER);
        container.add(inputPanel2,BorderLayout.AFTER_LAST_LINE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 500);
        setVisible(true);
        
        switch(identificativo){
            case 1:
            referto.setEnabled(false); break;
            case 2:
            priorita.setEnabled(false); break;
        
    }
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
   conferma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confermaActionPerformed(evt);
            }
        });
   
   referto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refertoActionPerformed(evt);
            }
        });
    table.addMouseListener(new MouseAdapter() {
         public void mouseClicked(MouseEvent me) {
            switch (identificativo){
                case 1:
                selezionaData(me); break;
                case 2:            
                selezionaPrenotazione(me); break;
            }
        }
    });
    }
    
    private void popolaTable(String query,int numColonne){
        String SQL=query;
        
        model.setRowCount(0); //svuota la tabella
        try {
            db.connetti();
            ResultSet rs = db.eseguiQuery(SQL);            
            while(rs.next()){    
                switch (numColonne){
                    case 2:
                    //System.out.println(rs.getString("data")+"  -  "+rs.getString("ora"));
                    String[] stringa2={rs.getString(1),rs.getString(2)};
                    model.addRow(stringa2);
                    break;
                    case 4:
                    String[] stringa4={rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)};
                    model.addRow(stringa4);
                        break;
                        
                }
            }
            rs.close(); 
            db.disconnetti();
        }catch(SQLException e){ System.out.println(e); }
    }
    
    private void esciActionPerformed(java.awt.event.ActionEvent evt){
      this.setVisible(false);
      Login l=new Login();
      l.setVisible(true);
  }
    
    private void indietroActionPerformed(java.awt.event.ActionEvent evt){
        switch(identificativo){
            case 1:
            case 2:        
                paz.setVisible(true);
                this.setVisible(false);
            break;
        }
  }
    
    private void refertoActionPerformed(java.awt.event.ActionEvent evt){
        String SQL=null;
        ResultSet rs;
        switch(identificativo){
            case 2:
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
            break;
        }
    }
    
    private void confermaActionPerformed(java.awt.event.ActionEvent evt){
        String SQL=null;
        switch (identificativo){
            case 1:
                if((data_table==null) && (ora_table==null)) {
                    JOptionPane.showMessageDialog(null,"Effettua una scelta prima di proseguire");
                }else{
                    db.connetti();
                    if (priorita.isSelected()){
                        SQL="insert into prenotazioni (reparto,data,ora,priorita,idpaziente) values ('"+reparto+"','"+data_table+"','"+ora_table+"','1','"+paz.getCod_Fisc()+"');";
                    }else { 
                        SQL="insert into prenotazioni (reparto,data,ora,priorita,idpaziente) values ('"+reparto+"','"+data_table+"','"+ora_table+"','0','"+paz.getCod_Fisc()+"');";
                    }
                    boolean ris=db.eseguiAggiornamento(SQL);
                    SQL="delete from visite where reparto='"+reparto+"' and data='"+data_table+"'and ora='"+ora_table+"';";
                    if (ris==true) System.out.println("ok");
                    ris=db.eseguiAggiornamento(SQL);
          
                    String codice=null;
                    try{ 
                        SQL="select idprenotazione from prenotazioni where reparto='"+reparto+"' and data='"+data_table+"' and ora='"+ora_table+"';";
                        ResultSet rs=db.eseguiQuery(SQL);
                        while(rs.next()){
                            codice=rs.getString("idprenotazione");
                        }
                        rs.close();
                    } catch(SQLException e){ System.out.println(e); }

                    SQL="insert into referti (idprenotazione,cod_fisc) values ('"+codice+"','"+paz.getCod_Fisc()+"');";
                    ris=db.eseguiAggiornamento(SQL);
         
                    popolaTable("select data,ora from visite where reparto='"+reparto+"' and priorita='0' order by data,ora asc;",model.getColumnCount());
                    data_table=null;
                    ora_table=null;
                    db.disconnetti();
                }
                break;
        }
    }
    
    private void selezionaData(MouseEvent me){
        data_table = (String) table.getValueAt(table.getSelectedRow(), 0);
       ora_table = (String) table.getValueAt(table.getSelectedRow(), 1);
       if((data_table.length() != 0) && (ora_table.length() != 0)) {
           JOptionPane.showMessageDialog(null,"Contenuto riga selezionata: "+data_table+" "+ora_table);
        }
    }
    
    private void selezionaPrenotazione(MouseEvent me){
        id_prenot = (String) table.getValueAt(table.getSelectedRow(), 0);
       if(id_prenot!=null) {
           JOptionPane.showMessageDialog(null,"Contenuto riga selezionata: "+id_prenot);
        
           
       }
     
    }
}
