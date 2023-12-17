package Clases;

public class Apuesta {

	public String resultado;
	
	public Apuesta() {
		
	}
	
	public Apuesta(String ap) {
		this.resultado = ap;
	}
	
	public int ValorApuestaNacional() {
		int valor = 0;
		switch(this.resultado) {
		case "local":
			valor = 110;
			break;
		case "empate":
			valor = 200;
			break;
		case "visita":
			valor = 310;
			break;
			default:
				valor = 0;
		
		}
		return valor;
	}
	
	public int ValorApuestaInternacional() {
		int valor = 0;
		switch(this.resultado) {
		case "local":
			valor = 150;
			break;
		case "empate":
			valor = 240;
			break;
		case "visita":
			valor = 380;
			break;
			default:
				valor = 0;
		
		}
		return valor;
	}
	

}
