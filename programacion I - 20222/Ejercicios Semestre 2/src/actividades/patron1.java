package actividades;

import esen.cial;

/*
1  2  3  4  5
6  7  8  9  10
11 12 13 14 15
 */

public class patron1 {

	public static void main(String[] args) {
		int filas, columnas;
		filas = cial.leerInt("Escribe la cantidad de filas");
		columnas = cial.leerInt("Escribe la cantidad de columnas");
		String matriz = generarMatriz (filas, columnas);
		cial.imprimir(matriz);
	}
	public static String generarMatriz (int filas, int columnas) {
		String matriz = "";
		int cantidad = 1;
		for (int i = 0; i<filas;i++) {
			for (int j = 0; j<columnas;j++) {
				matriz += cantidad+" ";
				cantidad++;
			}
			matriz += "\n";
		}
		return matriz;
	}
}
