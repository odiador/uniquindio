package co.edu.uniquindio.p3.ejercicioaa;

/**
 * Determinar si una palabra o frase es palíndroma o no. boolean.
 * 
 * @author amador
 *
 */
public class Punto11 {
	public static boolean esPalindroma(String cad) {
		if (cad.length() == 1 || cad.length() == 0)
			return true;
		return esPalindromaAux(cad, 0);
	}

	private static boolean esPalindromaAux(String cad, int i) {
		if (i > cad.length() / 2)
			return true;
		if (cad.charAt(i) != cad.charAt(cad.length() - i - 1))
			return false;
		return esPalindromaAux(cad, i + 1);
	}
	public static void main(String[] args) {
		System.out.println(esPalindroma("saillias"));
		System.out.println(esPalindroma("aibofobia"));
		System.out.println(esPalindroma("acopoca"));
		System.out.println(esPalindroma("acoppoca"));
		System.out.println(esPalindroma("acopappoca"));
	}
}
