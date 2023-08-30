package co.edu.uniquindio.p3.taller1;

/**
 * Invertir un número N dado por parámetro. Debe retornar un número entero,
 * trate el número como entero, no lo convierta a String.
 * 
 * @author amador
 *
 */
public class Punto2 {
	public static void main(String[] args) {
		int n = 102584;
		int inversion = invertirNumero(n);
		System.out.println(inversion);
	}

	public static int invertirNumero(int n) {
		return invertirNumeroAux(n, 0);
	}

	private static int invertirNumeroAux(int n, int i) {
		if (n == 0)
			return i;
		return invertirNumeroAux(n / 10, (i * 10) + n % 10);
	}

}
