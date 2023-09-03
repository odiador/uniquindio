package co.edu.uniquindio.concesionariouq.model;

public enum TipoTransaccion {
	VENTA("Venta"), COMPRA("Compra"), ALQUILER("Alquiler");

	private final String text;

	/**
	 * Es el constructor de {@link TipoTransaccion}
	 * 
	 * @param text
	 */
	private TipoTransaccion(String text) {
		this.text = text;
	}

	/**
	 * Obtiene el texto correspondiente al tipo de usuario
	 * 
	 * @return
	 */
	public String getText() {
		return text;
	}

	/**
	 * Obtiene los valores de los tipos de usuarios
	 * 
	 * @return
	 */
	public static String[] textValues() {
		TipoTransaccion[] values = values();
		String[] textValues = new String[values.length];
		for (int i = 0; i < values.length; i++)
			textValues[i] = values[i].getText();
		return textValues;
	}

	public static TipoTransaccion of(String text) {
		TipoTransaccion[] values = values();
		for (TipoTransaccion tipoUsuario : values)
			if (tipoUsuario.getText().equals(text))
				return tipoUsuario;
		return null;
	}
}
