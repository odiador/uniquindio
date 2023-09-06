package co.edu.uniquindio.p3.tallerrepaso1;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Escriba un método que recorra un ArrayList de tipo Integer, y verifique si la
 * suma de todos sus elementos es un múltiplo de su tamaño.
 * 
 * @author amador
 *
 */
public class Punto25 {
	public static void main(String[] args) {
		final Integer[] numerosArray = { 1, 1, 1, 1, 1, 1, 4, -1, 0 };
		final ArrayList<Integer> lista = new ArrayList<>();
		Collections.addAll(lista, numerosArray);
		boolean sumaIgual = sumaEsIgualTam(lista);
		System.out.println(sumaIgual);
	}

	private static boolean sumaEsIgualTam(ArrayList<Integer> lista) {
		return lista.size() == sumarElementos(lista);
	}

	private static int sumarElementos(ArrayList<Integer> lista) {
		return sumarElementosAux(lista, 0);
	}

	private static int sumarElementosAux(ArrayList<Integer> lista, int i) {
		if (i == lista.size())
			return 0;
		return lista.get(i) + sumarElementosAux(lista, i + 1);
	}
}
