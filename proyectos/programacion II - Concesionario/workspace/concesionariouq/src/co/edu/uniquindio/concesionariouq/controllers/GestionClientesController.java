package co.edu.uniquindio.concesionariouq.controllers;

import java.io.IOException;

import co.edu.uniquindio.concesionariouq.exceptions.NullException;
import co.edu.uniquindio.concesionariouq.exceptions.UsuarioNoEncontradoException;
import co.edu.uniquindio.concesionariouq.model.Cliente;
import co.edu.uniquindio.concesionariouq.util.FxUtility;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.Callback;

public class GestionClientesController {

	@FXML
	private TableColumn<Cliente, String> colVehiculos;

	@FXML
	private TableColumn<Cliente, String> columIdentificacion;

	@FXML
	private TableView<Cliente> tablaClientes;

	@FXML
	private TableColumn<Cliente, String> colNombre;

	@FXML
	private BorderPane mainPane;

	@FXML
	void eliminarEvent(ActionEvent event) {
		ButtonType botonSeleccion = new ButtonType("Por Selección");
		ButtonType botonId = new ButtonType("Por id");
		ButtonType decisionAlerta = FxUtility.crearDecisionAlerta("Decision", "Como deseas eliminar el cliente?",
				"\"Por id\" te pregunta la identificacion del cliente a eliminar, \"por seleccion\" elimina el cliente que tengas seleccionado",
				AlertType.INFORMATION, 600, botonSeleccion, botonId);
		if (decisionAlerta == botonSeleccion) {
			eliminarPorSeleccionAction();
		}
		if (decisionAlerta == botonId) {
			eliminarPorIdAction();
		}
	}

	private void eliminarPorIdAction() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("../view/panelIdCliente.fxml"));
		loader.setController(new EliminarClienteController(() -> actualizarTabla()));
		Stage stage = new Stage();
		stage.setTitle("Carro UQ | Eliminacion de cliente por Identificacion");
		stage.getIcons().add(new Image("/resources/images/Logo Window.png"));
		try {
			stage.setScene(new Scene(loader.load()));
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void eliminarPorSeleccionAction() {
		Cliente cliente = tablaClientes.getSelectionModel().getSelectedItem();
		if (cliente == null) {
			FxUtility.mostrarMensaje("Advertencia", "Selecciona el cliente", "Recuerda seleccionar el cliente",
					AlertType.WARNING);
			return;
		}
		ButtonType decisionAlerta = FxUtility.crearDecisionAlerta("Decision", "Confirmar eliminación",
				"Deseas confirmar la eliminacion del cliente con identificacion" + cliente.getId() + "?",
				AlertType.INFORMATION, 600, ButtonType.OK, ButtonType.CLOSE);
		if (decisionAlerta == ButtonType.OK) {
			try {
				ModelFactoryController.getInstance().eliminarCliente(cliente.getId());
				actualizarTabla();
				FxUtility.mostrarMensaje("Informacion", "Se eliminó el cliente de manera exitosa",
						"El cliente con id: \"" + cliente.getId() + "\" ha sido eliminado", AlertType.CONFIRMATION);
			} catch (NullException | UsuarioNoEncontradoException e) {
				FxUtility.mostrarMensaje("Advertencia", "No se pudo eliminar el cliente", e.getMessage(),
						AlertType.ERROR);
			}
		}
	}

	@FXML
	void volverEvent(ActionEvent event) {
		volverAction();
	}

	@FXML
	void agregarEvent(ActionEvent event) {
		actualizarClienteAction();
	}

	@FXML
	void verAccionesEvent(ActionEvent event) {
		Cliente cliente = tablaClientes.getSelectionModel().getSelectedItem();
		if (cliente == null) {
			FxUtility.mostrarMensaje("Advertencia", "Elige un cliente", "Elige un cliente", AlertType.WARNING);
			return;
		}
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("../view/accionesCliente.fxml"));
		loader.setController(
				new AccionesClienteController(superiorPane, cliente, () -> superiorPane.setCenter(mainPane)));
		try {
			superiorPane.setCenter(loader.load());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	void initialize() {
		actualizarTabla();
		inicializarValoresColumnas();
	}

	private Runnable volverRunnable;

	private BorderPane superiorPane;

	public GestionClientesController(BorderPane mainPane, Runnable volverRunnable) {
		superiorPane = mainPane;
		this.volverRunnable = volverRunnable;
	}

	private void inicializarValoresColumnas() {
		colNombre.setCellValueFactory(e -> new ReadOnlyStringWrapper(e.getValue().getNombre()));
		columIdentificacion.setCellValueFactory(e -> new ReadOnlyStringWrapper(e.getValue().getId()));
		colVehiculos.setCellFactory(new Callback<TableColumn<Cliente, String>, TableCell<Cliente, String>>() {

			final @Override public TableCell<Cliente, String> call(TableColumn<Cliente, String> param) {
				return new TableCell<Cliente, String>() {

					@Override
					protected void updateItem(String arg0, boolean arg1) {
						super.updateItem(arg0, arg1);
						if (arg1) {
							setText(null);
						} else {
							setId("btn-tabla");
							Cliente cliente = getTableView().getItems().get(getIndex());
							setOnMouseClicked(e -> {
								System.out.println(cliente.listarVehiculos()); // TODO cambiar
							});
							setText("Ver Vehiculos");
						}
					}

				};
			}
		});
	}

	private void actualizarTabla() {
		tablaClientes
				.setItems(FXCollections.observableArrayList(ModelFactoryController.getInstance().listarClientes()));
		tablaClientes.refresh();
	}

	private void volverAction() {
		volverRunnable.run();
	}

	private void actualizarClienteAction() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("../view/agregarCliente.fxml"));
		loader.setController(new AgregarClienteController(() -> actualizarTabla()));
		try {
			Stage stage = new Stage();
			stage.setTitle("Carro UQ | Adicion de Clientes");
			stage.getIcons().add(new Image("/resources/images/Logo Window.png"));
			stage.setScene(new Scene(loader.load()));
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
