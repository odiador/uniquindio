package co.edu.uniquindio.concesionariouq.model;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.Serializable;

import javax.imageio.ImageIO;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;

public abstract class Vehiculo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected String id;
	protected String marca;
	protected String modelo;
	protected Double cilindraje;
	protected Double velocidadMaxima;
	protected Combustible combustible;
	protected EstadoVehiculo estado;
	protected TipoCambio tipo;
	private byte[] imagenData;

	/**
	 * Es el constructor de la clase {@link Vehiculo}
	 * 
	 * @param marca
	 * @param modelo
	 * @param cilindraje
	 * @param velocidadMaxima
	 * @param combustible
	 * @param estado
	 * @param tipo
	 */
	public Vehiculo(String id, String marca, String modelo, Double cilindraje, Double velocidadMaxima,
			Combustible combustible, EstadoVehiculo estado, TipoCambio tipo, Image imagen) {
		this.id = id;
		this.marca = marca;
		this.modelo = modelo;
		this.cilindraje = cilindraje;
		this.velocidadMaxima = velocidadMaxima;
		this.combustible = combustible;
		this.estado = estado;
		this.tipo = tipo;
		this.imagenData = getByteArrayImg(imagen);
	}

	public Image getImagen() {
		ByteArrayInputStream bais = new ByteArrayInputStream(imagenData);
		return new Image(bais);
	}

	private byte[] getByteArrayImg(Image imagen) {
		try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
			ImageIO.write(SwingFXUtils.fromFXImage(imagen, null), "png", baos);
			return baos.toByteArray();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean tieneId(String id) {
		return this.id.equals(id);
	}

	/**
	 * Determina si el cilindraje esta en un rango determinado
	 * 
	 * @param min
	 * @param max
	 * @return
	 */
	public boolean cilindrajeEnRango(double min, double max) {
		return cilindrajeMayorQue(min) && cilindrajeMenorQue(max);
	}

	/**
	 * Determina si el cilindraje es mayor a un rango determinado
	 * 
	 * @param val
	 * @return
	 */
	public boolean cilindrajeMayorQue(double val) {
		return cilindraje > val;
	}

	/**
	 * Determina si el cilindraje es menor a un rango determinado
	 * 
	 * @param val
	 * @return
	 */
	public boolean cilindrajeMenorQue(double val) {
		return cilindraje < val;
	}

	/**
	 * Determina si la velocidad maxima esta en un rango determinado
	 * 
	 * @param min
	 * @param max
	 * @return
	 */
	public boolean velocidadMaximaRango(double min, double max) {
		return velocidadMaximaMayorQue(min) && velocidadMaximaMenorQue(max);
	}

	/**
	 * Determina si la velocidad maxima es menor que un valor
	 * 
	 * @param val
	 * @return
	 */
	public boolean velocidadMaximaMenorQue(double val) {
		return velocidadMaxima < val;
	}

	/**
	 * Determina si la velocidad maxima es mayor que un valor
	 * 
	 * @param val
	 * @return
	 */
	public boolean velocidadMaximaMayorQue(double val) {
		return velocidadMaxima > val;
	}

	public boolean tieneCombustible(TipoCombustible tipoCombustible) {
		return combustible.getTipoCombustible() == tipoCombustible;
	}

	public abstract TipoVehiculo getTipoVehiculo();

	public boolean atributosLlenos() {
		return marca != null && modelo != null && cilindraje != null && velocidadMaxima != null && combustible != null
				&& estado != null && tipo != null && imagenData != null && !(marca.isEmpty() || modelo.isEmpty());
	}

	/**
	 * Obtiene la identificacion del vehiculo
	 * 
	 * @return
	 */
	public String getId() {
		return id;
	}

	/**
	 * Cambia la identificacion del vehiculo
	 * 
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Obtiene la marca del vehiculo
	 * 
	 * @return marca
	 */
	public String getMarca() {
		return marca;
	}

	/**
	 * Cambia la marca de vehiculo
	 * 
	 * @param marca
	 */
	public void setMarca(final String marca) {
		this.marca = marca;
	}

	/**
	 * Obtiene el modelo del vehiculo
	 * 
	 * @return modelo
	 */
	public String getModelo() {
		return modelo;
	}

	/**
	 * Cambia el modelo del vehiculo
	 * 
	 * @param modelo
	 */
	public void setModelo(final String modelo) {
		this.modelo = modelo;
	}

	/**
	 * Obtiene el cilindraje del vehiculo
	 * 
	 * @return cilindraje
	 */
	public Double getCilindraje() {
		return cilindraje;
	}

	/**
	 * Cambia el cilindraje del vehiculo
	 * 
	 * @param cilindraje
	 */
	public void setCilindraje(final Double cilindraje) {
		this.cilindraje = cilindraje;
	}

	/**
	 * Obtiene la velocidad maxima del vehiclo
	 * 
	 * @return velocidadMaxima
	 */
	public Double getVelocidadMaxima() {
		return velocidadMaxima;
	}

	/**
	 * Cambia la velocidad maxima del vehiculo
	 * 
	 * @param velocidadMaxima
	 */
	public void setVelocidadMaxima(final Double velocidadMaxima) {
		this.velocidadMaxima = velocidadMaxima;
	}

	/**
	 * Obtiene el combustible del vehiculo
	 * 
	 * @return combustible
	 */
	public Combustible getCombustible() {
		return combustible;
	}

	/**
	 * Cambia el tipo de combustible del vehiculo
	 * 
	 * @param combustible
	 */
	public void setCombustible(final Combustible combustible) {
		this.combustible = combustible;
	}

	/**
	 * Obtiene el estado del vehiculo
	 * 
	 * @return estado
	 */
	public EstadoVehiculo getEstado() {
		return estado;
	}

	/**
	 * Cambia el estado del vehiculo
	 * 
	 * @param estado
	 */
	public void setEstado(final EstadoVehiculo estado) {
		this.estado = estado;
	}

	/**
	 * Obtiene el tipo de vehiculo
	 * 
	 * @return tipo
	 */
	public TipoCambio getTipo() {
		return tipo;
	}

	/**
	 * Cambia el tipo de vehiculo
	 * 
	 * @param tipo
	 */
	public void setTipo(final TipoCambio tipo) {
		this.tipo = tipo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehiculo other = (Vehiculo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format(
				"Vehiculo [id=%s, marca=%s, modelo=%s, cilindraje=%s, velocidadMaxima=%s, combustible=%s, estado=%s, tipo=%s]",
				id, marca, modelo, cilindraje, velocidadMaxima, combustible, estado, tipo);
	}

}