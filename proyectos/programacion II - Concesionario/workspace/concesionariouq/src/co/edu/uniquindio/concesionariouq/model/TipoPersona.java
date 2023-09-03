package co.edu.uniquindio.concesionariouq.model;

public enum TipoPersona {
	CLIENTE("Cliente"), EMPLEADO("Empleado"), ADMIN("Administrador");

	private final String text;

	/**
	 * Es el constructor de {@link TipoPersona}
	 * 
	 * @param text
	 */
	private TipoPersona(String text) {
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
		TipoPersona[] values = values();
		String[] textValues = new String[values.length];
		for (int i = 0; i < values.length; i++)
			textValues[i] = values[i].getText();
		return textValues;
	}

	public static TipoPersona of(String text) {
		TipoPersona[] values = values();
		for (TipoPersona tipoUsuario : values)
			if (tipoUsuario.getText().equals(text))
				return tipoUsuario;
		return null;
	}
}
