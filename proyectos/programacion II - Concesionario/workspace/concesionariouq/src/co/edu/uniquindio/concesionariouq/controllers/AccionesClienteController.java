package co.edu.uniquindio.concesionariouq.controllers;

import java.io.IOException;

import javax.mail.MessagingException;

import co.edu.uniquindio.concesionariouq.model.Cliente;
import co.edu.uniquindio.concesionariouq.util.FxUtility;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;

public class AccionesClienteController {
	@FXML
	void volverEvent(ActionEvent event) {
		volverAction();
	}

	@FXML
	void comprarVehiculoEvent(ActionEvent event) {
		comprarVehiculoAction();
	}

	@FXML
	void venderVehiculoEvent(ActionEvent event) {
		venderVehiculoAction();
	}

	@FXML
	void alquilarVehiculoEvent(ActionEvent event) {
		FxUtility.mostrarMensaje("Informacion", "No se pudo alquilar", "no implementado", AlertType.ERROR);
	}

	@FXML
	void devolverVehiculoEvent(ActionEvent event) {
		FxUtility.mostrarMensaje("Informacion", "No se pudo devolver", "no implementado", AlertType.ERROR);
	}

	@FXML
	void enviarReporteEvent(ActionEvent event) {
		enviarReporteAction();
	}

	private void enviarReporteAction() {
		try {
			cliente.enviarReporteVehiculos();
			FxUtility.mostrarMensaje("Informacion", "El cliente ha recibido el reporte con exito",
					"El reporte se ha enviado a " + cliente.getCorreo(), AlertType.CONFIRMATION);
		} catch (MessagingException | IOException e) {
			FxUtility.mostrarMensaje("Advertencia", "No se pudo enviar el reporte", e.getMessage(), AlertType.ERROR);
		}
	}

	@FXML
	void verVehiculosEvent(ActionEvent event) {

	}

	private BorderPane contentPane;
	private Cliente cliente;
	private Runnable runnableVolver;

	public AccionesClienteController(BorderPane contentPane, Cliente cliente, Runnable runnableVolver) {
		this.contentPane = contentPane;
		this.cliente = cliente;
		this.runnableVolver = runnableVolver;
	}

	private void volverAction() {
		runnableVolver.run();
	}

	private void comprarVehiculoAction() {
		FXMLLoader loader = new FXMLLoader();
		loader.setController(new ComprarVehiculoClienteController(cliente, runnableVolver));
		loader.setLocation(getClass().getResource("../view/compraCliente.fxml"));
		try {
			contentPane.setCenter(loader.load());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void venderVehiculoAction() {
		FXMLLoader loader = new FXMLLoader();
		loader.setController(new VenderVehiculoClienteController(cliente, runnableVolver));
		loader.setLocation(getClass().getResource("../view/ventaCliente.fxml"));
		try {
			contentPane.setCenter(loader.load());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
