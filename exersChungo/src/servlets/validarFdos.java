package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class validarFdos
 */
@WebServlet("/validarFdos")
public class validarFdos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public validarFdos() {
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
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		HttpSession misession = request.getSession();
		if(misession.getAttribute("user") != null) {
			 out.println("<h1>Bienvenido "+misession.getAttribute("user")+"</h1>");
			 String menu = request.getParameter("menu");
			 String kk = request.getParameter("cant");
			 int cant = Integer.parseInt(kk);
			 Producto product= new Producto(menu, cant);
			 
			 if(misession.getAttribute("cesta") == null) {
				 TreeMap <Integer, Producto > map =new TreeMap();
				 map.put(1, product);
				 Cesta cestita = new Cesta(map);
				 misession.setAttribute("cesta", cestita);
			 }else {
				// misession.removeAttribute("cesta");
				 Cesta  map= (Cesta) misession.getAttribute("cesta");
				 Integer position =(Integer) map.getLista().size()+1;
				System.out.println(position);
				map.getLista().put(position, product);
				 
				 misession.setAttribute("cesta", map);
				 
				 
			 }
			
			
			 request.getRequestDispatcher("mostrarCesta").forward(request, response);
			 
		}else {
			 out.println("<h1>Lo siento, pero no estas logueado!!!</h1>");
		}
	}

}
