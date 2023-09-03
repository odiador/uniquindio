package co.edu.uniquindio.concesionariouq.model;

public enum TipoCambio {
	MANUAL("Manual"), AUTOMATICO("Automatico");

	private String text;

	private TipoCambio(String text) {
		this.text = text;

	}

	public String getText() {
		return text;
	}

	/**
	 * Obtiene el arreglo de textos de las opciones disponibles del tipo de cambio
	 * de vehiculo
	 * 
	 * @return
	 */
	public static String[] getTextValues() {
		TipoCambio[] arr = TipoCambio.values();
		String[] arrTexts = new String[arr.length];
		for (int i = 0; i < arr.length; i++) {
			arrTexts[i] = arr[i].getText();
		}
		return arrTexts;
	}

	/**
	 * Obtiene el tipo de cambio del vehiculo a partir del texto que se manda
	 * {@code texto}
	 * 
	 * @param texto
	 * @return
	 */
	public static TipoCambio obtenerEstadoTexto(String texto) {
		TipoCambio[] arr = TipoCambio.values();
		for (TipoCambio tipoCambio : arr)
			if (tipoCambio.getText().equals(texto))
				return tipoCambio;

		return null;

	}
}