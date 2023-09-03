package co.edu.uniquindio.concesionariouq.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.concesionariouq.model.Combustible;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class AgregarVehiculoController {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private BorderPane root;

	@FXML
	private VBox btnDeportivo;

	@FXML
	private VBox btnCamioneta;

	@FXML
	private VBox btnCamion;

	@FXML
	private VBox btnBus;

	@FXML
	private VBox btnVan;

	@FXML
	private VBox btnPickUp;

	@FXML
	private VBox btnMoto;

	@FXML
	private VBox btnSedan;

	private Combustible combustible;

	private BorderPane mainPane;

	private Runnable actualizarTabla;

	@FXML
	void initialize() {
	}

	@FXML
	void motoEvent(MouseEvent e) {
		motoAction();
	}

	@FXML
	void sedanEvent(MouseEvent e) {
		sedanAction();
	}

	@FXML
	void pickUpEvent(MouseEvent e) {
		pickUpction();
	}

	@FXML
	void vanEvent(MouseEvent e) {
		vanAction();
	}

	@FXML
	void camionetaEvent(MouseEvent e) {
		String ruta = "../view/panelAgregarCamioneta.fxml";
		AgregarCamionetaController controller = new AgregarCamionetaController(combustible, actualizarTabla);
		abrirVentana(ruta, controller);
	}

	@FXML
	void camionEvent(MouseEvent e) {
		camionAction();
	}

	@FXML
	void deportivoEvent(MouseEvent e) {
		deportivoAction();
	}

	@FXML
	void busEvent(MouseEvent action) {
		String ruta = "../view/panelAgregarBus.fxml";
		AgregarBusController controller = new AgregarBusController(combustible, actualizarTabla);
		abrirVentana(ruta, controller);
	}

	private void motoAction() {
		String ruta = "../view/panelAgregarMoto.fxml";
		AgregarMotoController controller = new AgregarMotoController(combustible, actualizarTabla);
		abrirVentana(ruta, controller);
	}

	private void sedanAction() {
		String ruta = "../view/panelAgregarSedan.fxml";
		AgregarSedanController controller = new AgregarSedanController(combustible, actualizarTabla);
		abrirVentana(ruta, controller);

	}

	private void camionAction() {
		String ruta = "../view/panelAgregarCamion.fxml";
		AgregarCamionController controller = new AgregarCamionController(combustible, actualizarTabla);
		abrirVentana(ruta, controller);
	}
	
	private void deportivoAction() {
		String ruta = "../view/panelAgregarDeportivo.fxml";
		AgregarDeportivoController controller = new AgregarDeportivoController(combustible, actualizarTabla);
		abrirVentana(ruta, controller);
	}
	
	private void pickUpction() {
		String ruta = "../view/panelAgregarPickUp.fxml";
		AgregarPickUpController controller = new AgregarPickUpController(combustible, actualizarTabla);
		abrirVentana(ruta, controller);
	}
	
	private void vanAction() {
		String ruta = "../view/panelAgregarVan.fxml";
		AgregarVanController controller = new AgregarVanController(combustible, actualizarTabla);
		abrirVentana(ruta, controller);
	}

	private void abrirVentana(String ruta, Object controller) {
		FXMLLoader loader = new FXMLLoader();
		loader.setController(controller);
		loader.setLocation(getClass().getResource(ruta));
		try {
			mainPane.setCenter(loader.load());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public AgregarVehiculoController(Combustible combustible, BorderPane mainPane, Runnable actualizarTabla) {
		this.combustible = combustible;
		this.mainPane = mainPane;
		this.actualizarTabla = actualizarTabla;
	}
}
