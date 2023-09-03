package co.edu.uniquindio.carrouq.model;

import java.util.ArrayList;
import java.util.List;

public class Transaccion {
	private String codigo;
	private List<DetalleTransaccion> listaDetalleTransacciones;

	/**
	 * 
	 */
	public Transaccion() {
	}

	/**
	 * 
	 * @param codigo
	 */
	public Transaccion(final String codigo) {
		this.codigo = codigo;
		this.listaDetalleTransacciones = new ArrayList<DetalleTransaccion>();
	}

	/**
	 * 
	 * @return
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * 
	 * @param codigo
	 */
	public void setCodigo(final String codigo) {
		this.codigo = codigo;
	}

	/**
	 * 
	 * @return
	 */
	public List<DetalleTransaccion> getListaDetalleTransacciones() {
		return listaDetalleTransacciones;
	}

	/**
	 * 
	 * @param listaDetalleTransacciones
	 */
	public void setListaDetalleTransacciones(final List<DetalleTransaccion> listaDetalleTransacciones) {
		this.listaDetalleTransacciones = listaDetalleTransacciones;
	}

	/**
	 * 
	 * @param tipo
	 */
	public void agregarDetalleTransaccion(final TipoTransaccion tipo) {

	}
}