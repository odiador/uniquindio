package co.edu.uniquindio.concesionariouq.view.menu;

public enum TipoCombustible {
	GASOLINA("Gasolina"), ELECTRICO("Electrico"), DIESEL("Diesel"), HIBRIDO("Hibrido");
	
	private final String text;
	
	private TipoCombustible(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}
	
	public static String[] getTextValues() {
		String [] ar = new String[values().length];
		TipoCombustible[] values = values();
		for (int i = 0; i < values.length; i++) {
			ar[i] = values[i].getText();
		} return ar;
	}
	
	public static TipoCombustible getTipo(String text) {
		for(TipoCombustible tipo : values()) {
			if(tipo.getText().equals(text)) return tipo;
		}
		return null;
	}
}
