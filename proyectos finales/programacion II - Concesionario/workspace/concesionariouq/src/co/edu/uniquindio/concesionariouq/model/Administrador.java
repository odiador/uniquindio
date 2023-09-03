package co.edu.uniquindio.concesionariouq.model;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import co.edu.uniquindio.concesionariouq.exceptions.AtributosFaltantesException;
import co.edu.uniquindio.concesionariouq.exceptions.NullException;
import co.edu.uniquindio.concesionariouq.exceptions.UsuarioEncontradoException;
import co.edu.uniquindio.concesionariouq.exceptions.UsuarioNoEncontradoException;
import javafx.scene.image.Image;

public class Administrador extends Empleado implements GestionableEmpleado {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected Set<Empleado> listaEmpleados;

	/**
	 * Este es el metodo constructor de la clase Administrador
	 * 
	 * @param id
	 * @param nombre
	 * @param contrasena
	 * @param email
	 * @param respuestaDeSeguridad
	 * @param estaActivo
	 * @param file
	 */
	public Administrador(String id, String nombre, String contrasena, String email, String respuestaDeSeguridad,
			Boolean estaActivo, Image file) {
		super(id, nombre, contrasena, email, respuestaDeSeguridad, estaActivo, file);
		this.listaEmpleados = new HashSet<>();
	}

	@Override
	public boolean atributosLlenos() {
		return super.atributosLlenos() && listaEmpleados != null;
	}

	@Override
	public TipoPersona getTipoPersona() {
		return TipoPersona.ADMIN;
	}

	@Override
	public void agregarEmpleado(Empleado empleado)
			throws UsuarioEncontradoException, AtributosFaltantesException, NullException {
		if (empleado == null)
			throw new NullException("El empleado enviado es null");
		if (!empleado.atributosLlenos())
			throw new NullException("El empleado tiene atributos sin llenar");
		if (validarEmpleado(empleado.getId())) {
			throw new UsuarioEncontradoException("El empleado fue encontrado, no se puede agregar");
		}
		listaEmpleados.add(empleado);
	}

	@Override
	public boolean validarEmpleado(String id) {
		return buscarEmpleado(id) != null;
	}

	/**
	 * Este metodo elimina un empleado
	 */
	@Override
	public void eliminarEmpleado(String id) throws UsuarioNoEncontradoException, NullException {

		if (id == null)
			throw new NullException("El id enviado es null");
		Empleado buscarEmpleado = buscarEmpleado(id);
		if (buscarEmpleado == null)
			throw new UsuarioNoEncontradoException("El empleado no se ha encontrado, no se puede eliminar");
		listaEmpleados.remove(buscarEmpleado);
	}

	@Override
	public Empleado buscarEmpleado(String id) {
		return listaEmpleados.stream().filter(empleado -> empleado.tieneId(id)).findFirst().orElse(null);
	}

	@Override
	public List<Empleado> listarEmpleados() {
		return listaEmpleados.stream().collect(Collectors.toList());
	}

	/**
	 * Este metodo actualiza un empleado
	 * 
	 * @param empleado
	 * @throws NullException
	 * @throws UsuarioNoEncontradoException
	 */
	public void actualizarEmpleado(Empleado empleado) throws NullException, UsuarioNoEncontradoException {
		if (empleado == null)
			throw new NullException("El empleado enviado es null");
		if (!validarEmpleado(empleado.getId()))
			throw new UsuarioNoEncontradoException("El empleado no ha encontrado, no se puede actualizar");
		listaEmpleados.remove(empleado);
		listaEmpleados.add(empleado);
	}

	/**
	 * Este metodo bloquea a un empleado
	 * 
	 * @param id
	 * @throws UsuarioNoEncontradoException
	 * @throws NullException
	 */
	public void bloquearEmpleado(String id) throws UsuarioNoEncontradoException, NullException {
		if (!validarEmpleado(id))
			throw new UsuarioNoEncontradoException("El empleado no fue encontrado");
		Empleado empleado = buscarEmpleado(id);
		empleado.setIsActivo(false);
		actualizarEmpleado(empleado);
	}

	@Override
	public String toString() {
		final int maxLen = 10;
		return String.format(
				"Administrador [id=%s, nombre=%s, contrasena=%s, email=%s, respuestaDeSeguridad=%s, estaActivo=%s, listaEmpleados=%s]",
				id, nombre, contrasena, email, respuestaDeSeguridad, estaActivo,
				listaEmpleados != null ? toString(listaEmpleados, maxLen) : null);
	}

	private String toString(Collection<?> collection, int maxLen) {
		StringBuilder builder = new StringBuilder();
		builder.append("[");
		int i = 0;
		for (Iterator<?> iterator = collection.iterator(); iterator.hasNext() && i < maxLen; i++) {
			if (i > 0)
				builder.append(", ");
			builder.append(iterator.next());
		}
		builder.append("]");
		return builder.toString();
	}

}
