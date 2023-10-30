
public class Bus {
	
	String Patente;
	String Conductor;
	Pasajero[] Cliente = new Pasajero[20];
	
	public Bus() {
		
	}
	
	public Bus(String pat, String cond, Pasajero pas, Integer Ass) {
		this.Patente = pat;
		this.Conductor = cond;
		this.Cliente[Ass] = pas;
	}
	
}
