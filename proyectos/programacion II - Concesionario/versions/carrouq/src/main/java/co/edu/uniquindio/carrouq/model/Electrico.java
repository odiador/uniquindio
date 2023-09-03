package co.edu.uniquindio.carrouq.model;

public class Electrico extends Combustible {
	private Double autonomiaCargaCompleta;
	private Double tiempoDemoraCarga;

	/**
	 * 
	 * @param autonomiaCargaCompleta
	 * @param tiempoDemoraCarga
	 */
	public Electrico(final Double autonomiaCargaCompleta, final Double tiempoDemoraCarga) {
		this.autonomiaCargaCompleta = autonomiaCargaCompleta;
		this.tiempoDemoraCarga = tiempoDemoraCarga;
	}

	/**
	 * 
	 * @param autonomiaCargaCompleta
	 */
	public void setAutonomiaCargaCompleta(final Double autonomiaCargaCompleta) {
		this.autonomiaCargaCompleta = autonomiaCargaCompleta;
	}

	/**
	 * 
	 * @return
	 */
	public Double getAutonomiaCargaCompleta() {
		return autonomiaCargaCompleta;
	}

	/**
	 * 
	 * @param tiempoDemoraCarga
	 */
	public void setTiempoDemoraCarga(final Double tiempoDemoraCarga) {
		this.tiempoDemoraCarga = tiempoDemoraCarga;
	}

	/**
	 * 
	 * @return
	 */
	public Double getTiempoDemoraCarga() {
		return tiempoDemoraCarga;
	}

}