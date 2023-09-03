package co.edu.uniquindio.concesionariouq.view.ver;

import co.edu.uniquindio.concesionariouq.controllers.ControlFiltroView;
import co.edu.uniquindio.concesionariouq.model.EstadoVehiculo;
import co.edu.uniquindio.concesionariouq.model.TipoFiltro;
import co.edu.uniquindio.concesionariouq.util.Boton;
import co.edu.uniquindio.concesionariouq.util.Utility;
import javafx.collections.FXCollections;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class PanelFiltrarEstado extends BorderPane {
	public PanelFiltrarEstado() {
		ComboBox<String> estados = new ComboBox<>();
		estados.setItems(FXCollections.observableArrayList(EstadoVehiculo.getTextValues()));
		Boton botonFiltrar = new Boton("Filtrar", ev -> {
			ControlFiltroView.agregarFiltro(TipoFiltro.ESTADO_VEHICULO, estados.getValue());
		});
		VBox vbox = new VBox(20);
		vbox.getChildren().add(Utility.generarHBox("Elige el estado del vehiculo", estados));
		vbox.getChildren().add(botonFiltrar);
		vbox.setId("centered-box");
		setCenter(vbox);
	}
}
