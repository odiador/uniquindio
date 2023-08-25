package pruebas;

import java.util.ArrayList;
// Si sirve
public class pruebaArrListADD {
	public static void main (String args[]) {
		ArrayList<Integer> ansd = new ArrayList<Integer>();
		int arr[] = {2,3,4,6,1,5};
		for (int i = 0; i < arr.length; i++) {
			ansd.add(arr[i]);
		}
		ansd.add(2,10);
		System.out.println(ansd);
	}
}
