package Clases;

public class Apostador {
	public String Alias;
	public Apuesta[] Nacional1;
	public Apuesta[] Nacional2;
	public Apuesta[] Internacional;
	
	public Apostador(String nom, Apuesta[] nac1, Apuesta[] nac2, Apuesta[] inter) {
		this.Alias = nom;
		this.Nacional1 = nac1;
		this.Nacional2 = nac2;
		this.Internacional = inter;
	}
	
	public int ValorTotalApuesta() {
		
		int valor = 0;
		for(int i = 0; i < 4; i++) {
			valor+= Nacional1[i].ValorApuestaNacional();
			valor+= Nacional2[i].ValorApuestaNacional();
			valor+= Internacional[i].ValorApuestaInternacional();
		}
		return valor;
		
	}
	

}
