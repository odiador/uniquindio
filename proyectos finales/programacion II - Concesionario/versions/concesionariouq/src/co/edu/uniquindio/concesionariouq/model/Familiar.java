package co.edu.uniquindio.concesionariouq.model;

public abstract class Familiar extends Automovil {

	// ATRIBUTOS
	protected Boolean tieneAireAcondicionado;
	protected Boolean tieneCamaraReversa;
	protected Boolean tieneABS;

	/**
	 * Es el constructor del automovil familiar
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
	 */
	public Familiar(String placa, String marca, String modelo, Double cilindraje, Double velocidadMaxima,
			Combustible combustible, EstadoVehiculo estado, TipoCambio tipo, Integer numeroPasajeros,
			Integer numeroBolsasAire, Integer numeroPuertas, Boolean tieneAireAcondicionado, Boolean tieneCamaraReversa,
			Boolean tieneABS) {
		super(placa, marca, modelo, cilindraje, velocidadMaxima, combustible, estado, tipo, numeroPasajeros,
				numeroBolsasAire, numeroPuertas);
		this.tieneAireAcondicionado = tieneAireAcondicionado;
		this.tieneCamaraReversa = tieneCamaraReversa;
		this.tieneABS = tieneABS;
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
				"Familiar [cilindraje=%s, combustible=%s, estado=%s, marca=%s, modelo=%s, numeroBolsasAire=%s, numeroPasajeros=%s, numeroPuertas=%s, placa=%s, tipo=%s, tipoVehiculo=%s, velocidadMaxima=%s, tieneABS=%s, tieneAireAcondicionado=%s, tieneCamaraReversa=%s]",
				cilindraje, combustible, estado, marca, modelo, numeroBolsasAire, numeroPasajeros, numeroPuertas, placa,
				tipo, tipoVehiculo, velocidadMaxima, tieneABS, tieneAireAcondicionado, tieneCamaraReversa);
	}
	

}