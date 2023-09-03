package co.edu.uniquindio.concesionariouq.model;

public class Moto extends Vehiculo {

	/**
	 * Este es el constructor principal de la clase
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
	public Moto(String placa, String marca, String modelo, Double cilindraje, Double velocidadMaxima,
			Combustible combustible, EstadoVehiculo estado, TipoCambio tipo) {
		super(placa, marca, modelo, cilindraje, velocidadMaxima, combustible, estado, tipo);
		setTipoVehiculo(TipoVehiculo.MOTO);
	}

	@Override
	public String toString() {
		return String.format(
				"Moto [placa=%s, marca=%s, modelo=%s, cilindraje=%s, velocidadMaxima=%s, combustible=%s, estado=%s, tipo=%s, tipoVehiculo=%s]",
				placa, marca, modelo, cilindraje, velocidadMaxima, combustible, estado, tipo, tipoVehiculo);
	}
}