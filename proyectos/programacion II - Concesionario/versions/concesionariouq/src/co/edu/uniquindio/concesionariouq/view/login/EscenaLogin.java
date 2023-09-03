package co.edu.uniquindio.concesionariouq.view.login;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class EscenaLogin extends Scene {

	public EscenaLogin(Stage stage, double width, double height) {
		super(new PanelLogin(stage), width, height);
	}

}
