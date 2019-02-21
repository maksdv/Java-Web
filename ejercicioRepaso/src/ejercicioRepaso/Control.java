package ejercicioRepaso;
import ejercicioRepaso.Alumno;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * Servlet implementation class Control
 */
@WebServlet("/Control")
public class Control extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Control() {
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
		 HttpSession misession = request.getSession();
		 
		String name=request.getParameter("name");
		String apes=request.getParameter("apes");
		String asignatura=request.getParameter("asignatura");
		String notaE=request.getParameter("nota");
		int nota=Integer.parseInt(notaE);
		
		
		ArrayList<Alumno> lista = (ArrayList<Alumno>) misession.getAttribute("alumnos");
		if(lista==null) {
			List<Alumno> listaAlumnos = new ArrayList<Alumno>();

//	        listaAlumnos.add(new Alumno("Luis","Marica", "MATES", 7));
//	        listaAlumnos.add(new Alumno("Jaime","Marica", "MATES", 7));
//	        listaAlumnos.add(new Alumno("Andres","Marica", "MATES", 7));
//	        listaAlumnos.add(new Alumno("Dani","Marica", "MATES", 7));
//	        listaAlumnos.add(new Alumno("Sonia","LaMejorProfeDelMundoMundial", "Servidor", 1));
	        listaAlumnos.add(new Alumno(name, apes, asignatura,nota));
	        misession.setAttribute("alumnos", listaAlumnos);
		}else {
			lista.add(new Alumno(name, apes, asignatura,nota));
			
		}
        
        request.getRequestDispatcher("mostrarAlumnos").forward(request, response);
        
//        Iterator<Alumno> it = listaAlumnos.iterator();
//        
//	     while(it.hasNext()){
//	         Alumno item=it.next();
//	         System.out.println(item.toString());
//	     }
	}

}
