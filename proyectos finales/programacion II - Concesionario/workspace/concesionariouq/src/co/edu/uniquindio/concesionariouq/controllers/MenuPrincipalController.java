package co.edu.uniquindio.concesionariouq.controllers;

import java.io.IOException;

import co.edu.uniquindio.concesionariouq.model.Empleado;
import co.edu.uniquindio.concesionariouq.util.FxUtility;
import co.edu.uniquindio.concesionariouq.util.ValorObservable;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MenuPrincipalController {

	@FXML
	private Label lblGestion;

	@FXML
	private Label lblBloqueo;

	@FXML
	private ImageView imgLogo;

	@FXML
	private ImageView imgUsuario;

	@FXML
	private HBox homePane;

	@FXML
	private ImageView imgLogoHome;

	@FXML
	private BorderPane menuPane;

	@FXML
	private ImageView imgMenuBarra;

	@FXML
	private SplitPane mainPane;

	@FXML
	private BorderPane contentPane;

	@FXML
	private Label labelNombre;

	@FXML
	private ImageView imgDetalleEmpleado;

	@FXML
	private VBox boxDetalleEmpleado;

	@FXML
	void initialize() {
		imgUsuario.setImage(empleado.getImagen());
		imgLogo.fitWidthProperty().bind(menuPane.widthProperty().multiply(0.99));
		crearAnimacionLogoHome();
		Platform.runLater(() -> ((Stage) mainPane.getScene().getWindow())
				.setTitle("Carro UQ | Menu Principal | " + empleado.getNombre()));
		Interpolator interpolacion = new Interpolator() {

			@Override
			protected double curve(double t) {
				return 0.6 * Math.sin(4.334 * t - 2.18) + 0.5;
			}
		};

		transicion3 = new Timeline(new KeyFrame(Duration.millis(200)));
		transition = new RotateTransition(Duration.millis(200), imgDetalleEmpleado);
		transition.setInterpolator(interpolacion);

		transicion2 = new ScaleTransition(Duration.millis(200), boxDetalleEmpleado);
		estaContraida = new ValorObservable<>(false, (oldValue, newValue) -> {
			transition.setToAngle(estaContraida.getValue() ? 0 : 180);
			transicion2.setByY(estaContraida.getValue() ? 1 : -1);

			transicion3 = new Timeline(new KeyFrame(Duration.millis(200),
					new KeyValue(boxDetalleEmpleado.prefHeightProperty(), (estaContraida.getValue() ? 200 : 0))));
			transicion3.setOnFinished(v -> status--);
		});
		transition.setOnFinished(v -> status--);
		transicion2.setOnFinished(v -> status--);
	}

	@FXML
	void accionarDetalleEvent(ActionEvent event) {
		accionarDetalleEmpleado();
	}

	@FXML
	void extenderMenuEvent(MouseEvent event) {
		extenderMenuAction();
	}

	@FXML
	void contraerMenuEvent(MouseEvent event) {
		contraerMenuAction();
	}

	@FXML
	void gestionVehiculosEvent(ActionEvent event) {
		gestionVehiculosAction();
	}

	@FXML
	void gestionTransaccionesEvent(ActionEvent event) {
		gestionTransaccionesAction();
	}

	@FXML
	void gestionEmpleadosEvent(ActionEvent event) {
		gestionEmpleadosAction();
	}

	private void gestionEmpleadosAction() {
		FXMLLoader loader = new FXMLLoader();
		loader.setController(new GestionEmpleadosController(() -> homeAction()));
		loader.setLocation(getClass().getResource("../view/gestionEmpleados.fxml"));
		try {
			contentPane.setCenter(loader.load());
		} catch (IOException e) {
			e.printStackTrace();
			e.getMessage();
		}
	}

	private void gestionTransaccionesAction() {
		FXMLLoader loader = new FXMLLoader();
		loader.setController(new GestionTransaccionesController(() -> homeAction()));
		loader.setLocation(getClass().getResource("../view/gestionTransacciones.fxml"));
		try {
			contentPane.setCenter(loader.load());
		} catch (IOException e) {
			e.printStackTrace();
			e.getMessage();
		}
	}

	@FXML
	void gestionClientesEvent(ActionEvent event) {
		gestionClientesAction();
	}

	@FXML
	void gestionReportesEvent(ActionEvent event) {

	}

	@FXML
	void homeEvent(MouseEvent event) {
		homeAction();
	}

	@FXML
	void bloquearBarraEvent(ActionEvent event) {
		bloquearBarraAction();
	}

	@FXML
	void cambiarContrasenaEvent(ActionEvent event) {

	}

	@FXML
	void cerrarSesionEvent(ActionEvent event) {
		cerrarSesionAction();
	}

	@FXML
	void eliminarCuentaEvent(ActionEvent event) {

	}

	private boolean barraBloqueada;

	private Empleado empleado;

	private int status = 0;

	private ValorObservable<Boolean> estaContraida;

	private RotateTransition transition;

	private ScaleTransition transicion2;

	private Timeline transicion3;

	public MenuPrincipalController(Empleado empleado) {
		this.empleado = empleado;
	}

	public void updateNameField() {
		labelNombre.setText(empleado.getNombre());
	}

	private void crearAnimacionLogoHome() {
		ScaleTransition transicion = new ScaleTransition(Duration.millis(5000), imgLogoHome);
		transicion.setToX(1.2f);
		transicion.setToY(1.2f);
		Interpolator interpolation = new Interpolator() {

			@Override
			protected double curve(double t) {
				return 0.5 * (1 - Math.cos(t * Math.PI));
			}
		};

		transicion.setInterpolator(interpolation);
		transicion.setCycleCount(-1);
		transicion.setAutoReverse(true);
		transicion.play();
	}

	private void extenderMenuAction() {
		if (!barraBloqueada) {
			cambiarMenuTam(1);
			lblGestion.setVisible(true);
			lblBloqueo.setVisible(true);
		}
	}

	private void cambiarMenuTam(int num) {
		mainPane.getDividers().forEach(divider -> {
			KeyValue kv = new KeyValue(divider.positionProperty(), divider.getPosition() + num);
			KeyFrame kf = new KeyFrame(Duration.millis(1000), kv);
			EventHandler<ActionEvent> evento = event -> setLogoImage(
					"/resources/images/" + (num == 1 ? "Whitelogowoutbg.png" : "Logo Window Big.png"));
			KeyFrame k2 = new KeyFrame(Duration.millis(70), evento);
			Timeline timeline = new Timeline(kf, k2);
			timeline.play();
		});
	}

	public void accionarDetalleEmpleado() {
		if (status <= 0) {
			estaContraida.setValue(!estaContraida.getValue());
			status = 3;
			transicion3.play();
			transicion2.play();
			transition.play();
		}
	}

	private void contraerMenuAction() {
		if (!barraBloqueada) {
			cambiarMenuTam(-1);
			lblGestion.setVisible(false);
			lblBloqueo.setVisible(false);
		}
	}

	private void homeAction() {
		contentPane.setCenter(homePane);
	}

	private void setLogoImage(String route) {
		imgLogo.setImage(new Image(route));
	}

	private void bloquearBarraAction() {
		ButtonType btnExtendido = new ButtonType("Extendido");
		ButtonType btnContraido = new ButtonType("Contraido");
		ButtonType btnNo = new ButtonType("Quitar");
		ButtonType botonAlerta = FxUtility.crearDecisionAlerta("Decision", "Que tipo de bloqueo quieres tener",
				"Eligue el tipo de bloqueo que deseas para la barra lateral de la ventana", AlertType.INFORMATION, 600,
				btnExtendido, btnContraido, btnNo);
		barraBloqueada = false;
		if (botonAlerta == btnExtendido) {
			extenderMenuAction();
			imgMenuBarra.setImage(new Image("/resources/images/Candado Bloqueado.png"));
			barraBloqueada = true;
		} else if (botonAlerta == btnContraido) {
			contraerMenuAction();
			imgMenuBarra.setImage(new Image("/resources/images/Candado Bloqueado.png"));
			barraBloqueada = true;
		} else {
			imgMenuBarra.setImage(new Image("/resources/images/Candado Libre.png"));
			contraerMenuAction();
		}
	}

	private void cerrarSesionAction() {
		ButtonType btnNo = new ButtonType("No");
		ButtonType btnSi = new ButtonType("Si");
		ButtonType btn = FxUtility.crearDecisionAlerta("Decision", "¿Deseas cerrar sesion?",
				"¿Estas segur@ que deseas cerrar sesion?", AlertType.CONFIRMATION, 600, btnSi, btnNo);
		if (btn != btnSi)
			return;
		FXMLLoader loader = new FXMLLoader();
		loader.setController(new LoginPageController());
		loader.setLocation(getClass().getResource("../view/login.fxml"));
		Stage stage = (Stage) mainPane.getScene().getWindow();
		try {
			stage.setScene(new Scene(loader.load()));
			stage.centerOnScreen();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void gestionClientesAction() {
		FXMLLoader loader = new FXMLLoader();
		loader.setController(new GestionClientesController(contentPane, () -> homeAction()));
		loader.setLocation(getClass().getResource("../view/gestionClientes.fxml"));
		try {
			contentPane.setCenter(loader.load());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void gestionVehiculosAction() {
		FXMLLoader loader = new FXMLLoader();
		loader.setController(new TablaVehiculosController(() -> homeAction()));
		loader.setLocation(getClass().getResource("../view/tablaVehiculo.fxml"));
		try {
			contentPane.setCenter(loader.load());
		} catch (IOException e) {
			e.printStackTrace();
			e.getMessage();
		}
	}

}
