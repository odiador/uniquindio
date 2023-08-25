package actividad1;

public class patron1 {
	public static String matriz (int n) {
		String mensaje = "";
		for (int i = 0; i<n;i++) {
			for (int j = 0; j<n;j++) {
				if (i==j) mensaje+= (i+" ");
				else if (i<j) mensaje+="2 ";
				else mensaje+= ((int) Math.pow(i, j)+" ");
			}
			mensaje+="\n";
		}
		return mensaje;
	} 
	public static void main (String args[]) {
		System.out.println(matriz(6));
	}
}
