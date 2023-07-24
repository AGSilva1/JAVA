
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
	
	public String StringVariable() {
		String retorno = "";
		retorno += this.Acceso+" "+this.Tipo+" "+this.Nombre+";";
		return retorno;
	}
	
	public String StringVariablePHP() {
		String retorno = "";
		retorno += this.Acceso+" $"+this.Nombre+";";
		return retorno;
	}
	
	public String StringParametroJAVA() {
		String retorno = "";
		retorno += this.Nombre;
		return retorno;
	}
	
	public String StringParametroPHP() {
		String retorno = "";
		retorno += "$"+this.Nombre;
		return retorno;
	}
	
	public String StringParametroC() {
		String retorno = "";
		retorno += this.Nombre;
		return retorno;
	}
	public String StringParametro() {
		String retorno = "";
		retorno += this.Tipo+" "+this.Nombre;
		return retorno;
	}
	public String StringParametroJS() {
		String retorno = "";
		retorno += this.Nombre;
		return retorno;
	}
	
	public String StringVariableC() {
		String retorno = "";
		retorno += this.Tipo+" "+this.Nombre+";";
		return retorno;
	}
	
	public String StringVariableJS() {
		String retorno = "";
		retorno += "this."+this.Nombre+" = "+this.Nombre+";";
		return retorno;
	}
}
