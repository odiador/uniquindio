package parcial2;

public class punto2 {
	public static void main (String args[]) {
		String cadenas[] = {"sien","encima","mapa","pata","tapas"};
		System.out.println(estaEncadenado(cadenas));
	}
	public static boolean estaEncadenado (String arr[]) {
		boolean res = true;
		for (int i = 1;i<arr.length;i++) {
			String parteAtras = obtener2Letras(false,arr[i-1]);
			String parteAdelante = obtener2Letras(true,arr[i]);
			System.out.println("¿"+parteAtras+" equals "+parteAdelante+"?");
			if(!(parteAtras.equals(parteAdelante))) {
				res = false;
				break;
			}
		}
		return res;
	}
	public static String obtener2Letras (boolean sonLasPrimeras, String cadena) {
		String res = "";
		for (int i = cadena.length()-2;i<cadena.length();i++) {
			res+=cadena.charAt(i)+"";
		}
		if(sonLasPrimeras) {
			res = "";
			for (int i = 0;i<2;i++) {
				res+=cadena.charAt(i)+"";
			}
		}
		return res;
	}
}
