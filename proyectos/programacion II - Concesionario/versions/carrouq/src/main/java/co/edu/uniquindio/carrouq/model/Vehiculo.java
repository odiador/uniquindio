package co.edu.uniquindio.carrouq.model;

public abstract class Vehiculo {
	private String placa;
	private String marca;
	private String modelo;
	private Double cilindraje;
	private Double velocidadMaxima;
	private Combustible combustible;
	private EstadoVehiculo estado;
	private TipoCambio tipo;

	/**
	 * Es el constructor de la clase Vehiculo
	 * 
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
	 * @return
	 */
	public String getPlaca() {
		return placa;
	}

	/**
	 * @param placa
	 */
	public void setPlaca(String placa) {
		this.placa = placa;
	}

	/**
	 * 
	 * @return
	 */
	public String getMarca() {
		return marca;
	}

	/**
	 * 
	 * @param marca
	 */
	public void setMarca(final String marca) {
		this.marca = marca;
	}

	/**
	 * 
	 * @return
	 */
	public String getModelo() {
		return modelo;
	}

	/**
	 * 
	 * @param modelo
	 */
	public void setModelo(final String modelo) {
		this.modelo = modelo;
	}

	/**
	 * 
	 * @return
	 */
	public Double getCilindraje() {
		return cilindraje;
	}

	/**
	 * 
	 * @param cilindraje
	 */
	public void setCilindraje(final Double cilindraje) {
		this.cilindraje = cilindraje;
	}

	/**
	 * 
	 * @return
	 */
	public Double getVelocidadMaxima() {
		return velocidadMaxima;
	}

	/**
	 * 
	 * @param velocidadMaxima
	 */
	public void setVelocidadMaxima(final Double velocidadMaxima) {
		this.velocidadMaxima = velocidadMaxima;
	}

	/**
	 * 
	 * @return
	 */
	public Combustible getCombustible() {
		return combustible;
	}

	/**
	 * 
	 * @param combustible
	 */
	public void setCombustible(final Combustible combustible) {
		this.combustible = combustible;
	}

	/**
	 * 
	 * @return
	 */
	public EstadoVehiculo getEstado() {
		return estado;
	}

	/**
	 * 
	 * @param estado
	 */
	public void setEstado(final EstadoVehiculo estado) {
		this.estado = estado;
	}

	/**
	 * 
	 * @return
	 */
	public TipoCambio getTipo() {
		return tipo;
	}

	/**
	 * 
	 * @param tipo
	 */
	public void setTipo(final TipoCambio tipo) {
		this.tipo = tipo;
	}

}