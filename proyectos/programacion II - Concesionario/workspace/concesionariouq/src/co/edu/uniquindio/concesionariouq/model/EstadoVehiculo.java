package co.edu.uniquindio.concesionariouq.model;

import java.util.Arrays;
import java.util.List;

public enum EstadoVehiculo {
	NUEVO("Nuevo"), USADO("Usado");

	private String text;

	private EstadoVehiculo(String text) {
		this.text = text;

	}

	public String getText() {
		return text;
	}

	/**
	 * Obtiene el arreglo de textos de las opciones disponibles del estado de
	 * vehiculo
	 * 
	 * @return
	 */
	public static String[] getTextValues() {
		EstadoVehiculo[] arr = EstadoVehiculo.values();
		String[] arrTexts = new String[arr.length];
		for (int i = 0; i < arr.length; i++) {
			arrTexts[i] = arr[i].getText();
		}
		return arrTexts;
	}

	/**
	 * Obtiene el estado del vehiculo a partir del texto que se manda {@code texto}
	 * 
	 * @param texto
	 * @return
	 */
	public static EstadoVehiculo obtenerEstadoTexto(String texto) {
		EstadoVehiculo[] arr = EstadoVehiculo.values();
		for (EstadoVehiculo estadoVehiculo : arr)
			if (estadoVehiculo.getText().equals(texto))
				return estadoVehiculo;

		return null;

	}
	
	/**
	 * Retorna una lista con cada uno de los tipos de estado.
	 * @return
	 */
	public static List<EstadoVehiculo> getValues(){
		List<EstadoVehiculo> lista = Arrays.asList(values());
		return lista;
	}
}
