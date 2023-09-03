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

public class PanelAgregarSedan extends PanelConVolver {

	private Combustible combustible;
	private VBox box;
	private TextField tfPlaca, tfMarca, tfModelo, tfCilindraje, tfVelocidadMax, tfCMaletero;
	private Boton botonCombustible;
	private ComboBox<String> cbEstadoVechiculo, cbTipoCambio;
	private Spinner<Integer> tfNPasajeros, tfNBolsasAire, tfNPuertas;
	private CheckBox cbTieneAire, cbTieneCamara, cbTieneABS, cbTieneCrucero, cbTieneColision, cbTieneTrafico,
			cbTieneAsistente;

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
		cbTieneCrucero = new CheckBox();
		cbTieneColision = new CheckBox();
		cbTieneTrafico = new CheckBox();
		cbTieneAsistente = new CheckBox();

		box.getChildren().add(generarHBox("Ingresa la placa del vehiculo", tfPlaca));
		box.getChildren().add(generarHBox("Ingresa la marca del vehiculo", tfMarca));
		box.getChildren().add(generarHBox("Ingresa el modelo del vehiculo", tfModelo));
		box.getChildren().add(generarHBox("Ingresa el cilindraje del vehiculo", tfCilindraje));
		box.getChildren().add(generarHBox("Ingresa la velocidad maxima del vehiculo", tfVelocidadMax));
		box.getChildren().add(generarHBox("Seleccione el tipo de combustible", botonCombustible));
		box.getChildren().add(generarHBox("Seleccione el estado del vehiculo", cbEstadoVechiculo));
		box.getChildren().add(generarHBox("Seleccione el tipo de caja de cambios", cbTipoCambio));
		box.getChildren().add(generarHBox("Ingresa el numero de pasajeros", tfNPasajeros));
		box.getChildren().add(generarHBox("Ingresa el numero de bolsas de aire", tfNBolsasAire));
		box.getChildren().add(generarHBox("Ingresa el numero de puertas", tfNPuertas));
		box.getChildren().add(generarHBox("El vehiculo tiene aire acondicionado ?", cbTieneAire));
		box.getChildren().add(generarHBox("El vehiculo tiene camara de reversa ?", cbTieneCamara));
		box.getChildren().add(generarHBox("El vehiculo tiene frenos ABS ?", cbTieneABS));
		box.getChildren().add(generarHBox("Ingresa la capacidad de carga del maletero", tfCMaletero));
		box.getChildren().add(generarHBox("El vehiculo tiene velocidad crucero ?", cbTieneCrucero));
		box.getChildren().add(generarHBox("El vehiculo tiene sensor de colision ?", cbTieneColision));
		box.getChildren().add(generarHBox("El vehiculo tiene sensor de trafico ?", cbTieneTrafico));
		box.getChildren().add(generarHBox("El vehiculo tiene asistente de permanencia ?", cbTieneAsistente));

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
		ControlVehiculos.agregarSedan(tfPlaca.getText().trim().toUpperCase(), tfMarca.getText().trim(),
				tfModelo.getText().trim(), tfCilindraje.getText().trim(), tfVelocidadMax.getText().trim(), combustible,
				cbEstadoVechiculo.getValue(), cbTipoCambio.getValue(), tfNPasajeros.getValue().toString(),
				tfNBolsasAire.getValue().toString(), tfNPuertas.getValue().toString(), cbTieneAire.isSelected(),
				cbTieneCamara.isSelected(), cbTieneABS.isSelected(), tfCMaletero.getText().trim(),
				cbTieneCrucero.isSelected(), cbTieneColision.isSelected(), cbTieneTrafico.isSelected(),
				cbTieneAsistente.isSelected());
	}

}
