package manocaliente;

public class ManoCaliente {
	public static void main(String[] args) {
		String arr[] = { "11000001011000111110100100101100110011010110001010",
				"101001111100000100011100000111111010000111010010010101",
				"111101000000100001100100011100001100100000110",
				"1000000110111011101101001000001111101111011011100111111" };
		String cadena = obtenerCadenaManosCalientes(arr);
		System.out.println(cadena);

	}

	private static String obtenerCadenaManosCalientes(String[] arr) {
		String cadena = "";
		String[] manosCalientes = obtenerArrManosCalientes(arr);
		for (int i = 0; i < manosCalientes.length; i++) {
			cadena += manosCalientes[i] + "\n";
		}
		return cadena;
	}

	public static String[] obtenerArrManosCalientes(String[] entradas) {
		String[] retManosCalientes = new String[entradas.length + 1];

		for (int i = 0; i < entradas.length; i++)
			retManosCalientes[i] = obtenerCantidadManosCalientes(entradas[i]) + "";
		retManosCalientes[entradas.length] = String.format("%.2f", obtenerPorcentaje(retManosCalientes)) + "%";
		return retManosCalientes;
	}

	public static double obtenerPorcentaje(String[] manosCalientes) {
		double cantidadCalientes = 0;
		for (int i = 0; i < manosCalientes.length - 1; i++) {
			if (!manosCalientes[i].equals("0")) {
				cantidadCalientes++;
			}
		}
		return cantidadCalientes / (manosCalientes.length - 1) * 100;
	}

	public static int obtenerCantidadManosCalientes(String entrada) {
		String cadenaCambiada = entrada;
		String[] arreglo = cadenaCambiada.split("0");
		int contador = 0;
		for (int i = 0; i < arreglo.length; i++) {
			if (arreglo[i].length() > 4) {
				contador++;
			}
		}
		return contador;
	}
}
