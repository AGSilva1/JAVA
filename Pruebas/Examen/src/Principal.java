import java.util.Scanner;

public class Principal {

	//Variable almacenadora de la sopa de letras en una matriz de [7][7]. Solo para lectura
	private static final char[][] sopa = {{'X', 'M', 'A', 'N', 'T', 'I', 'J', 'E'},
	        {'G', 'U', 'S', 'A', 'S', 'U', 'H', 'O'},
	        {'M', 'A', 'N', 'Z', 'A', 'N', 'A', 'R'},
	        {'E', 'N', 'T', 'O', 'N', 'E', 'L', 'M'},
	        {'L', 'B', 'O', 'A', 'D', 'R', 'V', 'E'},
	        {'O', 'G', 'F', 'W', 'I', 'G', 'E', 'I'},
	        {'N', 'T', 'U', 'V', 'A', 'Z', 'R', 'Y'},
	        {'U', 'V', 'E', 'R', 'L', 'O', 'M', 'E'}};
	
	public static void main(String[] args) {
		
		//Instancia lectura de plabra a ingresar
		Scanner sc = new Scanner(System.in);
		
		//Muestra Menu de la Sopa incluyendo la sopa
		MuestraSopa();
		
		//Mientras sea true se hara...
		while(true) {
			
			//Solicita e ingresa palabra o salir para salir.
			System.out.println("Ingrese la palabra que encontro o 'salir' para terminar.\n");
			String palabra = sc.nextLine().toUpperCase();
			
			//Si la palabra ingresa es salir se termina el ciclo
			if(palabra.equals("SALIR")) {
				break;
			}
			
			//Si no se encuentra la Palabra se mostrara mensaje. 
			if(!BuscarPalabra(palabra)) {
				System.out.println("La palabra ingresada "+palabra+" no existe en la sopa de letras");
			}
			
		}
		System.out.println("====================================================\n");
		System.out.println("Adios.");
		sc.close();
	}
	//Muestra en consola la sopa de letras.
	private static void MuestraSopa() {
		System.out.println("SOPA DE LETRAS");
		System.out.println("=====================================================");
		String vista  = "";
		//Recorre matriz[7][7] mostrandola en consola
		for( char[] linea : sopa) {
			for(char c : linea) {
				vista += c+" ";
			}
			vista += "\n";
		}
		System.out.println(vista);
	}
	
	//Recorre la sopa (matriz[7][7]).
	private static boolean BuscarPalabra(String pa) {
		
		//Recorre cada linea
		for(int linea = 0; linea < sopa.length; linea++) {
			//Recorreo cada posicion de la linea
			for(int fila = 0; fila < sopa[linea].length; fila++) {
				//Analiza palabra en la utilizando como guia la coordenada(linea, fila) en la sopa, si es la palabra termina la funcion retornando true.
				if(BuscaxPosicion(pa, linea, fila)) {
					return true;
				}
			}
		}
		//Si no encontro la palabra dentro de la sopa retornara false.
		return false;
	}
	
	//
	private static boolean BuscaxPosicion(String palabra, int x, int y) {
		//inicia arreglos de valores para calcular posicionamiento de linea y fila de la palabra en la sopa
		int[] distancialinea = {-1, -1, -1, 0, 0, 1, 1, 1};
		int[] distanciafila = {-1, 0, 1, -1, 1, -1, 0, 1};
		
		//Recorre distancialinea para obtener posicion de la linea y la fila en la sopa
		for(int direccion = 0;direccion < distancialinea.length; direccion++ ) {
			int linea = x;
			int fila = y;
			int index;
			
			//Recorre palabra para analizarla con la posicion actual de la sopa y obtener la posicion final
			for(index = 0; index < palabra.length(); index++) {
				
				//Valida si ya no queda posicion de linea o si ya no queda posicion de fila o si la posicion actual de la sopa es distinta a la letra recorrida de la termina ciclo for
				if(linea < 0 || linea >= sopa.length || fila < 0 || fila >= sopa.length || sopa[linea][fila] != palabra.charAt(index)) {
					break;
				} 
				 //Guarda el valor del calculo de la posicion final de la sopa de letras 
				fila += distanciafila[direccion];
				linea += distancialinea[direccion];
				
			}
			
			//Si se logro recorrer toda la palabra dentro de la sopa se mostrara posicion inicial y posicion final.
			if(index == palabra.length()) {
				System.out.println("La Palabra ingresada " + palabra + " existe, y se encuntra en la posición["
                        + x + ", " + y + "] y finaliza en la posición ["
                        + (linea - distancialinea[direccion]) + ", " + (fila - distanciafila[direccion]) + "].");
                return true;
			}
			
		}
		//Si no logro recorrer toda la palabra se retornara false para continuar con la siguiente posicion guia de la sopa
		return false;
		
	}

}
