package co.edu.uniquindio.concesionariouq.controllers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.concesionariouq.exceptions.AtributosFaltantesException;
import co.edu.uniquindio.concesionariouq.exceptions.NullException;
import co.edu.uniquindio.concesionariouq.exceptions.VehiculoYaExisteException;
import co.edu.uniquindio.concesionariouq.model.Bus;
import co.edu.uniquindio.concesionariouq.model.Combustible;
import co.edu.uniquindio.concesionariouq.model.EstadoVehiculo;
import co.edu.uniquindio.concesionariouq.model.TipoCambio;
import co.edu.uniquindio.concesionariouq.util.FxUtility;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class AgregarBusController {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TextField txtSalidasEmergencia;

	@FXML
	private Label lblTipoVehiculo;

	@FXML
	private TextField txtModelo;

	@FXML
	private TextField txtVelMaxima;

	@FXML
	private Button btnCombustible;

	@FXML
	private CheckBox checkReversa;

	@FXML
	private ComboBox<EstadoVehiculo> comboEstado;

	@FXML
	private Button btnAgregar;

	@FXML
	private Button btnCerrar;

	@FXML
	private TextField txtNumBolsas;

	@FXML
	private CheckBox checkABS;

	@FXML
	private TextField txtPlaca;

	@FXML
	private TextField txtNumPuertas;

	@FXML
	private ComboBox<TipoCambio> comboCambio;

	@FXML
	private CheckBox checkAireAcondicionado;

	@FXML
	private BorderPane root;

	@FXML
	private TextField txtNumEjes;

	@FXML
	private TextField txtCapacidadMaletero;

	@FXML
	private TextField txtCilindraje;

	@FXML
	private TextField txtMarca;

	@FXML
	private TextField txtNumPasajeros;

	private Combustible combustible;

	private Runnable actualizarTabla;

	public AgregarBusController(Combustible combustible, Runnable actualizarTabla) {
		this.combustible = combustible;
		this.actualizarTabla = actualizarTabla;
	}

	@FXML
	void agregarAction(ActionEvent event) {
		agregar();
	}

	@FXML
	void cerrarAction(ActionEvent event) {
		((Stage) root.getScene().getWindow()).close();
	}

	@FXML
	void combustibleEvent(ActionEvent event) {

	}

	@FXML
	void initialize() {
		FxUtility.setAsNumberTextfield(txtPlaca);
		FxUtility.setMaximumTextSize(txtPlaca, 12);

		FxUtility.setAsAlphanumericTextfield(txtMarca);
		FxUtility.setMaximumTextSize(txtMarca, 12);

		FxUtility.setAsNumberTextfield(txtModelo);
		FxUtility.setMaximumTextSize(txtModelo, 4);

		FxUtility.setAsNumberTextfield(txtCilindraje);
		FxUtility.setMaximumTextSize(txtCilindraje, 10);

		FxUtility.setAsNumberTextfield(txtVelMaxima);
		FxUtility.setMaximumTextSize(txtVelMaxima, 10);

		comboEstado.setItems(FXCollections.observableList(EstadoVehiculo.getValues()));
		comboCambio.setItems(FXCollections.observableList(TipoCambio.getValues()));

		FxUtility.setAsNumberTextfield(txtNumPasajeros);
		FxUtility.setMaximumTextSize(txtNumPasajeros, 2);

		FxUtility.setAsNumberTextfield(txtNumBolsas);
		FxUtility.setMaximumTextSize(txtNumBolsas, 2);

		FxUtility.setAsNumberTextfield(txtNumPuertas);
		FxUtility.setMaximumTextSize(txtNumPuertas, 2);

		FxUtility.setAsNumberTextfield(txtCapacidadMaletero);
		FxUtility.setMaximumTextSize(txtCapacidadMaletero, 10);

		FxUtility.setAsNumberTextfield(txtNumEjes);
		FxUtility.setMaximumTextSize(txtNumEjes, 2);

		FxUtility.setAsNumberTextfield(txtSalidasEmergencia);
		FxUtility.setMaximumTextSize(txtSalidasEmergencia, 2);
	}

	private void agregar() {
		try {
			Image image = new Image(new FileInputStream("/resources/images/vehiculos/bus.png"));
			ModelFactoryController.getInstance()
					.agregarVehiculo(new Bus(txtPlaca.getText().trim(), txtMarca.getText().trim(),
							txtModelo.getText().trim(), Double.parseDouble(txtCilindraje.getText().trim()),
							Double.parseDouble(txtVelMaxima.getText().trim()), combustible, comboEstado.getValue(),
							comboCambio.getValue(), Integer.parseInt(txtNumPasajeros.getText().trim()),
							Integer.parseInt(txtNumBolsas.getText().trim()),
							Integer.parseInt(txtNumPuertas.getText().trim()), checkAireAcondicionado.isSelected(),
							checkReversa.isSelected(), checkABS.isSelected(),
							Double.parseDouble(txtCapacidadMaletero.getText().trim()),
							Integer.parseInt(txtNumEjes.getText().trim()),
							Integer.parseInt(txtSalidasEmergencia.getText().trim()), image));
			actualizarTabla.run();
			FxUtility.mostrarMensaje("Informacion", "El vehiculo ha sido agregado con exito",
					"El vehiculo ha sido agregado con exito", AlertType.CONFIRMATION);
		} catch (NumberFormatException | NullException | AtributosFaltantesException | VehiculoYaExisteException
				| FileNotFoundException e) {
			FxUtility.mostrarMensaje("Advertencia", "No se pudo agregar el vehiculo", e.getMessage(), AlertType.ERROR);
		}
	}

}
