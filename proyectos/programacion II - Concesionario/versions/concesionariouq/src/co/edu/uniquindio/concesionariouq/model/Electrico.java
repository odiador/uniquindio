package co.edu.uniquindio.concesionariouq.model;

public class Electrico extends Combustible {
	private Double autonomiaCargaCompleta;
	private Double tiempoDemoraCarga;

	/**
	 * Este es el constructor principal de la clase
	 * 
	 * @param autonomiaCargaCompleta
	 * @param tiempoDemoraCarga
	 */
	public Electrico(final Double autonomiaCargaCompleta, final Double tiempoDemoraCarga) {
		this.autonomiaCargaCompleta = autonomiaCargaCompleta;
		this.tiempoDemoraCarga = tiempoDemoraCarga;
	}

	/**
	 * Cambia la automonia de carga completa
	 * 
	 * @param autonomiaCargaCompleta
	 */
	public void setAutonomiaCargaCompleta(final Double autonomiaCargaCompleta) {
		this.autonomiaCargaCompleta = autonomiaCargaCompleta;
	}

	/**
	 * Obtiene la automonia de carga completa
	 * 
	 * @return autonomiaCargaCompleta
	 */
	public Double getAutonomiaCargaCompleta() {
		return autonomiaCargaCompleta;
	}

	/**
	 * Cambia el tiempo de demora de carga del electrico
	 * 
	 * @param tiempoDemoraCarga
	 */
	public void setTiempoDemoraCarga(final Double tiempoDemoraCarga) {
		this.tiempoDemoraCarga = tiempoDemoraCarga;
	}

	/**
	 * Obtiene el tiempo de demora de carga del electrico
	 * 
	 * @return tiempoDemoraCarga
	 */
	public Double getTiempoDemoraCarga() {
		return tiempoDemoraCarga;
	}

}