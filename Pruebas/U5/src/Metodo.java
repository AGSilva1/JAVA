import java.util.ArrayList;

public class Metodo {
	public String Nombre;
	public String Tipo;
	public String Acceso;
	public ArrayList<Variable> Parametros = new ArrayList<Variable>();
	
	public Metodo(String nom, String tip, String acc, ArrayList<Variable> vars) {
		this.Nombre = nom;
		this.Tipo = tip;
		this.Acceso = acc;
		if(vars != null) {
		for(int i=0;i<vars.size();i++) {
			this.Parametros.add(vars.get(i));
		}
		}
	}
	
	public String ListParametrosJAVA() {
		String retorno = "";
		for(int i=0;i<this.Parametros.size();i++) {
			retorno += ""+this.Parametros.get(i).StringParametroJAVA();
		}
		return "("+retorno+")";
	}
	
	public String ListParametros() {
		String retorno = "";
		for(int i=0;i<this.Parametros.size();i++) {
			retorno += ""+this.Parametros.get(i).StringParametroJAVA();
		}
		return "("+retorno+")";
	}
	
	public String ListParametrosPHP() {
		String retorno = "";
		for(int i=0;i<this.Parametros.size();i++) {
			retorno += ""+this.Parametros.get(i).StringParametroPHP();
		}
		return "("+retorno+")";
	}
	
	public String ListParametrosJS() {
		String retorno = "";
		for(int i=0;i<this.Parametros.size();i++) {
			retorno += this.Parametros.get(i).StringParametroJS();
		}
		return "("+retorno+")";
	}
	
	public String ListVariablesParam() {
		String retorno = "";
		for(int i=0;i<this.Parametros.size();i++) {
			retorno += i+". "+this.Parametros.get(i).StringVariable()+"\n";
		}
		return retorno;
	}
	
	public String StringMetodo() {
		String retorno = "";
		
		retorno += this.Acceso+" "+this.Nombre+this.ListParametros()+"{\n}";
		
		return retorno;
	}
	
	public String StringMetodoPHP() {
		String retorno = "";
		
		retorno += this.Acceso+" "+this.Nombre+this.ListParametrosPHP()+"{\n}";
		
		return retorno;
	}
	
	public String StringMetodoC() {
		String retorno = "";
		
		retorno +=this.Tipo+" "+this.Nombre+this.ListParametros()+"{\n     }";
		
		return retorno;
	}
	
	public String StringMetodoJS() {
		String retorno = "";
		
		retorno +=this.Nombre+this.ListParametrosJS()+"{\n     }";
		
		return retorno;
	}
	
	
}
