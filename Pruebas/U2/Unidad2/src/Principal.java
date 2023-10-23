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
			System.out.println("Ingreso de Artefacto");
			System.out.println("Seleccione Artefacto que desee ingresar");
			System.out.println("1. Televisor \n 2. Camara IP");
			menu = sc.nextInt();
			
			switch(menu) {
			case 1:
					Integer pulgadas = 0;
					boolean smart = true;
					String ValorSmart = "";
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
					System.out.println("Ingrese valor en US");
					valor = sc.nextDouble();
					}while(!tv.ValidaValor(valor, true));
					
					Televisor tvIngresa = new Televisor(marca, modelo, valor, pulgadas, smart);
					
					tvIngresa.toString();
					
				break;
			case 2:
				String codigo = "";
				Integer giro = 0;
				double pixeles = 0;
				double alcance = 0;
				do {
				System.out.println("Ingrese Marca");
				marca = sc.next();
				}while(!cam.ValidaMarca(marca));
				do {
				System.out.println("Ingrese Modelo");
				modelo = sc.next();
				
				}while(!cam.ValidaModelo(modelo, modelo));
				do {
				System.out.println("Ingrese Codigo");
				codigo = sc.next();
				}while(!cam.ValidaCodigo(codigo));
				do {
				System.out.println("Indique el giro de la camara");
				giro = sc.nextInt();
				}while(!cam.ValidaGiro(giro));
				do{
				System.out.println("Indique la resolucion en pixeles");
				pixeles = sc.nextDouble();
				}while(!cam.ValidaPixeles(pixeles));
				do {
				System.out.println("Indique el alcance de conexion Wifi");
				alcance = sc.nextDouble();
				}while(!cam.validaAlcance(alcance));
				do {
				System.out.println("Ingrese valor en UF");
				valor = sc.nextDouble();
				}while(!cam.ValidaValor(alcance, false));
				
				CamaraIp camIngresa = new CamaraIp(codigo, giro, pixeles, alcance, marca, modelo, valor);
				
				camIngresa.toString();
				
				break;
				
			}
			
		}while(menu != 9);

	}

}
