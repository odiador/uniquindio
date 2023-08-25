package taller40preguntas;

import esen.cial;

/*
 * Utilice el arreglo del punto anterior para: escribir un programa, que lea el arreglo y
 * muestre sus elementos en pantalla. Luego, si hay números repetidos, deben eliminarse
 * de la lista y dejar sólo uno de cada número e imprimir la nueva lista.
 */
public class p34 {
	public static void main (String args[]) {
		int cant = cial.leerInt("Escribe la cantidad de numeros a generar");
		int arr[] = generarArrRandom(cant);
		System.out.println((cial.arregloIaString(arr)));
		int arrSinR[]= detArrSinR(arr);
		cial.imprimir("El arreglo original es: \n"+cial.arregloIaString(arr)+"\nY sin repetir:\n"+cial.arregloIaString(arrSinR));
	}
	public static int[] generarArrRandom (int n) {
		int arr[] = new int [n];
		int min = 0;
		int max = 9;
		for(int i = 0;i<n;i++) {
			arr[i] = (int) (Math.random() * (max - min)) + min;
		}
		return arr;
	}
	public static int[] detArrSinR(int arr[]) {
		int cant = arr.length;
		String cadena = "";
		for(int i = 0;i<cant;i++) {
			boolean estaLibre = true;
			for(int j = 0;j<i;j++) {
				if(arr[i]==arr[j]) estaLibre = false;
			}
			if(estaLibre) cadena+=arr[i]+"-";
		}
		String arrString[] = cadena.split("-");
		cant = arrString.length;
		int arrRes[] = new int [cant];
		for(int i = 0;i<cant;i++) {
			arrRes[i] = Integer.parseInt(arrString[i]);
		}
		System.out.println((cial.arregloIaString(arrRes)));
		return arrRes;
	}
}