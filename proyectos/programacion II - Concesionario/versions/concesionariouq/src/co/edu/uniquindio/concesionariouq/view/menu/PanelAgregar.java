package co.edu.uniquindio.concesionariouq.view.menu;

import static co.edu.uniquindio.concesionariouq.util.Utility.generarHBox;

import co.edu.uniquindio.concesionariouq.controllers.ControlAgregar;
import co.edu.uniquindio.concesionariouq.util.Boton;
import co.edu.uniquindio.concesionariouq.util.PanelConVolver;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

public class PanelAgregar extends PanelConVolver {

	@Override
	public void handle(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void initComponents() {
		VBox box = new VBox(20);
		Boton btUsuario = new Boton("Usuario", e -> ControlAgregar.irAgregarUsuario(this));
		Boton btVehiculo = new Boton("Vehiculo", e -> ControlAgregar.irAgregarVehiculo(this));
		
		box.getChildren().add(generarHBox("Ingresa la placa del vehiculo", btUsuario));
		box.getChildren().add(generarHBox("Ingresa la marca del vehiculo", btVehiculo));
		
		setCenter(box);
		box.setId("centered-box");

	}

}
