package co.edu.uniquindio.p3.temas.recursividad;

public class Ej03 {
	public static void main(String[] args) {
		System.out.println(encontrarFiboMejorado(20));

	}

	public static void imprimirSerieFibo(int n) {
		int a = 0;
		int b = 1;
		for (int i = 0; i < n; i++) {
			int suma = a + b;
			System.out.println(a);
			a = b;
			b = suma;
		}
	}

	public static void imprimirSerieFiboRecursiva(int n) {
		for (int i = 0; i < n; i++)
			System.out.println(encontrarNumFibonacciRecursivo(i));
	}

	public static int encontrarNumFibonacciRecursivo(int n) {
		if (n == 0 || n == 1) {
			return n;
		}
		return encontrarNumFibonacciRecursivo(n - 1) + encontrarNumFibonacciRecursivo(n - 2);
	}

	public static int encontrarFiboMejorado(int n) {
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		return encontrarFiboMejoradoAux(n, 0, 1);

	}

	public static int encontrarFiboMejoradoAux(int n, int indice, int a) {
		if (n == indice)
			return a;
		return a + encontrarFiboMejoradoAux(n, indice + 1, a);
	}
}
