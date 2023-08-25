package taller40preguntas;

import esen.cial;
/*
 * Leer un arreglo de Strings y suprimir todas las consonantes de cada de unas palabras
 * contenidas.
 */
public class p13 {
	public static void main (String args[]) {
		//String palabras[] = {"hola","pepe","hola","a","aloh","te"};
		int cant = cial.leerInt("Ingrese la cantidad de cadenas");
		String palabras[] = new String[cant];
		for(int i = 0;i<cant;i++) {
			palabras[i] = cial.leerString("Ingrese la cadena numero "+(i+1)+" ("+(i+1)+"/"+cant+"):");
		}
		String palabrasSinCons[] = suprimir(palabras);
		String mensaje = cial.arregloSaString(palabrasSinCons);
		cial.imprimir("El nuevo arreglo sin consoinantes es: \n"+mensaje);
	}
	public static boolean esVocal(char letra) {
		if (letra>='A'&&letra<='Z') letra+=32;
		boolean res = false;
		if (letra =='a'||letra =='e'||letra =='i'||letra =='o'||letra =='u') res = true;
		return res;
	}
	public static boolean esConsonante (char letra) {
		if (letra>='A'&&letra<='Z') letra+=32;
		boolean res = false;
		if (letra>='a'&&letra<='z'||letra=='ñ'||letra=='Ñ') {
			if (letra !='a'&&letra !='e'&&letra !='i'&&letra !='o'&&letra !='u') {
				res = true;
			}
		}
		return res;
	}
	public static String suprimirConsonantes (String palabra) {
		String res = "";
		int cant = palabra.length();
		for (int i = 0;i<cant;i++) {
			char letra = palabra.charAt(i);
			if(!esConsonante(letra)&&esVocal(letra)) {
				res +=letra+"";
			}
		}
		return res;
	}
	public static String[] suprimir (String arreglo[]) {
		int cant = arreglo.length;
		String arrRes[]= new String [cant];
		for (int i = 0;i<cant;i++) {
			arrRes[i] = suprimirConsonantes(arreglo[i]);
		}
		return arrRes;
	}
}
