package co.edu.uniquindio.concesionariouq.model;

//ATRIBUTOS
public abstract class Usuario {
	private final String id;
	private String nombre;
	private String contrasena;
	private String email;

	/**
	 * Este es el metodo constructor de la clase usuario
	 * 
	 * @param id
	 * @param nombre
	 * @param contrasena
	 * @param email
	 */
	public Usuario(String id,String nombre, String contrasena, String email) {
		this.id = id;
		this.nombre = nombre;
		this.contrasena = contrasena;
		this.setEmail(email);
	}

	/**
	 * Este metodo obtiene el nombre del usuario
	 * 
	 * @return nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Este metodo cambia el nombre del usuario
	 * 
	 * @param nombre
	 */
	public void setNombre(final String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Este metodo obtiene las opciones disponible del usuario
	 * 
	 * @return
	 */
	public abstract OpcionMenu[] obtenerOpcionesDisponibles();

	/**
	 * Obtiene la contraseña del usuario
	 * 
	 * @return contrasena
	 */
	public String getContrasena() {
		return contrasena;
	}

	/**
	 * Cambia la contraseña del usuario
	 * 
	 * @param contrasena
	 */
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getId() {
		return id;
	}

}