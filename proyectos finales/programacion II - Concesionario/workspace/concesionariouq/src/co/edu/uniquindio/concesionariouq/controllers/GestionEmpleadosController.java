package co.edu.uniquindio.concesionariouq.controllers;

import java.io.IOException;

import co.edu.uniquindio.concesionariouq.exceptions.NullException;
import co.edu.uniquindio.concesionariouq.exceptions.UsuarioNoEncontradoException;
import co.edu.uniquindio.concesionariouq.model.Empleado;
import co.edu.uniquindio.concesionariouq.util.FxUtility;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class GestionEmpleadosController {

	@FXML
	private TableColumn<Empleado, String> columIdentificacion;

	@FXML
	private TableView<Empleado> tablaEmpleados;

	@FXML
	private TableColumn<Empleado, String> colNombre;

	@FXML
	private BorderPane mainPane;

	private Runnable volverEvent;

	@FXML
	void agregarEvent(ActionEvent event) {
		agregarAction();
	}

	@FXML
	void eliminarEvent(ActionEvent event) {
		eliminarAction();

	}

	private void agregarAction() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("../view/register.fxml"));
		loader.setController(new RegistroEmpleadoController(new Runnable() {
			
			@Override
			public void run() {
				actualizarTabla();
			}
		}));
		try {
			Stage stage = new Stage();
			stage.setScene(new Scene(loader.load()));
			stage.centerOnScreen();
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void eliminarAction() {
		Empleado empleado = tablaEmpleados.getSelectionModel().getSelectedItem();
		if (empleado == null) {
			FxUtility.mostrarMensaje("Advertencia", "Selecciona un empleado", "Selecciona un empleado",
					AlertType.ERROR);
			return;
		}
		try {
			ModelFactoryController.getInstance().eliminarEmpleado(empleado.getId());
			actualizarTabla();
			FxUtility.mostrarMensaje("Informacion", "El empleado fue eliminado", "El empleado fue eliminado",
					AlertType.CONFIRMATION);
		} catch (UsuarioNoEncontradoException | NullException e) {
			FxUtility.mostrarMensaje("Advertencia", "El empleado no se pudo eliminar", e.getMessage(), AlertType.ERROR);
		}
	}

	@FXML
	void volverEvent(ActionEvent event) {
		volverEvent.run();
	}

	@FXML
	void initialize() {
		actualizarTabla();
		colNombre.setCellValueFactory(e -> new ReadOnlyStringWrapper(e.getValue().getNombre()));
		columIdentificacion.setCellValueFactory(e -> new ReadOnlyStringWrapper(e.getValue().getId()));
	}

	private void actualizarTabla() {
		tablaEmpleados
				.setItems(FXCollections.observableArrayList(ModelFactoryController.getInstance().listarEmpleados()));
		tablaEmpleados.refresh();
	}

	public GestionEmpleadosController(Runnable volverEvent) {
		this.volverEvent = volverEvent;
	}
}
