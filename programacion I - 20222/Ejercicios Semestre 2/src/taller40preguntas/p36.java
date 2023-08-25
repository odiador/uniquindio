package taller40preguntas;

import esen.cial;

/*
 * En España cada persona está identificada con un Documento Nacional de Identidad
 * (DNI) en el que figura un número y una letra, por ejemplo 56999545W
 */
public class p36 {
	public static void main (String args[]) {
		int num = cial.leerInt("Escribe el numero del DNI");
		String res = determinarDNI(num);
		cial.imprimir("El numero completo del DNI es:\n" +res);
	}
	public static char obtenerLetra(int num) {
		char letras[] = {'T','R','W','A','G','M','Y','F','P','D','X','B','N','J','Z','S','Q','V','H','L','C','K','E'};
		char letra=letras[num];
		return letra;
	}
	public static String determinarDNI (int num) {
		int numLetra = num%23;
		char letra = obtenerLetra(numLetra);
		String res = num+""+letra+"";
		return res;
	}
}