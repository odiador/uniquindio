package co.edu.uniquindio.carrouq.model;

public abstract class Familiar extends Automovil {

	private Boolean tieneAireAcondicionado;
	private Boolean tieneCamaraReversa;
	private Boolean tieneABS;

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
	 * 
	 * @return
	 */
	public Boolean getTieneAireAcondicionado() {
		return tieneAireAcondicionado;
	}

	/**
	 * 
	 * @param tieneAireAcondicionado
	 */
	public void setTieneAireAcondicionado(final Boolean tieneAireAcondicionado) {
		this.tieneAireAcondicionado = tieneAireAcondicionado;
	}

	/**
	 * 
	 * @return
	 */
	public Boolean getTieneCamaraReversa() {
		return tieneCamaraReversa;
	}

	/**
	 * 
	 * @param tieneCamaraReversa
	 */
	public void setTieneCamaraReversa(final Boolean tieneCamaraReversa) {
		this.tieneCamaraReversa = tieneCamaraReversa;
	}

	/**
	 * 
	 * @return
	 */
	public Boolean getTieneABS() {
		return tieneABS;
	}

	/**
	 * 
	 * @param tieneABS
	 */
	public void setTieneABS(final Boolean tieneABS) {
		this.tieneABS = tieneABS;
	}

}