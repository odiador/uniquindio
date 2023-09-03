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
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

public class PanelAgregarVan extends PanelConVolver {

	private Combustible combustible;
	private VBox box;
	private TextField tfPlaca, tfMarca, tfModelo, tfCilindraje, tfVelocidadMax, tfCMaletero;
	private Boton botonCombustible;
	private ComboBox<String> cbEstadoVechiculo, cbTipoCambio;
	private Spinner<Integer> tfNPasajeros, tfNPuertas, tfNBolsasAire;
	private CheckBox cbTieneAire, cbTieneCamara, cbTieneABS;

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
		tfNPasajeros = new Spinner<Integer>();
		tfNBolsasAire = new Spinner<Integer>();
		tfNPuertas = new Spinner<Integer>();
		cbTieneAire = new CheckBox();
		cbTieneCamara = new CheckBox();
		cbTieneABS = new CheckBox();
		tfCMaletero = new TextField();

		box.getChildren().add(generarHBox("Ingresa la placa del vehiculo", tfPlaca));
		box.getChildren().add(generarHBox("Ingresa la marca del vehiculo", tfMarca));
		box.getChildren().add(generarHBox("Ingresa el modelo del vehiculo", tfModelo));
		box.getChildren().add(generarHBox("Ingresa el cilindraje del vehiculo", tfCilindraje));
		box.getChildren().add(generarHBox("Ingresa la velocidad maxima del vehiculo", tfVelocidadMax));
		box.getChildren().add(generarHBox("Selecciona el tipo de combustible", botonCombustible));
		box.getChildren().add(generarHBox("Selecciona el estado del vehiculo", cbEstadoVechiculo));
		box.getChildren().add(generarHBox("Selecciona el tipo de la caja de cambio", cbTipoCambio));
		box.getChildren().add(generarHBox("Selecciona el numero de pasajeros", tfNPasajeros));
		box.getChildren().add(generarHBox("Selecciona el numero de bolsas de aire", tfNBolsasAire));
		box.getChildren().add(generarHBox("Selecciona el numero de puertas", tfNPuertas));
		box.getChildren().add(generarHBox("El vehiculo tiene aire acondicionado ?", cbTieneAire));
		box.getChildren().add(generarHBox("El vehiculo tiene camara de reversa ?", cbTieneCamara));
		box.getChildren().add(generarHBox("El vehiculo tiene frenos ABS ?", cbTieneABS));
		box.getChildren().add(generarHBox("Ingresa la capacidad del maletero", tfCMaletero));

		Utility.setMaximumTextLength(tfPlaca, 6);
		Utility.setAsNumberTextfield(tfModelo);
		Utility.setAsNumberTextfield(tfCilindraje);
		Utility.setAsNumberTextfield(tfVelocidadMax);
		Utility.setAsNumberTextfield(tfCMaletero);
		cbEstadoVechiculo.setItems(FXCollections.observableArrayList(EstadoVehiculo.getTextValues()));
		cbTipoCambio.setItems(FXCollections.observableArrayList(TipoCambio.getTextValues()));
		SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10);
		SpinnerValueFactory<Integer> valueFactory2 = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10);
		SpinnerValueFactory<Integer> valueFactory3 = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10);
		tfNPasajeros.setValueFactory(valueFactory);
		tfNBolsasAire.setValueFactory(valueFactory2);
		tfNPuertas.setValueFactory(valueFactory3);

		setCenter(box);
		box.setId("centered-box");
	}

	@Override
	public void handle(MouseEvent event) {
		ControlVehiculos.agregarVan(tfPlaca.getText().trim().toUpperCase(), tfMarca.getText().trim(),
				tfModelo.getText().trim(), tfCilindraje.getText().trim(), tfVelocidadMax.getText().trim(), combustible,
				cbEstadoVechiculo.getValue(), cbTipoCambio.getValue(), tfNPasajeros.getValue().toString(),
				tfNBolsasAire.getValue().toString(), tfNPuertas.getValue().toString(), cbTieneAire.isSelected(),
				cbTieneCamara.isSelected(), cbTieneABS.isSelected(), tfCMaletero.getText().trim());
	}

}
