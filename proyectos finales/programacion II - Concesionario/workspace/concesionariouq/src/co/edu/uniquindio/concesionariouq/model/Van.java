package co.edu.uniquindio.concesionariouq.model;

import javafx.scene.image.Image;

public class Van extends Familiar {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected Double capacidadMaletero;

	/**
	 * Es el constructor de la Van
	 * 
	 * @param id
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
	 * @param imagen
	 */
	public Van(String id, String marca, String modelo, Double cilindraje, Double velocidadMaxima,
			Combustible combustible, EstadoVehiculo estado, TipoCambio tipo, Integer numeroPasajeros,
			Integer numeroBolsasAire, Integer numeroPuertas, Boolean tieneAireAcondicionado, Boolean tieneCamaraReversa,
			Boolean tieneABS, Double capacidadMaletero, Image imagen) {
		super(id, marca, modelo, cilindraje, velocidadMaxima, combustible, estado, tipo, numeroPasajeros,
				numeroBolsasAire, numeroPuertas, tieneAireAcondicionado, tieneCamaraReversa, tieneABS, imagen);
		this.capacidadMaletero = capacidadMaletero;
	}

	@Override
	public boolean atributosLlenos() {
		return super.atributosLlenos() && capacidadMaletero != null;
	}

	/**
	 * Obtiene la capacidad del maletero del Van
	 * 
	 * @return capacidadMaletero
	 */
	public Double getCapacidadMaletero() {
		return capacidadMaletero;
	}

	@Override
	public TipoVehiculo getTipoVehiculo() {
		return TipoVehiculo.VAN;
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
				"Van [id=%s, marca=%s, modelo=%s, cilindraje=%s, velocidadMaxima=%s, combustible=%s, estado=%s, tipo=%s, numeroPasajeros=%s, numeroBolsasAire=%s, numeroPuertas=%s, tieneAireAcondicionado=%s, tieneCamaraReversa=%s, tieneABS=%s, capacidadMaletero=%s]",
				id, marca, modelo, cilindraje, velocidadMaxima, combustible, estado, tipo, numeroPasajeros,
				numeroBolsasAire, numeroPuertas, tieneAireAcondicionado, tieneCamaraReversa, tieneABS,
				capacidadMaletero);
	}

}