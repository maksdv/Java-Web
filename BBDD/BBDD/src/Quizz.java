import java.lang.reflect.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.TreeSet;

import com.mysql.jdbc.Statement;

public class Quizz extends Conexion {

	
	public Quizz() {
		super();
	}
	
	public ArrayList temas() {
		String query = "SELECT topic FROM theme";
		
		
		try {
			Statement st = (Statement) this.conn.createStatement();
  	      	ResultSet rs = st.executeQuery(query);
  	      	ArrayList<String> temas = new ArrayList();
  	      	//TreeMap<String, String> pepetter = new TreeMap<>();

  	      	while(rs.next()) {
  	      		System.out.println("eooo" + rs.toString());
  	      		temas.add(rs.getString("topic"));
  	      	}
  	      	return temas;
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("FALLO EN QUIZZ TEMAS:     " + e);
			
		}
		
		return null;
	}
	
	public TreeMap<String, String> queryTema(String tema){
		if (tema=="Web") {
			String query = "SELECT * FROM quiz where id=1 or id=2 or id=3 or id=4 ";
				
		}
		
		return null;
	}
	
}
