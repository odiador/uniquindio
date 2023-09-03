package co.edu.uniquindio.concesionariouq.model;

public class Electrico extends Combustible {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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

	@Override
	public boolean atributosLlenos() {
		return autonomiaCargaCompleta != null && tiempoDemoraCarga != null;
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

	@Override
	public TipoCombustible getTipoCombustible() {
		return TipoCombustible.ELECTRICO;
	}

	@Override
	public String toString() {
		return String.format("Electrico [autonomiaCargaCompleta=%s, tiempoDemoraCarga=%s]", autonomiaCargaCompleta,
				tiempoDemoraCarga);
	}

}