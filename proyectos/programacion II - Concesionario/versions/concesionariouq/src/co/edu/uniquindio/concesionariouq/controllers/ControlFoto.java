package co.edu.uniquindio.concesionariouq.controllers;

import java.io.File;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class ControlFoto {
	
	public static ImageView elegirFoto(Stage stage) {
		ImageView imagen = new ImageView();
		FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Imagenes (*.png, *.jpg)", "*.png", "*.jpg");
        fileChooser.getExtensionFilters().add(extFilter);
        File file = fileChooser.showOpenDialog(stage);
        if (file != null) {
            Image image = new Image(file.toURI().toString());
            imagen.setImage(image);
        }
		return imagen;
	}
}
