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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

public class PanelAgregarMoto extends PanelConVolver {

	private Combustible combustible;
	private VBox vBox;
	private TextField tfPlaca, tfMarca, tfModelo, tfCilindraje, tfVelMaxima;
	private ComboBox<String> cbEstadoVechiculo, cbTipoCambio;
	private Boton botonCombustible;

	@Override
	public void initComponents() {
		vBox = new VBox(20);
		tfPlaca = new TextField();
		tfMarca = new TextField();
		tfModelo = new TextField();
		tfCilindraje = new TextField();
		tfVelMaxima = new TextField();
		cbEstadoVechiculo = new ComboBox<String>();
		cbTipoCambio = new ComboBox<String>();
		botonCombustible = new Boton("Combustible", e -> {
			ControlVehiculos.irACambiarCombustible(this, combustible);
		});
		botonCombustible.setStyle("-fx-pref-width: 400;");

		vBox.getChildren().add(generarHBox("Ingresa la placa de la moto", tfPlaca));
		vBox.getChildren().add(generarHBox("Ingresa la marca", tfMarca));
		vBox.getChildren().add(generarHBox("Ingresa el modelo", tfModelo));
		vBox.getChildren().add(generarHBox("Ingresa el cilindraje", tfCilindraje));
		vBox.getChildren().add(generarHBox("Ingresa la velocidad maxima", tfVelMaxima));
		vBox.getChildren().add(generarHBox("Elige el estado", cbEstadoVechiculo));
		vBox.getChildren().add(generarHBox("Elige el tipo de cambio", cbTipoCambio));
		vBox.getChildren().add(generarHBox("Elige el combustible", botonCombustible));

		Utility.setMaximumTextLength(tfPlaca, 6);
		Utility.setAsNumberTextfield(tfModelo);
		Utility.setAsNumberTextfield(tfCilindraje);
		Utility.setAsNumberTextfield(tfVelMaxima);
		cbEstadoVechiculo.setItems(FXCollections.observableArrayList(EstadoVehiculo.getTextValues()));
		cbTipoCambio.setItems(FXCollections.observableArrayList(TipoCambio.getTextValues()));

		setCenter(vBox);
		vBox.setId("centered-box");
		setId("centered-box");
	}

	@Override
	public void handle(MouseEvent event) {
		ControlVehiculos.agregarMoto(tfPlaca.getText().trim().toUpperCase(), tfMarca.getText().trim(),
				tfModelo.getText().trim(), tfCilindraje.getText().trim(), tfVelMaxima.getText().trim(),
				cbEstadoVechiculo.getValue(), cbTipoCambio.getValue(), combustible);
	}
}
