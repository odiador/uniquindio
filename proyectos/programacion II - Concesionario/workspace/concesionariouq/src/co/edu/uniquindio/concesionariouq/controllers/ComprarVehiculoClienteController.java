package co.edu.uniquindio.concesionariouq.controllers;

import co.edu.uniquindio.concesionariouq.exceptions.AtributosFaltantesException;
import co.edu.uniquindio.concesionariouq.exceptions.NullException;
import co.edu.uniquindio.concesionariouq.exceptions.TransaccionYaExisteException;
import co.edu.uniquindio.concesionariouq.exceptions.UsuarioNoEncontradoException;
import co.edu.uniquindio.concesionariouq.exceptions.VehiculoNoExisteException;
import co.edu.uniquindio.concesionariouq.exceptions.VehiculoYaExisteException;
import co.edu.uniquindio.concesionariouq.model.Cliente;
import co.edu.uniquindio.concesionariouq.model.Vehiculo;
import co.edu.uniquindio.concesionariouq.model.Venta;
import co.edu.uniquindio.concesionariouq.util.FxUtility;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.util.Callback;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class ComprarVehiculoClienteController {

	@FXML
	private TextField txtValorVehiculo;

	@FXML
	private TableColumn<Vehiculo, String> colDetalle;

	@FXML
	private TableColumn<Vehiculo, String> colTipo;

	@FXML
	private TableColumn<Vehiculo, String> colId;

	@FXML
	private TableView<Vehiculo> tableVehiculos;

	private Cliente cliente;

	private Runnable runnableVolver;

	@FXML
	void volverEvent(ActionEvent event) {
		volverAction();
	}

	@FXML
	void comprarEvent(ActionEvent event) {
		comprarAction();
	}

	@FXML
	void initialize() {
		actualizarTabla();
		colDetalle.setCellFactory(new Callback<TableColumn<Vehiculo, String>, TableCell<Vehiculo, String>>() {

			final @Override public TableCell<Vehiculo, String> call(TableColumn<Vehiculo, String> param) {
				return new TableCell<Vehiculo, String>() {

					@Override
					protected void updateItem(String arg0, boolean arg1) {
						super.updateItem(arg0, arg1);
						if (arg1) {
							setText(null);
						} else {
							setId("btn-tabla");
							Vehiculo vehiculo = getTableView().getItems().get(getIndex());
							setOnMouseClicked(e -> {
								System.out.println(vehiculo.toString()); // TODO cambiar
							});
							setText("Ver Vehiculos");
						}
					}

				};
			}
		});
		colId.setCellValueFactory(e -> new ReadOnlyStringWrapper(e.getValue().getId()));
		colTipo.setCellValueFactory(e -> new ReadOnlyStringWrapper(e.getValue().getTipoVehiculo().getTipo()));
		FxUtility.setAsNumberTextfield(txtValorVehiculo);
	}

	private void actualizarTabla() {
		tableVehiculos
				.setItems(FXCollections.observableArrayList(ModelFactoryController.getInstance().listarVehiculo()));
		tableVehiculos.refresh();
	}

	public ComprarVehiculoClienteController(Cliente cliente, Runnable runnableVolver) {
		this.cliente = cliente;
		this.runnableVolver = runnableVolver;
	}

	private void comprarAction() {
		Vehiculo vehiculo = tableVehiculos.getSelectionModel().getSelectedItem();
		if (vehiculo == null) {
			FxUtility.mostrarMensaje("Advertencia", "Selecciona un vehiculo", "Selecciona un vehiculo",
					AlertType.WARNING);
			return;
		}
		double valor;
		try {
			valor = Double.parseDouble(txtValorVehiculo.getText());
		} catch (NumberFormatException e) {
			FxUtility.mostrarMensaje("Advertencia", "Llegaste al valor maximo permitido", "Elige un valor menor",
					AlertType.WARNING);
			return;
		}
		try {
			ModelFactoryController.getInstance().venderVehiculoACliente(cliente.getId(),
					new Venta(vehiculo, valor, ModelFactoryController.getInstance().getConcesionario()));
			FxUtility.mostrarMensaje("Informacion", "El vehiculo ha sido vendido al cliente",
					"El cliente con id " + cliente.getId() + " ahora tiene un nuevo vehiculo", AlertType.CONFIRMATION);
		} catch (NullException | VehiculoYaExisteException | AtributosFaltantesException | UsuarioNoEncontradoException
				| TransaccionYaExisteException | VehiculoNoExisteException e) {
			FxUtility.mostrarMensaje("Advertencia", "No se pudo vender el vehiculo al cliente", e.getMessage(),
					AlertType.WARNING);
		}
	}

	private void volverAction() {
		runnableVolver.run();
	}
}
