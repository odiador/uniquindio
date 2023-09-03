package co.edu.uniquindio.concesionariouq.model;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.mail.MessagingException;

import co.edu.uniquindio.concesionariouq.exceptions.AtributosFaltantesException;
import co.edu.uniquindio.concesionariouq.exceptions.NullException;
import co.edu.uniquindio.concesionariouq.exceptions.VehiculoNoExisteException;
import co.edu.uniquindio.concesionariouq.exceptions.VehiculoYaExisteException;
import co.edu.uniquindio.concesionariouq.util.ProjectUtility;

public class Cliente extends Persona implements GestionableVehiculo, Proveedor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Set<Vehiculo> listaVehiculos;
	private String correo;

	/**
	 * Es el constructor de la clase {@link Cliente}
	 * 
	 * @param id
	 * @param nombre
	 * @param correo
	 */
	public Cliente(String id, String nombre, String correo) {
		super(id, nombre);
		this.correo = correo;
		listaVehiculos = new HashSet<>();
	}

	@Override
	public TipoPersona getTipoPersona() {
		return TipoPersona.CLIENTE;
	}

	@Override
	public boolean atributosLlenos() {
		return super.atributosLlenos() && listaVehiculos != null && correo != null && !correo.isEmpty();
	}

	@Override
	public Vehiculo buscarVehiculo(String id) {
		return listaVehiculos.stream().filter(vehiculo -> vehiculo.tieneId(id)).findFirst().orElse(null);
	}

	@Override
	public void agregarVehiculo(Vehiculo vehiculo)
			throws VehiculoYaExisteException, AtributosFaltantesException, NullException {
		if (vehiculo == null)
			throw new NullException("El vehiculo enviado es null");
		if (!vehiculo.atributosLlenos())
			throw new AtributosFaltantesException("Al vehiculo le hacen falta datos");
		if (validarVehiculo(vehiculo.getId()))
			throw new VehiculoYaExisteException("El vehiculo ya existe, no se puede agregar");

		listaVehiculos.add(vehiculo);
	}

	@Override
	public void eliminarVehiculo(String id) throws VehiculoNoExisteException, NullException {
		if (id == null)
			throw new NullException("La identificacion enviada es null");
		Vehiculo vehiculo = buscarVehiculo(id);
		if (vehiculo == null)
			throw new VehiculoNoExisteException("El vehiculo no existe, no se puede eliminar");
		listaVehiculos.remove(vehiculo);
	}

	@Override
	public List<Vehiculo> listarVehiculos() {
		return listaVehiculos.stream().collect(Collectors.toList());
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	@Override
	public TipoProveedor getTipoProveedor() {
		return TipoProveedor.CLIENTE;
	}

	public void enviarReporteVehiculos() throws MessagingException, IOException {
		ProjectUtility.enviarReporteConPdf(listarVehiculos(), "Reporte de Vehiculos_" + getNombre(), getCorreo(),
				getNombre());
	}

}