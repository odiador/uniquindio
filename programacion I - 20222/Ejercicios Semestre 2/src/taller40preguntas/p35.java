package taller40preguntas;

import esen.cial;

/*
 * Cree una función que reciba un mensaje y una palabra clave, el programa debe
 * encriptar el mensaje con base a la palabra clave que se ingresó, para lo cual, el
 * programa debe comparar los elementos del mensaje contra los elementos de la palabra
 * clave.
 */
public class p35 {
	public static void main (String args[]) {
		String mensaje = cial.leerString("Escribe el mensaje a codificar");
		String clave = cial.leerString("Escribe la cadena clave");
		String res = encriptarMensaje(mensaje,clave);
		cial.imprimir("La cadena encriptada es: "+ res);
	}
	public static String encriptarMensaje(String mensaje,String clave) {
		int cant = mensaje.length();
		String res = "";
		if(cant>clave.length()) {
			int faltan = cant-clave.length();
			for(int i = 0;i<faltan;i++) {
				clave+=clave.charAt(i)+"";
			}
		}
		if(cant<clave.length()) {
			int faltan = clave.length()-cant;
			for(int i = 0;i<faltan;i++) {
				mensaje+=mensaje.charAt(i)+"";
			}
		}
		for(int i = 0;i<cant;i++) {
			char caracter = (char) (mensaje.charAt(i)+clave.charAt(i));
			res+=caracter+"";
		}
		return res;
	}
}