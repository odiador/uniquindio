package model;
/**
 * Esta clase representa un vehiculo
 * @author
 *
 */

public class Vehiculo
{
//---------------------------------------------------------------------------
//ATRIBUTOS
//---------------------------------------------------------------------------
private String  placa="";
private Propietario miPropietario;
private int tipo;
private int modelo;
/**
 * Constructor de la clase vehiculo
 * @param modelo El modelo del vehiculo, modelo > 1900
 * @param placa La placa del vehiculo, placa!=null
 * @param miPropietario El duenio del vehiculo, duenio!=null
 */
 public Vehiculo(int modelo, String placa, Propietario miPropietario, int tipo)
  {
	  this.modelo=modelo;
	  this.placa=placa;
	  this.miPropietario=miPropietario;
	  this.tipo=tipo;
  }

/**
 * Metodo accesor
 * @return El modelo
 */
public int getModelo() {
	return modelo;
}

/**
 * Metodo modificador
 * @param modelo El modelo del vehiculo, modelo > 1900
 */
public void setModelo(int modelo) {
	this.modelo = modelo;
}
/**
 * Metodo accesor
 * @return La placa del vehiculo
 */
public String getPlaca() {
	return placa;
}
/**
 * Metodo modificador
 * @param placa La placa del vehiculo, placa!=null
 */
public void setPlaca(String placa) {
	this.placa = placa;
}

/**
 * Metodo accesor
 * @return El due�o del vehiculo
 */

public Propietario getDuenio() {
	return miPropietario;
}
/**
 * @param duenio El duenio del vehiculo, duenio!=null
 */
public void setPropietario(Propietario duenio) {
	this.miPropietario = duenio;
}

public int getTipo() {
	return tipo;
}

public void setTipo(int tipo) {
	this.tipo = tipo;
}
 }
