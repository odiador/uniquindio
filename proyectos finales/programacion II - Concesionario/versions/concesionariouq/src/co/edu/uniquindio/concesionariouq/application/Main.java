package co.edu.uniquindio.concesionariouq.application;

import co.edu.uniquindio.concesionariouq.model.UsuarioRoot;
import co.edu.uniquindio.concesionariouq.view.login.EscenaLogin;
import co.edu.uniquindio.concesionariouq.view.principal.EscenaPrincipal;
import co.edu.uniquindio.concesionariouq.view.ver.PanelVerVehiculos;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Scene escenaLogin = new EscenaLogin(primaryStage, 440, 440);

			Scene escenaPrincipal = new EscenaPrincipal(primaryStage, UsuarioRoot.adminAmador());

			Scene escenaTabla = new Scene(new PanelVerVehiculos(), 800, 600);

			escenaLogin.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			escenaPrincipal.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			escenaTabla.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

			primaryStage.setScene(escenaPrincipal);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

}
