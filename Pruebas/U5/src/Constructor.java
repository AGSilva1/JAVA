import java.util.ArrayList;

public class Constructor {
	public ArrayList<Variable> Variables = new ArrayList<Variable>();
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
	
	public String StringConstructorJAVA() {
		String retorno = "";
		retorno += this.Nombre+"(";
		for(int i=0;i<this.Variables.size();i++) {
			retorno +=this.Variables.get(i).StringParametroJAVA();
			if((i+1) < this.Variables.size()) {
				retorno +=",";
			}
		}
		retorno += "){\n";
		for(int i=0;i<this.Variables.size();i++) {
			retorno += "this."+this.Variables.get(i).StringParametroJAVA()+" = "+this.Variables.get(i).Nombre+";\n";
		}
		return retorno;
		
	}
	
	public String StringConstructorPHP() {
		String retorno = "";
		retorno += this.Nombre+"(";
		for(int i=0;i<this.Variables.size();i++) {
			retorno +=this.Variables.get(i).StringParametroPHP();
			if((i+1) < this.Variables.size()) {
				retorno +=",";
			}
		}
		retorno += "){\n";
		for(int i=0;i<this.Variables.size();i++) {
			retorno += "this->"+this.Variables.get(i).StringParametroPHP()+" = $"+this.Variables.get(i).Nombre+";\n";
		}
		return retorno;
		
	}
	
	private String ListVaraiblesAsigna() {
		String retorno = "";
		for(int i=0;i<this.Variables.size();i++) {
			retorno += this.Variables.get(i).StringParametro();
		}
		return retorno;
	}
	
	public String StringConstructorC() {
		String retorno = "";
		retorno += this.Nombre+"(";
		for(int i=0;i<this.Variables.size();i++) {
			retorno += this.Variables.get(i).StringParametro();
			if((i+1)<this.Variables.size()) {
				retorno+=",";
			}
		}
		retorno += "){\n";
		for(int i=0;i<this.Variables.size();i++) {
			retorno += "            "+this.Variables.get(i).StringParametroC()+" = "+this.Variables.get(i).Nombre+";\n";
		}
		
		return retorno+"     }";
		
	}
	
	public String StringConstructorJS() {
		String retorno = "";
		retorno += this.Nombre+"(";
		for(int i=0;i<this.Variables.size();i++) {
			retorno += this.Variables.get(i).Nombre;
		}
		retorno += "){";
		
		return retorno;
	}
}
