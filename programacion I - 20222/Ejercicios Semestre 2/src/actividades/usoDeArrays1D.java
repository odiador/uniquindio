package actividades;
import esen.cial;
public class usoDeArrays1D {
	public static void main(String[] args) {
		int notas[] = new int [5];
		int sumatoria = 0;
		int cantNotas = notas.length;
		for (int i = 0; i<cantNotas;i++) {
			notas[i] = cial.leerInt("Escribe la nota numero "+(i+1));
		}
		for (int i = 0; i<cantNotas;i++) {
			sumatoria+=notas[i];
		}
		cial.imprimir("Suma: "+sumatoria);
	}
}
