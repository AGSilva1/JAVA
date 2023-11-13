import java.io.*;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;
		FileWriter fichero = null;
		PrintWriter pw = null;
		
		Recorrido trayecto = null;
		

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
		
		//Lee archivo1
				try {
					archivo = new File("C:\\primeraSubidaBus.txt");
					fr = new FileReader(archivo);
					br = new BufferedReader(fr);
					String linea;
					while((linea=br.readLine())!= null) {
						
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
