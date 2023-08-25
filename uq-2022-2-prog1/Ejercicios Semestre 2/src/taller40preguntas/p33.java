package taller40preguntas;

import esen.cial;

/*
 * Llene un arreglo de tamaño n ingresado por el usuario, con números aleatorios entre
 * 0-9, seguido de esto:
 *
 * Cree una función en la cual el usuario ingrese un número y la función debe retornar
 * la cantidad de veces que aparece dicho numero
 */
public class p33 {
	public static void main (String args[]) {
		int cant = cial.leerInt("Escribe la cantidad de numeros a generar");
		int arr[] = generarArrRandom(cant);
		System.out.println((cial.arregloIaString(arr)));
		int num = cial.leerInt("Escribe el numero a buscar");
		int frecuencia = detFrec(arr,num);
		cial.imprimir("La frecuencia en la que aparece "+num+ " es de "+ frecuencia);
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
	public static int[] detArrFrec(int arr[],int arrSinR[]) {
		int arrFrec[] = new int [arrSinR.length];
		for(int i = 0;i<arrSinR.length;i++) {
			int cant = 0;
			for(int j = 0;j<arr.length;j++) {
				if(arrSinR[i]==arr[j]) cant++;
			}
			arrFrec[i] = cant;
		}
		System.out.println((cial.arregloIaString(arrFrec)));
		return arrFrec;
	}
	public static int detFrec(int arr[],int num) {
		int arrSinR[] = detArrSinR(arr);
		int arrFrec[] = detArrFrec(arr,arrSinR);
		int frecuencia = -5;
		for(int i = 0;i<arrSinR.length;i++) {
			if(arrSinR[i]==num) {
				frecuencia = arrFrec[i];
				break;
			}
		}
		return frecuencia;
	}
}