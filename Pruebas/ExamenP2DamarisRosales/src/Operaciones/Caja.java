package Operaciones;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

import Interface.CajaAutomatica;

//Realiza acciones que se puede hacer (Leer Productos, Agregar, Comprar, Listar, Archivar Comprar)
public class Caja {


	public List<Compra> operacion = new ArrayList();
	public List<Producto> almacen = new ArrayList();
	private int DocFactura = 1;
	private int DocBoleta = 1;
	
	public static void main(String[] args) {
		
		//Inicia Inteface y muestra pantalla
		CajaAutomatica Ventana = new CajaAutomatica();
		Ventana.setVisible(true);
		
	}
	
	//Ingresa nuevo producto si cumple su requisito (Almacen limite 13 Productos)
	public boolean AddProducto(String nom) {
		//Si la cantidad de Productos almacenados es menor a 13 se Ingresa
		if(almacen.size() < 13) {
			//Recode Productos del Almacen
			for(Producto verp : almacen) {
				//Si Producto existe en Alamcen no se ingresa
				if(verp.GetNombre().toLowerCase().equals(nom.toLowerCase())) {
					return false;
				}
			}
			Random rand = new Random();
			int minimo = 500;
			int maximo = 2000;
			//Obtiene valor Random entre 500 y 2000
			int valor = (int)Math.floor(Math.random() * (maximo - minimo + 1) + minimo);
			//Ingresa Producto
			almacen.add(new Producto(nom, valor, 0 ));
			return true;
		}else {
			return false;
		}
		
	}
	
	//Lee Archivo Productos.txt para ingresar los productos al sistema
	public boolean RellenaInventario() {
		
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			//Encuentra archivo
			archivo = new File("C:\\productos.txt");
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);
			String linea;
			//Lee cada linea del archivo (Formato "nombreproducto;precio\n")
			while((linea=br.readLine())!= null) {
				//Verifica que linea tenga datos
				if(linea.indexOf(";")> 0) {
					if(!linea.split(";")[0].isEmpty() && !linea.split(";")[1].isEmpty()) {
						Producto prod = new Producto(linea.split(";")[0], Integer.parseInt(linea.split(";")[1]), 0);
						almacen.add(prod);
					}
				}
			}
			
