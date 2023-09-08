package co.edu.uniquindio.p3.punto2;

public class Polidivisible {
	public static void main(String[] args) {
		boolean poli = esPolidivisible(3036);
		System.out.println(poli);
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
