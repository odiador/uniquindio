package co.edu.uniquindio.carrouq.model;

public class Automovil extends Vehiculo {

	// ATRIBUTOS
	private Integer numeroPasajeros;
	private Integer numeroBolsasAire;
	private Integer numeroPuertas;

	/**
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
	public Automovil(String placa, String marca, String modelo, Double cilindraje, Double velocidadMaxima,
			Combustible combustible, EstadoVehiculo estado, TipoCambio tipo, Integer numeroPasajeros,
			Integer numeroBolsasAire, Integer numeroPuertas) {
		super(placa, marca, modelo, cilindraje, velocidadMaxima, combustible, estado, tipo);
		this.numeroPasajeros = numeroPasajeros;
		this.numeroBolsasAire = numeroBolsasAire;
		this.numeroPuertas = numeroPuertas;
	}

	/**
	 * Obtiene el numero de pasajeros
	 * 
	 * @return numeroPasajeros
	 */
	public Integer getNumeroPasajeros() {
		return numeroPasajeros;
	}

	/**
	 * Cambia el numero de pasajeros
	 * 
	 * @param numeroPasajeros
	 */
	public void setNumeroPasajeros(final Integer numeroPasajeros) {
		this.numeroPasajeros = numeroPasajeros;
	}

	/**
	 * Obiene el numero de bolsas de aire
	 * 
	 * @return numeroBolsasAire
	 */
	public Integer getNumeroBolsasAire() {
		return numeroBolsasAire;
	}

	/**
	 * Cambia el numero de bolsas de aire
	 * 
	 * @param numeroBolsasAire
	 */
	public void setNumeroBolsasAire(final Integer numeroBolsasAire) {
		this.numeroBolsasAire = numeroBolsasAire;
	}

	/**
	 * Obtiene el numero de puertas
	 * 
	 * @return numeroPuertas
	 */
	public Integer getNumeroPuertas() {
		return numeroPuertas;
	}

	/**
	 * Cambia el numero de puertas
	 * 
	 * @param numeroPuertas
	 */
	public void setNumeroPuertas(final Integer numeroPuertas) {
		this.numeroPuertas = numeroPuertas;
	}

}