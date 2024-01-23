package Operaciones;


public class Producto {

	private String Nombre;
	private int Valor;
	private int Cantidad;
	
	public Producto(String nom, int val, int cant) {
		this.Nombre = nom;
		this.Valor = val;
		this.Cantidad = cant;
	}
	
	//Retorna Producto como texto
	public String VerProducto() {
		
		String retorno = "";
		retorno += "Product. " + this.Nombre + "\n";
		retorno += "Cant. " + this.Cantidad+" pcs.\n";
		retorno += "Precio. $"+this.Valor + "\n";
		retorno += "SubTot. $" + (this.Cantidad * this.Valor)+"\n";
		return retorno;
		
	}
	
	//Modifica Valor
	public void SetValor(int val) {
		this.Valor = val;
	}
	//Modifica Cantidad
	public void SetCantidad(int cant) {
		this.Cantidad = cant;
	}
	//Obtiene nombre
	public String GetNombre() {
		return this.Nombre;
	}
	//Obtiene valor
	public int GetValor() {
		return this.Valor;
	}
	//Obtiene cantidad
	public int GetCantidad() {
		return this.Cantidad;
	}
	
}
