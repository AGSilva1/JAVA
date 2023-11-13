import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {

		int menu = 0;
		Scanner sc = new Scanner(System.in);
		do {
			Televisor tv = new Televisor();
			CamaraIp cam = new CamaraIp();
			double valor = 0;
			String marca = "";
			String modelo = "";
			boolean esdouble = true;
			System.out.println("Ingreso de Artefacto");
			System.out.println("Seleccione Artefacto que desee ingresar");
			System.out.println("1. Televisor \n 2. Camara IP");
			menu = sc.nextInt();
			
			switch(menu) {
			case 1:
					Integer pulgadas = 0;
					boolean smart = true;
					String ValorSmart = "";
					String Cable = "";
					
					do {
						System.out.println("Ingrese Marca");
						marca = sc.next();
					}while(!tv.ValidaMarca(marca));
					
					do {
						System.out.println("Ingrese Modelo");
						modelo = sc.next();
					}while(!tv.ValidaModelo(modelo));
					
					do {
						System.out.println("Ingrese Pulgadas");
						pulgadas = sc.nextInt();
					}while(!tv.ValidaPulgadas(pulgadas));
					
					do {
						System.out.println("Indique si es smart o no");
						ValorSmart = sc.next();
					}while(!tv.ValidaSmart(ValorSmart));
					
					do {
						System.out.println("Ingrese Nombre empresa Cable");
						Cable = sc.next();
					}while(!tv.ValidaEmpresaCable(Cable));
					
					do {
						esdouble = true;
						try {
							System.out.println("Ingrese valor en US");
							valor = sc.nextDouble();
						}catch(Exception e) {
							esdouble = false;
							System.out.println("El valor de double con separacion de decimal con ,");
							sc.nextLine();
						}
					}while(!esdouble || !tv.ValidaValor(valor, true));
					
					if(ValorSmart == "S") {
						smart = true;
					}else {
						smart = false;
					}
					
					Televisor tvIngresa = new Televisor(marca, modelo, valor, pulgadas, smart, Cable);
					System.out.println("===================================\n\n");
					System.out.println(tvIngresa.toString());
					System.out.println("\n\n===================================\n\n");
					
				break;
			case 2:
				String codigo = "";
				Integer giro = 0;
				double pixeles = 0;
				double alcance = 0;
				String palabra1 = "";
				String palabra2 = "";
				do {
					System.out.println("Ingrese Marca");
					marca = sc.next();
				}while(!cam.ValidaMarca(marca));
				
				sc.nextLine();
				
				do {				
					System.out.println("Ingrese Modelo");
					modelo = sc.nextLine();
					if(modelo.indexOf(" ")!= -1) {
						String[] partes = modelo.split(" ");
						palabra1 = partes[0];
						palabra2 = partes[1];
					}
				}while(!cam.ValidaModelo(palabra1, palabra2));
				
				do {
					System.out.println("Ingrese Codigo");
					codigo = sc.next();
				}while(!cam.ValidaCodigo(codigo));
				
				do {
					System.out.println("Indique el giro de la camara");
					giro = sc.nextInt();
				}while(!cam.ValidaGiro(giro));
				
				do{
					esdouble = true;
					try {
					System.out.println("Indique la resolucion en pixeles");
					pixeles = sc.nextDouble();
					}catch(Exception e) {
						esdouble = false;
						System.out.println("El valor de double con separacion de decimal con ,");
						sc.nextLine();
					}
				}while(!esdouble || !cam.ValidaPixeles(pixeles));
				
				do {
					esdouble = true;
					try {
						System.out.println("Indique el alcance de conexion Wifi");
						alcance = sc.nextDouble();
					}catch(Exception e) {
						esdouble = false;
						System.out.println("El valor de double con separacion de decimal con ,");
						sc.nextLine();
					}
				}while(!esdouble || !cam.validaAlcance(alcance));
				
				do {
					esdouble  = true;
					try {
					System.out.println("Ingrese valor en UF");
					valor = sc.nextDouble();
					}catch(Exception e) {
						esdouble = false;
						System.out.println("El valor de double con separacion de decimal con ,");
						sc.nextLine();
					}
				}while(!esdouble || !cam.ValidaValor(alcance, false));
				
				CamaraIp camIngresa = new CamaraIp(codigo, giro, pixeles, alcance, marca, modelo, valor);
				
				System.out.println(camIngresa.toString());
				
				break;
				
			}
			
		}while(menu != 9);

	}

}
