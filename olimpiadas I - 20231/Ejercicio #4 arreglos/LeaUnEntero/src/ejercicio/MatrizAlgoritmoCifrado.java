package ejercicio;

import javax.swing.JOptionPane;

/**
 * 
 * @author amador
 * @author florez
 * @author perdomo
 *
 */
public class MatrizAlgoritmoCifrado {

	public static void main(String[] args) {
		String cadena = JOptionPane.showInputDialog("Ingrese una frase: ");
		JOptionPane.showMessageDialog(null, "La cadena cifrada es:\n" + obtenerResultadoMatriz(cadena));
	}

	/**
	 * 
	 * 
	 * @param cadena
	 * @return
	 */
	public static String obtenerResultadoMatriz(String cadena) {
		String[][] matriz = generarMatrizCifradaEspiral(cadena);
		String result = "";
		for (String[] arreglos : matriz) {
			for (String cadaCadena : arreglos) {
				result += cadaCadena;
			}
		}
		return result;
	}

	/**
	 * 
	 * Obtiene el tamaño preferido de la matriz para que quepa en un 
	 * 
	 * @param num el tamanio de la matriz
	 * @return un arreglo con ancho en la posicion 0 y alto en la 1
	 */
	public static int[] conseguirArrTabla(int num) {
		int altura = 1;
		while (Math.pow(altura, 2) < num) {
			altura++;
		}
		altura--;

		int ancho = altura;
		while (altura * ancho < num) {
			ancho++;
		}

		int[] result = { ancho, altura };
		return result;
	}

	/**
	 * Genera la matriz cifrada de forma de espiral
	 * 
	 * @param cadena
	 * @return
	 */
	public static String[][] generarMatrizCifradaEspiral(String cadena) {
		int[] arregloTabla = conseguirArrTabla(cadena.length());
		int altura = arregloTabla[1];
		int ancho = arregloTabla[0];
		String[][] matriz = new String[altura][ancho];

		int posicion = 0;
		for (int j = 0; j < matriz[0].length; j++) {
			int posicionj = matriz[0].length - j - 1;
			for (int i = 0; i < matriz.length; i++) {
				int posicioni = matriz.length - i - 1;
				if (j % 2 == 0) {
					posicioni = i;
				}
				matriz[posicioni][posicionj] = " ";
				if (posicion < cadena.length())
					matriz[posicioni][posicionj] = String.valueOf(cadena.charAt(posicion));
				posicion++;
			}

		}
		return matriz;
	}

}
