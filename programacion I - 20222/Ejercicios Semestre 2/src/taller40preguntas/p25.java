package taller40preguntas;

import esen.cial;
/*
 * Vector de prioridades. Se tienen tres vectores de 5 elementos cada uno de tipo int,
 * que representa el nivel de prioridad de una tarea en el procesador. Para su ejecución,
 * el procesador ejecuta los procesos según su nivel de mayor a menor. Crear un vector de
 * 5 elementos donde se tengan los procesos de mayor nivel ordenados de forma descendente.
 */
public class p25 {
	public static void main (String args[]) {
		int cant = 5;
		int vector1[] = new int[cant];
		int vector2[] = new int[cant];
		int vector3[] = new int[cant];
		for(int i = 0;i<cant;i++) {
			vector1[i] = cial.leerInt("Ingrese el numero numero "+(i+1)+" ("+(i+1)+"/"+cant+"| vector 1):");
			vector2[i] = cial.leerInt("Ingrese el numero numero "+(i+1)+" ("+(i+1)+"/"+cant+"| vector 2):");
			vector3[i] = cial.leerInt("Ingrese el numero numero "+(i+1)+" ("+(i+1)+"/"+cant+"| vector 3):");
		}
		//int vector1[] = {1,5,9,3,4};
		//int vector2[] = {6,9,3,8,7};
		//int vector3[] = {1,3,6,6,8};
		int vectorF[] = sacarMayorP(vector1,vector2,vector3);
		cial.imprimir(cial.arregloIaString(vectorF));
	}
	public static int[] juntarArr (int vector1[],int vector2[],int vector3[]) {
		int vectorF[] = new int[vector1.length+vector2.length+vector3.length];
		int pos = 0;
		for(int i = 0;i<vector1.length;i++) {
			vectorF[pos] =vector1[i];
			pos++;
		}
		for(int i = 0;i<vector2.length;i++) {
			vectorF[pos] =vector2[i];
			pos++;
		}
		for(int i = 0;i<vector3.length;i++) {
			vectorF[pos] =vector3[i];
			pos++;
		}
		return vectorF;
	}
	public static int[] sacar5Mayores(int arr[]) {
		for (int j = 0;j<arr.length-1;j++) {
			for (int i = j+1;i<arr.length;i++) {
				if(arr[i]>arr[j]) {
					int aux = arr[j];
					arr[j] =arr[i];
					arr[i] = aux;
				}
			}
		}
		int arrF[] = new int[5];
		for (int i = 0;i<5;i++) {
			arrF[i] = arr[i];
		}
		return arrF;
	}
	public static int[] sacar5valores(int arr[]) {
		int arrF[] = new int[5];
		for (int i = 0;i<5;i++) {
			arrF[i] = arr[i];
		}
		return arrF;
	}
	public static int[] sacarMayorP (int vector1[],int vector2[],int vector3[]) {
		int vectorJunto[] = juntarArr(vector1,vector2,vector3);
		int arrFinal[] = sacar5Mayores(vectorJunto);
		return arrFinal;
	}
}
