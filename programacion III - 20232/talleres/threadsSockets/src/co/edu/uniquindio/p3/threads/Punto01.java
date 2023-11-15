package co.edu.uniquindio.p3.threads;

public class Punto01 {

	public static void main(String[] args) throws InterruptedException {
		int[][] matr = { { 1, 2, 3 }, { 1, 2, 3 }, { 1, 2, 3 } };
		int[][] matr2 = { { 3, 1, 3 }, { 1, 2, 3 }, { 1, 2, 3 } };
		int[][] suma = sumarMatrices(matr, matr2);
		for (int i = 0; i < matr2.length; i++) {
			for (int j = 0; j < matr2.length; j++)
				System.out.print(suma[i][j] + "	");
			System.out.println("\n");
		}
	}

	public static int[][] sumarMatrices(int[][] m1, int[][] m2) throws InterruptedException {
		int mitad = m1.length / 2;
		int matrizNueva[][] = new int[m1.length][m1[0].length];

		HiloSuma h1 = new HiloSuma(matrizNueva, m1, m2, 0, mitad);
		HiloSuma h2 = new HiloSuma(matrizNueva, m1, m2, mitad, m1.length);

		h1.start();
		h2.start();
		h1.join();
		h2.join();

		return matrizNueva;
	}

	private static class HiloSuma extends Thread {

		private int[][] matrizNueva, m1, m2;
		private int p0, end;

		public HiloSuma(int[][] matrizNueva, int[][] m1, int[][] m2, int p0, int end) {
			this.matrizNueva = matrizNueva;
			this.m1 = m1;
			this.m2 = m2;
			this.p0 = p0;
			this.end = end;
		}

		@Override
		public void run() {
			for (int i = p0; i < end; i++) {
				for (int j = 0; j < m1[0].length; j++) {
					matrizNueva[i][j] = m1[i][j] + m2[i][j];
				}
			}
		}
	}
}
