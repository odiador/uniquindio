package co.edu.uniquindio.concesionariouq.controllers;

import co.edu.uniquindio.concesionariouq.model.Combustible;
import co.edu.uniquindio.concesionariouq.model.TipoVehiculo;
import co.edu.uniquindio.concesionariouq.util.Boton;
import co.edu.uniquindio.concesionariouq.util.PanelConVolver;
import co.edu.uniquindio.concesionariouq.view.agregarVehiculo.PanelAgregarBus;
import co.edu.uniquindio.concesionariouq.view.agregarVehiculo.PanelAgregarCamion;
import co.edu.uniquindio.concesionariouq.view.agregarVehiculo.PanelAgregarCamioneta;
import co.edu.uniquindio.concesionariouq.view.agregarVehiculo.PanelAgregarDeportivo;
import co.edu.uniquindio.concesionariouq.view.agregarVehiculo.PanelAgregarMoto;
import co.edu.uniquindio.concesionariouq.view.agregarVehiculo.PanelAgregarPickUp;
import co.edu.uniquindio.concesionariouq.view.agregarVehiculo.PanelAgregarSedan;
import co.edu.uniquindio.concesionariouq.view.agregarVehiculo.PanelAgregarVan;
import co.edu.uniquindio.concesionariouq.view.menu.PanelAgregarVehiculo;
import co.edu.uniquindio.concesionariouq.view.menu.PanelCombustible;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

public class ControlVehiculos {

	public static void irAgregarVehiculo(PanelAgregarVehiculo panelAgregarVehiculo, String opcionTipoVehiculo,
			EventHandler<? super MouseEvent> eventoVolver) {
		TipoVehiculo tipoVehiculo = TipoVehiculo.obtenerValorTipo(opcionTipoVehiculo);
		if (tipoVehiculo == null) {
			new Alert(AlertType.WARNING, "No se ha encontrado la opcion").show();
			panelAgregarVehiculo.initComponents();
			return;
		}

		PanelConVolver panelConVolver;
		switch (tipoVehiculo) {
		case MOTO:
			panelConVolver = new PanelAgregarMoto();
			break;
		case BUS:
			panelConVolver = new PanelAgregarBus();
			break;
		case CAMION:
			panelConVolver = new PanelAgregarCamion();
			break;
		case CAMIONETA:
			panelConVolver = new PanelAgregarCamioneta();
			break;
		case DEPORTIVO:
			panelConVolver = new PanelAgregarDeportivo();
			break;
		case PICKUP:
			panelConVolver = new PanelAgregarPickUp();
			break;
		case SEDAN:
			panelConVolver = new PanelAgregarSedan();
			break;
		case VAN:
			panelConVolver = new PanelAgregarVan();
			break;

		default:
			String tipo = tipoVehiculo == null ? "?" : tipoVehiculo.getTipo();
			new Alert(AlertType.WARNING, "No se ha implementado la opcion " + tipo).show();
			return;
		}

		((Stage) panelAgregarVehiculo.getScene().getWindow())
				.setTitle("Agregación de " + opcionTipoVehiculo + " | Concesionario UQ");

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

		panelAgregarVehiculo.setCenter(scrollPane);
		panelAgregarVehiculo.setBottom(hbox);
	}

	public static void agregarBus(String placa, String marca, String modelo, String cilindraje, String velocidadMaxima,
			Combustible combustible, String estado, String tipo, String numeroPasajeros, String numeroBolsasAire,
			String numeroPuertas, Boolean tieneAireAcondicionado, Boolean tieneCamaraReversa, Boolean tieneABS,
			String capacidadMaletero, String numeroEjes, String numeroSalidasEmergencia) {

	}

	public static void agregarPickUp(String placa, String marca, String modelo, String cilindraje,
			String velocidadMaxima, Combustible combustible, String estado, String tipo, String numeroPasajeros,
			String numeroBolsasAire, String numeroPuertas, Boolean tieneAireAcondicionado, Boolean tieneCamaraReversa,
			Boolean tieneABS, Boolean es4x4, String capacidadCajaCarga) {

	}

	public static void agregarCamioneta(String placa, String marca, String modelo, String cilindraje,
			String velocidadMaxima, Combustible combustible, String estado, String tipo, String numeroPasajeros,
			String numeroBolsasAire, String numeroPuertas, Boolean tieneAireAcondicionado, Boolean tieneCamaraReversa,
			Boolean tieneABS, String capacidadMaletero, Boolean tieneVelocidadCrucero, Boolean tieneSensorColision,
			Boolean tieneSensorTrafico, Boolean tieneAsistentePermanencia, Boolean es4x4) {

	}

	public static void agregarDeportivo(String placa, String marca, String modelo, String cilindraje,
			String velocidadMaxima, Combustible combustible, String estado, String tipo, String numeroPasajeros,
			String numeroBolsasAire, String numeroPuertas, String numeroCaballosFuerza, String tiempoAlcanza100Kmh) {

	}

	public static void agregarSedan(String placa, String marca, String modelo, String cilindraje,
			String velocidadMaxima, Combustible combustible, String estado, String tipo, String numeroPasajeros,
			String numeroBolsasAire, String numeroPuertas, Boolean tieneAireAcondicionado, Boolean tieneCamaraReversa,
			Boolean tieneABS, String capacidadMaletero, Boolean tieneVelocidadCrucero, Boolean tieneSensorColision,
			Boolean tieneSensorTrafico, Boolean tieneAsistentePermanencia) {

	}

	public static void agregarVan(String placa, String marca, String modelo, String cilindraje, String velocidadMaxima,
			Combustible combustible, String estado, String tipo, String numeroPasajeros, String numeroBolsasAire,
			String numeroPuertas, Boolean tieneAireAcondicionado, Boolean tieneCamaraReversa, Boolean tieneABS,
			String capacidadMaletero) {

	}

	public static void agregarCamion(String placa, String marca, String modelo, String cilindraje,
			String velocidadMaxima, Combustible combustible, String estado, String tipo, String capacidadCarga,
			Boolean tieneAireAcondicionado, Boolean tieneFrenosAire, String numeroEjes, Boolean tieneABS,
			String tipoCamion) {

	}

	public static void agregarMoto(String string, String string2, String string3, String string4, String string5,
			String string6, String string7, Combustible combustible) {

		new Alert(AlertType.CONFIRMATION, "Moto Agregada").show();
	}

	public static void irACambiarCombustible(PanelConVolver panel, Combustible combustible) {
		PanelConVolver panelConVolver = new PanelCombustible();
		panelConVolver.initComponents();
		panel.setCenter(panelConVolver);
	}

}
