/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ospedale;

/**
 *
 * @author alex
 */

/*
 * Classe dedicata alla gestione del Database.
 * Gestisce l'apertura e la chiusura della connessione col Database
 * Fornisce i metodi per l'esecuzione delle query sul Database
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

public class Database {
   private String nomeDB;       // Nome del Database a cui connettersi
   private String nomeUtente;   // Nome utente utilizzato per la connessione al Database
   private String pwdUtente;    // Password usata per la connessione al Database
   private String errore;       // Raccoglie informazioni riguardo l'ultima eccezione sollevata
   private Connection db;       // La connessione col Database
   private boolean connesso;    // Flag che indica se la connessione è attiva o meno

  

   public Database(String nomeDB, String nomeUtente, String pwdUtente) {
      this.nomeDB = nomeDB;
      this.nomeUtente = nomeUtente;
      this.pwdUtente = pwdUtente;
      connesso = false;
      errore = "";
   }

    // Apre la connessione con il Database
   public boolean connetti() {
      connesso = false;
      try {

         // Carico il driver JDBC per la connessione con il database MySQL
         Class.forName("com.mysql.jdbc.Driver");

         // Controllo che il nome del Database non sia nulla
         if (!nomeDB.equals("")) {

            // Controllo se il nome utente va usato o meno per la connessione
            if (nomeUtente.equals("")) {

               // La connessione non richiede nome utente e password
               db = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + nomeDB);
            } else {

               // La connessione richiede nome utente, controllo se necessita anche della password
               if (pwdUtente.equals("")) {

                  // La connessione non necessita di password
                  db = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + nomeDB + "?user=" + nomeUtente);
               } else {

                  // La connessione necessita della password
                  db = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + nomeDB + "?user=" + nomeUtente + "&password=" + pwdUtente);
               }
            }

            // La connessione è avvenuta con successo
            connesso = true;
         } else {
            System.out.println("Manca il nome del database!!");
            System.out.println("Scrivere il nome del database da utilizzare all'interno del file \"config.xml\"");
            System.exit(0);
         }
      } catch (Exception e) { errore = e.getMessage(); }
      return connesso;
   }
   // Esegue una query di selezione dati sul Database
   // query: una stringa che rappresenta un'istruzione SQL di tipo SELECT da eseguire
   // colonne: il numero di colonne di cui sarà composta la tupla del risultato
   // ritorna un Vector contenente tutte le tuple del risultato
   
   
   
   
   public String[] verificaUtente(String utente,String passw) {
      String[] dati=new String[7];
      // 
      boolean conn=false;
      try {
       connetti();     
                 
        com.mysql.jdbc.Statement stmt = (com.mysql.jdbc.Statement) db.createStatement();
            
            ResultSet rs;
            rs = stmt.executeQuery("SELECT * FROM utenti WHERE cod_fisc='"+utente+"'");
            while ( rs.next() ) {
                String password = rs.getString("password");
                System.out.println(password);
                if (password.equals(passw)){
                   conn=true;
                   dati[0]=rs.getString("cod_fisc");
                    dati[1]=rs.getString("password");
                    dati[2]=rs.getString("nome");
                    dati[3]=rs.getString("email");
                    dati[4]=rs.getString("telefono");
                    dati[5]=rs.getString("residenza");
                    dati[6]=Integer.toString(rs.getInt("is_admin"));
                    
                    System.out.println(dati[0]+"--"+dati[1]+"--"+dati[2]+"--"+dati[3]+"--"+dati[4]+"--"+dati[5]+"--"+dati[6]);
                    
                }
            }
            db.close();
                    System.out.println("db chiuso");
                
        } catch (Exception e) { System.out.println(e.getMessage()); }
      
      if (conn==true){
            return dati;
      }else return null;
  }
  public boolean addUtente(String CF,String passw,String nome, String mail, String tel,String res){
      connetti();
      boolean esistente=isUtente(CF);
      if(esistente==false){
      try {
            
                 
        com.mysql.jdbc.Statement stmt = (com.mysql.jdbc.Statement) db.createStatement();
        String SQL="INSERT INTO utenti(cod_fisc, nome, password, email, telefono, residenza, is_admin) VALUES('"+CF+"','"+nome+"','"+passw+"','"+mail+"','"+tel+"','"+res+"',0)"; 
        stmt.executeUpdate(SQL);
         
        } catch (Exception e) { System.out.println(e.getMessage()); }
      return true;  
      } else return false;
      
  }
   
  public boolean isUtente(String CF){
      System.out.println("immesso:"+CF);
      boolean esistente=false;
      String cod=null;
      try{
          connetti();
          com.mysql.jdbc.Statement stmt = (com.mysql.jdbc.Statement) db.createStatement();     
            
          ResultSet rs= stmt.executeQuery("select cod_fisc from utenti;");
          while(rs.next()){
              cod=rs.getString("cod_fisc");
              System.out.println(cod);
              if(cod.equals(CF)){
                  esistente=true;
              }
          }
         
      }catch (Exception e) { System.out.println(e.getMessage()); }
      System.out.println(esistente);
      return esistente;
  }
   
   public ResultSet eseguiQuery(String query) {
      ResultSet rs=null;
       Vector a1 = null;
      String [] record;
      int colonne = 0;
      try {
          connetti();
         Statement stmt = db.createStatement();     // Creo lo Statement per l'esecuzione della query
         rs = stmt.executeQuery(query);   // Ottengo il ResultSet dell'esecuzione della query
         /*a1 = new Vector();
         ResultSetMetaData rsmd = rs.getMetaData();
         colonne = rsmd.getColumnCount();
         while(rs.next()) {   // Creo il vettore risultato scorrendo tutto il ResultSet
            record = new String[colonne];
            for (int i=0; i<colonne; i++) record[i] = rs.getString(i+1);
            a1.add( (String[]) record.clone() );
         }
         rs.close();     // Chiudo il ResultSet
         stmt.close();   // Chiudo lo Statement */
      } catch (Exception e) { e.printStackTrace(); errore = e.getMessage(); }
      return rs;
   }

   // Esegue una query di aggiornamento sul Database
   // query: una stringa che rappresenta un'istuzione SQL di tipo UPDATE da eseguire
   // ritorna TRUE se l'esecuzione è adata a buon fine, FALSE se c'è stata un'eccezione
   public boolean eseguiAggiornamento(String query) {
      int numero = 0;
      boolean risultato = false;
      try {
         Statement stmt = db.createStatement();
         numero = stmt.executeUpdate(query);
         risultato = true;
         stmt.close();
      } catch (Exception e) {
         e.printStackTrace();
         errore = e.getMessage();
         risultato = false;
      }
      return risultato;
   }

   // Chiude la connessione con il Database
   public void disconnetti() {
      try {
         db.close();
         connesso = false;
      } catch (Exception e) { e.printStackTrace(); }
   }

   public boolean isConnesso() { return connesso; }   // Ritorna TRUE se la connessione con il Database è attiva
   public String getErrore() { return errore; }       // Ritorna il messaggio d'errore dell'ultima eccezione sollevata

public static void main(String Args[]){
  
}

}

