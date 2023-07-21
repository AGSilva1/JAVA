import java.util.ArrayList;
import java.util.Scanner;

public class Unidad5 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		ArrayList<Clase> clases = new ArrayList<Clase>();
		Clase clas;		
		Variable variable;
		Metodo metodo;
		
		int menuPrincipal, menuclase, menuvaraible, menumetodo;
		menuPrincipal = 0;
		System.out.println("Bienvenido");
		do {
			System.out.println(MenuPrincipal());
			menuPrincipal = sc.nextInt();
			switch(menuPrincipal) {
			case 1:
				System.out.println("\n=======================================\n");
				EjemploBase();
				System.out.println("\n=======================================\n");
				break;
			case 2:
				menuclase = 0;
				do {
				System.out.println("\n=======================================\n");
				if(clases != null) {
					System.out.println(MenuClases(true));
				}else {
					System.out.println(MenuClases(false));
				}
				menuclase = sc.nextInt();
				switch(menuclase) {
				case 1:
						String NomClas = "";
						do {
						
						}while(NomClas != "");
						
						String AccClas = "";
						do {
							
						}while(AccClas != "");
						
						
						
					break;
				case 2:
					System.out.println("____________________________________\n");
					for(int i = 0; i<clases.size();i++) {
						System.out.println(i+". "+clases.get(i).Acceso+"\n");
					}
					System.out.println("____________________________________\n");
					break;
				case 3:
					break;
				case 4:
					break;
				case 5:
					break;
				default:
					System.out.println("Debe seleccionar una opcion valida");
					menuclase = 0;
				}
				System.out.println("\n=======================================\n");
				}while(menuclase!=5);
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
				break;
			default:
				System.out.println("Debe seleccionar una opcion valida");
				menuPrincipal = 0;
			}
		
		}while(menuPrincipal != 6);	
		
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
	
	public static String MenuPrincipal() {
		String retorno = "";
		retorno += "Menu Principal \n";
		retorno +="Seleccione una opcion \n";
		retorno +="1. Ejecutar ejemplo de clase formato standar java \n";
		retorno +="2. Agregar o modificar clase \n";
		retorno +="3. Agregar  o modificar Variables de una clase \n";
		retorno +="4. Agregar o modificar Metodos de una Clase \n";
		retorno +="5. Listar Clase en formato \n";
		retorno +="6. Salir \n";
		return retorno;
	}
	
	public static String MenuClases(boolean ExisteClase) {
		String retorno = "";
		retorno += "Menu Clases \n";
		retorno +="Seleccione una opcion \n";
		retorno +="1. Agregar Nueva Clase \n";
		if(ExisteClase) {
			retorno +="2. Listar Clases \n";
			retorno +="3. Modificar una Clase \n";
			retorno +="4. Eliminar una Clase \n";
		}
		retorno +="5. Volver al Menu Principal \n";
		return retorno;
		
	}

}
