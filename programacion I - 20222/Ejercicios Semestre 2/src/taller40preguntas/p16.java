package taller40preguntas;

import esen.cial;
/*
 * Leer por teclado dos vectores de 5 números enteros y crear un tercer vector de
 * 10 posiciones donde ubique los números intercalados de los dos vectores iniciales
 */
public class p16 {
	public static void main(String args[]) {
		int cant = 5;
		int arr[] = new int[cant];
		for(int i = 0;i<cant;i++) {
			arr[i] = cial.leerInt("Ingrese el numero numero "+(i+1)+" ("+(i+1)+"/"+cant+"):");
		}
		int arr2[] = new int[cant];
		for(int i = 0;i<cant;i++) {
			arr2[i] = cial.leerInt("Ingrese el numero numero "+(i+1)+" ("+(i+1)+"/"+cant+"):");
		}
		int arrRes[] = unirArreglos(arr,arr2);
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
}