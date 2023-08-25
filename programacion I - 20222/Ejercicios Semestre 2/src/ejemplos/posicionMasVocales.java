package ejemplos;

import esen.cial;

public class posicionMasVocales {
	public static void main (String args[]) {
		int cant = cial.leerInt("Ingrese la cantidad de cadenas");
		String arr[] = new String [cant];
		for (int i = 0;i<cant;i++) {
			arr[i] = cial.leerString("Ingrese una cadena");
		}
		int cantidad = calcMasVocales(arr);
		cial.imprimir(cantidad+"");
	}
	public static boolean esVocal(char letra) {
		boolean res = false;
		if (letra>='A'&&letra<='Z') letra=(char) (letra+32);
		if (letra=='a'||letra=='e'||letra=='i'||letra=='o'||letra=='u') res = true;
		return res;
	}
	public static int contarVocales (String cadena) {
		int cant = 0;
		for(int i = 0;i<cadena.length();i++) {
			char letra = cadena.charAt(i);
			if (esVocal(letra)) cant++;
		}
		return cant;
	}
	public static int[] calcArrPos (String arr[]) {
		int arrPos[] = new int[arr.length];
		for(int i = 0;i<arr.length;i++) {
			arrPos[i]=contarVocales(arr[i]);
		}
		return arrPos;
	}
	public static int calcMasVocales (String arr[]) {
		int arrPos[] = calcArrPos(arr);
		int posMayor = 0,menor=0;
		for (int i = 0;i<arrPos.length;i++) {
			if (arrPos[i]<menor) menor = arrPos[i];
		}
		return posMayor;
	}
}
