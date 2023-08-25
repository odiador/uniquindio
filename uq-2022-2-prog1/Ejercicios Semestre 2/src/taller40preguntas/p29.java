package taller40preguntas;

import esen.cial;
/*
 * Cree un arreglo de números de un tamaño n ingresado por el usuario, el arreglo
contendrá números aleatorios entre 1 y 300, escriba una función para mostrar aquellos
números que inicien o terminen en un dígito que el usuario ingresa, estos deben
guardarse en un nuevo arreglo.
 */
public class p29 {
	public static void main (String args[]) {
		int cant = cial.leerInt("Escribe la cantidad de numeros a generar");
		int arr[] = generarArrRandom(cant);
		int digito = cial.leerInt("Escribe el digito a comparar");
		String ultimo = cial.leerString("Escribe si deseas comparar el ultimo digito (y/n)");
		String primer = cial.leerString("Escribe si deseas comparar el primer digito (y/n)");
		boolean deseaU = false;
		boolean deseaP = false;
		if(ultimo.equals("y")) deseaU = true;
		if(primer.equals("y")) deseaP = true;
		int arrRes[] = guardarArrSiCumplen(arr,deseaP,deseaU,digito);
		cial.imprimir("El arreglo original es:"
				+ "\n"+(cial.arregloIaString(arr))
				+"\nEl nuevo es:"
				+ "\n"+(cial.arregloIaString(arrRes)));
		//cial.imprimir(cial.arregloIaString(arrRes));
	}
	public static boolean siCumple(int num,boolean primer,boolean ultimo,int digito) {
		String numCadena = num+"";
		int cant = numCadena.length();
		int primerNum = numCadena.charAt(0)-48;
		int ultimoNum = numCadena.charAt(cant-1)-48;
		boolean res = false;
		if(primer&&ultimo) {
			if(primerNum==digito&&ultimoNum==digito) res = true;
		} else if (primer) {
			if(primerNum==digito) res = true;
		}else if (ultimo) {
			if(ultimoNum==digito) res = true;
		}
		return res;
	}
	public static int[] generarArrRandom (int n) {
		int arr[] = new int [n];
		int min = 1;
		int max = 300;
		for(int i = 0;i<n;i++) {
			arr[i] = (int) (Math.random() * (max - min)) + min;
		}
		return arr;
	}
	public static int[] guardarArrSiCumplen(int arr[],boolean primer,boolean ultimo,int digito) {
		int cant = 0;
		for(int i = 0;i<arr.length;i++) {
			if(siCumple(arr[i],primer,ultimo,digito)) cant++;
		}
		int arrRes[] = new int[cant];
		int pos = 0;
		for(int i = 0;i<arr.length;i++) {
			if(siCumple(arr[i],primer,ultimo,digito)) {
				arrRes[pos] =arr[i];
				pos++;
			}
		}
		return arrRes;
	}
}
