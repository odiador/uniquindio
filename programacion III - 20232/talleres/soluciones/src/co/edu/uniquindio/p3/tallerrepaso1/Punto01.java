package co.edu.uniquindio.p3.tallerrepaso1;

/**
 * Escribir un método que reciba 2 enteros n y b y devuelva true si n es
 * potencia de b. Ej. 16 es potencia de 2, 64 es potencia de 4, 50 no es
 * potencia de 10.
 * 
 * @author amador
 *
 */
public class Punto01 {
	public static void main(String[] args) {
		int n = 2048;
		int k = 2;
		boolean esPotencia = esPotencia(n, k);
		System.out.println(esPotencia);
	}

	/**
	 * Determina si un numero n es potencia de otro numero k
	 * 
	 * @param n
	 * @param k
	 * @return true si n es potencia de k
	 */
	private static boolean esPotencia(int n, int k) {
		return esPotenciaAux(n, k, 1);
	}

	private static boolean esPotenciaAux(int n, int k, int resultado) {
		if (resultado == n)
			return true;
		if (resultado > n)
			return false;
		return esPotenciaAux(n, k, resultado * k);
	}
}
