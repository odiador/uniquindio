package co.edu.uniquindio.concesionariouq.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.concesionariouq.model.Combustible;
import co.edu.uniquindio.concesionariouq.model.Diesel;
import co.edu.uniquindio.concesionariouq.model.Electrico;
import co.edu.uniquindio.concesionariouq.model.Gasolina;
import co.edu.uniquindio.concesionariouq.model.Hibrido;
import co.edu.uniquindio.concesionariouq.model.TipoCombustible;
import co.edu.uniquindio.concesionariouq.util.FxUtility;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

public class GestionCombustibleController {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private ComboBox<TipoCombustible> comboTipoC;

	@FXML
	private CheckBox checkEnchufable;

	@FXML
	private CheckBox checkHibridoLigero;

	@FXML
	private BorderPane root;

	@FXML
	private BorderPane mainPane;

	@FXML
	private TextField txtAutonomia;

	@FXML
	private Label lbl1;

	@FXML
	private TextField txtCarga;

	@FXML
	private Label lbl2;

	@FXML
	private Button btnSiguiente;

	private Runnable actualizarTabla;

	public GestionCombustibleController(Runnable actualizarTabla) {
		this.actualizarTabla = actualizarTabla;
	}

	@FXML
	void initialize() {
		lbl1.setVisible(false);
		txtAutonomia.setVisible(false);
		checkEnchufable.setVisible(false);

		lbl2.setVisible(false);
		txtCarga.setVisible(false);
		checkHibridoLigero.setVisible(false);

		FxUtility.setAsNumberTextfield(txtAutonomia);
		FxUtility.setMaximumTextSize(txtAutonomia, 2);

		FxUtility.setAsNumberTextfield(txtCarga);
		FxUtility.setMaximumTextSize(txtCarga, 2);

		comboTipoC.setItems(FXCollections.observableList(TipoCombustible.getValues()));
		comboTipoC.valueProperty().addListener((observable, oldV, newV) -> {
			switch (newV) {
			case ELECTRICO:
				lbl1.setText("Autonomia con carga completa:");
				lbl1.setVisible(true);
				txtAutonomia.setVisible(true);
				checkEnchufable.setVisible(false);

				lbl2.setText("Tiempo que demora en cargar:");
				lbl2.setVisible(true);
				txtCarga.setVisible(true);
				checkHibridoLigero.setVisible(false);
				break;

			case HIBRIDO:
				lbl1.setText("El Vehichulo es enchufable:");
				lbl1.setVisible(true);
				txtAutonomia.setVisible(false);
				checkEnchufable.setVisible(true);

				lbl2.setText("El Vehichulo es hibrido ligero:");
				lbl2.setVisible(true);
				txtCarga.setVisible(false);
				checkHibridoLigero.setVisible(true);
				break;
			case DIESEL:
				lbl1.setVisible(false);
				lbl2.setVisible(false);
				txtAutonomia.setVisible(false);
				checkEnchufable.setVisible(false);
				
			case GASOLINA:
				lbl1.setVisible(false);
				lbl2.setVisible(false);
				txtCarga.setVisible(false);
				checkHibridoLigero.setVisible(false);
			default:
				break;
			}
		});
	}

	@FXML
	void siguienteEvent(ActionEvent action) {

		Combustible combustible = null;

		switch (comboTipoC.getValue()) {
		case DIESEL:
			combustible = new Diesel();
			break;

		case GASOLINA:
			combustible = new Gasolina();
			break;

		case ELECTRICO:
			if (!validarCampos()) {
				FxUtility.mostrarMensaje("Llene", "Llene todos los campos", "Recuerde llenar todos los campos",
						AlertType.WARNING);
				break;
			}
			combustible = new Electrico(Double.parseDouble(txtAutonomia.getText().trim()),
					Double.parseDouble(txtCarga.getText().trim()));
		case HIBRIDO:
			combustible = new Hibrido(checkEnchufable.isSelected(), checkHibridoLigero.isSelected());
		default:
			break;
		}

		if (combustible != null) {
			FXMLLoader loader = new FXMLLoader();
			loader.setController(new AgregarVehiculoController(combustible, mainPane, actualizarTabla));
			loader.setLocation(getClass().getResource("../view/panelAgregarVehiculo.fxml"));
			try {
				mainPane.setCenter(loader.load());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private boolean validarCampos() {
		if (txtAutonomia.getText().isEmpty() || txtCarga.getText().isEmpty())
			return false;
		return true;
	}

}
