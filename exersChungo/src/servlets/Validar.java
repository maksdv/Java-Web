package servlets;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Validar
 */
@WebServlet("/Validar")
public class Validar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Validar() {
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
		
		TreeMap<String, String> users = new TreeMap<>();
		users.put("max", "123");
		users.put("pulpo", "123");
		
		String username = request.getParameter("user");
		String password = request.getParameter("pass");
		
		if(isRegistered(username, password, users)) {
			System.out.println("esta dentro");
			HttpSession misession = request.getSession();
			misession.setAttribute("user", username);
			request.getRequestDispatcher("formularioDos.jsp").forward(request, response);
		}
	}
	
	private boolean isRegistered(String username, String password, TreeMap<String, String> users) {
		for(Map.Entry<String, String> entry: users.entrySet()) {
			if(entry.getKey().compareTo(username) == 0 && entry.getValue().compareTo(password) == 0) return true;
		}
		return false;
	}

}
