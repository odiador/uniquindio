package taller40preguntas;

import esen.cial;

/*
 * Escribir un programa que dados dos arreglos numéricos a y b, de n1 y n2 elementos
 * respectivamente guarden en un tercer arreglo c, todos los números que están en a pero
 * no están en b.
 */
public class p37 {
	public static void main (String args[]) {
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
		//int arrA[] = {1,2,3,4,5};
		//int arrB[] = {3,4,5,6};
		int arrSA[] = detArrSoloA(arrA,arrB);
		cial.imprimir(cial.arregloIaString(arrSA));
	}
	public static int[] calcArregloIntersect (int arregloA[],int arregloB[]) {
		int nA = arregloA.length;
		int nB = arregloB.length;
		String res = "";
		for (int i = 0;i<nA;i++) {
			for (int j = 0;j<nB;j++) {
				if(arregloA[i]==arregloB[j]) res+= arregloA[i]+"-";
			}
		}
		String arrString[] = res.split("-");
		int cant = arrString.length;
		int arrRes[] = new int [cant];
		for(int i = 0;i<cant;i++) {
			arrRes[i] = Integer.parseInt(arrString[i]);
		}
		return arrRes;
	}
	public static int[] detArrSoloA (int arrA[],int arrB[]) {
		int arrIntersect[] = calcArregloIntersect(arrA,arrB);
		System.out.println(cial.arregloIaString(arrIntersect));
		String res = "";
		for (int i = 0;i<arrA.length;i++) {
			int cant = 0;
			for (int j = 0;j<arrIntersect.length;j++) {
				if(arrA[i]!=arrIntersect[j]) cant++;
			}
			if (cant==arrIntersect.length) res+= arrA[i]+"-";
		}

		String arrString[] = res.split("-");
		int cant = arrString.length;
		int arrRes[] = new int [cant];
		for(int i = 0;i<cant;i++) {
			arrRes[i] = Integer.parseInt(arrString[i]);
		}
		return arrRes;
	}
}
