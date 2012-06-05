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
    private Connection conn;
  private JTable table;
  private String reparto;
  public ModelJTable_Prenota(){
      
  }

  public ModelJTable_Prenota(String rep) {
    super();
    reparto=rep;
    model = new DefaultTableModel();
    model.addColumn("GIORNO");
    model.addColumn("ORARIO");

    
    //String SQL="select data,ora from visite where reparto='ortopedia' and priorita='0' order by data,ora asc;";       
        String SQL="select data,ora from visite where reparto='"+reparto+"' and priorita='0' order by data,ora asc;";       
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/ospedale?user=root&password=lilli");

            Statement stmt = conn.createStatement(); // Creo lo Statement per l'esecuzione della query
            ResultSet rs = stmt.executeQuery(SQL);
            
            while(rs.next()){
                int i=0;
                       System.out.println(rs.getString(i+1)+"  -  "+rs.getString(i+2));
                       String[] stringa={rs.getString(i+1),rs.getString(i+2)};
                       model.addRow(stringa);
                
            }
            rs.close(); 
            stmt.close(); 
            conn.close();
        }catch(SQLException e){ System.out.println(e); } 
        catch (ClassNotFoundException e){ System.out.println(e); }
    /*String[] socrates = { "Socrates", "", "469-399 B.C." };
    model.addRow(socrates);

    String[] plato = { "Plato", "", "428-347 B.C." };
    model.addRow(plato);

    String[] aquinas = { "Thomas", "Aquinas", "1225-1274" };
    model.addRow(aquinas);

    String[] kierkegaard = { "Soren", "Kierkegaard", "1813-1855" };
    model.addRow(kierkegaard);

    String[] kant = { "Immanuel", "Kant", "1724-1804" };
    model.addRow(kant);

    String[] nietzsche = { "Friedrich", "Nietzsche", "1844-1900" };
    model.addRow(nietzsche);

    String[] arendt = { "Hannah", "Arendt", "1906-1975" };
    model.addRow(arendt); */

    table = new JTable(model);

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
    JPanel inputPanel = new JPanel();
    //inputPanel.add(addButton);
    //inputPanel.add(removeButton);

    Container container = getContentPane();
    container.add(new JScrollPane(table), BorderLayout.CENTER);
    //container.add(inputPanel, BorderLayout.NORTH);

    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setSize(400, 300);
    setVisible(true);
  } 
  public static void main(String args[]) {
    //new ModelJTable_Prenota();
  }
}
