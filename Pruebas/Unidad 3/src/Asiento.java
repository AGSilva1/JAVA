
public class Asiento extends Pasajero {

	public int Numero;
	public boolean Ocupado;
	
	public Asiento(int num) {
		
		this.Numero = num;
		this.Ocupado = false;
	}

	@Override
	public boolean Subir(Pasajero pas, int numero) {
		if(!this.Ocupado) {
			this.Nombre = pas.Nombre;
			this.Destino = pas.Destino;
			this.ValorP = pas.ValorP;
			this.Ocupado = true;
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean Bajar(Pasajero pas, int numero) {
		
		this.Nombre = "";
		this.Destino = "";
		this.ValorP = 0;
		this.Ocupado = false;
		return true;
		
	}
	
	
	
}
