package co.edu.uniquindio.concesionariouq.model;

public enum TipoVehiculo {
	// TIPOS DE VEHICULO

	BUS("Bus"), CAMION("Camion"), CAMIONETA("Camioneta"), DEPORTIVO("Deportivo"), MOTO("Moto"), PICKUP("PickUp"),
	SEDAN("Sedan"), VAN("Van");

	private final String tipo;

	private TipoVehiculo(String tipo) {
		this.tipo = tipo;
	}

	/**
	 * Obtiene una lista con los valores que puede tener el tipo del vehiculo
	 * 
	 * @return tipos
	 */
	public static String[] tipoValues() {
		TipoVehiculo[] arr = TipoVehiculo.values();
		String[] tipos = new String[arr.length];
		for (int i = 0; i < arr.length; i++)
			tipos[i] = arr[i].getTipo();
		return tipos;
	}

	/**
	 * Obtiene el tipo del vehiculo
	 * 
	 * @return tipo
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * Obtiene un valor de la lista con los valores que puede tener el tipo del
	 * vehiculo
	 * 
	 * @param tipo
	 * @return
	 */
	public static TipoVehiculo obtenerValorTipo(String tipo) {
		TipoVehiculo[] arr = TipoVehiculo.values();
		for (TipoVehiculo tipoVehiculo : arr)
			if (tipoVehiculo.getTipo().equals(tipo))
				return tipoVehiculo;

		return null;
	}

}
