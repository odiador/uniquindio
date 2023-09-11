package co.edu.uniquindio.p3.punto2;

/**
 * Dado un numero natural N, se calcula la raíz digital de N sumando los digitos
 * que lo componen. El proceso se repite sobre el nuevo numero hasta que el
 * resultado obtenido tiene un solo dígito.
 * 
 * @author Amador (Corem05) y Santiago (Tourment0412)
 *
 */
public class RaizDigital {
	public static void main(String[] args) {
		int raizDig = calcularRaizDig(591);
		System.out.println(raizDig);
	}

	private static int calcularRaizDig(int n) {
		if (n < 10)
			return n;
		return calcularRaizDig(sumarDigitos(n, 0));
	}

	private static int sumarDigitos(int n, int suma) {
		if (n == 0)
			return suma;
		return sumarDigitos(n / 10, suma + n % 10);
	}
}
