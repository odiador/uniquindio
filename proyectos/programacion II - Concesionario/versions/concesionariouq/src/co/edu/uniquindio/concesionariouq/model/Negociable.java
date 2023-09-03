package co.edu.uniquindio.concesionariouq.model;

import co.edu.uniquindio.concesionariouq.exceptions.VehiculoNoExisteException;
import co.edu.uniquindio.concesionariouq.exceptions.VehiculoYaExisteException;

public interface Negociable {
    
    public void agregarVehiculo(Vehiculo vehiculo) throws VehiculoYaExisteException, VehiculoNoExisteException;   
    public void eliminarVehiculo(Vehiculo vehiculo) throws VehiculoNoExisteException;   
}
