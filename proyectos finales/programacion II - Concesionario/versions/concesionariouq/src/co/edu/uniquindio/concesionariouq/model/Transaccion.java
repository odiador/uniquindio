package co.edu.uniquindio.concesionariouq.model;

import java.util.ArrayList;
import java.util.List;

import co.edu.uniquindio.concesionariouq.exceptions.ConcesionarioException;

public class Transaccion {

	// ATRIBUTOS
	private String codigo;
	private List<DetalleTransaccion> listaDetalleTransacciones;

	/**
	 * Este es el constructor vacio de la clase
	 * 
	 */
	public Transaccion() {
	}

	/**
	 * Este es el constructor principal de la clase
	 * 
	 * @param codigo
	 */
	public Transaccion(final String codigo) {
		this.codigo = codigo;
		this.listaDetalleTransacciones = new ArrayList<DetalleTransaccion>();
	}

	/**
	 * Obtiene el codigo de la Transaccion
	 * 
	 * @return codigo
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * Cambia el codigo de la Transaccion
	 * 
	 * @param codigo
	 */
	public void setCodigo(final String codigo) {
		this.codigo = codigo;
	}

	/**
	 * Obtiene la lista de los detalles de las transacciones
	 * 
	 * @return listaDetalleTransacciones
	 */
	public List<DetalleTransaccion> getListaDetalleTransacciones() {
		return listaDetalleTransacciones;
	}

	/**
	 * Cambia la lista de los detalles de las transacciones
	 * 
	 * @param listaDetalleTransacciones
	 */
	public void setListaDetalleTransacciones(final List<DetalleTransaccion> listaDetalleTransacciones) {
		this.listaDetalleTransacciones = listaDetalleTransacciones;
	}

	/**
	 * Agrega un detalle a la transaccion, muestra un error si ya existe
	 * 
	 * @param tipo
	 * @throws ConcesionarioException
	 */
	public void agregarDetalleTransaccion(Vehiculo vehiculo, String codigoTransaccion, TipoTransaccion tipo)
			throws ConcesionarioException {
		if (validarDetalleTransaccion(codigo))
			throw new ConcesionarioException("El detalle de la transacción ya se encuentra, elige otro código");
		listaDetalleTransacciones.add(new DetalleTransaccion(vehiculo, codigoTransaccion, tipo));
	}

	/**
	 * Busca un detalle de transaccion, si no se encuentra se retorna un null
	 * 
	 * @param codigo
	 * @return
	 */
	public DetalleTransaccion buscarDetalleTransaccion(String codigo) {
		return listaDetalleTransacciones.stream().filter(detalle -> detalle.getCodigoTransaccion().equals(codigo))
				.findFirst().orElse(null);
	}

	/**
	 * Elimina cada detalle de la transaccion
	 */
	public void eliminarCadaDetalle() {
		listaDetalleTransacciones.clear();
	}

	/**
	 * Valida si un detalle de transaccion existe, si no se encuentra retorna un
	 * false
	 * 
	 * @param codigo
	 * @return
	 */
	public boolean validarDetalleTransaccion(String codigo) {
		return buscarDetalleTransaccion(codigo) != null;
	}
}