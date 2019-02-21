

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.TreeMap;

import com.mysql.jdbc.Statement;


public class Conexion {

    // Librería de MySQL
    public String driver = "com.mysql.jdbc.Driver";

    // Nombre de la base de datos
    public String database = "pruebas";

    // Host
    public String hostname = "localhost";

    // Puerto
    public String port = "3306";

    // Ruta de nuestra base de datos (desactivamos el uso de SSL con "?useSSL=false")
    public String url = "jdbc:mysql://" + hostname + ":" + port + "/" + database;

    // Nombre de usuario
    public String username = "root";

    // Clave de usuario
    public String password = "QWERTY1.";
    
    public Connection conn = null;

    public Conexion() {
        
        try {
            
			Class.forName(driver);
			conn = DriverManager.getConnection(url, username, password);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }
    
    public void closeConn() {
    	try {
			this.conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public TreeMap<String, String> queryGen(String table) {
    	
    	String query = "SELECT * FROM " + table;
    	
    	try {
    	      Statement st = (Statement) conn.createStatement();
    	      ResultSet rs = st.executeQuery(query);
    	      //System.out.println("QUERY" + rs);
    	      int c =0;
    	      TreeMap<String, String> pepetter = new TreeMap<>();
    	      while(rs.next()) {
    	    	 pepetter.put(rs.getString("name"), rs.getString("pass"));
    	    	 c++;
    	      }
    	     // st.close();

    	      return pepetter;
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("ERRORQUERT"+ e);

		}
		return null;
    	

    }
    public int getUser(String name, String pass) {
    	String query = "SELECT * FROM users where name=" +"'"+ name + "'" ;
  	  	System.out.println(query.toString());

    	int id=-1;
    	try {
    	      Statement st = (Statement) this.conn.createStatement();
    	      ResultSet rs = st.executeQuery(query);
    	      while(rs.next()) {
        	      if(rs.getString("pass").compareTo(pass)==0) {
        	    	  id=rs.getInt("id");
        	    	  return id;
        	      }
    	      }
    	    
    	      return -1;
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("EXCEPCION NO ENCUENTRA NADA"+ e);
			return -1;
		}
    	//return 1;
	}
}