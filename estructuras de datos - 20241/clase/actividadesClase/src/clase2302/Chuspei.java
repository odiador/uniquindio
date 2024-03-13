package clase2302;

import java.util.ArrayList;
import java.util.Iterator;

public class Chuspei<R> implements Iterable<R> {
	private final ArrayList<R> lista = new ArrayList<R>();

	public ArrayList<R> getLista() {
		return lista;
	}

	@Override
	public Iterator<R> iterator() {
		return new ChuspeiIterator<R>(lista);
	}

}
