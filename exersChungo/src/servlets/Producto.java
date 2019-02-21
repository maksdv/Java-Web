package servlets;

public class Producto {
	
	private String name;
	private int cantidad;
	
	public Producto(String name, int cantidad) {
		super();
		this.name = name;
		this.cantidad = cantidad;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	@Override
	public String toString() {
		
		return "Producto [name=" + name + ", cantidad=" + cantidad + "]";
	}
}
