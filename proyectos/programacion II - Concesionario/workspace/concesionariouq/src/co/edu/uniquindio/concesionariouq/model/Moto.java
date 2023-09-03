package co.edu.uniquindio.concesionariouq.model;

import javafx.scene.image.Image;

public class Moto extends Vehiculo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Este es el constructor principal de la clase {@link Moto}
	 * 
	 * @param id
	 * @param marca
	 * @param modelo
	 * @param cilindraje
	 * @param velocidadMaxima
	 * @param combustible
	 * @param estado
	 * @param tipo
	 * @param imagen 
	 */
	public Moto(String id, String marca, String modelo, Double cilindraje, Double velocidadMaxima,
			Combustible combustible, EstadoVehiculo estado, TipoCambio tipo, Image imagen) {
		super(id, marca, modelo, cilindraje, velocidadMaxima, combustible, estado, tipo, imagen);
	}

	@Override
	public TipoVehiculo getTipoVehiculo() {
		return TipoVehiculo.MOTO;
	}

	@Override
	public String toString() {
		return String.format(
				"Moto [id=%s, marca=%s, modelo=%s, cilindraje=%s, velocidadMaxima=%s, combustible=%s, estado=%s, tipo=%s]",
				id, marca, modelo, cilindraje, velocidadMaxima, combustible, estado, tipo);
	}
}