import java.io.*;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;
		FileWriter fichero = null;
		PrintWriter pw = null;
		
		Bus bs = new Bus();
		Pasajero pj = new Pasajero();
		//Lee archivo
		try {
			archivo = new File("C:\\XD.txt");
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);
			String linea;
			while((linea=br.readLine())!= null) {
				System.out.println(linea);
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
			
			fichero = new FileWriter("C:\\XD2.txt");
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
