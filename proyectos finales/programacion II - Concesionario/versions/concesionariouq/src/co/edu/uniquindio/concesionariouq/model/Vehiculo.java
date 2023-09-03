package co.edu.uniquindio.concesionariouq.model;

public abstract class Vehiculo {

	// ATRIBUTOS

	protected final String placa;
	protected String marca;
	protected String modelo;
	protected Double cilindraje;
	protected Double velocidadMaxima;
	protected Combustible combustible;
	protected EstadoVehiculo estado;
	protected TipoCambio tipo;
	protected TipoVehiculo tipoVehiculo;

	/**
	 * Es el constructor de la clase Vehiculo
	 * 
	 * @param tipoVehiculo
	 * @param placa
	 * @param marca
	 * @param modelo
	 * @param cilindraje
	 * @param velocidadMaxima
	 * @param combustible
	 * @param estado
	 * @param tipo
	 */
	public Vehiculo(String placa, String marca, String modelo, Double cilindraje, Double velocidadMaxima,
			Combustible combustible, EstadoVehiculo estado, TipoCambio tipo) {
		this.placa = placa;
		this.marca = marca;
		this.modelo = modelo;
		this.cilindraje = cilindraje;
		this.velocidadMaxima = velocidadMaxima;
		this.combustible = combustible;
		this.estado = estado;
		this.tipo = tipo;
	}

	/**
	 * Obtiene la marca del vehiculo
	 * 
	 * @return marca
	 */
	public String getMarca() {
		return marca;
	}

	/**
	 * Cambia la marca de vehiculo
	 * 
	 * @param marca
	 */
	public void setMarca(final String marca) {
		this.marca = marca;
	}

	/**
	 * Obtiene el modelo del vehiculo
	 * 
	 * @return modelo
	 */
	public String getModelo() {
		return modelo;
	}

	/**
	 * Cambia el modelo del vehiculo
	 * 
	 * @param modelo
	 */
	public void setModelo(final String modelo) {
		this.modelo = modelo;
	}

	/**
	 * Obtiene el cilindraje del vehiculo
	 * 
	 * @return cilindraje
	 */
	public Double getCilindraje() {
		return cilindraje;
	}

	/**
	 * Cambia el cilindraje del vehiculo
	 * 
	 * @param cilindraje
	 */
	public void setCilindraje(final Double cilindraje) {
		this.cilindraje = cilindraje;
	}

	/**
	 * Obtiene la velocidad maxima del vehiclo
	 * 
	 * @return velocidadMaxima
	 */
	public Double getVelocidadMaxima() {
		return velocidadMaxima;
	}

	/**
	 * Cambia la velocidad maxima del vehiculo
	 * 
	 * @param velocidadMaxima
	 */
	public void setVelocidadMaxima(final Double velocidadMaxima) {
		this.velocidadMaxima = velocidadMaxima;
	}

	/**
	 * Obtiene el combustible del vehiculo
	 * 
	 * @return combustible
	 */
	public Combustible getCombustible() {
		return combustible;
	}

	/**
	 * Cambia el tipo de combustible del vehiculo
	 * 
	 * @param combustible
	 */
	public void setCombustible(final Combustible combustible) {
		this.combustible = combustible;
	}

	/**
	 * Obtiene el estado del vehiculo
	 * 
	 * @return estado
	 */
	public EstadoVehiculo getEstado() {
		return estado;
	}

	/**
	 * Cambia el estado del vehiculo
	 * 
	 * @param estado
	 */
	public void setEstado(final EstadoVehiculo estado) {
		this.estado = estado;
	}

	/**
	 * Obtiene el tipo de vehiculo
	 * 
	 * @return tipo
	 */
	public TipoCambio getTipo() {
		return tipo;
	}

	/**
	 * Cambia el tipo de vehiculo
	 * 
	 * @param tipo
	 */
	public void setTipo(final TipoCambio tipo) {
		this.tipo = tipo;
	}

	/**
	 * Obtiene la placa del vehículo
	 * 
	 * @return
	 */
	public String getPlaca() {
		return placa;
	}

	public TipoVehiculo getTipoVehiculo() {
		return tipoVehiculo;
	}

	public void setTipoVehiculo(TipoVehiculo tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}

	/**
	 * Determina si la placa del vehiculo termina con una cadena especifica
	 * 
	 * @param cadena
	 * @return
	 */
	public boolean placaTerminaCon(String cadena) {
		return placa.endsWith(cadena);
	}

	/**
	 * Determina si la placa del vehiculo empieza con una cadena especifica
	 * 
	 * @param cadena
	 * @return
	 */
	public boolean placaEmpiezaCon(String cadena) {
		return placa.startsWith(cadena);
	}

	/**
	 * Determina si el cilindraje esta en un rango determinado
	 * 
	 * @param min
	 * @param max
	 * @return
	 */
	public boolean cilindrajeEnRango(double min, double max) {
		return cilindrajeMayorQue(min) && cilindrajeMenorQue(max);
	}

	/**
	 * Determina si el cilindraje es mayor a un rango determinado
	 * 
	 * @param val
	 * @return
	 */
	public boolean cilindrajeMayorQue(double val) {
		return cilindraje > val;
	}

	/**
	 * Determina si el cilindraje es menor a un rango determinado
	 * 
	 * @param val
	 * @return
	 */
	public boolean cilindrajeMenorQue(double val) {
		return cilindraje < val;
	}

	/**
	 * Determina si la velocidad maxima esta en un rango determinado
	 * 
	 * @param min
	 * @param max
	 * @return
	 */
	public boolean velocidadMaximaRango(double min, double max) {
		return velocidadMaximaMayorQue(min) && velocidadMaximaMenorQue(max);
	}

	/**
	 * Determina si la velocidad maxima es menor que un valor
	 * 
	 * @param val
	 * @return
	 */
	public boolean velocidadMaximaMenorQue(double val) {
		return velocidadMaxima < val;
	}

	/**
	 * Determina si la velocidad maxima es mayor que un valor
	 * 
	 * @param val
	 * @return
	 */
	public boolean velocidadMaximaMayorQue(double val) {
		return velocidadMaxima > val;
	}

	public boolean tieneCombustibleGasolina() {
		return combustible instanceof Gasolina;
	}

	public boolean tieneCombustibleEletrico() {
		return combustible instanceof Electrico;
	}

	public boolean tieneCombustibleHibrido() {
		return combustible instanceof Hibrido;
	}

	public boolean tieneCombustibleDiesel() {
		return combustible instanceof Diesel;
	}

	@Override
	public String toString() {
		return String.format(
				"Vehiculo [placa=%s, marca=%s, modelo=%s, cilindraje=%s, velocidadMaxima=%s, combustible=%s, estado=%s, tipo=%s, tipoVehiculo=%s]",
				placa, marca, modelo, cilindraje, velocidadMaxima, combustible, estado, tipo, tipoVehiculo);
	}

}