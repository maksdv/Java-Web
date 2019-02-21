import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.*;

public class connectionBD {
	public Connection cn;
	public Statement st = null;

	public connectionBD() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			this.cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cliente", "root", "");
			this.st = (Statement) this.cn.createStatement();
			ResultSet miResult=st.executeQuery("Select * from cliente");
			
			while(miResult.next()) {
				System.out.println(miResult.getString("Nombre") + " " +miResult.getString("Apellido") );
			}
			System.out.println("La conexion ha sido unexito  ");
		} catch (Exception e) {
			System.out.println("La conexion ha falladoo  " + e);
			e.printStackTrace();
		}
	}

}
