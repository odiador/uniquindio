package co.edu.uniquindio.p2.agentatelefonica.model;

public enum CategoriaGrupo {
	OFICINA("Oficina"), FIESTA("Fiesta"), AMIGOS("Amigos"), FAMILIA("Familia");

	private String nombre;

	private CategoriaGrupo(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	/**
	 * Obtiene el arreglo de los valores de los nombres de la categoria del grupo
	 *
	 * @return
	 */
	public static String[] textValues() {
		CategoriaGrupo[] values = CategoriaGrupo.values();
		String[] textValues = new String[values.length];
		for (int i = 0; i < values.length; i++)
			textValues[i] = values[i].getNombre();
		return textValues;
	}

	/**
	 * Obtiene la categoria del grupo a partir de su nombre, si no se encuentra se
	 * retorna un null
	 *
	 * @param nombre
	 * @return
	 */
	public static CategoriaGrupo obtenerCategoriaDeNombre(String nombre) {
		CategoriaGrupo[] values = CategoriaGrupo.values();
		for (CategoriaGrupo categoria : values)
			if (categoria.getNombre().equals(nombre))
				return categoria;
		return null;
	}
}
