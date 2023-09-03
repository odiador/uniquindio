package co.edu.uniquindio.concesionariouq.view.menu;

import co.edu.uniquindio.concesionariouq.controllers.ControlVehiculos;
import co.edu.uniquindio.concesionariouq.model.TipoVehiculo;
import co.edu.uniquindio.concesionariouq.util.Boton;
import co.edu.uniquindio.concesionariouq.util.PanelConVolver;
import co.edu.uniquindio.concesionariouq.view.login.UtilPane;
import javafx.collections.FXCollections;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PanelAgregarVehiculo extends PanelConVolver {

	@Override
	public void initComponents() {
		VBox box = new VBox(20);
		ComboBox<String> comboTipoVehiculo = new ComboBox<String>();
		comboTipoVehiculo.setItems(FXCollections.observableArrayList(TipoVehiculo.tipoValues()));
		box.getChildren().add(UtilPane.generarHBox("Elige el tipo de Vehiculo", comboTipoVehiculo));
		Boton botonAgregar = new Boton("Agregar", evento -> {
			ControlVehiculos.irAgregarVehiculo(this, comboTipoVehiculo.getValue(), e -> {
				initComponents();
				((Stage) getScene().getWindow()).setTitle("Agregar Vehiculo | Concesionario UQ");
			});
		});
		box.setId("centered-box");
		setBottom(botonAgregar);
		this.setCenter(box);
	}

	@Override
	public void handle(MouseEvent event) {
		// TODO Auto-generated method stub
		
	}
}