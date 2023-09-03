package co.edu.uniquindio.concesionariouq.view.principal;

import co.edu.uniquindio.concesionariouq.model.Usuario;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MenuPrincipalIzq extends BorderPane {
	private MenuComunicationListener comunicacion;

	public MenuPrincipalIzq(Stage stage, Usuario usuario, MenuComunicationListener comunicacion) {
		this.comunicacion = comunicacion;
		initComp();
	}

	private void initComp() {
		ScrollPane scroll = new ScrollPane(new MenuOpcionesIzq(comunicacion));
		scroll.setStyle("");
		setCenter(scroll);
	}

}
