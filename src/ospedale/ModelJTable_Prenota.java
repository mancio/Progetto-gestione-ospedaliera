/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ospedale;

import com.mysql.jdbc.Connection;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author alex
 */
public class ModelJTable_Prenota extends JFrame{
    private DefaultTableModel model;
    private Database db=new Database("ospedale","root","lilli");;
  private JTable table;
  private String reparto,data_table,ora_table,SQL;
  private Paziente paz;
  JRadioButton priorita;
  
  
  public ModelJTable_Prenota(){
      
  }

  public ModelJTable_Prenota(String rep,Paziente p) {
    super();
    data_table=null;
    ora_table=null;
    reparto=rep;
    paz=p;
    model = new DefaultTableModel();
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
    
    /*JButton addButton = new JButton("Add Philosopher");
    addButton.addActionListener(new ActionListener() {

      public void actionPerformed(ActionEvent event) {
        String[] philosopher = { "", ""};
        model.addRow(philosopher);
      }
    });

    JButton removeButton = new JButton("Remove Selected Philosopher");

    removeButton.addActionListener(new ActionListener() {

      public void actionPerformed(ActionEvent event) {
        model.removeRow(table.getSelectedRow());
      }
    });*/
    JLabel informazioni=new JLabel("DATE DISPONIBILLI");
    JButton esci=new JButton("ESCI");
    JLabel spazio1 =new JLabel("     ");
    JLabel spazio2 =new JLabel("     ");
    JButton conferma=new JButton("CONFERMA");
    JButton indietro=new JButton("INDIETRO");
    priorita=new JRadioButton("Richiedi Priorità");
    
    JPanel inputPanel = new JPanel();
    JPanel inputPanel2 =new JPanel();
    inputPanel.add(esci);
    inputPanel.add(spazio1);
    inputPanel.add(priorita);
    inputPanel.add(spazio2);
    inputPanel.add(indietro);
    inputPanel.add(conferma);
    inputPanel2.add(informazioni);
    Container container = getContentPane();
  
   
    container.add(new JScrollPane(table), BorderLayout.CENTER);
    container.add(inputPanel2,BorderLayout.NORTH);
    container.add(inputPanel, BorderLayout.AFTER_LAST_LINE);

    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setSize(500, 400);
    setVisible(true);
    
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
   
    table.addMouseListener(new MouseAdapter() {
     public void mouseClicked(MouseEvent me) {
       data_table = (String) table.getValueAt(table.getSelectedRow(), 0);
       ora_table = (String) table.getValueAt(table.getSelectedRow(), 1);
       if((data_table.length() != 0) && (ora_table.length() != 0)) {
           JOptionPane.showMessageDialog(null,"Contenuto riga selezionata: "+data_table+" "+ora_table);
        
           
       }
     }
   });
  }
  
  private void popolaTable(){
      SQL="select data,ora from visite where reparto='"+reparto+"' and priorita='0' order by data,ora asc;";
           model.setRowCount(0); //svuota la tabella
        try {
            db.connetti();
            ResultSet rs = db.eseguiQuery(SQL);            
            while(rs.next()){             
                       System.out.println(rs.getString(1)+"  -  "+rs.getString(2));
                       String[] stringa={rs.getString(1),rs.getString(2)};
                       model.addRow(stringa);  
                       
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
      paz.setVisible(true);
      this.setVisible(false);
  }
  
   private void confermaActionPerformed(java.awt.event.ActionEvent evt){
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
          popolaTable();
          data_table=null;
          ora_table=null;
          db.disconnetti();
          
      }
  }
  

  public static void main(String args[]) {
    //new ModelJTable_Prenota();
  }
}
