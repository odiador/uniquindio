package co.edu.uniquindio.carrouq.model;

public class DetalleTransaccion {
	private Vehiculo vehiculo;
	private String codigoTransaccion;
	private TipoTransaccion tipo;

	/**
	 * 
	 */
	public DetalleTransaccion() {
	}

	/**
	 * 
	 * @return
	 */
	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	/**
	 * 
	 * @param vehiculo
	 */
	public void setVehiculo(final Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	/**
	 * 
	 * @return
	 */
	public String getCodigoTransaccion() {
		return codigoTransaccion;
	}

	/**
	 * 
	 * @param codigoTransaccion
	 */
	public void setCodigoTransaccion(final String codigoTransaccion) {
		this.codigoTransaccion = codigoTransaccion;
	}

	/**
	 * 
	 * @return
	 */
	public TipoTransaccion getTipo() {
		return tipo;
	}

	/**
	 * 
	 * @param tipo
	 */
	public void setTipo(final TipoTransaccion tipo) {
		this.tipo = tipo;
	}

}