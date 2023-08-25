package co.edu.uniquindio.p3.ejercicioaa;

/**
 * Contar el número de vocales de una cadena: int vocales(String cadena, int
 * contador).
 * 
 * @author amador
 *
 */
public class Punto12 {
	public static int contarVocales(String cadena) {
		return contarVocalesAux(cadena, 0, 0);
	}

	public static int contarVocalesAux(String cadena, int i, int contador) {
		if (i >= cadena.length())
			return contador;
		return contarVocalesAux(cadena, i + 1, esVocal(cadena.charAt(i)) ? contador + 1 : contador);
	}

	public static boolean esVocal(char c) {
		String vocales = "aeiou";
		for (int i = 0; i < vocales.length(); i++)
			if (c == vocales.charAt(i) || c == vocales.charAt(i) - 32)
				return true;
		return false;
	}

	public static void main(String[] args) {
		System.out.println(esVocal('a'));
		System.out.println(esVocal('A'));
		System.out.println(esVocal('F'));
		System.out.println(contarVocales("Sumar todos los elementos de una matriz cuadrada"));
	}
}
