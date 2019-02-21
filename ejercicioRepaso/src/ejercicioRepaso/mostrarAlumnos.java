package ejercicioRepaso;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class mostrarAlumnos
 */
@WebServlet("/mostrarAlumnos")
public class mostrarAlumnos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public mostrarAlumnos() {
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
		PrintWriter out = response.getWriter();
		HttpSession misession = request.getSession();
		ArrayList<Alumno> lista = (ArrayList<Alumno>) misession.getAttribute("alumnos");
		
		Iterator<Alumno> it = lista.iterator();
        
	     while(it.hasNext()){
	    	 Alumno item=it.next();
	    	 System.out.println(item.toString());
	    	// if(item.getNombre().equals("Max")) {
	    		 
		         out.println("<!DOCTYPE html>");
	             out.println("<html>");
	             out.println("<head>");
	             out.println("<title>Menú</title>");            
	             out.println("</head>");
	             out.println("<body>");
	             out.println("<h1>Bienvenido "+item.getNombre()+"</h1>");
	             out.println("<h1>Todos tus datos "+item.toString()+"</h1>");
	             out.println("<a href='CerrarSesionServlet'>Cerrar sesionn</a>");
	             out.println("<a href='EliminarReg'>Eliminar un alumno</a>");
	             out.println("</body>");
	             out.println("</html>");
	    	// }
	         
	         
	     }
		
		
	}

}
