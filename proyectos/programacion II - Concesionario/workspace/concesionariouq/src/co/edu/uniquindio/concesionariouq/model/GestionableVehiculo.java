package co.edu.uniquindio.concesionariouq.model;

import java.util.List;

import co.edu.uniquindio.concesionariouq.exceptions.AtributosFaltantesException;
import co.edu.uniquindio.concesionariouq.exceptions.NullException;
import co.edu.uniquindio.concesionariouq.exceptions.VehiculoNoExisteException;
import co.edu.uniquindio.concesionariouq.exceptions.VehiculoYaExisteException;

public interface GestionableVehiculo {

	public void agregarVehiculo(Vehiculo vehiculo)
			throws VehiculoYaExisteException, AtributosFaltantesException, NullException;

	public void eliminarVehiculo(String id) throws VehiculoNoExisteException, NullException;

	public Vehiculo buscarVehiculo(String id);

	public default boolean validarVehiculo(String id) {
		return buscarVehiculo(id) != null;
	}

	public List<Vehiculo> listarVehiculos();
}
