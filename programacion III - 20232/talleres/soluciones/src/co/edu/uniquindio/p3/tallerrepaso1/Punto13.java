package co.edu.uniquindio.p3.tallerrepaso1;

/**
 * De una matriz de cadenas cuadrada mostrar la cadena más larga.
 * 
 * @author amador
 *
 */
public class Punto13 {
	public static void main(String[] args) {
		String[][] matriz = { 
				{ "Juan", "Andrea", "Camila", "Carlos" }, 
				{ "Luisa", "Santiago", "Valentina", "David" },
				{ "Isabella", "Mateo", "Daniela", "Javier" },
				{ "Laura", "Alejandro", "Valeria", "Felipe" }
			};
		String cadMasLarga = obtenerCadenaMasLarga(matriz);
		System.out.println(cadMasLarga);
	}

	private static String obtenerCadenaMasLarga(String[][] nombres) {
		return obtenerCadenaMasLargaAux(nombres, 0, 0, nombres[0][0]);
	}

	private static String obtenerCadenaMasLargaAux(String[][] nombres, int i, int j, String masLarga) {
		if (i == nombres.length)
			return masLarga;
		if (j == nombres.length)
			return obtenerCadenaMasLargaAux(nombres, i + 1, 0, masLarga);
		return obtenerCadenaMasLargaAux(nombres, i, j + 1,
				nombres[i][j].length() > masLarga.length() ? nombres[i][j] : masLarga);
	}
}