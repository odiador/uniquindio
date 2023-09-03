package co.edu.uniquindio.biblioteca.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.JOptionPane;

import org.junit.experimental.theories.FromDataPoints;

public class Biblioteca {

	
	//ATRIBUTOS
	private String nombre;
	private String direccion;
	private String telefono;
	private ArrayList<Estudiante> listaEstudiantes;
	private ArrayList<Prestamo> listaPrestamos;
	private ArrayList<Empleado> listaEmpleados;
	private ArrayList<Libro> listaLibros;
	
	public Biblioteca() {
	
	}

	/**
	 * Este es el metodo constructor de la clase biblioteca
	 * @param nombre
	 * @param direccion
	 * @param telefono
	 */
	

	public String getNombre() {
		return nombre;
	}

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

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Prestamo> getListaPrestamos() {
		return listaPrestamos;
	}

	public void setListaPrestamos(ArrayList<Prestamo> listaPrestamos) {
		this.listaPrestamos = listaPrestamos;
	}

	public ArrayList<Empleado> getListaEmpleados() {
		return listaEmpleados;
	}

	public void setListaEmpleados(ArrayList<Empleado> listaEmpleados) {
		this.listaEmpleados = listaEmpleados;
	}

	public ArrayList<Libro> getListaLibros() {
		return listaLibros;
	}

