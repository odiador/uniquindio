package co.edu.uniquindio.concesionariouq.view.principal;

import co.edu.uniquindio.concesionariouq.controllers.ControlMenu;
import co.edu.uniquindio.concesionariouq.model.Usuario;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MenuPrincipal extends BorderPane {
	private MenuPrincipalIzq menuPrincipalIzq;
	private Stage stage;
	private Usuario usuario;

	public MenuPrincipal(Stage stage, Usuario usuario) {
		this.stage = stage;
		this.usuario = usuario;
		initComp();
	}

	private void initComp() {
		MenuComunicationListener listener = msg -> {
			ControlMenu.actualizarVista(this, usuario, msg);
		};
		menuPrincipalIzq = new MenuPrincipalIzq(stage, usuario, listener);
		setLeft(menuPrincipalIzq);
	}

	public Stage getStage() {
		return stage;
	}
}
