package co.edu.uniquindio.concesionariouq.controllers;

import co.edu.uniquindio.concesionariouq.exceptions.CampoException;
import co.edu.uniquindio.concesionariouq.model.Combustible;
import co.edu.uniquindio.concesionariouq.model.Diesel;
import co.edu.uniquindio.concesionariouq.model.Electrico;
import co.edu.uniquindio.concesionariouq.model.Gasolina;
import co.edu.uniquindio.concesionariouq.model.Hibrido;
import co.edu.uniquindio.concesionariouq.util.PanelConVolver;
import co.edu.uniquindio.concesionariouq.view.menu.PanelCombustible;
import co.edu.uniquindio.concesionariouq.view.menu.TipoCombustible;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class ControlCombustible {
	public static void irACambiarCombustible(PanelConVolver panel, Combustible combustible,
			EventHandler<? super MouseEvent> event) {
		PanelConVolver panelConVolver = new PanelCombustible();
		panel.setCenter(panelConVolver);
	}

	public static void actualizarValorThrows(PanelCombustible panelCombustible, String valorNuevo)
			throws CampoException {
		TipoCombustible tipoCombustible = TipoCombustible.getTipo(valorNuevo);
		if (tipoCombustible == null) {
			throw new CampoException("Recuerda llenar todos los campos");
		}
		switch (tipoCombustible) {
		case ELECTRICO:
			panelCombustible.mostrarCamposElectricos();
			break;
		case HIBRIDO:
			panelCombustible.mostrarCamposHibridos();
			break;
		default:
			panelCombustible.comboInicial();
			break;
		}

	}

	public static void actualizarValor(PanelCombustible panelCombustible, String valorNuevo) {
		try {
			actualizarValorThrows(panelCombustible, valorNuevo);
		} catch (CampoException e) {

		}
	}

	public static Combustible obtenerCombustible(String tipoCombustibleString, String autonomiaElectricoString,
			String tiempoElectricoString, boolean esHibridoEnchufable, boolean esHibridoLigero) {
		TipoCombustible tipoCombustible = TipoCombustible.getTipo(tipoCombustibleString);
		if (tipoCombustible == null)
			return null;
		switch (tipoCombustible) {
		case DIESEL:
			return new Diesel();
		case ELECTRICO:
			double autonomia = Double.parseDouble(autonomiaElectricoString);
			double tiempo = Double.parseDouble(tiempoElectricoString);
			return new Electrico(autonomia, tiempo);
		case GASOLINA:
			return new Gasolina();
		case HIBRIDO:
			return new Hibrido(esHibridoEnchufable, esHibridoLigero);
		}
		return null;
	}
}
