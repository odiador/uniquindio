package co.edu.uniquindio.concesionariouq.view.menu;

public enum TipoAgregacion {
	VEHICULO("Vehiculo"), USUARIO("Usuario");
	
	final String text;
	
	private TipoAgregacion(String text) {
		this.text = text;
	}
	
	/**
	 * Obtiene una lista con los valores que puede tener el tipo del vehiculo
	 * 
	 * @return tipos
	 */
	public static String[] tipoValues() {
		TipoAgregacion[] arr = TipoAgregacion.values();
		String[] tipos = new String[arr.length];
		for (int i = 0; i < arr.length; i++)
			tipos[i] = arr[i].getText();
		return tipos;
	}

	/**
	 * Obtiene el tipo de agregacion
	 * 
	 * @return tipo
	 */
	public String getText() {
		return text;
	}

	/**
	 * Obtiene un valor de la lista con los valores que puede tener el tipo de agregacion
	 * 
	 * @param tipo
	 * @return
	 */
	public static TipoAgregacion obtenerValorTipo(String tipo) {
		TipoAgregacion[] arr = TipoAgregacion.values();
		for (TipoAgregacion tipoVehiculo : arr)
			if (tipoVehiculo.getText().equals(tipo))
				return tipoVehiculo;

		return null;
	}
}
