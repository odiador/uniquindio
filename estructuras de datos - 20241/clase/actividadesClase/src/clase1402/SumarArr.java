package clase1402;

public class SumarArr {
	public static void main(String[] args) {
		int n = 5;
		int suma = sumar(n, 0);
		System.out.println(suma);
	}

	public static int sumar(int n) {
		if (n == 0)
			return 0;
		return n + sumar(n - 1);
	}

	private static int sumar(int n, int suma) {
		if (n == 0)
			return suma;
		return sumar(n - 1, suma + n);
	}
}
