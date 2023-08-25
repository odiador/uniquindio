package clase7;

import esen.*;

public class primeroFilas {
	public static int[][] generarMatriz2D(int filas, int columnas, String mensaje){
		int matriz2D[][] = new int [filas][columnas];
		for (int j = 0;j<columnas;j++) {
			for (int i = 0;i<filas;i++) {
				matriz2D[i][j] = cial.leerInt(mensaje+" (["+i+"]["+j+"]):");
			}
		}
		return matriz2D;
	}

	public static void main(String[] args) {
		int f = cial.leerInt("Ingrese la cantidad de filas de la matriz");
		int c = cial.leerInt("Ingrese la cantidad de columnas de la matriz");
		int matriz2D[][] = generarMatriz2D(f,c,"Ingrese un numero");
		String msg = cial.deMatrizIntAString(matriz2D);
		cial.imprimir(msg);

	}
}
