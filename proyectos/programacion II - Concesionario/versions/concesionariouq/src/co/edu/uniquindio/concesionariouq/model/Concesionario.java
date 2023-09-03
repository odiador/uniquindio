package co.edu.uniquindio.concesionariouq.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;

import co.edu.uniquindio.concesionariouq.exceptions.ClienteNoEncontradoException;
import co.edu.uniquindio.concesionariouq.exceptions.ConcesionarioException;
import co.edu.uniquindio.concesionariouq.exceptions.LoginFailedException;
import co.edu.uniquindio.concesionariouq.exceptions.TransaccionYaExisteException;
import co.edu.uniquindio.concesionariouq.exceptions.UsuarioNoEsClienteException;
import co.edu.uniquindio.concesionariouq.exceptions.VehiculoNoExisteException;
import co.edu.uniquindio.concesionariouq.exceptions.VehiculoYaExisteException;

public class Concesionario implements Negociable {

	// ATRIBUTOS
	private String nombre;
	private String direccion;
	private Map<String, Vehiculo> listaVehiculos;
	private Map<String, Usuario> listaUsuarios;
	private Map<String, Transaccion> listaTransacciones;

	/**
	 * Es el metodo constructor vacio de la clase
	 */
	public Concesionario() {
	}

	/**
	 * Es el metodo constructor de la clase
	 */
	public Concesionario(final String nombre, final String direccion) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.listaVehiculos = new HashMap<String, Vehiculo>();
		this.listaUsuarios = new HashMap<String, Usuario>();
		this.listaTransacciones = new HashMap<String, Transaccion>();
	}

	/**
	 * Obtiene el nombre del concesionario
	 *
	 * @return nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Cambia el nombre del concesionario
	 *
	 * @param nombre
	 */
	public void setNombre(final String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Obtiene la direccion del concesionario
	 *
	 * @return direccion
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * Cambia la direccion del concesionario
	 *
	 * @param direccion
	 */
	public void setDireccion(final String direccion) {
		this.direccion = direccion;
	}

	public Vehiculo buscarVehiculo(String placa) {
		return listaVehiculos.getOrDefault(placa, null);
	}

	/**
	 * Agrega una transaccion al concesionario
	 *
	 */
	public void agregarTransaccion(String codigo) throws TransaccionYaExisteException {
		throwIfTransaccionExist(codigo);
		listaTransacciones.put(codigo, new Transaccion(codigo));
	}

	/**
	 * Valida si una transaccion existe o no a partir de su código
	 * 
	 * @param codigo
	 * @return
	 */
	private boolean validarTransaccion(String codigo) {
		return buscarTransaccion(codigo) != null;
	}

	/**
	 * Muestra un error en caso de que la transaccion ya exista
	 * 
	 * @param codigo
	 * @throws TransaccionYaExisteException
	 */
	private void throwIfTransaccionExist(String codigo) throws TransaccionYaExisteException {
		if (validarTransaccion(codigo))
			throw new TransaccionYaExisteException("La transaccion ya existe");
	}

	/**
	 * Elimina una transaccion, muestra un error si no se encuentra
	 * 
	 * @param codigo
	 * @throws ConcesionarioException
	 */
	public void eliminarTransaccion(String codigo) throws TransaccionYaExisteException {
		throwIfTransaccionExist(codigo);
		listaTransacciones.remove(codigo);
	}

	/**
	 * Agrega detalle a una transaccion del concesionario
	 * 
	 * @throws ConcesionarioException
	 *
	 */
	public void agregarDetalleTransaccion(String codigoTransaccion, String codigoDetalle, Vehiculo vehiculo,
			TipoTransaccion tipo) throws ConcesionarioException {
		Transaccion transaccion = buscarTransaccion(codigoTransaccion);
		if (transaccion == null)
			throw new ConcesionarioException("El detalle de la transaccion no fue encontrado");

		transaccion.agregarDetalleTransaccion(vehiculo, codigoTransaccion, tipo);
	}

	public Transaccion buscarTransaccion(String codigoTransaccion) {
		return listaTransacciones.getOrDefault(codigoTransaccion, null);
	}

	/**
	 * Generar reporte al concesionario
	 *
	 */
	public void generarReporte() {

	}

	/**
	 * Agrega foto al concesionario
	 *
	 */
	public void agregarFoto() {

	}

	/**
	 * Envia email de recuperacion al usuario para restablecer su contrasena
	 *
	 */
	public void enviarEmailRecuperacion() {

	}

	/**
	 * Vende un vehiculo a un usuario
	 * 
	 * @param placa
	 * @throws VehiculoYaExisteExceptio
	 * @throws VehiculoNoExisteException
	 */
	public void venderVehiculoaUsuario(String idCliente, String placa)
			throws VehiculoNoExisteException, VehiculoYaExisteException {
		Cliente usuario = (Cliente) buscarUsuario(idCliente);
		Vehiculo vehiculo = buscarVehiculo(placa);
		eliminarVehiculo(vehiculo);
		usuario.agregarVehiculo(vehiculo);
	}

	/**
	 * 
	 * Elimina el cliente
	 * 
	 * @param placa
	 * @throws ClienteNoEncontradoException
	 * @throws ConcesionarioException
	 * @throws UsuarioNoEsClienteException
	 */
	public void venderVehiculoaConcesionario(String idCliente, String placa)
			throws ConcesionarioException, ClienteNoEncontradoException, UsuarioNoEsClienteException {
		Usuario buscarUsuario = buscarUsuario(idCliente);
		if (buscarUsuario == null)
			throw new ClienteNoEncontradoException("El usuario no fue encontrado");
		if (!(buscarUsuario instanceof Cliente))
			throw new UsuarioNoEsClienteException("El usuario encontrado no es un cliente");

		((Cliente) buscarUsuario).eliminarVehiculo(placa);
	}

	public void comprarVehiculo(Vehiculo vehiculo) {
	}

	/**
	 * Este metodo agrega un bus al concesionario
	 *
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
	 * @param numeroEjes
	 * @param numeroSalidasEmergencia
	 * @throws ConcesionarioException
	 */
	public void agregarBus(String placa, String marca, String modelo, Double cilindraje, Double velocidadMaxima,
			Combustible combustible, EstadoVehiculo estado, TipoCambio tipo, Integer numeroPasajeros,
			Integer numeroBolsasAire, Integer numeroPuertas, Boolean tieneAireAcondicionado, Boolean tieneCamaraReversa,
			Boolean tieneABS, Double capacidadMaletero, Integer numeroEjes, Integer numeroSalidasEmergencia)
			throws ConcesionarioException {
		throwIfVehiculoExist(placa);
		Bus bus = new Bus(placa, marca, modelo, cilindraje, velocidadMaxima, combustible, estado, tipo, numeroPasajeros,
				numeroBolsasAire, numeroPuertas, tieneAireAcondicionado, tieneCamaraReversa, tieneABS,
				capacidadMaletero, numeroEjes, numeroSalidasEmergencia);
		listaVehiculos.put(placa, bus);
	}

	private boolean validarVehiculo(String placa) {
		return buscarVehiculo(placa) != null;
	}

	/**
	 * Busca un usuario basandose en su identificacion
	 *
	 * @param identificacion
	 * @return
	 */
	public Usuario buscarUsuario(String identificacion) {
		return listaUsuarios.getOrDefault(identificacion, null);
	}

	/**
	 * Busca un usuario a partir de su identificacion y contraseña
	 *
	 * @param identificacion
	 * @param contrasena
	 * @return
	 */
	public Usuario buscarUsuario(String identificacion, String contrasena) {
		Usuario usuario = buscarUsuario(identificacion);
		if (usuario != null && usuario.getContrasena().equals(contrasena))
			return usuario;
		return null;
	}

	/**
	 * Intenta hacer login al usuario, si no se puede marca una excepcion
	 * 
	 * @param contrasena
	 * @param identificacion
	 * @throws LoginFailedException
	 */
	public void hacerLogin(String identificacion, String contrasena) throws LoginFailedException {
		if (buscarUsuario(identificacion, contrasena) == null) {
			throw new LoginFailedException(
					"La id o contraseña especificada no coinciden con tus datos, intenta nuevamente");
		}
	}

	/**
	 * 
	 * @param identificacion
	 * @return
	 */
	public boolean validarUsuario(String identificacion) {
		return buscarUsuario(identificacion) != null;
	}

	/**
	 * Valida si un usuario existe, verificando su identificacion y contraseña
	 *
	 * @param identificacion
	 * @param contrasena
	 * @return
	 */
	public boolean validarUsuario(String identificacion, String contrasena) {
		return buscarUsuario(identificacion, contrasena) != null;
	}

	/**
	 * Agrega un usuario administrador al concesionario, muestra un error en caso de
	 * que ya esté agregado
	 *
	 * @param nombre
	 * @param id
	 * @param contrasena
	 * @param email
	 * @throws ConcesionarioException
	 */
	public void agregarAdministrador(String nombre, String id, String contrasena, String email)
			throws ConcesionarioException {
		if (validarUsuario(id))
			throw new ConcesionarioException("El usuario ya se encuentra agregado");
		Administrador administrador = new Administrador(id, nombre, contrasena, email);
		listaUsuarios.put(id, administrador);
	}

	public void agregarEmpleado(String nombre, String id, String contrasena, String email)
			throws ConcesionarioException {
		if (validarUsuario(id))
			throw new ConcesionarioException("El usuario ya se encuentra agregado");
		Empleado empleado = new Empleado(id, nombre, contrasena, email);
		listaUsuarios.put(id, empleado);
	}

	public void agregarCliente(String nombre, String id, String contrasena, String email)
			throws ConcesionarioException {
		if (validarUsuario(id))
			throw new ConcesionarioException("El usuario ya se encuentra agregado");
		Cliente cliente = new Cliente(id, nombre, contrasena, email);
		listaUsuarios.put(id, cliente);

	}

	/**
	 * Agregar un nuevo Camtaion al la lista de vehiculos
	 * 
	 * @param placa
	 * @param marca
	 * @param modelo
	 * @param cilindraje
	 * @param velocidadMaxima
	 * @param combustible
	 * @param estado
	 * @param tipo
	 * @param capacidadCarga
	 * @param tieneAireAcondicionado
	 * @param tieneFrenosAire
	 * @param numeroEjes
	 * @param tieneABS
	 * @param tipoCamion
	 * @throws ConcesionarioException
	 */
	public void agregarCamion(String placa, String marca, String modelo, Double cilindraje, Double velocidadMaxima,
			Combustible combustible, EstadoVehiculo estado, TipoCambio tipo, Double capacidadCarga,
			Boolean tieneAireAcondicionado, Boolean tieneFrenosAire, Integer numeroEjes, Boolean tieneABS,
			String tipoCamion) throws ConcesionarioException {
		throwIfVehiculoExist(placa);
		Camion camion = new Camion(placa, marca, modelo, cilindraje, velocidadMaxima, combustible, estado, tipo,
				capacidadCarga, tieneAireAcondicionado, tieneFrenosAire, numeroEjes, tieneABS, tipoCamion);
		listaVehiculos.put(placa, camion);

	}

	/**
	 * Automatiza la verificacion de vehiculos
	 * 
	 * @param placa
	 * @throws ConcesionarioException
	 */
	private void throwIfVehiculoExist(String placa) throws ConcesionarioException {
		if (validarVehiculo(placa))
			throw new ConcesionarioException("El vehiculo con la placa " + placa + " ya existe");
	}

	/**
	 * Agregar un nuevo Camion a la lista de vehiculos
	 * 
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
	 * @param tieneVelocidadCrucero
	 * @param tieneSensorColision
	 * @param tieneSensorTrafico
	 * @param tieneAsistentePermanencia
	 * @param es4x4
	 * @throws ConcesionarioException
	 */
	public void agregarCamioneta(String placa, String marca, String modelo, Double cilindraje, Double velocidadMaxima,
			Combustible combustible, EstadoVehiculo estado, TipoCambio tipo, Integer numeroPasajeros,
			Integer numeroBolsasAire, Integer numeroPuertas, Boolean tieneAireAcondicionado, Boolean tieneCamaraReversa,
			Boolean tieneABS, Double capacidadMaletero, Boolean tieneVelocidadCrucero, Boolean tieneSensorColision,
			Boolean tieneSensorTrafico, Boolean tieneAsistentePermanencia, Boolean es4x4)
			throws ConcesionarioException {
		throwIfVehiculoExist(placa);
		Camioneta camioneta = new Camioneta(placa, marca, modelo, cilindraje, velocidadMaxima, combustible, estado,
				tipo, numeroPasajeros, numeroBolsasAire, numeroPuertas, tieneAireAcondicionado, tieneCamaraReversa,
				tieneABS, capacidadMaletero, tieneVelocidadCrucero, tieneSensorColision, tieneSensorTrafico,
				tieneAsistentePermanencia, es4x4);
		listaVehiculos.put(placa, camioneta);
	}

	/**
	 * Agregar un nuevo Deportivo a la lista de vehiculos
	 * 
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
	 * @param numeroCaballosFuerza
	 * @param tiempoAlcanza100Kmh
	 * @throws ConcesionarioException
	 */
	public void agregarDeportivo(String placa, String marca, String modelo, Double cilindraje, Double velocidadMaxima,
			Combustible combustible, EstadoVehiculo estado, TipoCambio tipo, Integer numeroPasajeros,
			Integer numeroBolsasAire, Integer numeroPuertas, Integer numeroCaballosFuerza, Integer tiempoAlcanza100Kmh)
			throws ConcesionarioException {
		throwIfVehiculoExist(placa);
		Deportivo deportivo = new Deportivo(placa, marca, modelo, cilindraje, velocidadMaxima, combustible, estado,
				tipo, numeroPasajeros, numeroBolsasAire, numeroPuertas, numeroCaballosFuerza, tiempoAlcanza100Kmh);
		listaVehiculos.put(placa, deportivo);
	}

	/**
	 * Agregar una nueva Moto a la lista de vehiculos
	 * 
	 * @param placa
	 * @param marca
	 * @param modelo
	 * @param cilindraje
	 * @param velocidadMaxima
	 * @param combustible
	 * @param estado
	 * @param tipo
	 * @throws ConcesionarioException
	 */
	public void agregarMoto(String placa, String marca, String modelo, Double cilindraje, Double velocidadMaxima,
			Combustible combustible, EstadoVehiculo estado, TipoCambio tipo) throws ConcesionarioException {
		throwIfVehiculoExist(placa);
		listaVehiculos.put(placa,
				new Moto(placa, marca, modelo, cilindraje, velocidadMaxima, combustible, estado, tipo));
	}

	/**
	 * Agregar un nuevo PickUp a la lista de vehiculos
	 * 
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
	 * @param es4x4
	 * @param capacidadCajaCarga
	 * @throws ConcesionarioException
	 */
	public void agregarPickUp(String placa, String marca, String modelo, Double cilindraje, Double velocidadMaxima,
			Combustible combustible, EstadoVehiculo estado, TipoCambio tipo, Integer numeroPasajeros,
			Integer numeroBolsasAire, Integer numeroPuertas, Boolean tieneAireAcondicionado, Boolean tieneCamaraReversa,
			Boolean tieneABS, Boolean es4x4, Double capacidadCajaCarga) throws ConcesionarioException {
		throwIfVehiculoExist(placa);
		PickUp pickUp = new PickUp(placa, marca, modelo, cilindraje, velocidadMaxima, combustible, estado, tipo,
				numeroPasajeros, numeroBolsasAire, numeroPuertas, tieneAireAcondicionado, tieneCamaraReversa, tieneABS,
				es4x4, capacidadCajaCarga);
		listaVehiculos.put(placa, pickUp);
	}

	/**
	 * Agregar un nuevo Sedan a la lista de vehiculos
	 * 
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
	 * @param tieneVelocidadCrucero
	 * @param tieneSensorColision
	 * @param tieneSensorTrafico
	 * @param tieneAsistentePermanencia
	 * @throws ConcesionarioException
	 */
	public void agregarSedan(String placa, String marca, String modelo, Double cilindraje, Double velocidadMaxima,
			Combustible combustible, EstadoVehiculo estado, TipoCambio tipo, Integer numeroPasajeros,
			Integer numeroBolsasAire, Integer numeroPuertas, Boolean tieneAireAcondicionado, Boolean tieneCamaraReversa,
			Boolean tieneABS, Double capacidadMaletero, Boolean tieneVelocidadCrucero, Boolean tieneSensorColision,
			Boolean tieneSensorTrafico, Boolean tieneAsistentePermanencia) throws ConcesionarioException {
		throwIfVehiculoExist(placa);
		Sedan sedan = new Sedan(placa, marca, modelo, cilindraje, velocidadMaxima, combustible, estado, tipo,
				numeroPasajeros, numeroBolsasAire, numeroPuertas, tieneAireAcondicionado, tieneCamaraReversa, tieneABS,
				capacidadMaletero, tieneVelocidadCrucero, tieneSensorColision, tieneSensorTrafico,
				tieneAsistentePermanencia);
		listaVehiculos.put(placa, sedan);
	}

	/**
	 * Agregar una nueva Van a la lista de vehiculos
	 * 
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
	 * @throws ConcesionarioException
	 */
	public void agregarVan(String placa, String marca, String modelo, Double cilindraje, Double velocidadMaxima,
			Combustible combustible, EstadoVehiculo estado, TipoCambio tipo, Integer numeroPasajeros,
			Integer numeroBolsasAire, Integer numeroPuertas, Boolean tieneAireAcondicionado, Boolean tieneCamaraReversa,
			Boolean tieneABS, Double capacidadMaletero) throws ConcesionarioException {
		throwIfVehiculoExist(placa);
		Van van = new Van(placa, marca, modelo, cilindraje, velocidadMaxima, combustible, estado, tipo, numeroPasajeros,
				numeroBolsasAire, numeroPuertas, tieneAireAcondicionado, tieneCamaraReversa, tieneABS,
				capacidadMaletero);
		listaVehiculos.put(placa, van);
	}

	/**
	 * Elimina un vehiculo por medio de la placa, si no se encuentra se muestra una
	 * excepcion
	 * 
	 * @param placa
	 * @throws ConcesionarioException
	 */
	public void eliminarVehiculo(String placa) throws VehiculoNoExisteException {
		if (!validarVehiculo(placa))
			throw new VehiculoNoExisteException("El vehiculo con la placa " + placa + " no existe");
		listaVehiculos.remove(placa);
	}

	@Override
	public void agregarVehiculo(Vehiculo vehiculo) throws VehiculoNoExisteException {
		if (validarVehiculo(vehiculo.getPlaca()))
			throw new VehiculoNoExisteException("El vehiculo con la placa " + vehiculo.getPlaca() + " no existe");
		listaVehiculos.remove(vehiculo.getPlaca());
	}

	@Override
	public void eliminarVehiculo(Vehiculo vehiculo) throws VehiculoNoExisteException {
		if (!validarVehiculo(vehiculo.getPlaca()))
			throw new VehiculoNoExisteException("El vehiculo con la placa " + vehiculo.getPlaca() + " no existe");
		listaVehiculos.remove(vehiculo.getPlaca());
	}

	/**
	 * Lista los vehiculos del concesionario, como la lista de vehiculos es en
	 * realidad un map, toca convertirlo a un set, y luego hacer un map para cambiar
	 * el tipo de variable a vehiculo
	 * 
	 * @return
	 */
	public List<Vehiculo> listarVehiculos() {
		return listaVehiculos.entrySet().stream()
				.map((Function<? super Entry<String, Vehiculo>, ? extends Vehiculo>) mapper -> {
					return mapper.getValue();
				}).collect(Collectors.toList());
	}
}
