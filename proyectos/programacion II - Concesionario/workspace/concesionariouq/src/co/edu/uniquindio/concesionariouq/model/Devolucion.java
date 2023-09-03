package co.edu.uniquindio.concesionariouq.model;

public class Devolucion extends Transaccion {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Cliente cliente;

	/**
	 * Es el constructor de la clase {@link Devolucion}
	 * 
	 * @param codigo
	 * @param vehiculo
	 * @param valor
	 * @param fechaLimite
	 * @param cliente
	 * 
	 */
	public Devolucion(Vehiculo vehiculo, Double valor, Cliente cliente) {
		super(vehiculo, valor);
		this.cliente = cliente;
	}

	@Override
	public TipoTransaccion getTipoTransaccion() {
		return TipoTransaccion.ALQUILER;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
