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
    String SQL;
    
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
        Container container = getContentPane();
        
        JLabel informazioni = new JLabel("ELENCO PRENOTAZIONI");
        JPanel inputPanel1 = new JPanel();
        inputPanel1.add(informazioni);
   container.add(inputPanel1,BorderLayout.NORTH);
    container.add(new JScrollPane(table), BorderLayout.CENTER);
    
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setSize(500, 400);
    setVisible(true);
    }
    
    private void popolaTable(){
      SQL="select idprenotazione,reparto,data,ora from prenotazioni where idpaziente='"+paz.getCod_Fisc()+"' order by idprenotazione asc;";
           model.setRowCount(0); //svuota la tabella
        try {
            db.connetti();
            ResultSet rs = db.eseguiQuery(SQL);            
            while(rs.next()){             
                       System.out.println(rs.getString(1)+"  -  "+rs.getString(2));
                       String[] stringa={rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)};
                       model.addRow(stringa);  
                       
            }
            rs.close(); 
            db.disconnetti();
        }catch(SQLException e){ System.out.println(e); }
  }
    
}
