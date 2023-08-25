package co.edu.uniquindio.p3.ejercicioaa;

/**
 * Calcular y retornar cualquier potencia para cualquier número.
 * 
 * @author amador
 *
 */
public class Punto04 {
	public static void main(String[] args) {
		System.out.println(calcularPotencia(-5, -2));
	}

	public static double calcularPotencia(int base, int expo) {
		if (expo == 0)
			return 1;
		if (expo > 0)
			return calcularPotenciaPos(base, expo);
		return 1d / calcularPotenciaPos(base, expo * -1);
	}

	public static int calcularPotenciaPos(int base, int expo) {
		if (expo == 0)
			return 1;
		return base * calcularPotenciaPos(base, expo - 1);
	}

}
