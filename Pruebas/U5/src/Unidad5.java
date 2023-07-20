import java.util.ArrayList;

public class Unidad5 {

	public static void main(String[] args) {
		
		ArrayList<Clase> clases = new ArrayList<Clase>();
		Clase clas;		
		Variable variable;
		Metodo metodo;
		
		clas = new Clase("Persona", "public");
		clases.add(clas);
		
		variable = new Variable("Nombre","String",true,"private");		
		clases.get(0).AddVariable(variable);
		
		clases.get(0).startConstructor();
		
		metodo = new Metodo("stringPersona","String","public",null);
		
		clases.get(0).AddMetodo(metodo);
		
		System.out.println(clases.get(0).Acceso+" class "+clases.get(0).Nombre+"{\n");
		System.out.println(clases.get(0).ListStringVariables());
		System.out.println("\n");
		System.out.println(clases.get(0).ListaConstructor());
		System.out.println("\n");
		System.out.println(clases.get(0).ListStringMetodos()+"\n}");
		
	}

}
