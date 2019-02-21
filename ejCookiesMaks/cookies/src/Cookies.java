

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import javax.servlet.http.Cookie;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class Cookies
 */
@WebServlet("/Cookies")
public class Cookies extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cookies() {
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
		// TODO Auto-generated method stub
		
		if(request.getCookies() != null) {
			Cookie[] cookie = request.getCookies();
			
				if(cookie[0].getValue().equals(request.getParameter("name"))) {
					PrintWriter out = response.getWriter();
					out.println("Bienvenido "+request.getParameter("name") +" eres un tolay ");
					Cookie[] cookies = request.getCookies();
					printCookies(cookies, out);
				}else {
					
					PrintWriter out = response.getWriter();
					out.println("Bienvenido, eres nuevo en el lugar");
					Cookie name = new Cookie("name", request.getParameter("name"));
					Cookie pass = new Cookie("pass", request.getParameter("pass"));
					String val = ""+((int)(Math.random()*9000)+1000);
					Cookie uid = new Cookie("UID", val);
					response.addCookie(name);
					response.addCookie(pass);
					
					Cookie[] cookies = request.getCookies();
					//response.setHeader("Refresh", "5");	
					printCookies(cookies, out);
					
				}
			
		}else {
			
			PrintWriter out = response.getWriter();
			out.println("Bienvenido, eres nuevo en el lugar");
			Cookie name = new Cookie("name", request.getParameter("name"));
			Cookie pass = new Cookie("pass", request.getParameter("pass"));
			String val = ""+((int)(Math.random()*9000)+1000);
			Cookie uid = new Cookie("UID", val);
			response.addCookie(name);
			response.addCookie(pass);
			
			Cookie[] cookies = request.getCookies();
			//response.setHeader("Refresh", "5");	
			printCookies(cookies, out);
			
		}
	}
	
	private void printCookies(Cookie[] cookies, PrintWriter out) {
		Arrays.stream(cookies).forEach(c -> out.println(c.getName() + ": " + c.getValue()));
	}

}
