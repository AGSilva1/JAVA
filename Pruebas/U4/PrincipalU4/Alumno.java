
public class Alumno extends Persona {
  private Notas misnotas;
  public Alumno(String nombre, String rut, int cantidadNotas) {
    super(nombre);
    this.asignaRUT(rut);
    this.validaRUT();
    this.misnotas = new Notas(cantidadNotas);
  }
  public void agregaNota(int i, float nota) {
	  this.misnotas.addNota(i, nota);
  }
  public float promedio() {
	  return (misnotas.promedio());
  }
  public String libroClases() {
	  return( this.obtieneDatos() + " " + this.misnotas.diceNotas());
	  
  }
}
