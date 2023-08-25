package taller40preguntas;

import esen.cial;

/*
 * Eliminar los tres valores que más se repiten en un vector de n elementos enteros
 */
public class p09 {
	public static void main(String[] args) {
		int cant = cial.leerInt("Ingrese la cantidad de numeros");
		int arr[] = new int[cant];
		for(int i = 0;i<cant;i++) {
			arr[i] = cial.leerInt("Ingrese el numero numero "+(i+1)+" ("+(i+1)+"/"+cant+"):");
		}
		//int arr[]= {5,2,2,2,5,1,5,3,8,1,4,2,5,5,1,3};
		int arrSin3M[] = generarArrSin3Mayores(arr);
		String mensaje = cial.arregloIaString(arrSin3M);
		cial.imprimir("El arreglo sin los 3 valores que mas se repiten es: "+mensaje);
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
	public static int[] conseguirArrFrecuencias (int arr[], int arrSinR[]) {
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
	public static int calcPosMayor(int arr[]) {
		int mayor=arr[0];
		int posMayor = 0;
		for(int i = 1;i<arr.length;i++) {
			if(arr[i]>mayor) {
				mayor = arr[i];
				posMayor = i;
			}
		}
		return posMayor;
	}
	public static int[] eliminarMayorArr(int arr[],int pos) {
		int arrFinal[] = new int[arr.length-1];
		int posicion = 0;
		for(int i = 0; i<arr.length;i++) {
			if (i!=pos) {
				arrFinal[posicion]=arr[i];
				posicion++;
			}
		}
		return arrFinal;
	}

	public static int[] generarArr3Mayores(int arr[]) {
		int arrSinR[] = conseguirArrSinRepetir(arr);
		int arrFrec[] = conseguirArrFrecuencias (arr,arrSinR);
		System.out.println(cial.arregloIaString(arrSinR));
		System.out.println(cial.arregloIaString(arrFrec));
		int arrAuxSinR[] = arrSinR;
		int arrAuxFrec[] = arrFrec;
		int cant = 3;
		int numerosMayores[] = new int[cant];
		int pos = 0;
		for(int i = 0;i<arr.length;i++) {
			if(pos<cant) {
				int posMayor = calcPosMayor(arrAuxFrec);
				numerosMayores[pos] = arrAuxSinR[posMayor];
				arrAuxSinR = eliminarMayorArr(arrAuxSinR,posMayor);
				arrAuxFrec = eliminarMayorArr(arrAuxFrec,posMayor);
				pos++;
			}
		}
		return numerosMayores;
	}
	public static int calcCantArrSin3Mayores(int arr[],int arr3Mayores[]) {
		int res = 0;
		for(int j= 0; j<arr.length;j++) {
			int cantidad = 0;
			for(int i= 0; i<arr3Mayores.length;i++) {
				if (arr3Mayores[i]!=arr[j]) cantidad++;
				if (cantidad == 3) {
					res++;
					System.out.println(arr[j]+"  | "+arr3Mayores[i]+" -> "+ cantidad);
				}
			}
		}
		return res;
	}
	public static int[] generarArrSin3Mayores(int arr[]) {
		int arr3Mayores[] = generarArr3Mayores(arr);
		int cant = calcCantArrSin3Mayores(arr,arr3Mayores);
		int arrSin3Mayores[] = new int[cant];
		int pos = 0;
		for(int j= 0; j<arr.length;j++) {
			int cantidad = 0;
			for(int i= 0; i<arr3Mayores.length;i++) {
				if (arr3Mayores[i]!=arr[j]) cantidad++;
				if (cantidad == 3) {
					arrSin3Mayores[pos] = arr[j];
					pos++;
				}
			}
		}
		return arrSin3Mayores;
	}
}
