package actividades;
import esen.cial;

public class patron2 {
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
		int cantEspacios = n-1;
		int CantActeriscos = 1;
		while (cantEspacios>=0) {
			cadena+= agregarACadena (cantEspacios,"  ");
			cadena+= agregarACadena (CantActeriscos,"X");
			CantActeriscos+=2;
			cantEspacios--;
			cadena+="\n";
		}
		CantActeriscos-=4;
		cantEspacios+=2;
		while (cantEspacios<=n) {
			cadena+= agregarACadena (cantEspacios,"  ");
			cadena+= agregarACadena (CantActeriscos,"X");
			CantActeriscos-=2;
			cantEspacios++;
			cadena+="\n";
		}
		return cadena;
	} 

}
