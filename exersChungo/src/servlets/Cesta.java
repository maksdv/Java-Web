package servlets;

import java.util.Map;
import java.util.TreeMap;

public class Cesta {
	private TreeMap <Integer, Producto> lista;

	public Cesta(TreeMap<Integer, Producto> lista) {
		super();
		this.lista = lista;
	}

	public TreeMap<Integer, Producto> getLista() {
		return lista;
	}

	public void setLista(TreeMap<Integer, Producto> lista) {
		this.lista = lista;
	}

	@Override
	public String toString() {
		return "Cesta [lista=" + lista + "]";
	}

//	for(Integer k : this.lista.keySet()) {
//		Producto v = this.lista.get(k);
//		
//		System.out.println("KEY: " + k + "PRoducto: " + v.toString());
//		return "KEY: " + k + "PRoducto: " + v.toString();
//	}
	
	

	
	
	
}
