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
		respuesta += "==============REPORTE REFIGERADOR=================\n";
		respuesta += "Marca: "+this.Marca.toUpperCase()+"\n";
		respuesta += "Modelo: "+this.Modelo.toUpperCase()+"\n";
		respuesta += "Volumen Total "+Math.round(volumenTotal())+"(cms) \n";
		respuesta += "Temperaturas: "+this.TemMax+"°C / "+Fahrenheit()+"°F / "+Kelvin()+"K \n";
		respuesta += "Temperatura Contenedor: "+Math.round(TemperaturaContenedor())+"°C \n";
		respuesta += "Volumen Contenedor: "+Math.round(VolumenContenedor())+"(cms) \n";
		respuesta += "Potencia: "+this.Watts+" Watts \n";
		respuesta += "Potencia Morgan: "+Math.round(Morgan())+" Watts \n";	
		respuesta += "Precio Neto: $"+this.Precio+" \n";	
		respuesta += "Potencia Total: $"+Math.round(this.Precio * 1.19)+" \n";	
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
		double alpha = ((this.Alto * this.Alto + this.Ancho) / this.Largo);
		double t1 = Math.pow(this.TemMax, 3) * Math.sin(Math.toRadians(this.TemMax * Math.PI / 360 + alpha));
		double t2 = Math.cbrt(this.TemMax * this.TemMax) * Math.log(Math.abs(this.TemMax - (this.Alto * this.Ancho) / this.Largo));
		double respuesta = Math.max(t1, t2);
		return respuesta;
	}
	
	private double Morgan() {
		double respuesta = 0;
			respuesta = this.Watts * Math.exp(-this.Garantia / this.Watts);
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
