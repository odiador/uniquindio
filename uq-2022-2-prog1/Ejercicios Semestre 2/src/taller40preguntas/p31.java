package taller40preguntas;

import esen.cial;

/*
 * Escriba una función que sume los números que estén entre un rango de posiciones
 * dado por el usuario, donde:
 *
 * - El valor inicial y el valor final deben ser menores que el tamaño del arreglo
 * - El valor inicial debe ser menor o igual que el valor final
 */
public class p31 {
	public static void main (String args[]) {
		int cant = cial.leerInt("Escribe la cantidad de numeros a generar");
		int arr[] = generarArrRandom(cant);
		int v0 = cial.leerInt("Escribe el valor inicial:");
		int vF = cial.leerInt("Escribe el valor final:");
		int suma = sumarNums(v0,vF,arr);
		System.out.println((cial.arregloIaString(arr)));
		if(suma == -7) cial.imprimir("No se cumplen los requisitos");
		else cial.imprimir("El resultado de la suma es: "+ suma);
	}
	public static int[] generarArrRandom (int n) {
		int arr[] = new int [n];
		int min = 0;
		int max = 99;
		for(int i = 0;i<n;i++) {
			arr[i] = (int) (Math.random() * (max - min)) + min;
		}
		return arr;
	}
	public static boolean sonMenores (int v0,int vF,int n) {
		boolean res = false;
		if(vF<n&&v0<n) res = true;
		return res;
	}
	public static boolean finalesMayor (int v0,int vF) {
		boolean res = false;
		if(vF>=v0) res = true;
		return res;
	}
	public static int sumarNums (int v0,int vF,int arr[]) {
		int cant = arr.length;
		int suma = -7;
		if(sonMenores(v0,vF,cant)&&finalesMayor(v0,vF)) {
			suma = 0;
			for(int i = v0;i<=vF;i++) {
				suma+=arr[i];
			}
		}
		return suma;
	}
}