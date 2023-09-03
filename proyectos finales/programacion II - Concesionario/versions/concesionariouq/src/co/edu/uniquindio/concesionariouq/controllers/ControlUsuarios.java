package co.edu.uniquindio.concesionariouq.controllers;

import co.edu.uniquindio.concesionariouq.util.Boton;
import co.edu.uniquindio.concesionariouq.util.PanelConVolver;
import co.edu.uniquindio.concesionariouq.view.menu.PanelAgregarAdmin;
import co.edu.uniquindio.concesionariouq.view.menu.PanelAgregarCliente;
import co.edu.uniquindio.concesionariouq.view.menu.PanelAgregarEmpleado;
import co.edu.uniquindio.concesionariouq.view.menu.PanelAgregarUsuario;
import co.edu.uniquindio.concesionariouq.view.menu.TipoUsuario;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

public class ControlUsuarios {
	public static void irAgregarUsuario(PanelAgregarUsuario panelAgregarUsuario, String opcionTipoUsuario,
			EventHandler<? super MouseEvent> eventoVolver) {
		TipoUsuario tipoUsuario = TipoUsuario.obtenerValorTipo(opcionTipoUsuario);
		if (tipoUsuario == null) {
			new Alert(AlertType.WARNING, "No se ha encontrado la opcion").show();
			panelAgregarUsuario.initComponents();
			return;
		}

		PanelConVolver panelConVolver;
		switch (tipoUsuario) {
		case CLIENTE:
			panelConVolver = new PanelAgregarCliente();
			break;
		case EMPLEADO:
			panelConVolver = new PanelAgregarEmpleado();
			break;
		case ADMIN:
			panelConVolver = new PanelAgregarAdmin();
			break;

		default:
			String tipo = tipoUsuario == null ? "?" : tipoUsuario.getText();
			new Alert(AlertType.WARNING, "No se ha implementado la opcion " + tipo).show();
			return;
		}

		((Stage) panelAgregarUsuario.getScene().getWindow())
				.setTitle("Agregación de " + opcionTipoUsuario + " | Concesionario UQ");

		HBox hbox = new HBox();
		ScrollPane scrollPane = new ScrollPane(panelConVolver);
		scrollPane.setId("centered-box");
		scrollPane.setBorder(null);
		scrollPane.setFitToHeight(true);
		scrollPane.setFitToWidth(true);

		Boton botonVolver = new Boton("Volver", eventoVolver);
		Boton botonAgregar = new Boton("Agregar", panelConVolver);

		hbox.getChildren().add(botonVolver);
		hbox.getChildren().add(botonAgregar);

		Insets insets = new Insets(10, 10, 10, 10);
		HBox.setMargin(botonAgregar, insets);
		HBox.setMargin(botonVolver, insets);

		HBox.setHgrow(botonVolver, Priority.ALWAYS);
		HBox.setHgrow(botonAgregar, Priority.ALWAYS);

		panelAgregarUsuario.setCenter(scrollPane);
		panelAgregarUsuario.setBottom(hbox);
	}

	public static void agregarCliente(String id, String nombre, String contrasena, String email) {
		
	}
}
