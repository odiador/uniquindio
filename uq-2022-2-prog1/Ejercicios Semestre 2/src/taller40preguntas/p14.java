package taller40preguntas;

import esen.cial;
/*
 * Dado un String, crear uno nuevo que contenga primero las vocales y luego las consonantes.
 */
public class p14 {
	public static void main (String args[]) {
		//String palabra = "asdyuhuyedha dvfervesuydbudyeb";
		String palabra = cial.leerString("Ingrese la cadena a modificar:");
		String palabraModificada = modificar(palabra);
		cial.imprimir("La palabra modificada es: \n"+palabraModificada);
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
	public static String modificar(String palabra) {
		String vocales = "";
		int cant = palabra.length();
		for (int i = 0;i<cant;i++) {
			char letra = palabra.charAt(i);
			if(esVocal(letra)) {
				vocales +=letra+"";
			}
		}
		String consonantes = "";
		for (int i = 0;i<cant;i++) {
			char letra = palabra.charAt(i);
			if(esConsonante(letra)) {
				consonantes +=letra+"";
			}
		}
		String res = vocales+consonantes;
		return res;
	}


}
