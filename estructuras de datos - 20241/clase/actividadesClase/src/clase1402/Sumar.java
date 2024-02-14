package clase1402;

public class Sumar {
	public static void main(String[] args) {
		int[] n = { 2, 4, 5, 3 };
		int suma = sumar(n);
		System.out.println(suma);
	}

	private static int sumar(int[] n) {
		return sumar(n, 0);
	}

	private static int sumar(int[] n, int i) {
		if (i >= n.length)
			return 0;
		return n[i] + sumar(n, ++i);
	}
}
