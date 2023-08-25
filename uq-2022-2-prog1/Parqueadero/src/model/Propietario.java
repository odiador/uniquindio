package model;

/**
 * Clase que representa un Propietario
 * @author
 *
 */
public class Propietario
{

    //---------------------------------------------------------------------------
	//ATRIBUTOS
	//---------------------------------------------------------------------------
	private String nombre;
	private String telefono;
	/**
	 * Constructor de propietario
	 * @param nombre El nombre del Propietario del vehiculo, nombre!=null
	 * @param telefono El telefono del propietario, telefono!=null
	 */
   public Propietario(String nombre, String telefono)
   {
	   this.nombre=nombre;
	   this.telefono=telefono;
   }


/**
 * Metodo accesor
 * @return El nombre del propietario
 */
public String getNombre() {
	return nombre;
}

/**
 * El nombre del propietario
 * @param nombre El nombre del Propietario del vehiculo, nombre!=null
 */
public void setNombre(String nombre) {
	this.nombre = nombre;
}

/**
 * Devuelve el telefono del propietario
 * @return El telefono
 */
public String getTelefono() {
	return telefono;
}
/**
 * Permite fijar el telefono del propietario
 * @param telefono El telefono del propietario, telefono!=null
 */
public void setTelefono(String telefono) {
	this.telefono = telefono;
}
   public String toString()
   {
	   return nombre + "  "+telefono;
   }

}
