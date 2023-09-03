package co.edu.uniquindio.carrouq.model;

public class Bus extends Van {

	// ATRIBUTOS
	private Integer numeroEjes;
	private Integer numeroSalidasEmergencia;

	/**
	 * Es el constructor del Bus
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
	 * @param numeroEjes
	 * @param numeroSalidasEmergencia
	 */
	public Bus(String placa, String marca, String modelo, Double cilindraje, Double velocidadMaxima,
			Combustible combustible, EstadoVehiculo estado, TipoCambio tipo, Integer numeroPasajeros,
			Integer numeroBolsasAire, Integer numeroPuertas, Boolean tieneAireAcondicionado, Boolean tieneCamaraReversa,
			Boolean tieneABS, Double capacidadMaletero, Integer numeroEjes, Integer numeroSalidasEmergencia) {
		super(placa, marca, modelo, cilindraje, velocidadMaxima, combustible, estado, tipo, numeroPasajeros,
				numeroBolsasAire, numeroPuertas, tieneAireAcondicionado, tieneCamaraReversa, tieneABS,
				capacidadMaletero);
		this.numeroEjes = numeroEjes;
		this.numeroSalidasEmergencia = numeroSalidasEmergencia;
	}

	/**
	 * Obtiene el numero de ejes
	 * 
	 * @return numeroEjes
	 */
	public Integer getNumeroEjes() {
		return numeroEjes;
	}

	/**
	 * Cambia el numero de ejes
	 * 
	 * @param numeroEjes
	 */
	public void setNumeroEjes(final Integer numeroEjes) {
		this.numeroEjes = numeroEjes;
	}

	/**
	 * Obtiene el numero de salidas de emergencia
	 * 
	 * @return numeroSalidasEmergencia
	 */
	public Integer getNumeroSalidasEmergencia() {
		return numeroSalidasEmergencia;
	}

	/**
	 * Cambia el numero de salidas de emergencia
	 * 
	 * @param numeroSalidasEmergencia
	 */
	public void setNumeroSalidasEmergencia(final Integer numeroSalidasEmergencia) {
		this.numeroSalidasEmergencia = numeroSalidasEmergencia;
	}

}