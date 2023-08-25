package pagina133;

import esen.cial;

public class suprimirConsonantes {

//Leer un arreglo de Strings y suprimir todas las consonantes de cada de unas palabrascontenidas.
	public static String eliminarConsonantes(String cadena) {
		String cadenaF = "";
		for(int i = 0; i<cadena.length();i++) {
			char letra = cadena.charAt(i);
			if (letra>='a'&&letra<='z'&&(letra=='a'||letra=='e'||letra=='i'||letra=='o'||letra=='u')) {
				cadenaF+=letra+"";
			} else if (letra>='A'&&letra<='Z'&&(letra=='A'||letra=='E'||letra=='I'||letra=='O'||letra=='U')) {
				cadenaF+=letra+"";
			} else if (letra<'A'||letra>'Z'&&letra<'a'||letra>'z') {
				cadenaF+=letra+"";
			}
		}

		return cadenaF;
	}
	public static String[] eliminarConsonantesArr(String arr[]) {
		String arrF[] = new String [arr.length];
		for(int i = 0;i<arr.length;i++) {
			arrF[i] = eliminarConsonantes(arr[i]);
		}
		return arrF;
	}
	public static void main(String[] args) {
		int cantidad = cial.leerInt("Escriba la cantidad de cadenas del conjunto A");
		String arrA[]= new String[cantidad];
		for(int i = 0;i<arrA.length;i++) {
			arrA[i]=cial.leerString("Escriba la cadena numero "+(i+1)+":");
		}
		String arrF[]= eliminarConsonantesArr(arrA);
		String mensaje = cial.arregloSaString(arrF);
		cial.imprimir("El arreglo final es: "+mensaje);
	}
}
