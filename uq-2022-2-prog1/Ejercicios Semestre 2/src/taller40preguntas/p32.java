package taller40preguntas;

import esen.cial;

/*
 * Cree dos funciones, una para retornar el número menor y una para retornar el
 * número mayor.
 */
public class p32 {
	public static void main (String args[]) {
		int cant = cial.leerInt("Escribe la cantidad de numeros a generar");
		int arr[] = generarArrRandom(cant);
		System.out.println((cial.arregloIaString(arr)));
		int menor = detMenor(arr);
		int mayor = detMayor(arr);
		cial.imprimir("El mayor es: "+mayor+ " y  el menor es: "+ menor);
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
	public static int detMayor(int nums[]) {
		int mayor = nums[0];
		for(int i = 1;i<nums.length;i++) {
			if(nums[i]>mayor) mayor = nums[i];
		}
		return mayor;
	}
	public static int detMenor(int nums[]) {
		int menor = nums[0];
		for(int i = 1;i<nums.length;i++) {
			if(nums[i]<menor) menor = nums[i];
		}
		return menor;
	}
}
