package puntosArreglos;

import javax.swing.JOptionPane;
/*
 * Dada una matriz de números, devolver un arreglo con todos los elementos que
 * corresponden a números polidivisibles.
 */
public class punto10 {
	//Nota: En la clase AbrirTodos están todos los puntos
	public static void main(String[] args) {
		//Una matriz de numeros
		int matriz[][] = {
				{2016,4233,6267,1002,5256},
				{3004,2460,2072,-10,2021},
				{3240,3636,3637,4028,4021}
		};
		int vectorPoli[] = generarVectorPoli(matriz);
		imprimirMatrizInt("La matriz inicial es: ",matriz);
		imprimirVectorInt("El vector de numeros polidivisibles es:",vectorPoli);
	}
	public static int[] generarVectorPoli(int matriz[][]) {
		String res = "";
		for(int i = 0;i<matriz.length;i++) {
			for(int j = 0;j<matriz[0].length;j++) {
				if(esPolidivisible(matriz[i][j])) {
					res+=matriz[i][j]+"-";
				}
			}
		}
		String matrizString[] = res.split("-");
		int resVect[] = new int [matrizString.length];
		for(int i = 0;i<resVect.length;i++) {
			resVect[i] = Integer.parseInt(matrizString[i]);
		}
		return resVect;
	}
	public static boolean esPolidivisible(int num) {
		boolean res = true;
		String numS = num+"";
		if (num>0) {
			for(int i = 1;i<=numS.length();i++) {
				int parte = Integer.parseInt(numS.substring(0,i));
				if(parte%i!=0) {
					res = false;
					break;
				}
			}
		} else {
			res = false;
		}
		return res;
	}
	public static void imprimirVectorInt (String mensaje,int matriz[]) {
		mensaje += "\n";
		for(int i = 0; i<matriz.length;i++) {
			mensaje+="["+matriz[i]+"] ";
		}
		JOptionPane.showMessageDialog(null, mensaje);
	}
	public static void imprimirMatrizInt (String mensaje,int matriz[][]) {
		mensaje +="\n";
		for(int i = 0; i<matriz.length;i++) {
			for(int j = 0; j<matriz[0].length;j++) {
				mensaje+="["+matriz[i][j]+"] ";
			}
			mensaje +="\n";
		}
		JOptionPane.showMessageDialog(null, mensaje);
	}
}
