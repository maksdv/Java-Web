

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CreaSesion
 */
@WebServlet("/CreaSesion")
public class CreaSesion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreaSesion() {
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
		
		String name=request.getParameter("nombre");
		String kk=request.getParameter("altura");
		String fe=request.getParameter("fecha");
		String aa=request.getParameter("edad");
		int edad=Integer.parseInt(aa);
		Float altura=Float.parseFloat(kk);
		SimpleDateFormat format=new SimpleDateFormat("yyyy-mm-dd");
		try {
			Date fecha = format.parse(fe);
		} catch (ParseException e) {
			e.printStackTrace();
			
		}
		
		HttpSession misession = request.getSession(false);
		//String nam= (String)request.getSession().getAttribute("name");
		if(misession==null) {
			misession = (HttpSession) request.getSession();
			misession.setAttribute("name", name);
			//misession.setAttribute("fecha", fecha);
			misession.setAttribute("edad", edad);
			misession.setAttribute("altura", altura);
		}else {
			request.getSession().setMaxInactiveInterval(1);
			request.getRequestDispatcher("index.html").forward(request, response);
		}
		
		
	}

}
