 package clase0902;

public class MultiplicarArrDivide {

	public static void main(String[] args) {
		int[] arr = { 2, 3, 4, 5 };
		System.out.println("resultado: " + multiplicarArr(arr));
	}

	public static int multiplicarArr(int[] arr) {
		return multiplicarArrAux(arr, 0, arr.length - 1);
	}

	private static int multiplicarArrAux(int[] arr, int inicio, int fin) {
		if (inicio == fin) {
			return arr[inicio];
		}
		int mitad = (inicio + fin) / 2;
		return multiplicarArrAux(arr, inicio, mitad) + multiplicarArrAux(arr, mitad + 1, fin);
	}

}
