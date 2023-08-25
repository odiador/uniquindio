package taller40preguntas;

import esen.cial;

/*
 * Eliminar todos los números perfectos que hay en un arreglo. Un número es perfecto cuando la
suma de sus divisores propios es igual al mismo número. Ejemplo 6 es número perfecto, porque
sus divisores propios son 1, 2 y 3; y 6 = 1 + 2 + 3.
 */
public class p02 {
	public static void main (String args[]) {
		//int arr[] = {2,3,5,6,28,70,17,19,24,23};
		int cant = cial.leerInt("Ingrese la cantidad de numeros");
		int arr[] = new int[cant];
		for(int i = 0;i<cant;i++) {
			arr[i] = cial.leerInt("Ingrese el numero numero "+(i+1)+" ("+(i+1)+"/"+cant+"):");
		}
		int arrF[] = generarArrSinPerf(arr);
		String mensaje = cial.arregloIaString(arrF);
		cial.imprimir("El arreglo sin numeros perfectos es: "+mensaje);
	}
	public static boolean esPerfecto(int num) {
		int suma = 0;
		for(int i = 1;i<num;i++) {
			if(num%i==0) suma+=i;
		}
		boolean res = false;
		if (num==suma) res = true;
		return res;
	}
	public static int detCantArrSinPerf (int arr[]) {
		int cant = 0;
		for(int i = 0;i<arr.length;i++) {
			if(!esPerfecto(arr[i])) cant++;
		}
		return cant;
	}
	public static int[] generarArrSinPerf (int arr[]) {
		int cant = detCantArrSinPerf(arr);
		int nArr[] = new int[cant];
		int pos = 0;
		for(int i = 0;i<arr.length;i++) {
			if(!esPerfecto(arr[i])) {
				nArr[pos] = arr[i];
				pos++;
			}
		}
		return nArr;
	}
}
