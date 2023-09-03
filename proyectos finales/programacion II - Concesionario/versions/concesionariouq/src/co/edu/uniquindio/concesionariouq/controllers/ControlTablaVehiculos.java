package co.edu.uniquindio.concesionariouq.controllers;

import co.edu.uniquindio.concesionariouq.model.Vehiculo;
import co.edu.uniquindio.concesionariouq.util.Boton;
import co.edu.uniquindio.concesionariouq.view.ver.PanelFiltrar;
import co.edu.uniquindio.concesionariouq.view.ver.PanelVerFiltros;
import co.edu.uniquindio.concesionariouq.view.ver.PanelVerVehiculos;
import co.edu.uniquindio.concesionariouq.view.ver.TablaVehiculos;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.util.Callback;

public class ControlTablaVehiculos {

	public static void irATabla(PanelVerVehiculos panelVerVehiculos) {
		panelVerVehiculos.setCenter(new TablaVehiculos());
		Boton botonVolver = new Boton("Volver", e -> {
			panelVerVehiculos.initComponents();
		});
		panelVerVehiculos.setBottom(botonVolver);
	}

	public static void irAFiltrar(PanelVerFiltros panelVerFiltros) {
		panelVerFiltros.setCenter(new PanelFiltrar(e -> {
			panelVerFiltros.initComponents();
		}));
		panelVerFiltros.setTop(null);
		panelVerFiltros.setBottom(null);
	}

	public static void irVerFiltros(PanelVerVehiculos panelVerVehiculos) {
		panelVerVehiculos.setCenter(new PanelVerFiltros(e -> {
			panelVerVehiculos.initComponents();
		}));
	}

	public static Callback<CellDataFeatures<Vehiculo, String>, ObservableValue<String>> obtenerCallbackPlaca() {
		return data -> new ReadOnlyStringWrapper(data.getValue().getPlaca());
	}

	public static Callback<CellDataFeatures<Vehiculo, String>, ObservableValue<String>> obtenerCallbackModelo() {
		return data -> new ReadOnlyStringWrapper(data.getValue().getModelo());
	}

	public static Callback<CellDataFeatures<Vehiculo, String>, ObservableValue<String>> obtenerCallbackCilindraje() {
		return data -> new ReadOnlyStringWrapper(
				String.format("%.2f", data.getValue().getCilindraje()).replace(',', '.'));
	}

	public static Callback<CellDataFeatures<Vehiculo, String>, ObservableValue<String>> obtenerCallbackVelMax() {
		return data -> new ReadOnlyStringWrapper(
				String.format("%.2f", data.getValue().getVelocidadMaxima()).replace(',', '.'));
	}

	public static Callback<CellDataFeatures<Vehiculo, String>, ObservableValue<String>> obtenerCallbackEstado() {
		return data -> new ReadOnlyStringWrapper(data.getValue().getEstado().getText());
	}

	public static Callback<CellDataFeatures<Vehiculo, String>, ObservableValue<String>> obtenerCallbackMarca() {
		return data -> new ReadOnlyStringWrapper(data.getValue().getMarca());
	}

	public static Callback<CellDataFeatures<Vehiculo, String>, ObservableValue<String>> obtenerCallbackTipoVehiculo() {
		return data -> new ReadOnlyStringWrapper(data.getValue().getTipoVehiculo().getTipo());
	}

	public static Callback<CellDataFeatures<Vehiculo, String>, ObservableValue<String>> obtenerCallbackTipoCambios() {
		return data -> new ReadOnlyStringWrapper(data.getValue().getTipo().getText());
	}

}
