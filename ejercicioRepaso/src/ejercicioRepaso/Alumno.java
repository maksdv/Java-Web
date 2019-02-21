package ejercicioRepaso;


import java.util.ArrayList;
import java.util.List;

public class Alumno{
	
	 private String nombre;
	 private String apes;
	 private String asignatura;
	 private int nota;
	 
	 public Alumno(String nombre, String apes, String asignatura, int nota) {
		 this.nombre=nombre;
		 this.apes=apes;
		 this.asignatura=asignatura;
		 this.nota=nota;
	 }
	
	 public String toString() {
		 return "El alumno "+nombre+" "+apes+" ha sacado un "+nota+"en "+asignatura;
	 }
	 
	 public String getNombre() {
	        return nombre;
	    }
	    public void setNombre(String nombre) {
	        this.nombre = nombre;
	    }
	    public String getApes() {
	        return apes;
	    }
	    public void setApes(String apes) {
	        this.apes = apes;
	    }
	    public String getAsignatura() {
	        return asignatura;
	    }
	    public void setAsignatura(String asignatura) {
	        this.asignatura = asignatura;
	    }
	    public int getNota() {
	        return nota;
	    }
	    public void setNota(int nota) {
	        this.nota = nota;
	    }
	
}