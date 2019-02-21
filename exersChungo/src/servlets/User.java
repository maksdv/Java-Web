package servlets;

public class User {
	private String name;
	private String pass;
	private String fruta;
	private String gufe;
	
	public User(String name, String pass) {
		this.name=name;
		this.pass=pass;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getFruta() {
		return fruta;
	}

	public void setFruta(String fruta) {
		this.fruta = fruta;
	}

	public String getGufe() {
		return gufe;
	}

	public void setGufe(String gufe) {
		this.gufe = gufe;
	}

	@Override
	public String toString() {
		return "Usuario  " + name + ",ha elegido " + fruta + " ,y es " + gufe;
	}
	
	
}
