package taller40preguntas;

import esen.cial;
/*
 * Diseñe un programa que lea por teclado 10 números enteros y los almacene en un vector,
 * luego le permita al usuario seleccionar desplazamiento hacia la derecha o desplazamiento
 * hacia la izquierda y esto lo pueda hacer hastaque el usuario decida salir del programa,
 * donde se mostrara el vector resultado.
 * La función del desplazamiento hacia la derecha es mover todos los elementos una posición
 * hacia la derecha, así que, el primero pasa a ser el segundo, el segundo a tercer, y así
 * sucesivamente, y el ultimo pasa a ser primero.
 * La función del desplazamiento hacia la izquierda es mover todos los elementos del vector
 * una posición hacia la izquierda, así que el décimo pasa a ser noveno, el noveno a ser
 * octavo y así sucesivamente, y el primero pasa a ser el ultimo.
 */
public class p20 {
	public static void main (String args[]) {

		int cant = 10;
		int arr[] = new int[cant];
		for(int i = 0;i<cant;i++) {
			arr[i] = cial.leerInt("Ingrese el numero numero "+(i+1)+" ("+(i+1)+"/"+cant+"):");
		}
		//int arr[] = {1,2,3,4,5,8,10,12,4};
		int opcion = -6;
		while (opcion!=0) {
			String mensaje = "Movimiento de un vector a un lado."
					+ "\n"+ cial.arregloIaString(arr)
					+ "\nElija 1 para moverlo a la derecha."
					+ "\nElija 2 para moverlo a la izquierda."
					+ "\nElija 0 para salir.";
			opcion = cial.leerInt(mensaje);
			switch (opcion) {
			case 1: arr = generarArrDere(arr);
			break;
			case 2: arr = generarArrIzq(arr);
			break;
			case 0: System.exit(0);
			}
		}
	}
	public static int[] generarArrIzq (int arr[]) {
		int cant = arr.length;
		int arrAux[] = new int[cant];
		for (int i = 0;i<cant;i++) {
			try {
			arrAux[i] = arr[i+1];
			}
			catch (Exception e) {
				arrAux[i] = arr[0];
				break;
			}
		}
		return arrAux;
	}
	public static int[] generarArrDere (int arr[]) {
		int cant = arr.length;
		int arrAux[] = new int[cant];
		for (int i = 0;i<cant;i++) {
			try {
			arrAux[i] = arr[i-1];
			}
			catch (Exception e) {
				arrAux[0] = arr[cant-1];
			}
		}
		return arrAux;
	}
}