package taller40preguntas;

import esen.cial;
//Programa para hallar la diferencia entre dos conjuntos.
public class p03 {
	public static void main(String[] args) {
		//int arrA[] = {2,3,5,7,12345,70,12741,19,2123,23};
		//int arrB[] = {2,3,5,7,123,70,17,12437,24,23};
		int cant = cial.leerInt("Ingrese la cantidad de elementos de cada conjunto");
		int arrA[] = new int[cant];
		for(int i = 0;i<cant;i++) {
			arrA[i] = cial.leerInt("Ingrese el numero numero "+(i+1)+" ("+(i+1)+"/"+cant+"| Conjunto A):");
		}
		int arrB[] = new int[cant];
		for(int i = 0;i<cant;i++) {
			arrB[i] = cial.leerInt("Ingrese el numero numero "+(i+1)+" ("+(i+1)+"/"+cant+"| Conjunto B):");
		}
		int arrFinal[] = generarArrFinal(arrA,arrB);
		String mensajeFinal = cial.arregloIaString(arrFinal);
		cial.imprimir("La diferencia de los 2 conjuntos es: "+mensajeFinal);
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
	public static int[] calcArregloSolo1 (int arreglo[],int arregloInter[]) {
		int arregloFinal[];
		int n = arreglo.length;
		int nI = arregloInter.length;
		int cantS1 = 0;
		for (int i = 0;i<n;i++) {
			int cantDif = 0;
			for (int j = 0;j<nI;j++) {
				if (arreglo[i]!=arregloInter[j]) cantDif++;

			}
			if (cantDif==nI) cantS1++;
		}
		arregloFinal = new int[cantS1];
		int posicion = 0;
		for (int i = 0;i<n;i++) {
			int cantDif = 0;
			for (int j = 0;j<nI;j++) {
				if (arreglo[i]!=arregloInter[j]) cantDif++;
				}
			if (cantDif==nI) {
				arregloFinal[posicion] = arreglo[i];
				posicion++;
			}
		}
		return arregloFinal;
	}
	public static int[] juntarArreglo (int arregloA[],int arregloB[]) {
		int nA = arregloA.length;
		int nB = arregloB.length;
		int arreglo[] = new int[(nA+nB)];
		for (int i = 0;i<nA;i++) {
			arreglo[i]=arregloA[i];
		}
		for (int i = 0;i<nB;i++) {
			arreglo[(i+nA)]=arregloB[i];
		}
		return arreglo;
	}
	public static int[] generarArrFinal (int arrA[],int arrB[]) {
		int arrIntersect[] = calcArregloIntersect(arrA,arrB);
		int arrSoloA[] = calcArregloSolo1 (arrA,arrIntersect);
		int arrSoloB[] = calcArregloSolo1 (arrB,arrIntersect);
		int arrFinal[] = juntarArreglo(arrSoloA,arrSoloB);
		return arrFinal;
	}

}
