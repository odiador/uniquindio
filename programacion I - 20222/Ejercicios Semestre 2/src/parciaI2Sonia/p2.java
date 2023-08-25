package parciaI2Sonia;

public class p2 {

	public static void main(String[] args) {

		int arr[] = {1,3,20,30,33,17,23};
		boolean x = metPrincipal(arr);
		System.out.println(x);

	}

	public static boolean isPrimo (int num) {
		boolean res = true;
		for(int i = 2;i<num;i++) {
			if(num%i==0) {
				res = false;
			}
		}
		return res;
	}
	public static int devolverSiguientePrimo(int primo) {
		int num = primo;
		boolean esPrimo = false;
		while (esPrimo==false) {
			num++;
			esPrimo = isPrimo(num);
		}
		return num;
	}
	public static int[] devolverPrimos (int numeros[]) {
		int cant = 0;
		for(int i = 0;i<numeros.length;i++) {
			if(isPrimo(numeros[i])) {
				cant++;
			}
		}
		int prims[] = new int[cant];
		int pos = 0;
		for(int i = 0;i<numeros.length;i++) {
			if(isPrimo(numeros[i])) {
				prims[pos] = numeros[i];
				System.out.print(prims[pos]+" ");
				pos++;
			}
		}
		System.out.println("");
		return prims;
	}
	public static boolean verificarSiNumeroPrimoTieneSuConsecutivoEnVector(int primo,int primos[]) {
		boolean res = false;
		int sigPrim = devolverSiguientePrimo(primo);
		for(int j = 0;j<primos.length&&!res;j++) {
			System.out.println(sigPrim+"=="+primos[j]);
			if(sigPrim==primos[j]) {
				res = true;
			}
		}
		return res;
	}
	public static boolean metPrincipal (int numeros[]) {
		boolean res = false;
		int[] prims = devolverPrimos(numeros);
		for (int i = 0; i < prims.length&&!res; i++) {
			int primo = prims[i];
			res = verificarSiNumeroPrimoTieneSuConsecutivoEnVector(primo,prims);
		}
		return res;
	}
}