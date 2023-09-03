package co.edu.uniquindio.concesionariouq.view.menu;

import static co.edu.uniquindio.concesionariouq.util.Utility.generarHBox;

import co.edu.uniquindio.concesionariouq.util.PanelConVolver;
import co.edu.uniquindio.concesionariouq.util.Utility;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

public class PanelAgregarAdmin extends PanelConVolver{

	private VBox box;
	private TextField tfNombre;
	private TextField tfId;
	private TextField tfContrasena;
	private TextField tfEmail;

	@Override
	public void handle(MouseEvent event) {
		
	}

	@Override
	public void initComponents() {
		box = new VBox(20);
		tfNombre = new TextField();
		tfId = new TextField();
		tfContrasena = new TextField();
		tfEmail = new TextField();
		
		box.getChildren().add(generarHBox("Ingresa el nombre del Administrador", tfNombre));
		box.getChildren().add(generarHBox("Ingresa la identificacion del Administrador", tfId));
		box.getChildren().add(generarHBox("Ingresa la contraseña del Administrador", tfContrasena));
		box.getChildren().add(generarHBox("Ingresa el email del Administrador", tfEmail));
		
		Utility.setAsNumberTextfield(tfId);
		
		setCenter(box);
		box.setId("centered-box");
		
	}

}
