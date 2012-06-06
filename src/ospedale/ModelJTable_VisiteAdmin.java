/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author claudio
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


public class ModelJTable_VisiteAdmin extends JFrame{
    private Database db=new Database("ospedale","root","lilli");
    JLabel info = new JLabel("AGGIORNA LE DATE DISPONIBILI");
    private DefaultTableModel model;
    private JTable table;
    private Amministratore admin;
}
