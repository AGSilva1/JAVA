
public abstract class Pasajero  {
	String Nombre;
	String Destino;
	Integer ValorP;
	
	
	public Pasajero() {
		this.Nombre = "";
		this.ValorP = 0;
		this.Destino = "";
	}
	
	public Pasajero(String nom, Integer asi, String dest, Integer val) {
		this.Nombre = nom;
		this.Destino = dest;
		this.ValorP = val;
	}
	
	public abstract boolean Subir(Pasajero pas, int numero);
	
	public abstract boolean Bajar(Pasajero pas, int numero);
	
}
