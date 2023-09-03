package co.edu.uniquindio.carrouq.model;

public class Cliente extends Usuario implements PuedeTenerVehiculo {

	/**
	 * Este el constructor de la clase Cliente
	 * 
	 * @param nombre
	 * @param id
	 */
	public Cliente(String nombre, String id) {
		super(nombre, id);
	}

	@Override
	public void comprarVehiculo(Vehiculo vehiculo) {
	}

	/**
	 * Alquila un vehiculo por medio de la placa
	 */
	public void alquilarVehiculo(String placa) {

	}

	@Override
	public void venderVehiculo(String placa) {
	}

}