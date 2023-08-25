package model;

public class Registro {
private Puesto miPuesto;
private Vehiculo miVehiculo;
public Registro(Puesto miPuesto, Vehiculo miVehiculo) {
	this.miPuesto = miPuesto;
	this.miVehiculo = miVehiculo;
}
public Puesto getMiPuesto() {
	return miPuesto;
}
public void setMiPuesto(Puesto miPuesto) {
	this.miPuesto = miPuesto;
}
public Vehiculo getMiVehiculo() {
	return miVehiculo;
}
public void setMiVehiculo(Vehiculo miVehiculo) {
	this.miVehiculo = miVehiculo;
}




}
