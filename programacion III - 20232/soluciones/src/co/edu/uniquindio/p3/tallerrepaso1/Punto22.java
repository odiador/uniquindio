package co.edu.uniquindio.p3.tallerrepaso1;

import java.util.ArrayList;

/**
 * Escriba un método que invierta un ArrayList de cualquier tipo.
 * 
 * @author amador
 *
 */
public class Punto22 {
	public static void main(String[] args) {
		ArrayList<String> lista = new ArrayList<String>();
		lista.add("Santiago");
		lista.add("Valentina");
		lista.add("Mateo");
		lista.add("Maria");
		lista.add("Juan");
		lista.add("Camila");
		lista.add("Lucas");
		lista.add("Isabella");
		lista.add("Matias");
		lista.add("Sofia");
		ArrayList<String> arrayInvertido = invertirArr(lista);
		System.out.println(arrayInvertido);
	}

	private static <T> ArrayList<T> invertirArr(ArrayList<T> lista) {
		ArrayList<T> listaNueva = new ArrayList<T>();
		invertirArrAux(lista, listaNueva, 0);
		return listaNueva;
	}

	private static <T> void invertirArrAux(ArrayList<T> lista, ArrayList<T> listaNueva, int i) {
		if (i == lista.size())
			return;
		listaNueva.add(lista.get(lista.size() - 1 - i));
		invertirArrAux(lista, listaNueva, i + 1);
	}
}
