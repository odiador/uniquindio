package puntosArreglos;

import java.util.ArrayList;

import javax.swing.JOptionPane;

/*
 * Dada una matriz de códigos de identificación con cinco dígitos, mostrar la posición de los códigos
 * que son palíndromos. Un código es palíndromo cuando puede ser leído lo mismo de izquierda a
 * derecha que de derecha a izquierda. Las posiciones de los códigos palíndromos se deben
 * almacenar y retornar en un ArrayList.
 */
public class punto02 {
	//Nota: En la clase AbrirTodos están todos los puntos
	public static void main (String args[]) {
		//Codigos cualquiera
		String codigos[][] = {
				{"65765","12321","78387","12345","73842","90162"},
				{"64764","12373","63861","80381","18581","00000"}
				};
		//obtiene los codigos palindromos
		ArrayList<String> posPalindromos = obtenerPosCodigosPalindromos(codigos);
		//imprime
		imprimirMatrizString("La matriz inicial es: ",codigos);
		imprimirConArrayList("Las posiciones con codigos palíndromos son: ",posPalindromos);
	}
	public static ArrayList<String> obtenerPosCodigosPalindromos (String codigos[][]){
		ArrayList<String> res = new ArrayList<String>();
		//Si es palindroma se agrega la posicion
		for(int i = 0;i<codigos.length;i++) {
			for(int j = 0;j<codigos[0].length;j++) {
				if(esPalindroma(codigos[i][j])) {
					String pos = "("+i+","+j+")";
					res.add(pos);
				}
			}

		}
		return res;
	}
	public static boolean esPalindroma (String cadena) {
		boolean res = true;
		int j = cadena.length()-1;
		//Si la parte inicial es la misma que la parte final contando de arriba hacia
		//abajo, si es palíndroma
		for(int i = 0; i<cadena.length()/2;i++) {
			if(cadena.charAt(i)!=cadena.charAt(j)) {
				res = false;
			}
			j--;
		}
		return res;
	}
	public static void imprimirConArrayList (String mensaje,ArrayList<String> codigos) {
		JOptionPane.showMessageDialog(null, mensaje+"\n"+codigos);
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