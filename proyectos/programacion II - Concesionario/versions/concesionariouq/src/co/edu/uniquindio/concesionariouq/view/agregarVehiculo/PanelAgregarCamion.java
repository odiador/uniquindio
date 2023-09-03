package co.edu.uniquindio.concesionariouq.view.agregarVehiculo;

import static co.edu.uniquindio.concesionariouq.util.Utility.generarHBox;

import co.edu.uniquindio.concesionariouq.controllers.ControlVehiculos;
import co.edu.uniquindio.concesionariouq.model.Combustible;
import co.edu.uniquindio.concesionariouq.model.EstadoVehiculo;
import co.edu.uniquindio.concesionariouq.model.TipoCambio;
import co.edu.uniquindio.concesionariouq.util.Boton;
import co.edu.uniquindio.concesionariouq.util.PanelConVolver;
import co.edu.uniquindio.concesionariouq.util.Utility;
import javafx.collections.FXCollections;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

public class PanelAgregarCamion extends PanelConVolver {
	private Combustible combustible;
	private VBox box;
	private TextField tfPlaca, tfMarca, tfModelo, tfCilindraje, tfVelocidadMax, tfNEjes, tfTipoCamion, tfCCarga;
	private Boton botonCombustible;
	private ComboBox<String> cbEstadoVechiculo, cbTipoCambio;
	private CheckBox cbTieneAire, cbTieneFrenosAire, cbTieneABS;

	@Override
	public void initComponents() {

		box = new VBox(20);
		tfPlaca = new TextField();
		tfMarca = new TextField();
		tfModelo = new TextField();
		tfCilindraje = new TextField();
		tfVelocidadMax = new TextField();
		botonCombustible = new Boton("Combustible", e -> {
			ControlVehiculos.irACambiarCombustible(this, combustible);
		});
		cbEstadoVechiculo = new ComboBox<String>();
		cbTipoCambio = new ComboBox<String>();
		tfCCarga = new TextField();
		cbTieneAire = new CheckBox();
		cbTieneFrenosAire = new CheckBox();
		tfNEjes = new TextField();
		cbTieneABS = new CheckBox();
		tfTipoCamion = new TextField();

		box.getChildren().add(generarHBox("Ingresa la placa del vehiculo", tfPlaca));
		box.getChildren().add(generarHBox("Ingresa la marca del vehiculo", tfMarca));
		box.getChildren().add(generarHBox("Ingresa el modelo del vehiculo", tfModelo));
		box.getChildren().add(generarHBox("Ingresa el cilindraje del vehiculo", tfCilindraje));
		box.getChildren().add(generarHBox("Ingresa la velocidad maxima del vehiculo", tfVelocidadMax));
		box.getChildren().add(generarHBox("Seleccione el tipo de combustible", botonCombustible));
		box.getChildren().add(generarHBox("Seleccione el estado del vehiculo", cbEstadoVechiculo));
		box.getChildren().add(generarHBox("Seleccione el tipo de caja de cambios", cbTipoCambio));
		box.getChildren().add(generarHBox("Ingresa capacidad de carga", tfCCarga));
		box.getChildren().add(generarHBox("El vehiculo tiene aire acondicionado ?", cbTieneAire));
		box.getChildren().add(generarHBox("El vehiculo tiene frenos de aire ?", cbTieneFrenosAire));
		box.getChildren().add(generarHBox("Ingrese el numero de ejes del vehiculo", tfNEjes));
		box.getChildren().add(generarHBox("El vehiculo tiene frenos ABS ?", cbTieneABS));
		box.getChildren().add(generarHBox("Ingrese el tipo de camion", tfTipoCamion));

		Utility.setMaximumTextLength(tfPlaca, 6);
		Utility.setAsNumberTextfield(tfModelo);
		Utility.setAsNumberTextfield(tfCilindraje);
		Utility.setAsNumberTextfield(tfVelocidadMax);
		Utility.setAsNumberTextfield(tfCCarga);
		Utility.setAsNumberTextfield(tfNEjes);
		cbEstadoVechiculo.setItems(FXCollections.observableArrayList(EstadoVehiculo.getTextValues()));
		cbTipoCambio.setItems(FXCollections.observableArrayList(TipoCambio.getTextValues()));

		setCenter(box);
		box.setId("centered-box");
	}

	@Override
	public void handle(MouseEvent event) {
		ControlVehiculos.agregarCamion(tfPlaca.getText().trim().toUpperCase(), tfMarca.getText().trim(),
				tfModelo.getText().trim(), tfCilindraje.getText().trim(), tfVelocidadMax.getText().trim(), combustible,
				cbEstadoVechiculo.getValue(), cbTipoCambio.getValue(), tfCCarga.getText().trim(),
				cbTieneAire.isSelected(), cbTieneFrenosAire.isSelected(), tfNEjes.getText().trim(),
				cbTieneABS.isSelected(), tfTipoCamion.getText().trim());
	}
}
