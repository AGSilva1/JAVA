
public class Televisor extends
Artefacto {
	Integer Pulgadas;
	boolean SmartTv;
	String EmpresaCable;
	
	public Televisor() {
		
		
	}
	
	public Televisor(String marca, String modelo, double valor, Integer pulgadas, boolean smart, String empresa) { 
		super(marca, modelo, valor); 
		this.Pulgadas = pulgadas;
		this.SmartTv = smart;
		this.EmpresaCable = empresa;
	}
	
	public boolean ValidaPulgadas(int valor) {
		
		if(valor < 32  || valor >55) {
			System.out.println("Las pugadas son desde 32 hasta 55");
			return false;
		}
		
		return true;
		
	}
	
	public boolean ValidaSmart(String valor) {
				
		if(!valor.equals("S") && !valor.equals("N")) {
			System.out.println("Sebe ingresar S = 'Si' o 'N' = No");
			return false;
		}
		
		return true;
	}
	
	public boolean ValidaEmpresaCable(String nombre) {
		
		char c = nombre.charAt(0);
		
		if(!Character.isUpperCase(c)) {
			System.out.println("La primera letra del nombre de la empresa debe ser en mayuscula");
			return false;
		}
		
		if(nombre.length() > 8) {
			System.out.println("El nombre de la empresa no puede contener mas de 8 caracteres");
			return false;
		}
		
		
		return true;
		
	}

	public String toString() {
		String retorno = "";
		
		retorno += "Televisor";
		retorno += "\nMarca: "+ this.Marca;
		retorno += "\nModelo: "+this.Modelo;
		retorno += "\nPulgadas: "+ this.Pulgadas;
		retorno += "\nSmartTV: "+ this.SmartTv;
		retorno += "\nEmpresa Cable: " + this.EmpresaCable;
		retorno += "\nValor US: $" + this.Valor;
		
		return retorno;
	}
}
