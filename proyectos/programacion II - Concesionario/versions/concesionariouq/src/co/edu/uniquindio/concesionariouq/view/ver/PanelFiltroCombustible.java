package co.edu.uniquindio.concesionariouq.view.ver;

import co.edu.uniquindio.concesionariouq.controllers.ControlFiltroView;
import co.edu.uniquindio.concesionariouq.model.TipoFiltro;
import co.edu.uniquindio.concesionariouq.util.Boton;
import co.edu.uniquindio.concesionariouq.view.menu.TipoCombustible;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class PanelFiltroCombustible extends BorderPane {
	public PanelFiltroCombustible() {
		VBox vBox = new VBox(20);

		vBox.getChildren().add(new Boton("Filtrar Diesel", evt -> {
			ControlFiltroView.agregarFiltro(TipoFiltro.COMBUSTIBLE, TipoCombustible.DIESEL.getText());
		}));
		vBox.getChildren().add(new Boton("Filtrar Electricos", evt -> {
			ControlFiltroView.agregarFiltro(TipoFiltro.COMBUSTIBLE, TipoCombustible.ELECTRICO.getText());
		}));
		vBox.getChildren().add(new Boton("Filtrar Gasolina", evt -> {
			ControlFiltroView.agregarFiltro(TipoFiltro.COMBUSTIBLE, TipoCombustible.GASOLINA.getText());
		}));
		vBox.getChildren().add(new Boton("Filtrar Hibridos", evt -> {
			ControlFiltroView.agregarFiltro(TipoFiltro.COMBUSTIBLE, TipoCombustible.HIBRIDO.getText());
		}));
		vBox.setId("centered-box");
		setCenter(vBox);
	}

}
