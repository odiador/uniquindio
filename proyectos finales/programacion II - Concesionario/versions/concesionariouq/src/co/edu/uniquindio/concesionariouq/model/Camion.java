package co.edu.uniquindio.concesionariouq.model;

public class Camion extends Vehiculo {

	// ATRIBUTOS

	protected Double capacidadCarga;
	protected Boolean tieneAireAcondicionado;
	protected Boolean tieneFrenosAire;
	protected Boolean tieneABS;
	protected Integer numeroEjes;
	protected String tipoCamion; // El tipo de tipoCamion es provicional. Deberia ser un Enum

	/**
	 * Es el constructor de la clase camión
	 * 
	 * @param placa
	 * @param marca
	 * @param modelo
	 * @param cilindraje
	 * @param velocidadMaxima
	 * @param combustible
	 * @param estado
	 * @param tipo
	 * @param capacidadCarga
	 * @param tieneAireAcondicionado
	 * @param tieneFrenosAire
	 * @param numeroEjes
	 * @param tieneABS
	 * @param tipoCamion
	 */
	public Camion(String placa, String marca, String modelo, Double cilindraje, Double velocidadMaxima,
			Combustible combustible, EstadoVehiculo estado, TipoCambio tipo, Double capacidadCarga,
			Boolean tieneAireAcondicionado, Boolean tieneFrenosAire, Integer numeroEjes, Boolean tieneABS,
			String tipoCamion) {
		super(placa, marca, modelo, cilindraje, velocidadMaxima, combustible, estado, tipo);

		this.capacidadCarga = capacidadCarga;
		this.tieneAireAcondicionado = tieneAireAcondicionado;
		this.tieneFrenosAire = tieneFrenosAire;
		this.numeroEjes = numeroEjes;
		this.tieneABS = tieneABS;
		this.tipoCamion = tipoCamion;
		setTipoVehiculo(TipoVehiculo.CAMION);
	}

	/**
	 * Obtiene la capacidad de carga
	 * 
	 * @return capacidadCarga
	 */
	public Double getCapacidadCarga() {
		return capacidadCarga;
	}

	/**
	 * Cambia la capacidad de carga
	 * 
	 * @param capacidadCarga
	 */
	public void setCapacidadCarga(final Double capacidadCarga) {
		this.capacidadCarga = capacidadCarga;
	}

	/**
	 * Obtiene la opcion que si el camion tiene aire acondicionado o no
	 * 
	 * @return tieneAireAcondicionado
	 */
	public Boolean getTieneAireAcondicionado() {
		return tieneAireAcondicionado;
	}

	/**
	 * Cambia la opcion que si el camion tiene aire acondicionado o no
	 * 
	 * @param tieneAireAcondicionado
	 */
	public void setTieneAireAcondicionado(final Boolean tieneAireAcondicionado) {
		this.tieneAireAcondicionado = tieneAireAcondicionado;
	}

	/**
	 * Obtiene la opcion que si el camion tiene frenos o no
	 * 
	 * @return tieneFrenosAire
	 */
	public Boolean getTieneFrenosAire() {
		return tieneFrenosAire;
	}

	/**
	 * Cambia la opcion que si el camion tiene frenos o no
	 * 
	 * @param tieneFrenosAire
	 */
	public void setTieneFrenosAire(final Boolean tieneFrenosAire) {
		this.tieneFrenosAire = tieneFrenosAire;
	}

	/**
	 * Obtiene la opcion que si el camion tiene ABS o no
	 * 
	 * @return tieneABS
	 */
	public Boolean getTieneABS() {
		return tieneABS;
	}

	/**
	 * Cambia la opcion que si el camion tiene ABS o no
	 * 
	 * @param tieneABS
	 */
	public void setTieneABS(final Boolean tieneABS) {
		this.tieneABS = tieneABS;
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
	 * Obtiene el tipo de camion
	 * 
	 * @return tipoCamion
	 */
	public String getTipoCamion() {
		return tipoCamion;
	}

	/**
	 * Cambia el tipo de camion
	 * 
	 * @param tipoCamion
	 */
	public void setTipoCamion(final String tipoCamion) {
		this.tipoCamion = tipoCamion;
	}

	@Override
	public String toString() {
		return String.format(
				"Camion [placa=%s, marca=%s, modelo=%s, cilindraje=%s, velocidadMaxima=%s, combustible=%s, estado=%s, tipo=%s, tipoVehiculo=%s, capacidadCarga=%s, tieneAireAcondicionado=%s, tieneFrenosAire=%s, tieneABS=%s, numeroEjes=%s, tipoCamion=%s]",
				placa, marca, modelo, cilindraje, velocidadMaxima, combustible, estado, tipo, tipoVehiculo,
				capacidadCarga, tieneAireAcondicionado, tieneFrenosAire, tieneABS, numeroEjes, tipoCamion);
	}
}