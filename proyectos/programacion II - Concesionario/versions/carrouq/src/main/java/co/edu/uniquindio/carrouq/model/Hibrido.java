package co.edu.uniquindio.carrouq.model;

public class Hibrido extends Combustible {

	private Boolean esEnchufable;
	private Boolean esHibridoLigero;

	/**
	 * 
	 * @param esEnchufable
	 * @param esHibridoLigero
	 */
	public Hibrido(final Boolean esEnchufable, final Boolean esHibridoLigero) {
		this.esHibridoLigero = esHibridoLigero;
		this.esEnchufable = esEnchufable;
	}

	/**
	 * 
	 * @return
	 */
	public Boolean getEsHibridoLigero() {
		return esHibridoLigero;
	}

	/**
	 * 
	 * @param esHibridoLigero
	 */
	public void setHibridoLigero(final Boolean esHibridoLigero) {
		this.esHibridoLigero = esHibridoLigero;
	}

	/**
	 * 
	 * @return
	 */
	public Boolean getEsEnchufable() {
		return esEnchufable;
	}

	/**
	 * 
	 * @param esEnchufable
	 */
	public void setEsEnchufable(final Boolean esEnchufable) {
		this.esEnchufable = esEnchufable;
	}
}