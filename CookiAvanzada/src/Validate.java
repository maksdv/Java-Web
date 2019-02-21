

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class Validate
 */
@WebServlet("/Validate")
public class Validate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Validate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
				
//		            Class.forName("com.mysql.jdbc.Driver");
//
//					Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/libros","root","");
//				
//					Statement miStatement = miConexion.createStatement();
//					
//					ResultSet miResult=miStatement.executeQuery("Select * from customer");
//				
//					while(miResult.next()) {
//					System.out.println(miResult.getString("firstname") + " " +miResult.getString("surname") );
					
					
					connectionBD pepetter=new connectionBD();			
					
	}

}
