package puntosArreglos;

import java.util.ArrayList;

import javax.swing.JOptionPane;

/*
 * Dada una matriz de cadenas de n x n, se debe evaluar por cada posición [i][j] de la misma, si
 * cada cadena corresponde a una palabra palíndroma. Se debe devolver un ArrayList, con las
 * palabras palíndromas que estén por debajo de la diagonal principal.
 */
public class punto03 {
	//Nota: En la clase AbrirTodos están todos los puntos
	public static void main (String args[]) {
		//Una matriz de palabras
		String matriz[][] = {
				{"oso","paz","reconocer"},
				{"sometemos","roso","seres"},
				{"anilina","late","naturaleza"}};
		ArrayList<String> cadenasPalindromas = obtenerCadenasPalindromas(matriz);
		imprimirMatrizString("La matriz inicial es: ",matriz);
		imprimirConArrayList("Las cadenas palíndromas que están\npor debajo de la diagonal principal son: ",cadenasPalindromas);
	}
	public static ArrayList<String> obtenerCadenasPalindromas (String matriz[][]){
		ArrayList<String> res = new ArrayList<String>();
		for(int i = 0;i<matriz.length;i++) {
			for(int j = 0;j<matriz.length;j++) {
				//Si es palindroma y esta debajo de la diagonal principal se agregue
				if(i>j&&esPalindroma(matriz[i][j])) {
					res.add(matriz[i][j]);
				}
			}
		}
		return res;
	}
	public static boolean esPalindroma (String cadena) {
		boolean res = true;
		int j = cadena.length()-1;
		//Si la parte inicial es la misma que la parte final contando de arriba hacia
		//abajo, si es palíndroma
		for(int i = 0; i<cadena.length()/2;i++) {
			if(cadena.charAt(i)!=cadena.charAt(j)) {
				res = false;
			}
			j--;
		}
		return res;
	}
	//Imprimir todo
	public static void imprimirConArrayList (String mensaje,ArrayList<String> codigos) {
		JOptionPane.showMessageDialog(null, mensaje+"\n"+codigos);
	}
	public static void imprimirMatrizString (String mensaje,String matriz[][]) {
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