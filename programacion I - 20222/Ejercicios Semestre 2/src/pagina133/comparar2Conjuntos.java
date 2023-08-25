package pagina133;

import esen.cial;

public class comparar2Conjuntos {
	//3 Programa para hallar la diferencia entre dos conjuntos.
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
		int arrSoloA[] = calcArregloSolo1 (arrA,arregloIntersect);
		int arrSoloB[] = calcArregloSolo1 (arrB,arregloIntersect);
		int arrFinal[] = juntarArreglo(arrSoloA,arrSoloB);
		String mensajeFinal = cial.arregloIaString(arrFinal);
		cial.imprimir("La diferencia de los 2 conjuntos es: "+mensajeFinal);
	}
}
