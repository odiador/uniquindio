package actividades;

import esen.cial;

/*
 *
 **
 ***
 ****
 ***
 **
 *
 */
public class patron3 {
	public static void main(String[] args) {
		int n = cial.leerInt("Ingrese la cantidad de celdas");
		String triangulo = generarEquilatero(n);
		cial.imprimir(triangulo);
		

	}
	public static String agregarACadena (int cantidad,String texto) {
		String res = "";
		for (int i = 0; i<cantidad;i++) {
			res+=texto;
		}
		return res;
	}
	public static String generarEquilatero (int n) {
		String cadena = "";
		int CantActeriscos = 1;
		while (CantActeriscos<=n) {
			cadena+= agregarACadena (CantActeriscos,"X");
			CantActeriscos++;
			cadena+="\n";
		}
		CantActeriscos-=2;
		while (CantActeriscos>=0) {
			cadena+= agregarACadena (CantActeriscos,"X");
			CantActeriscos--;
			cadena+="\n";
		}
		return cadena;
	} 
}
