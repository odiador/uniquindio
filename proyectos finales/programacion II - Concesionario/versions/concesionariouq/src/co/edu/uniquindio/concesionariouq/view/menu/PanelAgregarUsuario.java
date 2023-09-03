package co.edu.uniquindio.concesionariouq.view.menu;

import co.edu.uniquindio.concesionariouq.controllers.ControlUsuarios;
import co.edu.uniquindio.concesionariouq.util.Boton;
import co.edu.uniquindio.concesionariouq.util.PanelConVolver;
import co.edu.uniquindio.concesionariouq.view.login.UtilPane;
import javafx.collections.FXCollections;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PanelAgregarUsuario extends PanelConVolver{

	@Override
	public void handle(MouseEvent event) {
		
	}

	@Override
	public void initComponents() {
		VBox box = new VBox(20);
		ComboBox<String> comboTipoUsuario = new ComboBox<String>();
		comboTipoUsuario.setItems(FXCollections.observableArrayList(TipoUsuario.tipoValues()));
		box.getChildren().add(UtilPane.generarHBox("Elige el tipo de usuario", comboTipoUsuario));
		Boton botonAgregar = new Boton("Agregar", evento -> {
			ControlUsuarios.irAgregarUsuario(this, comboTipoUsuario.getValue(), e -> {
				initComponents();
				((Stage) getScene().getWindow()).setTitle("Agregar Usuario | Concesionario UQ");
			});
		});
		box.setId("centered-box");
		setBottom(botonAgregar);
		this.setCenter(box);
		
	}

}
