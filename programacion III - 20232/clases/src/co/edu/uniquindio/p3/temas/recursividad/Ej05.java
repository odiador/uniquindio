package co.edu.uniquindio.p3.temas.recursividad;

public class Ej05 {
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
