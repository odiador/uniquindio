package clase5;
import esen.*;

public class usodeString {
	public static void main (String args[]) {

		String cadena = cial.leerString("Escribe la cadena que quieres usar para la gestión:");
		String pregunta = "Bienvenidos a la gestión de cadenas: "
				+ "\nPor favor selecciona la opción que deseas probar:"
				+ "\n Cadena: "+cadena+ "."
				+ "\n"
				+ "\n1. Convertir la cadena ingresada en mayúscula."
				+ "\n2. Decir la cantidad de caracteres de la cadena (tamaño)."
				+ "\n3. Contar la cantidad de minúsculas de la cadena."
				+ "\n4. Concatenar una nueva cadena a la que ya se ingreso al inicio, si es diferente."
				+ "\n5. Sacar el ultimo caracter de una cadena y determinar si es vocal."
				+ "\n6. Mostrar la cadena sin vocales, solo si el ultimo caracter es vocal."
				+ "\n7. Mostrar solo los numeros de una cadena, solo si el último caracter es una consonante."
				+ "\n8. Mostrar una porción de la cadena, pidiendo el origen y el fin."
				+ "\n9. La 8 pero con substring."
				+ "\n0. Salir.";

		while (true) {
			int opcion = cial.leerInt(pregunta);
			calcularGestion(opcion,cadena);
		}
	}
	public static String pasaraMayus(String cadena) {
		String resultado =  cadena.toUpperCase();
		return resultado;
	}
	public static String cantCaracteres(String cadena) {
		int cant = cadena.length();
		String resultado = cant+"";
		return resultado;
	}
	public static String cantMinus(String cadena) {
		String resultado;
		int cant = cadena.length();
		int contador = 0;
		for (int i = 0;i<cant;i++) {
			char caracter = cadena.charAt(i);
			for (char x = 'a';x<='z';x++) {
				if (caracter == x) contador++;
			}
		}
		resultado = contador+"";
		return resultado;
	}
	public static String agregarCadena(String cadena1) {
		String resultado = cadena1;
		String cadena2 = cial.leerString("Escribe la segunda cadena que quieres usar: ");
		if (!cadena1.equals(cadena2)) resultado= cadena1+ ""+cadena2;
		return resultado;
	}
	public static String determinarsiesVocal(String cadena) {
		int cant = cadena.length();
		char ultimaLetra = cadena.charAt(cant-1);
		boolean res = false;
		if (ultimaLetra=='a'|| ultimaLetra=='e' || ultimaLetra=='i' || ultimaLetra=='o' ||ultimaLetra=='u'||ultimaLetra=='A'|| ultimaLetra=='E' || ultimaLetra=='I' || ultimaLetra=='O' ||ultimaLetra=='U') {
			res = true;
		}
		String resultado = res+"";
		return resultado;
	}
	public static String sinVocales(String cadena) {
		String resultado = "";
		int cant = cadena.length();
		if (Boolean.getBoolean(determinarsiesVocal(cadena))) {
			for(int i = 0;i<cant;i++) {
				char caracter = cadena.charAt(i);
				if (caracter!='a' && caracter!='e' && caracter!='i' && caracter!='o' && caracter!='u') {
					resultado+= ""+caracter;
				}
			}
		}
		return resultado;
	}
	public static String mostrarNums(String cadena) {
		String resultado = "";
		int cant = cadena.length();
		char primerCaracter = cadena.charAt(cant-1);
		if (primerCaracter>=65 && primerCaracter<=90 ||primerCaracter>=97 && primerCaracter<=122 || primerCaracter == 164 || primerCaracter == 165) {
			for (int i = 0;i<cant;i++) {
				char caracter = cadena.charAt(i);
				for (char x = '0';x<='9';x++) {
					if (caracter == x) resultado +=caracter+"";
				}
			}
		} else {
			resultado="El ultimo caracter no es cadena";
		}
		return resultado;
	}
	public static String porcionCadena(String cadena) {
		int inicialCadena = cial.leerInt("Escribe la primera parte de la cadena: ");
		int finalCadena = cial.leerInt("Escribe la segunda parte de la cadena: ");
		String resultado = "";
		for (int i = inicialCadena;i<=finalCadena; i++) {
			resultado+=cadena.charAt(i)+"";
		}
		return resultado;
	}
	public static String porcionCadena2(String cadena) {
		int inicialCadena = cial.leerInt("Escribe la primera parte de la cadena: ");
		int finalCadena = cial.leerInt("Escribe la segunda parte de la cadena: ");
		String resultado = cadena.substring(inicialCadena,finalCadena+1);
		return resultado;
	}
	public static void calcularGestion(int opcion,String cadena) {
		String resultado = "";
		if      (opcion == 1) resultado = pasaraMayus(cadena);
		else if (opcion == 2) resultado = cantCaracteres(cadena);
		else if (opcion == 3) resultado = cantMinus(cadena);
		else if (opcion == 4) resultado = agregarCadena(cadena);
		else if (opcion == 5) resultado = determinarsiesVocal(cadena);
		else if (opcion == 6) resultado = sinVocales(cadena);
		else if (opcion == 7) resultado = mostrarNums(cadena);
		else if (opcion == 8) resultado = porcionCadena(cadena);
		else if (opcion == 9) resultado = porcionCadena2(cadena);
		else if (opcion == 0) System.exit(0);
		else cial.imprimir("Error, inténtalo de nuevo");
		cial.imprimir(resultado);
	}
}