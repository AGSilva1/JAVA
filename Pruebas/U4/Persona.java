
public class Persona {
	protected String nombre;
	private int numero;
	private char digitoVerificador;
	private int validado;
	public Persona(String nombre) {
		this.nombre = nombre;
		this.numero = 0;
		this.validado = 0;
		this.digitoVerificador = '?';
	}
	public String obtieneNumero() {
		String miRut;
		miRut = Integer.toString(this.numero)+'-'+this.digitoVerificador;
		return miRut;
	}
	public void asignaRUT(String rut) {
		rut = rut.toUpperCase(); 
		rut = rut.replace(".", ""); 
		rut = rut.replace("-", ""); 
		this.numero = Integer.parseInt(rut.substring(0, rut.length() - 1));
		this.digitoVerificador = rut.charAt(rut.length()-1);
		this.validado = 0;
	}
	public void validaRUT() {
		int M=0,S=1,T=this.numero;
		for (;T!=0;T/=10) S=(S+T%10*(9-M++%6))%11;
		this.validado = (char)(S!=0?S+47:75) == this.digitoVerificador?1:2;
	}
	public String obtieneDatos() {
		String datos;
		datos = this.nombre + ' ' + this.obtieneNumero();
		if (this.validado > 0) 
datos += "(" + (this.validado==2?"no ":"") + "válido)";
		return(datos);
	}

}