			if(almacen == null) {
				return false;
			}else {
				return true;
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}finally {
			try {
				if(null != fr) {
					fr.close();
				}
			}catch(Exception e) {
				return false;
			}
		}
		
	}
	
	//Retorna los productos para su lectura en interface
	public List<Producto> ListaProductos(){
		return almacen;
	}
	
	//Retorna un Producto especifico buscado por su nombre
	public Producto VerProducto(String nom) {

		for(int i = 0; i < almacen.size(); i++) {
			if(almacen.get(i).GetNombre().equals(nom)) {
				
				return almacen.get(i);
				
			}
		}
		
		return null;
		
	}
	
	//Muestra Documento x su Numero y tipo
	public String VerCompraXDoc(int numdoc, int tpoDoc) {
		//Recorre las compras
		for(int i=0; i < operacion.size(); i++) {
			//Si el tipo y numero coincide, retornara un string con los datos de la compra
			if(operacion.get(i).Documento.NroDoc == numdoc && operacion.get(i).Documento.TipoDoc == tpoDoc) {
				return operacion.get(i).VerCompra();
			}
			
		}
		
		return "No existe Compra Relacionada al Número de documento Ingresado";
		
	}
	
	//Agrega una compra
	public boolean AddCompra(List<Producto> prod, int tpdoc) {
		
		
		Compra comp = new Compra();
		String filename = "";
		
		//Ingresa Compra para su manipulacion y validacion
		comp.AddProducto(prod);
		//Segun tipodoc genera el nombre del archivo donde se guardara fisicamente
		if(tpdoc == 33) {
			comp.addPago(tpdoc, DocFactura);
			filename = "Examen\\compraSupermercado_Factura_Nro"+DocFactura+".txt";
			DocFactura++;
		}else {
			comp.addPago(tpdoc, DocBoleta);
			filename = "Examen\\compraSupermercado_boleta_Nro"+DocBoleta+".txt";
			DocBoleta++;
		}
		
		//Ingresa la Compra en la lista de Compras
		operacion.add(comp);
		
		//Archiva Compra
		File archivo = null;
		FileWriter fichero = null;
		PrintWriter pw = null;
		
		try {
			archivo = new File("C:\\Examen");
			if(!archivo.exists()) {
				Files.createDirectory(Paths.get("C:\\Examen"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			archivo = new File("C:\\"+filename);
			fichero = new FileWriter("C:\\"+filename, true);
			fichero.write(operacion.get(operacion.size()-1).VerCompra());
		}catch(Exception e) {
			operacion.remove(operacion.size()-1);
			if(tpdoc == 33) {
				DocFactura--;
			}else {
				DocBoleta--;
			}
			System.out.println("Error al escribir en el fichero");
			return false;
		}finally {
			
			try {
				if(null != fichero) {
					fichero.close();
					//pw.close();
					return true;
				}
			}catch(Exception e) {
				operacion.remove(operacion.size()-1);
				if(tpdoc == 33) {
					DocFactura--;
				}else {
					DocBoleta--;
				}
				System.out.println("Se cayo al cerrar el fichero y su lapiz");
				return false;
			}
			
		}
		
		return true;
	}
	
	//Muestra la ultima compra generada
	public String VerUltimaCompra() {
		
		if(!operacion.isEmpty()) {
		
			return operacion.get(operacion.size()-1).VerCompra();
		
		}else {
		
			return "No hay compras ingresadas";
		
		}
		
	}
	
	//Genera Reporte Consolidado
	public String ReporteConsolidado() {
		
		String retorno = "";
		String filename = "Examen\\consolidadoDiario.txt";
		File archivo = null;
		FileWriter fichero = null;
		PrintWriter pw = null;
		
		try {
			archivo = new File("C:\\"+filename);
			
			if(archivo.exists()) {
				archivo.delete();
			}
			
			fichero = new FileWriter("C:\\"+filename, true);
			List<Producto> ProdAux = new ArrayList();
			//Copia los productos del alamacen en un listado auxiliar para manipular cantidades
			for(int j = 0; j < this.almacen.size(); j++) {
				Producto p = new Producto(this.almacen.get(j).GetNombre(),0,0);
				ProdAux.add(p);
			}
			
			//Instancia totales para el reporte
			int Cantbol = 0;
			int TotValBol = 0;
			int CantFact = 0;
			int TotValFac = 0;
			int TotPuntos = 0;
			
			//Recorre el listado de Compras
			for(int i = 0; i < operacion.size(); i++) {
				//Valida tipo de documento para sumar cantidad generado y totales por tipo
				if(operacion.get(i).Documento.TipoDoc == 33) {
					CantFact++;
					TotValFac += operacion.get(i).Documento.Total;
				}else {
					Cantbol++;
					TotValBol += operacion.get(i).Documento.Total;
				}
				//Suma total de puntos
				TotPuntos += operacion.get(i).Puntos;
				//Recorre los productos de cada compra para identificar cantidades vendidas
				for(int a = 0; a < operacion.get(i).productos.size(); a++) {
					//Recorre listado auxiliar para validar por nombre
					for(int o = 0; o < ProdAux.size(); o++) {
						//Si concuerda en nombre se setea la cantidad sumandola
						if(ProdAux.get(o).GetNombre().equals(operacion.get(i).productos.get(a).GetNombre())) {
							ProdAux.get(o).SetCantidad(ProdAux.get(o).GetCantidad() + operacion.get(i).productos.get(a).GetCantidad());
						}
					}
					
				}
				
			}
			
			retorno += "Boletas Generadas: $"+Cantbol+"\n";
			retorno += "Total Compras con Boletas: $"+TotValBol+"\n";
			retorno += "Facturas Generadas: "+CantFact+"\n";
			retorno += "Total Compras con Facturas: "+TotValFac+"\n";
			retorno += "PRODUCTOS\n---------------------\n";
			
			//instancia producto mas vendio y menos vendido, indexos para el mas vendido y el menos vendido
			Producto MasVendido = null;
			int alto = 0;
			Producto MenosVendido = null;
			int bajo = 99999999;
			
			//Recorre listado auxiliar
			for(int z = 0; z < ProdAux.size(); z++) {
				retorno += "Nombre: "+ProdAux.get(z).GetNombre()+"\n";
				retorno += "Cantidad Vendida: "+ProdAux.get(z).GetCantidad()+"\n";
				//Si la cantidad del producto es mayor al index alto se guarda como mas vendido y toma su cantidad como index alto
				if(ProdAux.get(z).GetCantidad() > alto) {
					alto = ProdAux.get(z).GetCantidad();
					MasVendido = new Producto(ProdAux.get(z).GetNombre(),ProdAux.get(z).GetValor(), ProdAux.get(z).GetCantidad());
				}
				//Si la cantidad del producto es menor al index bajo se guarda como menos vendido y toma su cantidad como index bajo
				if(ProdAux.get(z).GetCantidad() < bajo) {
					bajo = ProdAux.get(z).GetCantidad();
					MenosVendido = new Producto(ProdAux.get(z).GetNombre(),ProdAux.get(z).GetValor(), ProdAux.get(z).GetCantidad());
				}
				if(z < (ProdAux.size()-1)) {
					retorno += "------------------";
				}
			}
			
			retorno += "Producto Mas Vendido: "+MasVendido.GetNombre() + "("+MasVendido.GetCantidad()+" pcs)\n";
			retorno += "Producto Menos Vendido: "+MenosVendido.GetNombre() + "("+MenosVendido.GetCantidad()+" pcs)\n";
			retorno += "Total Puntos Acumulados: "+TotPuntos+"\n";
			retorno += "Total Vendido en el día: $"+(TotValBol+TotValFac);
			//Escribe archivo
			fichero.write(retorno);
		}catch(Exception e) {
			e.printStackTrace();
			return "Error al escribir en el fichero";
		}finally {
			
			try {
				if(null != fichero) {
					fichero.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
				System.out.println("Se cayo al cerrar el fichero y su lapiz");
				return "Se cayo al cerrar el fichero y su lapiz";
			}
			
		}
		
		return retorno;
		
		
	}
	
	
}
