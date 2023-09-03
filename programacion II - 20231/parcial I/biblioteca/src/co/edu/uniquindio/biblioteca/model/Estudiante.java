package co.edu.uniquindio.biblioteca.model;

import java.util.ArrayList;
import java.util.List;

public class Estudiante {

	// Atributos
	private String nombres;
	private String apellidos;
	private Integer edadEstudiante;
	private String programa;
	private String estado;
	private String identificacion;
	private ArrayList<Prestamo> listaPrestamos;

	public Estudiante() {
	}

	/**
	 * 
	 * @param nombres
	 * @param apellidos
	 * @param edad
	 * @param programa
	 * @param estado
	 * @param identificacion
	 */
	public Estudiante(String nombres, String apellidos, Integer edad, String programa, String estado,
			String identificacion) {
		super();
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.edadEstudiante = edad;
		this.programa = programa;
		this.estado = estado;
		this.identificacion = identificacion;
		this.listaPrestamos = new ArrayList<Prestamo>();
	}

	/**
	 * 
	 * @return
	 */
	public String getNombres() {
		return nombres;
	}

	/**
	 * 
	 * @return
	 */
	public ArrayList<Prestamo> getListaPrestamos() {
		return listaPrestamos;
	}

	/**
	 * 
	 * @param listaPrestamos
	 */
	public void setListaPrestamos(ArrayList<Prestamo> listaPrestamos) {
		this.listaPrestamos = listaPrestamos;
	}

	/**
	 * 
	 * @param nombres
	 */
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	/**
	 * 
	 * @return
	 */
	public String getApellidos() {
		return apellidos;
	}

	/**
	 * 
	 * @param apellidos
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	/**
	 * 
	 * @return
	 */
	public Integer getEdadEstudiante() {
		return edadEstudiante;
	}

	/**
	 * 
	 * @param edad
	 */
	public void setEdadEstudiante(Integer edad) {
		this.edadEstudiante = edad;
	}

	/**
	 * 
	 * @return
	 */
	public String getPrograma() {
		return programa;
	}

	/**
	 * 
	 * @param programa
	 */
	public void setPrograma(String programa) {
		this.programa = programa;
	}

	/**
	 * 
	 * @return
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * 
	 * @param estado
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * 
	 * @return
	 */
	public String getIdentificacion() {
		return identificacion;
	}

	/**
	 * 
	 * @param identificacion
	 */
	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	@Override
	public String toString() {
		return "Estudiante [nombres=" + nombres + ", apellidos=" + apellidos + ", edad=" + edadEstudiante
				+ ", programa="
				+ programa + ", estado=" + estado + ", identificacion=" + identificacion + "]";
	}

	/**
	 * 
	 * @param edad
	 * @return
	 */
	public boolean verificarEdad(int edad) {
		return getEdadEstudiante() > edad;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((identificacion == null) ? 0 : identificacion.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Estudiante other = (Estudiante) obj;
		if (identificacion == null) {
			if (other.identificacion != null)
				return false;
		} else if (!identificacion.equals(other.identificacion))
			return false;
		return true;
	}

	/**
	 * Verifica si un estudiante tiene una identificación determinada
	 * 
	 * @param id es la identificacion
	 * @return true si son iguales
	 */
	public boolean cumpleId(String id) {
		return getIdentificacion().equals(id);
	}

	/**
	 * Verifica si un estudiante está en un progrsma determinado
	 * 
	 * @param programa es el programa
	 * @return true si son iguales
	 */
	public boolean cumplePrograma(String programa) {
		return getPrograma().equals(programa);
	}

	/**
	 * Verifica si un estudiante está en un progrsma determinado y tiene una
	 * identificación especificada
	 * 
	 * @param id       es la identificación
	 * @param programa es el programa
	 * @return true si cumple ambas condiciones
	 * @see {@link #cumpleId(String)}
	 *      <li>{@link #cumplePrograma(String)}
	 */
	public boolean cumpleIdPrograma(String id, String programa) {
		return cumpleId(id) && cumplePrograma(programa);
	}

	/**
	 * Obtiene los libros que tienen un tipo geterminado y total en un rango
	 * determinado
	 * 
	 * @param tipo          es el tipo del libro a buscar
	 * @param valorInferior es el valor inferior del rango
	 * @param valorSuperior es el valor superior del rango
	 * @return la lsita de libros que cumplen con estas condiciones
	 */
	public List<Libro> obtenerLibrosTipoconTotalEnRango(Tipo tipo, Double valorInferior, Double valorSuperior) {
		List<Libro> listaLibrosTipoConTotal = new ArrayList<Libro>();
		for (Prestamo prestamo : listaPrestamos) {
			List<Libro> listaLibrosTipo = prestamo.obtenerLibrosTienenTipo(tipo);
			if (prestamo.tieneTotalEnRango(valorInferior, valorSuperior) && listaLibrosTipo.size() == 0) {
				for (Libro libro : listaLibrosTipo) {
					listaLibrosTipoConTotal.add(libro);
				}
			}
		}
		return listaLibrosTipoConTotal;
	}

	public boolean fueAtendidoPorTipo(TipoEmpleado tipoEmpleado) {
		for (Prestamo prestamo : listaPrestamos) {
			if (prestamo.empleadoTieneTipo(tipoEmpleado)) {
				return true;
			}
		}
		return false;
	}
}
