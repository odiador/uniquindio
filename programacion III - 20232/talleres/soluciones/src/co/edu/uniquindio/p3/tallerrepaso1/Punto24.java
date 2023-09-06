package co.edu.uniquindio.p3.tallerrepaso1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

/**
 * Dado un ArrayList de tipo Integer (con números en base 10) retorne un
 * ArrayList con los números en base 2 de cada uno de sus elementos.
 * 
 * @author amador
 *
 */
public class Punto24 {
	public static void main(String[] args) {
		Integer[] numeros = { 13, 879, 311, 1044, 675 };
		ArrayList<Integer> lista = new ArrayList<>();
		Collections.addAll(lista, numeros);
		ArrayList<Double> listaBin = obtenerListaBinaria(lista);
		System.out.println(lista);
		listaBin.forEach(d -> {
			System.out.println(String.format("%.0f", d, Locale.US));
		});

	}

	private static ArrayList<Double> obtenerListaBinaria(ArrayList<Integer> lista) {
		ArrayList<Double> listaBinaria = new ArrayList<>();
		llenarListaBinaria(lista, listaBinaria, 0);
		return listaBinaria;
	}

	private static void llenarListaBinaria(ArrayList<Integer> lista, ArrayList<Double> listaBinaria, int i) {
		if (i >= lista.size()) {
			return;
		}
		listaBinaria.add(obtenerNumBinario(lista.get(i), 0, 1));
		llenarListaBinaria(lista, listaBinaria, i + 1);
	}

	public static Double obtenerNumBinario(int num, double i, double potencia) {
		if (num < 2)
			return i + num * potencia;
		return obtenerNumBinario(num / 2, i + (num % 2) * potencia, potencia * 10);
	}
}
