package co.edu.uniquindio.carrouq.model;

public class Camioneta extends Sedan {

	private Boolean es4x4;

	/**
	 * Es el constructor de la clase Camioneta
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
	 * @param es4x4
	 */
	public Camioneta(String placa, String marca, String modelo, Double cilindraje, Double velocidadMaxima,
			Combustible combustible, EstadoVehiculo estado, TipoCambio tipo, Integer numeroPasajeros,
			Integer numeroBolsasAire, Integer numeroPuertas, Boolean tieneAireAcondicionado, Boolean tieneCamaraReversa,
			Boolean tieneABS, Double capacidadMaletero, Boolean tieneVelocidadCrucero, Boolean tieneSensorColision,
			Boolean tieneSensorTrafico, Boolean tieneAsistentePermanencia, Boolean es4x4) {
		super(placa, marca, modelo, cilindraje, velocidadMaxima, combustible, estado, tipo, numeroPasajeros,
				numeroBolsasAire, numeroPuertas, tieneAireAcondicionado, tieneCamaraReversa, tieneABS,
				capacidadMaletero, tieneVelocidadCrucero, tieneSensorColision, tieneSensorTrafico,
				tieneAsistentePermanencia);
		this.es4x4 = es4x4;
	}

	/**
	 * Obtiene si la camioneta es 4x4 o no
	 * 
	 * @return
	 */
	public Boolean getEs4x4() {
		return es4x4;
	}

	/**
	 * Obtiene si la camioneta es 4x4 o no
	 * 
	 * @param
	 */
	public void setEs4x4(final Boolean es4x4) {
		this.es4x4 = es4x4;
	}

}
