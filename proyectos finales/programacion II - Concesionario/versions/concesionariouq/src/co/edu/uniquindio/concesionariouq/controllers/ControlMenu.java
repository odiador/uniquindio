package co.edu.uniquindio.concesionariouq.controllers;

import co.edu.uniquindio.concesionariouq.model.OpcionMenu;
import co.edu.uniquindio.concesionariouq.model.Usuario;
import co.edu.uniquindio.concesionariouq.view.menu.PanelAgregar;
import co.edu.uniquindio.concesionariouq.view.principal.MenuPrincipal;
import javafx.scene.control.Label;

public class ControlMenu {

	public static void actualizarVista(MenuPrincipal menuPrincipal, Usuario usuario, String msg) {
		OpcionMenu valorOpcion = OpcionMenu.obtenerValorOpcion(msg);
		if (valorOpcion == null)
			return;
		switch (valorOpcion) {
		case AGREGAR:
			menuPrincipal.setCenter(new PanelAgregar());
			break;
		/*
		case AGREGAR_VEHICULO:
			((Stage) menuPrincipal.getScene().getWindow()).setTitle("Agregar Vehiculo | Concesionario UQ");
			menuPrincipal.setCenter(new PanelAgregarVehiculo());
			break; */
		default:
			menuPrincipal.setCenter(new Label("Coming soon"));
			break;
		}
	}

}
