package co.edu.uniquindio.p3.ejercicioaa;

/**
 * División de un número entre otro mediante restas sucesivas.
 * 
 * @author amador
 *
 */
public class Punto02 {

	public static int dividirNumerosRestas(int a, int b) {
		return dividirNumerosRestasAux(a, b, 0);
	}

	public static int dividirNumerosRestasAux(int a, int b, int i) {
		if (a < b)
			return i;
		return dividirNumerosRestasAux(a - b, b, i + 1);
	}

	public static void main(String[] args) {
		System.out.println(dividirNumerosRestas(34, 5));
	}

}
