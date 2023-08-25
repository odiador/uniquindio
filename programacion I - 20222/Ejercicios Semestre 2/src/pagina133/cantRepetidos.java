package pagina133;

import esen.cial;

public class cantRepetidos {
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
	public static String moda3Valores (int arrSinR[],int arrFrec[]) {
		int arrAux[] = arrFrec;
		int pos = 0;
		pos = calcPosMayor(arrAux);
		int primero = arrSinR[pos];
		int primeroFrec = arrAux[pos];
		arrAux=eliminar1ValorArr(arrAux,pos);
		arrSinR=eliminar1ValorArr(arrSinR,pos);
		pos = calcPosMayor(arrAux);
		int segundo = arrSinR[pos];
		int segundoFrec = arrAux[pos];
		arrAux=eliminar1ValorArr(arrAux,pos);
		arrSinR=eliminar1ValorArr(arrSinR,pos);
		pos = calcPosMayor(arrAux);
		int tercero = arrSinR[pos];
		int terceroFrec = arrAux[pos];
		String res = primero+" ("+primeroFrec+"), "+segundo+" ("+segundoFrec+")," +tercero+" ("+terceroFrec+")";
		return res;
	}
	public static void main(String[] args) {
		int cantidad = cial.leerInt("Escriba la cantidad de numeros del conjunto A");
		int arrA[]= new int[cantidad];
		for(int i = 0;i<arrA.length;i++) {
			arrA[i]=cial.leerInt("Escriba el numero numero "+(i+1)+":");
		}

		int arrSinR[] = conseguirArrSinRepetir(arrA);
		int arrFrec[] = conseguirArrFrecuencia  (arrA,arrSinR);
		String moda3 = moda3Valores(arrSinR,arrFrec);

		String mensaje = cial.arregloIaString(arrSinR);
		String mensaje2 = cial.arregloIaString(arrFrec);
		cial.imprimir(mensaje+"\n"+mensaje2);
		cial.imprimir("Los 3 que mas se repiten son: "+moda3);
	}
}

