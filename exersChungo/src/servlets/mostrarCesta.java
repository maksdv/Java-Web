package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class mostrarCesta
 */
@WebServlet("/mostrarCesta")
public class mostrarCesta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public mostrarCesta() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		HttpSession misession = request.getSession();
		if(misession.getAttribute("user") != null) {
			Cesta kk = (Cesta) misession.getAttribute("cesta");
			out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Menú</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>HOLA</h1>");
            out.println("<h1>Todos tus datos "+kk.toString()+"</h1>");
            out.println("<a href='CerrarSesionServlet'>Cerrar sesionn</a>");
            out.println("<a href='EliminarReg'>Eliminar un alumno</a>");
            out.println("</body>");
            out.println("</html>");
			
		}
		
	}

}
