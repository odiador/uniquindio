package co.edu.uniquindio.concesionariouq.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public abstract class Transaccion implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected Vehiculo vehiculo;
	protected Double valor;
	protected LocalDateTime momento;

	/**
	 * Este es el constructor principal de la clase {@link Transaccion}
	 * 
	 * @param vehiculo
	 * @param valor
	 */
	public Transaccion(final Vehiculo vehiculo, final Double valor) {
		this.momento = LocalDateTime.now();
		this.vehiculo = vehiculo;
		this.valor = valor;
	}

	public abstract TipoTransaccion getTipoTransaccion();

	public boolean atributosLlenos() {
		return vehiculo != null && vehiculo.atributosLlenos();
	}

	/**
	 * @return the vehiculo
	 */
	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	/**
	 * @param vehiculo the vehiculo to set
	 */
	public void setVehiculo(final Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public LocalDateTime getMomento() {
		return momento;
	}

	public void setMomento(LocalDateTime momento) {
		this.momento = momento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((momento == null) ? 0 : momento.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		// se cambio para que 2 transacciones en la misma fecha puedan ser iguales
		if (!(obj instanceof Transaccion))
			return false;
		Transaccion other = (Transaccion) obj;
		if (momento == null) {
			if (other.momento != null)
				return false;
		} else if (!momento.equals(other.momento))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("Transaccion [vehiculo=%s, valor=%s, momento=%s]", vehiculo, valor, momento);
	}

}