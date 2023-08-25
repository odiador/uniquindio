package taller40preguntas;

import esen.cial;
/*
 * Diccionario. Crear un vector de 50 elementos de tipo String, e ir insertando elemento
 * a elemento según vaya insertando el usuario, el vector siempre debe estar ordenado de
 * forma ascendente. Cuando se llene le vector, indicar al usuario y mostrar el listado.
 */

public class p24 {
	public static void main (String args[]) {
		int cant = 50;
		String arr[] = new String [cant];
		for(int i = 0;i<cant;i++) {
			String num = cial.leerString("Arreglo: "+cial.arregloSaString(arr)
					+ "\nEscribe el dato numero "+(i+1)+":");
			arr[i] = num;
			ordenarArr(arr,i);
		}
		cial.imprimir("El arreglo final es:\n"+cial.arregloSaString(arr));
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
	public static void ordenarArr (String arr[],int pos) {
		for (int j = 0;j<=pos-1;j++) {
			for (int i = j+1;i<=pos;i++) {
				String mayor = obtenerMayorOMenor(arr[j],arr[i],true);
				String menor = obtenerMayorOMenor(arr[j],arr[i],false);
				arr[i] = mayor;
				arr[j] = menor;
			}
		}
	}
}
