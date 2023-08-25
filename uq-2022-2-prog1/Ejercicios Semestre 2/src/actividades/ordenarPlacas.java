package actividades;

import java.util.ArrayList;
public class ordenarPlacas {

	public static void main(String[] args) {
		String arr[] = {"ABC023","FHY726","GHT001","UYT280","HDA456"};
		ArrayList<String> placas = llenarArr(arr);
		ArrayList<String> placasOG = placas;
		determinarLista0s(placas);
		System.out.println(placas);
	}
	public static ArrayList<String> llenarArr(String arr[]) {
		ArrayList<String> placas = new ArrayList<String>();
		for(int i = 0;i<arr.length;i++) {
			placas.add(arr[i]);
		}
		return placas;
	}
	public static ArrayList<Integer> determinarNumsPlaca (ArrayList<String> placas) {
		ArrayList<Integer> listaNums = new ArrayList<Integer>();
		int cant = placas.size();
		for(int i = 0;i<cant;i++) {
			int cant2 = placas.get(i).length();
			String res = "";
			for(int j = 0;j<cant2;j++) {
				char car = placas.get(i).charAt(j);
				if(car>='0'&&car<='9') {
					res+=car+"";
				}
			}
			listaNums.add(Integer.parseInt(res));
		}
		return listaNums;
		}
	public static ArrayList<String> ordenarPlacas (ArrayList<String> placas) {
		int cant = placas.size();
		ArrayList<String> arrRes = new ArrayList<String>();
		for(int i = 0;i<cant;i++) {
			arrRes.add(placas.get(i));
		}
		ArrayList<Integer> placasNums = determinarNumsPlaca(placas);
		System.out.println(placas.toString());
		System.out.println(placasNums.toString());
		for(int i = 0;i<cant-1;i++) {
			for(int j = i;j<cant;j++) {
				if(placasNums.get(i)>placasNums.get(j)) {
					String aux = arrRes.get(i);
					arrRes.set(i, arrRes.get(j));
					arrRes.set(j,aux);
					int aux2 = placasNums.get(i);
					placasNums.set(i, placasNums.get(j));
					placasNums.set(j,aux2);
				}
			}
		}
		return arrRes;
	}

	//PUNTO 2
	//ABC023 -> 02 ES PRIMO Y 23 ES PRIMO => A0C020 pos impares cambian a 0
	public static boolean esPrimo(int num) {
		int cant = (num+"").length();
		boolean res = true;
		for (int i = 2;i<cant;i++) {
			if(num%i==0) res = false;
		}
		return res;
	}

	public static void determinarLista0s (ArrayList<String> placas) {
		ArrayList<Integer> placasInt = determinarNumsPlaca(placas);
		for (int x = 0;x<placasInt.size();x++) {
			int num =placasInt.get(x);
			String numTXT = num+"";
			int cant = numTXT.length();
			boolean cumple = false;
			int cantidad = 0;
			for (int i = 0;i<cant;i++) {
				for (int j = 1;j<=cant;j++) {
					if((j-i)==2) {
						int numMini = Integer.parseInt(numTXT.substring(i, j));
						if(esPrimo(numMini)) cantidad++;
					}
				}
			}
			if(cantidad ==2) cumple = true;
			String placa = placas.get(x);
			if(cumple) {
				String mensaje = "";
				for(int i = 0;i<placa.length();i++) {
					if(i%2==1) {
						mensaje+="0";
					} else {
						mensaje+=placa.charAt(i)+"";
					}
				}
				placas.add(mensaje);
			} else {
				placas.add(placa);
			}
		}

	}
}
