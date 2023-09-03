package co.edu.uniquindio.concesionariouq.controllers;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import co.edu.uniquindio.concesionariouq.exceptions.AtributosFaltantesException;
import co.edu.uniquindio.concesionariouq.exceptions.LoginFailedException;
import co.edu.uniquindio.concesionariouq.exceptions.NullException;
import co.edu.uniquindio.concesionariouq.exceptions.TransaccionYaExisteException;
import co.edu.uniquindio.concesionariouq.exceptions.UsuarioEncontradoException;
import co.edu.uniquindio.concesionariouq.exceptions.UsuarioNoEncontradoException;
import co.edu.uniquindio.concesionariouq.exceptions.VehiculoNoExisteException;
import co.edu.uniquindio.concesionariouq.exceptions.VehiculoYaExisteException;
import co.edu.uniquindio.concesionariouq.model.Cliente;
import co.edu.uniquindio.concesionariouq.model.Compra;
import co.edu.uniquindio.concesionariouq.model.Concesionario;
import co.edu.uniquindio.concesionariouq.model.Empleado;
import co.edu.uniquindio.concesionariouq.model.Transaccion;
import co.edu.uniquindio.concesionariouq.model.Vehiculo;
import co.edu.uniquindio.concesionariouq.model.Venta;

public class ModelFactoryController {

	private Concesionario concesionario;

	public static class Singleton {
		private final static ModelFactoryController eINSTANCE = new ModelFactoryController();
	}

	public static ModelFactoryController getInstance() {
		return Singleton.eINSTANCE;
	}

	public Concesionario getConcesionario() {
		if (concesionario == null)
			loadData();
		return concesionario;
	}

	public Empleado hacerLogin(String id, String password) throws LoginFailedException, NullException {
		return getConcesionario().hacerLogin(id, password);
	}

	public void agregarCliente(Cliente cliente)
			throws UsuarioEncontradoException, NullException, AtributosFaltantesException {
		getConcesionario().agregarCliente(cliente);
		saveData();
	}

	public void eliminarCliente(String id) throws NullException, UsuarioNoEncontradoException {
		getConcesionario().eliminarCliente(id);
		saveData();
	}

	public void setConcesionario(Concesionario concesionario) {
		this.concesionario = concesionario;
	}

	public List<Vehiculo> listarVehiculo() {
		return getConcesionario().listarVehiculos();
	}

	public Empleado buscarEmpleado(String id) {
		return getConcesionario().buscarEmpleado(id);
	}

	public void agregarEmpleado(Empleado empleado)
			throws UsuarioEncontradoException, AtributosFaltantesException, NullException {
		getConcesionario().agregarEmpleado(empleado);
		saveData();
	}

	public void actualizarContrasena(String id, String pass) throws NullException, UsuarioNoEncontradoException {
		getConcesionario().actualizarContrasena(id, pass);
		saveData();
	}

	/**
	 * Serializa el objeto concesionario convirtiendolo en una serie de bits y lo
	 * guarda en la ruta seleccionada.
	 */
	public void saveData() {

		try (FileOutputStream fileOut = new FileOutputStream(
				"src/co/edu/uniquindio/concesionariouq/controllers/data.dat");
				ObjectOutputStream obOut = new ObjectOutputStream(fileOut);) {
			obOut.writeObject(getConcesionario());

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Obtiene los datos del archivo serializado y setea el concesionario con estos
	 * datos.
	 */
	public void loadData() {
		try (FileInputStream fileIn = new FileInputStream("src/co/edu/uniquindio/concesionariouq/controllers/data.dat");
				ObjectInputStream obOut = new ObjectInputStream(fileIn);) {
			setConcesionario((Concesionario) obOut.readObject());
		} catch (IOException | ClassNotFoundException e) {
			setConcesionario(new Concesionario("Carro UQ", "Universidad del Quindio"));
			saveData();
		}
	}

	/**
	 * Enlista los clientes del concesionario.
	 * 
	 * @return
	 */
	public List<Cliente> listarClientes() {
		return getConcesionario().listarClientes();
	}

	/**
	 * Agrega un vehiculo a la lista del concesionario.
	 * 
	 * @param vehiculo
	 * @throws NullException
	 * @throws AtributosFaltantesException
	 * @throws VehiculoYaExisteException
	 */
	public void agregarVehiculo(Vehiculo vehiculo)
			throws NullException, AtributosFaltantesException, VehiculoYaExisteException {
		getConcesionario().agregarVehiculo(vehiculo);
		saveData();
	}

	public void venderVehiculoACliente(String idCliente, Venta venta)
			throws NullException, VehiculoYaExisteException, AtributosFaltantesException, UsuarioNoEncontradoException,
			TransaccionYaExisteException, VehiculoNoExisteException {
		getConcesionario().venderVehiculoACliente(idCliente, venta);
		saveData();
	}

	public void comprarVehiculoDeCliente(String id, Compra compra)
			throws NullException, VehiculoYaExisteException, AtributosFaltantesException, UsuarioNoEncontradoException,
			TransaccionYaExisteException, VehiculoNoExisteException {
		getConcesionario().comprarVehiculoDeCliente(id, compra);
		saveData();
	}

	public void eliminarEmpleado(String id) throws UsuarioNoEncontradoException, NullException {
		getConcesionario().eliminarEmpleado(id);
		saveData();
	}

	public List<Empleado> listarEmpleados() {
		return getConcesionario().listarEmpleados();
	}

	public List<Transaccion> listarTransacciones() {
		return getConcesionario().listarTransacciones();
	}

}
