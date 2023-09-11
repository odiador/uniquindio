package co.edu.uniquindio.p3.punto2;

/**
 * 
 * Escriba un metood que determine la cantidad de numeros de un arreglo que son
 * polidivisibles. No tome el numero como String
 * 
 * @author Amador (Corem05) y Santiago (Tourment0412)
 *
 */
public class Polidivisible {
	public static void main(String[] args) {
		int arr[] = { 3036, 28, 20, 100, 204 };
		System.out.println(contarPolidivisiblesArr(arr));
	}

	/**
	 * No nos acordamos que era de un arreglo
	 * 
	 * @param arr
	 * @return
	 */
	public static int contarPolidivisiblesArr(int[] arr) {
		return contarPolidivisiblesArrAux(arr, 0, 0);
	}

	/**
	 * No nos acordamos que era de un arreglo
	 * 
	 * @param arr
	 * @param i
	 * @param suma
	 * @return
	 */
	private static int contarPolidivisiblesArrAux(int[] arr, int i, int suma) {
		if (i == arr.length)
			return suma;
		return contarPolidivisiblesArrAux(arr, i + 1, suma + (esPolidivisible(arr[i]) ? 1 : 0));
	}

	private static boolean esPolidivisible(int n) {
		if (n <= 0)
			return false;
		return esPolidivisibleAux(n, calcularDigitos(n, 0));
	}

	private static int calcularDigitos(int n, int pot) {
		if (n == 0)
			return pot;
		return calcularDigitos(n / 10, pot + 1);
	}

	private static boolean esPolidivisibleAux(int n, int i) {
		if (n == 0)
			return true;
		if (n % i != 0)
			return false;
		return esPolidivisibleAux(n / 10, i - 1);
	}
}
