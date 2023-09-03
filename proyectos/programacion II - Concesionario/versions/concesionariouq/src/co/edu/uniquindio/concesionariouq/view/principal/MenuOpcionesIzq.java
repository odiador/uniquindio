package co.edu.uniquindio.concesionariouq.view.principal;

import co.edu.uniquindio.concesionariouq.model.OpcionMenu;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class MenuOpcionesIzq extends VBox {

	private MenuComunicationListener comunicacion;

	public MenuOpcionesIzq(MenuComunicationListener comunicacion) {
		this.comunicacion = comunicacion;
		initComp();
	}

	private void initComp() {
		setId("menu-opciones-izq");
		OpcionMenu[] opciones = OpcionMenu.values();
		for (int i = 0; i < opciones.length; i++) {
			Label boton = new Label(opciones[i].getText());
			boton.getStyleClass().add("boton-menu");
			this.getChildren().add(boton);
			boton.setOnMouseReleased(evento -> {
				comunicacion.botonIzqPresionado(((Label) evento.getSource()).getText());
			});
		}

	}

}
