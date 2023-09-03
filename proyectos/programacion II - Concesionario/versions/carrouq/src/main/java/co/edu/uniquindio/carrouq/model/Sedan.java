package co.edu.uniquindio.carrouq.model;

public class Sedan extends Van {

	private Boolean tieneVelocidadCrucero;
	private Boolean tieneSensorColision;
	private Boolean tieneSensorTrafico;
	private Boolean tieneAsistentePermanencia;

	/**
	 * Es el constructor del Sedan
	 * 
	 * @param placa
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
	 */
	public Sedan(String placa, String marca, String modelo, Double cilindraje, Double velocidadMaxima,
			Combustible combustible, EstadoVehiculo estado, TipoCambio tipo, Integer numeroPasajeros,
			Integer numeroBolsasAire, Integer numeroPuertas, Boolean tieneAireAcondicionado, Boolean tieneCamaraReversa,
			Boolean tieneABS, Double capacidadMaletero, Boolean tieneVelocidadCrucero, Boolean tieneSensorColision,
			Boolean tieneSensorTrafico, Boolean tieneAsistentePermanencia) {
		super(placa, marca, modelo, cilindraje, velocidadMaxima, combustible, estado, tipo, numeroPasajeros,
				numeroBolsasAire, numeroPuertas, tieneAireAcondicionado, tieneCamaraReversa, tieneABS,
				capacidadMaletero);
		this.tieneVelocidadCrucero = tieneVelocidadCrucero;
		this.tieneSensorColision = tieneSensorColision;
		this.tieneSensorTrafico = tieneSensorTrafico;
		this.tieneAsistentePermanencia = tieneAsistentePermanencia;
	}

	/**
	 * 
	 * @return
	 */
	public Boolean getTieneVelocidadCrucero() {
		return tieneVelocidadCrucero;
	}

	/**
	 * 
	 * @param tieneVelocidadCrucero
	 */
	public void setTieneVelocidadCrucero(final Boolean tieneVelocidadCrucero) {
		this.tieneVelocidadCrucero = tieneVelocidadCrucero;
	}

	/**
	 * 
	 * @return
	 */
	public Boolean getTieneSensorColision() {
		return tieneSensorColision;
	}

	/**
	 * 
	 * @param tieneSensorColision
	 */
	public void setTieneSensorColision(final Boolean tieneSensorColision) {
		this.tieneSensorColision = tieneSensorColision;
	}

	/**
	 * 
	 * @return
	 */
	public Boolean getTieneSensorTrafico() {
		return tieneSensorTrafico;
	}

	/**
	 * 
	 * @param tieneSensorTrafico
	 */
	public void setTieneSensorTrafico(final Boolean tieneSensorTrafico) {
		this.tieneSensorTrafico = tieneSensorTrafico;
	}

	/**
	 * 
	 * @return
	 */
	public Boolean getTieneAsistentePermanencia() {
		return tieneAsistentePermanencia;
	}

	/**
	 * 
	 * @param tieneAsistentePermanencia
	 */
	public void setTieneAsistentePermanencia(final Boolean tieneAsistentePermanencia) {
		this.tieneAsistentePermanencia = tieneAsistentePermanencia;
	}

}