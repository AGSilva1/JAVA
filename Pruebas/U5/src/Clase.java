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
	
	public void DelVariable(int posicion) {
		if(this.Var.get(posicion).EsConstructor) {
			for(int i= 0; i < this.Const.Variables.size();i++) {
				if(this.Var.get(posicion) == this.Const.Variables.get(i)) {
					this.Const.Variables.remove(i);
				}
			}
		}
		this.Var.remove(posicion);
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
			retorno += (i+1)+". "+this.Var.get(i).StringVariable()+"\n";
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
	
	public String ListStringVariablesPHP() {
		String retorno = "";
		for(int i=0;i<this.Var.size();i++) {
			retorno += this.Var.get(i).StringVariablePHP()+"\n";
		}
		return retorno;
	}
	
	private String ListaVarC() {
		String retorno = "";
		ArrayList<Variable> publico = new ArrayList<Variable>();
		ArrayList<Variable> privado = new ArrayList<Variable>();
		ArrayList<Variable> protegido = new ArrayList<Variable>();
		for(int i =0; i < this.Var.size();i++) {
			switch(this.Var.get(i).Acceso.toLowerCase()) {
			case "public":
					publico.add(this.Var.get(i));
				break;
			case "private":
				privado.add(this.Var.get(i));
				break;
			case "protected":
				protegido.add(this.Var.get(i));
				break;
			}
		}
		if(publico.size() >= 0) {
			retorno += "public:\n";
			for(int i = 0;i < publico.size();i++) {
				retorno += "      "+publico.get(i).StringVariableC();
			}
		}
		if(privado.size() >= 0) {
			retorno += "private:\n";
			for(int i = 0;i < privado.size();i++) {
				retorno += "      "+privado.get(i).StringVariableC();
			}
		}
		if(protegido.size() >= 0) {
			retorno += "protected:\n";
			for(int i = 0;i < protegido.size();i++) {
				retorno += "      "+protegido.get(i).StringVariableC();
			}
		}
		
		return retorno;
	}
	
	public String ListarVarJS() {
		String retorno = "";
		for(int i = 0;i<this.Var.size();i++) {
			if(this.Var.get(i).EsConstructor) {
				retorno+="     "+this.Var.get(i).StringVariableJS()+"\n";
			}else {
				retorno+="     this."+this.Var.get(i).Nombre+" = '';\n";
			}
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
	
	public String ListStringMetodosPHP() {
		String retorno = "";
		for(int i=0;i<this.Met.size();i++) {
			retorno += this.Met.get(i).StringMetodo()+"\n";			
		}
		return retorno;
	}
	
	public String ListMetodosC() {
		String retorno = "";
		for(int i=0;i<this.Met.size();i++) {
			retorno += this.Met.get(i).StringMetodoC()+"\n";			
		}
		return retorno;
	}
	
	public String ListMetodosJS() {
		String retorno = "";
		for(int i=0;i<this.Met.size();i++) {
			retorno += "     function "+this.Met.get(i).StringMetodoJS()+"\n";			
		}
		return retorno;
	}
	
	public String ListaConstructorJAVA() {
		String retorno = "";
		retorno += this.Acceso+" "+this.Const.StringConstructorJAVA();
		
		return retorno ;
	}
	
	public String ListaConstructorPHP() {
		String retorno = "";
		retorno += "function "+this.Const.StringConstructorPHP();
		
		return retorno ;
	}
	
	public String ListaConstructorC() {
		String retorno = "";
		retorno+="      "+this.Const.StringConstructorC();
		
		return retorno ;
	}
	
	public String ListarClassJAVA() {
		String retorno = "";
		retorno+= this.Acceso+" class "+this.Nombre+"{\n\n";
		retorno+= this.ListStringVariables()+"\n";
		retorno+= this.ListaConstructorJAVA();
		for(int i = 0;i<this.Var.size();i++) {
			if(!this.Var.get(i).EsConstructor) {
				switch(this.Var.get(i).Tipo.toLowerCase()) {
				case "string":
					retorno += "this."+this.Var.get(i).Nombre+" = '';";
					break;
				case "boolean":
					retorno += "this."+this.Var.get(i).Nombre+" = false;";
				case "char":
					retorno += "this."+this.Var.get(i).Nombre+" = '';";
					break;
				default:
					retorno += "this."+this.Var.get(i).Nombre+" = 0;";
				}
			}
		}
		retorno+= "\n}\n\n";
		retorno+= this.ListStringMetodos()+"\n}";
		return retorno;
	}
	
	public String ListarClassC() {
		String retorno = "";
		boolean privado = false;
		boolean protegido = false;
		retorno+= "class "+this.Nombre+"{\n";
		retorno += "public:\n";
		for(int i = 0; i<Var.size();i++) {
			if(this.Var.get(i).Acceso.toLowerCase().equals("public")) {
				retorno+="     "+this.Var.get(i).Tipo+" "+Var.get(i).Nombre+";\n";
			}else if(this.Var.get(i).Acceso.toLowerCase().equals("private")) {
				privado = true;
			}else if(this.Var.get(i).Acceso.toLowerCase().equals("protected")) {
				protegido = true;
			}
		}
		for(int i = 0;i<this.Met.size();i++) {
			if(this.Met.get(i).Acceso.toLowerCase().equals("public")) {
				retorno += "     "+this.Met.get(i).StringMetodoC()+"\n";
			}else if(this.Met.get(i).Acceso.toLowerCase().equals("private")) {
				privado = true;
			}else if(this.Met.get(i).Acceso.toLowerCase().equals("protected")) {
				protegido = true;
			}
		}
		if(this.Acceso.toLowerCase().equals("public")) {
		retorno+= this.ListaConstructorC();
		}else if(this.Acceso.toLowerCase().equals("private")) {
			privado = true;
		}else if(this.Acceso.toLowerCase().equals("protected")) {
			protegido = true;
		}

		retorno+="\n";
		if(privado) {
			retorno += "private:\n";
			for(int i = 0; i<Var.size();i++) {
				if(this.Var.get(i).Acceso.toLowerCase().equals("private")) {
					retorno+="     "+this.Var.get(i).StringVariableC()+"\n";
				}
			}
			for(int i = 0;i<this.Met.size();i++) {
				if(this.Met.get(i).Acceso.toLowerCase().equals("private")) {
					retorno +="     "+this.Met.get(i).StringMetodoC()+"\n";
				}
			}
			if(this.Acceso.toLowerCase().equals("private")) {
				retorno+= this.ListaConstructorC();
			}
			retorno+="\n";
		}
		if(protegido) {
			retorno += "protected:\n";
			for(int i = 0; i<Var.size();i++) {
				if(this.Var.get(i).Acceso.toLowerCase().equals("protected")) {
					retorno+="     "+this.Var.get(i).StringVariableC()+"\n";
				}
			}
			for(int i = 0;i<this.Met.size();i++) {
				if(this.Met.get(i).Acceso.toLowerCase().equals("protected")) {
					retorno +="     "+this.Met.get(i).StringMetodoC()+"\n";
				}
			}
			if(this.Acceso.toLowerCase().equals("protected")) {
				retorno+= this.ListaConstructorC();
			}
			retorno+="\n";
		}
		retorno+= "}\n";
		return retorno;
	}
	
	public String ListarClassJS() {
		String retorno = "";
		ArrayList<Variable> paramConst = new ArrayList<Variable>();
		retorno+= " function "+this.Nombre+"(";
		for(int i = 0;i<this.Var.size();i++) {
			if(this.Var.get(i).EsConstructor) {
				paramConst.add(this.Var.get(i));
			}
		}
		for(int i = 0;i<paramConst.size();i++) {
			retorno+=paramConst.get(i).Nombre;
			if((i+1)<paramConst.size()) {
				retorno+=",";
			}
		}
		retorno+="){\n";
		retorno+= this.ListarVarJS();
		retorno+= "\n";
		retorno+= this.ListMetodosJS()+"\n}";
		return retorno;
	}
	
	public String ListarClassPHP() {
		String retorno = "";
		retorno+= " class "+this.Nombre+"{\n\n";
		retorno+= this.ListStringVariables()+"\n";
		retorno+= this.ListaConstructorPHP();
		for(int i = 0;i<this.Var.size();i++) {
			if(!this.Var.get(i).EsConstructor) {
				switch(this.Var.get(i).Tipo.toLowerCase()) {
				case "string":
					retorno += "this->$"+this.Var.get(i).Nombre+" = '';";
					break;
				case "boolean":
					retorno += "this->$"+this.Var.get(i).Nombre+" = false;";
				case "char":
					retorno += "this->$"+this.Var.get(i).Nombre+" = '';";
					break;
				default:
					retorno += "this->$"+this.Var.get(i).Nombre+" = 0;";
				}
			}
		}
		retorno+= "\n}\n\n";
		retorno+= this.ListStringMetodosPHP()+"\n}";
		return retorno;
	}
	
}
