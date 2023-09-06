package co.edu.uniquindio.p3.tallerrepaso1;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Dado un ArrayList de enteros, retornar los valores contenidos en él que hacen
 * parte de la serie Fibonacci. La serie Fibonacci comienza en 0,1 y los
 * siguientes términos se calculan sumando los dos números anteriores.
 * 
 * @author amador
 *
 */
public class Punto26 {
	public static void main(String[] args) {
		Integer[] numeros = { 4, 7, 2, 13, 1, 9, 6, 2, 3, 6 };
		ArrayList<Integer> lista = new ArrayList<Integer>();
		Collections.addAll(lista, numeros);
		ArrayList<Integer> numerosFibo = obtenerNumerosFibo(lista);
		System.out.println(numerosFibo);
	}

	private static ArrayList<Integer> obtenerNumerosFibo(ArrayList<Integer> lista) {
		if (lista.size() == 0)
			return new ArrayList<Integer>();
		int mayor = obtenerMayor(lista, 0, lista.get(0));
		ArrayList<Integer> listaFibo = new ArrayList<Integer>();
		ArrayList<Integer> listaResult = new ArrayList<Integer>();
		llenarListaFibo(mayor, listaFibo);
		llenarListaNumerosFibo(lista, listaFibo, listaResult, 0, 0);
		return listaResult;
	}

	private static void llenarListaNumerosFibo(ArrayList<Integer> lista, ArrayList<Integer> listaFibo,
			ArrayList<Integer> listaResult, int i, int j) {
		if (i == lista.size())
			return;
		if (j >= listaFibo.size()) {
			llenarListaNumerosFibo(lista, listaFibo, listaResult, i + 1, 0);
			return;
		}
		if (lista.get(i) == listaFibo.get(j)) {
			listaResult.add(lista.get(i));
			llenarListaNumerosFibo(lista, listaFibo, listaResult, i + 1, 0);
		} else {
			llenarListaNumerosFibo(lista, listaFibo, listaResult, i, j + 1);
		}

	}

	private static void llenarListaFibo(int mayor, ArrayList<Integer> lista) {
		llenarListaFiboAux(mayor, lista, 0, 1);
	}

	private static void llenarListaFiboAux(int mayor, ArrayList<Integer> listafibo, int i, int j) {
		if (i > mayor)
			return;
		listafibo.add(i);
		llenarListaFiboAux(mayor, listafibo, j, i + j);
	}

	private static int obtenerMayor(ArrayList<Integer> lista, int i, int mayor) {
		if (i >= lista.size())
			return mayor;
		return obtenerMayor(lista, i + 1, lista.get(i) > mayor ? lista.get(i) : mayor);
	}
}
