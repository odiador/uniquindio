package co.edu.uniquindio.p3.ejercicioaa;

/**
 * Imprimir en consola un arreglo de cualquier tipo.
 * 
 * @author amador
 *
 */
public class Punto05 {
	public static void imprimirArr(int a[]) {
		String msg = "{";
		System.out.println(imprimirArrAux(a, 0, msg));
	}

	private static String imprimirArrAux(int[] a, int i, String msg) {
		if (i >= a.length)
			return msg + "}";
		if (i == a.length - 1)
			return imprimirArrAux(a, i + 1, msg + a[i]);
		return imprimirArrAux(a, i + 1, msg + a[i] + ", ");
	}
}
