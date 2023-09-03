package co.edu.uniquindio.concesionariouq.model;

public class Van extends Familiar {

	// ATRIBUTOS
	protected Double capacidadMaletero;

	/**
	 * Es el constructor de la Van
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
	 */
	public Van(String placa, String marca, String modelo, Double cilindraje, Double velocidadMaxima,
			Combustible combustible, EstadoVehiculo estado, TipoCambio tipo, Integer numeroPasajeros,
			Integer numeroBolsasAire, Integer numeroPuertas, Boolean tieneAireAcondicionado, Boolean tieneCamaraReversa,
			Boolean tieneABS, Double capacidadMaletero) {
		super(placa, marca, modelo, cilindraje, velocidadMaxima, combustible, estado, tipo, numeroPasajeros,
				numeroBolsasAire, numeroPuertas, tieneAireAcondicionado, tieneCamaraReversa, tieneABS);
		this.capacidadMaletero = capacidadMaletero;
		setTipoVehiculo(TipoVehiculo.VAN);
	}

	/**
	 * Obtiene la capacidad del maletero del Van
	 * 
	 * @return capacidadMaletero
	 */
	public Double getCapacidadMaletero() {
		return capacidadMaletero;
	}

	/**
	 * Cambia la capacidad del maletero del Van
	 * 
	 * @param capacidadMaletero
	 */
	public void setCapacidadMaletero(final Double capacidadMaletero) {
		this.capacidadMaletero = capacidadMaletero;
	}

	@Override
	public String toString() {
		return String.format(
				"Van [tieneAireAcondicionado=%s, tieneCamaraReversa=%s, tieneABS=%s, numeroPasajeros=%s, numeroBolsasAire=%s, numeroPuertas=%s, placa=%s, marca=%s, modelo=%s, cilindraje=%s, velocidadMaxima=%s, combustible=%s, estado=%s, tipo=%s, tipoVehiculo=%s, capacidadMaletero=%s]",
				tieneAireAcondicionado, tieneCamaraReversa, tieneABS, numeroPasajeros, numeroBolsasAire, numeroPuertas,
				placa, marca, modelo, cilindraje, velocidadMaxima, combustible, estado, tipo, tipoVehiculo,
				capacidadMaletero);
	}

}