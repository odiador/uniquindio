package co.edu.uniquindio.p3.tallerrepaso1;

/**
 * Contar cuántos números primos hay en un arreglo de enteros y retornar dicha
 * cuenta.
 * 
 * @author amador
 *
 */
public class Punto06 {
	public static void main(String[] args) {
		final int[] numeros = { 4, 7, 2, 10, 1, 9, 5, 8, 3, 6 }; // 1 no cuenta como primo
		int contarPrimos = contarPrimosEnArr(numeros);
		System.out.println(contarPrimos);
	}

	public static int contarPrimosEnArr(int[] numeros) {
		return contarPrimosEnArrAux(numeros, 0);
	}

	private static int contarPrimosEnArrAux(int[] numeros, int i) {
		if (i == numeros.length)
			return 0;
		return (esPrimo(numeros[i]) ? 1 : 0) + contarPrimosEnArrAux(numeros, i + 1);
	}

	public static boolean esPrimo(int num) {
		if (num == 1)
			return false;
		return esPrimoAux(num, 2);
	}

	private static boolean esPrimoAux(int num, int i) {
		if (i >= num)
			return true;
		if (num % i == 0)
			return false;
		return esPrimoAux(num, i + 1);
	}
}
