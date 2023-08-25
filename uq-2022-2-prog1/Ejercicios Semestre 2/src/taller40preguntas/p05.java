package taller40preguntas;

import esen.cial;
/*
 * Leer dos vectores A y B, e indicar si B está contenido en A en orden estricto inverso
Ejemplo A= 1,2,3,4,5,7 B=5,4,3 Debe indicar que B está contenido en A
 */
public class p05 {
	public static void main(String[] args) {
		int cant = cial.leerInt("Ingrese la cantidad de elementos del conjunto A");
		int arrA[] = new int[cant];
		for(int i = 0;i<cant;i++) {
			arrA[i] = cial.leerInt("Ingrese el numero numero "+(i+1)+" ("+(i+1)+"/"+cant+"):");
		}
		cant = cial.leerInt("Ingrese la cantidad de elementos del conjunto B");
		int arrB[] = new int[cant];
		for(int i = 0;i<cant;i++) {
			arrB[i] = cial.leerInt("Ingrese el numero numero "+(i+1)+" ("+(i+1)+"/"+cant+"):");
		}
		//int arrB[] = {1,2,3,4,5};
		//int arrB[] = {5,2,3};
		boolean estaContenido = estaEn(arrA,arrB);
		if(estaContenido) cial.imprimir("El conjunto B está contenido en A");
		if(!estaContenido)cial.imprimir("El conjunto B NO está contenido en A");
	}
	public static int[] calcArregloIntersect (int arregloA[],int arregloB[]) {
		int arregloIntersect[];
		int nA = arregloA.length;
		int nB = arregloB.length;
		int cantidadIntersectado = 0;
		for (int i = 0;i<nA;i++) {
			for (int j = 0;j<nB;j++) {
				if(arregloA[i]==arregloB[j]) cantidadIntersectado++;		//AUB-ANB
			}
		}
		arregloIntersect = new int[cantidadIntersectado];
		int posicion = 0;
		for (int i = 0;i<nA;i++) {
			for (int j = 0;j<nB;j++) {
				if(arregloA[i]==arregloB[j]) {
					arregloIntersect[posicion]=arregloA[i];
					posicion++;
				}
			}
		}
		return arregloIntersect;
	}
	public static int[] calcArrReves (int arr[]) {
		int cant = arr.length;
		int nArr[] = new int[cant];
		int j = cant-1;
		for (int i = 0;i<cant;i++) {
			nArr[i] = arr[j];
			j--;
		}
		return nArr;
	}
	public static boolean estaEn(int arrA[],int arrB[]) {
		boolean res = true;
		int arrReves[] = calcArrReves(arrB);
		int arrIntersect[] = calcArregloIntersect(arrA,arrReves);
		if (arrReves.length==arrIntersect.length) {
			for(int i=0;i<arrReves.length;i++) {
				if(arrReves[i]!=arrIntersect[i]) res = false;
			}
		} else {
			res = false;
		}
		return res;
	}
}