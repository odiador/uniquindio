package model;

import java.util.ArrayList;
import java.util.List;

public class Ciudad {
	private final List<Nino> listaNinos = new ArrayList<Nino>();
	private String nombre;

	public Ciudad(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Nino> getListaNinos() {
		return listaNinos;
	}

	/**
	 * Agrega un niño a partir de cada uno de sus atributos
	 * 
	 * @param identificacion
	 * @param nombre
	 * @param sexo
	 * @param estaVacunado
	 * @return
	 */
	public boolean addNino(String identificacion, String nombre, int sexo, boolean estaVacunado) {
		Nino nino = new Nino(identificacion, nombre, sexo, estaVacunado);
		if (sexo != 1 && sexo != 2)
			return false;

		return getListaNinos().add(nino);
	}

	/**
	 * Busca un niño dependiendo de su identificacion, retorna un null en caso de
	 * que no se encuentre
	 * 
	 * @param identificacion
	 * @return
	 */
	public Nino buscarNino(String identificacion) {
		Nino nino = null;
		for (int i = 0; i < listaNinos.size() && nino == null; i++) {
			Nino cadaNino = listaNinos.get(i);
			if (cadaNino.getIdentificacion().equals(identificacion))
				nino = cadaNino;
		}
		return nino;
	}

	public boolean validarSexo(int sexo) {
		return sexo == Nino.SEXO_FEMENINO || sexo == Nino.SEXO_MASCULINO;
	}

	/**
	 * Agrega un niño (sin vacunar) a partir de cada uno de sus atributos
	 * 
	 * @param identificacion
	 * @param nombre
	 * @param sexo
	 * @return
	 */
	public boolean addNino(String identificacion, String nombre, int sexo) {
		Nino nino = new Nino(identificacion, nombre, sexo);
		if (sexo != 1 && sexo != 2)
			return false;

		return getListaNinos().add(nino);
	}

	/**
	 * Obtiene la cantidad de niños de la ciudad
	 * 
	 * @return
	 */
	public int obtenerCantidadNinos() {
		return getListaNinos().size();
	}

	/**
	 * Obtiene la cantidad de niños vacunados de la ciudad
	 * 
	 * @return
	 */
	public int obtenerCantidadNinosVacunados() {
		int cant = 0;
		for (Nino nino : listaNinos)
			if (nino.isEstaVacunado())
				cant++;
		return cant;
	}

	/**
	 * Obtiene la cantidad de niños sin vacunar en la ciudad
	 * 
	 * @return
	 */
	public int obtenerCantidadNinosSinVacunar() {
		int cant = 0;
		for (int i = 0; i < getListaNinos().size(); i++) {
			Nino nino = getListaNinos().get(i);
			if (!nino.isEstaVacunado())
				cant++;
		}
		return cant;
	}

	/**
	 * Obtiene la cantidad de niños de sexo masculino de la ciudad
	 * 
	 * @return
	 */
	public int obtenerCantidadNinosSexoM() {
		int cant = 0;
		for (int i = 0; i < getListaNinos().size(); i++) {
			Nino nino = getListaNinos().get(i);
			if (nino.getSexo() == Nino.SEXO_MASCULINO)
				cant++;
		}
		return cant;
	}

	/**
	 * Obtiene la cantidad de niños de sexo masculino de la ciudad
	 * 
	 * @return
	 */
	public int obtenerCantidadNinosSexoF() {
		int cant = 0;
		for (int i = 0; i < getListaNinos().size(); i++) {
			Nino nino = getListaNinos().get(i);
			if (nino.getSexo() == Nino.SEXO_FEMENINO)
				cant++;
		}
		return cant;
	}
}
