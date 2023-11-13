
public class Recorrido implements Bus {
	
	
	public String Patente = "";
	public String Conductor = "";
	public Asiento[] Numero = new Asiento[20];
	

	public Recorrido() {
		
	}
	
	@Override
	public void IniciarRecorrido(String conductor, String patente) {
		this.Patente = patente;
		this.Conductor = conductor;
		for(int i = 0; i < Numero.length;i++) {
			this.Numero[i] = new Asiento(i+1);
		}
	}



	@Override
	public void TerminarRecorrido() {
		 
	}

}


	

