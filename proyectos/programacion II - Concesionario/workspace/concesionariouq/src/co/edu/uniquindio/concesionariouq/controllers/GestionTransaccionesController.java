package co.edu.uniquindio.concesionariouq.controllers;

import co.edu.uniquindio.concesionariouq.model.Transaccion;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;

public class GestionTransaccionesController {
	@FXML
	private TableColumn<Transaccion, String> columFecha;

	@FXML
	private TableColumn<Transaccion, String> colHora;

	@FXML
	private TableColumn<Transaccion, String> columValor;

	@FXML
	private BorderPane mainPane;

	@FXML
	private TableView<Transaccion> tablaTransacciones;

	private Runnable volverRunnable;

	@FXML
	void initialize() {
		tablaTransacciones.setItems(FXCollections.observableArrayList(ModelFactoryController.getInstance().listarTransacciones()));
		columFecha.setCellValueFactory(e -> new ReadOnlyStringWrapper(e.getValue().getMomento().toLocalDate().toString()));
		colHora.setCellValueFactory(e -> new ReadOnlyStringWrapper(e.getValue().getMomento().toLocalTime().toString()));
		columValor.setCellValueFactory(e -> new ReadOnlyStringWrapper(e.getValue().getValor().toString()));
	}

	@FXML
	void volverEvent(ActionEvent event) {
		volverRunnable.run();
	}

	public GestionTransaccionesController(Runnable volverRunnable) {
		this.volverRunnable = volverRunnable;
	}
}
