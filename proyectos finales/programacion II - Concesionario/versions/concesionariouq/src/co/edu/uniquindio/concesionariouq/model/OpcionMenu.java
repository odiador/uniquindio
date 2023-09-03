package co.edu.uniquindio.concesionariouq.model;

public enum OpcionMenu {
	AGREGAR("Agregar", 1),
	COMPRAR_VEHICULO("Comprar Vehiculo", 2), ALQUILAR_VEHICULO("Alquilar Vehiculo", 3),
	ELIMINAR_CLIENTE("Eliminar cliente", 4), ELIMINAR_VEHICULO("Eliminar Vehiculo", 5),
	ACTUALIZAR_VEHICULO("Actualizar Vehiculo", 6), ACTUALIZAR_CLIENTE("Actualizar Vliente", 7),
	VENDER_VEHICULO("Vender Vehiculo", 8), GENERAR_REPORTE("Generar Reporte", 9),
	ACTUALIZAR_INFO("Actualizar Info", 10), CAMBIAR_CONTRASENA("Cambiar Contraseña", 11),
	ESTAS_BLOQUEADO("Estas bloqueado", 12), ACERCA_DE("Acerca de", 13);

	private String text;
	private int orden;

	private OpcionMenu(String text, int orden) {
		this.text = text;
		this.orden = orden;
	}

	public String getText() {
		return text;
	}

	public int getOrden() {
		return orden;
	}

	public int compararPorPrioridad(OpcionMenu opt) {
		return orden - opt.orden;
	}

	public static OpcionMenu obtenerValorOpcion(String text) {
		OpcionMenu[] arr = OpcionMenu.values();
		for (OpcionMenu opcionesMenu : arr)
			if (opcionesMenu.getText().equals(text))
				return opcionesMenu;

		return null;
	}
}
