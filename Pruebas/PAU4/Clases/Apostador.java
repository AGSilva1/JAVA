
public class Apostador {
	public String Alias;
	public Apuesta[] Nacional1;
	public Apuesta[] Nacional2;
	public Apuesta[] Internacional;
	
	public Apostador(String nom, Apuesta[] nac1, Apuesta[] nac2, Apuesta[] inter) {
		this.Alias = nom;
		this.Nacional1 = new Apuesta[4];
		this.Nacional2 = new Apuesta[4];
		this.Internacional = new Apuesta[4];
	}
	
	public int ValorTotalApuesta() {
		
		int valor = 0;
		
		return valor;
		
	}
	

}
