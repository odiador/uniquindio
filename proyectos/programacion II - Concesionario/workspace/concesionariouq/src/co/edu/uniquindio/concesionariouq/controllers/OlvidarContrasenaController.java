package co.edu.uniquindio.concesionariouq.controllers;

import java.io.IOException;

import co.edu.uniquindio.concesionariouq.model.Empleado;
import co.edu.uniquindio.concesionariouq.util.FxUtility;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class OlvidarContrasenaController {

	@FXML
	private BorderPane mainPane;

	@FXML
	private TextField txtIdentificacion;

	@FXML
	void initialize() {
		txtIdentificacion.setText(text);
	}

	@FXML
	void volverEvent(ActionEvent event) {
		volverAction();
	}

	@FXML
	void enviarEvent(ActionEvent event) {
		enviarAction();
	}

	private String text;

	public OlvidarContrasenaController(String text) {
		this.text = text;
	}

	private void volverAction() {
		FXMLLoader loader = new FXMLLoader();
		loader.setController(new LoginPageController(txtIdentificacion.getText()));
		loader.setLocation(getClass().getResource("../view/login.fxml"));
		try {
			Stage stage = (Stage) mainPane.getScene().getWindow();
			stage.setScene(new Scene(loader.load()));
			stage.centerOnScreen();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void enviarAction() {
		FXMLLoader loader = new FXMLLoader();
		String text = txtIdentificacion.getText();
		Empleado empleado;
		empleado = ModelFactoryController.getInstance().buscarEmpleado(text);
		if (empleado == null) {
			FxUtility.mostrarMensaje("Advertencia", "No se ha podido encontrar el usuario",
					"El empleado no se ha encontrado", AlertType.ERROR);
			return;
		}
		MidEnviarCorreoController controller = new MidEnviarCorreoController(empleado);
		loader.setLocation(getClass().getResource("../view/panelMidEnviarCorreo.fxml"));
		loader.setController(controller);
		try {
			Stage stage = (Stage) mainPane.getScene().getWindow();
			stage.setScene(new Scene(loader.load()));
			stage.centerOnScreen();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
