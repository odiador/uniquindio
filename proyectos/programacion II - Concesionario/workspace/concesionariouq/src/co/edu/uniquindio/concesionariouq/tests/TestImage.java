package co.edu.uniquindio.concesionariouq.tests;

import java.io.File;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.*;

public class TestImage extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		final FileChooser fileChooser = new FileChooser();
		File file = fileChooser.showOpenDialog(stage);
		if (file != null) {
			// openFile(file);

			// where my problem is
			Image image1 = new Image(file.toURI().toString());
			// what I tried to do
			// Image image1 = new Image(file);
			ImageView ip = new ImageView(image1);
			VBox root = new VBox();
			root.getChildren().add(ip);
			stage.setScene(new Scene(root, 500, 400));
			stage.show();
		}

	}

	public static void main(String[] args) {
		launch();
	}

}
