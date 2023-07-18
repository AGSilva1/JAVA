
public class Variable {
	public String Nombre;
	public String Tipo;
	public boolean EsConstructor;
	public String Acceso;
	
	public Variable(String nom, String tip, boolean esC, String acc) {
		this.Nombre = nom;
		this.Tipo = tip;
		this.EsConstructor = esC;
		this.Acceso = acc;
	}
	
	public void setAcceso(String acc) {
		this.Acceso = acc;
	}
	
	public void setTipo(String tip) {
		this.Tipo = tip;
	}
	
	public void setNombre(String nom) {
		this.Nombre = nom;
	}
	
	public String StringVariable() {
		String retorno = "";
		retorno += this.Acceso+" "+this.Tipo+" "+this.Nombre;
		return retorno;
	}
	
	public String StringParametro() {
		String retorno = "";
		retorno += this.Tipo+" "+this.Nombre;
		return retorno;
	}
}
