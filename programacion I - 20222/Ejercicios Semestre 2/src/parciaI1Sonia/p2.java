package parciaI1Sonia;

public class p2 {

	public static void main(String[] args) {
		System.out.println(esLibreDeCuadrados(10193761));
	}
	public static int cantidadDeVecesQEsDivisible (int num,int i) {
		int cant = 0;
		boolean esDivisible = true;
		while (esDivisible) {
			if(num%i==0) {
				num = num/i;
				cant++;
			} else {
				esDivisible = false;
			}
		}
		return cant;
	}
	public static boolean esLibreDeCuadrados(int num) {
		boolean res = true;
		for(int i = 2;i<num&&res;i++) {
			if(cantidadDeVecesQEsDivisible(num,i)>=2) {
				res = false;
			}
		}
		return res;
	}
}