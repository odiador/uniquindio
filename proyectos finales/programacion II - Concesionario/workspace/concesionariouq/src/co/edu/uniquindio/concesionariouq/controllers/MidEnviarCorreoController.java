package co.edu.uniquindio.concesionariouq.controllers;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.mail.MessagingException;

import co.edu.uniquindio.concesionariouq.model.Empleado;
import co.edu.uniquindio.concesionariouq.util.FxUtility;
import co.edu.uniquindio.concesionariouq.util.ProjectUtility;
import co.edu.uniquindio.concesionariouq.util.ValorObservable;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MidEnviarCorreoController {
	@FXML
	private ImageView imgLogo;

	@FXML
	private HBox boxImg;

	@FXML
	private VBox mainPane;

	@FXML
	private Button btnVolver;

	@FXML
	private Label lblDots;

	@FXML
	private Label labelEnviando;

	@FXML
	void volverEvent(ActionEvent event) {
		volverAction();
	}

	@FXML
	void initialize() {
		ejecutarActualizacionDots();
		ejecutarVisionBtnVolver();
		initValues();
		ejecutarHiloEnviarCodigo();
	}

	private Empleado empleado;

	private String code;

	private ValorObservable<Boolean> seHaTerminado;

	public MidEnviarCorreoController(Empleado empleado) {
		this.empleado = empleado;
	}

	private void initValues() {
		code = ProjectUtility.crearCodigoRandomAlfaNumerico(6);
		seHaTerminado = new ValorObservable<Boolean>(false, (oldValue, newValue) -> {
			Platform.runLater(() -> {
				animarBox();
			});
		});
	}

	private void animarBox() {
		KeyValue keyValue = new KeyValue(lblDots.opacityProperty(), 0);
		KeyValue keyValue2 = new KeyValue(boxImg.opacityProperty(), 0);
		KeyValue keyValue3 = new KeyValue(labelEnviando.opacityProperty(), 0);
		KeyFrame keyFrame = new KeyFrame(Duration.millis(1000), keyValue, keyValue2, keyValue3);
		Timeline timeline = new Timeline(keyFrame);
		timeline.play();
		timeline.setOnFinished(evento -> {
			irAVercodigo();
		});
	}

	private void ejecutarHiloEnviarCodigo() {
		new Thread(() -> enviarCorreo()).start();
	}

	private void enviarCorreo() {
		try {
			ProjectUtility.enviarCorreoRecuperacion(empleado.getEmail(), empleado.getNombre(), code);
			seHaTerminado.setValue(true);
		} catch (MessagingException | IOException e) {
			Platform.runLater(() -> {
				FxUtility.mostrarMensaje("Advertencia", "No se pudo enviar el correo", e.getMessage(), AlertType.ERROR);
			});
		}

	}

	private void ejecutarActualizacionDots() {
		EventHandler<ActionEvent> evento = event -> actualizarDots();
		Timeline lineActualizarPuntos = new Timeline(new KeyFrame(Duration.millis(150), evento));
		lineActualizarPuntos.setCycleCount(-1);
		lineActualizarPuntos.play();
	}

	private void ejecutarVisionBtnVolver() {
		KeyValue value = new KeyValue(btnVolver.opacityProperty(), 1);
		KeyFrame keyFrame = new KeyFrame(Duration.millis(1000), value);
		Timeline lineActualizarPuntos = new Timeline(keyFrame);
		lineActualizarPuntos.setDelay(Duration.seconds(5));
		lineActualizarPuntos.setCycleCount(1);
		lineActualizarPuntos.play();
	}

	private void irAVercodigo() {
		CodigoRecuperacionController controller = new CodigoRecuperacionController(empleado, code, LocalDateTime.now());
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("../view/panelCodigoRecuperacion.fxml"));
		loader.setController(controller);
		try {
			Stage stage = (Stage) mainPane.getScene().getWindow();
			stage.setScene(new Scene(loader.load()));
			stage.centerOnScreen();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void actualizarDots() {
		lblDots.setText(
				Stream.generate(() -> ".").limit((lblDots.getText().length() % 3) + 1).collect(Collectors.joining()));
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
