package co.edu.uniquindio.p3.ejercicioaa;

/**
 * Sumar todos los números impares hasta n. Donde n es un número que se pasa
 * como parámetro.
 * 
 * @author amador
 *
 */
public class Punto03 {

	public static int sumarNumsImparesN(int n) {
		return sumarNumsImparesNAux(n, 1, 0);
	}

	public static int sumarNumsImparesNAux(int n, int numImpar, int acumulador) {
		if (numImpar > n)
			return acumulador;
		return sumarNumsImparesNAux(n, numImpar + 2, acumulador + numImpar);
	}

	public static void main(String[] args) {
		System.out.println(sumarNumsImparesN(9));
	}
}
