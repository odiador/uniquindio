package co.edu.uniquindio.concesionariouq.view.ver;

import java.util.ArrayList;

import co.edu.uniquindio.concesionariouq.controllers.ControlTablaVehiculos;
import co.edu.uniquindio.concesionariouq.model.TipoFiltro;
import co.edu.uniquindio.concesionariouq.util.Boton;
import co.edu.uniquindio.concesionariouq.util.Relacion;
import javafx.event.EventHandler;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class PanelVerFiltros extends BorderPane {
	private EventHandler<? super MouseEvent> eventoVolver;
	public static final ArrayList<Relacion<TipoFiltro, String>> filtros = new ArrayList<Relacion<TipoFiltro, String>>();

	public PanelVerFiltros(EventHandler<? super MouseEvent> eventoVolver) {
		this.eventoVolver = eventoVolver;
		initComponents();
	}

	public void initComponents() {
		generarTabla();
		generarBotones();
		generarParteInferior();
	}

	private void generarParteInferior() {
		setBottom(new Boton("Volver", eventoVolver));
	}

	private void generarTabla() {
		VBox vbox = new VBox(20);
		vbox.setId("centered-box");

		if (filtros.size() == 0) {
			setCenter(new Label("No hay Filtros"));
			return;
		}

		for (Relacion<TipoFiltro, String> relacion : filtros) {
			String cadFiltro = "Filtro por " + relacion.getValor1().getText() + " " + relacion.getValor2();
			vbox.getChildren().add(new CheckBox(cadFiltro));
		}
		setCenter(vbox);
	}

	private void generarBotones() {

		Boton botonEliminarFiltro = new Boton("Eliminar Seleccionados", e -> {

		});
		Boton botonAgregarFiltro = new Boton("Agregar Filtro", e -> {
			ControlTablaVehiculos.irAFiltrar(this);
		});
		HBox.setHgrow(botonAgregarFiltro, Priority.ALWAYS);
		HBox.setHgrow(botonEliminarFiltro, Priority.ALWAYS);
		setTop(new HBox(botonAgregarFiltro, botonEliminarFiltro));
	}
}
