package co.edu.uniquindio.concesionariouq.util;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

public abstract class PanelConVolver extends BorderPane implements EventHandler<MouseEvent> {
	public PanelConVolver() {
		initComponents();
		setId("raiz");
	}

	public abstract void initComponents();
}
