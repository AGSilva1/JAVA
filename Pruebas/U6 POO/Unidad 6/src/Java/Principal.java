package Java;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("INGRESAR DATOS REFIGERADOR");
		
		
		String marca = "";
		System.out.println("Ingrese Marca");
		marca = sc.next();
		String modelo = "";
		System.out.println("Ingrese Modelo");
		modelo = sc.next();
		double alto = 0;
		System.out.println("Ingrese Alto (cms)");
		alto = sc.nextDouble();
		double ancho = 0;
		System.out.println("Ingrese Ancho (cms)");
		ancho = sc.nextDouble();
		double largo = 0;
		System.out.println("Ingrse Largo (cms)");
		largo = sc.nextDouble();
		double temp = 0;
		System.out.println("Ingrese Temperatura Maxima (celsius)");
		temp = sc.nextDouble();
		int anio = 0;
		System.out.println("Ingrese Años de Garantia");
		anio = sc.nextInt();
		double watts = 0;
		System.out.println("Ingrese Potencia en Watts");
		watts = sc.nextDouble();
		int precio = 0;
		System.out.println("Ingrese Precio Neto");
		precio = sc.nextInt();
		double radioc = 0;
		System.out.println("Ingrese Radio Cilindro (cms)");
		radioc = sc.nextDouble();
		double alturac = 0;
		System.out.println("Ingrese Altura Cilindro (cms)");
		alturac = sc.nextDouble();
		
		Refigerador refri = new Refigerador(marca, modelo, alto, ancho, largo, anio, precio, temp, watts, radioc, alturac);
		
		System.out.println(refri.Reporte());
		
	}

}
