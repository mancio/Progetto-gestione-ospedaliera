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
    private Database db;
  private JTable table;
  private String reparto;
  private JLabel jLabel1;
  public ModelJTable_Prenota(){
      
  }

  public ModelJTable_Prenota(String rep) {
    super();
    reparto=rep;
    model = new DefaultTableModel();
    model.addColumn("GIORNO");
    model.addColumn("ORARIO");

    
           
        String SQL="select data,ora from visite where reparto='"+reparto+"' and priorita='0' order by data,ora asc;";       
        try {
            /*Class.forName("com.mysql.jdbc.Driver");
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/ospedale?user=root&password=lilli");

            Statement stmt = conn.createStatement(); // Creo lo Statement per l'esecuzione della query
            */
            db=new Database("ospedale","root","lilli");
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
    JRadioButton priorita=new JRadioButton("Richiedi Priorità");
    
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
   
    table.addMouseListener(new MouseAdapter() {
     public void mouseClicked(MouseEvent me) {
       String col1 = (String) table.getValueAt(table.getSelectedRow(), 0);
       String col2 = (String) table.getValueAt(table.getSelectedRow(), 1);
       if((col1.length() != 0) && (col2.length() != 0)) {
           JOptionPane.showMessageDialog(null,"Contenuto riga selezionata: "+col1+" "+col2);
        
           //jLabel1.setText("hai selezionato: "+col1+" -- "+col2);
       }
     }
   });
  }
 
  
  public static void main(String args[]) {
    //new ModelJTable_Prenota();
  }
}
