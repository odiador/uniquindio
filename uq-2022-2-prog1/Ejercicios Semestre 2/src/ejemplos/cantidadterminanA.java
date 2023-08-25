package ejemplos;
import esen.cial;

public class cantidadterminanA {
	public static boolean terminaEnA(String cadena) {
		int ultimaLetra = cadena.length()-1;
		boolean res = false;
		if (cadena.charAt(ultimaLetra)=='a'||cadena.charAt(ultimaLetra)=='A') res = true;
		return res;
	}
	public static int cantTerminanEnA(String arr[]) {
		int cant = 0;
		for (int i = 0;i<arr.length;i++) {
			if (terminaEnA(arr[i])) cant++;
		}
		return cant;
	}
	public static void main (String args[]) {
		int cant = cial.leerInt("Ingrese la cantidad de cadenas");
		String arr[] = new String [cant];
		for (int i = 0;i<cant;i++) {
			arr[i] = cial.leerString("Ingrese una cadena");
		}
		int cantidadA = cantTerminanEnA(arr);
		cial.imprimir(cantidadA+"");
	}
}