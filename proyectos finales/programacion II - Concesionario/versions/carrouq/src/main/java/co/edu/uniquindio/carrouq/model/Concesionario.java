package co.edu.uniquindio.carrouq.model;

import java.util.ArrayList;
import java.util.List;

public class Concesionario implements PuedeTenerVehiculo {

	// ATRIBUTOS
	private String nombre;
	private String direccion;
	private List<Vehiculo> listaVehiculos;
	private List<Usuario> listaUsuarios;
	private List<Cliente> listaClientes;
	private List<Transaccion> listaTransacciones;

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
		this.listaVehiculos = new ArrayList<Vehiculo>();
		this.listaUsuarios = new ArrayList<Usuario>();
		this.listaClientes = new ArrayList<Cliente>();
		this.listaTransacciones = new ArrayList<Transaccion>();
	}

	/**
	 * 
	 * @return
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * 
	 * @param nombre
	 */
	public void setNombre(final String nombre) {
		this.nombre = nombre;
	}

	/**
	 * 
	 * @return
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * 
	 * @param direccion
	 */
	public void setDireccion(final String direccion) {
		this.direccion = direccion;
	}

	/**
	 * 
	 * @return
	 */
	public List<Vehiculo> getListaVehiculos() {
		return listaVehiculos;
	}

	/**
	 * 
	 * @param listaVehiculos
	 */
	public void setListaVehiculos(final List<Vehiculo> listaVehiculos) {
		this.listaVehiculos = listaVehiculos;
	}

	/**
	 * 
	 * @return
	 */
	public List<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}

	/**
	 * 
	 * @param listaUsuarios
	 */
	public void setListaUsuarios(final List<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

	/**
	 * 
	 * @return
	 */
	public List<Cliente> getListaClientes() {
		return listaClientes;
	}

	/**
	 * 
	 * @param listaClientes
	 */
	public void setListaClientes(final List<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}

	/**
	 * 
	 * @return
	 */
	public List<Transaccion> getListaTransacciones() {
		return listaTransacciones;
	}

	/**
	 * 
	 * @param listaTransacciones
	 */
	public void setListaTransacciones(final List<Transaccion> listaTransacciones) {
		this.listaTransacciones = listaTransacciones;
	}

	/**
	 * 
	 */
	public void registrarVehiculo() {

	}

	/**
	 * 
	 */
	public void agregarTransaccion() {

	}

	/**
	 * 
	 */
	public void agregarDetalleTransaccion() {

	}

	/**
	 * 
	 */
	public void generarReporte() {

	}

	/**
	 * 
	 */
	public void agregarFoto() {

	}

	/**
	 * 
	 */
	public void enviarEmailRecuperacion() {

	}

	@Override
	public void venderVehiculo(String placa) {
	}

	@Override
	public void comprarVehiculo(Vehiculo vehiculo) {
	}

}
