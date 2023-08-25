package parcial1;
import esen.cial;
public class pregunta3 {
	
	public static void main(String[] args) {
		int n = cial.leerInt("Escribe un numero para genera matriz");
		String matriz = generarMatriz(n);
		cial.imprimir(matriz);
	}
	public static String generarMatriz(int n) {
		String cadena = "";
		for (int i = 0;i<n;i++) {
			for (int j = 0;j<n;j++) {
				if (i>=j) {
					cadena+=((int) Math.pow(i, j))+" ";
				} else {
					cadena += "2 ";
				}
			}
			cadena += "\n";
		}
		return cadena;
	}
}
