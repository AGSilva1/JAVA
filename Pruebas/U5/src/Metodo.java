import java.util.ArrayList;

public class Metodo {
	public String Nombre;
	public String Tipo;
	public String Acceso;
	public ArrayList<Variable> Parametros;
	
	public Metodo(String nom, String tip, String acc, ArrayList<Variable> vars) {
		this.Nombre = nom;
		this.Tipo = tip;
		this.Acceso = acc;
		for(int i=0;i<vars.size();i++) {
			this.Parametros.add(vars.get(i));
		}
	}
	
	public String ListParametros() {
		String retorno = "";
		for(int i=0;i<this.Parametros.size();i++) {
			retorno += ""+this.Parametros.get(i).StringParametro();
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
	
	
}
