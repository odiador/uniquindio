package co.edu.uniquindio.concesionariouq.controllers;

import co.edu.uniquindio.concesionariouq.exceptions.AtributosFaltantesException;
import co.edu.uniquindio.concesionariouq.exceptions.NullException;
import co.edu.uniquindio.concesionariouq.exceptions.UsuarioEncontradoException;
import co.edu.uniquindio.concesionariouq.model.Cliente;
import co.edu.uniquindio.concesionariouq.util.FxUtility;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class AgregarClienteController {

	@FXML
	private GridPane clientPane;

	@FXML
	private TextField txtNombre;

	@FXML
	private TextField txtCorreo;

	@FXML
	private BorderPane mainPane;

	@FXML
	private TextField txtIdentificacion;

	private Runnable runnableActualizarTabla;

	@FXML
	void initialize() {
		FxUtility.setAsNumberTextfield(txtIdentificacion);
		FxUtility.setAsAlphanumericTextfield(txtNombre);
	}

	@FXML
	void volverEvent(ActionEvent event) {
		((Stage) mainPane.getScene().getWindow()).close();
	}

	@FXML
	void guardarEvent(ActionEvent event) {
		if (txtIdentificacion.getText().length() < 6) {
			FxUtility.mostrarMensaje("Advertencia", "La cedula tiene que ser de 6 letras o más", "", AlertType.ERROR);
			return;
		}
		if (txtNombre.getText().isEmpty()) {
			FxUtility.mostrarMensaje("Advertencia", "El nombre está vacío", "", AlertType.ERROR);
			return;
		}
		Cliente cliente = new Cliente(txtIdentificacion.getText().trim(), txtNombre.getText().trim(),
				txtCorreo.getText().trim());
		try {
			ModelFactoryController.getInstance().agregarCliente(cliente);
			runnableActualizarTabla.run();
			FxUtility.mostrarMensaje("Informacion", "El cliente se ha agregado con éxito",
					cliente.getNombre() + ", has sido creado con agregado con exito", AlertType.CONFIRMATION);
		} catch (UsuarioEncontradoException | NullException | AtributosFaltantesException e) {
			FxUtility.mostrarMensaje("Advertencia", "No se pudo agregar el cliente", e.getMessage(), AlertType.ERROR);
		}
	}

	public AgregarClienteController(Runnable runnableActualizarTabla) {
		this.runnableActualizarTabla = runnableActualizarTabla;
	}
}
