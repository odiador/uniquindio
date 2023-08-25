package esen;

import javax.swing.JOptionPane;

public class cial {
	/**
	 * Lee una cadena ingresada por el usuario
	 * por medio de un JOptionPane.
	 * @param msg mensaje a preguntar
	**/
	public static String leerString(String msg) {

		return JOptionPane.showInputDialog(msg);
	}
	/**
	 * Lee un valor de tipo double ingresado por el usuario
	 * por medio de un JOptionPane.
	 * @param msg mensaje a preguntar
	**/
	public static double leerDouble(String msg) {
		return Double.parseDouble(JOptionPane.showInputDialog(msg));
	}
	/**
	 * Lee un valor de tipo int ingresado por el usuario
	 * por medio de un JOptionPane.
	 * @param msg mensaje a preguntar
	**/
	public static int leerInt(String msg) {
		return Integer.parseInt(JOptionPane.showInputDialog(msg));
	}
	/**
	 * Imprime un mensaje
	 * por medio de un JOptionPane.
	 * @param msg mensaje a imprimir
	**/
	public static void imprimir (String msg) {
		JOptionPane.showMessageDialog(null, msg);
	}
	/**
	 * Convierte un arreglo de tipo {@code int} a un {@code String}
	 * para que se pueda imprimir de manera mas sencilla
	 * <br><br><b>Ejemplo:</b>
	 * <li> Se tiene un arreglo con los datos: {1,2,3,5,6,2} <br>
	 * El valor de retorno va a ser "[1] [2] [3] [5] [6] [2]".
	 *
	 * @param arreglo el arreglo a transformar
	 * @return el {@code String} arreglo escrito a manera de cadena
	 *
	**/
	public static String arregloIaString (int arreglo[]) {
		int n = arreglo.length;
		String mensaje = "";
		for (int i=0;i<n;i++) {
			mensaje+="["+arreglo[i]+"] ";
		}
		return mensaje;
	}
	/**
	 * Convierte un arreglo de tipo {@code double} a un {@code String}
	 * para que se pueda imprimir de manera mas sencilla
	 * <br><br><b>Ejemplo:</b>
	 * <li> Se tiene un arreglo con los datos: {1.3,2.1,3.6} <br>
	 * El valor de retorno va a ser "[1.3] [2.1] [3.6]".
	 *
	 * @param arreglo el arreglo a transformar
	 * @return el {@code String} arreglo escrito a manera de cadena
	 *
	**/
	public static String arregloDaString (double arreglo[]) {
		int n = arreglo.length;
		String mensaje = "";
		for (int i=0;i<n;i++) {
			mensaje+="["+arreglo[i]+"] ";
		}
		return mensaje;
	}
	/**
	 * Convierte un arreglo de tipo {@code boolean} a un {@code String}
	 * para que se pueda imprimir de manera mas sencilla
	 * <br><br><b>Ejemplo:</b>
	 * <li> Se tiene un arreglo con los datos: {true,false,false} <br>
	 * El valor de retorno va a ser "[true] [false] [false]".
	 *
	 * @param arreglo el arreglo a transformar
	 * @return el {@code String} arreglo escrito a manera de cadena
	 *
	**/
	public static String arregloBaString (boolean arreglo[]) {
		int n = arreglo.length;
		String mensaje = "";
		for (int i=0;i<n;i++) {
			mensaje+="["+arreglo[i]+"] ";
		}
		return mensaje;
	}
	/**
	 * Convierte un arreglo de tipo {@code String} a un {@code String}
	 * para que se pueda imprimir de manera mas sencilla
	 * <br><br><b>Ejemplo:</b>
	 * <li> Se tiene un arreglo con los datos: {"Juan","María","Andrés"} <br>
	 * El valor de retorno va a ser "[Juan] [María] [Andrés]".
	 *
	 * @param arreglo el arreglo a transformar
	 * @return el {@code String} arreglo escrito a manera de cadena
	 *
	**/
	public static String arregloSaString (String arreglo[]) {
		int n = arreglo.length;
		String mensaje = "";
		for (int i=0;i<n;i++) {
			mensaje+="["+arreglo[i]+"] ";
		}
		return mensaje;
	}
	/**
	 * Crea un arreglo de tipo {@code String} a partir de la cantidad de datos
	 * y con un mensaje de pregunta
	 *
	 * @param cant la cantidad de datos a preguntar
	 * @param mensaje el mensaje a preguntar para cada cadena
	 * @return un arreglo de tipo {@code String}
	 *
	**/
	public static String[] generarArrString (int cant,String mensaje) {
		String arr[] = new String[cant];
		for (int i = 0;i<cant;i++) {
			arr[i] = leerString(mensaje+ " ("+(i+1)+" / "+cant+")");
		}
		return arr;
	}
	/**
	 * Crea un arreglo de tipo {@code double} a partir de la cantidad de datos
	 * y con un mensaje de pregunta
	 *
	 * @param cant la cantidad de datos a preguntar
	 * @param mensaje el mensaje a preguntar para cada cadena
	 * @return un arreglo de tipo {@code double}
	 *
	**/
	public static double[] generarArrDouble (int cant,String mensaje) {
		double arr[] = new double[cant];
		for (int i = 0;i<cant;i++) {
			arr[i] = leerDouble(mensaje+ " ("+(i+1)+" / "+cant+")");
		}
		return arr;
	}
	/**
	 * Crea un arreglo de tipo {@code int} a partir de la cantidad de datos
	 * y con un mensaje de pregunta
	 *
	 *
	 * @param cant la cantidad de datos a preguntar
	 * @param mensaje el mensaje a preguntar para cada cadena
	 * @return un arreglo de tipo {@code int}
	 *
	**/
	public static int[] generarArrInt (int cant,String mensaje) {
		int arr[] = new int[cant];
		for (int i = 0;i<cant;i++) {
			arr[i] = leerInt(mensaje+ " ("+(i+1)+" / "+cant+")");
		}
		return arr;
	}
	/**
	 * De una cadena de tipo {@code String} retorna solo los números
	 *
	 * <br><br><b>Ejemplo:</b>
	 * <li> Se tiene la cadena: "ASD125", de esa cadena se va a retornar <br>
	 * el número 125.
	 * @param cadena la cadena a transformar
	 * @return un numero de tipo {@code int}
	 *
	**/
	public static int sacarNumsDeString(String cadena) {
		String res = "";
		for(int i = 0;i<cadena.length();i++) {
			char caracter = cadena.charAt(i);
			if (caracter>='0' && caracter<='9') res+=caracter+"";
		}
		int num = Integer.parseInt(res);
		return num;
	}
}
