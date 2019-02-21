

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
/**
 * Servlet implementation class conector
 */
@WebServlet("/conector")
public class conector extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public conector() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		try {
//			Conexion cn = new Conexion();
//			System.out.println("pepepepepe" + cn);
//			
			String user = request.getParameter("user");	
			String pass = request.getParameter("pass");	
//			//System.out.println(">>>>>>>>>>>>>"+user+"PASSSSSSS"+pass);
//			TreeMap<String, String> names = cn.queryGen("users");
//			
//			for(Map.Entry<String,String> entry : names.entrySet()) {
//				  String key = entry.getKey();
//				  String value = entry.getValue();
//				  
//				  //System.out.println(key + " => " + value);
//				  
//				  if (user.compareTo(key)==0 && pass.compareTo(value)==0) {
//					 System.out.println(key + " => " + value);
//				  }
//
//				}
			System.out.println("USER :" + user + "==>" + "PASS : " + pass);
			
			Conexion cn = new Conexion();
			int c = cn.getUser(user, pass);
			//HttpSession session= request.getSession(true);

			
			if(c>-1) {
				Quizz q = new Quizz();
				
				ArrayList<String> temas = q.temas();
				
				request.getSession().setAttribute("id", c);
				//request.getSession().setAttribute("user", user);
				
				Cookie myCookie = new Cookie("Nombre", user);
				myCookie.setMaxAge(60*60);
				//response.addCookie(myCookie);
				
				request.getSession().setAttribute("temas", temas);
				
				response.sendRedirect("startQuizz.jsp");
				
				System.out.println("Usuario validado");

			}else if (c==-1) {
				System.out.println("Usuario no validado");
			}else {
				System.out.println("ALGO FUE MAL");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	doGet(request, response);
	}

}
