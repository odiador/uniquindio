package co.edu.uniquindio.p3.threads;

public class Punto01V2 {

	public static int[][] sumarMatrices(int[][] m1, int[][] m2) throws InterruptedException {
		int mitad = m1.length / 2;
		int matrizNueva[][] = new int[m1.length][m1[0].length];

		Thread h1 = new Thread(() -> sumarMatrices(matrizNueva, m1, m2, 0, mitad));
		Thread h2 = new Thread(() -> sumarMatrices(matrizNueva, m1, m2, mitad, m1.length));

		h1.start();
		h2.start();
		h1.join();
		h2.join();

		return matrizNueva;
	}

	private static void sumarMatrices(int[][] matrizNueva, int[][] m1, int[][] m2, int p0, int end) {
		for (int i = p0; i < end; i++)
			for (int j = 0; j < m1[0].length; j++)
				matrizNueva[i][j] = m1[i][j] + m2[i][j];
	}
}
