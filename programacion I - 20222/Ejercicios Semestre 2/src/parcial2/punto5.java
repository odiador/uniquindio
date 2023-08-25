package parcial2;

import java.util.ArrayList;

public class punto5 {
	public static void main (String args[]) {
		int arr[] = {2016,4233,6267,1002,5256};
		ArrayList<Integer> res = obtenerPolidivisibles(arr);
		System.out.println("");
		System.out.println(res);
	}
	public static ArrayList<Integer> obtenerPolidivisibles (int arr[]) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		for(int i = 0;i<arr.length;i++) {
			if (esPolidivisible(arr[i])) {
				res.add(arr[i]);
			}
		}
		return res;
	}
	public static boolean esPolidivisible(int num) {
		boolean res = true;
		String numS = num+"";
		if (num>0) {
			for(int i = 1;i<=numS.length();i++) {
				int parte = Integer.parseInt(numS.substring(0,i));
				System.out.println(parte+" entre "+i+" = "+parte%i);
				if(parte%i!=0) {
					res = false;
					break;
				}
			}
		} else {
			res = false;
		}
		return res;
	}
}
