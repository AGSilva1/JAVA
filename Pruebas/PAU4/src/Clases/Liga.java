package Clases;

public class Liga {
	
	public String Nombre;
	public Partido[] partidos;
	public String Tipo;
	
	public Liga(String nom, String tipo ) {
		this.Nombre = nom;
		this.Tipo = tipo;
		this.partidos = new Partido[4];
		this.partidos[0] = new Partido();
		this.partidos[1] = new Partido();
		this.partidos[2] = new Partido();
		this.partidos[3] = new Partido();
	}
	
	public void addResultados(Partido part1, Partido part2, Partido part3, Partido part4) {
		this.partidos[0] = part1;
		this.partidos[1] = part2;
		this.partidos[2] = part3;
		this.partidos[3] = part4;
	}
	
	
	public String PartidosLiga() {
		String retorno = "";
		retorno += "Liga ("+ this.Tipo + ") "+this.Nombre+"\n";
		retorno += "Resultados: \n";
		for(int i = 0; i < partidos.length; i++) {
			if(partidos[i].resultado.equals("empate")) {
				retorno += "Partido "+i+": Es "+ partidos[i].resultado;
			}else {
				retorno += "Partido "+i+": Ganador "+ partidos[i].resultado;
			}
			
		}
		return retorno;
	}

}
