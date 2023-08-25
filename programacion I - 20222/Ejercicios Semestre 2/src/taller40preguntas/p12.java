package taller40preguntas;

import esen.cial;
/*
 * Dado un arreglo de Strings de n elementos, y un String k, genere un segundo arreglo con todas
las posiciones en donde el String k (o el String en orden inverso) está almacenado en el primer
arreglo[1].
 */
public class p12 {
	public static void main (String args[]) {
		//String palabras[] = {"hola","pepe","hola","a","aloh","te"};
		//String cadena = "hola";
		int cant = cial.leerInt("Ingrese la cantidad de cadenas");
		String palabras[] = new String[cant];
		for(int i = 0;i<cant;i++) {
			palabras[i] = cial.leerString("Ingrese la cadena numero "+(i+1)+" ("+(i+1)+"/"+cant+"):");
		}
		String cadena = cial.leerString("Ingrese la cadena a comparar (k)");
		int posiciones[] = devolverPosiciones(palabras,cadena);
		String mensaje = cial.arregloIaString(posiciones);
		cial.imprimir(mensaje);
	}
	public static String invertirCadena (String cadena) {
		String nuevaCadena = "";
		for (int i = cadena.length()-1;i>=0;i--) {
			nuevaCadena += cadena.charAt(i)+"";
		}
		return nuevaCadena;
	}
	public static int[] pasarIntArrAStringArr(String arr[]) {
		int arrNums[] = new int [arr.length];
		for (int i = 0; i<arr.length;i++) {
			arrNums[i] = Integer.parseInt(arr[i]);
		}
		return arrNums;
	}
	public static int[] devolverPosiciones (String palabras[], String cadena) {
		String posicionesString = "";
		String cadenaReves = invertirCadena(cadena);
		for (int i = 0;i<palabras.length;i++) {
			if(palabras[i].equals(cadena)||palabras[i].equals(cadenaReves)) {
				posicionesString+= i+"-";
			}
		}
		String arrString[] = posicionesString.split("-");
		int arrPosiciones[] = pasarIntArrAStringArr(arrString);
		return arrPosiciones;
	}
}