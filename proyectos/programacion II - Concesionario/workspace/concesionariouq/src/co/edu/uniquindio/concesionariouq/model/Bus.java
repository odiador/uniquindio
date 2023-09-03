package co.edu.uniquindio.concesionariouq.model;

import javafx.scene.image.Image;

public class Bus extends Van {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// ATRIBUTOS
	protected Integer numeroEjes;
	protected Integer numeroSalidasEmergencia;

	/**
	 * Es el constructor de la clase {@link Bus}
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
	 * @param numeroEjes
	 * @param numeroSalidasEmergencia
	 * @param image
	 */
	public Bus(String id, String marca, String modelo, Double cilindraje, Double velocidadMaxima,
			Combustible combustible, EstadoVehiculo estado, TipoCambio tipo, Integer numeroPasajeros,
			Integer numeroBolsasAire, Integer numeroPuertas, Boolean tieneAireAcondicionado, Boolean tieneCamaraReversa,
			Boolean tieneABS, Double capacidadMaletero, Integer numeroEjes, Integer numeroSalidasEmergencia,
			Image imagen) {
		super(id, marca, modelo, cilindraje, velocidadMaxima, combustible, estado, tipo, numeroPasajeros,
				numeroBolsasAire, numeroPuertas, tieneAireAcondicionado, tieneCamaraReversa, tieneABS,
				capacidadMaletero, imagen);
		this.numeroEjes = numeroEjes;
		this.numeroSalidasEmergencia = numeroSalidasEmergencia;
	}

	@Override
	public boolean atributosLlenos() {
		return super.atributosLlenos() && numeroEjes != null && numeroSalidasEmergencia != null;
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

	@Override
	public TipoVehiculo getTipoVehiculo() {
		return TipoVehiculo.BUS;
	}

	@Override
	public String toString() {
		return String.format(
				"Bus [id=%s, marca=%s, modelo=%s, cilindraje=%s, velocidadMaxima=%s, combustible=%s, estado=%s, tipo=%s, numeroPasajeros=%s, numeroBolsasAire=%s, numeroPuertas=%s, tieneAireAcondicionado=%s, tieneCamaraReversa=%s, tieneABS=%s, capacidadMaletero=%s, numeroEjes=%s, numeroSalidasEmergencia=%s]",
				id, marca, modelo, cilindraje, velocidadMaxima, combustible, estado, tipo, numeroPasajeros,
				numeroBolsasAire, numeroPuertas, tieneAireAcondicionado, tieneCamaraReversa, tieneABS,
				capacidadMaletero, numeroEjes, numeroSalidasEmergencia);
	}
}