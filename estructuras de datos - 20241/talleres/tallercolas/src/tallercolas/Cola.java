package tallercolas;

import java.util.Comparator;

public class Cola<T> implements Cloneable {
	private Nodo nodoInicio;
	private int size;
	private Nodo nodoFinal;

	public void encolar(T valor) {
		final Nodo l = nodoFinal;
		final Nodo newNode = new Nodo(valor, l, null);
		nodoFinal = newNode;
		if (l == null)
			nodoInicio = newNode;
		else
			l.next = newNode;
		size++;
	}

	public T desencolar() {
		if (nodoInicio == null)
			throw new RuntimeException();
		final T element = nodoInicio.value;
		final Nodo next = nodoInicio.next;
		nodoInicio.value = null;
		nodoInicio.next = null;
		nodoInicio = next;
		if (next == null)
			nodoFinal = null;
		else
			next.prev = null;
		size--;
		return element;
	}

	public T peek() {
		if (nodoInicio == null)
			throw new RuntimeException();
		return nodoInicio.value;
	}

	public int size() {
		return size;
	}

	private class Nodo {
		T value;
		Nodo next;
		Nodo prev;

		public Nodo(T value, Nodo next, Nodo prev) {
			this.value = value;
			this.next = next;
			this.prev = prev;
		}
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		Cola<T> clon = new Cola<T>();
		for (int i = 0; i < size; i++) {
			T dato = desencolar();
			encolar(dato);
			clon.encolar(dato);
		}
		return clon;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		for (int i = 0; i < size(); i++) {
			T dato = desencolar();
			encolar(dato);
			sb.append(dato);
			if (i < size - 1) {
				sb.append(", ");
			}
		}
		sb.append(']');
		return sb.toString();
	}

	public void agregarElemento(int pos, T elemento) {
		if (pos < 0 || pos >= size)
			throw new IndexOutOfBoundsException("La posicion tiene que estar en el tamano");
		recorerCola(0, pos);
		encolar(elemento);
		recorerCola(pos, size);
	}

	private void recorerCola(int desde, int hasta) {
		for (int i = desde; i < hasta; i++)
			encolar(desencolar());
	}

	public boolean comparar(Cola<T> o) {
		if (size != o.size)
			return false;
		return true;
	}

	public void ordenarCola(Comparator<T> comparator) {
		if (size == 0 || size == 1)
			return;
		Cola<T> colaaux1 = new Cola<T>();
		Cola<T> colaaux2 = new Cola<T>();
		while (size > 0) {
			T valor = desencolar();
			if (colaaux1.estaVacia()) {

			}
		}

	}

	private boolean estaVacia() {
		return nodoInicio == null;
	}
}
