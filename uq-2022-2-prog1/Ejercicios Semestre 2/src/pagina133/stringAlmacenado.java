package pagina133;

import esen.cial;
/*Dado un arreglo de Strings de n elementos, y un String k, genere un segundo arreglo
 * con todas las posiciones en donde el String k (o el String en orden inverso) está
 * almacenado en el primer arreglo
*/
public class stringAlmacenado {
	public static void main(String[] args) {
		int cantidad = cial.leerInt("Escriba la cantidad de textos del conjunto A");
		String arrA[]= new String[cantidad];
		for(int i = 0;i<arrA.length;i++) {
			arrA[i]=cial.leerString("Escriba el numero numero "+(i+1)+":");
		}
		String texto = cial.leerString("Escriba la cadena a comparar");
		int arrPos[] = hallarPosAlmacenada(arrA,texto);
		String mensaje = cial.arregloIaString(arrPos);
		cial.imprimir("Posiciones:"+mensaje);


	}
	public static boolean estaAlmacenada (String cadena, String comparacion) {
		boolean res = false;
		String cadenaReves = "";
		for (int i = cadena.length()-1;i>=0;i--) {
			cadenaReves+= cadena.charAt(i)+"";

		}
		if (cadenaReves.equals(comparacion)||cadena.equals(comparacion)) res = true;
		return res;
	}
	public static int hallarCantAlmacenada (String arr[],String texto) {
		int cantidad = 0;
		for(int i = 0;i<arr.length;i++) {
			if (estaAlmacenada(arr[i],texto)) cantidad++;
		}
		return cantidad;
	}
	public static int[] hallarPosAlmacenada (String arr[],String texto) {
		int cantidad = hallarCantAlmacenada(arr,texto);
		int posAlmacenada[] = new int[cantidad];
		int pos = 0;
		for(int i = 0;i<arr.length;i++) {
			if (estaAlmacenada(arr[i],texto)) {
				posAlmacenada[pos] =i;
				pos++;
			}
		}
		return posAlmacenada;
	}
}