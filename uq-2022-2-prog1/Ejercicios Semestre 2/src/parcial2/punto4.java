package parcial2;

import java.util.ArrayList;

public class punto4 {
	public static void main (String args[]) {
		String codigos[] = {"AEIUN72652","GJAHT62791","JABAB01733","YSJTU56284"};
		ArrayList<String> res = obtenerCodigos2_M_Z(codigos);
		System.out.println(res);
		ArrayList<String> res2 = obtenerCodsABImp(codigos);
		System.out.println("");
		System.out.println("Codigos 2 M y Z cons: "+res);
		System.out.println("Codigos 2AB: "+res2);

	}
	public static ArrayList<String> obtenerCodigos2_M_Z (String arr[]) {
		ArrayList<String> res = new ArrayList<String>();
		for (int i = 0;i<arr.length;i++) {
			String mitad1 = obtenerMitad(true,arr[i]);
			System.out.println("Mitad 1: "+mitad1);
			if(obtenerCantM_Z(mitad1)>=2) {
				res.add(arr[i]);
			}
		}
		return res;
	}
	public static String obtenerMitad (boolean esMitad1, String cadena) {
		int mitad = cadena.length()/2;
		String res = cadena.substring(0,mitad);
		if(!esMitad1) {
			res = cadena.substring(mitad,cadena.length());
		}
		return res;
	}
	public static int obtenerCantM_Z (String cadena) {
		int res = 0;
		for (int i = 0;i<cadena.length();i++) {
			char letra = cadena.charAt(i);

			if(letra>='M'&&letra<='Z'&&letra!='O'&&letra!='U') { //me falto lo de consonantes
				res++;
			}
			System.out.println("Letra: "+letra+" - cant "+res);
		}
		System.out.println("cadena "+cadena+" - cant "+res);
		return res;
	}
	public static ArrayList<String> obtenerCodsABImp (String arr[]){
		ArrayList<String> res = new ArrayList<String>();
		for (int i = 0;i<arr.length;i++) {
			String mitad1 = obtenerMitad (true,arr[i]);
			int cantAB = obtenerCantAB (mitad1);
			int digComprob = arr[i].charAt(arr[i].length()-1)-48;
			if(cantAB>=2&&digComprob%2==1) {
				res.add(arr[i]);
			}
		}
		return res;
	}
	public static int obtenerCantAB (String cadena) {
		int i = 0, res = 0;
		for (int j = 2;j<=cadena.length();j++) {
			String parte = cadena.substring(i,j);
			if (parte.equals("AB")) {
				res++;
			}
			System.out.println("¿"+ parte+" equals AB? - "+res);
			i++;
		}
		System.out.println("cant: "+res+" cadena: "+cadena);
		return res;
	}
}