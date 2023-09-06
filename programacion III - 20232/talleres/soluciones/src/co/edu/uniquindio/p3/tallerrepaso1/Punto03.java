package co.edu.uniquindio.p3.tallerrepaso1;

/**
 * Un número N es perfecto si la suma de sus divisores (excluido el propio N) es
 * N. Por ejemplo 28 es perfecto, pues sus divisores (excluido el 28) son
 * 1,2,4,7 y 14 su suma da 28. Escriba un método que indique si N es perfecto.
 * 
 * @author amador
 *
 */
public class Punto03 {
	public static void main(String[] args) {
		boolean esPerfecto = esPerfecto(28);
		System.out.println(esPerfecto);
	}

	private static boolean esPerfecto(int n) {
		return n == obtenerSumaPerfectoAux(n, 1);
	}

	private static int obtenerSumaPerfectoAux(int n, int i) {
		if (i == n)
			return 0;
		return (n % i == 0 ? i : 0) + obtenerSumaPerfectoAux(n, i + 1);
	}
}
