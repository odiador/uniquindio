package taller40preguntas;

import esen.cial;

/*
 * Crear un programa donde se tenga un vector de 20 posiciones y el usuario indicará la
 * posición donde se quiere almacenar al dato y luego ingresara el dato y esto lo hará
 * hasta que le vector este completamente lleno. En caso de que el usuario indique una
 * posición ya ocupada el programa deberá preguntar si se desea actualizar el dato. Una vez
 * que el vector este lleno debería Mostar un mensaje indicándolo y mostrar por pantalla el
 * vector.
 */
public class p21 {
	public static void main (String args[]) {
		int cant = 10;
		String arr[] = new String[cant];
		String arrString;
		while(true) {
			arrString = cial.arregloSaString(arr);
			String mensaje = "Bienvenido al sistema para llenar un vector"
					+ "\n" + arrString
					+ "\nElija la posición para llenar:"
					+ "\n(Para salir no elija ninguna opcion).";
			int num = -1;
			try {
				num = cial.leerInt(mensaje);
			}
			catch(Exception e) {
				System.exit(0);
			}
			arr = arreglar(arr,num);
		}


	}
	public static String[] llenarArregloString(String arr[]) {
		int cant = arr.length;
		String arrRes[] = new String[cant];
		for (int i = 0;i<cant;i++) {
			arrRes[i]=arr[i];
		}
		return arrRes;
	}
	public static boolean estaLleno(String arr[]) {
		boolean res = true;
		int cant = arr.length;
		for (int i = 0;i<cant;i++) {
			if(arr[i]==null) res = false;
		}
		return res;

	}
	public static String[] arreglar (String arreglo[],int pos) {
		String arr[] = llenarArregloString(arreglo);
		if (estaLleno(arr)) {
			cial.imprimir("El arreglo ya está lleno");
		}
		else if (pos<arr.length) {
			boolean necesitaAct = true;
			if (arr[pos]!=null) {
				String opcion = cial.leerString("La posición "+pos+ " ya tiene el valor '"+arr[pos]+"', "
						+ "\n¿desea actualizar el dato? (y/n)");
				if (opcion.equals("y")) {
					necesitaAct = true;
				} else {
					necesitaAct = false;
				}
			}
			if (necesitaAct) {
				arr[pos] = cial.leerString("Escribe el dato que quieres llenar");
			}
		}
		return arr;

	}
}
