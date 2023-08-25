package puntosArreglos;

import javax.swing.JOptionPane;

public class punto06 {
	/*
	 * 5	4	3	2	1
	 * 10 	9	8	7	6
	 * 15	14	13	12	11
	 * 20	19	18	17	16
	 * 25	24	23	22	21
	 */
	//Nota: En la clase AbrirTodos están todos los puntos
	public static void main(String[] args) {
		int cant = 5;
		int[][] matriz = generarMatriz(cant);
		//Imprime la matriz
		imprimirMatrizInt("La matriz generada es: ",matriz);
	}

	public static int[][] generarMatriz(int cant) {
		int matriz[][] = new int[cant][cant];
		int num = 1;
		//Genera la matriz pero con j de abajo hacia arriba
		for(int i = 0;i<cant;i++) {
			for(int j = cant-1;j>=0;j--) {
				matriz[i][j] = num;
				num++;
			}
		}
		return matriz;
	}
	public static void imprimirMatrizInt (String mensaje,int matriz[][]) {
		//imprime la matriz
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