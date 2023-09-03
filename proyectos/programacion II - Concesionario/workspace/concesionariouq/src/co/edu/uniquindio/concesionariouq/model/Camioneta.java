package co.edu.uniquindio.concesionariouq.model;

import javafx.scene.image.Image;

public class Camioneta extends Sedan {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected Boolean es4x4;

	/**
	 * Es el constructor de la clase {@link Camioneta}
	 * 
	 * @param id
	 * @param marca
	 * @param modelo
	 * @param cilindraje
	 * @param velocidadMaxima
	 * @param combustible
	 * @param estado
	 * @param tipo
	 * @param numeroPasajeros
	 * @param numeroBolsasAire
	 * @param numeroPuertas
	 * @param tieneAireAcondicionado
	 * @param tieneCamaraReversa
	 * @param tieneABS
	 * @param capacidadMaletero
	 * @param tieneVelocidadCrucero
	 * @param tieneSensorColision
	 * @param tieneSensorTrafico
	 * @param tieneAsistentePermanencia
	 * @param es4x4
	 * @param imagen
	 */
	public Camioneta(String id, String marca, String modelo, Double cilindraje, Double velocidadMaxima,
			Combustible combustible, EstadoVehiculo estado, TipoCambio tipo, Integer numeroPasajeros,
			Integer numeroBolsasAire, Integer numeroPuertas, Boolean tieneAireAcondicionado, Boolean tieneCamaraReversa,
			Boolean tieneABS, Double capacidadMaletero, Boolean tieneVelocidadCrucero, Boolean tieneSensorColision,
			Boolean tieneSensorTrafico, Boolean tieneAsistentePermanencia, Boolean es4x4, Image imagen) {
		super(id, marca, modelo, cilindraje, velocidadMaxima, combustible, estado, tipo, numeroPasajeros,
				numeroBolsasAire, numeroPuertas, tieneAireAcondicionado, tieneCamaraReversa, tieneABS,
				capacidadMaletero, tieneVelocidadCrucero, tieneSensorColision, tieneSensorTrafico,
				tieneAsistentePermanencia, imagen);
		this.es4x4 = es4x4;
	}

	@Override
	public boolean atributosLlenos() {
		return super.atributosLlenos() && es4x4 != null;
	}

	/**
	 * Obtiene si la camioneta es 4x4 o no
	 * 
	 * @return
	 */
	public Boolean getEs4x4() {
		return es4x4;
	}

	/**
	 * Obtiene si la camioneta es 4x4 o no
	 * 
	 * @param
	 */
	public void setEs4x4(final Boolean es4x4) {
		this.es4x4 = es4x4;
	}

	@Override
	public TipoVehiculo getTipoVehiculo() {
		return TipoVehiculo.CAMIONETA;
	}

	@Override
	public String toString() {
		return String.format(
				"Camioneta [id=%s, marca=%s, modelo=%s, cilindraje=%s, velocidadMaxima=%s, combustible=%s, estado=%s, tipo=%s, numeroPasajeros=%s, numeroBolsasAire=%s, numeroPuertas=%s, tieneAireAcondicionado=%s, tieneCamaraReversa=%s, tieneABS=%s, capacidadMaletero=%s, tieneVelocidadCrucero=%s, tieneSensorColision=%s, tieneSensorTrafico=%s, tieneAsistentePermanencia=%s, es4x4=%s]",
				id, marca, modelo, cilindraje, velocidadMaxima, combustible, estado, tipo, numeroPasajeros,
				numeroBolsasAire, numeroPuertas, tieneAireAcondicionado, tieneCamaraReversa, tieneABS,
				capacidadMaletero, tieneVelocidadCrucero, tieneSensorColision, tieneSensorTrafico,
				tieneAsistentePermanencia, es4x4);
	}
}
