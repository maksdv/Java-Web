

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookArray
 */
@WebServlet("/CookArray")
public class CookArray extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CookArray() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		TreeMap<String, String> users = new TreeMap<>();
		users.put("sandra", "123");
		users.put("andres", "123");
		
		String username = req.getParameter("usu");
		String password = req.getParameter("pass");
		
		if(isRegistered(username, password, users)) {
			setCookies(username, req, res);
		}
		else res.sendRedirect("index.jsp?error=0");
		
	}
	
	private boolean isRegistered(String username, String password, TreeMap<String, String> users) {
		for(Map.Entry<String, String> entry: users.entrySet()) {
			if(entry.getKey().compareTo(username) == 0 && entry.getValue().compareTo(password) == 0) return true;
		}
		return false;
	}
	
	private void setCookies(String username, HttpServletRequest req, HttpServletResponse res) {
		
		Cookie[] cookies = req.getCookies();
		System.out.println("COOKIES LENGTH" + cookies.length);
		Object[] userCookies =Arrays.stream(cookies).filter(c -> c.getName().contains(username)).toArray();
		if(cookies.length == 1 || userCookies.length == 0) {
			res.addCookie(new Cookie(username, "Alfarero"));
			res.addCookie(new Cookie(username + "-visits", "1"));
			return;
		}
		System.out.println("USERNAME " + username);
		
		System.out.println(userCookies.length);
		for(Object cook: userCookies) {
			Cookie cok = (Cookie) cook;
			if(cok.getName().contains("-visits")) {
				int newVisits = Integer.parseInt(cok.getValue()) + 1;
				res.addCookie(new Cookie(username + "-visits", newVisits + ""));
				System.out.println("COOKOIIIES: " + cok.getName() + " -----> " + cok.getValue());
			}
			System.out.println("COOKOIIIES: " + cok.getName() + " -----> " + cok.getValue());
		}
		
	}
}
