import java.util.ArrayList;

public class Unidad5 {

	public static void main(String[] args) {
		
		ArrayList<Clase> clases = new ArrayList<Clase>();
		Clase clas;		
		Variable variable;
		Metodo metodo;
		
		EjemploBase();
				
		
	}
	
	public static void EjemploBase() {
		ArrayList<Clase> clasesEjem = new ArrayList<Clase>();
		Clase clasEjem;		
		Variable variableEjem;
		Metodo metodoEjem;
		
		clasEjem = new Clase("Persona", "public");
		clasesEjem.add(clasEjem);
		
		variableEjem = new Variable("Nombre","String",true,"private");		
		clasesEjem.get(0).AddVariable(variableEjem);
		
		clasesEjem.get(0).startConstructor();
		
		metodoEjem = new Metodo("stringPersona","String","public",null);
		
		clasesEjem.get(0).AddMetodo(metodoEjem);
		
		System.out.println(clasesEjem.get(0).Acceso+" class "+clasesEjem.get(0).Nombre+"{\n");
		System.out.println(clasesEjem.get(0).ListStringVariables());
		//System.out.println("\n");
		System.out.println(clasesEjem.get(0).ListaConstructor());
		System.out.println("\n");
		System.out.println(clasesEjem.get(0).ListStringMetodos()+"\n}");
	}

}
