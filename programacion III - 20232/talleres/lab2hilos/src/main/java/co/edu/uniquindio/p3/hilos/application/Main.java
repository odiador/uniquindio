package co.edu.uniquindio.p3.hilos.application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) {
		stage.setScene(new Scene(loadFXML("matriz")));
		stage.show();
	}

	public static Parent loadFXML(String fxml) {
		FXMLLoader fxmlLoader = new FXMLLoader(
				Main.class.getResource("/fxml/" + fxml + ".fxml"));
		try {
			return fxmlLoader.load();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

}