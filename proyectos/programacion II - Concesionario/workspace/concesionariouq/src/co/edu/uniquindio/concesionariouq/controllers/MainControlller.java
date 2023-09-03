package co.edu.uniquindio.concesionariouq.controllers;

import java.io.IOException;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MainControlller {

	@FXML
	private ImageView imgU;

	@FXML
	private ImageView imgA;

	@FXML
	private VBox contenedorO;

	@FXML
	private HBox boxTodoLogo;

	@FXML
	private BorderPane mainPane;

	@FXML
	private ImageView imgC;

	@FXML
	private ImageView imgQ;

	@FXML
	private ImageView imgR1;

	@FXML
	private ImageView imgR2;

	@FXML
	private ImageView imgLlanta;

	private Interpolator interpolation;

	@FXML
	void initialize() {
		interpolation = new Interpolator() {

			@Override
			protected double curve(double t) {
				return 0.5 * (1 - Math.cos(t * Math.PI));
			}
		};
		KeyValue keyValue1 = new KeyValue(contenedorO.opacityProperty(), 1, interpolation);
		KeyFrame keyFrame2 = new KeyFrame(Duration.millis(1000), (value) -> ejecutarAnimacion2(), keyValue1);
		Timeline timeline = new Timeline(keyFrame2);
		timeline.play();
	}

	private void ejecutarAnimacion2() {

		KeyValue keyValueContenecorC = new KeyValue(imgC.fitHeightProperty(), 100, interpolation);
		KeyValue keyValueContenecorA = new KeyValue(imgA.fitHeightProperty(), 100, interpolation);
		KeyValue keyValueContenecorR1 = new KeyValue(imgR1.fitHeightProperty(), 100, interpolation);
		KeyValue keyValueContenecorR2 = new KeyValue(imgR2.fitHeightProperty(), 100, interpolation);
		KeyValue keyValueContenecorU = new KeyValue(imgU.fitHeightProperty(), 100, interpolation);
		KeyValue keyValueContenecorQ = new KeyValue(imgQ.fitHeightProperty(), 100, interpolation);
		KeyValue keyValueContenecorC2 = new KeyValue(imgC.fitWidthProperty(), 100, interpolation);
		KeyValue keyValueContenecorA2 = new KeyValue(imgA.fitWidthProperty(), 100, interpolation);
		KeyValue keyValueContenecorR12 = new KeyValue(imgR1.fitWidthProperty(), 100, interpolation);
		KeyValue keyValueContenecorR22 = new KeyValue(imgR2.fitWidthProperty(), 100, interpolation);
		KeyValue keyValueContenecorU2 = new KeyValue(imgU.fitWidthProperty(), 100, interpolation);
		KeyValue keyValueContenecorQ2 = new KeyValue(imgQ.fitWidthProperty(), 100, interpolation);
		KeyFrame keyFrame2 = new KeyFrame(Duration.millis(500), (evento) -> ejecutarAnimacion3(), keyValueContenecorC,
				keyValueContenecorA, keyValueContenecorR1, keyValueContenecorR2, keyValueContenecorU,
				keyValueContenecorQ, keyValueContenecorC2, keyValueContenecorA2, keyValueContenecorR12,
				keyValueContenecorR22, keyValueContenecorU2, keyValueContenecorQ2);
		Timeline timeline = new Timeline(keyFrame2);
		timeline.play();
	}

	private void ejecutarAnimacion3() {
		KeyValue keyValueContenecorC = new KeyValue(imgC.opacityProperty(), 1, interpolation);
		KeyValue keyValueContenecorA = new KeyValue(imgA.opacityProperty(), 1, interpolation);
		KeyValue keyValueContenecorR1 = new KeyValue(imgR1.opacityProperty(), 1, interpolation);
		KeyValue keyValueContenecorR2 = new KeyValue(imgR2.opacityProperty(), 1, interpolation);
		KeyValue keyValueContenecorU = new KeyValue(imgU.opacityProperty(), 1, interpolation);
		KeyValue keyValueContenecorQ = new KeyValue(imgQ.opacityProperty(), 1, interpolation);

		KeyFrame keyFrame5 = new KeyFrame(Duration.millis(150), (evento) -> {
			ejecutarAnimacionFinal();
		}, keyValueContenecorC);
		KeyFrame keyFrame4 = new KeyFrame(Duration.millis(150), (evento) -> new Timeline(keyFrame5).play(),
				keyValueContenecorA);
		KeyFrame keyFrame3 = new KeyFrame(Duration.millis(150), (evento) -> new Timeline(keyFrame4).play(),
				keyValueContenecorR1, keyValueContenecorQ);
		KeyFrame keyFrame2 = new KeyFrame(Duration.millis(150), (evento) -> new Timeline(keyFrame3).play(),
				keyValueContenecorR2, keyValueContenecorU);
		new Timeline(keyFrame2).play();
	}

	private void ejecutarAnimacionFinal() {
		KeyValue keyValue = new KeyValue(boxTodoLogo.opacityProperty(), 0);
		KeyFrame keyFrame6 = new KeyFrame(Duration.millis(1000), (value) -> ejecutarAnimacionSalida(), keyValue);
		new Timeline(keyFrame6).play();
	}

	private void ejecutarAnimacionSalida() {
		EventHandler<ActionEvent> evento = event -> irAMain();
		new Timeline(new KeyFrame(Duration.millis(100), evento)).play();
	}

	private void irAMain() {
		FXMLLoader loader = new FXMLLoader();
		loader.setController(new LoginPageController());
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