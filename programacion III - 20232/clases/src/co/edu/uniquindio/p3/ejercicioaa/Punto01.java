package co.edu.uniquindio.p3.ejercicioaa;

/**
 * Multiplicar dos números mediante sumas sucesivas.
 * 
 * @author amador
 *
 */
public class Punto01 {

	public static int multiplicarNumerosSumas(int a, int b) {
		return multiplicarNumerosSumasAux(a, b, 0, 0);
	}

	public static int multiplicarNumerosSumasAux(int a, int b, int i, int resultado) {
		if (i == b)
			return resultado;
		return multiplicarNumerosSumasAux(a, b, i + 1, resultado + a);
	}

	public static void main(String[] args) {
		System.out.println(multiplicarNumerosSumas(5, 27));
	}

}
