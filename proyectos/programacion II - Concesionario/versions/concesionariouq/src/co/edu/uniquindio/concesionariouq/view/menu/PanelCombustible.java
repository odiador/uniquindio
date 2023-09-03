package co.edu.uniquindio.concesionariouq.view.menu;

import java.util.Arrays;

import co.edu.uniquindio.concesionariouq.controllers.ControlCombustible;
import co.edu.uniquindio.concesionariouq.model.Combustible;
import co.edu.uniquindio.concesionariouq.util.PanelConVolver;
import co.edu.uniquindio.concesionariouq.util.Utility;
import javafx.collections.FXCollections;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

public class PanelCombustible extends PanelConVolver {
	private ComboBox<String> cbCombustible;
	private CheckBox checkHibridoEnchufado;
	private CheckBox checkHibridoLigero;
	private TextField txtElectricoAutonomia;
	private TextField txtElectricoTiempoCarga;

	@Override
	public void handle(MouseEvent arg0) {
	}

	@Override
	public void initComponents() {
		cbCombustible = new ComboBox<String>();
		cbCombustible.setItems(FXCollections.observableList(Arrays.asList(TipoCombustible.getTextValues())));
		cbCombustible.valueProperty().addListener((valorObservable, valorAnterior, valorNuevo) -> {
			ControlCombustible.actualizarValor(this, valorNuevo);
		});
		txtElectricoAutonomia = new TextField();
		txtElectricoTiempoCarga = new TextField();
		checkHibridoEnchufado = new CheckBox();
		checkHibridoLigero = new CheckBox();

		Utility.setAsNumberTextfield(txtElectricoAutonomia);
		Utility.setAsNumberTextfield(txtElectricoTiempoCarga);

		comboInicial();

	}

	public void comboInicial() {
		VBox box = new VBox(20);
		box.getChildren().add(Utility.generarHBox("Selecciona el tipo de combustible:", cbCombustible));
		box.setId("centered-box");
		setCenter(box);
	}

	public Combustible getCombustible() {
		txtElectricoAutonomia = new TextField();
		txtElectricoTiempoCarga = new TextField();
		checkHibridoEnchufado = new CheckBox();
		checkHibridoLigero = new CheckBox();
		return ControlCombustible.obtenerCombustible(cbCombustible.getValue(), txtElectricoAutonomia.getText(),
				txtElectricoTiempoCarga.getText(), checkHibridoEnchufado.isSelected(), checkHibridoLigero.isSelected());
	}

	public void mostrarCamposElectricos() {
		VBox box = new VBox(20);
		box.getChildren().add(Utility.generarHBox("Selecciona el tipo de combustible:", cbCombustible));
		box.getChildren().add(Utility.generarHBox("Escribe la duración de la autonomía:", txtElectricoAutonomia));
		box.getChildren().add(Utility.generarHBox("Escribe el tiempo de carga:", txtElectricoTiempoCarga));
		box.setId("centered-box");
		setCenter(box);
	}

	public void mostrarCamposHibridos() {
		VBox box = new VBox(20);
		box.getChildren().add(Utility.generarHBox("Selecciona el tipo de combustible:", cbCombustible));
		box.getChildren().add(Utility.generarHBox("¿Es enchufable?", checkHibridoEnchufado));
		box.getChildren().add(Utility.generarHBox("¿Es hibrido ligero?", checkHibridoLigero));
		box.setId("centered-box");
		setCenter(box);
	}

}
