package taller40preguntas;
import esen.cial;
/*
 * Dado un arreglo de Strings borrar las palabras que tienen consonantes al inicio, final y parte
 * central.
 */
public class p10 {
	public static void main (String args[]) {
		int cant = cial.leerInt("Ingrese la cantidad de cadenas");
		String arrF[] = new String[cant];
		for(int i = 0;i<cant;i++) {
			arrF[i] = cial.leerString("Ingrese la cadena numero "+(i+1)+" ("+(i+1)+"/"+cant+"):");
		}
		//String arrF[] = {"BFYTSHVYTWEF","FHRSUHJSFBK","SDSHDASDHJ","ASDFASD"};
		arrF = eliminarPalabras(arrF);
		System.out.println("El arreglo resultante es: "+cial.arregloSaString(arrF));
	}
	public static boolean esConsonante (char letra) {
		boolean res = false;
		if(letra >= 'A'&&letra<='Z') letra+=32;
		if(letra !='a'&&letra !='e'&&letra !='i'&&letra !='o'&&letra !='u') res = true;
		return res;
	}
	public static boolean verificarPalabra (String palabra) {
		int cant = palabra.length();
		int contador = 0;
		int mitad = cant/2+1;
		for(int i = 0;i<cant;i++) {
			char letra = palabra.charAt(i);
			if(i==0||i==cant-1||i==mitad){
				if(esConsonante(letra)) {
					contador++;
				}
			}
		}
		boolean res = false;
		if (contador==3) res = true;
		return res;
	}
	public static String[] eliminarPalabras(String arreglo[]) {
		String palabras = "";
		for(int i = 0;i<arreglo.length;i++) {
			if(verificarPalabra(arreglo[i])) palabras+= arreglo[i]+"-";
		}
		String arr[] = palabras.split("-");
		return arr;
	}
}