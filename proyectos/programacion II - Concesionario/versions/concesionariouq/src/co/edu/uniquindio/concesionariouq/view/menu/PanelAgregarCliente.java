package co.edu.uniquindio.concesionariouq.view.menu;

import static co.edu.uniquindio.concesionariouq.util.Utility.generarHBox;

import co.edu.uniquindio.concesionariouq.controllers.ControlUsuarios;
import co.edu.uniquindio.concesionariouq.util.PanelConVolver;
import co.edu.uniquindio.concesionariouq.util.Utility;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

public class PanelAgregarCliente extends PanelConVolver {

	private VBox box;
	private TextField tfNombre;
	private TextField tfId;
	private TextField tfContrasena;
	private TextField tfEmail;

	@Override
	public void handle(MouseEvent event) {
		ControlUsuarios.agregarCliente(tfId.getText().trim(), tfNombre.getText().trim(), tfContrasena.getText().trim(), tfEmail.getText().trim());
	}

	@Override
	public void initComponents() {
		box = new VBox(20);
		tfNombre = new TextField();
		tfId = new TextField();
		tfContrasena = new TextField();
		tfEmail = new TextField();
		
		box.getChildren().add(generarHBox("Ingresa el nombre del cliente", tfNombre));
		box.getChildren().add(generarHBox("Ingresa la identificacion del cliente", tfId));
		box.getChildren().add(generarHBox("Ingresa la contraseña del cliente", tfContrasena));
		box.getChildren().add(generarHBox("Ingresa el email del cliente", tfEmail));
		
		Utility.setAsNumberTextfield(tfId);
		
		setCenter(box);
		box.setId("centered-box");
		
	}

	

}
