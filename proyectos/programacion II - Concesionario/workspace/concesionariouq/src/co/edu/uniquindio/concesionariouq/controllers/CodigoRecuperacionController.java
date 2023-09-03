package co.edu.uniquindio.concesionariouq.controllers;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;

import co.edu.uniquindio.concesionariouq.model.Empleado;
import co.edu.uniquindio.concesionariouq.util.FxUtility;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class CodigoRecuperacionController {
	@FXML
	private Label lblTiempo;

	@FXML
	private Button btnOtroCodigo;

	@FXML
	private Button btnRecuperarContrasena;

	@FXML
	private Label lblIdentificacion;

	@FXML
	private TextField txtCodigo;

	@FXML
	private BorderPane mainPane;

	@FXML
	void initialize() {
		setComponentProperties();
		ejecutarActualizacionTiempo();
		pararCon0Segundos();
	}

	@FXML
	void volverEvent(ActionEvent event) {
		volverAction();
	}

	@FXML
	void otroCodigoEvent(ActionEvent event) {
		otroCodigoAction();
	}

	@FXML
	void recuperarContrasenaEvent(ActionEvent event) {
		recuperarContrasenaAction();
	}

	private Timeline timeline;

	private LocalDateTime fechaEnvio;

	private Empleado empleado;

	private String code;

	public CodigoRecuperacionController(Empleado empleado, String code, LocalDateTime fechaEnvio) {
		this.empleado = empleado;
		this.fechaEnvio = fechaEnvio;
		this.code = code;
	}

	private void setComponentProperties() {
		lblIdentificacion.setText(empleado.getId());
		btnOtroCodigo.setDisable(true);
	}

	private void pararCon0Segundos() {
		lblTiempo.textProperty().addListener((observable, oldVal, newVal) -> {
			if (btnOtroCodigo.isDisabled()) {
				if (Integer.parseInt(newVal.substring(0, 2)) <= 4 && Integer.parseInt(newVal.substring(3, 5)) <= 50) {
					btnOtroCodigo.setDisable(false);
				}
			}
			if (newVal.equals("00:00")) {
				lblTiempo.setStyle("-fx-text-fill: red");
				btnRecuperarContrasena.setDisable(true);
				txtCodigo.setEditable(false);
				timeline.stop();
			} else {
				lblTiempo.setStyle("");
			}
		});
	}

	private void volverAction() {
		FXMLLoader loader = new FXMLLoader();
		loader.setController(new LoginPageController(lblIdentificacion.getText()));
		loader.setLocation(getClass().getResource("../view/login.fxml"));
		try {
			Stage stage = (Stage) mainPane.getScene().getWindow();
			stage.setScene(new Scene(loader.load()));
			stage.centerOnScreen();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void ejecutarActualizacionTiempo() {
		EventHandler<ActionEvent> evento = event -> actualizarLblTiempo();
		timeline = new Timeline(new KeyFrame(Duration.millis(1), evento));
		timeline.setCycleCount(-1);
		timeline.play();
	}

	private void actualizarLblTiempo() {
		LocalDateTime now = LocalDateTime.now();
		if (now.isAfter(fechaEnvio.plusMinutes(5))) {
			lblTiempo.setText("00:00");
			return;
		}
		LocalTime tiempoEnvio15 = fechaEnvio.toLocalTime().plusMinutes(5);
		LocalTime tiempoActual = LocalTime.now();
		tiempoEnvio15 = tiempoEnvio15.minusMinutes(tiempoActual.getMinute()).minusSeconds(tiempoActual.getSecond());
		int minute = tiempoEnvio15.getMinute();
		int seconds = tiempoEnvio15.getSecond();
		String minuto = (minute < 10 ? "0" : "") + minute;
		String sedundo = (seconds < 10 ? "0" : "") + seconds;
		lblTiempo.setText(minuto + ":" + sedundo);
	}

	private void otroCodigoAction() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("../view/panelMidEnviarCorreo.fxml"));
		loader.setController(new MidEnviarCorreoController(empleado));
		try {
			Stage stage = (Stage) mainPane.getScene().getWindow();
			stage.setScene(new Scene(loader.load()));
			stage.centerOnScreen();
		} catch (IOException e) {
		}
	}

	private void recuperarContrasenaAction() {
		if (txtCodigo.getText().equals(code)) {
			irACambiarContrasena();
		} else {
			FxUtility.mostrarMensaje("Advertencia", "El código no coincide",
					"El codigo enviado a tu correo no coincide con el código que ingresaste", AlertType.ERROR);
			lblTiempo.setText("00:00");
		}
	}

	private void irACambiarContrasena() {
		FXMLLoader loader = new FXMLLoader();
		loader.setController(new CambioContrasenaController(empleado));
		loader.setLocation(getClass().getResource("../view/panelCambiarContrasena.fxml"));
		Stage stage = (Stage) mainPane.getScene().getWindow();
		try {
			stage.setScene(new Scene(loader.load()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
