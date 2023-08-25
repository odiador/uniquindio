package taller40preguntas;

import esen.cial;
/*
 * Leer por teclado un vector de 5 números enteros y el algoritmo debe indicar
 * si el vector está ordenado de forma ascendente, descendente o si están desordenados.
 */
public class p18 {
	public static void main(String args[]) {
		int cant = 5;
		int arr[] = new int[cant];
		for(int i = 0;i<cant;i++) {
			arr[i] = cial.leerInt("Ingrese el numero numero "+(i+1)+" ("+(i+1)+"/"+cant+"):");
		}
		//int arr[] = {45,78,4,22,11,2,6,87,9,54};
		//int arr[] = {2,4,6,9,11,22,45,54,78,87};
		//int arr[] = {87,78,54,45,22,11,9,6,4,2};
		String orden = determinarOrden(arr);
		cial.imprimir(orden);
	}
	public static int[] ordenarAscendente (int arr[]) {
		int cant = arr.length;
		int arrRes[] = new int[cant];
		for(int i = 0;i<cant;i++) {
			arrRes[i] = arr[i];
		}
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
	public static int[] ordenarDescendente (int arr[]) {
		int cant = arr.length;
		int arrRes[] = new int[cant];
		for(int i = 0;i<cant;i++) {
			arrRes[i] = arr[i];
		}
		for(int i = 0;i<cant-1;i++) {
			int mayor = arrRes[i];
			for(int j = i+1;j<cant;j++) {
				if (mayor<arrRes[j]) {
					mayor = arrRes[j];
					arrRes[j] = arrRes[i];
					arrRes[i] = mayor;
				}
			}
		}
		return arrRes;
	}
	public static boolean estaOrdenadoAsc (int arr[]) {
		int arrOrdenado[] = ordenarAscendente(arr);
		int cant = arr.length;
		boolean res = true;
		for (int i = 0;i<cant;i++) {
			if(arr[i]!=arrOrdenado[i]) res = false;
		}
		return res;
	}
	public static boolean estaOrdenadoDesc (int arr[]) {
		int arrOrdenado[] = ordenarDescendente(arr);
		int cant = arr.length;
		boolean res = true;
		for (int i = 0;i<cant;i++) {
			if(arr[i]!=arrOrdenado[i]) res = false;
		}
		return res;
	}
	public static String determinarOrden (int arr[]) {
		String mensaje = "El vector no esta ordenado";
		if(estaOrdenadoAsc(arr)) {
			mensaje = "El vector esta ordenado de manera ascendente";
		}
		if(estaOrdenadoDesc(arr)) {
			mensaje = "El vector esta ordenado de manera descendente";
		}
		return mensaje;
	}
}
