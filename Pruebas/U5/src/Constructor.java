import java.util.ArrayList;

public class Constructor {
	public ArrayList<Variable> Variables;
	public String Nombre;
	
	public Constructor(String nom, ArrayList<Variable> vars) {
		this.Nombre = nom;
		for(int i=0;i<vars.size();i++) {
		this.Variables.add(vars.get(i));
		}
	}
	
	public String ListVariablesConst() {
		String retorno = "";
		for(int i=0;i<this.Variables.size();i++) {
			retorno += i+". "+this.Variables.get(i).StringVariable()+"\n";
		}
		return retorno;
	}
	
	public String StringConstructor() {
		String retorno = "";
		retorno += this.Nombre+"(";
		for(int i=0;i<this.Variables.size();i++) {
			retorno += this.Variables.get(i).StringParametro();
		}
		return retorno+")";
		
	}
}
