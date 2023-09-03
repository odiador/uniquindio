package co.edu.uniquindio.concesionariouq.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.concesionariouq.model.Vehiculo;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class TablaVehiculosController {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TableColumn<Vehiculo, String> colMarca;

	@FXML
	private TableColumn<Vehiculo, String> colEstado;

	@FXML
	private Button btnDetalle;

	@FXML
	private Button btnAgregar;

	@FXML
	private TableView<Vehiculo> tablaVehiculos;

	@FXML
	private TableColumn<Vehiculo, String> colModelo;

	@FXML
	private TableColumn<Vehiculo, String> colCaja;

	@FXML
	private TableColumn<Vehiculo, String> colCilindraje;

	@FXML
	private Button btnVolver;

	@FXML
	private TableColumn<Vehiculo, String> colVelocidad;

	@FXML
	private Button btnEliminar;

	@FXML
	private BorderPane root;

	@FXML
	private TableColumn<Vehiculo, String> colId;

	@FXML
	private TableColumn<Vehiculo, String> colCombustible;

	@FXML
	private Button btnActualizar;

	private Runnable volverRunnable;

	public TablaVehiculosController(Runnable volverRunnable) {
		this.volverRunnable = volverRunnable;
	}

	@FXML
	void initialize() {
		tablaVehiculos.setItems(FXCollections.observableList(ModelFactoryController.getInstance().listarVehiculo()));

		colId.setCellValueFactory(e -> new ReadOnlyStringWrapper(e.getValue().getId()));
		colMarca.setCellValueFactory(e -> new ReadOnlyStringWrapper(e.getValue().getMarca()));
		colModelo.setCellValueFactory(e -> new ReadOnlyStringWrapper(e.getValue().getModelo()));
		colCilindraje.setCellValueFactory(
				e -> new ReadOnlyStringWrapper(String.format("%.2f", e.getValue().getCilindraje())));
		colCombustible.setCellValueFactory(
				e -> new ReadOnlyStringWrapper(e.getValue().getCombustible().getTipoCombustible().getText()));
		colEstado.setCellValueFactory(e -> new ReadOnlyStringWrapper(e.getValue().getEstado().getText()));
		colCaja.setCellValueFactory(e -> new ReadOnlyStringWrapper(e.getValue().getTipo().getText()));
		colVelocidad.setCellValueFactory(
				e -> new ReadOnlyStringWrapper(String.format("%.2f", e.getValue().getVelocidadMaxima())));
		actualizarTabla();
	}

	@FXML
	void detalleEvent(ActionEvent event) {

	}

	@FXML
	void agregarEvent(ActionEvent event) {
		irACombustibleAction();
	}

	private void irACombustibleAction() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/panelCombustible.fxml"));
		GestionCombustibleController controller = new GestionCombustibleController(() -> actualizarTabla());
		loader.setController(controller);
		try {
			Stage stage = new Stage();
			Scene scene = new Scene(loader.load(), 1280, 720);
			stage.setScene(scene);
			stage.setMinWidth(760);
			stage.setMinHeight(760);
			stage.centerOnScreen();
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	void eliminarEvent(ActionEvent event) {
		// TODO
	}

	@FXML
	void volverEvent(ActionEvent event) {
		volverRunnable.run();
	}

	private void actualizarTabla() {
		tablaVehiculos
				.setItems(FXCollections.observableArrayList(ModelFactoryController.getInstance().listarVehiculo()));
		tablaVehiculos.refresh();
	}

}
