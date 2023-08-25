package actividad1;

public class patron2 {
	public static String matriz (int n) {
		String mensaje = "";
		for (int i = 0; i<n;i++) {
			for (int j = 0; j<n;j++) {
				if (i==0 && i==j) mensaje+=("0 "); 
				else if (i==j) mensaje+= ((int) Math.pow(i, j)+" "); 
				else if (i<j) mensaje+="2 ";
				else mensaje+= ("1 ");
			}
			mensaje+="\n";
		}
		return mensaje;
	} 
	public static void main (String args[]) {
		System.out.println(matriz(6));
	}
}

