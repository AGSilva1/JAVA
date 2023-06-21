import java.util.Random;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Alumno[] curso;
        Random random = new Random();
        float sumaGeneral = 0;
        
        curso = new Alumno[5];
        curso[0] = new Alumno("Josefa", "1-9", 3);
        curso[1] = new Alumno("Camila", "2-7", 3);
        curso[2] = new Alumno("Pedro", "3-5", 3);
        curso[3] = new Alumno("Rodrigo", "4-3", 3);
        curso[4] = new Alumno("Juana", "5-1", 3);
        
        for (int i = 0; i < 5; i++) {
        	for (int j = 0; j < 3; j++)
        		curso[i].agregaNota(j, random.nextInt(60)/10+1);
        	System.out.println(curso[i].libroClases());
        	sumaGeneral += curso[i].promedio();
        }
        System.out.println("Promedio del Curso: " + Float.toString(sumaGeneral/5));
	}

}
