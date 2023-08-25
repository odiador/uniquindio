package puntosArreglos;

import javax.swing.JOptionPane;

public class punto07 {
	/*
	 * 21	16 	11 	6 	1
	 * 22	17 	12 	7 	2
	 * 23	18 	13 	8 	3
	 * 24 	19 	14 	9 	4
	 * 25 	20	15 	10 	5
	 */
	//Nota: En la clase AbrirTodos están todos los puntos
	public static void main(String[] args) {
		int cant = 5;
		int[][] matriz = generarMatriz(cant);
		//Imprime la matriz
		imprimirVecInt("La matriz generada es: ",matriz);
	}

	public static int[][] generarMatriz(int cant) {
		int matriz[][] = new int[cant][cant];
		int num = 1;
		//Genera una matriz de arriba a abajo desde la parte de la derecha a la izquierda
		for(int j = cant-1;j>=0;j--) {
			for(int i = 0;i<cant;i++) {
				matriz[i][j] = num;
				num++;
			}
		}
		return matriz;
	}
	//Imprime
	public static void imprimirVecInt (String mensaje,int matriz[][]) {
		mensaje+= "\n";
		for(int i = 0; i<matriz.length;i++) {
			for(int j = 0; j<matriz[0].length;j++) {
				mensaje+="["+matriz[i][j]+"] ";
			}
			mensaje+="\n";
		}
		JOptionPane.showMessageDialog(null, mensaje);
	}

}