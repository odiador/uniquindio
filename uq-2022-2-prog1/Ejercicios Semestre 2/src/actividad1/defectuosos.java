package actividad1;

public class defectuosos {
	public static void main(String[] args) {
		System.out.println(esDefectuoso(5));
	}
	public static boolean esDefectuoso (int n) {
		int suma = 0;
		for (int i =1; i<n;i++) {
			if (n%i==0) suma+=i;
		}
		boolean resultado = false;
		if (n<suma) resultado = true;
		return resultado;
	}
}
