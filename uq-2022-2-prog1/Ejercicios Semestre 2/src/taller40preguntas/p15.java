package taller40preguntas;

import esen.cial;

/*
 * Leer un arreglo de Strings y una cadena. Informar la posición dentro del arreglo del String que
 * contenga más veces la cadena leída.
 */
public class p15 {
	public static void main(String[] args ) {
		int cant = cial.leerInt("Ingrese la cantidad de cadenas");
		String arrA[] = new String[cant];
		for(int i = 0;i<cant;i++) {
			arrA[i] = cial.leerString("Ingrese la cadena numero "+(i+1)+" ("+(i+1)+"/"+cant+"):");
		}
		String comparacion = cial.leerString("Ingrese la cadena a comparar (k)");
		//String arrA[]= {"mariahola","holaholahola","pepehola","rolaholaholahola"};
		//String comparacion = "hola";
		String mensaje = calcPosMayor(arrA,comparacion)+"";
		cial.imprimir("La cadena que tiene más '"+comparacion+"' está en la posición: "+mensaje);
	}
	public static int calcFrecuencia (String cadena,String comparacion) {
		int contador = 0;
		for(int x = 0; x<=(cadena.length()-comparacion.length());x++) {
			for(int i = 0;i<comparacion.length();i++) {
				if(cadena.charAt(x)==comparacion.charAt(i)) {
					String nuevaCadena = cadena.substring(x,x+comparacion.length());
					if (nuevaCadena.equals(comparacion)) contador++;
				}
			}
		}
		System.out.println("cadena: "+cadena+" - contador: "+contador);
		return contador;
	}
	public static int[] calcularArrFrecuencia(String arr[],String comparacion) {
		int cantidad = arr.length;
		int arrFrec[] = new int [cantidad];
		for (int i = 0;i<cantidad; i++) {
			arrFrec[i] = calcFrecuencia(arr[i],comparacion);
		}
		return arrFrec;
	}
	public static int calcPosMayor(String arr[],String comparacion) {
		int arrFrec[] = calcularArrFrecuencia(arr,comparacion);
		int mayor=-1,posMayor=0;
		for(int i = 0;i<arr.length;i++) {
			if(arrFrec[i]>mayor) {
				mayor = arrFrec[i];
				posMayor = i;
			}
		}
		System.out.println("mayor: "+mayor+" - posicion "+posMayor);
		return posMayor;
	}
}
