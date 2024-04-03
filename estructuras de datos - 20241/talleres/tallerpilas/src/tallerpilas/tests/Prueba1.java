package tallerpilas.tests;

import org.junit.Test;

import tallerpilas.estructuras.Stack;

public class Prueba1 {

	public static <T> void eliminarElementos(Stack<T> p, int nivelInf, int nivelSup) {
		int lvl = 1;
		Stack<T> aux = new Stack<T>();
		while (!p.isEmpty()) {
			T element = p.pop();
			if (lvl < nivelInf || lvl > nivelSup)
				aux.push(element);
			lvl++;
		}
		while (!aux.isEmpty())
			p.push(aux.pop());
	}

	@Test
	public void pruebaEliminacion() {
		Stack<Integer> pila = new Stack<Integer>();
		pila.pushAll(40, 78, 12, 20, 10);
		System.out.println(pila);
		eliminarElementos(pila, 1, 2);
		System.out.println(pila);
	}

}
