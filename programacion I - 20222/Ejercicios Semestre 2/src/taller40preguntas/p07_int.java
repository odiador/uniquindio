package taller40preguntas;
import esen.cial;

public class p07_int {
	public static void main (String args[]) {
		int cant = cial.leerInt("Ingrese la cantidad de numeros");
		int arr[] = new int[cant];
		for(int i = 0;i<cant;i++) {
			arr[i] = cial.leerInt("Ingrese el numero numero "+(i+1)+" ("+(i+1)+"/"+cant+"):");
		}
		ordenarArr(arr);
		String msg = cial.arregloIaString(arr);
		cial.imprimir(msg);
	}
	public static void ordenarArr (int arr[]) {
		int cant = arr.length;
		for (int i = 0;i<cant-1;i++) {
			for (int x = i+1;x<cant;x++) {
				if (arr[x]<arr[i]) {
					int aux =arr[i];
					arr[i] = arr[x];
					arr[x] = aux;
				}
			}
		}
	}
}
