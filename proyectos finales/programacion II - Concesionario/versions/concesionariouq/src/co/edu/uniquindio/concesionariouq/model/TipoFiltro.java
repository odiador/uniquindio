package co.edu.uniquindio.concesionariouq.model;

public enum TipoFiltro {
	COMBUSTIBLE("Combustible"), TIPO_VEHICULO("Tipo Vehiculo"), ESTADO_VEHICULO("Estado");

	private String text;

	private TipoFiltro(String text) {
		this.text = text;

	}

	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * Obtiene los valores del texto de los tipos de filtros
	 * 
	 * @return
	 */
	public static String[] textValues() {
		TipoFiltro[] values = values();
		String[] textValues = new String[values.length];
		for (int i = 0; i < values.length; i++)
			textValues[i] = values[i].getText();
		return textValues;
	}

	public static TipoFiltro obtenerFiltroTexto(String text) {
		TipoFiltro[] values = values();
		for (TipoFiltro tipoFiltro : values)
			if (tipoFiltro.getText().equals(text))
				return tipoFiltro;

		return null;
	}
}
