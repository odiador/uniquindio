package co.edu.uniquindio.concesionariouq.model;

import java.io.Serializable;

public abstract class Persona implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected String id;
	protected String nombre;

	/**
	 * Es el constructor de la clase de {@link Persona}
	 * 
	 * @param id
	 * @param nombre
	 */
	public Persona(String id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}

	public abstract TipoPersona getTipoPersona();

	public boolean tieneId(String id) {
		return this.id.equals(id);
	}

	public boolean atributosLlenos() {
		return id != null && nombre != null && !id.isEmpty() && !nombre.isEmpty();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Persona other = (Persona) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("Persona [id=%s, nombre=%s]", id, nombre);
	}

}
