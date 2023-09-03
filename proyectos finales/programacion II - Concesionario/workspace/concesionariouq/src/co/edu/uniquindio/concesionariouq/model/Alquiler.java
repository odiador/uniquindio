package co.edu.uniquindio.concesionariouq.model;

import java.time.LocalDate;

public class Alquiler extends Transaccion {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private LocalDate fechaLimite;
	private Cliente cliente;

	/**
	 * Es el constructor de la clase {@link Alquiler}
	 * 
	 * @param codigo
	 * @param vehiculo
	 * @param valor
	 * @param fechaLimite
	 * @param cliente
	 * 
	 */
	public Alquiler(Vehiculo vehiculo, Double valor, LocalDate fechaLimite, Cliente cliente) {
		super(vehiculo, valor);
		this.fechaLimite = fechaLimite;
		this.cliente = cliente;
	}

	@Override
	public boolean atributosLlenos() {
		return super.atributosLlenos() && fechaLimite != null && cliente.atributosLlenos();
	}

	@Override
	public TipoTransaccion getTipoTransaccion() {
		return TipoTransaccion.ALQUILER;
	}

	public LocalDate getFechaLimite() {
		return fechaLimite;
	}

	public void setFechaLimite(LocalDate fechaLimite) {
		this.fechaLimite = fechaLimite;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return String.format("Alquiler [vehiculo=%s, valor=%s, momento=%s, fechaLimite=%s, cliente=%s]", vehiculo,
				valor, momento, fechaLimite, cliente);
	}

}
