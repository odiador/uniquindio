package taller40preguntas;

import esen.cial;
/*
 * Diseñar una aplicación que permita llenar un vector de 10 posiciones ordenadamente, es decir,
 * cuando ingresamos el primer numero este se ubicara en la posición 0, el siguiente numero si es
 * mayor se ubicara en la posición 1, pero si es menor se ubicara en la posición 0 y desplazara
 * hacia la derecha el numero, luego leerá el siguiente numero el cual ubicara según su valor
 * desplazando hacia la derecha los números que sean necesarios, de tal forma que el vector
 * permanezca ordenado. Si el vector está ordenado de forma ascendente, descendente o si están
 * desordenados.
 */
public class p19 {
	public static void main (String args[]) {
		int cant = 10;
		int arr[] = new int [cant];
		for(int i = 0;i<cant;i++) {
			int num = cial.leerInt("Escribe el dato numero "+(i+1)+":");
			arr[i] = num;
			arr = ordenarAscendente(arr,i);
			System.out.println(cial.arregloIaString(arr));

		}
	}
	public static int[] ordenarAscendente (int arr[],int pos) {
		int cant = arr.length;
		int arrRes[] = new int[cant];
		for(int i = 0;i<cant;i++) {
			arrRes[i] = arr[i];
		}
		for(int i = 0;i<pos;i++) {
			int menor = arrRes[i];
			for(int j = i+1;j<pos+1;j++) {
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
