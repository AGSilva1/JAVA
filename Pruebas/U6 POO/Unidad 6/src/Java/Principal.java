package Java;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("INGRESAR DATOS REFIGERADOR");
		String regexD = "^[0-9]+(\\.[0-9]+){0,1}$";
		String regexI = "[0-9]*";
		
		String marca = "";
		do {
		System.out.println("Ingrese Marca");
		marca = sc.next();
		if(marca.equals("")) {
			System.out.println("Debe ingresar un nombre de Marca");
		}
		}while(marca.equals(""));
		
		String modelo = "";
		do {
		System.out.println("Ingrese Modelo");
		modelo = sc.next();
		if(modelo.equals("")) {
			System.out.println("Debe ingresar un nombre de Modelo");
		}
		}while(modelo.equals(""));
		
		String alto ="";
		do {
		System.out.println("Ingrese Alto (cms)");
		alto = sc.next();
		if(!alto.matches(regexD)) {
			System.out.println("Debe ingresar un numero valido con decimales en (.)");
		}
		}while(!alto.matches(regexD));
		
		String ancho = "";
		do {
		System.out.println("Ingrese Ancho (cms)");
		ancho = sc.next();
		if(!ancho.matches(regexD)) {
			System.out.println("Debe ingresar un numero valido con separacion de decimales(.)");
		}
		}while(!ancho.matches(regexD));
		
		String largo = "";
		do {
		System.out.println("Ingrese Largo (cms)");
		largo = sc.next();
		if(!largo.matches(regexD)) {
			System.out.println("Debe ingresar un numero valido con separacion de decimales(.)");
		}
		}while(!largo.matches(regexD));
		
		String temp = "";
		do {
		System.out.println("Ingrese Temperatura Maxima (celsius)");
		temp = sc.next();
		if(!temp.matches(regexI)) {
			System.out.println("Debe ingresar un numero entero valido");
		}
		}while(!temp.matches(regexI));
		String anio = "";
		do {
		System.out.println("Ingrese cantidad de Años de Garantia");	
		anio = sc.next();
		if(!anio.matches(regexI)) {
			System.out.println("Debe ingresar un numero entero valido");
		}
		}while(!anio.matches(regexI));
		String watts = "";
		do {
		System.out.println("Ingrese Potencia en Watts");
		watts = sc.next();
		if(!watts.matches(regexD)) {
			System.out.println("Debe ingresar un numero valido con separacion de decimales(.)");
		}
		}while(!watts.matches(regexD));
		
		String precio = "";
		do {
		System.out.println("Ingrese Precio Neto");
		precio = sc.next();
		if(!precio.matches(regexI)) {
			System.out.println("Debe ingresar un numero entero valido");
		}
		}while(!precio.matches(regexI));
		
		String radioc = "";
		do {
		System.out.println("Ingrese Radio Cilindro (cms)");
		radioc = sc.next();
		if(!radioc.matches(regexD)) {
			System.out.println("Debe ingresar un numero valido con separacion de decimales(.)");
		}
		}while(!radioc.matches(regexD));
		
		String alturac = "";
		do {
		System.out.println("Ingrese Altura Cilindro (cms)");
		alturac = sc.next();
		if(!alturac.matches(regexD)) {
			System.out.println("Debe ingresar un numero valido con separacion de decimales(.)");
		}
		}while(!alturac.matches(regexD));
		
		
		
		Refigerador refri = new Refigerador(marca, modelo, Double.parseDouble(alto), Double.parseDouble(ancho), Double.parseDouble(largo), Integer.parseInt(anio), Integer.parseInt(precio), Double.parseDouble(temp), Double.parseDouble(watts), Double.parseDouble(radioc), Double.parseDouble(alturac));
		
		System.out.println(refri.Reporte());
		
	}

}
