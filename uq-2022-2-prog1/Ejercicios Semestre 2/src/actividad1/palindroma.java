package actividad1;

public class palindroma {

	public static void main(String[] args) {
		System.out.println(esPalindroma("seres"));
		System.out.println(esPalindroma2("reconocer"));
		System.out.println(esPalindroma2("reconoceras"));
	}

	public static boolean esPalindroma (String palabra) {
		int cant = palabra.length();
		int media = cant/2;
		int j = cant-1;
		boolean resultado = true;
		for (int i = 0; i<=media; i++) {
			if (palabra.charAt(i)!=palabra.charAt(j)) resultado =false;
			j--;
		}
		return resultado;
	}

		public static boolean esPalindroma2 (String palabra) {
			int cant = palabra.length();
			String reves = "";
			for (int i = (cant-1); i>=0; i--) {
				reves+=(""+palabra.charAt(i));
			}
			boolean resultado = false;
			if (palabra.equals(reves)) resultado = true;
			return resultado;

	}
}
