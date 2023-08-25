package taller40preguntas;

import esen.cial;

/*
 * Encriptación de mensajes. Uno de los métodos más antiguos para codificar mensajes es el conocido
 * como cifrado Cesar. Su funcionamiento es simple: cada una de las letras del mensaje original es
 * sustituida por otra letra que se encuentra un número fijo de posiciones más adelante en el alfabeto.
 *
 * Así, si utilizamos un desplazamiento de 2, las apariciones de la letra 'a'se sustituyen por la 'c',
 * todas las apariciones de la 'b'; por 'd', etc. El método tradicional comienza de nuevo al llegar al
 * final del alfabeto, de forma que, con el desplazamiento de 2, la 'y' se sustituye por la
 * 'a'; y la 'z' se sustituye por la 'b'.
 *
 * Los desplazamientos también pueden ser negativos; si utilizamos un desplazamiento de -1, la 'E' se
 * convertirá en 'D', mientras que la 'a' pasará a ser ‘z’.
 */
public class p27 {
	public static void main (String args[]) {
		String mensaje = cial.leerString("Escribe el mensaje a decodificar");
		int cantidad = cial.leerInt("Escribe la cantidad de posiciones a mover");
		String mensajeDec =decodificarMensaje(mensaje, cantidad);
		cial.imprimir("El mensaje decodificado es "+mensajeDec);
	}
	public static char restar(char caracter,int cantidad,boolean minus) {
		char nuevoCar = (char) (caracter+cantidad);
		if (minus) {
			char carAux= ' ';
			if(nuevoCar<='a') {
				carAux = (char) (caracter+26);
				nuevoCar = (char) (carAux+cantidad);
			} else if(nuevoCar>='z') {
				carAux = (char) (caracter-26);
				nuevoCar = (char) (carAux+cantidad);
			}

		}
		if (!minus) {
			char carAux= ' ';
			if(nuevoCar<='A') {
				carAux = (char) (caracter+26);
				nuevoCar = (char) (carAux+cantidad);
			} else if(nuevoCar>='Z') {
				carAux = (char) (caracter-26);
				nuevoCar = (char) (carAux+cantidad);
				}

		}
		return nuevoCar;
	}
	public static boolean esMinus(char caracter) {
		boolean res = false;
		if(caracter>='a'&&caracter<='z') res = true;
		return res;
	}
	public static boolean estaEnAlfabeto(char caracter) {
		boolean res = false;
		if(caracter>='a'&&caracter<='z') res = true;
		if(caracter>='A'&&caracter<='Z') res = true;
		return res;
	}
	public static String decodificarMensaje (String cadena,int cantidad) {
		int cant = cadena.length();
		String res = "";
		for(int i = 0;i<cant;i++) {
			char caracter = cadena.charAt(i);

			if(estaEnAlfabeto(caracter)) {
				char caracterDec = restar(caracter,cantidad,esMinus(caracter));
				res+=caracterDec+"";
			} else {
				res+=" ";
			}

		}
		return res;
	}
}
