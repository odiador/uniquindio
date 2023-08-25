package parciaI1Sonia;

public class p3 {

	public static void main(String[] args) {
		System.out.println(construirFigura(9));
	}

	public static String llenarFila(int tope, int columnas) {
		String res = tope+" ";

		return res;
	}

	public static String construirFigura(int n) {
		String resultado = "";
		for (int i = 0;i<n;i++) {
			for (int j = 0;j<n*2;j++) {
				if(j<i+1) {
					resultado+=j+"";
				} else {
					resultado+=(i+1)+"";
				}
			}
			resultado+="\n";
		}
		return resultado;
	}
}