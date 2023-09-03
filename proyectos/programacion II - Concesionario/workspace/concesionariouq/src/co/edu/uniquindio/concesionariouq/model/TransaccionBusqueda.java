package co.edu.uniquindio.concesionariouq.model;

import java.time.LocalDateTime;

public class TransaccionBusqueda extends Transaccion {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TransaccionBusqueda(LocalDateTime momento) {
		super(null, null);
		this.momento = momento;
	}

	@Override
	public TipoTransaccion getTipoTransaccion() {
		return null;
	}

}
