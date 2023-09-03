package co.edu.uniquindio.concesionariouq.model;

import java.util.Arrays;
import java.util.List;

public enum TipoCombustible {
	ELECTRICO("Electrico"), GASOLINA("Gasolina"), HIBRIDO("Hibrido"), DIESEL("Diesel");

	private String text;

	private TipoCombustible(String text) {
		this.text = text;
	}

	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * Obtiene el arreglo de textos de las opciones disponibles del tipo de
	 * combustible
	 * 
	 * @return
	 */
	public static String[] getTextValues() {
		TipoCombustible[] values = values();
		String[] textValues = new String[values.length];
		for (int i = 0; i < values.length; i++)
			textValues[i] = values[i].getText();
		return textValues;
	}

	/**
	 * Obtiene el tipo de combustible a partir del texto que se manda {@code text}
	 * 
	 * @param text
	 * @return
	 */
	public static TipoCombustible of(String text) {
		TipoCombustible[] values = values();
		for (TipoCombustible tipoCombustible : values)
			if (tipoCombustible.getText().equals(text))
				return tipoCombustible;
		return null;
	}
	
	/**
	 * Retorna una lista con cada uno de los tipos de gasofa.
	 * @return
	 */
	public static List<TipoCombustible> getValues(){
		List<TipoCombustible> lista = Arrays.asList(values());
		return lista;
	}
}
