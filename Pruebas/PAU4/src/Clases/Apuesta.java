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
		case "Local":
			valor = 110;
			break;
		case "Empate":
			valor = 200;
			break;
		case "Visita":
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
		case "Local":
			valor = 150;
			break;
		case "Empate":
			valor = 240;
			break;
		case "Visita":
			valor = 380;
			break;
			default:
				valor = 0;
		
		}
		return valor;
	}
	
	public int GananciaXApuesta(String aposta) {
		int valor = 0;
		switch(aposta) {
		case "Local":
			if(this.resultado.equals(aposta)) {
			valor = 150*2;
			}
			break;
		case "Empate":
			if(this.resultado.equals(aposta)) {
			valor = 240*3;
			}
			break;
		case "Visita":
			if(this.resultado.equals(aposta)) {
			valor = 380*5;
			}
			break;
			default:
				valor = 0;
		
		}
		return valor;
	}
	

}
