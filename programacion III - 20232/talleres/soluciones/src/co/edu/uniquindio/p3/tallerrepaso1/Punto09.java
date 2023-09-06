package co.edu.uniquindio.p3.tallerrepaso1;

import java.util.function.BiPredicate;

/**
 * Dado un arreglo de double, contar cuántos números están por encima del
 * promedio y cuántos por debajo.
 * 
 * @author amador
 *
 */
public class Punto09 {
	public static void main(String[] args) {
		double[] numeros = { 4.0, 7.0, 2.0, 5.0, 1.0, 9.0, 5.0, 8.0, 3.0, 6.0 };

		int numsEncimaProm = obtenerCantNumsPromedio(numeros, (prom, n) -> n > prom);
		int numsDebajoProm = obtenerCantNumsPromedio(numeros, (prom, n) -> n < prom);
		System.out.println(numsEncimaProm);
		System.out.println(numsDebajoProm);
	}

	private static double obtenerPromedio(double[] numeros) {
		return obtenerPromedioAux(numeros, 0, 0);
	}

	private static double obtenerPromedioAux(double[] numeros, int i, double sum) {
		if (i == numeros.length) {
			System.out.println(sum / numeros.length);
			return sum / numeros.length;
		}
		return obtenerPromedioAux(numeros, i + 1, sum + numeros[i]);
	}

	private static int obtenerCantNumsPromedio(double[] numeros, BiPredicate<Double, Double> condicion) {
		double promedio = obtenerPromedio(numeros);
		return obtenerCantNumsPromedioAux(numeros, promedio, condicion, 0, 0);
	}

	private static int obtenerCantNumsPromedioAux(double[] numeros, double promedio,
			BiPredicate<Double, Double> condicion, int i, int cont) {
		if (i == numeros.length)
			return cont;
		if (condicion.test(promedio, numeros[i]))
			return obtenerCantNumsPromedioAux(numeros, promedio, condicion, i + 1, cont + 1);
		return obtenerCantNumsPromedioAux(numeros, promedio, condicion, i + 1, cont);
	}
}
