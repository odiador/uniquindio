package taller40preguntas;
import esen.cial;
/*
 * Dado un arreglo de Strings, un mensaje encriptado y un numero entre 0 y 50 para
 * desencripción, hallar en el arreglo el mensaje original
 */
public class p11 {
	public static void main (String args[]) {
		int cant = cial.leerInt("Ingrese la cantidad de cadenas");
		String arr[] = new String[cant];
		for(int i = 0;i<cant;i++) {
			arr[i] = cial.leerString("Ingrese la cadena numero "+(i+1)+" ("+(i+1)+"/"+cant+"):");
		}
		int numero = cial.leerInt("Ingrese el numero para desencriptar");
		String mensajeEnc = cial.leerString("Ingrese la cadena encriptada");
		String mensajeO = hallarMensajeOriginal(arr,numero,mensajeEnc);
		cial.imprimir(mensajeO);
	}
	public static String desencriptar (String mensaje, int numero) {
		String mensajeDesenc = "";
		for(int i = 0;i<mensaje.length();i++) {
			char caracter = (char) (mensaje.charAt(i)+numero);
			mensajeDesenc+=caracter;
		}
		return mensajeDesenc;
	}
	public static String hallarMensajeOriginal (String arreglo[], int numero, String mensajeEncriptado) {
		String mensajeDesenc = desencriptar(mensajeEncriptado,numero);
		int pos = -7;
		for(int i= 0;i<arreglo.length;i++) {
			if(arreglo[i]==mensajeDesenc) pos = i;
		}
		String res = "No se encontro el mensaje original";
		if(pos!=-7) {
			pos++;
			res = "El mensaje original es: '"+mensajeDesenc+"', y está en la posición "+pos;
		}
		return res;
	}
}