package co.edu.uniquindio.concesionariouq.exceptions;

public class TransaccionYaExisteException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TransaccionYaExisteException(String smg) {
		super(smg);
	}
}
