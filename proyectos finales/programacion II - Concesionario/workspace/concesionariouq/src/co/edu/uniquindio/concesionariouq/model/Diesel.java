package co.edu.uniquindio.concesionariouq.model;

public class Diesel extends Combustible {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public TipoCombustible getTipoCombustible() {
		return TipoCombustible.DIESEL;
	}

	@Override
	public boolean atributosLlenos() {
		return true;
	}

	@Override
	public String toString() {
		return String.format("Diesel []");
	}
}