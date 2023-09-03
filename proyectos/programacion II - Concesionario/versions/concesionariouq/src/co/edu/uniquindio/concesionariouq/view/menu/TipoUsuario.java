package co.edu.uniquindio.concesionariouq.view.menu;

public enum TipoUsuario {
	ADMIN("Admin"), EMPLEADO("Empleado"), CLIENTE("Cliente");
	
	final String text;
	
	private TipoUsuario(String text) {
		this.text = text;
	}
	
	/**
	 * Obtiene una lista con los valores que puede tener el tipo del vehiculo
	 * 
	 * @return tipos
	 */
	public static String[] tipoValues() {
		TipoUsuario[] arr = TipoUsuario.values();
		String[] tipos = new String[arr.length];
		for (int i = 0; i < arr.length; i++)
			tipos[i] = arr[i].getText();
		return tipos;
	}

	/**
	 * Obtiene el tipo de usuario
	 * 
	 * @return tipo
	 */
	public String getText() {
		return text;
	}

	/**
	 * Obtiene un valor de la lista con los valores que puede tener el tipo de usuario
	 * 
	 * @param tipo
	 * @return
	 */
	public static TipoUsuario obtenerValorTipo(String tipo) {
		TipoUsuario[] arr = TipoUsuario.values();
		for (TipoUsuario tipoUsuario : arr)
			if (tipoUsuario.getText().equals(tipo))
				return tipoUsuario;

		return null;
	}
}
