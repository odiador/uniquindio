package co.edu.uniquindio.p3.taller1;

/**
 * Realizar una función que calcule la suma descendente de un número entero
 * positivo. La suma descendente se realiza sumando los números producto de
 * haber ido eliminando el dígito más significativo de forma reiterada. No debe
 * tomar el número como un String. <br>
 * Por ejemplo, la suma descendente del número 4578 es igual a 4578 + 578 + 78 +
 * 8 = 5242.
 * 
 * @author amador
 *
 */
public class Punto6 {
	public static void main(String[] args) {
		int suma = calcularSumaDescendiente(999);
		System.out.println(suma);
	}

	public static int calcularSumaDescendiente(int n) {
		return calcularSumaDescendienteAux(n, obtenerBase10(n, 1));
	}

	public static int calcularSumaDescendienteAux(int n, int i) {
		if (i == 0)
			return 0;
		return (n % i) + calcularSumaDescendienteAux(n, i / 10);
	}

	public static int obtenerBase10(int n, int i) {
		if (n < i)
			return i;
		return obtenerBase10(n, i * 10);
	}

}
