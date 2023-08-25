package taller40preguntas;

import esen.cial;
/*
 * Utilizando el arreglo previamente creado y llenado elevar al cuadrado cada valor
almacenado en el arreglo, almacenar el resultado en otro arreglo. Retorne el arreglo
resultante, al final imprima el arreglo original y el resultante.
 */
public class p30 {
	public static void main (String args[]) {
		int cant = cial.leerInt("Escribe la cantidad de numeros a generar");
		int arr[] = generarArrRandom(cant);
		int arrRes[] = elevarNums(arr);
		cial.imprimir("El arreglo original es:"
				+ "\n"+(cial.arregloIaString(arr))
				+"\nEl nuevo es:"
				+ "\n"+(cial.arregloIaString(arrRes)));
	}
	public static int[] generarArrRandom (int n) {
		int arr[] = new int [n];
		int min = 1;
		int max = 300;
		for(int i = 0;i<n;i++) {
			arr[i] = (int) (Math.random() * (max - min)) + min;
		}
		return arr;
	}
	public static int[] elevarNums (int arr[]) {
		int cant = arr.length;
		int arrRes[] = new int [cant];
		for(int i = 0;i<cant;i++) {
			arrRes[i] = (int) Math.pow(arr[i], 2);
		}
		return arrRes;
	}
}
