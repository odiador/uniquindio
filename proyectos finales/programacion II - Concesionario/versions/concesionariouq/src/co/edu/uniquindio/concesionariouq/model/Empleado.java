package co.edu.uniquindio.concesionariouq.model;

import java.util.ArrayList;

public class Empleado extends Usuario {

	private boolean estaActivo = true;

	/**
	 * Este es el constructor principal de la clase
	 * 
	 * @param nombre
	 * @param contrasena
	 * @param email
	 */
	public Empleado(String id, String nombre, String contrasena, String email) {
		super(id, nombre, contrasena, email);
	}

	@Override
	public OpcionMenu[] obtenerOpcionesDisponibles() {
		ArrayList<OpcionMenu> listaAux = new ArrayList<OpcionMenu>();
		listaAux.add(OpcionMenu.COMPRAR_VEHICULO);
		listaAux.add(OpcionMenu.VENDER_VEHICULO);
		listaAux.add(OpcionMenu.CAMBIAR_CONTRASENA);
		listaAux.add(OpcionMenu.ACTUALIZAR_INFO);
		listaAux.add(OpcionMenu.ACERCA_DE);
		return (OpcionMenu[]) listaAux.toArray(new OpcionMenu[listaAux.size()]);
	}

	public boolean isActivo() {
		return estaActivo;
	}

	public void setIsActivo(boolean estaActivo) {
		this.estaActivo = estaActivo;
	}
}