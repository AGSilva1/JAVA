
public class CamaraIp extends Artefacto {
	
	String Codigo;
	Integer Giro;
	double MegaPixeles;
	double AlcanzeWifi;
	
	public CamaraIp() {
		
	}
	
	public CamaraIp(String codigo, Integer giro, double pixeles, double alcanze, String marca, String modelo, double valor) {
		super(marca, modelo, valor);
		this.Codigo = codigo;
		this.Giro = giro;
		this.MegaPixeles = pixeles;
		this.AlcanzeWifi = alcanze;
	}
	
	public boolean ValidaCodigo(String cod) {
		
		
		return true;
		
	}
	
	public boolean ValidaGiro(int grado) {
		
		if(grado < 0 && grado > 360) {
			System.out.println("El giro de la camara debe ser entre 0 y 360 grados");
			return false;
		}
		
		return true;
		
	}
	
	public boolean ValidaPixeles(double pixel) {
		
		if(pixel < 5.0 && pixel >16.3) {
			System.out.println("Los megapixeles de la camara deben ser entre 5.0 y 16.3");
			return false;
		}
		return true;
		
	}
	
	public boolean validaAlcance(double metros) {
		
		if(metros < 3 && metros > 14) {
			System.out.println("Los metros de alcance del Wifi de la camara debe ser entre 3 y 14 metros");
			return false;
		}
		return true;
		
	}
	
	
}
