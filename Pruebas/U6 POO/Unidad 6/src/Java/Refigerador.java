package Java;

public class Refigerador {

	String Marca;
	String Modelo;
	double Alto;
	double Ancho;
	double Largo;
	int Garantia;
	int Precio;
	double TemMax;
	double Watts;
	double RadioC;
	double AltoC;
	
	public Refigerador() {
		
	}
	
	public Refigerador(String marca, String modelo, double alto, double ancho, double largo, int garantia, int precio, double tmm, double watts, double radioc, double altoc) {
		this.Marca = marca;
		this.Modelo = modelo;
		this.Alto = alto;
		this.Ancho = ancho;
		this.Largo = largo;
		this.Garantia = garantia;
		this.Precio = precio;
		this.TemMax = tmm;
		this.Watts = watts;
		this.RadioC = radioc;
		this.AltoC = altoc;
	}
	
	public String Reporte() {
		
		String respuesta = "";
		
		respuesta += "		"+this.Marca+" "+this.Modelo+"\n";
		respuesta += "		"+this.Alto+"(csm) Alto x "+this.Ancho+"(cms) Ancho x "+this.Largo+"(cms) = "+volumenTotal()+"(cms) Volumen Total \n";
		respuesta += "		Temperatura "+this.TemMax+"°C / "+Fahrenheit()+"°F / "+Kelvin()+"K \n";
		respuesta += "		Temperatura Contenedor "+TemperaturaContenedor()+" \n";
		respuesta += "		Volumen Contenedor "+VolumenContenedor()+" \n";
		respuesta += "		Potencia "+this.Watts+" Watts \n";
		respuesta += "		Potencia Morgan "+Morgan()+" \n";	
		
		return respuesta;
		
		
	}
	
	private double Fahrenheit() {
		double respuesta = 0;
			respuesta = (this.TemMax * 1.8) + 32;
		return respuesta;
	}
	
	private double Kelvin() {
		
		double respuesta = 0;
			respuesta = this.TemMax + 273.15;
		return respuesta;
	} 
	
	private double TemperaturaContenedor() {
		double respuesta = 0;
		
		return respuesta;
	}
	
	private double Morgan() {
		double respuesta = 0;
			respuesta = this.Watts;
		return respuesta;
	}
	
	private double volumenTotal() {
		
		double respuesta = 0;
		
		respuesta = this.Alto * this.Ancho * this.Largo;
		
		return respuesta;
		
	}
	
	private double VolumenContenedor() {
		double respuesta = 0;
		
			respuesta = Math.PI * Math.pow(this.RadioC, 2) * this.AltoC;
			
		return respuesta;
	}
	
}
