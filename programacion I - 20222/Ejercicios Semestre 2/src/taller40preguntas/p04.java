package taller40preguntas;

import esen.cial;
//Pasar de decimal a hexadecimal, almacenar el resultado en un String.
public class p04 {	public static void main(String[] args) {
	int num =cial.leerInt("Escriba el numero que se va a pasar a hexadecimal:");
	String x = pasaraHex(num);
	cial.imprimir("El resultado es: "+x);
}
	public static String pasaraHex(int numero) {
		int x = numero;
		int contador = 1;
		while (x>16) {
			contador++;
			x = x/16;
		}
		int array[] = new int [contador];
		for(int i = (contador-1);i>=0;i--) {
			array[i] = numero%16;
			numero = numero/16;
		}
		String resultado = "";
		for(int i = 0;i<contador;i++) {
			if		(array[i]< 10) resultado+=array[i]+"";
			else if	(array[i]==10) resultado+="A";
			else if	(array[i]==11) resultado+="B";
			else if	(array[i]==12) resultado+="C";
			else if	(array[i]==13) resultado+="D";
			else if	(array[i]==14) resultado+="E";
			else if	(array[i]==15) resultado+="F";
		}
		return resultado;
	}
}
