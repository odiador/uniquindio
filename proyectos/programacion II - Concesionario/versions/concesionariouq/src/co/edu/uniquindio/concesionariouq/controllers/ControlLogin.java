package co.edu.uniquindio.concesionariouq.controllers;

import co.edu.uniquindio.concesionariouq.model.Concesionario;
import co.edu.uniquindio.concesionariouq.view.principal.EscenaPrincipal;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class ControlLogin {

	public static void entrar(Stage stage, String identificacion, String contrasena) {
		if (identificacion.isEmpty() || contrasena.isEmpty()) {
			new Alert(AlertType.ERROR, "Rellena todos los campos").show();
			return;
		}
		SerializedData data = new SerializedData();
		Concesionario concesionario = data.getConcesionario();
		stage.setScene(new EscenaPrincipal(stage, concesionario.buscarUsuario(identificacion, contrasena)));
	}

}
