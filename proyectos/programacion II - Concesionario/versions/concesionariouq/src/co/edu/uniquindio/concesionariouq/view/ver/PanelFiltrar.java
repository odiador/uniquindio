package co.edu.uniquindio.concesionariouq.view.ver;

import static co.edu.uniquindio.concesionariouq.controllers.ControlFiltros.filtrarListaVehiculosCilindrajeEnRango;
import static co.edu.uniquindio.concesionariouq.controllers.ControlFiltros.filtrarListaVehiculosEstado;
import static co.edu.uniquindio.concesionariouq.controllers.ControlFiltros.filtrarListaVehiculosPlacaEmpezando;
import static co.edu.uniquindio.concesionariouq.controllers.ControlFiltros.filtrarListaVehiculosPlacaTerminando;
import static co.edu.uniquindio.concesionariouq.controllers.ControlFiltros.filtrarListaVehiculosTipo;
import static co.edu.uniquindio.concesionariouq.controllers.ControlFiltros.filtrarListaVehiculosTipoCambio;
import static co.edu.uniquindio.concesionariouq.controllers.ControlFiltros.filtrarListaVehiculosVelMaxEnRango;
import static co.edu.uniquindio.concesionariouq.util.ProjectUtility.mostrarAdvertencia;
import static co.edu.uniquindio.concesionariouq.view.ver.PanelVerVehiculos.listaVehiculos;

import co.edu.uniquindio.concesionariouq.exceptions.FiltroException;
import co.edu.uniquindio.concesionariouq.model.EstadoVehiculo;
import co.edu.uniquindio.concesionariouq.model.TipoCambio;
import co.edu.uniquindio.concesionariouq.model.TipoVehiculo;
import co.edu.uniquindio.concesionariouq.util.Boton;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class PanelFiltrar extends BorderPane {
	public PanelFiltrar(EventHandler<? super MouseEvent> eventoVolver) {
		Boton botonCombustible = new Boton("Filtrar Combustible", easad -> {
			setCenter(new PanelFiltroCombustible());
		});
		Boton botonEstado = new Boton("Filtrar Estado", easad -> {
			setCenter(new PanelFiltrarEstado());
		});
		int num = 1;
		if (num < 0) {
			try {
				listaVehiculos = filtrarListaVehiculosEstado(listaVehiculos, EstadoVehiculo.NUEVO);
			} catch (FiltroException e) {
				mostrarAdvertencia(e.getMessage());
			}
			try {
				listaVehiculos = filtrarListaVehiculosCilindrajeEnRango(listaVehiculos, 21313, 2131);
			} catch (FiltroException e) {
				mostrarAdvertencia(e.getMessage());
			}
			try {
				listaVehiculos = filtrarListaVehiculosPlacaEmpezando(listaVehiculos, "");
			} catch (FiltroException e) {
				mostrarAdvertencia(e.getMessage());
			}
			try {
				listaVehiculos = filtrarListaVehiculosPlacaTerminando(listaVehiculos, "");
			} catch (FiltroException e) {
				mostrarAdvertencia(e.getMessage());
			}
			try {
				listaVehiculos = filtrarListaVehiculosTipo(listaVehiculos, TipoVehiculo.BUS);
			} catch (FiltroException e) {
				mostrarAdvertencia(e.getMessage());
			}
			try {
				listaVehiculos = filtrarListaVehiculosTipoCambio(listaVehiculos, TipoCambio.AUTOMATICO);
			} catch (FiltroException e) {
				mostrarAdvertencia(e.getMessage());
			}
			try {
				listaVehiculos = filtrarListaVehiculosVelMaxEnRango(listaVehiculos, 2, 2);
			} catch (FiltroException e) {
				mostrarAdvertencia(e.getMessage());
			}
		}
		VBox vbox = new VBox(20);
		vbox.getChildren().add(botonCombustible);
		vbox.getChildren().add(botonEstado);

		vbox.setId("centered-box");
		setCenter(vbox);
		setBottom(new Boton("Volver", eventoVolver));
	}
}
