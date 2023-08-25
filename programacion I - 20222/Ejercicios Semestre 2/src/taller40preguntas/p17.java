package taller40preguntas;

import esen.cial;
/*
 * Leer por teclado dos vectores de 10 posiciones y crear un tercer vector de 20 posiciones
 * donde ubique los números de los dos vectores iniciales de forma ordenada ascendentemente.
 */
public class p17 {
	public static void main(String args[]) {
		int cant = 10;
		int arr[] = new int[cant];
		for(int i = 0;i<cant;i++) {
			arr[i] = cial.leerInt("Ingrese el numero numero "+(i+1)+" ("+(i+1)+"/"+cant+"):");
		}
		int arr2[] = new int[cant];
		for(int i = 0;i<cant;i++) {
			arr2[i] = cial.leerInt("Ingrese el numero numero "+(i+1)+" ("+(i+1)+"/"+cant+"):");
		}
		int arrRes[] = ordenarArr(arr,arr2);
		String mensaje = cial.arregloIaString(arrRes);
		cial.imprimir(mensaje);
	}
	public static int[] unirArreglos (int arr[],int arr2[]) {
		int cant = arr.length;
		int arrRes[] = new int[cant*2];
		int pos = 0;
		for (int i = 0;i<cant;i++) {
			arrRes[pos] = arr[i];
			pos++;
			arrRes[pos] = arr2[i];
			pos++;
		}
		return arrRes;
	}
	public static int[] ordenarArr (int arr1[],int arr2[]) {
		int arr[] = unirArreglos(arr1,arr2);
		int cant = arr.length;
		int arrRes[] = arr;
		for(int i = 0;i<cant-1;i++) {
			int menor = arrRes[i];
			for(int j = i+1;j<cant;j++) {
				if (menor>arrRes[j]) {
					menor = arrRes[j];
					arrRes[j] = arrRes[i];
					arrRes[i] = menor;
				}
			}
		}
		return arrRes;
	}
}