	public void setListaLibros(ArrayList<Libro> listaLibros) {
		this.listaLibros = listaLibros;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public ArrayList<Estudiante> getListaEstudiantes() {
		return listaEstudiantes;
	}

	public void setListaEstudiantes(ArrayList<Estudiante> listaEstudiantes) {
		this.listaEstudiantes = listaEstudiantes;
	}

	@Override
	public String toString() {
		return "Biblioteca [nombre=" + nombre + ", direccion=" + direccion + "]";
	}

	/**
	 * Este metodo permite crear un estudiante
	 * @param nombres
	 * @param apellidos
	 * @param edad
	 * @param programa
	 * @param estado
	 * @param identificacion
	 * @throws Exception 
	 */
	public String crearEstudiante(String nombres, String apellidos, Integer edad, String programa, String estado,
			String identificacion) throws Exception{
		
		String mensaje = "El estudiante ha sido registrado";
		boolean estudianteEncontrado = verificarEstudiante(identificacion);
		if( estudianteEncontrado == true){
			throw new Exception("El estudiante ya existe");
		}else{
			Estudiante nuevoEstudiante = new Estudiante(nombres, apellidos, edad, programa, estado, identificacion);
			listaEstudiantes.add(nuevoEstudiante);
		}
		return mensaje;
	}

	/**
	 * Obtener un estudiante
	 * @param identificacion
	 * @return
	 */
	public Estudiante obtenerEstudiante (String identificacion){
		
		Estudiante estudianteEncontrado = null;
		
		for (Estudiante estudiante : listaEstudiantes) {
			if(estudiante.getIdentificacion().equals(identificacion)){
				estudianteEncontrado = estudiante;
			}
		}
		return estudianteEncontrado;
	}
	
	public void eliminarEstudiante(String identificacion) throws Exception
	{
		if(verificarEstudiante(identificacion)==false)
		{
			throw new Exception("El estudiante no esta registrado");
		}
		else
		{
			for(int i=0; i<listaEstudiantes.size();i++)
			{
				if(listaEstudiantes.get(i).getIdentificacion().equals(identificacion))
				{
					listaEstudiantes.remove(i);
				}
			}
		}
	}
	
	
	public void eliminarEstudiante2(String identificacion) throws Exception
	{
		Estudiante estudianteEncontrado = obtenerEstudiante(identificacion);
		if(estudianteEncontrado == null){
			throw new Exception("El estudiante no esta registrado");
		}
		listaEstudiantes.remove(estudianteEncontrado);
	}
	public String actualizarEstudiante(String nombres , String apellidos , String identificacion, Integer edad) throws Exception{
		Estudiante estudianteEncontrado = obtenerEstudiante(identificacion);
		if(estudianteEncontrado == null){
			throw new Exception("El estudiante no esta registrado");
		}
       estudianteEncontrado.setNombres(nombres);
       estudianteEncontrado.setApellidos(apellidos);
     
       estudianteEncontrado.setEdadEstudiante(edad);
       
       return " El estudiante ha sido actualizado " ;
	}
	
	
	public void ordenarLibrosPorISBN() {
        Collections.sort(listaEstudiantes, new Comparator<Estudiante>() {
            @Override
            public int compare(Estudiante estudiante1, Estudiante estudiante2) {
                return estudiante1.getIdentificacion().compareTo(estudiante2.getIdentificacion());
            }
        });
    }
	
	
	
	/**
	 * 
	 * @param identificacion
	 * @return
	 */
	private boolean verificarEstudiante(String identificacion) {
		boolean verificado = false;		
		for (Estudiante estudianteaux : listaEstudiantes) {
			if(estudianteaux.getIdentificacion().equals(identificacion)){
				verificado = true;
				return verificado;
			}
		}
		return verificado;
	}
	
	public ArrayList<Estudiante> obtenerEstudiantesEdadMayor (int edad){
		ArrayList<Estudiante> listaEstudiantesEncontrados = new ArrayList<Estudiante>();
		
		for (Estudiante estudiante : listaEstudiantes) {
			if(estudiante.verificarEdad(edad)){
				listaEstudiantesEncontrados.add(estudiante);
			}
		}
		return listaEstudiantesEncontrados;
	}
	
	/**
	 * 
	 * @param autor
	 * @param valor
	 * @return
	 */
	public ArrayList<Prestamo> obtenerPrestamosTotalAutor (String autor, double valor){
		ArrayList<Prestamo> prestamosEncontrados = new ArrayList<Prestamo>();
		
		for (Prestamo prestamo : listaPrestamos) {
			if(prestamo.verificarTotalAutor(autor,valor) == true){
				prestamosEncontrados.add(prestamo);
			}
		}
		return prestamosEncontrados;
	}
	//-----------------------------------------------------------------------------------------------------	
	/**
	 * 
	 * @return
	 * @throws PrestamoException 
	 */
	public String obtenerEmpleadoPrestamoLibroIsbn(String isbn) throws PrestamoException{
		String empleadoEncontrado = "";
		
		for (Prestamo prestamo : listaPrestamos) {
			if(prestamo.cumpleIsbn(isbn)){
				empleadoEncontrado = prestamo.getEmpleadoPrestamo().toString();
				return empleadoEncontrado;
			}
		}
		
		throw new PrestamoException("NO exuste un prestamo para el isbn");
	}
	
	//punto 2
	
	public Prestamo devolverPrestamoLibro(String titulo,int limiteInferior,int limiteSuperior,int aniosExperiencia){
		
		Prestamo prestamoEncontrado = null;
		for (Prestamo prestamo : listaPrestamos) {
			if(prestamo.cumpleLibro(titulo,limiteInferior,limiteSuperior,aniosExperiencia)){
				prestamoEncontrado = prestamo;
				return prestamoEncontrado;
			}
		}
		return prestamoEncontrado;
	}
	
	//Consultar cual es el tipo de libro que ha sido prestado 
	//más veces en la biblioteca, según sus unidades prestadas. (1.0).

	public Tipo obtenerTipoMasPrestado(){
		
		Tipo tipoMasPrestado = Tipo.BIOGRAFIA;

		int totalPrestadoBiografia = obtenerTotalPrestado(Tipo.BIOGRAFIA);
		int totalPrestadoCientifico = obtenerTotalPrestado(Tipo.Cientifico);
		int totalPrestadoMonografia = obtenerTotalPrestado(Tipo.MONOGRAFIA);

		if (totalPrestadoBiografia > totalPrestadoCientifico && totalPrestadoBiografia > totalPrestadoMonografia) {
			tipoMasPrestado = Tipo.BIOGRAFIA;
		} else {
			if (totalPrestadoCientifico > totalPrestadoMonografia) {
				tipoMasPrestado = Tipo.Cientifico;
			} else {
				tipoMasPrestado = Tipo.MONOGRAFIA;
			}
		}

		return tipoMasPrestado;
	}

	private int obtenerTotalPrestado(Tipo tipo) {
		
		int cantidad = 0;
		for (Prestamo prestamo : listaPrestamos) {
			cantidad += prestamo.obtenerCantidadTipo(tipo);
		}
		
		return cantidad;
	}
	
	
	
	
	
	
	
	
	
	
}
