package taller40preguntas;
import esen.cial;
/*
 * Desarrollar un método que permita ordenar un vector de enteros de menor a mayor.
 * Repetir este proceso con Strings (orden alfabético).
 */
public class p07_String {
	public static void main (String args[]) {
		int cant = cial.leerInt("Ingrese la cantidad de cadenas");
		String arr[] = new String[cant];
		for(int i = 0;i<cant;i++) {
			arr[i] = cial.leerString("Ingrese la cadena numero "+(i+1)+" ("+(i+1)+"/"+cant+"):");
		}
		ordenarArr(arr);
		String msg = cial.arregloSaString(arr);
		cial.imprimir("El arreglo ordenado es: "+msg);
	}
	public static String pasarAMayus(String cadena) {
		String res = "";
		for(int i = 0;i<cadena.length();i++) {
			char letra = cadena.charAt(i);
			if(letra>='a'&&letra<='z') {
				letra-=32;
			}
			res+=letra+"";
		}
		return res;
	}
	public static String obtenerMayorOMenor (String cadena1, String cadena2,boolean deseaObtenerMayor) {
		String menor = "";
		String mayor = "";
		int cant1 = cadena1.length();
		int cant2 = cadena2.length();
		//Hacer las comparaciones con las palabras en mayús
		String cadena1Mayus = pasarAMayus(cadena1);
		String cadena2Mayus = pasarAMayus(cadena2);
		//Si son diferentes luego se reemplaza, pero si no, se queda igual
		String res = cadena1;
		//Llenar de espacios si una es mayor que la otra
		if(cant1<cant2) {
			for(int i = 0;i<(cant2-cant1);i++) {
				cadena1Mayus+=" ";
			}
			cant1=cant2;
		}
		if(cant2<cant1) {
			for(int i = 0;i<(cant1-cant2);i++) {
				cadena2Mayus+=" ";
			}
			cant2=cant1;
		}
		//En vez de una funcion para obtener mayor y otra para menor
		if(deseaObtenerMayor) {
			boolean condicion = false;
			for(int i = 0;i<cant1;i++) {
				if(cadena1Mayus.charAt(i)<cadena2Mayus.charAt(i)) {
					mayor=cadena2;
					condicion=true;
					break;
				} else if(cadena1Mayus.charAt(i)>cadena2Mayus.charAt(i)) {
					mayor=cadena1;
					condicion=true;
					break;
				}
			}
			if(condicion) res = mayor.trim();

		}
		if(!deseaObtenerMayor) {
			boolean condicion = false;
			for(int i = 0;i<cant1;i++) {
				if(cadena1Mayus.charAt(i)>cadena2Mayus.charAt(i)) {
					menor=cadena2;
					condicion= true;
					break;
				} else if(cadena1Mayus.charAt(i)<cadena2Mayus.charAt(i)) {
					menor=cadena1;
					condicion=true;
					break;
				}
			}
			if(condicion) res = menor.trim();
		}
		return res;
	}
	public static void ordenarArr (String arr[]) {
		int cant = arr.length;
		for (int i = 0;i<cant-1;i++) {
			for (int x = i+1;x<cant;x++) {
				String mayor = obtenerMayorOMenor(arr[x],arr[i],true);
				String menor = obtenerMayorOMenor(arr[x],arr[i],false);
				arr[i] = menor;
				arr[x] = mayor;
			}
		}
	}
}