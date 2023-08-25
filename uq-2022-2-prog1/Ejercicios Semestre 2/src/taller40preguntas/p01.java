package taller40preguntas;
import esen.cial;

/*
 * Obtener el promedio de todos los números primos que hay en un arreglo superiores a n.
 */
public class p01 {
	public static void main (String args[]) {
		//int arr[] = {2,3,5,7,12345,70,17,19,24,23};
		//2 3 5 7 17 19 23 -> 7
		//int n = 6;
		int cant = cial.leerInt("Ingrese la cantidad de numeros");
		int arr[] = new int[cant];
		for(int i = 0;i<cant;i++) {
			arr[i] = cial.leerInt("Ingrese el numero numero "+(i+1)+" ("+(i+1)+"/"+cant+"):");
		}
		int n = cial.leerInt("Ingrese el numero a comparar (n)");
		double prom = hallarPromedio(arr,n);//(7+17+19+23)/4
		cial.imprimir("El promedio es: "+prom);
	}
	public static boolean esPrimo (double n) {
		boolean res = true;
		for (int i = 2;i<n;i++) {
			if(n%i==0) res = false;
		}
		return res;
	}
	public static double hallarPromedio (int arreglo[],int n) {
		double prom;
		double suma = 0;
		int cantPrimos = 0;
		for (int i =0;i<arreglo.length;i++) {
			if(esPrimo(arreglo[i])&&arreglo[i]>n) {
				suma+=arreglo[i];
				cantPrimos++;
			}
		}
		prom = suma/cantPrimos;
		return prom;
	}
}