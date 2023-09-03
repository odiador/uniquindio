package co.edu.uniquindio.concesionariouq.controllers;

import java.io.IOException;

import co.edu.uniquindio.concesionariouq.exceptions.LoginFailedException;
import co.edu.uniquindio.concesionariouq.exceptions.NullException;
import co.edu.uniquindio.concesionariouq.model.Empleado;
import co.edu.uniquindio.concesionariouq.util.FxUtility;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LoginPageController {
	@FXML
	private PasswordField txtContrasena;

	@FXML
	private VBox mainPane;

	@FXML
	private TextField txtIdentificacion;

	@FXML
	void contrasenaOlvidadaEvent(ActionEvent event) {
		contrasenaOlvidadaAction();
	}

	@FXML
	void registrarEvent(ActionEvent event) {
		registrarAction();
	}

	@FXML
	void loginEvent(ActionEvent event) {
		loginAction();
	}

	@FXML
	void cerrarEvent(ActionEvent event) {
		cerrarAction();
	}

	@FXML
	void initialize() {
		txtIdentificacion.setText(id == null ? "" : id);
		Platform.runLater(() -> ((Stage) mainPane.getScene().getWindow()).setTitle("Carro UQ | Inicio de Sesión"));
	}

	private String id;

	public LoginPageController(String id) {
		this.id = id;
	}

	public LoginPageController() {
		this(null);
	}

	private void contrasenaOlvidadaAction() {
		FXMLLoader loader = new FXMLLoader();
		loader.setController(new OlvidarContrasenaController(txtIdentificacion.getText()));
		loader.setLocation(getClass().getResource("../view/panelCorreoRecuperacion.fxml"));
		try {
			Stage stage = (Stage) mainPane.getScene().getWindow();
			stage.setScene(new Scene(loader.load()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void registrarAction() {
		FXMLLoader loader = new FXMLLoader();
		RegistroController controller = new RegistroController(txtIdentificacion.getText());
		loader.setController(controller);
		loader.setLocation(getClass().getResource("../view/register.fxml"));
		Stage stage = (Stage) mainPane.getScene().getWindow();
		try {
			Scene scene = new Scene(loader.load(), 600, 420);
			stage.setScene(scene);
			stage.centerOnScreen();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void loginAction() {
		FXMLLoader loader = new FXMLLoader();
		Empleado empleado;
		try {
			empleado = ModelFactoryController.getInstance().hacerLogin(txtIdentificacion.getText(),
					txtContrasena.getText());
		} catch (LoginFailedException | NullException e1) {
			FxUtility.mostrarMensaje("Advertencia", "No se pudo iniciar sesion", e1.getMessage(), AlertType.ERROR);
			return;
		}
		MenuPrincipalController controller = new MenuPrincipalController(empleado);
		loader.setController(controller);
		loader.setLocation(getClass().getResource("../view/panelPrincipal.fxml"));
		try {
			Stage stage = (Stage) mainPane.getScene().getWindow();
			Scene scene = new Scene(loader.load(), 1280, 720);
			controller.updateNameField();
			stage.setScene(scene);
			stage.setMinWidth(760);
			stage.setMinHeight(760);
			stage.centerOnScreen();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void cerrarAction() {
		((Stage) mainPane.getScene().getWindow()).close();
	}

}
