package co.edu.uniquindio.biblioteca.model;

import java.util.ArrayList;
import java.util.List;

public class Prestamo {

	private String fecha;
	private double total;
	private int tiempoEntrega;
	private String codigo;
	private ArrayList<DetallePrestamo> listaDetallePrestamo;
	private Empleado empleadoPrestamo;

	/**
	 * 
	 * @param fecha
	 * @param total
	 * @param tiempoEntrega
	 * @param codio
	 */
	public Prestamo(String fecha, double total, int tiempoEntrega, String codio) {
		super();
		this.fecha = fecha;
		this.total = total;
		this.tiempoEntrega = tiempoEntrega;
		this.codigo = codio;
		this.listaDetallePrestamo = new ArrayList<DetallePrestamo>();
	}

	/**
	 * 
	 * @return
	 */
	public Empleado getEmpleadoPrestamo() {
		return empleadoPrestamo;
	}

	/**
	 * 
	 * @param empleadoPrestamo
	 */
	public void setEmpleadoPrestamo(Empleado empleadoPrestamo) {
		this.empleadoPrestamo = empleadoPrestamo;
	}

	/**
	 * 
	 * @return
	 */
	public String getFecha() {
		return fecha;
	}

	/**
	 * 
	 * @param fecha
	 */
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	/**
	 * 
	 * @return
	 */
	public double getTotal() {
		return total;
	}

	/**
	 * 
	 * @param total
	 */
	public void setTotal(double total) {
		this.total = total;
	}

	/**
	 * 
	 * @return
	 */
	public int getTiempoEntrega() {
		return tiempoEntrega;
	}

	/**
	 * 
	 * @param tiempoEntrega
	 */
	public void setTiempoEntrega(int tiempoEntrega) {
		this.tiempoEntrega = tiempoEntrega;
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
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	/**
	 * 
	 * @return
	 */
	public ArrayList<DetallePrestamo> getListaDetallePrestamo() {
		return listaDetallePrestamo;
	}

	/**
	 * 
	 * @param listaDetallePrestamo
	 */
	public void setListaDetallePrestamo(ArrayList<DetallePrestamo> listaDetallePrestamo) {
		this.listaDetallePrestamo = listaDetallePrestamo;
	}

	/**
	 * Verifica si el total es igual a una cantidad si en el préstamo se encuentra
	 * algún libro con un autor
	 * 
	 * @param autor es el autor del libro a comparar
	 * @param valor es el valor total del préstamo a comparar
	 * @return true si se cumplen ambas condiciones
	 * @see {@link #verificarAutor(String)}
	 *      <li>{@link #verificarTotal(double)}
	 */
	public boolean verificarTotalAutor(String autor, double valor) {
		return verificarTotal(valor) && verificarAutor(autor);
	}

	/**
	 * 
	 * @param autor
	 * @return
	 */
	public boolean verificarAutor(String autor) {
		for (DetallePrestamo detallePrestamo : listaDetallePrestamo) {
			if (detallePrestamo.cumpleAutor(autor)) {
				return true;
			}
		}
		return false;
	}

	private boolean verificarTotal(double valor) {
		return total == getTotal();
	}

	/**
	 * 
	 * @param isbn
	 * @return
	 */
	public boolean cumpleIsbn(String isbn) {

		for (DetallePrestamo detallePrestamo : listaDetallePrestamo) {
			if (detallePrestamo.cumpleIsbn(isbn)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 
	 * @param isbn
	 * @return
	 */
	public boolean cumpleIsbny(String isbn) {

		boolean cumple = false;
		for (DetallePrestamo detallePrestamo : listaDetallePrestamo) {
			if (detallePrestamo.getCantidad() > 10) {
				return true;
			}
		}
		return cumple;
	}

	/**
	 * 
	 * @param isbn
	 * @return
	 */
	public boolean cumpleIsbnx(String isbn) {

		boolean cumple = false;
		for (DetallePrestamo detallePrestamo : listaDetallePrestamo) {
			if (detallePrestamo.getCantidad() > 10) {
				return true;
			}
		}
		return cumple;
	}

	/**
	 * 
	 * @param titulo
	 * @param limiteInferior
	 * @param limiteSuperior
	 * @param aniosExperiencia
	 * @return
	 */
	public boolean cumpleLibro(String titulo, int limiteInferior, int limiteSuperior, int aniosExperiencia) {

		for (DetallePrestamo detallePrestamo : listaDetallePrestamo) {
			if (detallePrestamo.cumpleLibro(titulo, limiteInferior, limiteSuperior)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Obtiene la cantidad de detalles que tienen un tipo de libro determinado
	 * 
	 * @param tipo el tipo a comparar
	 * @return la cantidad
	 */
	public int obtenerCantidadTipo(Tipo tipo) {
		int cantidad = 0;
		for (DetallePrestamo detallePrestamo : listaDetallePrestamo) {
			if (detallePrestamo.cumpleTipo(tipo)) {
				cantidad += detallePrestamo.getCantidad();
			}
		}
		return cantidad;
	}

	/**
	 * Determina si el préstamo tiene el total en un rango determinado
	 * 
	 * @param valorInferior es el valor inferior
	 * @param valorSuperior es el valor superior
	 * @return true si está en ese rango
	 */
	public boolean tieneTotalEnRango(Double valorInferior, Double valorSuperior) {
		return getTotal() <= valorInferior && getTotal() >= valorSuperior;
	}

	/**
	 * Obtiene los libros que tienen un tipo de libro especificado
	 * 
	 * @param tipo es el tipo a comprarar
	 * @return una lista de libros (puede estar vacía)
	 */
	public List<Libro> obtenerLibrosTienenTipo(Tipo tipo) {
		List<Libro> listaLibrosTienenTipo = new ArrayList<Libro>();
		for (DetallePrestamo detallePrestamo : listaDetallePrestamo) {
			if (detallePrestamo.cumpleTipo(tipo)) {
				listaLibrosTienenTipo.add(detallePrestamo.getLibro());
			}
		}
		return listaLibrosTienenTipo;
	}

	/**
	 * Determina si un empleado tiene un tipo determinado
	 * 
	 * @param tipoEmpleado es el tipo a compraar
	 * @return true si se cumple
	 */
	public boolean empleadoTieneTipo(TipoEmpleado tipoEmpleado) {
		return getEmpleadoPrestamo().cumpleTipo(tipoEmpleado);
	}

	/**
	 * Verifica si un detalle de préstamo tiene una cantidad determinada de libros y
	 * si tiene un autor determinado
	 * 
	 * @param autor
	 * @param cantidad
	 * @return true si cumple las 2 condiciones
	 */
	public boolean verificarCantidadAutor(String autor, int cantidad) {
		for (DetallePrestamo detallePrestamo : listaDetallePrestamo) {
			if (detallePrestamo.cumpleAutor(autor) && detallePrestamo.verificarCant(cantidad)) {
				return true;
			}
		}
		return false;
	}

}
