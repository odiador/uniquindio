package co.edu.uniquindio.p3.punto2;

public class ArrContenido {
	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 5, 6 };
		int[] b = { 3, 4 };
		boolean contenido = isContenido(a, b);
		System.out.println(contenido);
	}

	private static boolean isContenido(int[] a, int[] b) {
		return isContenidoAux(a, b, 0);
	}

	private static boolean isContenidoAux(int[] a, int[] b, int i) {
		if (i == a.length)
			return false;
		if (a[i] == b[0]) // tal vez no fue así
			if (isContenidoAux2(a, b, i, 1))
				return true;
		return isContenidoAux(a, b, i + 1);
	}

	private static boolean isContenidoAux2(int[] a, int[] b, int i, int j) {
		if (i == a.length)
			return false;
		if (j == b.length)
			return true;
		if (a[i] != b[j])
			return false;
		return isContenidoAux2(a, b, i + 1, j + 1);
	}
}
