package taller40preguntas;

import esen.cial;

/* Desarrollar un método que permita determinar los tres valores que más se repiten en un
 * vector de n elementos enteros.
 */
public class p08 {
	public static void main(String[] args) {
		int cant = cial.leerInt("Ingrese la cantidad de numeros");
		int arr[] = new int[cant];
		for(int i = 0;i<cant;i++) {
			arr[i] = cial.leerInt("Ingrese el numero numero "+(i+1)+" ("+(i+1)+"/"+cant+"):");
		}
		//int arr[]= {5,2,2,5,1,5,3,8,1,4,2,5,5};
		String moda3 = moda3Valores(arr);
		cial.imprimir("Los 3 que mas se repiten son: "+moda3);
	}
	public static int calcCantSinRepetir (int arr[]) {
		int contador = 0;
		for(int i = 0; i<arr.length;i++) {
			boolean estaRep = false;
			for(int x = 0;x<i;x++) {
				if(arr[i]==arr[x]) estaRep = true;
			}
			if(!estaRep) contador++;
		}
		return contador;
	}
	public static int[] conseguirArrSinRepetir (int arr[]) {
		int arrSinRepetir[] = new int [calcCantSinRepetir (arr)];
		int j = 0;
		for(int i = 0; i<arr.length;i++) {
			boolean estaRep = false;
			for(int x = 0;x<i;x++) {
				if(arr[i]==arr[x]) estaRep = true;
			}
			if(!estaRep) {
				arrSinRepetir[j]=arr[i];
				j++;
			}
		}
		return arrSinRepetir;
	}
	public static int[] conseguirArrFrecuencia (int arr[],int arrSinR[]) {
		int arrFinal[] = new int [arrSinR.length];
		for(int i = 0;i<arrSinR.length;i++) {
			int contador = 0;
			for(int j = 0;j<arr.length;j++) {
				if(arrSinR[i]==arr[j]) contador++;
			}
			arrFinal[i]=contador;
		}
		return arrFinal;

	}
	public static int[] eliminar1ValorArr(int arr[],int posicion) {
		int arrFinal[] = new int[arr.length-1];
		int pos = 0;
		for(int i = 0; i<arr.length;i++) {
			if (i!=posicion) {
				arrFinal[pos]=arr[i];
				pos++;
			}
		}
		return arrFinal;
	}
	public static int calcPosMayor(int arr[]) {
		int mayor=-1,posMayor=0;
		for(int i = 0;i<arr.length;i++) {
			if(arr[i]>mayor) {
				mayor = arr[i];
				posMayor = i;
			}
		}
		return posMayor;
	}
	public static String moda3Valores (int arr[]) {
		int arrSinR[] = conseguirArrSinRepetir(arr);
		int arrFrec[] = conseguirArrFrecuencia  (arr,arrSinR);
		int arrAux[] = arrFrec;
		int pos = 0;
		String res = "";
		for(int i = 0;i<3;i++) {
			pos = calcPosMayor(arrAux);
			int mayor = arrSinR[pos];
			int mayorFrec = arrAux[pos];
			arrAux=eliminar1ValorArr(arrAux,pos);
			arrSinR=eliminar1ValorArr(arrSinR,pos);
			res+=mayor+" ("+mayorFrec+"),";
		}
		return res;
	}
}
