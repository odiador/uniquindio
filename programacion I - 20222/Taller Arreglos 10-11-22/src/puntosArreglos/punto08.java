package puntosArreglos;

import javax.swing.JOptionPane;

/*
 * Se requiere que el método informe a estos dos hermanos si su lista de palabras,
 * almacenadas en una matriz de tamaño nXm es válida, de acuerdo con el criterio de
 * encadenamiento de palabras.
 */
public class punto08 {
	//Nota: En la clase AbrirTodos están todos los puntos
	public static void main(String[] args) {
		String cadenas[][] = {
				{"sien","encima","mapa"},
				{"pata","tapa","papa"},
				{"pato","toma","mama"}
				};
		imprimirMatrizString("La matriz inicial es: ",cadenas);
		if(estaEncadenado(cadenas)) {
			imprimir("La matriz SI esta encadenada");
		} else {
			imprimir("La matriz NO esta encadenada");
		}
	}
	public static boolean estaEncadenado (String arr[][]) {
		boolean res = true;
		for (int i = 0;i<arr.length;i++) {
			for (int j = 0;j<arr[0].length;j++) {
				String parteAtras;
				String parteAdelante;
				if(i==0&&j==0) {
					// No puede comparar con ninguna mas cuando las i y j son 0
					parteAtras = obtener2Letras(false,arr[i][j]);
					parteAdelante = obtener2Letras(false,arr[i][j]);
				} else if (j==0) {
					// Cuando j es 0 pero i no, compara con la ultima posicion de j de la
					//fila anterior
					parteAtras = obtener2Letras(false,arr[i-1][arr[0].length-1]);
					parteAdelante = obtener2Letras(true,arr[i][j]);
				} else {
					// De resto compara con la anterior
					parteAtras = obtener2Letras(false,arr[i][j-1]);
					parteAdelante = obtener2Letras(true,arr[i][j]);
				}
				if(!(parteAtras.equals(parteAdelante))) {
					res = false;
				}
			}
		}
		return res;
	}
	public static String obtener2Letras (boolean sonLasPrimeras, String cadena) {

		String res = "";
		// Por default obtiene las primeras 2 letras, pero si son las primeras
		// obtiene las 2 primeras
		for (int i = cadena.length()-2;i<cadena.length();i++) {
			res+=cadena.charAt(i)+"";
		}
		if(sonLasPrimeras) {
			res = "";
			for (int i = 0;i<2;i++) {
				res+=cadena.charAt(i)+"";
			}
		}
		return res;
	}
	public static void imprimir (String mensaje) {
		// Imprime un mensaje
		JOptionPane.showMessageDialog(null, mensaje);
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