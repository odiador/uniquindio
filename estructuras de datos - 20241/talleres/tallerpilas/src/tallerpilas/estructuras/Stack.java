package tallerpilas.estructuras;

import java.util.NoSuchElementException;

/**
 * @param <T>
 */
public class Stack<T> {

	private StackNode pointer;

	private class StackNode {
		StackNode next;
		T value;

		StackNode(StackNode next, T value) {
			this.next = next;
			this.value = value;
		}

	}

	public void push(T element) {
		if (pointer == null)
			pointer = new StackNode(null, element);
		else
			pointer = new StackNode(pointer, element);
	}

	public T pop() {
		if (pointer == null)
			throw new NoSuchElementException("");
		T t = pointer.value;
		pointer = pointer.next;
		return t;
	}

	public boolean isEmpty() {
		return pointer == null;
	}

	public T peek() {
		if (pointer == null)
			throw new NoSuchElementException("");
		return pointer.value;
	}

	private synchronized String getValuesString() {
		StringBuilder sb = new StringBuilder("[");
		Stack<T> aux = new Stack<T>();
		while (!this.isEmpty()) {
			T value = this.pop();
			sb.append(value.toString());
			if (!this.isEmpty())
				sb.append(", ");
			aux.push(value);
		}
		while (!aux.isEmpty())
			this.push(aux.pop());
		sb.append("]");
		return sb.toString();
	}

	@SafeVarargs
	public final void pushAll(T... values) {
		for (T val : values)
			push(val);
	}

	@Override
	public String toString() {
		return getValuesString();
	}

}
