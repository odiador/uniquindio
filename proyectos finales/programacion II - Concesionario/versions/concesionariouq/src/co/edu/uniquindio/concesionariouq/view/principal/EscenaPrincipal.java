package co.edu.uniquindio.concesionariouq.view.principal;

import co.edu.uniquindio.concesionariouq.model.Usuario;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class EscenaPrincipal extends Scene {

	public EscenaPrincipal(Stage stage, Usuario usuario) {
		super(new MenuPrincipal(stage, usuario), 600, 500);

	}

}
