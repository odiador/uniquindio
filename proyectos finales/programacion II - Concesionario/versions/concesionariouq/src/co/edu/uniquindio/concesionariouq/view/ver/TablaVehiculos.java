package co.edu.uniquindio.concesionariouq.view.ver;

import co.edu.uniquindio.concesionariouq.controllers.ControlTablaVehiculos;
import co.edu.uniquindio.concesionariouq.model.Vehiculo;
import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;

public class TablaVehiculos extends BorderPane {

	public TablaVehiculos() {
		initComponents();
	}

	private void initComponents() {
		TableView<Vehiculo> tabla = new TableView<>();

		TableColumn<Vehiculo, String> colPlaca = new TableColumn<>("Placa");
		TableColumn<Vehiculo, String> colTipo = new TableColumn<>("Tipo de Vehiculo");
		TableColumn<Vehiculo, String> colMarca = new TableColumn<>("Marca");
		TableColumn<Vehiculo, String> colModelo = new TableColumn<>("Modelo");
		TableColumn<Vehiculo, String> colCilindraje = new TableColumn<>("Cilindraje");
		TableColumn<Vehiculo, String> colVelMaxima = new TableColumn<>("Vel Maxima");
		TableColumn<Vehiculo, String> colEstado = new TableColumn<>("Estado");
		TableColumn<Vehiculo, String> colTipoCambios = new TableColumn<>("Tipo de Cambios");

		colPlaca.setCellValueFactory(ControlTablaVehiculos.obtenerCallbackPlaca());
		colTipo.setCellValueFactory(ControlTablaVehiculos.obtenerCallbackTipoVehiculo());
		colMarca.setCellValueFactory(ControlTablaVehiculos.obtenerCallbackMarca());
		colModelo.setCellValueFactory(ControlTablaVehiculos.obtenerCallbackModelo());
		colCilindraje.setCellValueFactory(ControlTablaVehiculos.obtenerCallbackCilindraje());
		colVelMaxima.setCellValueFactory(ControlTablaVehiculos.obtenerCallbackVelMax());
		colEstado.setCellValueFactory(ControlTablaVehiculos.obtenerCallbackEstado());
		colTipoCambios.setCellValueFactory(ControlTablaVehiculos.obtenerCallbackTipoCambios());

		tabla.getColumns().add(colPlaca);
		tabla.getColumns().add(colTipo);
		tabla.getColumns().add(colMarca);
		tabla.getColumns().add(colModelo);
		tabla.getColumns().add(colCilindraje);
		tabla.getColumns().add(colVelMaxima);
		tabla.getColumns().add(colEstado);
		tabla.getColumns().add(colTipoCambios);

		tabla.setItems(FXCollections.observableList(PanelVerVehiculos.listaVehiculos));

		setCenter(tabla);
	}
	/*
	 * 
	 * placa marca modelo cilindraje velocidadMaxima combustible estado tipo
	 * tipoVehiculo
	 * 
	 */
}
