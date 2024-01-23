package Operaciones;

public class Pago {

	
	public int TipoDoc;
	public int NroDoc;
	public int Monto;
	public int IVA;
	public int Total;
	

	
	public Pago(int tpdoc, int ndoc, int mont, int tot, int iva) {
		
		this.TipoDoc = tpdoc;
		this.NroDoc = ndoc;
		this.Monto = mont;
		this.Total = tot;
		this.IVA = iva;
		
	}
	
	
	
	
}
