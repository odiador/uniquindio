package co.edu.uniquindio.concesionariouq.controllers;

import java.io.IOException;

import co.edu.uniquindio.concesionariouq.exceptions.NullException;
import co.edu.uniquindio.concesionariouq.exceptions.UsuarioNoEncontradoException;
import co.edu.uniquindio.concesionariouq.model.Empleado;
import co.edu.uniquindio.concesionariouq.util.FxUtility;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class CambioContrasenaController {

	@FXML
	private PasswordField txtContrasena;

	@FXML
	private PasswordField txtConfirmContrasena;

	@FXML
	private BorderPane mainPane;

	@FXML
	void cancelarEvent(ActionEvent event) {
		volverAction();
	}

	@FXML
	void cambiarContrasenaEvent(ActionEvent event) {
		cambiarContrasenaAction();
	}

	private Empleado empleado;

	public CambioContrasenaController(Empleado empleado) {
		this.empleado = empleado;
	}

	private void cambiarContrasenaAction() {
		if (!txtContrasena.getText().equals(txtConfirmContrasena.getText())) {
			FxUtility.mostrarMensaje("Advertencia", "Tu contraseña no coincide con su confirmacion", "",
					AlertType.ERROR);
			return;
		}
		try {
			ModelFactoryController.getInstance().actualizarContrasena(empleado.getId(), txtContrasena.getText());
			FxUtility.mostrarMensaje("Informacion", "Tu contraseña ha sido cambiada",
					empleado.getNombre() + ", tu contraseña ha sido cambiada con éxito", AlertType.CONFIRMATION);
			volverAction();
		} catch (NullException | UsuarioNoEncontradoException e) {
			FxUtility.mostrarMensaje("Advertencia", "No se ha podido cambiar la contrasena", e.getMessage(),
					AlertType.ERROR);
		}
	}

	private void volverAction() {
		FXMLLoader loader = new FXMLLoader();
		loader.setController(new LoginPageController(empleado.getId()));
		loader.setLocation(getClass().getResource("../view/login.fxml"));
		try {
			Stage stage = (Stage) mainPane.getScene().getWindow();
			stage.setScene(new Scene(loader.load()));
			stage.centerOnScreen();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
