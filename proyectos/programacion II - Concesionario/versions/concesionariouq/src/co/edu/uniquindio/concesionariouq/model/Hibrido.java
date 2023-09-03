package co.edu.uniquindio.concesionariouq.model;

public class Hibrido extends Combustible {

	//ATRIBUTOS
	private Boolean esEnchufable;
	private Boolean esHibridoLigero;

	/**
	 * Este es el constructor principal de la clase
	 * 
	 * @param esEnchufable
	 * @param esHibridoLigero
	 */
	public Hibrido(final Boolean esEnchufable, final Boolean esHibridoLigero) {
		this.esHibridoLigero = esHibridoLigero;
		this.esEnchufable = esEnchufable;
	}

	/**
	 * Obtiene la opcion si el hibrido es ligero o no lo es
	 * 
	 * @return esHibridoLigero
	 */
	public Boolean getEsHibridoLigero() {
		return esHibridoLigero;
	}

	/**
	 * Cambia la opcion si el hibrido es ligero o no lo es 
	 * 
	 * @param esHibridoLigero
	 */
	public void setHibridoLigero(final Boolean esHibridoLigero) {
		this.esHibridoLigero = esHibridoLigero;
	}

	/**
	 * Obtiene la opcion si el hibrido es enchufable o no
	 * 
	 * @return esEnchufable
	 */
	public Boolean getEsEnchufable() {
		return esEnchufable;
	}

	/**
	 * Cambia la opcion si el hibrido es enchufable o no
	 * 
	 * @param esEnchufable
	 */
	public void setEsEnchufable(final Boolean esEnchufable) {
		this.esEnchufable = esEnchufable;
	}
}