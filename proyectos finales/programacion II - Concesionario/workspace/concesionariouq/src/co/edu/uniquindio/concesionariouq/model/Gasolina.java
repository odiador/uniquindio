package co.edu.uniquindio.concesionariouq.model;

public class Gasolina extends Combustible {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public TipoCombustible getTipoCombustible() {
		return TipoCombustible.GASOLINA;
	}

	@Override
	public boolean atributosLlenos() {
		return true;
	}
}