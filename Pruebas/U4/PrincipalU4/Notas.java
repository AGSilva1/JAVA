
public class Notas {
  private Float[] notas;
  private int cantidad;
  public Notas(int cantidad) {
	  this.cantidad = cantidad;
	  this.notas = new Float[cantidad];
	  for (int i = 0; i < cantidad; i++)
		  this.notas[i] = (float)1;
  }
  public void addNota(int i, float nota) {
	  if (i < this.cantidad && i >= 0)
		  this.notas[i] = nota;
  }
  public float promedio() {
	  float suma = 0;
	  for (int i = 0; i < this.cantidad; i++) 
		  suma += this.notas[i];
	  return suma/this.cantidad;
  }
  public String diceNotas() {
	  String s = "Notas:";
	  for (Integer i = 0; i < this.cantidad; i++)
		  s += " " + this.notas[i].toString();
	  s += ". Prom:" + Float.toString(this.promedio());
	  return (s);
  }
}
