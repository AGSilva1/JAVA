import java.util.ArrayList;

public class Clase {
	public String Nombre;
	public String Acceso;
	public ArrayList<Variable> Var;
	public ArrayList<Metodo> Met;
	public Constructor Const;
	
	public Clase(String nom, String acc) {
		this.Nombre = nom;
		this.Acceso = acc;
		this.Var = new ArrayList<Variable>();
		this.Met = new ArrayList<Metodo>();
		this.Const = null;
	}
	
	public void AddVariable(Variable var) {
		this.Var.add(var);
	}
	
	public void AddMetodo(Metodo met) {
		this.Met.add(met);
	}
	
	public void startConstructor() {
		ArrayList<Variable> varConstruct = new ArrayList<Variable>();
		for(int i = 0; i<this.Var.size();i++) {
			if(this.Var.get(i).EsConstructor) {
				varConstruct.add(this.Var.get(i));
			}
		}
		this.Const = new Constructor(this.Nombre,varConstruct);
	}
	
	public String ListVariables() {
		String retorno = "";
		for(int i=0;i<this.Var.size();i++) {
			retorno += i+". "+this.Var.get(i).StringVariable()+"\n";
		}
		return retorno;
	}
	
	public String ListStringVariables() {
		String retorno = "";
		for(int i=0;i<this.Var.size();i++) {
			retorno += this.Var.get(i).StringVariable()+"\n";
		}
		return retorno;
	}
	
	public String ListMetodos() {
		String retorno = "";
		for(int i=0;i<this.Met.size();i++) {
			retorno += i+". "+this.Met.get(i).Acceso+" "+this.Met.get(i).Tipo+" "+this.Met.get(i).Nombre + this.Met.get(i).ListParametros()+"\n";			
		}
		return retorno;
	}
	
	public String ListStringMetodos() {
		String retorno = "";
		for(int i=0;i<this.Met.size();i++) {
			retorno += this.Met.get(i).StringMetodo()+"\n";			
		}
		return retorno;
	}
	
	public String ListaConstructor() {
		String retorno = "";
		retorno += this.Acceso+" "+this.Const.StringConstructor()+"{\n}";
		
		return retorno ;
	}
}
