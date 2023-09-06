package co.edu.uniquindio.p3.tallerrepaso1;

/**
 * Retornar en una cadena los números ubicados en las posiciones pares de un
 * arreglo de int.
 * 
 * @author amador
 *
 */
public class Punto07 {
	public static void main(String[] args) {
		final int[] numeros = { 4, 7, 2, 10, 1, 9, 5, 8, 3, 6, 2 };
		String numsPosPares = obtenerNumerosPosicionesPar(numeros);
		System.out.println(numsPosPares);
	}

	public static String obtenerNumerosPosicionesPar(int[] numeros) {
		return obtenerNumerosPosicionesParAux(numeros, 0);
	}

	public static String obtenerNumerosPosicionesParAux(int[] numeros, int i) {
		if (i >= numeros.length)
			return "";
		return numeros[i] + " " + obtenerNumerosPosicionesParAux(numeros, i + 2);
	}
}
