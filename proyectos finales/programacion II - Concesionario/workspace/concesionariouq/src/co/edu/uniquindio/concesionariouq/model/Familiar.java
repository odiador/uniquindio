package co.edu.uniquindio.concesionariouq.model;

import javafx.scene.image.Image;

public abstract class Familiar extends Automovil {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected Boolean tieneAireAcondicionado;
	protected Boolean tieneCamaraReversa;
	protected Boolean tieneABS;

	/**
	 * Es el constructor de la clase {@link Familiar}
	 * 
	 * @param id
	 * @param marca
	 * @param modelo
	 * @param cilindraje
	 * @param velocidadMaxima
	 * @param combustible
	 * @param estado
	 * @param tipo
	 * @param numeroPasajeros
	 * @param numeroBolsasAire
	 * @param numeroPuertas
	 * @param tieneAireAcondicionado
	 * @param tieneCamaraReversa
	 * @param tieneABS
	 * @param image
	 */
	public Familiar(String id, String marca, String modelo, Double cilindraje, Double velocidadMaxima,
			Combustible combustible, EstadoVehiculo estado, TipoCambio tipo, Integer numeroPasajeros,
			Integer numeroBolsasAire, Integer numeroPuertas, Boolean tieneAireAcondicionado, Boolean tieneCamaraReversa,
			Boolean tieneABS, Image imagen) {
		super(id, marca, modelo, cilindraje, velocidadMaxima, combustible, estado, tipo, numeroPasajeros,
				numeroBolsasAire, numeroPuertas, imagen);
		this.tieneAireAcondicionado = tieneAireAcondicionado;
		this.tieneCamaraReversa = tieneCamaraReversa;
		this.tieneABS = tieneABS;
	}

	@Override
	public boolean atributosLlenos() {
		return super.atributosLlenos() && tieneAireAcondicionado != null && tieneCamaraReversa != null
				&& tieneABS != null;
	}

	/**
	 * Obtiene la opcion si el familiar tiene aire acondicionado o no lo tiene
	 * 
	 * @return tieneAireAcondicionado
	 */
	public Boolean getTieneAireAcondicionado() {
		return tieneAireAcondicionado;
	}

	/**
	 * Cambia la opcion si el familiar tiene aire acondicionado o no lo tiene
	 * 
	 * @param tieneAireAcondicionado
	 */
	public void setTieneAireAcondicionado(final Boolean tieneAireAcondicionado) {
		this.tieneAireAcondicionado = tieneAireAcondicionado;
	}

	/**
	 * Obtiene la opcion si el familiar tiene camara reversa o no lo tiene
	 * 
	 * @return tieneCamaraReversa
	 */
	public Boolean getTieneCamaraReversa() {
		return tieneCamaraReversa;
	}

	/**
	 * Cambia la opcion si el familiar tiene camara reversa o no lo tiene
	 * 
	 * @param tieneCamaraReversa
	 */
	public void setTieneCamaraReversa(final Boolean tieneCamaraReversa) {
		this.tieneCamaraReversa = tieneCamaraReversa;
	}

	/**
	 * Obtiene la opcion si el familiar tiene ABS o no lo tiene
	 * 
	 * @return Obtiene la opcion si el familiar tiene ABS o no lo tiene
	 */
	public Boolean getTieneABS() {
		return tieneABS;
	}

	/**
	 * Cambia la opcion si el familiar tiene ABS o no lo tiene
	 * 
	 * @param tieneABS
	 */
	public void setTieneABS(final Boolean tieneABS) {
		this.tieneABS = tieneABS;
	}

	@Override
	public String toString() {
		return String.format(
				"Familiar [id=%s, marca=%s, modelo=%s, cilindraje=%s, velocidadMaxima=%s, combustible=%s, estado=%s, tipo=%s, numeroPasajeros=%s, numeroBolsasAire=%s, numeroPuertas=%s, tieneAireAcondicionado=%s, tieneCamaraReversa=%s, tieneABS=%s]",
				id, marca, modelo, cilindraje, velocidadMaxima, combustible, estado, tipo, numeroPasajeros,
				numeroBolsasAire, numeroPuertas, tieneAireAcondicionado, tieneCamaraReversa, tieneABS);
	}

}