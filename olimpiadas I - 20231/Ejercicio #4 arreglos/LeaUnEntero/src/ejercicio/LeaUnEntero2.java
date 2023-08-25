package ejercicio;

/**
 * Leer un número X. Coloque esta X en la primera posición de un vector
 * N [100]. En cada posición subsiguiente (1 hasta 99) coloque la mitad del
 * número insertado en la posición anterior, según el ejemplo a
 * continuación. Imprime todo el vector N. <br>
 * Aporte <br>
 * La entrada contiene un número de doble precisión con cuatro decimales.<br>
 * Producción <br>
 * Para cada posición del vector N, imprima "N[ i ] = Y";, donde i es la
 * posición de la matriz e Y es el número almacenado en esa posición. Cada
 * número de N [...] debe estar impreso con 4 dígitos después del punto decimal.
 * 
 * @author amador
 * @author florez
 * @author perdomo
 *
 */
public class LeaUnEntero2 {
	public static void main(String[] args) {
		String arregloMitades = imprimirArregloMitades(200, 5);
		System.out.println(arregloMitades);
	}

	/**
		<html>
	 * <style> h1{ text-fill: red; } </style>
	 * <h1>Recibe un numero y un limite para el arreglo. Retorna un arreglo con la
	 * mitad del numero en la posicion anterior.</h1>
	 * 
	 * @param num
	 * @param limite
	 * @return
	 */
	public static String[] obtenerArregloMitades(double num, int limite) {
		double numFormato = Double.parseDouble(String.format("%.4f", num).replace(',', '.'));
		String[] array = new String[limite];

		for (int i = 0; i < limite; i++, numFormato /= 2)
			array[i] = "N[" + i + "] = " + String.format("%.4f", numFormato);

		return array;
	}

	/**
	 * 
	 * @param num
	 * @param limite
	 * @return
	 */
	public static String imprimirArregloMitades(double num, int limite) {
		String[] ar = obtenerArregloMitades(num, limite);
		String cad = "";
		for (String cadena : ar)
			cad += cadena + "\n";
		return cad;
	}
}
