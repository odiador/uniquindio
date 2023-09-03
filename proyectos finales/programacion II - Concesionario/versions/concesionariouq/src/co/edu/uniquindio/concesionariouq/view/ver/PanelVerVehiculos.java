package co.edu.uniquindio.concesionariouq.view.ver;

import java.util.List;

import co.edu.uniquindio.concesionariouq.controllers.ControlTablaVehiculos;
import co.edu.uniquindio.concesionariouq.exceptions.ConcesionarioException;
import co.edu.uniquindio.concesionariouq.model.Concesionario;
import co.edu.uniquindio.concesionariouq.model.Diesel;
import co.edu.uniquindio.concesionariouq.model.EstadoVehiculo;
import co.edu.uniquindio.concesionariouq.model.Gasolina;
import co.edu.uniquindio.concesionariouq.model.TipoCambio;
import co.edu.uniquindio.concesionariouq.model.Vehiculo;
import co.edu.uniquindio.concesionariouq.util.Boton;
import co.edu.uniquindio.concesionariouq.util.ProjectUtility;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class PanelVerVehiculos extends BorderPane {
	public static List<Vehiculo> listaVehiculos = listar();

	public PanelVerVehiculos() {
		initComponents();
	}

	/**
	 * Crea un concesionario provisional para probar la tabla de vehiculos para los
	 * filtros
	 * 
	 * @return
	 */
	public static List<Vehiculo> listar() {
		Concesionario concesionario = new Concesionario("Nombre", "id");
		try {
			concesionario.agregarMoto("AAAA", "mazda", "2020", 200d, 200d, new Gasolina(), EstadoVehiculo.NUEVO,
					TipoCambio.AUTOMATICO);
			concesionario.agregarDeportivo("XG", "mazda", "2020", 1000d, 100d, new Gasolina(), EstadoVehiculo.NUEVO,
					TipoCambio.MANUAL, 5, 2, 3, 40, 4);
			concesionario.agregarMoto("ASAAS", "maxda", "2020", 200d, 200d, new Gasolina(), EstadoVehiculo.NUEVO,
					TipoCambio.AUTOMATICO);
			concesionario.agregarMoto("AAAV", "mazda", "2020", 200d, 200d, new Gasolina(), EstadoVehiculo.NUEVO,
					TipoCambio.AUTOMATICO);
			concesionario.agregarMoto("AAAZ", "mazda", "2020", 200d, 200d, new Diesel(), EstadoVehiculo.NUEVO,
					TipoCambio.AUTOMATICO);
		} catch (ConcesionarioException e) {
		}
		return concesionario.listarVehiculos();
	}

	public void initComponents() {
		VBox vbox = new VBox(20);
		Boton botonIr = new Boton("Ir", e -> {
			ControlTablaVehiculos.irATabla(this);
		});
		Boton botonVerFiltros = new Boton("Ver Filtros", e -> {
			ControlTablaVehiculos.irVerFiltros(this);
		});
		Boton botonQuitarFiltros = new Boton("Quitar Filtros", e -> {
			listaVehiculos = listar();
			PanelVerFiltros.filtros.clear();
			ProjectUtility.mostrarConfirmacion("Los filtros han sido eliminados");
		});
		vbox.setId("centered-box");
		vbox.getChildren().add(botonIr);
		vbox.getChildren().add(botonVerFiltros);
		vbox.getChildren().add(botonQuitarFiltros);
		setCenter(vbox);
		setBottom(null);
	}
}
