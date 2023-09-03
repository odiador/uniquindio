package co.edu.uniquindio.concesionariouq.exceptions;

public class FiltroException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FiltroException(String msg) {
		super(msg);
	}

	public FiltroException() {
		super("Elige un filtro valido");
	}
}
