package clase0103;

import java.util.Objects;

public class ListaEnlazada<T> {

	private Nodo<T> first;
	private int size;

	public void agregarElemento(T elemento) {
		Nodo<T> holi = first;
		if (holi == null) {
			holi = new Nodo<T>(elemento);
			size = 1;
			return;
		}
		while (holi.next != null)
			holi = holi.next;
		holi.next = new Nodo<T>(elemento);
		size++;
	}

	public void addFirst(T elemento) {
		Nodo<T> holi = new Nodo<T>(elemento);
		Nodo<T> aux = first;
		first = holi;
		first.next = aux;
		size++;
	}

	public boolean estaVacia() {
		return first == null;
	}

	public int bucarIndice(T elemento) {
		Nodo<T> holi = first;
		int i = 0;
		while (holi != null) {
			if (holi.elemento.equals(elemento))
				return i;
			i++;
			holi = holi.next;
		}
		return -1;
	}

	private static class Nodo<T> {

		private T elemento;
		private Nodo<T> next;

		public Nodo(T elemento) {
			this.elemento = elemento;
		}

		@Override
		public int hashCode() {
			return Objects.hash(elemento);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Nodo<?> other = (Nodo<?>) obj;
			return Objects.equals(elemento, other.elemento);
		}
	}
}
