package taller40preguntas;

import esen.cial;

/*
 * Escriba un programa que determine si una palabra es palíndroma. Un palíndromo es
 * un array de caracteres que se lee de igual forma en ambos sentidos.
 */
public class p39 {
	public static void main (String args[]) {
		String cadena = cial.leerString("Escribe la cadena a verificar:");
		boolean esPal = esPalindroma(cadena);
		if (esPal) cial.imprimir("Es palindroma");
		else cial.imprimir("No es palindroma");
	}
	public static boolean esPalindroma (String palabra) {
		int cant = palabra.length();
		int mitad = cant/2;
		int j = cant-1;
		boolean res = true;
		for(int i = 0;i<mitad;i++) {
			if(palabra.charAt(i)!=palabra.charAt(j)) res = false;
			j--;
		}
		return res;
	}
}