package model;

import java.util.ArrayList;
import java.util.List;

public class Pais {
	private String nombre;
	private final List<Departamento> listaDepartamentos = new ArrayList<Departamento>();

	public Pais(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Departamento> getListaDepartamentos() {
		return listaDepartamentos;
	}

	public int obtenerCantidadNinos() {
		int cant = 0;
		for (int i = 0; i < getListaDepartamentos().size(); i++)
			cant += getListaDepartamentos().get(i).obtenerCantidadNinos();
		return cant;
	}

	public boolean addNinoToCityOfDepartment(String nombreDepto, String nombreCiudad, String identificacion,
			String nombre, int sexo) {
		Departamento deptoEncontrado = buscarDepto(nombreDepto);
		if (deptoEncontrado == null)
			return false;
		return deptoEncontrado.addNinoToCiudad(nombreCiudad, identificacion, nombre, sexo);
	}

	public boolean addNinoToCityOfDepartment(String nombreDepto, String nombreCiudad, String identificacion,
			String nombre, int sexo, boolean estaVacunado) {
		Departamento deptoEncontrado = buscarDepto(nombreDepto);
		if (deptoEncontrado == null)
			return false;
		return deptoEncontrado.addNinoToCiudad(nombreCiudad, identificacion, nombre, sexo, estaVacunado);
	}

	public boolean addDepto(String nombre) {
		if (validarDepto(nombre))
			return false;
		return getListaDepartamentos().add(new Departamento(nombre));
	}

	public boolean validarDepto(String nombre) {
		return buscarDepto(nombre) != null;
	}

	public Departamento buscarDepto(String nombre) {
		for (int i = 0; i < getListaDepartamentos().size(); i++) {
			if (getListaDepartamentos().get(i).getNombre().equals(nombre))
				return getListaDepartamentos().get(i);
		}
		return null;
	}

}
