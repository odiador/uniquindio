package co.edu.uniquindio.concesionariouq.exceptions;

public class UsuarioNoEncontradoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Es el constructor de la clase {@link UsuarioNoEncontradoException}
	 * 
	 * @param msg
	 */
	public UsuarioNoEncontradoException(String msg) {
		super(msg);
	}
}
