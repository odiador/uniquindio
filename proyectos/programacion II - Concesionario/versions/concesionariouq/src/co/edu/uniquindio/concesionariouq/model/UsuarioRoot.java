package co.edu.uniquindio.concesionariouq.model;

public class UsuarioRoot extends Usuario {

	public UsuarioRoot(String id, String nombre, String contrasena, String email) {
		super(id, nombre, contrasena, email);
	}

	public static UsuarioRoot adminPerdomo() {
		return new UsuarioRoot("12313", "Juan Manuel Perdomo", "1234", "perdomo@gmail.com");
	}

	public static UsuarioRoot adminAmador() {
		return new UsuarioRoot("12313", "Juan Manuel Amador", "1234", "amador@gmail.com");
	}

	@Override
	public OpcionMenu[] obtenerOpcionesDisponibles() {
		return OpcionMenu.values();
	}

}
