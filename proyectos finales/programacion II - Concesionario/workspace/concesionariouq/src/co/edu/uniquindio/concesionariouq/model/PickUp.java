package co.edu.uniquindio.concesionariouq.model;

import javafx.scene.image.Image;

public class PickUp extends Familiar {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Es el constructor de la clase {@link PickUp}
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
	 * @param es4x4
	 * @param capacidadCajaCarga
	 * @param image
	 */
	public PickUp(String id, String marca, String modelo, Double cilindraje, Double velocidadMaxima,
			Combustible combustible, EstadoVehiculo estado, TipoCambio tipo, Integer numeroPasajeros,
			Integer numeroBolsasAire, Integer numeroPuertas, Boolean tieneAireAcondicionado, Boolean tieneCamaraReversa,
			Boolean tieneABS, Boolean es4x4, Double capacidadCajaCarga, Image imagen) {
		super(id, marca, modelo, cilindraje, velocidadMaxima, combustible, estado, tipo, numeroPasajeros,
				numeroBolsasAire, numeroPuertas, tieneAireAcondicionado, tieneCamaraReversa, tieneABS, imagen);
		this.es4x4 = es4x4;
		this.capacidadCajaCarga = capacidadCajaCarga;
	}

	@Override
	public boolean atributosLlenos() {
		return super.atributosLlenos() && es4x4 != null && capacidadCajaCarga != null;
	}

	/**
	 * Determina si el Pickup es 4x4 o no lo es
	 */
	protected Boolean es4x4;

	protected Double capacidadCajaCarga;

	/**
	 * Obtiene la opcion de que el Pickup es 4x4 o no lo es
	 * 
	 * @return es4x4
	 */
	public Boolean getEs4x4() {
		return es4x4;
	}

	/**
	 * Cambia la opcion de que el Pickup es 4x4 o no lo es
	 * 
	 * @param es4x4
	 */
	public void setEs4x4(final Boolean es4x4) {
		this.es4x4 = es4x4;
	}

	/**
	 * Obtiene la capacidad de la caja de carga del PickUp
	 * 
	 * @return capacidadCajaCarga
	 */
	public Double getCapacidadCajaCarga() {
		return capacidadCajaCarga;
	}

	/**
	 * Cambia la capacidad de la caja de carga del PickUp
	 * 
	 * @param capacidadCajaCarga
	 */
	public void setCapacidadCajaCarga(final Double capacidadCajaCarga) {
		this.capacidadCajaCarga = capacidadCajaCarga;
	}

	@Override
	public TipoVehiculo getTipoVehiculo() {
		return TipoVehiculo.PICKUP;
	}

	@Override
	public String toString() {
		return String.format(
				"PickUp [id=%s, marca=%s, modelo=%s, cilindraje=%s, velocidadMaxima=%s, combustible=%s, estado=%s, tipo=%s, numeroPasajeros=%s, numeroBolsasAire=%s, numeroPuertas=%s, tieneAireAcondicionado=%s, tieneCamaraReversa=%s, tieneABS=%s, es4x4=%s, capacidadCajaCarga=%s]",
				id, marca, modelo, cilindraje, velocidadMaxima, combustible, estado, tipo, numeroPasajeros,
				numeroBolsasAire, numeroPuertas, tieneAireAcondicionado, tieneCamaraReversa, tieneABS, es4x4,
				capacidadCajaCarga);
	}

}