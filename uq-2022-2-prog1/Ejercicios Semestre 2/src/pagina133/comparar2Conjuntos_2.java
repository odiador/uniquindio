package pagina133;

import esen.cial;

public class comparar2Conjuntos_2 {
	/*
	 * Leer dos vectores A y B, e indicar si el uno está contenido en otro en orden estricto
	 * inverso Ejemplo A= 1,2,3,4,5,7 B=5,4,3 Debe indicar que B está contenido en A

	 */
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
	public static boolean estaEn(int arregloA[],int arregloB[]) {
		boolean res = true;
		if (arregloA.length==arregloB.length) {
			for(int i=0;i<arregloA.length;i++) {
				if(arregloA[i]!=arregloB[i]) res = false;
			}
		} else {
			res = false;
		}
		return res;
	}
	public static void main(String[] args) {
		int cantidad = cial.leerInt("Escriba la cantidad de numeros del conjunto A");
		int arrA[]= new int[cantidad];
		for(int i = 0;i<arrA.length;i++) {
			arrA[i]=cial.leerInt("Escriba el numero numero "+(i+1)+":");
		}
		int cantidad2 = cial.leerInt("Escriba la cantidad de numeros del conjunto B");
		int arrB[]= new int[cantidad2];
		for(int i = 0;i<arrB.length;i++) {
			arrB[i]=cial.leerInt("Escriba el numero numero "+(i+1)+":");
		}
		int arregloIntersect[] = calcArregloIntersect (arrA,arrB);
		boolean estaContenido = estaEn(arrB,arregloIntersect);
		if(estaContenido) cial.imprimir("El conjunto B está contenido en A");
		if(!estaContenido)cial.imprimir("El conjunto B NO está contenido en A");
	}
}
