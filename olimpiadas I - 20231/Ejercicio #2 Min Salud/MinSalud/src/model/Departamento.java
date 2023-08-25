package model;

import java.util.ArrayList;
import java.util.List;

public class Departamento {
	private final List<Ciudad> listaCiudades = new ArrayList<Ciudad>();

	public Departamento(String nombre) {
	}

	public List<Ciudad> getListaCiudades() {
		return listaCiudades;
	}

}
