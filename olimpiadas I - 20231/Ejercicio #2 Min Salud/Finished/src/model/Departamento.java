package model;

import java.util.ArrayList;
import java.util.List;

public class Departamento {
	private final List<Ciudad> listaCiudades = new ArrayList<Ciudad>();
	private String nombre;

	public Departamento(String nombre) {
		this.nombre = nombre;
	}

	public int obtenerCantidadNinos() {
		int cant = 0;
		for (int i = 0; i < listaCiudades.size(); i++)
			cant += listaCiudades.get(i).obtenerCantidadNinos();
		return cant;
	}

	public int obtenerCantidadCiudadesVacunadas() {
		int cant = 0;
		for (int i = 0; i < listaCiudades.size(); i++)
			if (listaCiudades.get(i).seVacuno())
				cant++;
		return cant;
	}

	public List<Ciudad> getListaCiudades() {
		return listaCiudades;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean addNinoToCiudad(String nombreCiudad, String identificacion, String nombre, int sexo,
			boolean estaVacunado) {
		Ciudad ciudad = buscarCiudad(nombre);
		if (ciudad == null)
			return false;

		return ciudad.addNino(identificacion, nombre, sexo, estaVacunado);
	}

	public boolean addNinoToCiudad(String nombreCiudad, String identificacion, String nombre, int sexo) {
		Ciudad ciudad = buscarCiudad(nombre);
		if (ciudad == null)
			return false;

		return ciudad.addNino(identificacion, nombre, sexo);
	}

	public boolean addCiudad(String nombre) {
		if (validarCiudad(nombre))
			return false;
		return getListaCiudades().add(new Ciudad(nombre));
	}

	public boolean validarCiudad(String nombre) {
		return buscarCiudad(nombre) != null;
	}

	public Ciudad buscarCiudad(String nombre) {
		for (int i = 0; i < getListaCiudades().size(); i++) {
			if (getListaCiudades().get(i).getNombre().equals(nombre))
				return getListaCiudades().get(i);
		}
		return null;
	}

}
