package co.edu.uniquindio.concesionariouq.controllers;

import co.edu.uniquindio.concesionariouq.exceptions.NullException;
import co.edu.uniquindio.concesionariouq.exceptions.UsuarioNoEncontradoException;
import co.edu.uniquindio.concesionariouq.util.FxUtility;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class EliminarClienteController {

	@FXML
	private Label lblTitulo;

	@FXML
	private BorderPane mainPane;

	@FXML
	private Button btnAccionCustom;

	@FXML
	private TextField txtIdentificacion;

	@FXML
	void cerrarEvent(ActionEvent event) {
		cerrarAction();
	}

	@FXML
	void accionCustomEvent(ActionEvent event) {
		accionCustomAction();
	}

	@FXML
	void initialize() {
		lblTitulo.setText("Eliminacion");
		btnAccionCustom.setText("Eliminar");
	}

	private Runnable actionRunnable;

	public EliminarClienteController(Runnable actionRunnable) {
		this.actionRunnable = actionRunnable;
	}

	private void cerrarAction() {
		((Stage) mainPane.getScene().getWindow()).close();
	}

	private void accionCustomAction() {
		String id = txtIdentificacion.getText();
		ButtonType decisionAlerta = FxUtility.crearDecisionAlerta("Decision", "Confirmar eliminación",
				"Deseas confirmar la eliminacion del cliente con identificacion \"" + id + "\"?", AlertType.INFORMATION,
				600, ButtonType.OK, ButtonType.CLOSE);
		if (decisionAlerta == ButtonType.OK) {
			try {
				ModelFactoryController.getInstance().eliminarCliente(id);
				actionRunnable.run();
				FxUtility.mostrarMensaje("Informacion", "El cliente ha sido eliminado",
						"El cliente con identificación: \"" + id + "\" ha sido eliminado satisfactoriamente",
						AlertType.CONFIRMATION);
			} catch (NullException | UsuarioNoEncontradoException e) {
				FxUtility.mostrarMensaje("Advertencia", "No se pudo eliminar el cliente", e.getMessage(),
						AlertType.ERROR);
			}
		}
	}

}
