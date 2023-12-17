
public class Liga {
	
	public String Nombre;
	public Partido[] partidos;
	
	public Liga(String nom, Partido part1, Partido part2, Partido part3, Partido part4) {
		this.Nombre = nom;
		this.partidos = new Partido[4];
		this.partidos[0] = new Partido(part1.resultado);
		this.partidos[1] = new Partido(part2.resultado);
		this.partidos[2] = new Partido(part3.resultado);
		this.partidos[3] = new Partido(part3.resultado);
	}

}
