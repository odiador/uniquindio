package co.edu.uniquindio.concesionariouq.model;

import javafx.scene.image.Image;

public class Sedan extends Van {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// ATRIBUTOS

	protected Boolean tieneVelocidadCrucero;
	protected Boolean tieneSensorColision;
	protected Boolean tieneSensorTrafico;
	protected Boolean tieneAsistentePermanencia;

	/**
	 * Es el constructor del {@link Sedan}
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
	 * @param capacidadMaletero
	 * @param tieneVelocidadCrucero
	 * @param tieneSensorColision
	 * @param tieneSensorTrafico
	 * @param tieneAsistentePermanencia
	 * @param imagen
	 */
	public Sedan(String id, String marca, String modelo, Double cilindraje, Double velocidadMaxima,
			Combustible combustible, EstadoVehiculo estado, TipoCambio tipo, Integer numeroPasajeros,
			Integer numeroBolsasAire, Integer numeroPuertas, Boolean tieneAireAcondicionado, Boolean tieneCamaraReversa,
			Boolean tieneABS, Double capacidadMaletero, Boolean tieneVelocidadCrucero, Boolean tieneSensorColision,
			Boolean tieneSensorTrafico, Boolean tieneAsistentePermanencia, Image imagen) {
		super(id, marca, modelo, cilindraje, velocidadMaxima, combustible, estado, tipo, numeroPasajeros,
				numeroBolsasAire, numeroPuertas, tieneAireAcondicionado, tieneCamaraReversa, tieneABS,
				capacidadMaletero, imagen);
		this.tieneVelocidadCrucero = tieneVelocidadCrucero;
		this.tieneSensorColision = tieneSensorColision;
		this.tieneSensorTrafico = tieneSensorTrafico;
		this.tieneAsistentePermanencia = tieneAsistentePermanencia;
	}

	@Override
	public boolean atributosLlenos() {
		return super.atributosLlenos() && tieneVelocidadCrucero != null && tieneSensorColision != null
				&& tieneSensorTrafico != null && tieneAsistentePermanencia != null;
	}

	/**
	 * Obtiene la velocidad crucero del Sedan
	 * 
	 * @return tieneVelocidadCrucero
	 */
	public Boolean getTieneVelocidadCrucero() {
		return tieneVelocidadCrucero;
	}

	/**
	 * Cambia la velocidad crucero del Sedan
	 * 
	 * @param tieneVelocidadCrucero
	 */
	public void setTieneVelocidadCrucero(final Boolean tieneVelocidadCrucero) {
		this.tieneVelocidadCrucero = tieneVelocidadCrucero;
	}

	/**
	 * Obtiene la opcion si el sedan tiene o no tiene el sensor colision
	 * 
	 * @return tieneSensorColision
	 */
	public Boolean getTieneSensorColision() {
		return tieneSensorColision;
	}

	/**
	 * Cambia la opcion si el sedan tiene o no tiene el sensor colision
	 * 
	 * @param tieneSensorColision
	 */
	public void setTieneSensorColision(final Boolean tieneSensorColision) {
		this.tieneSensorColision = tieneSensorColision;
	}

	/**
	 * Obtiene un booleano si tiene o no tiene sensor de trafico
	 * 
	 * @return tieneSensorTrafico
	 */
	public Boolean getTieneSensorTrafico() {
		return tieneSensorTrafico;
	}

	/**
	 * Cambia la opcion si el sedan tiene o no tiene sensor de trafico
	 * 
	 * @param tieneSensorTrafico
	 */
	public void setTieneSensorTrafico(final Boolean tieneSensorTrafico) {
		this.tieneSensorTrafico = tieneSensorTrafico;
	}

	/**
	 * Obtiene la opcion si el sedan tiene o no tiene asistente de permanencia
	 * 
	 * @return tieneAsistentePermanencia
	 */
	public Boolean getTieneAsistentePermanencia() {
		return tieneAsistentePermanencia;
	}

	/**
	 * Cambia la opcion si el sedan tiene o no tiene asistente de permanencia
	 * 
	 * @param tieneAsistentePermanencia
	 */
	public void setTieneAsistentePermanencia(final Boolean tieneAsistentePermanencia) {
		this.tieneAsistentePermanencia = tieneAsistentePermanencia;
	}

	@Override
	public TipoVehiculo getTipoVehiculo() {
		return TipoVehiculo.SEDAN;
	}

	@Override
	public String toString() {
		return String.format(
				"Sedan [id=%s, marca=%s, modelo=%s, cilindraje=%s, velocidadMaxima=%s, combustible=%s, estado=%s, tipo=%s, numeroPasajeros=%s, numeroBolsasAire=%s, numeroPuertas=%s, tieneAireAcondicionado=%s, tieneCamaraReversa=%s, tieneABS=%s, capacidadMaletero=%s, tieneVelocidadCrucero=%s, tieneSensorColision=%s, tieneSensorTrafico=%s, tieneAsistentePermanencia=%s]",
				id, marca, modelo, cilindraje, velocidadMaxima, combustible, estado, tipo, numeroPasajeros,
				numeroBolsasAire, numeroPuertas, tieneAireAcondicionado, tieneCamaraReversa, tieneABS,
				capacidadMaletero, tieneVelocidadCrucero, tieneSensorColision, tieneSensorTrafico,
				tieneAsistentePermanencia);
	}

}