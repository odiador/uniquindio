package co.edu.uniquindio.p3.taller1;

/**
 * Programe un método recursivo para encontrar el módulo entre dos números
 * recibidos como parámetro.
 * 
 * @author amador
 *
 */
public class Punto3 {
	public static void main(String[] args) {
		int n = 52;
		int k = 2;
		int inversion = obtenerModulo(n, k);
		System.out.println(inversion);
	}

	public static int obtenerModulo(int n, int k) {
		if (n < k)
			return n;
		return obtenerModulo(n - k, k);
	}
}
