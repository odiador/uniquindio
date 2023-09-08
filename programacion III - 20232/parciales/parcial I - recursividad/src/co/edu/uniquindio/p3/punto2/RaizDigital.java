package co.edu.uniquindio.p3.punto2;

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
