package co.edu.uniquindio.concesionariouq.model;

public class Compra extends Transaccion {

	private Proveedor proveedor;

	/**
	 * Es el constructor de la clase {@link Compra}
	 * 
	 * @param vehiculo
	 * @param valor
	 * @param proveedor
	 */
	public Compra(Vehiculo vehiculo, Double valor, Proveedor proveedor) {
		super(vehiculo, valor);
		this.proveedor = proveedor;
	}

	@Override
	public boolean atributosLlenos() {
		return super.atributosLlenos();
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public TipoTransaccion getTipoTransaccion() {
		return TipoTransaccion.COMPRA;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}
}
