package tallercolas;

public class Persona {
	private String nombre, cedula;

	public String getNombre() {
		return nombre;
	}

	public String getCedula() {
		return cedula;
	}

	public Persona(String nombre, String cedula) {
		this.nombre = nombre;
		this.cedula = cedula;
	}

	@Override
	public String toString() {
		return "P [" + nombre + "]";
	}

}
