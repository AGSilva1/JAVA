package Operaciones;
import java.util.ArrayList;
import java.util.List;

public class Compra {

	
	public List<Producto> productos;
	public Pago Documento;
	public int Puntos;
	
	public Compra() {
		this.Puntos = 0;
		this.productos = new ArrayList();
	}
	
	//Agrega los productos que se compraran
	public void AddProducto(List<Producto> prod) {
		
		for(int i = 0; i < prod.size(); i++) {
			this.productos.add(prod.get(i));
		}
	
	}
	
	//Agrega Pago de la compra
	public void addPago(int TpDoc, int NroDoc) {
		
		int Neto = 0;
		int Tot = 0;
		double IVA = 0;
		//Recorre productos seleccionados para comprar para obtener el Neto del pago
		for(int i = 0; i < this.productos.size(); i++) {
			System.out.println(this.productos.get(i).GetValor());
			Neto += this.productos.get(i).GetValor()*this.productos.get(i).GetCantidad();
			
		}
		//Obtiene IVA y total
		IVA = Math.round(Neto * 0.19);
		Tot = (int) ((int) Neto + IVA);
		//Si el tipo documento es boleta guarda los puntos
		if(TpDoc == 39) {
			this.Puntos = (int) ((int) Math.round(Tot * 0.02));
		}
		//Ingresa el pago
		this.Documento = new Pago(TpDoc, NroDoc, Neto, Tot, (int) IVA);
		
		
		
	}

	//Muestra la Compra en texto
	public String VerCompra() {
		
		String retorno = "";
		if(this.Documento.TipoDoc == 33) {
			retorno += "Factura N° " + this.Documento.NroDoc + "\n";
		}else {
			retorno += "Boleta N° " + this.Documento.NroDoc + "\n";
		}
		
		for(int i = 0; i < this.productos.size(); i++) {
			
			retorno += this.productos.get(i).VerProducto();
			
			if(i == this.productos.size()-1) {
				retorno += "----------------\n";
			}
		} 
		
		//Si el tipo de documento es Factura desglosa Neto e IVA
		if(this.Documento.TipoDoc == 33) {
		retorno += "Neto $ " + this.Documento.Monto + "\n";
		retorno += "IVA $" + this.Documento.IVA + "\n";
		}
		retorno += "Total(+19%IVA) " + this.Documento.Total + "\n";
		
		//Si el tipo documento es boleta desglosa puntos acumulados
		if(this.Documento.TipoDoc == 39) {
			retorno += "Puntos Acumulados: "+this.Puntos;
		}
		
		return retorno;
		
	}
	
}
