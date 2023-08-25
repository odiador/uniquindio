package model;

/**
 * Esta clase representa un puesto dentro del parqueadero
 * @author
 *
 */
public class Puesto
{

	//---------------------------------------------------------------------------
	//ATRIBUTOS
	//---------------------------------------------------------------------------
	private int tipo;
	private Vehiculo miVehiculo;
	private Posicion miP;
	/**
	 * Constructor de la clase Puesto
	 * @param tipo El tipo de vehiculo, tipo>=1&& tipo<=3
	 * @param miVehiculo El vehiculo que se ubica dentro del vehiculo
	 */
   /* public Puesto(int tipo)
    {
    	this.tipo=tipo;


    }*/
    public Puesto(int tipo, Posicion miP) {
		super();
		this.tipo = tipo;
		this.miP=miP;
	}
   public Posicion getMiP()
   {
	   return miP;
   }



	/**
     * Metodo accesor
     * @return El tipo del puesto en donde se ubica el vehiculo
     */

    public int getTipo() {
		return tipo;
	}

    public void setMiP(Posicion miP) {
		this.miP = miP;
	}
	/**
     * Metodo modificador para inicializar el tipo
     * @param tipo El tipo de vehiculo, tipo>=1&& tipo<=3
     */
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	/**
	 * Metodo accesor del vehiculo
	 * @return el vehiculo
	 */
	public Vehiculo getMiVehiculo() {
		return miVehiculo;
	}

	 /**
	  * Permite inicializar el vehiculo
	  * @param miVehiculo El vehiculo a ubicar en el puesto.
	  */
	public void setMiVehiculo(Vehiculo miVehiculo) {
		this.miVehiculo = miVehiculo;
	}
	/**
	 * Permite eliminar el vehiculo
	 */
	public void eliminarMiVehiculo() {
		this.miVehiculo = null;
	}
	public boolean isDisponible()
	{
		boolean centinela=false;
		if(miVehiculo==null)
		{
			centinela=true;
		}
		return centinela;
	}

}
