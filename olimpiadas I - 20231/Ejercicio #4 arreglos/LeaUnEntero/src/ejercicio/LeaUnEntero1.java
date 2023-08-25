package ejercicio;

public class LeaUnEntero1 {
	public static int[] obtenerArregloImparesConsecutivos(int numero, int tamanioArreglo) {
		int num = numero + 2;
		if (num % 2 == 0)
			num = numero + 1;
		int[] arregloResult = new int[tamanioArreglo];
		for (int i = 0; i < tamanioArreglo; i++, num += 2) {
			arregloResult[i] = num;
		}
		return arregloResult;
	}

	public static void main(String[] args) {
		int arreglo[] = obtenerArregloImparesConsecutivos(8, 6);
		System.out.println(obtenerCadArr(arreglo));

	}

	public static String obtenerCadArr(Object[] arr) {
		String msg = "";
		for (Object object : arr) {
			msg += object.toString() + "\n";
		}
		return msg;
	}

	public static String obtenerCadArr(int[] arr) {
		String msg = "";
		for (int num : arr)
			msg += String.valueOf(num) + "\n";
		return msg;
	}
}
