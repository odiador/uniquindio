package taller40preguntas;

import esen.cial;

/*
 *Implementar en java una función que reciba un numero binario en un vector y retorne el vector
 *que corresponde al siguiente numero binario.
 */
public class p28 {
	public static void main (String args[]) {
		int num = cial.leerInt("Ingrese un numero binario: ");
		cial.imprimir("El resultado de sumarle 1 a ese numero es:\n"+cial.arregloIaString(sumar1(num)));
	}
	public static int[] generarArr(int num) {
		String numCadena = num+"";
		int cant = numCadena.length();
		int arr[] = new int[cant];
		for(int i = 0;i<cant;i++) {
			arr[i] = numCadena.charAt(i)-48;
		}
		return arr;
	}
	public static int[] sumar1 (int num) {
		int arr[] = generarArr(num);
		int cant = arr.length;
		boolean yaTermino = false;
		int i = cant-1;
		boolean lleva = true;
		while (!yaTermino&&i!=-1) {
			if (lleva) {
				if(arr[i]==0) {
					arr[i]+=1;
					yaTermino = true;
					lleva = false;
				}

				else if(arr[i]==1) {
					arr[i]=0;
				}
			}
			i--;
		}
		boolean todoDa0 = true;
		for(int j = 0;j<cant;j++) {
			if (arr[j]==1) todoDa0 = false;
		}
		if(todoDa0) {
			int arrRes[] = new int[cant+1];
			arrRes[0] = 1;
			return arrRes;
		}
		return arr;
	}
}
