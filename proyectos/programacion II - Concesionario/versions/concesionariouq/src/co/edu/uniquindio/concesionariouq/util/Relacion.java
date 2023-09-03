package co.edu.uniquindio.concesionariouq.util;

public class Relacion<T1, T2> {
	private T1 valor1;
	private T2 valor2;

	public Relacion(T1 valor1, T2 valor2) {
		this.valor1 = valor1;
		this.valor2 = valor2;
	}

	/**
	 * @return the valor1
	 */
	public T1 getValor1() {
		return valor1;
	}

	/**
	 * @param valor1 the valor1 to set
	 */
	public void setValor1(T1 valor1) {
		this.valor1 = valor1;
	}

	/**
	 * @return the valor2
	 */
	public T2 getValor2() {
		return valor2;
	}

	/**
	 * @param valor2 the valor2 to set
	 */
	public void setValor2(T2 valor2) {
		this.valor2 = valor2;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((valor1 == null) ? 0 : valor1.hashCode());
		result = prime * result + ((valor2 == null) ? 0 : valor2.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Relacion<?, ?> other = (Relacion<?, ?>) obj;
		if (valor1 == null) {
			if (other.valor1 != null)
				return false;
		} else if (!valor1.equals(other.valor1))
			return false;
		if (valor2 == null) {
			if (other.valor2 != null)
				return false;
		} else if (!valor2.equals(other.valor2))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("Relacion [valor1=%s, valor2=%s]", valor1, valor2);
	}
}
