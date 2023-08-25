package parcial3Sonia;

public class Matriz {
	public static void main(String[] args) {
		int cant = 6;
		int[][] matriz = generarZ(cant);
		String res = "";
		for (int i = 0;i<matriz.length;i++) {
			for (int j = 0;j<matriz[0].length;j++) {
				res+=matriz[i][j]+" ";
			}
			res+="\n";
		}
		System.out.println(res);
	}
	public static int[][] generarZ(int cant) {
		int matriz[][] = new int[cant][cant];
		for (int i = matriz.length-1;i>=0;i--) {
			for (int j = matriz[0].length-1;j>=0;j--) {
				if(i==0) {
					matriz[i][j] = 1;
				}
				if(i==matriz.length-1) {
					matriz[i][j] = 1;
				}
				if(i+j==matriz.length-1) {
					matriz[i][j] = 1;
				}
			}
		}
		return matriz;
	}
}
