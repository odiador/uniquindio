package co.edu.uniquindio.concesionariouq.model;

import java.util.List;

import co.edu.uniquindio.concesionariouq.exceptions.AtributosFaltantesException;
import co.edu.uniquindio.concesionariouq.exceptions.NullException;
import co.edu.uniquindio.concesionariouq.exceptions.UsuarioEncontradoException;
import co.edu.uniquindio.concesionariouq.exceptions.UsuarioNoEncontradoException;

public interface GestionableEmpleado {

	public void agregarEmpleado(Empleado empleado)
			throws UsuarioEncontradoException, AtributosFaltantesException, NullException;

	public void eliminarEmpleado(String id) throws UsuarioNoEncontradoException, NullException;

	public Empleado buscarEmpleado(String id);

	public default boolean validarEmpleado(String id) {
		return buscarEmpleado(id) != null;
	}

	public List<Empleado> listarEmpleados();
}
