package puntosArreglos;

import javax.swing.JOptionPane;

public class punto05 {
	/*
	 * 1  	10	11	20	21
	 * 2 	9	12	19	22
	 * 3	8	13	18	23
	 * 4	7	14	17	24
	 * 5	6	15	16	25
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
		for(int j = 0;j<cant;j++) {
			//Si es par que empiece de arriba a abajo
			if(j%2==0) {
				for(int i = 0;i<cant;i++) {
					matriz[i][j] = num;
					num++;
				}
			//Si es impar que empiece de abajo a arriba
			} else {
				for(int i = cant-1;i>=0;i--) {
					matriz[i][j] = num;
					num++;
				}
			}
		}
		return matriz;
	}
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