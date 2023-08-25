package taller40preguntas;

import esen.cial;
/*
 * Vector de palabras: se tiene un vector de tipo String donde en cada celda está almacenada una palabra
 * correspondiente a un texto recibido.
 */
public class p23 {
	public static void main (String args[]) {
		String opcion;
		int cant = cial.leerInt("Ingrese la cantidad de cadenas");
		String vector[] = new String[cant];
		for(int i = 0;i<cant;i++) {
			vector[i] = cial.leerString("Ingrese la cadena numero "+(i+1)+" ("+(i+1)+"/"+cant+"):");
		}
		//String vector[] = {"Juan","Andres","Juan","Alejo","Carlos","Andres","Simon","Juan","Andres"};
		String vectorString = cial.arregloSaString(vector);
		String mensaje = "Bienvenido al programa de manejo de vectores de palabras"
				+ "\n"+vectorString
				+ "\na. El numero de palabras únicas (no repetidas) que hay en el texto"
				+ "\nb. Las palabras repetidas y el numero de ocurrencia."
				+ "\nc. La densidad de palabras, es decir las palabras que más se repiten"
				+ "\nd. Buscar las palabras que empiece por una letra dada por el usuario"
				+ "\ne. Salir";

		while (true) {
			opcion = cial.leerString(mensaje);
			switch (opcion) {
			case "a": puntoa(vector);
			break;
			case "b": puntob(vector);
			break;
			case "c": puntoc(vector);
			break;
			case "d": puntod(vector);
			break;
			default: System.exit(0);
			}
		}
	}
	/*
	 *********************punto a*************************************
	 *El numero de palabras únicas (no repetidas) que hay en el texto*
	 *****************************************************************
	 */
	public static String[] generarArrSinR (String arr[]) {
		String res = "";
		for (int i = 0;i<arr.length;i++) {
			boolean estaLibre = true;
			for (int j = 0;j<i;j++) {
				if(arr[i].equals(arr[j])) estaLibre=false;
			}
			if(estaLibre) res+= arr[i]+"-";
		}
		return res.split("-");
	}
	public static int[] generarArrFrec (String arr[],String arrSinR[]) {
		int arrFrec[] = new int [arrSinR.length];
		for (int j = 0;j<arrSinR.length;j++) {
			int cant = 0;
			for (int i = 0;i<arr.length;i++) {
				if (arr[i].equals(arrSinR[j])) cant++;
			}
			arrFrec[j] = cant;
		}
		return arrFrec;
	}
	public static void puntoa(String arr[]) {
		String arrSinR[] = generarArrSinR(arr);
		int arrFrec[] = generarArrFrec(arr,arrSinR);
		cial.imprimir(" El numero de palabras únicas es de "+arrFrec.length);
	}

	/*
	 *********************punto b***********************
	 *Las palabras repetidas y el numero de ocurrencia.*
	 ***************************************************
	 */
	public static void puntob(String arr[]) {
		String arrSinR[] = generarArrSinR(arr);
		int arrFrec[] = generarArrFrec(arr,arrSinR);
		String mensaje = "Las palabras con su frecuencia son:\n";
		int cant = arrSinR.length;
		for(int i = 0;i<cant-1;i++) {
			mensaje+=arrSinR[i]+" con "+arrFrec[i]+", ";
		}
		mensaje+="y "+arrSinR[cant-1]+" con "+arrFrec[cant-1]+".";
		cial.imprimir(mensaje);
	}
	/*
	 *********************punto c***************************************
	 *La densidad de palabras, es decir las palabras que más se repiten*
	 *******************************************************************
	 */
	public static int sacarMayor (int arrFrec[]) {
		int mayor = arrFrec[0];
		for (int i = 1;i<arrFrec.length;i++) {
			if(arrFrec[i]>mayor) mayor = arrFrec[i];
		}
		return mayor;
	}
	public static String[] sacarMayores (String arrSinR[],int arrFrec[],int mayor) {
		String mayores = "";
		for(int i = 0;i<arrFrec.length;i++) {
			if(arrFrec[i]==mayor) mayores+=arrSinR[i]+"-";
		}
		return mayores.split("-");
	}
	public static void puntoc(String arr[]) {
		String arrSinR[] = generarArrSinR(arr);
		int arrFrec[] = generarArrFrec(arr,arrSinR);
		int mayor = sacarMayor(arrFrec);
		String masDensas[] = sacarMayores (arrSinR,arrFrec,mayor);
		String mensaje = "La palabra mas densa es:\n"+masDensas[0]+" con una frecuencia de "+mayor+".";
		if(masDensas.length>1) {
			mensaje = "Las palabras mas densas son:\n";
			for(int i = 0;i<masDensas.length-1;i++) {
				mensaje+=masDensas[i]+", ";
			}
			mensaje+="y "+masDensas[masDensas.length-1]+" con una frecuencia de "+mayor+".";
		}
		cial.imprimir(mensaje);
	}
	/*
	 *************************punto d***********************************
	 *Buscar las palabras que empiece por una letra dada por el usuario*
	 *******************************************************************
	 */
	public static boolean cumpleRequisitos (String cadena,char letra) {
		boolean res = false;
		char caracter = cadena.charAt(0);
		if(caracter>='a'&&caracter<='z') caracter-=32;
		if(letra>='a'&&letra<='z') letra-=32;
		if (caracter==letra) {
			res = true;
		}
		return res;
	}
	public static String[] generarPalabrasQueCumplen (String arr[],char letra) {
		String res = "";
		for(int i = 0;i<arr.length;i++) {
			if(cumpleRequisitos(arr[i],letra)) res+=arr[i]+"-";
		}
		return res.split("-");
	}
	public static void puntod(String arr[]) {
		char letra = cial.leerString("Escriba la letra de busqueda").charAt(0);
		String arrSinR[] = generarArrSinR(arr);
		String arrRes[] = generarPalabrasQueCumplen (arrSinR,letra);
		String mensaje = "La palabra que empieza por "+letra+" es: "+arrRes[0];
		if(arrRes.length>1) {
			mensaje = "Las palabras que empiezan por "+letra+" son:\n";
			for(int i = 0;i<arrRes.length-1;i++) {
				mensaje+=arrRes[i]+", ";
			}
			mensaje+="y "+arrRes[arrRes.length-1]+".";
		}
		cial.imprimir(mensaje);
	}
}
