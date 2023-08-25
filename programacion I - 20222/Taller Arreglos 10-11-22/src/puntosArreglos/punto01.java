package puntosArreglos;

import javax.swing.JOptionPane;

/*
 * Dada una matriz de Strings (de n filas x 2 columnas), donde cada fila corresponde a un caso de
 * prueba (con dos palabras p1 y p2), devolver un vector que contenga las posiciones de las filas
 * de la matriz original que cumplen el criterio de ser palabras similares. Dos palabras son
 * similares si tienen la misma longitud y la información de p1 está en p2 en cualquier orden.
 */

public class punto01 {
	//Nota: En la clase AbrirTodos están todos los puntos
	public static void main(String[] args) {
		//Da una matriz cualquiera de x*2
		String matriz[][] = {
				{"cama","acma"},
				{"oso","roso"},
				{"tela","late"}
				};
		int vectorRes[] = generarVectorRes(matriz);
		imprimirMatrizString("La matriz inicial es: ",matriz);
		//imprime
		imprimirVectorInt("El vector resultante es:",vectorRes);

	}
	public static int[] generarVectorRes(String matriz[][]) {
		String res = "";
		for(int i = 0;i<matriz.length;i++) {
			String cad1 = obtenerCadenaOrd(matriz[i][0]);
			String cad2 = obtenerCadenaOrd(matriz[i][1]);
			//Si las palabras ordenadas son iguales se agrega a una
			//cadena para luego hacer .split y generar un vector
			if(cad1.equals(cad2)) res+=i+"-";
		}
		//como el vector generado con el .split es de Strings, se pasa a
		//int
		String vectorResS[] = res.split("-");

		int vectorRes[] = new int[vectorResS.length];
		for(int i = 0;i<vectorResS.length;i++) {
			vectorRes[i] = Integer.parseInt(vectorResS[i]);
		}
		return vectorRes;
	}

	public static char[] ordenarCadCaracteres (String cadena) {
		//ordena los caracteres de una cadena "cama" pasaría a "aacm"
		// y se guardan en un vector de chars, sería: ['a','a','c','m']
		char res[] = cadena.toCharArray();
		char aux;
		for(int j = 1;j<res.length;j++) {
			for(int i = 0;i<res.length-1;i++) {
				if (res[i]>res[i+1]) {
					aux = res[i];
					res[i] = res[i + 1];
					res[i+1] = aux;
				}
			}
		}
		return res;
	}
	//Junta el vector ordenado para obtener la cadena ordenada
	public static String obtenerCadenaOrd (String cadena) {

		String res = "";
		//En caso de que sea "cama" obtiene ['a','a','c','m']
		char caracteresOrd[] = ordenarCadCaracteres (cadena);
		//LLena un string vacío con cada caracter, quedando: "aacm"
		for(int i = 0;i<caracteresOrd.length;i++) {
			res+=caracteresOrd[i]+"";
		}
		return res;

	}
	//Imprime el resultado
	public static void imprimirVectorInt (String mensaje,int matriz[]) {
		mensaje +="\n";
		for(int i = 0; i<matriz.length;i++) {
			mensaje+="["+matriz[i]+"] ";
		}
		JOptionPane.showMessageDialog(null, mensaje);
	}
	public static void imprimirMatrizString (String mensaje,String matriz[][]) {
		mensaje +="\n";
		for(int i = 0; i<matriz.length;i++) {
			for(int j = 0; j<matriz[0].length;j++) {
				mensaje+="["+matriz[i][j]+"] ";
			}
			mensaje +="\n";
		}
		JOptionPane.showMessageDialog(null, mensaje);
	}
}
