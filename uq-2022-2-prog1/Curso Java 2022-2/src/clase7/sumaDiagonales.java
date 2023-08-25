package clase7;

import esen.*;

public class sumaDiagonales {
	public static int[][] generarMatriz2D(int filas, int columnas){
		int matriz2D[][] = new int [filas][columnas];
		for (int i = 0;i<filas;i++) {
			for (int j = 0;j<columnas;j++) {
				matriz2D[i][j] = cial.leerInt("Ingrese un numero (["+i+"]["+j+"]):");
			}
		}
		return matriz2D;
	}
	public static String generarRes(int filas,int columnas) {
		int matriz[][] = generarMatriz2D(filas,columnas);
		int diagPrincipal = 0;
		int diagSecundaria = 0;
		for (int i = 0;i<filas;i++) {
			for (int j = 0;j<columnas;j++) {
				if(i==j) diagPrincipal+=matriz[i][j];
			}
		}
		for (int i = 0;i<filas;i++) {
			int pos = 0;
			for (int j = columnas-1;j>=0;j--) {
				if(i==pos) diagSecundaria+=matriz[i][j];
				pos++;
			}
		}
		String res = "Son iguales";
		if (diagPrincipal<diagSecundaria) res = "La principal es menor que la secundaria";
		if (diagPrincipal>diagSecundaria) res = "La principal es mayor que la secundaria";
		return res;
	}

	public static void main(String[] args) {
		int f = cial.leerInt("Ingrese la cantidad de filas de la matriz");
		int c = cial.leerInt("Ingrese la cantidad de columnas de la matriz");

		String msg = generarRes(f,c);
		cial.imprimir(msg);
	}
}
