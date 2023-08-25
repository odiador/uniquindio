package taller40preguntas;

import esen.cial;
/*
 * Multiplicación por duplicación, métodos Ruso
 * El método de multiplicación por duplicación consiste en:
 *
 * ● Escribir los números (A y B) que se desea multiplicar en la parte superior de sendas columnas.
 * ● Dividir A entre 2, sucesivamente, ignorando el residuo (división entera), hasta llegar a la unidad. Escribir los
 * resultados en la columna A.
 * ● Multiplicar B por 2 tantas veces como veces se ha dividido A entre 2. Escribir los resultados sucesivos en la
 * columna B.
 * ● Sumar todos los números de la columna B que estén al lado de un número impar de la columna A. Éste es el
resultado.
 */

public class p26 {
	public static void main (String args[]) {
		int numA = cial.leerInt("Escribe el primer numero a multiplicar");
		int numB = cial.leerInt("Escribe el segundo numero a multiplicar");
		cial.imprimir("El resultado de la multiplicación es: "+hallarRes(numA,numB));
	}
	public static boolean esImpar(int num) {
		boolean res = false;
		if(num%2==1) res=true;
		return res;
	}
	public static int sacarCantArr(int num) {
		int i = num;
		int cant = 0;
		while (i!=1) {
			i=i/2;
			cant++;
		}
		return cant;
	}
	public static int[] sacarArrs(int num,int opcion,int cant) {
		int i = num;
		int arr[] = new int[cant];
		int pos = 0;
		if (opcion==1) {

			while (cant!=0) {
				i=i/2;
				arr[pos] = i;
				pos++;
				cant--;
			}
		}
		else {
			while (cant!=0) {
				i=i*2;
				arr[pos] = i;
				pos++;
				cant--;
			}
		}
		return arr;
	}
	public static int hallarRes (int a,int b) {
		int cant = sacarCantArr(a);
		int arrA[] = sacarArrs(a,1,cant);
		int arrB[] = sacarArrs(b,2,cant);
		int suma = 0;
		for(int i = 0;i<cant;i++) {
			if(arrA[i]%2==1) suma+=arrB[i];
		}
		return suma;
	}
}
