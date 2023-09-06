package co.edu.uniquindio.p3.temas.recursividad;

/**
 * Index:
 * <li>Encontrar el factorial de un numero de manera recursiva
 * 
 * @author juan
 *
 */
public class Ej02 {

	public static void main(String[] args) {
		System.out.println(encontrarFactorialRecursivo(5, 1));
	}

	/**
	 * Encuentra el factorial de un numero num
	 * 
	 * @param num es el numero
	 * @return es el resultado del factorial
	 */
	public static int encontrarFactorialRecursivo(int num) {
		if (num == 0 || num == 1)
			return 1;
		return num * encontrarFactorialRecursivo(num - 1);
	}

	/**
	 * Encuentra el factorial de un numero num
	 * 
	 * @param num es el numero
	 * @return es el resultado del factorial
	 */
	public static int encontrarFactorial(int num) {
		int resultado = 1;
		while (num > 0) {
			resultado *= num;
			num--;
		}
		return resultado;
	}

	/**
	 * Encuentra el factorial de un numero num
	 * <li>Usa recursion por cola</li> <br>
	 * <b>Valor inicial:</b> 1
	 * 
	 * @param num      es el numero
	 * @param solucion es la solucion que va cambiando hasta encontrar el resultado
	 *                 final
	 * @return es el resultado del factorial
	 */
	public static int encontrarFactorialRecursivo(int num, int solucion) {
		if (num == 0 || num == 1)
			return solucion;
		return encontrarFactorialRecursivo(num - 1, num * solucion);
	}

	/*
	 * Cualquier metodo tiene que dar una solucion en un tiempo finito
	 */
}
