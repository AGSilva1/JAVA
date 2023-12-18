package Clases;

public class Apostador {
	public String Alias;
	public Apuesta[] Nacional;
	public Apuesta[] Internacional2;
	public Apuesta[] Internacional;
	public Apuesta[] Internacional3;
	
	public Apostador(String nom, Apuesta[] nac, Apuesta[] inter2, Apuesta[] inter, Apuesta[] inter3) {
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
	

}
