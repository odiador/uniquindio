package clase2302;

import java.util.ArrayList;
import java.util.Iterator;

public class ChuspeiIterator<R> implements Iterator<R> {

	private int i = 0;
	private ArrayList<R> lista;

	public ChuspeiIterator(ArrayList<R> lista) {
		this.lista = lista;

	}

	@Override
	public boolean hasNext() {
		return i < lista.size() - 1;
	}

	@Override
	public R next() {
		return lista.get(i++);
	}

}
