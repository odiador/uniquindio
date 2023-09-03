package co.edu.uniquindio.concesionariouq.model;

import javafx.scene.image.Image;

public class Deportivo extends Automovil {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected Integer numeroCaballosFuerza;
	protected Double tiempoAlcanza100Kmh;

	/**
	 * Es el constructor de la clase {@link Deportivo}
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
	 * @param numeroCaballosFuerza
	 * @param tiempoAlcanza100Kmh
	 * @param image
	 */
	public Deportivo(String id, String marca, String modelo, Double cilindraje, Double velocidadMaxima,
			Combustible combustible, EstadoVehiculo estado, TipoCambio tipo, Integer numeroPasajeros,
			Integer numeroBolsasAire, Integer numeroPuertas, Integer numeroCaballosFuerza, Double tiempoAlcanza100Kmh,
			Image imagen) {
		super(id, marca, modelo, cilindraje, velocidadMaxima, combustible, estado, tipo, numeroPasajeros,
				numeroBolsasAire, numeroPuertas, imagen);
		this.numeroCaballosFuerza = numeroCaballosFuerza;
		this.tiempoAlcanza100Kmh = tiempoAlcanza100Kmh;
	}

	@Override
	public boolean atributosLlenos() {
		return super.atributosLlenos() && numeroCaballosFuerza != null && tiempoAlcanza100Kmh != null;
	}

	/**
	 * Obtiene el numero de caballos de fuerza del deportivo
	 *
	 * @return numeroCaballosFuerza
	 */
	public Integer getNumeroCaballosFuerza() {
		return numeroCaballosFuerza;
	}

	/**
	 * Cambia el numero de caballos de fuerza del deportivo
	 *
	 * @param numeroCaballosFuerza
	 */
	public void setNumeroCaballosFuerza(final Integer numeroCaballosFuerza) {
		this.numeroCaballosFuerza = numeroCaballosFuerza;
	}

	/**
	 * Obtiene el tiempo en el que el deportivo alcanza los 100 Kmh
	 *
	 * @return
	 */
	public Double getTiempoAlcanza100Kmh() {
		return tiempoAlcanza100Kmh;
	}

	/**
	 * Cambia el tiempo en el que el deportivo alcanza los 100 Kmh
	 * 
	 * @param tiempoAlcanza100Kmh
	 */
	public void setTiempoAlcanza100Kmh(final Double tiempoAlcanza100Kmh) {
		this.tiempoAlcanza100Kmh = tiempoAlcanza100Kmh;
	}

	@Override
	public TipoVehiculo getTipoVehiculo() {
		return TipoVehiculo.DEPORTIVO;
	}

	@Override
	public String toString() {
		return String.format(
				"Deportivo [id=%s, marca=%s, modelo=%s, cilindraje=%s, velocidadMaxima=%s, combustible=%s, estado=%s, tipo=%s, numeroPasajeros=%s, numeroBolsasAire=%s, numeroPuertas=%s, numeroCaballosFuerza=%s, tiempoAlcanza100Kmh=%s]",
				id, marca, modelo, cilindraje, velocidadMaxima, combustible, estado, tipo, numeroPasajeros,
				numeroBolsasAire, numeroPuertas, numeroCaballosFuerza, tiempoAlcanza100Kmh);
	}

}