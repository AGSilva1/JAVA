
import java.lang.reflect.Array;
import java.util.regex.*;

public class Artefacto {

	String Marca;
	String Modelo;
	double Valor;
	
	public Artefacto() {
		
	}
	
	public Artefacto(String marca, String modelo, double valor) {		
		this.Marca = marca;
		this.Modelo = modelo;
		this.Valor = valor;
	}
	
	public boolean ValidaModelo(String codigo) {
		
		char Caracteres[] = codigo.toCharArray();
		char vocales[] = {'A', 'E', 'i', 'O', 'U'};
		if(Caracteres.length != 6) {
			System.out.println("El Modelo debe poseer exactamente 6 caracteres alfanumericos");
			return false;
		}

		boolean ValidaSiete = false;
		int suma = 0;
		for(int a = 0; a <= 5; a++) {
				
			if(a >= 2) {
				if(!Character.isDigit(Caracteres[a])) {
					System.out.println("El formato del modelo no coincide, los ultimos 4 digitos deben ser solo numeros");
					return false;
				}else {
					
					if(a == 2) {
						if(Character.getNumericValue(Caracteres[a]) == 0) {
							System.out.println("El tercer caracter debe ser numero entero mayor a 0");
							return false;
						}
					}
					if(Character.getNumericValue(Caracteres[a]) == 7) {
						
						ValidaSiete = true;
					}
					suma += Character.getNumericValue(Caracteres[a]);
				}
			}else {
				for(int v = 0; v < 5; v ++) {
					if(Caracteres[a] == vocales[v]) {	
						System.out.println("El formato del modelo no coincide, los primeros dos caracteres deben consonantes distintos");
						return false;
					}
				}
				if(a == 1) {
					if(Caracteres[a] == Caracteres[0]) {
						System.out.println("El segundo caracter del modelo no debe ser identico al primero, consonantes distintos");
						return false;
					}
				}
			}
				
				
		}
			
			if(ValidaSiete == false) {
				System.out.println("En los ultimos 4 caracteres del modelo debe incluir al menos el numero 7 una vez");
				return false;
			}
			
			if(suma > 20) {
				System.out.println("La suma de los ultimos 4 caracteres (numericos) deben ser menor a 21");
				return false;
			}

		return true;
		
	}
	
	public boolean ValidaModelo(String Palabra1, String Palabra2) {
		
		char excluidos[] = {'H', 'W', 'F', 'h', 'w', 'f'};
		char letter[] = Palabra2.toCharArray();
		
		if(!Palabra1.equals("Interior") && !Palabra1.equals("Exterior")) {
			System.out.println("La primera seccion del modelo debe ser Interior o Exterior. Ej: 'Interior XXXXXXX'");
			return false;
		}
		
		if(Palabra2.length() > 7) {
			System.out.println("La segunda seccion del modelo puede ser de largo maximo de 7 Caracteres. Ej: 'Exterior XXXXXXX'");
			return false;
		}
		
		
		
		for(int i = 0; i < 7; i++ ) {
			for(int j = 0; j < 6; i++) {
				if(letter[i] == excluidos[j]) {
					System.out.println("La segunda seccion del modelo no puede incluir las siguientes letras {'H', 'W', 'F', 'h', 'w', 'f'}");
					return false;
				}
			}
		}
		
		
		return true;
		
	}

	public boolean ValidaMarca(String marca) {
		
		char Caracteres[] = marca.toCharArray();
		
		return true;
		
	}
	
	
	public boolean ValidaValor(double monto, boolean esTV) {

		if(esTV == true) {		
			if(monto > 1000) {
				System.out.println("El valor del artefacto no debe ser mayor a $1000 US");
				return false;
			}			
		}else {
			if(monto > 100) {
				System.out.println("El valor del artefacto no debe ser mayor a $100 US");
				return false;
			}
		}
		
		return true;
		
	}
	
}
