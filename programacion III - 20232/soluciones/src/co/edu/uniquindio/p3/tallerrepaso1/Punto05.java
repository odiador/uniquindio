package co.edu.uniquindio.p3.tallerrepaso1;

/**
 * Sumar todos los valores de un arreglo de int y retornar dicho valor.
 * 
 * @author amador
 *
 */
public class Punto05 {
	public static void main(String[] args) {
		int[] numeros = { 4, 7, 2, 10 }; // 23
		int suma = obtenerSumaArr(numeros);
		System.out.println(suma);
	}

	public static int obtenerSumaArr(int[] numeros) {
		return obtenerSumaArrAux(numeros, 0);
	}

	public static int obtenerSumaArrAux(int[] numeros, int i) {
		if (i == numeros.length)
			return 0;
		return numeros[i] + obtenerSumaArrAux(numeros, i + 1);
	}
}
