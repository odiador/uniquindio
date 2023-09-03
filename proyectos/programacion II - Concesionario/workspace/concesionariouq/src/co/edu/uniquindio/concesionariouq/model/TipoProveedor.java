package co.edu.uniquindio.concesionariouq.model;

public enum TipoProveedor {
	CONCESIONARIO("Concesionario"), CLIENTE("Cliente");

	private final String text;

	private TipoProveedor(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}

	public static String[] textValues() {
		TipoProveedor[] values = values();
		String[] textValues = new String[values.length];
		for (int i = 0; i < values.length; i++)
			textValues[i] = values[i].getText();
		return textValues;
	}

	public static TipoProveedor of(String text) {
		TipoProveedor[] values = values();
		for (TipoProveedor tipoProveedor : values)
			if (tipoProveedor.getText().equals(text))
				return tipoProveedor;
		return null;
	}
}
