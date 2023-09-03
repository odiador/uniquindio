package co.edu.uniquindio.biblioteca.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Biblioteca {

	// ATRIBUTOS
	private String nombre;
	private String direccion;
	private String telefono;
	private ArrayList<Estudiante> listaEstudiantes;
	private ArrayList<Prestamo> listaPrestamos;
	private ArrayList<Empleado> listaEmpleados;
	private ArrayList<Libro> listaLibros;

	/**
	 * Este es el metodo constructor de la clase biblioteca sin parámetros
	 */
	public Biblioteca() {

	}

	/**
	 * Este es el metodo constructor de la clase biblioteca
	 * 
	 * @param nombre
	 * @param direccion
	 * @param telefono
	 */
	public Biblioteca(String nombre, String direccion, String telefono) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.listaEmpleados = new ArrayList<Empleado>();
		this.listaEstudiantes = new ArrayList<Estudiante>();
		this.listaLibros = new ArrayList<Libro>();
		this.listaPrestamos = new ArrayList<Prestamo>();
	}

	/**
	 * Obtiene el nombre de la biblioteca
	 *
	 * @return nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Cambia el nombre de la biblioteca
	 * 
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Obtiene la lista de prestamos de la biblioteca
	 *
	 * @return listaPrestamos
	 */
	public ArrayList<Prestamo> getListaPrestamos() {
		return listaPrestamos;
	}

	/**
	 * Cambia la lista de prestamos de la biblioteca
	 *
	 * @param listaPrestamos
	 */
	public void setListaPrestamos(ArrayList<Prestamo> listaPrestamos) {
		this.listaPrestamos = listaPrestamos;
	}

	/**
	 * Obtiene la lista de empleados de la biblioteca
	 *
	 * @return listaEmpleados
	 */
	public ArrayList<Empleado> getListaEmpleados() {
		return listaEmpleados;
	}

	/**
	 * Cambia la lista de empleados de la biblioteca
	 *
	 * @param listaEmpleados
	 */
	public void setListaEmpleados(ArrayList<Empleado> listaEmpleados) {
		this.listaEmpleados = listaEmpleados;
	}

	/**
	 * Obtiene la lista de libros de la biblioteca
	 *
	 * @return listaLibros
	 */
	public ArrayList<Libro> getListaLibros() {
		return listaLibros;
	}

	/**
	 * Cambia la lista de libros de la biblioteca
	 * 
	 * @param listaLibros
	 */
	public void setListaLibros(ArrayList<Libro> listaLibros) {
		this.listaLibros = listaLibros;
	}

	/**
	 * Obtiene la direccion de la biblioteca
	 * 
	 * @return direccion
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * Cambia la direccion de la biblioteca
	 * 
	 * @param direccion
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * Obtiene el telefono de la biblioteca
	 *
	 * @return telefono
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * Cambia el telefono de la biblioteca
	 * 
	 * @param telefono
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	/**
	 * Obtiene la lista de estudiantes de la biblioteca
	 *
	 * @return listaEstudiantes
	 */
	public ArrayList<Estudiante> getListaEstudiantes() {
		return listaEstudiantes;
	}

	/**
	 * Cambia la lista de estudiantes de la biblioteca
	 *
	 * @param listaEstudiantes
	 */
	public void setListaEstudiantes(ArrayList<Estudiante> listaEstudiantes) {
		this.listaEstudiantes = listaEstudiantes;
	}

	/**
	 * Este metodo permite crear un estudiante
	 * 
	 * @param nombres
	 * @param apellidos
	 * @param edad
	 * @param programa
	 * @param estado
	 * @param identificacion
	 * @throws BibliotecaException
	 *
	 * @return mensaje
	 */

	public String crearEstudiante(String nombres, String apellidos, Integer edad, String programa, String estado,
			String identificacion) throws BibliotecaException {

		String mensaje = "El estudiante ha sido registrado";
		boolean estudianteEncontrado = verificarEstudiante(identificacion);
		if (estudianteEncontrado == true) {
			throw new BibliotecaException("El estudiante ya existe");
		} else {
			Estudiante nuevoEstudiante = new Estudiante(nombres, apellidos, edad, programa, estado, identificacion);
			listaEstudiantes.add(nuevoEstudiante);
		}
		return mensaje;
	}

	/**
	 * Obtener un estudiante
	 * 
	 * @param identificacion
	 * @return estudianteEncontrado
	 */

	public Estudiante obtenerEstudiante(String identificacion) {

		Estudiante estudianteEncontrado = null;

		for (Estudiante estudiante : listaEstudiantes) {
			if (estudiante.getIdentificacion().equals(identificacion)) {
				estudianteEncontrado = estudiante;
			}
		}
		return estudianteEncontrado;
	}

	/**
	 * Este metodo permite eliminar un estudiante
	 * 
	 * @param identificacion
	 */

	public void eliminarEstudiante(String identificacion) throws Exception {
		if (verificarEstudiante(identificacion) == false) {
			throw new Exception("El estudiante no esta registrado");
		} else {
			for (int i = 0; i < listaEstudiantes.size(); i++) {
				if (listaEstudiantes.get(i).getIdentificacion().equals(identificacion)) {
					listaEstudiantes.remove(i);
				}
			}
		}
	}

	public void eliminarEstudiante2(String identificacion) throws Exception {
		Estudiante estudianteEncontrado = obtenerEstudiante(identificacion);
		if (estudianteEncontrado == null) {
			throw new Exception("El estudiante no esta registrado");
		}
		listaEstudiantes.remove(estudianteEncontrado);
	}

	/**
	 * Este metodo permite actualizar un estudiante
	 *
	 * @param nombres
	 * @param apellidos
	 * @param identificacion
	 * @param edad
	 *
	 * @return El estudiante ha sido actualizado
	 */

	public String actualizarEstudiante(String nombres, String apellidos, String identificacion, Integer edad)
			throws Exception {
		Estudiante estudianteEncontrado = obtenerEstudiante(identificacion);
		if (estudianteEncontrado == null) {
			throw new Exception("El estudiante no esta registrado");
		}
		estudianteEncontrado.setNombres(nombres);
		estudianteEncontrado.setApellidos(apellidos);

		estudianteEncontrado.setEdadEstudiante(edad);

		return " El estudiante ha sido actualizado ";
	}

	/**
	 * Este metodo permite ordenar libros por ISBN
	 */

	public void ordenarLibrosPorISBN() {
		Collections.sort(listaEstudiantes, new Comparator<Estudiante>() {
			@Override
			public int compare(Estudiante estudiante1, Estudiante estudiante2) {
				return estudiante1.getIdentificacion().compareTo(estudiante2.getIdentificacion());
			}
		});
	}

	/**
	 * Verificar un estudiante
	 *
	 * @param identificacion
	 * @return verificado
	 */

	private boolean verificarEstudiante(String identificacion) {
		boolean verificado = false;
		for (Estudiante estudianteaux : listaEstudiantes) {
			if (estudianteaux.getIdentificacion().equals(identificacion)) {
				verificado = true;
				return verificado;
			}
		}
		return verificado;
	}

	/**
	 * Obtiene a los estudiantes que sean mayores de edad
	 * 
	 * @param edad
	 * @return listaEstudiantesEncontrados
	 */
	public ArrayList<Estudiante> obtenerEstudiantesEdadMayor(int edad) {
		ArrayList<Estudiante> listaEstudiantesEncontrados = new ArrayList<Estudiante>();

		for (Estudiante estudiante : listaEstudiantes) {
			if (estudiante.verificarEdad(edad)) {
				listaEstudiantesEncontrados.add(estudiante);
			}
		}
		return listaEstudiantesEncontrados;
	}

	/**
	 * Obtiene los prestamos que tienen un autor y valor determinados
	 *
	 * @param autor
	 * @param valor
	 *
	 * @return prestamosEncontrados
	 */
	public ArrayList<Prestamo> obtenerPrestamosTotalAutor(String autor, double valor) {
		ArrayList<Prestamo> prestamosEncontrados = new ArrayList<Prestamo>();

		for (Prestamo prestamo : listaPrestamos) {
			if (prestamo.verificarTotalAutor(autor, valor) == true) {
				prestamosEncontrados.add(prestamo);
			}
		}
		return prestamosEncontrados;
	}

	// -----------------------------------------------------------------------------------------------------
	/**
	 * 
	 *
	 * @return
	 * @throws BibliotecaException
	 */
	public String obtenerEmpleadoPrestamoLibroIsbn(String isbn) throws BibliotecaException {
		String empleadoEncontrado = "";

		for (Prestamo prestamo : listaPrestamos) {
			if (prestamo.cumpleIsbn(isbn)) {
				empleadoEncontrado = prestamo.getEmpleadoPrestamo().toString();
				return empleadoEncontrado;
			}
		}

		throw new BibliotecaException("NO existe un prestamo para el isbn");
	}

	// punto 2

	/**
	 * 
	 * @param titulo
	 * @param limiteInferior
	 * @param limiteSuperior
	 * @param aniosExperiencia
	 * @return
	 */
	public Prestamo devolverPrestamoLibro(String titulo, int limiteInferior, int limiteSuperior, int aniosExperiencia) {
		for (Prestamo prestamo : listaPrestamos) {
			if (prestamo.cumpleLibro(titulo, limiteInferior, limiteSuperior, aniosExperiencia)) {
				return prestamo;
			}
		}
		return null;
	}

	// ------------------------------------------------------------------------------------------------
	// Consultar cual es el tipo de libro que ha sido prestado
	// mas veces en la biblioteca, segun sus unidades prestadas.

	/**
	 * Obtiene el tipo de libro mas vendido
	 *
	 * @return tipoMasPrestado
	 */
	public Tipo obtenerTipoMasPrestado() {

		Tipo tipoMasPrestado = Tipo.BIOGRAFIA;

		int totalPrestadoBiografia = obtenerTotalPrestado(Tipo.BIOGRAFIA);
		int totalPrestadoCientifico = obtenerTotalPrestado(Tipo.CIENTIFICO);
		int totalPrestadoMonografia = obtenerTotalPrestado(Tipo.MONOGRAFIA);

		if (totalPrestadoBiografia > totalPrestadoCientifico && totalPrestadoBiografia > totalPrestadoMonografia) {
			tipoMasPrestado = Tipo.BIOGRAFIA;
		} else {
			if (totalPrestadoCientifico > totalPrestadoMonografia) {
				tipoMasPrestado = Tipo.CIENTIFICO;
			} else {
				tipoMasPrestado = Tipo.MONOGRAFIA;
			}
		}

		return tipoMasPrestado;
	}

	/**
	 * Obtiene el total de libros prestados del tipo necesitado
	 *
	 * @param tipo
	 * @return cantidad
	 */
	private int obtenerTotalPrestado(Tipo tipo) {

		int cantidad = 0;
		for (Prestamo prestamo : listaPrestamos) {
			cantidad += prestamo.obtenerCantidadTipo(tipo);
		}

		return cantidad;
	}

	@Override
	public String toString() {
		return "Biblioteca [nombre=" + nombre + ", direccion=" + direccion + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((telefono == null) ? 0 : telefono.hashCode());
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
		Biblioteca other = (Biblioteca) obj;
		if (telefono == null) {
			if (other.telefono != null)
				return false;
		} else if (!telefono.equals(other.telefono))
			return false;
		return true;
	}

	/*
	 * Parcial 1 -> punto N°1: 1.25 Devolver los Libros de tipo Científico que han
	 * sido prestados por un estudiante dado la identificación del estudiante y el
	 * programa, estos préstamos deben tener un total dentro del rango mayor a 10000
	 * y menor a 200000. (1.0).
	 */

	/**
	 * Obtiene los libros de un tipo determinado que hayan sido prestados por un
	 * estudiante que tenga una identificadion {@code id} y que esté en un programa
	 * determinado, y que además que los préstamos del estudiante esté en un rango
	 * de 2 valores
	 * 
	 * @param id
	 * @param programa
	 * @param tipo
	 * @param total
	 * @param valorInferior
	 * @param valorSuperior
	 * @return
	 */
	public List<Libro> obtenerLibrosdeTipoDePrestamoEnRangoAPartirDelEstudiante(String id, String programa, Tipo tipo,
			Double total, Double valorInferior, Double valorSuperior) {
		for (Estudiante estudiante : listaEstudiantes) {
			if (estudiante.cumpleIdPrograma(id, programa)) {
				return estudiante.obtenerLibrosTipoconTotalEnRango(tipo, valorInferior, valorSuperior);
			}
		}
		return null;
	}

	/*
	 * Devolver la lista de préstamos "Biblioteca"
	 * donde el empleado tenga en su nombre mínimo tres vocales y
	 * "contar vocales del nombre"
	 * el préstamo tenga al menos 10 libros del autor “Gabriel Garcia Marquez”.
	 * "DetallePrestamo"
	 */

	public List<Prestamo> obtenerPrestamosNombreVocal(String nombre, int cantidadVocales,
			int cantidad, String autor) {
		List<Prestamo> listaEmpleadosCondicion = new ArrayList<Prestamo>();
		for (Empleado empleado : listaEmpleados) {
			List<Prestamo> listaResEmpleado = empleado.obtenerListaPrestamosVocalesAutorCantidad(cantidadVocales, autor,
					cantidad);

			if (listaResEmpleado.size() != 0) {
				for (Prestamo prestamo : listaResEmpleado) {
					listaEmpleadosCondicion.add(prestamo);
				}
			}

		}
		return listaEmpleadosCondicion;

	}

	/*
	 * -----------------------PUNTO 3-----------------------
	 * Obtener los estudiantes que hayan sido atendidos por un empleado de Tipo
	 * “Tecnico”(usar enumeración los tipos son auxiliar, tecnico y profesional
	 */
	/**
	 * Obtiene los estudiantes que hayan sido atendidos por algún empleado de tipo
	 * técnico
	 * 
	 * @param tipoEmpleado es el tipo a comprarar
	 * @return la lista de estudiantes que tienen esta condición
	 */
	public List<Estudiante> obtenerEstudianteDeTipo(TipoEmpleado tipoEmpleado) {
		List<Estudiante> listaAtendidosPorTipo = new ArrayList<Estudiante>();
		for (Estudiante estudiante : listaEstudiantes) {
			if (estudiante.fueAtendidoPorTipo(tipoEmpleado)) {
				listaAtendidosPorTipo.add(estudiante);
			}
		}
		return listaAtendidosPorTipo;
	}

	/**
	 * Busca un empleado a partir del nombre, retorna un null si no se encuentra
	 * 
	 * @param nombre
	 * @return
	 */
	public Empleado buscarEmpleado(String nombre) {
		return getListaEmpleados().stream().filter(empleado -> empleado.getNombre().equals(nombre)).findFirst()
				.orElse(null);
	}

	/**
	 * Crea un empleado
	 * 
	 * @param nombre
	 * @param salario
	 * @param cargo
	 * @param tipo
	 * @return
	 * @throws BibliotecaException
	 */
	public String crearEmpleado(String nombre, Double salario, String cargo, TipoEmpleado tipo)
			throws BibliotecaException {

		String mensaje = "El empleado ha sido registrado";
		if (verificarEmpleado(nombre)) {
			throw new BibliotecaException("El empleado ya existe");
		}
		getListaEmpleados().add(new Empleado(nombre, salario, cargo, tipo));
		return mensaje;
	}

	public boolean verificarEmpleado(String nombre) {
		return buscarEmpleado(nombre) != null;
	}

}
