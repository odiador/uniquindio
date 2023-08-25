package actividad1;

public class masAyO {
	public static int contarAyO(String palabra) {
		int cant = 0;
		for (int i = 0;i<palabra.length();i++) {
			char letra = palabra.charAt(i);
			if (letra=='A' || letra == 'O' || letra == 'a' || letra == 'o') cant++; 
		}
		return cant;
	}
	public static String compararPalabras(String p1,String p2) {
		String n;
		int cant1=contarAyO(p1);
		int cant2=contarAyO(p2);
		if (cant1>cant2) {
			n=p1;
		}else {
			n=p2;
		}
		return n;
	}
	public static void main (String args[]) {
		System.out.println(compararPalabras("aaaaooo","asdafnwa"));
	}
}
