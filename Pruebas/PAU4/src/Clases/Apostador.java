package Clases;

public class Apostador {
	public String Alias;
	public Apuesta[] Nacional;
	public Apuesta[] Internacional2;
	public Apuesta[] Internacional;
	public Apuesta[] Internacional3;
	
	public Apostador(String nom, Apuesta[] inter, Apuesta[] inter2, Apuesta[] inter3, Apuesta[] nac) {
		this.Alias = nom;
		this.Nacional = nac;
		this.Internacional2 = inter2;
		this.Internacional = inter;
		this.Internacional3 = inter3;
	}
	
	public int ValorTotalApuesta() {
		
		int valor = 0;
		for(int i = 0; i < 4; i++) {
			valor+= Nacional[i].ValorApuestaNacional();
			valor+= Internacional2[i].ValorApuestaInternacional();
			valor+= Internacional[i].ValorApuestaInternacional();
			valor+= Internacional3[i].ValorApuestaInternacional();
		}
		return valor;
		
	}
	
	public String MostrarApuestas() {
		String retorno = "";
		String Inter1 = "Internacional 1: \n";
		String Inter2 = "Internacional 2: \n";
		String Inter3 = "Internacional 3: \n";
		String Nac = "Nacional: \n";
		retorno += "Apuestas\n";
		for(int i = 0; i < 4; i++) {
			Inter1 += "Partido "+ i +": "+ this.Internacional[i].resultado+"\n";
			Inter2 += "Partido "+ i +": "+ this.Internacional2[i].resultado+"\n";
			Inter3 += "Partido "+ i +": "+ this.Internacional3[i].resultado+"\n";
			Nac += "Partido "+ i +": "+ this.Internacional[i].resultado+"\n";
		}
		retorno += Inter1 + Inter2 + Inter3 + Nac;
		return retorno;
	}
	

}
