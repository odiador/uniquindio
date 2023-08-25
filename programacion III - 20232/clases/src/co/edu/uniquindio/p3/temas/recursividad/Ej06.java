package co.edu.uniquindio.p3.temas.recursividad;

public class Ej06 {
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
