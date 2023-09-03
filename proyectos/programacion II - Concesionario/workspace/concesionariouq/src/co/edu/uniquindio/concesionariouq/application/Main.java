package co.edu.uniquindio.concesionariouq.application;

import co.edu.uniquindio.concesionariouq.controllers.MainControlller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("../view/main.fxml"));
			loader.setController(new MainControlller());
			Scene scene = new Scene(loader.load(), 1000, 600);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Carro UQ");
			primaryStage.getIcons().add(new Image("/resources/images/Logo Window.png"));
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

}
