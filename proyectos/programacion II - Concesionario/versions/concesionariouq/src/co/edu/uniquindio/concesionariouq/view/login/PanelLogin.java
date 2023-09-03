package co.edu.uniquindio.concesionariouq.view.login;

import co.edu.uniquindio.concesionariouq.controllers.ControlLogin;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PanelLogin extends BorderPane {
	private Stage stage;

	public PanelLogin(Stage stage) {
		this.stage = stage;
		initComp();
	}

	private void initComp() {
		VBox box = new VBox(20);
		TextField tfIdentificacion = new TextField("");
		PasswordField tfContrasena = new PasswordField();
		Label btnEntrar = new Label("Entrar");
		Label btnOlvidaste = new Label("¿Olvidaste tu contraseña?");

		box.getChildren().add(UtilPane.generarHBox("Escribe tu identificación:", tfIdentificacion));
		box.getChildren().add(UtilPane.generarHBox("Escribe tu contraseña:", tfContrasena));
		box.getChildren().add(btnEntrar);
		box.getChildren().add(btnOlvidaste);
		setCenter(box);
		
		btnEntrar.setStyle("-fx-text-fill: red;");
		btnEntrar.setOnMouseReleased(
				e -> ControlLogin.entrar(stage, tfIdentificacion.getText(), tfContrasena.getText()));
	}
}
