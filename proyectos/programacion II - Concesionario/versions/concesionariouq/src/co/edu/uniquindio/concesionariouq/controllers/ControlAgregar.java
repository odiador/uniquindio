package co.edu.uniquindio.concesionariouq.controllers;

import co.edu.uniquindio.concesionariouq.util.Boton;
import co.edu.uniquindio.concesionariouq.util.PanelConVolver;
import co.edu.uniquindio.concesionariouq.view.menu.PanelAgregar;
import co.edu.uniquindio.concesionariouq.view.menu.PanelAgregarUsuario;
import co.edu.uniquindio.concesionariouq.view.menu.PanelAgregarVehiculo;
import co.edu.uniquindio.concesionariouq.view.menu.TipoAgregacion;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

public class ControlAgregar {

	public static void irAgregar(PanelAgregar panel, String tipoAgregacion,
			EventHandler<? super MouseEvent> eventoVolver) {
		TipoAgregacion tipoAgregar = TipoAgregacion.obtenerValorTipo(tipoAgregacion);
		if (tipoAgregar == null) {
			new Alert(AlertType.ERROR, "No se ha econtrado la opcion").show();
			panel.initComponents();
			return;
		}
		PanelConVolver panelConVolver;
		switch (tipoAgregar) {
		case USUARIO:
			panelConVolver = new PanelAgregarUsuario();
			break;

		case VEHICULO:
			panelConVolver = new PanelAgregarVehiculo();
			break;

		default:
			String tipo = tipoAgregar == null ? "?" : tipoAgregar.getText();
			new Alert(AlertType.WARNING, "No se ha implementado la opcion " + tipo).show();
			return;
		}

		((Stage) panel.getScene().getWindow())
				.setTitle("Adición de " + tipoAgregacion + " | Concesionario UQ");

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

		panel.setCenter(scrollPane);
		panel.setBottom(hbox);
	}

	public static void irAgregarUsuario(PanelAgregar panelAgregar) {
		PanelConVolver panelConVolver = new PanelAgregarUsuario();
		panelConVolver.initComponents();
		panelAgregar.setCenter(panelConVolver);
		
	}

	public static void irAgregarVehiculo(PanelAgregar panelAgregar) {
		PanelConVolver panelConVolver = new PanelAgregarVehiculo();
		panelConVolver.initComponents();
		panelAgregar.setCenter(panelConVolver);
		
	}
}
