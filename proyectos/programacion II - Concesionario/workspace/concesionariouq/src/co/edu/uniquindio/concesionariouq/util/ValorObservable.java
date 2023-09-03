package co.edu.uniquindio.concesionariouq.util;

import java.util.function.BiConsumer;

public class ValorObservable<V> {
	private V value;
	private BiConsumer<V, V> consumer;

	public ValorObservable(V value, BiConsumer<V, V> consumer) {
		this.value = value;
		this.consumer = consumer;
	}

	public ValorObservable(BiConsumer<V, V> consumer) {
		this(null, consumer);
	}

	public ValorObservable() {
		this(null, null);
	}

	/**
	 * @return the value
	 */
	public V getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(V value) {
		V aux = this.value;
		this.value = value;
		if (consumer != null)
			consumer.accept(aux, this.value);
	}
}
