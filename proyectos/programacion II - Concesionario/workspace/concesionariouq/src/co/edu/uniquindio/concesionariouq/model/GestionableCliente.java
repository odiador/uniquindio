package co.edu.uniquindio.concesionariouq.model;

import java.util.List;

import co.edu.uniquindio.concesionariouq.exceptions.AtributosFaltantesException;
import co.edu.uniquindio.concesionariouq.exceptions.NullException;
import co.edu.uniquindio.concesionariouq.exceptions.UsuarioEncontradoException;
import co.edu.uniquindio.concesionariouq.exceptions.UsuarioNoEncontradoException;

public interface GestionableCliente {

	public void agregarCliente(Cliente cliente)
			throws UsuarioEncontradoException, AtributosFaltantesException, NullException;

	public void eliminarCliente(String id)
			throws UsuarioNoEncontradoException, AtributosFaltantesException, NullException;

	public Cliente buscarCliente(String id);

	public default boolean validarCliente(String id) {
		return buscarCliente(id) != null;
	}

	public List<Cliente> listarClientes();
}
