import java.io.*;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;
		FileWriter fichero = null;
		PrintWriter pw = null;
		
		Recorrido trayecto = null;
		Pasajero pj = null;
		int opcion = 0;
		Scanner sc = new Scanner(System.in);
		
		do {
			System.out.println("Sistema Recorrido U3\n");
			System.out.println("==================================\n");
			System.out.println("Seleccione su opcion:\n");
			System.out.println("1. Iniciar Recorrido del Bus\n");
			System.out.println("9. Salir del Sistema\n");
			opcion = sc.nextInt();
			sc.next();
			
			if(opcion != 9) {
				//Lee archivo1
				try {
					archivo = new File("C:\\datosBus.txt");
					fr = new FileReader(archivo);
					br = new BufferedReader(fr);
					String linea;
					while((linea=br.readLine())!= null) {
						System.out.println(linea);
						if(linea.indexOf(";")> 0) {
							trayecto.IniciarRecorrido(linea.split(";")[0], linea.split(";")[1]);
						}
					}
					System.out.println("Comienza su Recorrido el bus.\n Patente: "+trayecto.Patente+"\n Chofer: "+trayecto.Conductor+"\n");
					
				}catch(Exception e) {
					e.printStackTrace();
				}finally {
					try {
						if(null != fr) {
							fr.close();
						}
					}catch(Exception e) {
						e.printStackTrace();
					}
				}
				
				//Lee archivo2
				try {
					archivo = new File("C:\\primeraSubidaBus.txt");
					fr = new FileReader(archivo);
					br = new BufferedReader(fr);
					String linea;
					while((linea=br.readLine())!= null) {
						System.out.println(linea);
						if(linea.indexOf(";")> 0) {
							//pj = new Pasajero();
							trayecto.Numero[Integer.parseInt(linea.split(";")[0]) - 1].Subir(null, Integer.parseInt(linea.split(";")[0]) - 1);
						}
					}
					
				}catch(Exception e) {
					e.printStackTrace();
				}finally {
					try {
						if(null != fr) {
							fr.close();
						}
					}catch(Exception e) {
						e.printStackTrace();
					}
				}
				
			}else {
				System.out.println("Good Bye");
			}
			
		}while(opcion != 9);
		

		
		//Escribe en el archivo
		try {
			
			fichero = new FileWriter("C:\\ultimaBajadaBus.txt");
			pw = new PrintWriter(fichero);
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
			try {
				if(null != fichero) {
					fichero.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		
	}

}
