package co.edu.uniquindio.biblioteca.model;

public class BibliotecaException extends Exception {

	/**
	 * Es el error en caso de que no se haya podido realizar algún proceso de la
	 * biblioteca
	 * 
	 * @param mensaje
	 */
	public BibliotecaException(String mensaje) {
		super(mensaje);
	}

}
