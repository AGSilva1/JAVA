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
			//========================================================================================================================================
			case 1:
				System.out.println("\n=======================================\n");
				EjemploBase();
				System.out.println("\n=======================================\n");
				break;
			//========================================================================================================================================
			case 2:
				menuclase = 0;
				do {
				System.out.println("\n=======================================\n");
				if(!clases.isEmpty()) {
					System.out.println(MenuClases(true));
				}else {
					System.out.println(MenuClases(false));
				}
				menuclase = sc.nextInt();
				switch(menuclase) {
				//__________________________________________________________________________________________________________________
				case 1://AGREGAR CLASE
						boolean AgregaClase = false;
						String confirmaClase = ""; 
						System.out.println("TE RECORDAMOS QUE LOS DATOS SOLICITADOS SON BASADOS EN LENGUAJE JAVA,\n CUANDO SOLICITES MOSTRARLOS EN OTROS CODIGOS SE HARA LA CONVERCION CORRESPONDIENTE");
						//AGREGA NOMBRE CLASE
						String NomClas = "";
						System.out.println("Ingrese el nombre de la Clase");
						do {							
							NomClas = sc.nextLine();
							if(NomClas.equals("")) {
								System.out.println("Debe ingresa un nombre para la clase");
							}
						}while(NomClas.equals(""));
						//FIN AGREGA NOMBRE CLASE
						//AGREGA ACCESO CLASE
						String AccClas = "";
						boolean validaAcc = false;
						do {
							System.out.println("Ingrese el acceso de la clase (public, private, protected)\n");
							AccClas = sc.nextLine();
							if(AccClas.toLowerCase().equals("public") || AccClas.toLowerCase().equals("private") || AccClas.toLowerCase().equals("protected") ) {
								validaAcc = true;
							}else {
								System.out.println("Debe ingresar uno de los siguientes datos validos (public, private, protected)");
							}
						}while(validaAcc = false);
						//FIN AGEGA ACCESO CLASE
						
						//CONFIRMAR AGREGAR CLASE
						System.out.println("Confirma los datos? - Clase: "+AccClas+" "+NomClas);
						confirmaClase = sc.nextLine();
						if(confirmaClase.toUpperCase().equals("S")) {
							clas = new Clase(NomClas,AccClas.toLowerCase());
							clases.add(clas);
							AgregaClase = true;
							System.out.println("Clase Grabada correctamente");
						}
						//FIN CONFIRMAR AGREGAR CLASE
						
						if(AgregaClase) {		
							
							//AGREGAR VARIABLE
							String agregavar = "";						
							do{
								System.out.println("Desea Agregar variables? S=SI/N=NO\n");
								agregavar = sc.nextLine();
								switch(agregavar.toUpperCase()) {
								case "S"://SI AGREGA VARIABLE
									
										//AGREGA NOMBRE VARIABLE
										String NomVariable = "";
										System.out.println("Ingrese nombre de la variable");
										do {									
										NomVariable = sc.nextLine();
										if(NomVariable.equals("")) {
											System.out.println("Debe ingresar un nombre para la variable");
										}
										}while(NomVariable.equals(""));
										//FIN AGREGA NOMBRE VARIABLE
										
										//AGREGA ACCESO VARIABLE
										String AccVariable = "";
										System.out.println("Ingrese acceso de la variable (public, private, protected)");
										do {
											AccVariable  = sc.nextLine();
											if(!AccVariable.equals("public") && !AccVariable.equals("private") && !AccVariable.equals("protected")) {
												AccVariable = "";
											}
										}while(AccVariable.equals(""));
										//FIN  AGREGA ACCESO VARIABLE
										
										//AGREGA TIPO DATO VARIABLE
										String TipoVariable = "";
										System.out.println("Ingrese tipo de dato de la variable (string, int, boolean, char, double, short, long, float)");
										do {																			
											TipoVariable = sc.nextLine();
											if(!TipoVariable.toLowerCase().equals("string")&&!TipoVariable.toLowerCase().equals("int")&&!TipoVariable.toLowerCase().equals("boolean")&&!TipoVariable.toLowerCase().equals("char")&&!TipoVariable.toLowerCase().equals("double")&&!TipoVariable.toLowerCase().equals("short")&&!TipoVariable.toLowerCase().equals("long")&&!TipoVariable.toLowerCase().equals("float")) {
												System.out.println("Debe ingresar un tipo para la variable (string, int, boolean, char, double, short, long, float)");
												TipoVariable = "";
											}
										}while(TipoVariable.equals(""));
										//FIN AGREGA TIPO DATO VARIABLE
										
										//CONFIRMA SI SE AGREGA A CONSTRUCTOR CLASE
										String EsConstVariable="";
										boolean EsConstructor = false;
										System.out.println("Desea agregarlo al constructor de la clase "+NomClas+"? S=SI/N=NO");
										do {										
											EsConstVariable  = sc.nextLine();
											if(EsConstVariable.equals("") && (!EsConstVariable.toUpperCase().equals("S") || !EsConstVariable.toUpperCase().equals("N"))) {
												System.out.println("Debe ingresar un dato valido S o N");
											}else {
												if(EsConstVariable.toUpperCase().equals("S")) {
													EsConstructor = true;
												}else {
													EsConstructor = false;
												}
											}
										}while(!EsConstVariable.toUpperCase().equals("N") && !EsConstVariable.toUpperCase().equals("S"));
										//FIN CONFIRMA SI SE AGREGA A CONSTRUCTOR CLASE
										
										//CONFIRMA AGREGAR VARIABLE
										System.out.println("Varaible: "+AccVariable+" "+TipoVariable+" "+NomVariable+" EsConstructor "+EsConstVariable+"\n");
										System.out.println("Confirmar para grabar S=SI/N=NO\n");
										String grabar = sc.nextLine();
										switch(grabar.toUpperCase()) {
										case "S"://SI CONFIRMA AGREGA VARIABLE
												variable = new Variable(NomVariable,TipoVariable,EsConstructor,AccVariable);
												int posicionclass = clases.size();
												clases.get(posicionclass-1).AddVariable(variable);
												System.out.println("Variable Grabada correctamente a la clase"+clases.get(posicionclass-1).Nombre);
											break;
										case "N"://NO CONFIRMA AGREGA VARIABLE
											break;
										default:
										}
										//FIN CONFIRMA AGREGA VARIABLE
									break;
								case "N"://NO AGREGA VARIABLE
									break;
								default://EN CASO DE INGRESAR DATO ERRONEO
									System.out.println("Debe ingresar un dato valido S/N");
									agregavar = "";
								}
							}while(!agregavar.toUpperCase().equals("N"));
							//FIN AGREGAR VARAIBLE
							clases.get(clases.size()-1).startConstructor();
						}
						//FIN AGREGAR CLASE
					break;
				//__________________________________________________________________________________________________________________
				case 2://AGREGAR VARIABLE
					System.out.println("____________________________________\n");
					int posicion = 0;
					if(clases.size()>0) {
						for(int i = 0; i<clases.size();i++) {
							System.out.println((i+1)+". "+clases.get(i).Acceso+" "+clases.get(i).Nombre+"\n");
						}
					}else {
						System.out.println("No existen Clases ingresadas");
						break;
					}
					int selecClasVariable = 0;
					do {
						System.out.println("Seleccione una clase por su ID");
						selecClasVariable = sc.nextInt();
						if(clases.get(selecClasVariable-1) == null) {
							System.out.println("No existe clase con el ID ingresado");
							selecClasVariable = 0;
						}
					}while(selecClasVariable == 0);					
					//AGREGA NOMBRE VARIABLE
					String NomVariable = "";
					System.out.println("Ingrese nombre de la variable");
					do {									
						NomVariable = sc.nextLine();
						if(NomVariable.equals("")) {
							System.out.println("Debe ingresar un nombre para la variable");
						}
					}while(NomVariable.equals(""));
					//FIN AGREGA NOMBRE VARIABLE
								
					//AGREGA ACCESO VARIABLE
					String AccVariable = "";
					System.out.println("Ingrese acceso de la variable (public, private, protected)");
					do {
						AccVariable  = sc.nextLine();
						if(!AccVariable.equals("public") && !AccVariable.equals("private") && !AccVariable.equals("protected")) {
							System.out.println("Debe ingresar un acceso valido de la variable (public, private, protected)");
							AccVariable = "";
						}
					}while(AccVariable.equals(""));
					//FIN  AGREGA ACCESO VARIABLE
								
					//AGREGA TIPO DATO VARIABLE
					String TipoVariable = "";
					System.out.println("Ingrese tipo de dato de la variable (string, int, boolean, char, double, short, long, float)");
					do {																			
						TipoVariable = sc.nextLine();
						if(!TipoVariable.toLowerCase().equals("string")&&!TipoVariable.toLowerCase().equals("int")&&!TipoVariable.toLowerCase().equals("boolean")&&!TipoVariable.toLowerCase().equals("char")&&!TipoVariable.toLowerCase().equals("double")&&!TipoVariable.toLowerCase().equals("short")&&!TipoVariable.toLowerCase().equals("long")&&!TipoVariable.toLowerCase().equals("float")) {
							System.out.println("Debe ingresar un tipo para la variable (string, int, boolean, char, double, short, long, float)");
							TipoVariable = "";
						}
					}while(TipoVariable.equals(""));
					//FIN AGREGA TIPO DATO VARIABLE
								
					//CONFIRMA SI SE AGREGA A CONSTRUCTOR CLASE
					String EsConstVariable="";
					boolean EsConstructor = false;
					System.out.println("Desea agregarlo al constructor de la clase? S=SI/N=NO");
					do {										
						EsConstVariable  = sc.nextLine();
						if(EsConstVariable.equals("") && (!EsConstVariable.toUpperCase().equals("S") || !EsConstVariable.toUpperCase().equals("N"))) {
							System.out.println("Debe ingresar un dato valido S o N");
						}else {
							if(EsConstVariable.toUpperCase().equals("S")) {
								EsConstructor = true;
							}else {
								EsConstructor = false;
							}
									}
					}while(!EsConstVariable.toUpperCase().equals("N") && !EsConstVariable.toUpperCase().equals("S"));
					//FIN CONFIRMA SI SE AGREGA A CONSTRUCTOR CLASE
								
					//CONFIRMA AGREGAR VARIABLE
					System.out.println("Varaible: "+AccVariable+" "+TipoVariable+" "+NomVariable+" EsConstructor "+EsConstVariable+"\n");
					System.out.println("Confirmar para grabar S=SI/N=NO\n");
					String grabar = sc.nextLine();
					switch(grabar.toUpperCase()) {
						case "S"://SI CONFIRMA AGREGA VARIABLE
								variable = new Variable(NomVariable,TipoVariable,EsConstructor,AccVariable);
								clases.get(selecClasVariable-1).AddVariable(variable);
								System.out.println("Variable Grabada correctamente a la clase"+clases.get(selecClasVariable-1).Nombre);
							break;
						case "N"://NO CONFIRMA AGREGA VARIABLE
							break;
						default:
					}			
					//FIN AGREGAR VARAIBLE
					break;
				//__________________________________________________________________________________________________________________
				case 3://AGREGA METODO A CLASE
					System.out.println("____________________________________\n");
					ArrayList<Variable> parametro = new ArrayList<Variable>();
					if(clases.size()>0) {
						for(int i = 0; i<clases.size();i++) {
							int pocision = i + 1;
							System.out.println(pocision+". "+clases.get(i).Acceso+" "+clases.get(i).Nombre+"\n");
						}
					}else {
						System.out.println("No existen Clases ingresadas");
					}
					int selecClassMetodo = 0;
					do {
						System.out.println("Seleccione una clase por su numero");
						selecClassMetodo = sc.nextInt();
						if(clases.get(selecClassMetodo-1) == null) {
							System.out.println("No existe clase con el numero ingresado");
							selecClassMetodo = 0;
						}
					}while(selecClassMetodo == 0);
					
					String NomMetodo = "";
					System.out.println("Ingrese nombre del metodo");
					do {
						NomMetodo = sc.nextLine();
						if(NomMetodo.equals("")) {
							System.out.println("Debe ingresar un nombre al metodo");
							NomMetodo = "";
						}
					}while(NomMetodo.equals(""));
					
					String AcceMetodo = "";
					System.out.println("Ingrese Acceso del metodo (public, private, protected)");
					do {
						AcceMetodo = sc.nextLine();
						if(!AcceMetodo.toLowerCase().equals("public") && !AcceMetodo.toLowerCase().equals("private") && !AcceMetodo.toLowerCase().equals("protected")) {
							System.out.println("Debe ingresar un Acceso valido al metodo");
							AcceMetodo = "";
						}
					}while(!AcceMetodo.toLowerCase().equals("public") && !AcceMetodo.toLowerCase().equals("private") && !AcceMetodo.toLowerCase().equals("protected"));
					
					String tipMetodo = "";
					System.out.println("Ingrese tipo de dato del metodo (string, int, boolean, char, double, short, long, float)");
					do {
						tipMetodo = sc.nextLine();
						if(!tipMetodo.toLowerCase().equals("string")&&!tipMetodo.toLowerCase().equals("int")&&!tipMetodo.toLowerCase().equals("boolean")&&!tipMetodo.toLowerCase().equals("char")&&!tipMetodo.toLowerCase().equals("double")&&!tipMetodo.toLowerCase().equals("short")&&!tipMetodo.toLowerCase().equals("long")&&!tipMetodo.toLowerCase().equals("float")) {
							System.out.println("Debe ingresar un tipo para el metodo (string, int, boolean, char, double, short, long, float)");
							tipMetodo = "";
						}
					}while(tipMetodo.equals(""));
					
					String ConfirmParametro = "";
					do {
						System.out.println("Desea agregar Parametro al Metodo? S=SI/N=NO");
						ConfirmParametro = sc.nextLine();
						switch(ConfirmParametro.toUpperCase()) {
						case "S":
							Variable Param;
							String NomParametro = "";
							System.out.println("Ingrese nombre del parametro");
							do {
								NomParametro = sc.nextLine();
								if(NomParametro.equals("")) {
									System.out.println("Debe ingresar un nombre para el parametro");
									NomParametro = "";
								}
							}while(NomParametro.equals(""));
							
							String TipParametro = "";
							System.out.println("Ingrese Tipo de dato del parametro (string, int, boolean, char, double, short, long, float)");
							do {
								TipParametro = sc.nextLine();
								if(!TipParametro.toLowerCase().equals("string")&&!TipParametro.toLowerCase().equals("int")&&!TipParametro.toLowerCase().equals("boolean")&&!TipParametro.toLowerCase().equals("char")&&!TipParametro.toLowerCase().equals("double")&&!TipParametro.toLowerCase().equals("short")&&!TipParametro.toLowerCase().equals("long")&&!TipParametro.toLowerCase().equals("float")) {
									System.out.println("Debe ingresar un tipo de dato valido para el parametro (string, int, boolean, char, double, short, long, float)");
									TipParametro = "";
								}
							}while(TipParametro.equals(""));
								Param = new Variable(NomParametro,TipParametro,false,"");
								parametro.add(Param);
								
							break;
						case "N":
							break;
						default:
							System.out.println("Debe seleccionar un dato de confirmacion valido S/N");
						}
					}while(!ConfirmParametro.toUpperCase().equals("N") );
						metodo = new Metodo(NomMetodo,tipMetodo,AcceMetodo,parametro);
						clases.get(selecClassMetodo-1).AddMetodo(metodo);
						System.out.println("Metodo agregado correctamente");
					System.out.println("____________________________________\n");
					break;
				//__________________________________________________________________________________________________________________
				case 4://ELIMINA CLASES
					boolean existeClass = false;
					if(clases.size()>0) {
						existeClass = true;
						for(int i = 0; i<clases.size();i++) {
							int pocision = i + 1;
							System.out.println(pocision+". "+clases.get(i).Acceso+" "+clases.get(i).Nombre+"\n");
						}
					}else {
						System.out.println("No existen Clases ingresadas");
						existeClass = false;
					}
					int selecClassElimina = 0;
					if(existeClass) {
						do {
							System.out.println("Seleccione la clase por su ID");
							selecClassElimina = sc.nextInt();
							for(int i = 0; i<clases.size();i++) {;
								if(clases.get(selecClassElimina-1) != null) {
									System.out.println("Clase Seleccionada: "+clases.get(selecClassElimina-1).Nombre);
								}else {
									System.out.println("La posicion ingresada no existe");
									selecClassElimina = 0;
								}
							}
						}while(selecClassElimina == 0);
						String ConfirmaElimina = "";
						System.out.println("Confirmar eliminar clase "+clases.get(selecClassElimina-1).Nombre);
						do {
							ConfirmaElimina = sc.nextLine();
							if(ConfirmaElimina.toUpperCase().equals("S")) {
								clases.remove(selecClassElimina-1);
								System.out.println("Clase eliminada");
							}else if(!ConfirmaElimina.toUpperCase().equals("N")) {
								System.out.println("Debe seleccionar un dato de confirmacion valido S/N");
							}
						}while(!ConfirmaElimina.toUpperCase().equals("S") && !ConfirmaElimina.toUpperCase().equals("N"));
					}
					break;
				//__________________________________________________________________________________________________________________
				case 5://ELIMINA VARIABLES
					if(clases.size()>0) {
						for(int i = 0; i<clases.size();i++) {
							int pocision = i + 1;
							System.out.println(pocision+". "+clases.get(i).Acceso+" "+clases.get(i).Nombre+"\n");
						}
						int selecVariableClass = 0;
						do {
							System.out.println("Seleccione la clase por su ID");
							selecVariableClass = sc.nextInt();
							for(int i = 0; i<clases.size();i++) {;
								if(clases.get(selecVariableClass-1) != null) {
									System.out.println("Clase Seleccionada: "+clases.get(selecVariableClass-1).Nombre);
								}else {
									System.out.println("La posicion ingresada no existe");
									selecClassElimina = 0;
								}
							}
						}while(selecVariableClass == 0);
						
						int SelecvarClassElimina = 0;
						for(int i = 0; i < clases.get(selecVariableClass-1).Var.size();i++) {
							System.out.println(clases.get(selecVariableClass-1).ListVariables());
						}
						System.out.println("Seleccionae la variable por su ID");
						do {
						SelecvarClassElimina = sc.nextInt();
						if(clases.get(selecVariableClass-1).Var.get(SelecvarClassElimina-1) != null) {
							clases.get(selecVariableClass-1).Var.remove(SelecvarClassElimina-1);
							clases.get(selecVariableClass-1).startConstructor();
							System.out.println("Variable eliminado de la clase "+clases.get(selecVariableClass-1).Nombre);
						}else {
							System.out.println("No existe varaible con el ID ingresado en la clase "+clases.get(selecVariableClass-1).Nombre);
							SelecvarClassElimina = 0;
						}
						}while(SelecvarClassElimina == 0);
					}else {
						System.out.println("No existen Clases ingresadas");
					}
					
					break;
				//__________________________________________________________________________________________________________________
				case 6://ELIMINA METODOS
					if(clases.size()>0) {
						for(int i = 0; i<clases.size();i++) {
							int pocision = i + 1;
							System.out.println(pocision+". "+clases.get(i).Acceso+" "+clases.get(i).Nombre+"\n");
						}
						int selecMetodoClass = 0;
						do {
							System.out.println("Seleccione la clase por su ID");
							selecMetodoClass = sc.nextInt();
							for(int i = 0; i<clases.size();i++) {;
								if(clases.get(selecMetodoClass-1) != null) {
									System.out.println("Clase Seleccionada: "+clases.get(selecMetodoClass-1).Nombre);
								}else {
									System.out.println("La posicion ingresada no existe");
									selecClassElimina = 0;
								}
							}
						}while(selecMetodoClass == 0);
						System.out.println(clases.get(selecMetodoClass-1).ListMetodos());
						int SelecMetodoClassElimina = 0;
						do {
							SelecMetodoClassElimina = sc.nextInt();
							if(clases.get(selecMetodoClass).Met.get(SelecMetodoClassElimina-1) != null) {
								clases.get(selecMetodoClass).Met.remove(SelecMetodoClassElimina);
								System.out.println("Metodo Eliminado Correctamente");
							}else {
								System.out.println("No existe metodo con el ID ingresado");
							}
						}while(SelecMetodoClassElimina == 0);
					}else {
						System.out.println("No existen Clases ingresadas");
					}
					
					break;
				//__________________________________________________________________________________________________________________
				case 7://LISTAR CLASES
					if(clases.size()>0) {
						for(int i = 0; i<clases.size();i++) {
							System.out.println("_________________________________________________________________________\n");
							System.out.println(clases.get(i).ListarClassJAVA());							
							System.out.println("_________________________________________________________________________\n");
						}
					}else {
						System.out.println("No existen Clases ingresadas");
					}
					break;
				//__________________________________________________________________________________________________________________
				case 8://VOLVER AL MENU PRINCIPAL
					break;
				default:
					System.out.println("Debe seleccionar una opcion valida");
					menuclase = 0;
				}
				System.out.println("\n=======================================\n");
				}while(menuclase!=8);
				break;
			//========================================================================================================================================
			case 3://LISTAR CLASES EN FORMATO
				if(clases.size()>0) {
					for(int i = 0; i<clases.size();i++) {
						int pocision = i + 1;
						System.out.println(pocision+". "+clases.get(i).Acceso+" "+clases.get(i).Nombre+"\n");
					}
				}else {
					System.out.println("No existen Clases ingresadas");
				}
				int selectListarClass = 0;
				do {
					selectListarClass = sc.nextInt();
					if(clases.get(selectListarClass-1) != null) {
						int SelectFormato = 0;
						System.out.println("Elija el formato de impresion");
						System.out.println("1. PHP");
						System.out.println("2. C++");
						System.out.println("3. JavaScript");
						System.out.println("4. JAVA");
						do {
						SelectFormato = sc.nextInt();
						if(SelectFormato <= 0 && SelectFormato >4) {
							System.out.println("Debe seleccionar una opcion valida");
							SelectFormato = 0;
						}else {
							switch(SelectFormato) {
							case 1://PHP
								System.out.println("_________________________________________________________________________\n");
								System.out.println(clases.get(selectListarClass-1).ListarClassPHP()+"\n");
								System.out.println("_________________________________________________________________________\n");
								break;
							case 2://C++
								System.out.println("_________________________________________________________________________\n");
								System.out.println(clases.get(selectListarClass-1).ListarClassC()+"\n");
								System.out.println("_________________________________________________________________________\n");
								break;
							case 3://JAVASCRIPT
								System.out.println("_________________________________________________________________________\n");
								System.out.println(clases.get(selectListarClass-1).ListarClassJS()+"\n");
								System.out.println("_________________________________________________________________________\n");
								break;
							case 4://JAVA
								System.out.println("_________________________________________________________________________\n");
								System.out.println(clases.get(selectListarClass-1).ListarClassJAVA()+"\n");
								System.out.println("_________________________________________________________________________\n");
								break;
							default:
							}
						}
						}while(SelectFormato == 0);
					}else {
						System.out.println("No Existe clase con el ID ingresado");
					}
				}while(selectListarClass == 0);
				break;
			//========================================================================================================================================
			case 4://SALIR
					System.out.println("Adios vuelva pronto.");
				break;

			default:
				System.out.println("Debe seleccionar una opcion valida");
				menuPrincipal = 0;
			}
		
		}while(menuPrincipal != 4);	
		
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
		System.out.println(clasesEjem.get(0).ListaConstructorJAVA());
		System.out.println("\n");
		System.out.println(clasesEjem.get(0).ListStringMetodos()+"\n}");
	}
	
	public static String MenuPrincipal() {
		String retorno = "";
		retorno += "Menu Principal \n";
		retorno +="Seleccione una opcion \n";
		retorno +="1. Ejecutar ejemplo de clase formato standar java \n";
		retorno +="2. Agregar o eliminar clase \n";
		retorno +="3. Listar Clase en formato \n";
		retorno +="4. Salir \n";
		return retorno;
	}
	
	public static String MenuClases(boolean ExisteClase) {
		String retorno = "";
		retorno += "Menu Clases \n";
		retorno +="Seleccione una opcion \n";
		retorno +="1. Agregar Nueva Clase \n";
		if(ExisteClase) {
			retorno +="2. Agregar Variables a una Clase\n";
			retorno +="3. Agregar Metodos a una Clase\n";
			retorno +="4. Eliminar una Clase \n";
			retorno +="5. Eliminar Variables de una Clase \n";
			retorno +="6. Eliminar Metodos de una Clase\n";
			retorno +="7. Listar Clases \n";
		}
		retorno +="8. Volver al Menu Principal \n";
		return retorno;
		
	}
	


}
