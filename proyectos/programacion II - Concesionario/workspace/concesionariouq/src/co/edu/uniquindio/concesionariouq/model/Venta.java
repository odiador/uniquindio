package co.edu.uniquindio.concesionariouq.model;

public class Venta extends Transaccion {

	private Proveedor proveedor;

	public Venta(Vehiculo vehiculo, Double valor, Proveedor proveedor) {
		super(vehiculo, valor);
		this.proveedor = proveedor;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public TipoTransaccion getTipoTransaccion() {
		return TipoTransaccion.VENTA;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}
}
