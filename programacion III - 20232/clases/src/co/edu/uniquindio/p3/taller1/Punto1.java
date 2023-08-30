package co.edu.uniquindio.p3.taller1;

/**
 * Realizar la multiplicación rusa. Este método permite calcular el producto de
 * M*N de la siguiente manera:<br>
 * En pasos sucesivos se divide M entre 2 (división entera) y se multiplica N
 * por 2. Este proceso se repite hasta que M es 0. El resultado de la
 * multiplicación deseada se obtiene acumulando aquellos valores sucesivos de N
 * para los cuales el valor de M es impar:
 * 
 * @author amador
 *
 */
public class Punto1 {
	public static void main(String[] args) {
		int m = 28;
		int n = 31;
		int multiplicar = multiplicarRuso(m, n);
		System.out.println(multiplicar);
	}

	public static int multiplicarRuso(int m, int n) {
		return multiplicarRusoAux(m, n, 0);
	}

	public static int multiplicarRusoAux(int m, int n, int suma) {
		if (m == 0 || n == 0)
			return suma;
		return multiplicarRusoAux(m / 2, n * 2, m % 2 == 0 ? suma : (suma + n));
	}
}
