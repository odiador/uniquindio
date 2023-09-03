package co.edu.uniquindio.concesionariouq.model;

import java.io.Serializable;

public abstract class Combustible implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public abstract TipoCombustible getTipoCombustible();

	public abstract boolean atributosLlenos();
}